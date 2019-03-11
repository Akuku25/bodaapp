package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzah.zza;
import java.util.concurrent.Future;

@zzgi
public class zzai {
    protected zzah zza(Context context, zzhy zzhy, final zzhq<zzah> zzhq) {
        final zzah zzaj = new zzaj(context, zzhy);
        zzaj.zza(new zza(this) {
            final /* synthetic */ zzai zznO;

            public void zzbk() {
                zzhq.zzb(zzaj);
            }
        });
        return zzaj;
    }

    public Future<zzah> zza(Context context, zzhy zzhy, String str) {
        final Future zzhq = new zzhq();
        final Context context2 = context;
        final zzhy zzhy2 = zzhy;
        final String str2 = str;
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzai zznO;

            public void run() {
                this.zznO.zza(context2, zzhy2, zzhq).zzg(str2);
            }
        });
        return zzhq;
    }
}
