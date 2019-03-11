package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

@zzgi
public class zzfz implements Runnable {
    private final int zzli;
    private final int zzlj;
    protected final zzic zzmu;
    private final Handler zzvA;
    private final long zzvB;
    private long zzvC;
    private com.google.android.gms.internal.zzid.zza zzvD;
    protected boolean zzvE;
    protected boolean zzvF;

    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzvG;
        private Bitmap zzvH;
        final /* synthetic */ zzfz zzvI;

        public zza(zzfz zzfz, WebView webView) {
            this.zzvI = zzfz;
            this.zzvG = webView;
        }

        protected /* synthetic */ Object doInBackground(Object[] x0) {
            return zza((Void[]) x0);
        }

        protected /* synthetic */ void onPostExecute(Object x0) {
            zza((Boolean) x0);
        }

        protected synchronized void onPreExecute() {
            this.zzvH = Bitmap.createBitmap(this.zzvI.zzli, this.zzvI.zzlj, Config.ARGB_8888);
            this.zzvG.setVisibility(0);
            this.zzvG.measure(MeasureSpec.makeMeasureSpec(this.zzvI.zzli, 0), MeasureSpec.makeMeasureSpec(this.zzvI.zzlj, 0));
            this.zzvG.layout(0, 0, this.zzvI.zzli, this.zzvI.zzlj);
            this.zzvG.draw(new Canvas(this.zzvH));
            this.zzvG.invalidate();
        }

        protected synchronized Boolean zza(Void... voidArr) {
            Boolean valueOf;
            int width = this.zzvH.getWidth();
            int height = this.zzvH.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.zzvH.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void zza(Boolean bool) {
            zzfz.zzc(this.zzvI);
            if (bool.booleanValue() || this.zzvI.zzdE() || this.zzvI.zzvC <= 0) {
                this.zzvI.zzvF = bool.booleanValue();
                this.zzvI.zzvD.zza(this.zzvI.zzmu, true);
            } else if (this.zzvI.zzvC > 0) {
                if (zzhx.zzA(2)) {
                    zzhx.zzY("Ad not detected, scheduling another run.");
                }
                this.zzvI.zzvA.postDelayed(this.zzvI, this.zzvI.zzvB);
            }
        }
    }

    public zzfz(com.google.android.gms.internal.zzid.zza zza, zzic zzic, int i, int i2) {
        this(zza, zzic, i, i2, 200, 50);
    }

    public zzfz(com.google.android.gms.internal.zzid.zza zza, zzic zzic, int i, int i2, long j, long j2) {
        this.zzvB = j;
        this.zzvC = j2;
        this.zzvA = new Handler(Looper.getMainLooper());
        this.zzmu = zzic;
        this.zzvD = zza;
        this.zzvE = false;
        this.zzvF = false;
        this.zzlj = i2;
        this.zzli = i;
    }

    static /* synthetic */ long zzc(zzfz zzfz) {
        long j = zzfz.zzvC - 1;
        zzfz.zzvC = j;
        return j;
    }

    public void run() {
        if (this.zzmu == null || zzdE()) {
            this.zzvD.zza(this.zzmu, true);
        } else {
            new zza(this, this.zzmu.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(zzgq zzgq) {
        zza(zzgq, new zzij(this, this.zzmu, zzgq.zzwP));
    }

    public void zza(zzgq zzgq, zzij zzij) {
        this.zzmu.setWebViewClient(zzij);
        this.zzmu.loadDataWithBaseURL(TextUtils.isEmpty(zzgq.zzus) ? null : zzab.zzaM().zzS(zzgq.zzus), zzgq.zzwG, "text/html", "UTF-8", null);
    }

    public void zzdC() {
        this.zzvA.postDelayed(this, this.zzvB);
    }

    public synchronized void zzdD() {
        this.zzvE = true;
    }

    public synchronized boolean zzdE() {
        return this.zzvE;
    }

    public boolean zzdF() {
        return this.zzvF;
    }
}
