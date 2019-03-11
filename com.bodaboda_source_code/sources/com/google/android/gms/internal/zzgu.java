package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.zzgt.zza;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzgu implements zza<zzcl> {
    public /* synthetic */ zzcn.zza zza(zzgt zzgt, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return zzb(zzgt, jSONObject);
    }

    public zzcl zzb(zzgt zzgt, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new zzcl(jSONObject.getString("headline"), (Drawable) zzgt.zza(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) zzgt.zza(jSONObject, "app_icon", true).get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"));
    }
}
