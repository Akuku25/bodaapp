package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzcb extends zzaj {
    private static final String ID = zza.RANDOM.toString();
    private static final String zzazF = zzb.MIN.toString();
    private static final String zzazG = zzb.MAX.toString();

    public zzcb() {
        super(ID, new String[0]);
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        double doubleValue;
        double d;
        zzd.zza zza = (zzd.zza) map.get(zzazF);
        zzd.zza zza2 = (zzd.zza) map.get(zzazG);
        if (!(zza == null || zza == zzde.zzuf() || zza2 == null || zza2 == zzde.zzuf())) {
            zzdd zzh = zzde.zzh(zza);
            zzdd zzh2 = zzde.zzh(zza2);
            if (!(zzh == zzde.zzud() || zzh2 == zzde.zzud())) {
                double doubleValue2 = zzh.doubleValue();
                doubleValue = zzh2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return zzde.zzx(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return zzde.zzx(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }

    public boolean zzsD() {
        return false;
    }
}
