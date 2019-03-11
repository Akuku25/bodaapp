package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzg.zza;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzLI;
    private OnClickListener zzLJ;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzLJ = null;
        setStyle(0, 0);
    }

    private void zzN(Context context) {
        if (this.zzLI != null) {
            removeView(this.zzLI);
        }
        try {
            this.zzLI = zzac.zzb(context, this.mSize, this.mColor);
        } catch (zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.zzLI = zza(context, this.mSize, this.mColor);
        }
        addView(this.zzLI);
        this.zzLI.setEnabled(isEnabled());
        this.zzLI.setOnClickListener(this);
    }

    private static Button zza(Context context, int i, int i2) {
        Button zzad = new zzad(context);
        zzad.zza(context.getResources(), i, i2);
        return zzad;
    }

    public void onClick(View view) {
        if (this.zzLJ != null && view == this.zzLI) {
            this.zzLJ.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.zzLI.setEnabled(enabled);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.zzLJ = listener;
        if (this.zzLI != null) {
            this.zzLI.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.mColor);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        boolean z = buttonSize >= 0 && buttonSize < 3;
        zzx.zza(z, "Unknown button size %d", Integer.valueOf(buttonSize));
        z = colorScheme >= 0 && colorScheme < 2;
        zzx.zza(z, "Unknown color scheme %s", Integer.valueOf(colorScheme));
        this.mSize = buttonSize;
        this.mColor = colorScheme;
        zzN(getContext());
    }
}
