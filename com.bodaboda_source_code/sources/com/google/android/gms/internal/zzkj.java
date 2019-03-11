package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;

public final class zzkj extends Drawable implements Callback {
    private int mFrom;
    private boolean zzOF;
    private int zzOM;
    private long zzON;
    private int zzOO;
    private int zzOP;
    private int zzOQ;
    private int zzOR;
    private boolean zzOS;
    private zzb zzOT;
    private Drawable zzOU;
    private Drawable zzOV;
    private boolean zzOW;
    private boolean zzOX;
    private boolean zzOY;
    private int zzOZ;

    private static final class zza extends Drawable {
        private static final zza zzPa = new zza();
        private static final zza zzPb = new zza();

        private static final class zza extends ConstantState {
            private zza() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return zza.zzPa;
            }
        }

        private zza() {
        }

        public void draw(Canvas canvas) {
        }

        public ConstantState getConstantState() {
            return zzPb;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    static final class zzb extends ConstantState {
        int zzPc;
        int zzPd;

        zzb(zzb zzb) {
            if (zzb != null) {
                this.zzPc = zzb.zzPc;
                this.zzPd = zzb.zzPd;
            }
        }

        public int getChangingConfigurations() {
            return this.zzPc;
        }

        public Drawable newDrawable() {
            return new zzkj(this);
        }
    }

    public zzkj(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = zza.zzPa;
        }
        this.zzOU = drawable;
        drawable.setCallback(this);
        zzb zzb = this.zzOT;
        zzb.zzPd |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = zza.zzPa;
        }
        this.zzOV = drawable2;
        drawable2.setCallback(this);
        zzb = this.zzOT;
        zzb.zzPd |= drawable2.getChangingConfigurations();
    }

    zzkj(zzb zzb) {
        this.zzOM = 0;
        this.zzOP = MotionEventCompat.ACTION_MASK;
        this.zzOR = 0;
        this.zzOF = true;
        this.zzOT = new zzb(zzb);
    }

    public boolean canConstantState() {
        if (!this.zzOW) {
            boolean z = (this.zzOU.getConstantState() == null || this.zzOV.getConstantState() == null) ? false : true;
            this.zzOX = z;
            this.zzOW = true;
        }
        return this.zzOX;
    }

    public void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.zzOM) {
            case 1:
                this.zzON = SystemClock.uptimeMillis();
                this.zzOM = 2;
                break;
            case 2:
                if (this.zzON >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzON)) / ((float) this.zzOQ);
                    if (uptimeMillis < 1.0f) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.zzOM = 0;
                    }
                    float min = Math.min(uptimeMillis, 1.0f);
                    this.zzOR = (int) ((min * ((float) (this.zzOO - this.mFrom))) + ((float) this.mFrom));
                    break;
                }
                break;
        }
        i2 = i;
        i = this.zzOR;
        boolean z = this.zzOF;
        Drawable drawable = this.zzOU;
        Drawable drawable2 = this.zzOV;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzOP) {
                drawable2.setAlpha(this.zzOP);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.zzOP - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.zzOP);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzOP);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.zzOT.zzPc) | this.zzOT.zzPd;
    }

    public ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzOT.zzPc = getChangingConfigurations();
        return this.zzOT;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.zzOU.getIntrinsicHeight(), this.zzOV.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.zzOU.getIntrinsicWidth(), this.zzOV.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.zzOY) {
            this.zzOZ = Drawable.resolveOpacity(this.zzOU.getOpacity(), this.zzOV.getOpacity());
            this.zzOY = true;
        }
        return this.zzOZ;
    }

    public void invalidateDrawable(Drawable who) {
        if (zzme.zzkd()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if (!this.zzOS && super.mutate() == this) {
            if (canConstantState()) {
                this.zzOU.mutate();
                this.zzOV.mutate();
                this.zzOS = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected void onBoundsChange(Rect bounds) {
        this.zzOU.setBounds(bounds);
        this.zzOV.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (zzme.zzkd()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, what, when);
            }
        }
    }

    public void setAlpha(int alpha) {
        if (this.zzOR == this.zzOP) {
            this.zzOR = alpha;
        }
        this.zzOP = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.zzOU.setColorFilter(cf);
        this.zzOV.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.mFrom = 0;
        this.zzOO = this.zzOP;
        this.zzOR = 0;
        this.zzOQ = durationMillis;
        this.zzOM = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (zzme.zzkd()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, what);
            }
        }
    }

    public Drawable zziI() {
        return this.zzOV;
    }
}
