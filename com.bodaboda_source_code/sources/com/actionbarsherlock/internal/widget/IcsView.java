package com.actionbarsherlock.internal.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

final class IcsView {
    private IcsView() {
    }

    public static int getMeasuredStateInt(View child) {
        return (child.getMeasuredWidth() & ViewCompat.MEASURED_STATE_MASK) | ((child.getMeasuredHeight() >> 16) & -256);
    }
}
