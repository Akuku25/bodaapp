package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.actionbarsherlock.C0055R;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import com.actionbarsherlock.internal.view.menu.ActionMenuView.ActionMenuChildView;
import com.actionbarsherlock.internal.view.menu.MenuBuilder.ItemInvoker;
import com.actionbarsherlock.internal.view.menu.MenuView.ItemView;
import com.actionbarsherlock.internal.widget.CapitalizingButton;
import com.actionbarsherlock.internal.widget.IcsToast;
import java.util.HashSet;
import java.util.Set;

public class ActionMenuItemView extends LinearLayout implements ItemView, OnClickListener, OnLongClickListener, ActionMenuChildView, View_HasStateListenerSupport {
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ImageButton mImageButton;
    private MenuItemImpl mItemData;
    private ItemInvoker mItemInvoker;
    private final Set<View_OnAttachStateChangeListener> mListeners;
    private int mMinWidth;
    private CapitalizingButton mTextButton;
    private CharSequence mTitle;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        this.mListeners = new HashSet();
        this.mAllowTextWithIcon = ResourcesCompat.getResources_getBoolean(context, C0055R.bool.abs__config_allowActionMenuItemTextWithIcon);
        TypedArray a = context.obtainStyledAttributes(attrs, C0055R.styleable.SherlockActionMenuItemView, 0, 0);
        this.mMinWidth = a.getDimensionPixelSize(C0055R.styleable.SherlockActionMenuItemView_android_minWidth, 0);
        a.recycle();
    }

    public void addOnAttachStateChangeListener(View_OnAttachStateChangeListener listener) {
        this.mListeners.add(listener);
    }

    public void removeOnAttachStateChangeListener(View_OnAttachStateChangeListener listener) {
        this.mListeners.remove(listener);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (View_OnAttachStateChangeListener listener : this.mListeners) {
            listener.onViewAttachedToWindow(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        for (View_OnAttachStateChangeListener listener : this.mListeners) {
            listener.onViewDetachedFromWindow(this);
        }
    }

    public void onFinishInflate() {
        this.mImageButton = (ImageButton) findViewById(C0055R.id.abs__imageButton);
        this.mTextButton = (CapitalizingButton) findViewById(C0055R.id.abs__textButton);
        this.mImageButton.setOnClickListener(this);
        this.mTextButton.setOnClickListener(this);
        this.mImageButton.setOnLongClickListener(this);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public void initialize(MenuItemImpl itemData, int menuType) {
        this.mItemData = itemData;
        setIcon(itemData.getIcon());
        setTitle(itemData.getTitleForItemView(this));
        setId(itemData.getItemId());
        setVisibility(itemData.isVisible() ? 0 : 8);
        setEnabled(itemData.isEnabled());
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.mImageButton.setEnabled(enabled);
        this.mTextButton.setEnabled(enabled);
    }

    public void onClick(View v) {
        if (this.mItemInvoker != null) {
            this.mItemInvoker.invokeItem(this.mItemData);
        }
    }

    public void setItemInvoker(ItemInvoker invoker) {
        this.mItemInvoker = invoker;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean checkable) {
    }

    public void setChecked(boolean checked) {
    }

    public void setExpandedFormat(boolean expandedFormat) {
        if (this.mExpandedFormat != expandedFormat) {
            this.mExpandedFormat = expandedFormat;
            if (this.mItemData != null) {
                this.mItemData.actionFormatChanged();
            }
        }
    }

    private void updateTextButtonVisibility() {
        boolean visible;
        int i = 1;
        int i2 = 0;
        if (TextUtils.isEmpty(this.mTextButton.getText())) {
            visible = false;
        } else {
            visible = true;
        }
        if (!(this.mImageButton.getDrawable() == null || (this.mItemData.showsTextAsAction() && (this.mAllowTextWithIcon || this.mExpandedFormat)))) {
            i = 0;
        }
        visible &= i;
        CapitalizingButton capitalizingButton = this.mTextButton;
        if (!visible) {
            i2 = 8;
        }
        capitalizingButton.setVisibility(i2);
    }

    public void setIcon(Drawable icon) {
        this.mImageButton.setImageDrawable(icon);
        if (icon != null) {
            this.mImageButton.setVisibility(0);
        } else {
            this.mImageButton.setVisibility(8);
        }
        updateTextButtonVisibility();
    }

    public boolean hasText() {
        return this.mTextButton.getVisibility() != 8;
    }

    public void setShortcut(boolean showShortcut, char shortcutKey) {
    }

    public void setTitle(CharSequence title) {
        this.mTitle = title;
        this.mTextButton.setTextCompat(this.mTitle);
        setContentDescription(this.mTitle);
        updateTextButtonVisibility();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (VERSION.SDK_INT >= 14) {
            super.onPopulateAccessibilityEvent(event);
        }
        CharSequence cdesc = getContentDescription();
        if (!TextUtils.isEmpty(cdesc)) {
            event.getText().add(cdesc);
        }
    }

    public boolean dispatchHoverEvent(MotionEvent event) {
        if (VERSION.SDK_INT >= 14) {
            return onHoverEvent(event);
        }
        return false;
    }

    public boolean showsIcon() {
        return true;
    }

    public boolean needsDividerBefore() {
        return hasText() && this.mItemData.getIcon() == null;
    }

    public boolean needsDividerAfter() {
        return hasText();
    }

    public boolean onLongClick(View v) {
        if (hasText()) {
            return false;
        }
        int[] screenPos = new int[2];
        Rect displayFrame = new Rect();
        getLocationOnScreen(screenPos);
        getWindowVisibleDisplayFrame(displayFrame);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int midy = screenPos[1] + (height / 2);
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        Toast cheatSheet = IcsToast.makeText(context, this.mItemData.getTitle(), 0);
        if (midy < displayFrame.height()) {
            cheatSheet.setGravity(53, (screenWidth - screenPos[0]) - (width / 2), height);
        } else {
            cheatSheet.setGravity(81, 0, height);
        }
        cheatSheet.show();
        return true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int targetWidth;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        int oldMeasuredWidth = getMeasuredWidth();
        if (widthMode == ExploreByTouchHelper.INVALID_ID) {
            targetWidth = Math.min(specSize, this.mMinWidth);
        } else {
            targetWidth = this.mMinWidth;
        }
        if (widthMode != 1073741824 && this.mMinWidth > 0 && oldMeasuredWidth < targetWidth) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(targetWidth, 1073741824), heightMeasureSpec);
        }
    }
}
