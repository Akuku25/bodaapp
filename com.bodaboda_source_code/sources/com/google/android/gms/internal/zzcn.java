package com.google.android.gms.internal;

import org.json.JSONObject;

@zzgi
public class zzcn {
    private zzt zzrv;
    private zzah zzrw;
    private JSONObject zzrx;

    public interface zza {
        void zza(zzcn zzcn);
    }

    public zzcn(zzt zzt, zzah zzah, JSONObject jSONObject) {
        this.zzrv = zzt;
        this.zzrw = zzah;
        this.zzrx = jSONObject;
    }

    public void recordImpression() {
        this.zzrv.zzan();
    }

    public void zzb(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset", i);
            jSONObject.put("template", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad", this.zzrx);
            jSONObject2.put("click", jSONObject);
            this.zzrw.zza("google.afma.nativeAds.handleClick", jSONObject2);
        } catch (Throwable e) {
            zzhx.zzb("Unable to create click JSON.", e);
        }
    }
}
