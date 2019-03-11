package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzhe.zza;

@zzgi
public class zzgd extends zzfy {

    /* renamed from: com.google.android.gms.internal.zzgd$1 */
    class C01881 implements Runnable {
        final /* synthetic */ zzgd zzvS;

        C01881(zzgd zzgd) {
            this.zzvS = zzgd;
        }

        public void run() {
            synchronized (this.zzvS.zznh) {
                if (this.zzvS.zzvO.errorCode != -2) {
                    return;
                }
                this.zzvS.zzmu.zzeG().zza(this.zzvS);
                this.zzvS.zzdG();
                zzhx.zzab("Loading HTML in WebView.");
                this.zzvS.zzmu.loadDataWithBaseURL(zzab.zzaM().zzS(this.zzvS.zzvO.zzus), this.zzvS.zzvO.zzwG, "text/html", "UTF-8", null);
            }
        }
    }

    zzgd(Context context, zza zza, zzic zzic, zzgc.zza zza2) {
        super(context, zza, zzic, zza2);
    }

    protected void zzdG() {
    }

    protected void zzg(long j) throws zza {
        zzhw.zzzG.post(new C01881(this));
        zzf(j);
    }
}
