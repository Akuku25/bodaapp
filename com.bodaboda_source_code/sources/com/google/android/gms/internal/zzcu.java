package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public final class zzcu {
    public static final zzcv zzrA = new C03362();
    public static final zzcv zzrB = new C03373();
    public static final zzcv zzrC = new C03384();
    public static final zzcv zzrD = new C03395();
    public static final zzcv zzrE = new C03406();
    public static final zzcv zzrF = new C03417();
    public static final zzcv zzrG = new C03428();
    public static final zzcv zzrH = new C03439();
    public static final zzcv zzrI = new zzdb();
    public static final zzcv zzrz = new C03351();

    /* renamed from: com.google.android.gms.internal.zzcu$1 */
    static class C03351 implements zzcv {
        C03351() {
        }

        public void zza(zzic zzic, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcu$2 */
    static class C03362 implements zzcv {
        C03362() {
        }

        public void zza(zzic zzic, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzhx.zzac("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = zzic.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            zzic.zzb("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcu$3 */
    static class C03373 implements zzcv {
        C03373() {
        }

        public void zza(zzic zzic, Map<String, String> map) {
            PackageManager packageManager = zzic.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (Throwable e) {
                                zzhx.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            zzhx.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    zzic.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    zzic.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                zzic.zzb("openableIntents", new JSONObject());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcu$4 */
    static class C03384 implements zzcv {
        C03384() {
        }

        public void zza(zzic zzic, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzhx.zzac("URL missing from click GMSG.");
                return;
            }
            Uri zza;
            Uri parse = Uri.parse(str);
            try {
                zzk zzeI = zzic.zzeI();
                if (zzeI != null && zzeI.zzb(parse)) {
                    zza = zzeI.zza(parse, zzic.getContext());
                    new zzhu(zzic.getContext(), zzic.zzeJ().zzzH, zza.toString()).start();
                }
            } catch (zzl e) {
                zzhx.zzac("Unable to append parameter to URL: " + str);
            }
            zza = parse;
            new zzhu(zzic.getContext(), zzic.zzeJ().zzzH, zza.toString()).start();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcu$5 */
    static class C03395 implements zzcv {
        C03395() {
        }

        public void zza(zzic zzic, Map<String, String> map) {
            zzel zzeF = zzic.zzeF();
            if (zzeF == null) {
                zzhx.zzac("A GMSG tried to close something that wasn't an overlay.");
            } else {
                zzeF.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcu$6 */
    static class C03406 implements zzcv {
        C03406() {
        }

        public void zza(zzic zzic, Map<String, String> map) {
            zzic.zzB("1".equals(map.get("custom_close")));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcu$7 */
    static class C03417 implements zzcv {
        C03417() {
        }

        public void zza(zzic zzic, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzhx.zzac("URL missing from httpTrack GMSG.");
            } else {
                new zzhu(zzic.getContext(), zzic.zzeJ().zzzH, str).start();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcu$8 */
    static class C03428 implements zzcv {
        C03428() {
        }

        public void zza(zzic zzic, Map<String, String> map) {
            zzhx.zzaa("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcu$9 */
    static class C03439 implements zzcv {
        C03439() {
        }

        public void zza(zzic zzic, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                zzk zzeI = zzic.zzeI();
                if (zzeI != null) {
                    zzeI.zzC().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzhx.zzac("Could not parse touch parameters from gmsg.");
            }
        }
    }
}
