package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.Map;

public final class zzrg extends zzqy<zzrg> {
    private String zzIO;
    public int zzasn;
    public int zzaso;
    public int zzasp;
    public int zztI;
    public int zztJ;

    public void setLanguage(String language) {
        this.zzIO = language;
    }

    public String toString() {
        Map arrayMap = new ArrayMap();
        arrayMap.put("language", this.zzIO);
        arrayMap.put("screenColors", Integer.valueOf(this.zzasn));
        arrayMap.put("screenWidth", Integer.valueOf(this.zztI));
        arrayMap.put("screenHeight", Integer.valueOf(this.zztJ));
        arrayMap.put("viewportWidth", Integer.valueOf(this.zzaso));
        arrayMap.put("viewportHeight", Integer.valueOf(this.zzasp));
        return zzqy.zzG(arrayMap);
    }

    public void zzgp(int i) {
        this.zztI = i;
    }

    public void zzgq(int i) {
        this.zztJ = i;
    }

    public int zzrb() {
        return this.zztI;
    }

    public int zzrc() {
        return this.zztJ;
    }
}
