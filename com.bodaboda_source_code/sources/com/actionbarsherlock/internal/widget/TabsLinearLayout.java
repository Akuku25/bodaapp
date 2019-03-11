package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;

public class TabsLinearLayout extends IcsLinearLayout {
    private static final int LinearLayout_measureWithLargestChild = 0;
    private static final int[] R_styleable_LinearLayout = new int[]{16843476};
    private boolean mUseLargestChild;

    public TabsLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R_styleable_LinearLayout);
        this.mUseLargestChild = a.getBoolean(0, false);
        a.recycle();
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        this.mUseLargestChild = enabled;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 2) {
            int mode = MeasureSpec.getMode(widthMeasureSpec);
            if (this.mUseLargestChild && mode == 0 && getOrientation() == 0) {
                useLargestChildHorizontal();
            }
        }
    }

    private void useLargestChildHorizontal() {
        int i;
        int childCount = getChildCount();
        int largestChildWidth = 0;
        for (i = 0; i < childCount; i++) {
            largestChildWidth = Math.max(getChildAt(i).getMeasuredWidth(), largestChildWidth);
        }
        int totalWidth = 0;
        for (i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (!(child == null || child.getVisibility() == 8)) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.weight > 0.0f) {
                    child.measure(MeasureSpec.makeMeasureSpec(largestChildWidth, 1073741824), MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), 1073741824));
                    totalWidth += largestChildWidth;
                } else {
                    totalWidth += child.getMeasuredWidth();
                }
                totalWidth += lp.leftMargin + lp.rightMargin;
            }
        }
        setMeasuredDimension(totalWidth + (getPaddingLeft() + getPaddingRight()), getMeasuredHeight());
    }
}
