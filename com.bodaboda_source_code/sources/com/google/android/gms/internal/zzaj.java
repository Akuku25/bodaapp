package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzah.zza;
import org.json.JSONObject;

@zzgi
public class zzaj implements zzah {
    private final zzic zzmu;

    public zzaj(Context context, zzhy zzhy) {
        this.zzmu = zzab.zzaN().zza(context, new zzba(), false, false, null, zzhy);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzbe.zzbD().zzeC()) {
            runnable.run();
        } else {
            zzhw.zzzG.post(runnable);
        }
    }

    public void destroy() {
        this.zzmu.destroy();
    }

    public void zza(final zza zza) {
        this.zzmu.zzeG().zza(new zzid.zza(this) {
            final /* synthetic */ zzaj zznS;

            public void zza(zzic zzic, boolean z) {
                zza.zzbk();
            }
        });
    }

    public void zza(zzat zzat, zzep zzep, zzct zzct, zzes zzes, boolean z, zzcw zzcw, zzcy zzcy, zzu zzu, zzeh zzeh) {
        this.zzmu.zzeG().zzb(zzat, zzep, zzct, zzes, z, zzcw, zzcy, new zzu(false), zzeh);
    }

    public void zza(String str, zzcv zzcv) {
        this.zzmu.zzeG().zza(str, zzcv);
    }

    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzaj zznS;

            public void run() {
                this.zznS.zzmu.zza(str, jSONObject);
            }
        });
    }

    public void zzb(String str, zzcv zzcv) {
        this.zzmu.zzeG().zzb(str, zzcv);
    }

    public void zzb(final String str, final String str2) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzaj zznS;

            public void run() {
                this.zznS.zzmu.zzb(str, str2);
            }
        });
    }

    public void zzf(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str});
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzaj zznS;

            public void run() {
                this.zznS.zzmu.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    public void zzg(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzaj zznS;

            public void run() {
                this.zznS.zzmu.loadUrl(str);
            }
        });
    }
}
