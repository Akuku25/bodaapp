package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;

@zzgi
public abstract class zzgb extends zzhl {
    protected final Context mContext;
    protected final zzic zzmu;
    protected final Object zznh = new Object();
    protected final com.google.android.gms.internal.zzgc.zza zzvL;
    protected final Object zzvM = new Object();
    protected final com.google.android.gms.internal.zzhe.zza zzvN;
    protected zzgq zzvO;

    /* renamed from: com.google.android.gms.internal.zzgb$1 */
    class C01861 implements Runnable {
        final /* synthetic */ zzgb zzvP;

        C01861(zzgb zzgb) {
            this.zzvP = zzgb;
        }

        public void run() {
            this.zzvP.onStop();
        }
    }

    protected static final class zza extends Exception {
        private final int zzvR;

        public zza(String str, int i) {
            super(str);
            this.zzvR = i;
        }

        public int getErrorCode() {
            return this.zzvR;
        }
    }

    protected zzgb(Context context, com.google.android.gms.internal.zzhe.zza zza, zzic zzic, com.google.android.gms.internal.zzgc.zza zza2) {
        this.mContext = context;
        this.zzvN = zza;
        this.zzvO = zza.zzyz;
        this.zzmu = zzic;
        this.zzvL = zza2;
    }

    public void onStop() {
    }

    public void zzdw() {
        int errorCode;
        synchronized (this.zznh) {
            zzhx.zzY("AdRendererBackgroundTask started.");
            int i = this.zzvN.errorCode;
            try {
                zzg(SystemClock.elapsedRealtime());
            } catch (zza e) {
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzhx.zzaa(e.getMessage());
                } else {
                    zzhx.zzac(e.getMessage());
                }
                if (this.zzvO == null) {
                    this.zzvO = new zzgq(errorCode);
                } else {
                    this.zzvO = new zzgq(errorCode, this.zzvO.zzsx);
                }
                zzhw.zzzG.post(new C01861(this));
                i = errorCode;
            }
            final zzhe zzt = zzt(i);
            zzhw.zzzG.post(new Runnable(this) {
                final /* synthetic */ zzgb zzvP;

                public void run() {
                    synchronized (this.zzvP.zznh) {
                        this.zzvP.zzh(zzt);
                    }
                }
            });
        }
    }

    protected abstract void zzg(long j) throws zza;

    protected void zzh(zzhe zzhe) {
        this.zzvL.zza(zzhe);
    }

    protected zzhe zzt(int i) {
        zzgo zzgo = this.zzvN.zzyy;
        return new zzhe(zzgo.zzwn, this.zzmu, this.zzvO.zzst, i, this.zzvO.zzsu, this.zzvO.zzwK, this.zzvO.orientation, this.zzvO.zzsx, zzgo.zzwq, this.zzvO.zzwI, null, null, null, null, null, this.zzvO.zzwJ, this.zzvN.zzlV, this.zzvO.zzwH, this.zzvN.zzyv, this.zzvO.zzwM, this.zzvO.zzwN, this.zzvN.zzys, null, zzgo.zzwD);
    }
}
