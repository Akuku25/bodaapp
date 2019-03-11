package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.Map;

public final class zzrf extends zzqy<zzrf> {
    private String zzBa;
    private String zzBb;
    private String zzBc;
    private String zzBd;

    public void setAppId(String value) {
        this.zzBc = value;
    }

    public void setAppInstallerId(String value) {
        this.zzBd = value;
    }

    public void setAppName(String value) {
        this.zzBa = value;
    }

    public void setAppVersion(String value) {
        this.zzBb = value;
    }

    public String toString() {
        Map arrayMap = new ArrayMap();
        arrayMap.put("appName", this.zzBa);
        arrayMap.put("appVersion", this.zzBb);
        arrayMap.put("appId", this.zzBc);
        arrayMap.put("appInstallerId", this.zzBd);
        return zzqy.zzG(arrayMap);
    }

    public String zzga() {
        return this.zzBa;
    }

    public String zzgc() {
        return this.zzBb;
    }

    public String zznE() {
        return this.zzBc;
    }

    public String zzra() {
        return this.zzBd;
    }
}
