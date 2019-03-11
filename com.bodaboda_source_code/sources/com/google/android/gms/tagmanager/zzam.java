package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzam extends zzbu {
    private static final String ID = zza.GREATER_THAN.toString();

    public zzam() {
        super(ID);
    }

    protected boolean zza(zzdd zzdd, zzdd zzdd2, Map<String, zzd.zza> map) {
        return zzdd.zza(zzdd2) > 0;
    }
}
