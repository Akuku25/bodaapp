package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.zzgt.zza;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzgv implements zza<zzcm> {
    public /* synthetic */ zzcn.zza zza(zzgt zzgt, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return zzc(zzgt, jSONObject);
    }

    public zzcm zzc(zzgt zzgt, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new zzcm(jSONObject.getString("headline"), (Drawable) zzgt.zza(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) zzgt.zza(jSONObject, "secondary_image", false).get(), jSONObject.getString("call_to_action"), jSONObject.getString("attribution"));
    }
}
