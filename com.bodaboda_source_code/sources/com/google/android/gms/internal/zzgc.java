package com.google.android.gms.internal;

import android.content.Context;

@zzgi
public class zzgc {

    public interface zza {
        void zza(zzhe zzhe);
    }

    public zzhl zza(Context context, zzt zzt, com.google.android.gms.internal.zzhe.zza zza, zzic zzic, zzdr zzdr, zza zza2) {
        zzgq zzgq = zza.zzyz;
        zzhl zzgg = zzgq.zzwS ? new zzgg(context, zzt, new zzai(), zza, zza2) : zzgq.zzwI ? new zzgf(context, zza, zzic, zzdr, zza2) : zzgq.zzwO ? new zzga(context, zza, zzic, zza2) : (((Boolean) zzca.zzqI.get()).booleanValue() && zzme.zzkj() && !zzme.zzkk() && zzic.zzad().zzpb) ? new zzge(context, zza, zzic, zza2) : new zzgd(context, zza, zzic, zza2);
        zzgg.start();
        return zzgg;
    }
}
