package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.zzhe.zza;

@zzgi
public class zzgf extends zzgb {
    private zzdr zzlD;
    private zzdk zzsf;
    private zzdi zzvW;
    protected zzdo zzvX;

    zzgf(Context context, zza zza, zzic zzic, zzdr zzdr, zzgc.zza zza2) {
        super(context, zza, zzic, zza2);
        this.zzlD = zzdr;
        this.zzsf = zza.zzyt;
    }

    public void onStop() {
        synchronized (this.zzvM) {
            super.onStop();
            if (this.zzvW != null) {
                this.zzvW.cancel();
            }
        }
    }

    protected void zzg(long j) throws zza {
        synchronized (this.zzvM) {
            this.zzvW = new zzdi(this.mContext, this.zzvN.zzyy, this.zzlD, this.zzsf);
        }
        this.zzvX = this.zzvW.zza(j, 60000);
        switch (this.zzvX.zzsK) {
            case 0:
                return;
            case 1:
                throw new zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zza("Unexpected mediation result: " + this.zzvX.zzsK, 0);
        }
    }

    protected zzhe zzt(int i) {
        zzgo zzgo = this.zzvN.zzyy;
        return new zzhe(zzgo.zzwn, this.zzmu, this.zzvO.zzst, i, this.zzvO.zzsu, this.zzvO.zzwK, this.zzvO.orientation, this.zzvO.zzsx, zzgo.zzwq, this.zzvO.zzwI, this.zzvX != null ? this.zzvX.zzsL : null, this.zzvX != null ? this.zzvX.zzsM : null, this.zzvX != null ? this.zzvX.zzsN : AdMobAdapter.class.getName(), this.zzsf, this.zzvX != null ? this.zzvX.zzsO : null, this.zzvO.zzwJ, this.zzvN.zzlV, this.zzvO.zzwH, this.zzvN.zzyv, this.zzvO.zzwM, this.zzvO.zzwN, this.zzvN.zzys, null, zzgo.zzwD);
    }
}
