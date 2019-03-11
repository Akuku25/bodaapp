package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

@zzgi
public class zzaa {
    private final zza zzmF;
    private final Runnable zzmG;
    private zzax zzmH;
    private boolean zzmI;
    private boolean zzmJ;
    private long zzmK;

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzaa(zzt zzt) {
        this(zzt, new zza(zzhw.zzzG));
    }

    zzaa(zzt zzt, zza zza) {
        this.zzmI = false;
        this.zzmJ = false;
        this.zzmK = 0;
        this.zzmF = zza;
        final WeakReference weakReference = new WeakReference(zzt);
        this.zzmG = new Runnable(this) {
            final /* synthetic */ zzaa zzmM;

            public void run() {
                this.zzmM.zzmI = false;
                zzt zzt = (zzt) weakReference.get();
                if (zzt != null) {
                    zzt.zzb(this.zzmM.zzmH);
                }
            }
        };
    }

    public void cancel() {
        this.zzmI = false;
        this.zzmF.removeCallbacks(this.zzmG);
    }

    public void pause() {
        this.zzmJ = true;
        if (this.zzmI) {
            this.zzmF.removeCallbacks(this.zzmG);
        }
    }

    public void resume() {
        this.zzmJ = false;
        if (this.zzmI) {
            this.zzmI = false;
            zza(this.zzmH, this.zzmK);
        }
    }

    public void zza(zzax zzax, long j) {
        if (this.zzmI) {
            zzhx.zzac("An ad refresh is already scheduled.");
            return;
        }
        this.zzmH = zzax;
        this.zzmI = true;
        this.zzmK = j;
        if (!this.zzmJ) {
            zzhx.zzaa("Scheduling ad refresh " + j + " milliseconds from now.");
            this.zzmF.postDelayed(this.zzmG, j);
        }
    }

    public boolean zzaG() {
        return this.zzmI;
    }

    public void zzc(zzax zzax) {
        zza(zzax, 60000);
    }
}
