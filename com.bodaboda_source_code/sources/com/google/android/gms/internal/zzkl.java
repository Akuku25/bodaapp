package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzkl extends ImageView {
    private Uri zzPe;
    private int zzPf;
    private int zzPg;
    private zza zzPh;
    private int zzPi;
    private float zzPj;

    public interface zza {
        Path zzk(int i, int i2);
    }

    protected void onDraw(Canvas canvas) {
        if (this.zzPh != null) {
            canvas.clipPath(this.zzPh.zzk(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzPg != 0) {
            canvas.drawColor(this.zzPg);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredHeight;
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        switch (this.zzPi) {
            case 1:
                measuredHeight = getMeasuredHeight();
                i = (int) (((float) measuredHeight) * this.zzPj);
                break;
            case 2:
                i = getMeasuredWidth();
                measuredHeight = (int) (((float) i) / this.zzPj);
                break;
            default:
                return;
        }
        setMeasuredDimension(i, measuredHeight);
    }

    public void zzaE(int i) {
        this.zzPf = i;
    }

    public void zzi(Uri uri) {
        this.zzPe = uri;
    }

    public int zziK() {
        return this.zzPf;
    }
}
