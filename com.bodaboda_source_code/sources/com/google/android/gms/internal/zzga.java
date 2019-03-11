package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzhe.zza;

@zzgi
public class zzga extends zzfy {
    zzga(Context context, zza zza, zzic zzic, zzgc.zza zza2) {
        super(context, zza, zzic, zza2);
    }

    protected void zzg(long j) throws zza {
        int i;
        int i2;
        zzba zzad = this.zzmu.zzad();
        if (zzad.zzpb) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = zzad.widthPixels;
            i2 = zzad.heightPixels;
        }
        final zzfz zzfz = new zzfz(this, this.zzmu, i, i2);
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzga zzvK;

            public void run() {
                synchronized (this.zzvK.zznh) {
                    if (this.zzvK.zzvO.errorCode != -2) {
                        return;
                    }
                    this.zzvK.zzmu.zzeG().zza(this.zzvK);
                    zzfz.zza(this.zzvK.zzvO);
                }
            }
        });
        zzf(j);
        if (zzfz.zzdE()) {
            zzhx.zzY("Ad-Network indicated no fill with passback URL.");
            throw new zza("AdNetwork sent passback url", 3);
        } else if (!zzfz.zzdF()) {
            throw new zza("AdNetwork timed out", 2);
        }
    }
}
