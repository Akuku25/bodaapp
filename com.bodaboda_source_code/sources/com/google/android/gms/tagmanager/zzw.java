package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.List;
import java.util.Map;

class zzw extends zzdc {
    private static final String ID = zza.DATA_LAYER_WRITE.toString();
    private static final String VALUE = zzb.VALUE.toString();
    private static final String zzayx = zzb.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer zzaxx;

    public zzw(DataLayer dataLayer) {
        super(ID, VALUE);
        this.zzaxx = dataLayer;
    }

    private void zza(zzd.zza zza) {
        if (zza != null && zza != zzde.zztZ()) {
            String zzg = zzde.zzg(zza);
            if (zzg != zzde.zzue()) {
                this.zzaxx.zzcU(zzg);
            }
        }
    }

    private void zzb(zzd.zza zza) {
        if (zza != null && zza != zzde.zztZ()) {
            Object zzl = zzde.zzl(zza);
            if (zzl instanceof List) {
                for (Object zzl2 : (List) zzl2) {
                    if (zzl2 instanceof Map) {
                        this.zzaxx.push((Map) zzl2);
                    }
                }
            }
        }
    }

    public void zzJ(Map<String, zzd.zza> map) {
        zzb((zzd.zza) map.get(VALUE));
        zza((zzd.zza) map.get(zzayx));
    }
}
