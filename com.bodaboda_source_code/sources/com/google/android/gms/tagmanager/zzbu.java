package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzd.zza;
import java.util.Map;

abstract class zzbu extends zzbz {
    public zzbu(String str) {
        super(str);
    }

    protected boolean zza(zza zza, zza zza2, Map<String, zza> map) {
        zzdd zzh = zzde.zzh(zza);
        zzdd zzh2 = zzde.zzh(zza2);
        return (zzh == zzde.zzud() || zzh2 == zzde.zzud()) ? false : zza(zzh, zzh2, (Map) map);
    }

    protected abstract boolean zza(zzdd zzdd, zzdd zzdd2, Map<String, zza> map);
}
