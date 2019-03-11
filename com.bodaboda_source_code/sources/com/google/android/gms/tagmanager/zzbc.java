package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzbc extends zzbu {
    private static final String ID = zza.LESS_THAN.toString();

    public zzbc() {
        super(ID);
    }

    protected boolean zza(zzdd zzdd, zzdd zzdd2, Map<String, zzd.zza> map) {
        return zzdd.zza(zzdd2) < 0;
    }
}
