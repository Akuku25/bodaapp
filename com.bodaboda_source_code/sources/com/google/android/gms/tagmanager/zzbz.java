package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd.zza;
import java.util.Map;
import java.util.Set;

public abstract class zzbz extends zzaj {
    private static final String zzayC = zzb.ARG0.toString();
    private static final String zzazv = zzb.ARG1.toString();

    public zzbz(String str) {
        super(str, zzayC, zzazv);
    }

    public zza zzH(Map<String, zza> map) {
        for (zza zza : map.values()) {
            if (zza == zzde.zzuf()) {
                return zzde.zzx(Boolean.valueOf(false));
            }
        }
        zza zza2 = (zza) map.get(zzayC);
        zza zza3 = (zza) map.get(zzazv);
        boolean zza4 = (zza2 == null || zza3 == null) ? false : zza(zza2, zza3, map);
        return zzde.zzx(Boolean.valueOf(zza4));
    }

    protected abstract boolean zza(zza zza, zza zza2, Map<String, zza> map);

    public boolean zzsD() {
        return true;
    }

    public /* bridge */ /* synthetic */ String zzth() {
        return super.zzth();
    }

    public /* bridge */ /* synthetic */ Set zzti() {
        return super.zzti();
    }
}
