package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public class PopupWindowCompat extends PopupWindow {
    private static final OnScrollChangedListener NOP = new C00731();
    private static final Field superListenerField;
    private OnScrollChangedListener mSuperScrollListener;
    private ViewTreeObserver mViewTreeObserver;

    /* renamed from: com.actionbarsherlock.internal.widget.PopupWindowCompat$1 */
    class C00731 implements OnScrollChangedListener {
        C00731() {
        }

        public void onScrollChanged() {
        }
    }

    static {
        Field f = null;
        try {
            f = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            f.setAccessible(true);
        } catch (NoSuchFieldException e) {
        }
        superListenerField = f;
    }

    public PopupWindowCompat() {
        init();
    }

    public PopupWindowCompat(Context context) {
        super(context);
        init();
    }

    public PopupWindowCompat(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PopupWindowCompat(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public PopupWindowCompat(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public PopupWindowCompat(int width, int height) {
        super(width, height);
        init();
    }

    public PopupWindowCompat(View contentView) {
        super(contentView);
        init();
    }

    public PopupWindowCompat(View contentView, int width, int height, boolean focusable) {
        super(contentView, width, height, focusable);
        init();
    }

    public PopupWindowCompat(View contentView, int width, int height) {
        super(contentView, width, height);
        init();
    }

    private void init() {
        if (superListenerField != null) {
            try {
                this.mSuperScrollListener = (OnScrollChangedListener) superListenerField.get(this);
                superListenerField.set(this, NOP);
            } catch (Exception e) {
                this.mSuperScrollListener = null;
            }
        }
    }

    private void unregisterListener() {
        if (this.mSuperScrollListener != null && this.mViewTreeObserver != null) {
            if (this.mViewTreeObserver.isAlive()) {
                this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
            }
            this.mViewTreeObserver = null;
        }
    }

    private void registerListener(View anchor) {
        if (this.mSuperScrollListener != null) {
            ViewTreeObserver vto;
            if (anchor.getWindowToken() != null) {
                vto = anchor.getViewTreeObserver();
            } else {
                vto = null;
            }
            if (vto != this.mViewTreeObserver) {
                if (this.mViewTreeObserver != null && this.mViewTreeObserver.isAlive()) {
                    this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
                }
                this.mViewTreeObserver = vto;
                if (vto != null) {
                    vto.addOnScrollChangedListener(this.mSuperScrollListener);
                }
            }
        }
    }

    public void showAsDropDown(View anchor, int xoff, int yoff) {
        super.showAsDropDown(anchor, xoff, yoff);
        registerListener(anchor);
    }

    public void update(View anchor, int xoff, int yoff, int width, int height) {
        super.update(anchor, xoff, yoff, width, height);
        registerListener(anchor);
    }

    public void update(View anchor, int width, int height) {
        super.update(anchor, width, height);
        registerListener(anchor);
    }

    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
        unregisterListener();
    }

    public void dismiss() {
        super.dismiss();
        unregisterListener();
    }
}
