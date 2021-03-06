package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Button;
import java.util.Locale;

public class CapitalizingButton extends Button {
    private static final boolean IS_GINGERBREAD;
    private static final int[] R_styleable_Button = new int[]{16842804};
    private static final int R_styleable_Button_textAppearance = 0;
    private static final int[] R_styleable_TextAppearance = new int[]{16843660};
    private static final int R_styleable_TextAppearance_textAllCaps = 0;
    private static final boolean SANS_ICE_CREAM = (VERSION.SDK_INT < 14);
    private boolean mAllCaps;

    static {
        boolean z;
        if (VERSION.SDK_INT >= 9) {
            z = true;
        } else {
            z = false;
        }
        IS_GINGERBREAD = z;
    }

    public CapitalizingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R_styleable_Button);
        int ap = a.getResourceId(0, -1);
        a.recycle();
        if (ap != -1) {
            TypedArray appearance = context.obtainStyledAttributes(ap, R_styleable_TextAppearance);
            if (appearance != null) {
                this.mAllCaps = appearance.getBoolean(0, true);
                appearance.recycle();
            }
        }
    }

    public void setTextCompat(CharSequence text) {
        if (!SANS_ICE_CREAM || !this.mAllCaps || text == null) {
            setText(text);
        } else if (IS_GINGERBREAD) {
            try {
                setText(text.toString().toUpperCase(Locale.ROOT));
            } catch (NoSuchFieldError e) {
                setText(text.toString().toUpperCase());
            }
        } else {
            setText(text.toString().toUpperCase());
        }
    }
}
