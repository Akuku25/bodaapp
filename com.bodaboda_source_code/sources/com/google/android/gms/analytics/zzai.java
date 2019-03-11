package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzrg;

class zzai implements zzq {
    private final zzra zzAM;

    zzai(zzra zzra) {
        zzx.zzl(zzra);
        this.zzAM = zzra;
    }

    public String getValue(String field) {
        return "&sr".equals(field) ? zzgC() : null;
    }

    public boolean zzaj(String str) {
        return "&sr".equals(str);
    }

    protected String zzgC() {
        zzrg zzqV = this.zzAM.zzqV();
        return zzqV.zzrb() + "x" + zzqV.zzrc();
    }
}
