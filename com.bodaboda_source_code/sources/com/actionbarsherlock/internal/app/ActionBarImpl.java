package com.actionbarsherlock.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.C0055R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.LayoutParams;
import com.actionbarsherlock.app.ActionBar.OnMenuVisibilityListener;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator.AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorListenerAdapter;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet.Builder;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuPopupHelper;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.ScrollingTabContainerView;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarImpl extends ActionBar {
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    ActionModeImpl mActionMode;
    private ActionBarView mActionView;
    private Activity mActivity;
    private ActionBarContainer mContainerView;
    private NineFrameLayout mContentView;
    private Context mContext;
    private int mContextDisplayMode;
    private ActionBarContextView mContextView;
    private Animator mCurrentModeAnim;
    private Animator mCurrentShowAnim;
    ActionMode mDeferredDestroyActionMode;
    Callback mDeferredModeDestroyCallback;
    final Handler mHandler = new Handler();
    private boolean mHasEmbeddedTabs;
    final AnimatorListener mHideListener = new C04111();
    private boolean mLastMenuVisibility;
    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
    private int mSavedTabPosition = -1;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final AnimatorListener mShowListener = new C04122();
    private ActionBarContainer mSplitView;
    private ScrollingTabContainerView mTabScrollView;
    Runnable mTabSelector;
    private ArrayList<TabImpl> mTabs = new ArrayList();
    private Context mThemedContext;
    boolean mWasHiddenBeforeMode;

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private Callback mCallback;
        private WeakReference<View> mCustomView;
        private MenuBuilder mMenu;

        public ActionModeImpl(Callback callback) {
            this.mCallback = callback;
            this.mMenu = new MenuBuilder(ActionBarImpl.this.getThemedContext()).setDefaultShowAsAction(1);
            this.mMenu.setCallback(this);
        }

        public MenuInflater getMenuInflater() {
            return new MenuInflater(ActionBarImpl.this.getThemedContext());
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public void finish() {
            if (ActionBarImpl.this.mActionMode == this) {
                if (ActionBarImpl.this.mWasHiddenBeforeMode) {
                    ActionBarImpl.this.mDeferredDestroyActionMode = this;
                    ActionBarImpl.this.mDeferredModeDestroyCallback = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                ActionBarImpl.this.animateToMode(false);
                ActionBarImpl.this.mContextView.closeMode();
                ActionBarImpl.this.mActionView.sendAccessibilityEvent(32);
                ActionBarImpl.this.mActionMode = null;
                if (ActionBarImpl.this.mWasHiddenBeforeMode) {
                    ActionBarImpl.this.hide();
                }
            }
        }

        public void invalidate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                boolean onCreateActionMode = this.mCallback.onCreateActionMode(this, this.mMenu);
                return onCreateActionMode;
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void setCustomView(View view) {
            ActionBarImpl.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference(view);
        }

        public void setSubtitle(CharSequence subtitle) {
            ActionBarImpl.this.mContextView.setSubtitle(subtitle);
        }

        public void setTitle(CharSequence title) {
            ActionBarImpl.this.mContextView.setTitle(title);
        }

        public void setTitle(int resId) {
            setTitle(ActionBarImpl.this.mContext.getResources().getString(resId));
        }

        public void setSubtitle(int resId) {
            setSubtitle(ActionBarImpl.this.mContext.getResources().getString(resId));
        }

        public CharSequence getTitle() {
            return ActionBarImpl.this.mContextView.getTitle();
        }

        public CharSequence getSubtitle() {
            return ActionBarImpl.this.mContextView.getSubtitle();
        }

        public View getCustomView() {
            return this.mCustomView != null ? (View) this.mCustomView.get() : null;
        }

        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            if (this.mCallback != null) {
                return this.mCallback.onActionItemClicked(this, item);
            }
            return false;
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            if (this.mCallback == null) {
                return false;
            }
            if (!subMenu.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(ActionBarImpl.this.getThemedContext(), subMenu).show();
            return true;
        }

        public void onCloseSubMenu(SubMenuBuilder menu) {
        }

        public void onMenuModeChange(MenuBuilder menu) {
            if (this.mCallback != null) {
                invalidate();
                ActionBarImpl.this.mContextView.showOverflowMenu();
            }
        }
    }

    public class TabImpl extends Tab {
        private TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;

        public Object getTag() {
            return this.mTag;
        }

        public Tab setTag(Object tag) {
            this.mTag = tag;
            return this;
        }

        public TabListener getCallback() {
            return this.mCallback;
        }

        public Tab setTabListener(TabListener callback) {
            this.mCallback = callback;
            return this;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Tab setCustomView(View view) {
            this.mCustomView = view;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setCustomView(int layoutResId) {
            return setCustomView(LayoutInflater.from(ActionBarImpl.this.getThemedContext()).inflate(layoutResId, null));
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public void setPosition(int position) {
            this.mPosition = position;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public Tab setIcon(Drawable icon) {
            this.mIcon = icon;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setIcon(int resId) {
            return setIcon(ActionBarImpl.this.mContext.getResources().getDrawable(resId));
        }

        public Tab setText(CharSequence text) {
            this.mText = text;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setText(int resId) {
            return setText(ActionBarImpl.this.mContext.getResources().getText(resId));
        }

        public void select() {
            ActionBarImpl.this.selectTab(this);
        }

        public Tab setContentDescription(int resId) {
            return setContentDescription(ActionBarImpl.this.mContext.getResources().getText(resId));
        }

        public Tab setContentDescription(CharSequence contentDesc) {
            this.mContentDesc = contentDesc;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }
    }

    /* renamed from: com.actionbarsherlock.internal.app.ActionBarImpl$1 */
    class C04111 extends AnimatorListenerAdapter {
        C04111() {
        }

        public void onAnimationEnd(Animator animation) {
            if (ActionBarImpl.this.mContentView != null) {
                ActionBarImpl.this.mContentView.setTranslationY(0.0f);
                ActionBarImpl.this.mContainerView.setTranslationY(0.0f);
            }
            if (ActionBarImpl.this.mSplitView != null && ActionBarImpl.this.mContextDisplayMode == 1) {
                ActionBarImpl.this.mSplitView.setVisibility(8);
            }
            ActionBarImpl.this.mContainerView.setVisibility(8);
            ActionBarImpl.this.mContainerView.setTransitioning(false);
            ActionBarImpl.this.mCurrentShowAnim = null;
            ActionBarImpl.this.completeDeferredDestroyActionMode();
        }
    }

    /* renamed from: com.actionbarsherlock.internal.app.ActionBarImpl$2 */
    class C04122 extends AnimatorListenerAdapter {
        C04122() {
        }

        public void onAnimationEnd(Animator animation) {
            ActionBarImpl.this.mCurrentShowAnim = null;
            ActionBarImpl.this.mContainerView.requestLayout();
        }
    }

    public ActionBarImpl(Activity activity, int features) {
        this.mActivity = activity;
        View decor = activity.getWindow().getDecorView();
        init(decor);
        if ((features & 512) == 0) {
            this.mContentView = (NineFrameLayout) decor.findViewById(16908290);
        }
    }

    public ActionBarImpl(Dialog dialog) {
        init(dialog.getWindow().getDecorView());
    }

    private void init(View decor) {
        int i = 1;
        this.mContext = decor.getContext();
        this.mActionView = (ActionBarView) decor.findViewById(C0055R.id.abs__action_bar);
        this.mContextView = (ActionBarContextView) decor.findViewById(C0055R.id.abs__action_context_bar);
        this.mContainerView = (ActionBarContainer) decor.findViewById(C0055R.id.abs__action_bar_container);
        this.mSplitView = (ActionBarContainer) decor.findViewById(C0055R.id.abs__split_action_bar);
        if (this.mActionView == null || this.mContextView == null || this.mContainerView == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(getClass().getSimpleName())).append(" can only be used ").append("with a compatible window decor layout").toString());
        }
        int i2;
        boolean homeButtonEnabled;
        this.mActionView.setContextView(this.mContextView);
        if (this.mActionView.isSplitActionBar()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.mContextDisplayMode = i2;
        if (this.mContext.getApplicationInfo().targetSdkVersion < 14) {
            homeButtonEnabled = true;
        } else {
            homeButtonEnabled = false;
        }
        if ((this.mActionView.getDisplayOptions() & 4) == 0) {
            i = 0;
        }
        setHomeButtonEnabled(homeButtonEnabled | i);
        setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, C0055R.bool.abs__action_bar_embed_tabs));
    }

    public void onConfigurationChanged(Configuration newConfig) {
        setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, C0055R.bool.abs__action_bar_embed_tabs));
        if (VERSION.SDK_INT < 8) {
            this.mActionView.onConfigurationChanged(newConfig);
            if (this.mContextView != null) {
                this.mContextView.onConfigurationChanged(newConfig);
            }
        }
    }

    private void setHasEmbeddedTabs(boolean hasEmbeddedTabs) {
        boolean isInTabMode;
        boolean z = true;
        this.mHasEmbeddedTabs = hasEmbeddedTabs;
        if (this.mHasEmbeddedTabs) {
            this.mContainerView.setTabContainer(null);
            this.mActionView.setEmbeddedTabView(this.mTabScrollView);
        } else {
            this.mActionView.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        }
        if (getNavigationMode() == 2) {
            isInTabMode = true;
        } else {
            isInTabMode = false;
        }
        if (this.mTabScrollView != null) {
            this.mTabScrollView.setVisibility(isInTabMode ? 0 : 8);
        }
        ActionBarView actionBarView = this.mActionView;
        if (this.mHasEmbeddedTabs || !isInTabMode) {
            z = false;
        }
        actionBarView.setCollapsable(z);
    }

    private void ensureTabsExist() {
        int i = 0;
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView tabScroller = new ScrollingTabContainerView(this.mContext);
            if (this.mHasEmbeddedTabs) {
                tabScroller.setVisibility(0);
                this.mActionView.setEmbeddedTabView(tabScroller);
            } else {
                if (getNavigationMode() != 2) {
                    i = 8;
                }
                tabScroller.setVisibility(i);
                this.mContainerView.setTabContainer(tabScroller);
            }
            this.mTabScrollView = tabScroller;
        }
    }

    void completeDeferredDestroyActionMode() {
        if (this.mDeferredModeDestroyCallback != null) {
            this.mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    public void setShowHideAnimationEnabled(boolean enabled) {
        this.mShowHideAnimationEnabled = enabled;
        if (!enabled && this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.add(listener);
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.remove(listener);
    }

    public void dispatchMenuVisibilityChanged(boolean isVisible) {
        if (isVisible != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = isVisible;
            int count = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < count; i++) {
                ((OnMenuVisibilityListener) this.mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(isVisible);
            }
        }
    }

    public void setCustomView(int resId) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, this.mActionView, false));
    }

    public void setDisplayUseLogoEnabled(boolean useLogo) {
        setDisplayOptions(useLogo ? 1 : 0, 1);
    }

    public void setDisplayShowHomeEnabled(boolean showHome) {
        setDisplayOptions(showHome ? 2 : 0, 2);
    }

    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        setDisplayOptions(showHomeAsUp ? 4 : 0, 4);
    }

    public void setDisplayShowTitleEnabled(boolean showTitle) {
        setDisplayOptions(showTitle ? 8 : 0, 8);
    }

    public void setDisplayShowCustomEnabled(boolean showCustom) {
        setDisplayOptions(showCustom ? 16 : 0, 16);
    }

    public void setHomeButtonEnabled(boolean enable) {
        this.mActionView.setHomeButtonEnabled(enable);
    }

    public void setTitle(int resId) {
        setTitle(this.mContext.getString(resId));
    }

    public void setSubtitle(int resId) {
        setSubtitle(this.mContext.getString(resId));
    }

    public void setSelectedNavigationItem(int position) {
        switch (this.mActionView.getNavigationMode()) {
            case 1:
                this.mActionView.setDropdownSelectedPosition(position);
                return;
            case 2:
                selectTab((Tab) this.mTabs.get(position));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationItem not valid for current navigation mode");
        }
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        if (this.mTabScrollView != null) {
            this.mTabScrollView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    public void setTitle(CharSequence title) {
        this.mActionView.setTitle(title);
    }

    public void setSubtitle(CharSequence subtitle) {
        this.mActionView.setSubtitle(subtitle);
    }

    public void setDisplayOptions(int options) {
        this.mActionView.setDisplayOptions(options);
    }

    public void setDisplayOptions(int options, int mask) {
        this.mActionView.setDisplayOptions((options & mask) | ((mask ^ -1) & this.mActionView.getDisplayOptions()));
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mContainerView.setPrimaryBackground(d);
    }

    public void setStackedBackgroundDrawable(Drawable d) {
        this.mContainerView.setStackedBackground(d);
    }

    public void setSplitBackgroundDrawable(Drawable d) {
        if (this.mSplitView != null) {
            this.mSplitView.setSplitBackground(d);
        }
    }

    public View getCustomView() {
        return this.mActionView.getCustomNavigationView();
    }

    public CharSequence getTitle() {
        return this.mActionView.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.mActionView.getSubtitle();
    }

    public int getNavigationMode() {
        return this.mActionView.getNavigationMode();
    }

    public int getDisplayOptions() {
        return this.mActionView.getDisplayOptions();
    }

    public ActionMode startActionMode(Callback callback) {
        boolean wasHidden = false;
        if (this.mActionMode != null) {
            wasHidden = this.mWasHiddenBeforeMode;
            this.mActionMode.finish();
        }
        this.mContextView.killMode();
        ActionModeImpl mode = new ActionModeImpl(callback);
        if (!mode.dispatchOnCreate()) {
            return null;
        }
        boolean z;
        if (!isShowing() || wasHidden) {
            z = true;
        } else {
            z = false;
        }
        this.mWasHiddenBeforeMode = z;
        mode.invalidate();
        this.mContextView.initForMode(mode);
        animateToMode(true);
        if (this.mSplitView != null && this.mContextDisplayMode == 1) {
            this.mSplitView.setVisibility(0);
        }
        this.mContextView.sendAccessibilityEvent(32);
        this.mActionMode = mode;
        return mode;
    }

    private void configureTab(Tab tab, int position) {
        TabImpl tabi = (TabImpl) tab;
        if (tabi.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabi.setPosition(position);
        this.mTabs.add(position, tabi);
        int count = this.mTabs.size();
        for (int i = position + 1; i < count; i++) {
            ((TabImpl) this.mTabs.get(i)).setPosition(i);
        }
    }

    public void addTab(Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, int position) {
        addTab(tab, position, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, boolean setSelected) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, setSelected);
        configureTab(tab, this.mTabs.size());
        if (setSelected) {
            selectTab(tab);
        }
    }

    public void addTab(Tab tab, int position, boolean setSelected) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, position, setSelected);
        configureTab(tab, position);
        if (setSelected) {
            selectTab(tab);
        }
    }

    public Tab newTab() {
        return new TabImpl();
    }

    public void removeTab(Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int position) {
        if (this.mTabScrollView != null) {
            int selectedTabPosition = this.mSelectedTab != null ? this.mSelectedTab.getPosition() : this.mSavedTabPosition;
            this.mTabScrollView.removeTabAt(position);
            TabImpl removedTab = (TabImpl) this.mTabs.remove(position);
            if (removedTab != null) {
                removedTab.setPosition(-1);
            }
            int newTabCount = this.mTabs.size();
            for (int i = position; i < newTabCount; i++) {
                ((TabImpl) this.mTabs.get(i)).setPosition(i);
            }
            if (selectedTabPosition == position) {
                Tab tab;
                if (this.mTabs.isEmpty()) {
                    tab = null;
                } else {
                    TabImpl tabImpl = (TabImpl) this.mTabs.get(Math.max(0, position - 1));
                }
                selectTab(tab);
            }
        }
    }

    public void selectTab(Tab tab) {
        int i = -1;
        if (getNavigationMode() != 2) {
            this.mSavedTabPosition = tab != null ? tab.getPosition() : -1;
            return;
        }
        FragmentTransaction trans = null;
        if (this.mActivity instanceof FragmentActivity) {
            trans = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        if (this.mSelectedTab != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, trans);
            }
            this.mSelectedTab = (TabImpl) tab;
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, trans);
            }
        } else if (this.mSelectedTab != null) {
            this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, trans);
            this.mTabScrollView.animateToTab(tab.getPosition());
        }
        if (trans != null && !trans.isEmpty()) {
            trans.commit();
        }
    }

    public Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public void show() {
        show(true);
    }

    void show(boolean markHiddenBeforeMode) {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() != 0) {
            this.mContainerView.setVisibility(0);
            if (this.mShowHideAnimationEnabled) {
                this.mContainerView.setAlpha(0.0f);
                AnimatorSet anim = new AnimatorSet();
                Builder b = anim.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", 1.0f));
                if (this.mContentView != null) {
                    b.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", (float) (-this.mContainerView.getHeight()), 0.0f));
                    this.mContainerView.setTranslationY((float) (-this.mContainerView.getHeight()));
                    b.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", 0.0f));
                }
                if (this.mSplitView != null && this.mContextDisplayMode == 1) {
                    this.mSplitView.setAlpha(0.0f);
                    this.mSplitView.setVisibility(0);
                    b.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", 1.0f));
                }
                anim.addListener(this.mShowListener);
                this.mCurrentShowAnim = anim;
                anim.start();
                return;
            }
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTranslationY(0.0f);
            this.mShowListener.onAnimationEnd(null);
        } else if (markHiddenBeforeMode) {
            this.mWasHiddenBeforeMode = false;
        }
    }

    public void hide() {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() != 8) {
            if (this.mShowHideAnimationEnabled) {
                this.mContainerView.setAlpha(1.0f);
                this.mContainerView.setTransitioning(true);
                AnimatorSet anim = new AnimatorSet();
                Builder b = anim.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", 0.0f));
                if (this.mContentView != null) {
                    b.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", 0.0f, (float) (-this.mContainerView.getHeight())));
                    b.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", (float) (-this.mContainerView.getHeight())));
                }
                if (this.mSplitView != null && this.mSplitView.getVisibility() == 0) {
                    this.mSplitView.setAlpha(1.0f);
                    b.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", 0.0f));
                }
                anim.addListener(this.mHideListener);
                this.mCurrentShowAnim = anim;
                anim.start();
                return;
            }
            this.mHideListener.onAnimationEnd(null);
        }
    }

    public boolean isShowing() {
        return this.mContainerView.getVisibility() == 0;
    }

    void animateToMode(boolean toActionMode) {
        int i;
        int i2 = 8;
        if (toActionMode) {
            show(false);
        }
        if (this.mCurrentModeAnim != null) {
            this.mCurrentModeAnim.end();
        }
        this.mActionView.animateToVisibility(toActionMode ? 8 : 0);
        ActionBarContextView actionBarContextView = this.mContextView;
        if (toActionMode) {
            i = 0;
        } else {
            i = 8;
        }
        actionBarContextView.animateToVisibility(i);
        if (this.mTabScrollView != null && !this.mActionView.hasEmbeddedTabs() && this.mActionView.isCollapsed()) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (!toActionMode) {
                i2 = 0;
            }
            scrollingTabContainerView.animateToVisibility(i2);
        }
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue outValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0055R.attr.actionBarWidgetTheme, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, targetThemeRes);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public void setCustomView(View view) {
        this.mActionView.setCustomNavigationView(view);
    }

    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mActionView.setCustomNavigationView(view);
    }

    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        this.mActionView.setDropdownAdapter(adapter);
        this.mActionView.setCallback(callback);
    }

    public int getSelectedNavigationIndex() {
        switch (this.mActionView.getNavigationMode()) {
            case 1:
                return this.mActionView.getDropdownSelectedPosition();
            case 2:
                if (this.mSelectedTab != null) {
                    return this.mSelectedTab.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    public int getNavigationItemCount() {
        switch (this.mActionView.getNavigationMode()) {
            case 1:
                SpinnerAdapter adapter = this.mActionView.getDropdownAdapter();
                return adapter != null ? adapter.getCount() : 0;
            case 2:
                return this.mTabs.size();
            default:
                return 0;
        }
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public void setNavigationMode(int mode) {
        boolean z = false;
        switch (this.mActionView.getNavigationMode()) {
            case 2:
                this.mSavedTabPosition = getSelectedNavigationIndex();
                selectTab(null);
                this.mTabScrollView.setVisibility(8);
                break;
        }
        this.mActionView.setNavigationMode(mode);
        switch (mode) {
            case 2:
                ensureTabsExist();
                this.mTabScrollView.setVisibility(0);
                if (this.mSavedTabPosition != -1) {
                    setSelectedNavigationItem(this.mSavedTabPosition);
                    this.mSavedTabPosition = -1;
                    break;
                }
                break;
        }
        ActionBarView actionBarView = this.mActionView;
        if (mode == 2 && !this.mHasEmbeddedTabs) {
            z = true;
        }
        actionBarView.setCollapsable(z);
    }

    public Tab getTabAt(int index) {
        return (Tab) this.mTabs.get(index);
    }

    public void setIcon(int resId) {
        this.mActionView.setIcon(resId);
    }

    public void setIcon(Drawable icon) {
        this.mActionView.setIcon(icon);
    }

    public void setLogo(int resId) {
        this.mActionView.setLogo(resId);
    }

    public void setLogo(Drawable logo) {
        this.mActionView.setLogo(logo);
    }
}
