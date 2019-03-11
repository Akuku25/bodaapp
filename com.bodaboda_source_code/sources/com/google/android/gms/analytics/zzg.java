package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzrf;

class zzg implements zzq {
    protected String zzBa;
    protected String zzBb;
    protected String zzBc;
    protected String zzBd;

    zzg(zzra zzra) {
        zzrf zzqU = zzra.zzqU();
        this.zzBc = zzqU.zznE();
        this.zzBd = zzqU.zzra();
        this.zzBa = zzqU.zzga();
        this.zzBb = zzqU.zzgc();
    }

    public String getValue(String field) {
        if (field == null) {
            return null;
        }
        if (field.equals("&an")) {
            return this.zzBa;
        }
        if (field.equals("&av")) {
            return this.zzBb;
        }
        if (field.equals("&aid")) {
            return this.zzBc;
        }
        return field.equals("&aiid") ? this.zzBd : null;
    }

    public boolean zzaj(String str) {
        return "&an".equals(str) || "&av".equals(str) || "&aid".equals(str) || "&aiid".equals(str);
    }
}
