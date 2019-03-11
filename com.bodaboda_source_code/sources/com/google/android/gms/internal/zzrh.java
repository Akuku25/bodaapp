package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;
import java.util.UUID;

public final class zzrh extends zzqy<zzrh> {
    private String zzasq;
    private int zzasr;
    private int zzass;
    private String zzast;
    private String zzasu;
    private boolean zzasv;
    private boolean zzasw;
    private boolean zzasx;

    public zzrh() {
        this(false);
    }

    public zzrh(boolean z) {
        this(z, zzrd());
    }

    public zzrh(boolean z, int i) {
        zzx.zzaL(i);
        this.zzasr = i;
        this.zzasw = z;
    }

    static int zzrd() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        Log.e("com.google.android.gms.measurement.data.ScreenViewInfo", "UUID.randomUUID() returned 0.");
        return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    private void zzrj() {
        if (this.zzasx) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public boolean isMutable() {
        return !this.zzasx;
    }

    public void setScreenName(String screenName) {
        zzrj();
        this.zzasq = screenName;
    }

    public String toString() {
        Map arrayMap = new ArrayMap();
        arrayMap.put("screenName", this.zzasq);
        arrayMap.put("interstitial", Boolean.valueOf(this.zzasv));
        arrayMap.put("automatic", Boolean.valueOf(this.zzasw));
        arrayMap.put("screenId", Integer.valueOf(this.zzasr));
        arrayMap.put("referrerScreenId", Integer.valueOf(this.zzass));
        arrayMap.put("referrerScreenName", this.zzast);
        arrayMap.put("referrerUri", this.zzasu);
        return zzqy.zzG(arrayMap);
    }

    public int zzaF() {
        return this.zzasr;
    }

    public void zzaa(boolean z) {
        zzrj();
        this.zzasv = z;
    }

    public void zzcv(String str) {
        zzrj();
        this.zzast = str;
    }

    public void zzgr(int i) {
        zzrj();
        this.zzass = i;
    }

    public String zzre() {
        return this.zzasq;
    }

    public int zzrf() {
        return this.zzass;
    }

    public String zzrg() {
        return this.zzast;
    }

    public void zzrh() {
        this.zzasx = true;
    }

    public boolean zzri() {
        return this.zzasv;
    }
}
