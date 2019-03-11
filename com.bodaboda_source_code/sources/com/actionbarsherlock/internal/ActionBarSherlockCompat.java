package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock.Implementation;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeFinishedListener;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener;
import com.actionbarsherlock.C0055R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarImpl;
import com.actionbarsherlock.internal.view.StandaloneActionMode;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuBuilder.Callback;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.view.menu.MenuPresenter;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.IcsProgressBar;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Implementation(api = 7)
public class ActionBarSherlockCompat extends ActionBarSherlock implements Callback, Window.Callback, MenuPresenter.Callback, OnMenuItemClickListener {
    protected static final int DEFAULT_FEATURES = 0;
    private static final String PANELS_TAG = "sherlock:Panels";
    private ActionBarImpl aActionBar;
    private ActionMode mActionMode;
    private ActionBarContextView mActionModeView;
    private IcsProgressBar mCircularProgressBar;
    private boolean mClosingActionMenu;
    private ViewGroup mContentParent;
    private ViewGroup mDecor;
    private int mFeatures = 0;
    private IcsProgressBar mHorizontalProgressBar;
    private boolean mIsDestroyed = false;
    private boolean mIsTitleReady = false;
    private MenuBuilder mMenu;
    private Bundle mMenuFrozenActionViewState;
    private boolean mMenuIsPrepared;
    private boolean mMenuRefreshContent;
    protected HashMap<MenuItem, MenuItemImpl> mNativeItemMap;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet = false;
    private int mUiOptions = 0;
    private ActionBarView wActionBar;

    /* renamed from: com.actionbarsherlock.internal.ActionBarSherlockCompat$1 */
    class C00561 implements Runnable {
        C00561() {
        }

        public void run() {
            if (!ActionBarSherlockCompat.this.mIsDestroyed && !ActionBarSherlockCompat.this.mActivity.isFinishing() && ActionBarSherlockCompat.this.mMenu == null) {
                ActionBarSherlockCompat.this.dispatchInvalidateOptionsMenu();
            }
        }
    }

    private class ActionModeCallbackWrapper implements ActionMode.Callback {
        private final ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapper(ActionMode.Callback wrapped) {
            this.mWrapped = wrapped;
        }

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return this.mWrapped.onCreateActionMode(mode, menu);
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(mode, menu);
        }

        public boolean onActionItemClicked(ActionMode mode, com.actionbarsherlock.view.MenuItem item) {
            return this.mWrapped.onActionItemClicked(mode, item);
        }

        public void onDestroyActionMode(ActionMode mode) {
            this.mWrapped.onDestroyActionMode(mode);
            if (ActionBarSherlockCompat.this.mActionModeView != null) {
                ActionBarSherlockCompat.this.mActionModeView.setVisibility(8);
                ActionBarSherlockCompat.this.mActionModeView.removeAllViews();
            }
            if (ActionBarSherlockCompat.this.mActivity instanceof OnActionModeFinishedListener) {
                ((OnActionModeFinishedListener) ActionBarSherlockCompat.this.mActivity).onActionModeFinished(ActionBarSherlockCompat.this.mActionMode);
            }
            ActionBarSherlockCompat.this.mActionMode = null;
        }
    }

    public ActionBarSherlockCompat(Activity activity, int flags) {
        super(activity, flags);
    }

    public ActionBar getActionBar() {
        initActionBar();
        return this.aActionBar;
    }

    private void initActionBar() {
        if (this.mDecor == null) {
            installDecor();
        }
        if (this.aActionBar == null && hasFeature(8) && !hasFeature(1) && !this.mActivity.isChild()) {
            this.aActionBar = new ActionBarImpl(this.mActivity, this.mFeatures);
            if (!this.mIsDelegate) {
                this.wActionBar.setWindowTitle(this.mActivity.getTitle());
            }
        }
    }

    protected Context getThemedContext() {
        return this.aActionBar.getThemedContext();
    }

    public void setTitle(CharSequence title) {
        dispatchTitleChanged(title, 0);
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionMode.Callback wrappedCallback = new ActionModeCallbackWrapper(callback);
        ActionMode mode = null;
        initActionBar();
        if (this.aActionBar != null) {
            mode = this.aActionBar.startActionMode(wrappedCallback);
        }
        if (mode != null) {
            this.mActionMode = mode;
        } else {
            if (this.mActionModeView == null) {
                ViewStub stub = (ViewStub) this.mDecor.findViewById(C0055R.id.abs__action_mode_bar_stub);
                if (stub != null) {
                    this.mActionModeView = (ActionBarContextView) stub.inflate();
                }
            }
            if (this.mActionModeView != null) {
                this.mActionModeView.killMode();
                mode = new StandaloneActionMode(this.mActivity, this.mActionModeView, wrappedCallback, true);
                if (callback.onCreateActionMode(mode, mode.getMenu())) {
                    mode.invalidate();
                    this.mActionModeView.initForMode(mode);
                    this.mActionModeView.setVisibility(0);
                    this.mActionMode = mode;
                    this.mActionModeView.sendAccessibilityEvent(32);
                } else {
                    this.mActionMode = null;
                }
            }
        }
        if (this.mActionMode != null && (this.mActivity instanceof OnActionModeStartedListener)) {
            ((OnActionModeStartedListener) this.mActivity).onActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }

    public void dispatchConfigurationChanged(Configuration newConfig) {
        if (this.aActionBar != null) {
            this.aActionBar.onConfigurationChanged(newConfig);
        }
    }

    public void dispatchPostResume() {
        if (this.aActionBar != null) {
            this.aActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void dispatchPause() {
        if (this.wActionBar != null && this.wActionBar.isOverflowMenuShowing()) {
            this.wActionBar.hideOverflowMenu();
        }
    }

    public void dispatchStop() {
        if (this.aActionBar != null) {
            this.aActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void dispatchInvalidateOptionsMenu() {
        if (this.mMenu != null) {
            Bundle savedActionViewStates = new Bundle();
            this.mMenu.saveActionViewStates(savedActionViewStates);
            if (savedActionViewStates.size() > 0) {
                this.mMenuFrozenActionViewState = savedActionViewStates;
            }
            this.mMenu.stopDispatchingItemsChanged();
            this.mMenu.clear();
        }
        this.mMenuRefreshContent = true;
        if (this.wActionBar != null) {
            this.mMenuIsPrepared = false;
            preparePanel();
        }
    }

    public boolean dispatchOpenOptionsMenu() {
        if (isReservingOverflow()) {
            return this.wActionBar.showOverflowMenu();
        }
        return false;
    }

    public boolean dispatchCloseOptionsMenu() {
        if (isReservingOverflow() && this.wActionBar != null) {
            return this.wActionBar.hideOverflowMenu();
        }
        return false;
    }

    public void dispatchPostCreate(Bundle savedInstanceState) {
        if (this.mIsDelegate) {
            this.mIsTitleReady = true;
        }
        if (this.mDecor == null) {
            initActionBar();
        }
    }

    public boolean dispatchCreateOptionsMenu(android.view.Menu menu) {
        Log.d("ActionBarSherlock", "[dispatchCreateOptionsMenu] android.view.Menu: " + menu);
        Log.d("ActionBarSherlock", "[dispatchCreateOptionsMenu] returning true");
        return true;
    }

    public boolean dispatchPrepareOptionsMenu(android.view.Menu menu) {
        if (this.mActionMode != null) {
            return false;
        }
        this.mMenuIsPrepared = false;
        if (!preparePanel() || isReservingOverflow()) {
            return false;
        }
        if (this.mNativeItemMap == null) {
            this.mNativeItemMap = new HashMap();
        } else {
            this.mNativeItemMap.clear();
        }
        if (this.mMenu != null) {
            return this.mMenu.bindNativeOverflow(menu, this, this.mNativeItemMap);
        }
        return false;
    }

    public boolean dispatchOptionsItemSelected(MenuItem item) {
        throw new IllegalStateException("Native callback invoked. Create a test case and report!");
    }

    public boolean dispatchMenuOpened(int featureId, android.view.Menu menu) {
        if (featureId != 8 && featureId != 0) {
            return false;
        }
        if (this.aActionBar == null) {
            return true;
        }
        this.aActionBar.dispatchMenuVisibilityChanged(true);
        return true;
    }

    public void dispatchPanelClosed(int featureId, android.view.Menu menu) {
        if ((featureId == 8 || featureId == 0) && this.aActionBar != null) {
            this.aActionBar.dispatchMenuVisibilityChanged(false);
        }
    }

    public void dispatchTitleChanged(CharSequence title, int color) {
        if ((!this.mIsDelegate || this.mIsTitleReady) && this.wActionBar != null) {
            this.wActionBar.setWindowTitle(title);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == 4) {
            int action = event.getAction();
            if (this.mActionMode != null) {
                if (action != 1) {
                    return true;
                }
                this.mActionMode.finish();
                return true;
            } else if (this.wActionBar != null && this.wActionBar.hasExpandedActionView()) {
                if (action != 1) {
                    return true;
                }
                this.wActionBar.collapseActionView();
                return true;
            }
        }
        return false;
    }

    public void dispatchDestroy() {
        this.mIsDestroyed = true;
    }

    public void dispatchSaveInstanceState(Bundle outState) {
        if (this.mMenu != null) {
            this.mMenuFrozenActionViewState = new Bundle();
            this.mMenu.saveActionViewStates(this.mMenuFrozenActionViewState);
        }
        outState.putParcelable(PANELS_TAG, this.mMenuFrozenActionViewState);
    }

    public void dispatchRestoreInstanceState(Bundle savedInstanceState) {
        this.mMenuFrozenActionViewState = (Bundle) savedInstanceState.getParcelable(PANELS_TAG);
    }

    private boolean preparePanel() {
        boolean z = false;
        if (this.mMenuIsPrepared) {
            return true;
        }
        if (this.mMenu == null || this.mMenuRefreshContent) {
            if (this.mMenu == null && (!initializePanelMenu() || this.mMenu == null)) {
                return false;
            }
            if (this.wActionBar != null) {
                this.wActionBar.setMenu(this.mMenu, this);
            }
            this.mMenu.stopDispatchingItemsChanged();
            if (callbackCreateOptionsMenu(this.mMenu)) {
                this.mMenuRefreshContent = false;
            } else {
                this.mMenu = null;
                if (this.wActionBar == null) {
                    return false;
                }
                this.wActionBar.setMenu(null, this);
                return false;
            }
        }
        this.mMenu.stopDispatchingItemsChanged();
        if (this.mMenuFrozenActionViewState != null) {
            this.mMenu.restoreActionViewStates(this.mMenuFrozenActionViewState);
            this.mMenuFrozenActionViewState = null;
        }
        if (callbackPrepareOptionsMenu(this.mMenu)) {
            KeyCharacterMap kmap = KeyCharacterMap.load(-1);
            MenuBuilder menuBuilder = this.mMenu;
            if (kmap.getKeyboardType() != 1) {
                z = true;
            }
            menuBuilder.setQwertyMode(z);
            this.mMenu.startDispatchingItemsChanged();
            this.mMenuIsPrepared = true;
            return true;
        }
        if (this.wActionBar != null) {
            this.wActionBar.setMenu(null, this);
        }
        this.mMenu.startDispatchingItemsChanged();
        return false;
    }

    public boolean onMenuItemSelected(MenuBuilder menu, com.actionbarsherlock.view.MenuItem item) {
        return callbackOptionsItemSelected(item);
    }

    public void onMenuModeChange(MenuBuilder menu) {
        reopenMenu(true);
    }

    private void reopenMenu(boolean toggleMenuMode) {
        if (this.wActionBar != null && this.wActionBar.isOverflowReserved()) {
            if (this.wActionBar.isOverflowMenuShowing() && toggleMenuMode) {
                this.wActionBar.hideOverflowMenu();
            } else if (this.wActionBar.getVisibility() == 0 && callbackPrepareOptionsMenu(this.mMenu)) {
                this.wActionBar.showOverflowMenu();
            }
        }
    }

    private boolean initializePanelMenu() {
        Context context = this.mActivity;
        if (this.wActionBar != null) {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(C0055R.attr.actionBarWidgetTheme, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                context = new ContextThemeWrapper(context, targetThemeRes);
            }
        }
        this.mMenu = new MenuBuilder(context);
        this.mMenu.setCallback(this);
        return true;
    }

    void checkCloseActionMenu(Menu menu) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.wActionBar.dismissPopupMenus();
            this.mClosingActionMenu = false;
        }
    }

    public boolean onOpenSubMenu(MenuBuilder subMenu) {
        return true;
    }

    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        checkCloseActionMenu(menu);
    }

    public boolean onMenuItemClick(MenuItem item) {
        MenuItemImpl sherlockItem = (MenuItemImpl) this.mNativeItemMap.get(item);
        if (sherlockItem != null) {
            sherlockItem.invoke();
        } else {
            Log.e("ActionBarSherlock", "Options item \"" + item + "\" not found in mapping");
        }
        return true;
    }

    public boolean onMenuItemSelected(int featureId, com.actionbarsherlock.view.MenuItem item) {
        return callbackOptionsItemSelected(item);
    }

    public void setProgressBarVisibility(boolean visible) {
        int i;
        if (visible) {
            i = -1;
        } else {
            i = -2;
        }
        setFeatureInt(2, i);
    }

    public void setProgressBarIndeterminateVisibility(boolean visible) {
        setFeatureInt(5, visible ? -1 : -2);
    }

    public void setProgressBarIndeterminate(boolean indeterminate) {
        setFeatureInt(2, indeterminate ? -3 : -4);
    }

    public void setProgress(int progress) {
        setFeatureInt(2, progress + 0);
    }

    public void setSecondaryProgress(int secondaryProgress) {
        setFeatureInt(2, secondaryProgress + 20000);
    }

    private void setFeatureInt(int featureId, int value) {
        updateInt(featureId, value, false);
    }

    private void updateInt(int featureId, int value, boolean fromResume) {
        if (this.mContentParent != null) {
            if ((getFeatures() & (1 << featureId)) != 0 || fromResume) {
                onIntChanged(featureId, value);
            }
        }
    }

    private void onIntChanged(int featureId, int value) {
        if (featureId == 2 || featureId == 5) {
            updateProgressBars(value);
        }
    }

    private void updateProgressBars(int value) {
        IcsProgressBar circularProgressBar = getCircularProgressBar(true);
        IcsProgressBar horizontalProgressBar = getHorizontalProgressBar(true);
        int features = this.mFeatures;
        if (value == -1) {
            if ((features & 4) != 0) {
                int visibility;
                int level = horizontalProgressBar.getProgress();
                if (horizontalProgressBar.isIndeterminate() || level < 10000) {
                    visibility = 0;
                } else {
                    visibility = 4;
                }
                horizontalProgressBar.setVisibility(visibility);
            }
            if ((features & 32) != 0) {
                circularProgressBar.setVisibility(0);
            }
        } else if (value == -2) {
            if ((features & 4) != 0) {
                horizontalProgressBar.setVisibility(8);
            }
            if ((features & 32) != 0) {
                circularProgressBar.setVisibility(8);
            }
        } else if (value == -3) {
            horizontalProgressBar.setIndeterminate(true);
        } else if (value == -4) {
            horizontalProgressBar.setIndeterminate(false);
        } else if (value >= 0 && value <= 10000) {
            horizontalProgressBar.setProgress(value + 0);
            if (value < 10000) {
                showProgressBars(horizontalProgressBar, circularProgressBar);
            } else {
                hideProgressBars(horizontalProgressBar, circularProgressBar);
            }
        } else if (20000 <= value && value <= 30000) {
            horizontalProgressBar.setSecondaryProgress(value - 20000);
            showProgressBars(horizontalProgressBar, circularProgressBar);
        }
    }

    private void showProgressBars(IcsProgressBar horizontalProgressBar, IcsProgressBar spinnyProgressBar) {
        int features = this.mFeatures;
        if ((features & 32) != 0 && spinnyProgressBar.getVisibility() == 4) {
            spinnyProgressBar.setVisibility(0);
        }
        if ((features & 4) != 0 && horizontalProgressBar.getProgress() < 10000) {
            horizontalProgressBar.setVisibility(0);
        }
    }

    private void hideProgressBars(IcsProgressBar horizontalProgressBar, IcsProgressBar spinnyProgressBar) {
        int features = this.mFeatures;
        Animation anim = AnimationUtils.loadAnimation(this.mActivity, 17432577);
        anim.setDuration(1000);
        if ((features & 32) != 0 && spinnyProgressBar.getVisibility() == 0) {
            spinnyProgressBar.startAnimation(anim);
            spinnyProgressBar.setVisibility(4);
        }
        if ((features & 4) != 0 && horizontalProgressBar.getVisibility() == 0) {
            horizontalProgressBar.startAnimation(anim);
            horizontalProgressBar.setVisibility(4);
        }
    }

    private IcsProgressBar getCircularProgressBar(boolean shouldInstallDecor) {
        if (this.mCircularProgressBar != null) {
            return this.mCircularProgressBar;
        }
        if (this.mContentParent == null && shouldInstallDecor) {
            installDecor();
        }
        this.mCircularProgressBar = (IcsProgressBar) this.mDecor.findViewById(C0055R.id.abs__progress_circular);
        if (this.mCircularProgressBar != null) {
            this.mCircularProgressBar.setVisibility(4);
        }
        return this.mCircularProgressBar;
    }

    private IcsProgressBar getHorizontalProgressBar(boolean shouldInstallDecor) {
        if (this.mHorizontalProgressBar != null) {
            return this.mHorizontalProgressBar;
        }
        if (this.mContentParent == null && shouldInstallDecor) {
            installDecor();
        }
        this.mHorizontalProgressBar = (IcsProgressBar) this.mDecor.findViewById(C0055R.id.abs__progress_horizontal);
        if (this.mHorizontalProgressBar != null) {
            this.mHorizontalProgressBar.setVisibility(4);
        }
        return this.mHorizontalProgressBar;
    }

    private int getFeatures() {
        return this.mFeatures;
    }

    public boolean hasFeature(int featureId) {
        return (this.mFeatures & (1 << featureId)) != 0;
    }

    public boolean requestFeature(int featureId) {
        if (this.mContentParent != null) {
            throw new AndroidRuntimeException("requestFeature() must be called before adding content");
        }
        switch (featureId) {
            case 1:
            case 2:
            case 5:
            case 8:
            case 9:
            case 10:
                this.mFeatures |= 1 << featureId;
                return true;
            default:
                return false;
        }
    }

    public void setUiOptions(int uiOptions) {
        this.mUiOptions = uiOptions;
    }

    public void setUiOptions(int uiOptions, int mask) {
        this.mUiOptions = (this.mUiOptions & (mask ^ -1)) | (uiOptions & mask);
    }

    public void setContentView(int layoutResId) {
        if (this.mContentParent == null) {
            installDecor();
        } else {
            this.mContentParent.removeAllViews();
        }
        this.mActivity.getLayoutInflater().inflate(layoutResId, this.mContentParent);
        android.view.Window.Callback callback = this.mActivity.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
        initActionBar();
    }

    public void setContentView(View view, LayoutParams params) {
        if (this.mContentParent == null) {
            installDecor();
        } else {
            this.mContentParent.removeAllViews();
        }
        this.mContentParent.addView(view, params);
        android.view.Window.Callback callback = this.mActivity.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
        initActionBar();
    }

    public void addContentView(View view, LayoutParams params) {
        if (this.mContentParent == null) {
            installDecor();
        }
        this.mContentParent.addView(view, params);
        initActionBar();
    }

    private void installDecor() {
        boolean splitWhenNarrow = true;
        if (this.mDecor == null) {
            this.mDecor = (ViewGroup) this.mActivity.getWindow().getDecorView().findViewById(16908290);
        }
        if (this.mContentParent == null) {
            View child;
            List<View> views = null;
            if (this.mDecor.getChildCount() > 0) {
                views = new ArrayList(1);
                int children = this.mDecor.getChildCount();
                for (int i = 0; i < children; i++) {
                    child = this.mDecor.getChildAt(0);
                    this.mDecor.removeView(child);
                    views.add(child);
                }
            }
            this.mContentParent = generateLayout();
            if (views != null) {
                for (View child2 : views) {
                    this.mContentParent.addView(child2);
                }
            }
            this.wActionBar = (ActionBarView) this.mDecor.findViewById(C0055R.id.abs__action_bar);
            if (this.wActionBar != null) {
                boolean splitActionBar;
                this.wActionBar.setWindowCallback(this);
                if (this.wActionBar.getTitle() == null) {
                    this.wActionBar.setWindowTitle(this.mActivity.getTitle());
                }
                if (hasFeature(2)) {
                    this.wActionBar.initProgress();
                }
                if (hasFeature(5)) {
                    this.wActionBar.initIndeterminateProgress();
                }
                int uiOptions = loadUiOptionsFromManifest(this.mActivity);
                if (uiOptions != 0) {
                    this.mUiOptions = uiOptions;
                }
                if ((this.mUiOptions & 1) == 0) {
                    splitWhenNarrow = false;
                }
                if (splitWhenNarrow) {
                    splitActionBar = ResourcesCompat.getResources_getBoolean(this.mActivity, C0055R.bool.abs__split_action_bar_is_narrow);
                } else {
                    splitActionBar = this.mActivity.getTheme().obtainStyledAttributes(C0055R.styleable.SherlockTheme).getBoolean(C0055R.styleable.SherlockTheme_windowSplitActionBar, false);
                }
                ActionBarContainer splitView = (ActionBarContainer) this.mDecor.findViewById(C0055R.id.abs__split_action_bar);
                if (splitView != null) {
                    this.wActionBar.setSplitView(splitView);
                    this.wActionBar.setSplitActionBar(splitActionBar);
                    this.wActionBar.setSplitWhenNarrow(splitWhenNarrow);
                    this.mActionModeView = (ActionBarContextView) this.mDecor.findViewById(C0055R.id.abs__action_context_bar);
                    this.mActionModeView.setSplitView(splitView);
                    this.mActionModeView.setSplitActionBar(splitActionBar);
                    this.mActionModeView.setSplitWhenNarrow(splitWhenNarrow);
                } else if (splitActionBar) {
                    Log.e("ActionBarSherlock", "Requested split action bar with incompatible window decor! Ignoring request.");
                }
                this.mDecor.post(new C00561());
            }
        }
    }

    private ViewGroup generateLayout() {
        TypedArray a = this.mActivity.getTheme().obtainStyledAttributes(C0055R.styleable.SherlockTheme);
        if (a.hasValue(C0055R.styleable.SherlockTheme_windowActionBar)) {
            int layoutResource;
            if (a.getBoolean(C0055R.styleable.SherlockTheme_windowNoTitle, false)) {
                requestFeature(1);
            } else if (a.getBoolean(C0055R.styleable.SherlockTheme_windowActionBar, false)) {
                requestFeature(8);
            }
            if (a.getBoolean(C0055R.styleable.SherlockTheme_windowActionBarOverlay, false)) {
                requestFeature(9);
            }
            if (a.getBoolean(C0055R.styleable.SherlockTheme_windowActionModeOverlay, false)) {
                requestFeature(10);
            }
            a.recycle();
            if (hasFeature(1)) {
                if (!hasFeature(10) || hasFeature(1)) {
                    layoutResource = C0055R.layout.abs__screen_simple;
                } else {
                    layoutResource = C0055R.layout.abs__screen_simple_overlay_action_mode;
                }
            } else if (hasFeature(9)) {
                layoutResource = C0055R.layout.abs__screen_action_bar_overlay;
            } else {
                layoutResource = C0055R.layout.abs__screen_action_bar;
            }
            this.mDecor.addView(this.mActivity.getLayoutInflater().inflate(layoutResource, null), new LayoutParams(-1, -1));
            ViewGroup contentParent = (ViewGroup) this.mDecor.findViewById(C0055R.id.abs__content);
            if (contentParent == null) {
                throw new RuntimeException("Couldn't find content container view");
            }
            this.mDecor.setId(-1);
            contentParent.setId(16908290);
            if (hasFeature(5)) {
                IcsProgressBar progress = getCircularProgressBar(false);
                if (progress != null) {
                    progress.setIndeterminate(true);
                }
            }
            return contentParent;
        }
        throw new IllegalStateException("You must use Theme.Sherlock, Theme.Sherlock.Light, Theme.Sherlock.Light.DarkActionBar, or a derivative.");
    }

    private boolean isReservingOverflow() {
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = ActionMenuPresenter.reserveOverflow(this.mActivity);
            this.mReserveOverflowSet = true;
        }
        return this.mReserveOverflow;
    }

    private static int loadUiOptionsFromManifest(Activity activity) {
        int uiOptions = 0;
        try {
            String thisPackage = activity.getClass().getName();
            String packageName = activity.getApplicationInfo().packageName;
            XmlResourceParser xml = activity.createPackageContext(packageName, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.nextToken()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    int i;
                    if ("application".equals(name)) {
                        for (i = xml.getAttributeCount() - 1; i >= 0; i--) {
                            if ("uiOptions".equals(xml.getAttributeName(i))) {
                                uiOptions = xml.getAttributeIntValue(i, 0);
                                break;
                            }
                        }
                    } else if ("activity".equals(name)) {
                        Integer activityUiOptions = null;
                        String activityPackage = null;
                        boolean isOurActivity = false;
                        for (i = xml.getAttributeCount() - 1; i >= 0; i--) {
                            String attrName = xml.getAttributeName(i);
                            if (!"uiOptions".equals(attrName)) {
                                if ("name".equals(attrName)) {
                                    activityPackage = cleanActivityName(packageName, xml.getAttributeValue(i));
                                    if (!thisPackage.equals(activityPackage)) {
                                        break;
                                    }
                                    isOurActivity = true;
                                }
                            } else {
                                activityUiOptions = Integer.valueOf(xml.getAttributeIntValue(i, 0));
                            }
                            if (!(activityUiOptions == null || activityPackage == null)) {
                                uiOptions = activityUiOptions.intValue();
                            }
                        }
                        if (isOurActivity) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uiOptions;
    }

    public static String cleanActivityName(String manifestPackage, String activityName) {
        if (activityName.charAt(0) == '.') {
            return new StringBuilder(String.valueOf(manifestPackage)).append(activityName).toString();
        }
        if (activityName.indexOf(46, 1) == -1) {
            return new StringBuilder(String.valueOf(manifestPackage)).append(".").append(activityName).toString();
        }
        return activityName;
    }

    public void ensureActionBar() {
        if (this.mDecor == null) {
            initActionBar();
        }
    }
}
