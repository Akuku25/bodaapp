package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public final class zzgx {
    private static final SimpleDateFormat zzxu = new SimpleDateFormat("yyyyMMdd");

    public static zzgq zza(Context context, zzgo zzgo, String str) {
        try {
            zzgq zzgq;
            int i;
            List list;
            List list2;
            List list3;
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            Object optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_html", null);
            long j = -1;
            String optString5 = jSONObject.optString("debug_dialog", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString6 = jSONObject.optString("orientation", null);
            int i2 = -1;
            if ("portrait".equals(optString6)) {
                i2 = zzab.zzaO().zzey();
            } else if ("landscape".equals(optString6)) {
                i2 = zzab.zzaO().zzex();
            }
            if (TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString2)) {
                    zzhx.zzac("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new zzgq(0);
                }
                zzgq zza = zzgw.zza(context, zzgo.zzlP.zzzH, optString2, null, null);
                optString = zza.zzus;
                optString4 = zza.zzwG;
                j = zza.zzwM;
                zzgq = zza;
            } else if (TextUtils.isEmpty(optString)) {
                zzhx.zzac("Could not parse the mediation config: Missing required ad_base_url field");
                return new zzgq(0);
            } else {
                zzgq = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = zzgq == null ? null : zzgq.zzst;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray.length(); i++) {
                    list4.add(optJSONArray.getString(i));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = zzgq == null ? null : zzgq.zzsu;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray2.length(); i++) {
                    list4.add(optJSONArray2.getString(i));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = zzgq == null ? null : zzgq.zzwK;
            if (optJSONArray3 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray3.length(); i++) {
                    list4.add(optJSONArray3.getString(i));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (zzgq != null) {
                if (zzgq.orientation != -1) {
                    i2 = zzgq.orientation;
                }
                if (zzgq.zzwH > 0) {
                    j2 = zzgq.zzwH;
                }
            }
            String optString7 = jSONObject.optString("active_view");
            String str2 = null;
            boolean optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str2 = jSONObject.optString("ad_passback_url", null);
            }
            return new zzgq(optString, optString4, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i2, optString3, j, optString5, optBoolean, str2, optString7, jSONObject.optBoolean("custom_render_allowed", false), jSONObject.optBoolean("native", false), zzgo.zzwv, jSONObject.optBoolean("content_url_opted_out", false), jSONObject.optBoolean("prefetch", false));
        } catch (JSONException e) {
            zzhx.zzac("Could not parse the mediation config: " + e.getMessage());
            return new zzgq(0);
        }
    }

    public static JSONObject zza(zzgo zzgo, zzhb zzhb, Location location, zzbv zzbv) {
        try {
            Map hashMap = new HashMap();
            Iterable zzbW = zzbv.zzbW();
            if (zzbW.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", zzbW));
            }
            if (zzgo.zzwm != null) {
                hashMap.put("ad_pos", zzgo.zzwm);
            }
            zza((HashMap) hashMap, zzgo.zzwn);
            hashMap.put("format", zzgo.zzlV.zzpa);
            if (zzgo.zzlV.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (zzgo.zzlV.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (zzgo.zzlV.zzpc != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (zzba zzba : zzgo.zzlV.zzpc) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(zzba.width == -1 ? (int) (((float) zzba.widthPixels) / zzhb.zzwz) : zzba.width);
                    stringBuilder.append("x");
                    stringBuilder.append(zzba.height == -2 ? (int) (((float) zzba.heightPixels) / zzhb.zzwz) : zzba.height);
                }
                hashMap.put("sz", stringBuilder);
            }
            if (zzgo.zzwt != 0) {
                hashMap.put("native_version", Integer.valueOf(zzgo.zzwt));
                hashMap.put("native_templates", zzgo.zzmf);
            }
            hashMap.put("slotname", zzgo.zzlM);
            hashMap.put("pn", zzgo.applicationInfo.packageName);
            if (zzgo.zzwo != null) {
                hashMap.put("vc", Integer.valueOf(zzgo.zzwo.versionCode));
            }
            hashMap.put("ms", zzgo.zzwp);
            hashMap.put("seq_num", zzgo.zzwq);
            hashMap.put("session_id", zzgo.zzwr);
            hashMap.put("js", zzgo.zzlP.zzzH);
            zza((HashMap) hashMap, zzhb);
            hashMap.put("fdz", new Integer(zzbv.zzbX()));
            if (zzgo.zzwn.versionCode >= 2 && zzgo.zzwn.zzoT != null) {
                zza((HashMap) hashMap, zzgo.zzwn.zzoT);
            }
            if (zzgo.versionCode >= 2) {
                hashMap.put("quality_signals", zzgo.zzws);
            }
            if (zzgo.versionCode >= 4 && zzgo.zzwv) {
                hashMap.put("forceHttps", Boolean.valueOf(zzgo.zzwv));
            }
            if (zzgo.versionCode >= 4 && zzgo.zzwu != null) {
                hashMap.put("content_info", zzgo.zzwu);
            }
            if (zzgo.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(zzgo.zzwz));
                hashMap.put("sh", Integer.valueOf(zzgo.zzwy));
                hashMap.put("sw", Integer.valueOf(zzgo.zzwx));
            } else {
                hashMap.put("u_sd", Float.valueOf(zzhb.zzwz));
                hashMap.put("sh", Integer.valueOf(zzhb.zzwy));
                hashMap.put("sw", Integer.valueOf(zzhb.zzwx));
            }
            if (zzgo.versionCode >= 6) {
                if (!TextUtils.isEmpty(zzgo.zzwA)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(zzgo.zzwA));
                    } catch (Throwable e) {
                        zzhx.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                if (((Boolean) zzca.zzqL.get()).booleanValue() && zzgo.zzwB) {
                    hashMap.put("ga_hid", Integer.valueOf(zzgo.zzwC));
                    hashMap.put("ga_cid", zzgo.zzwD);
                }
                hashMap.put("correlation_id", Long.valueOf(zzgo.zzwE));
            }
            if (zzgo.versionCode >= 7) {
                hashMap.put("request_id", zzgo.zzwF);
            }
            if (zzhx.zzA(2)) {
                zzhx.zzab("Ad Request JSON: " + zzab.zzaM().zzw(hashMap).toString(2));
            }
            return zzab.zzaM().zzw(hashMap);
        } catch (JSONException e2) {
            zzhx.zzac("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void zza(HashMap<String, Object> hashMap, zzax zzax) {
        String zzep = zzhk.zzep();
        if (zzep != null) {
            hashMap.put("abf", zzep);
        }
        if (zzax.zzoL != -1) {
            hashMap.put("cust_age", zzxu.format(new Date(zzax.zzoL)));
        }
        if (zzax.extras != null) {
            hashMap.put("extras", zzax.extras);
        }
        if (zzax.zzoM != -1) {
            hashMap.put("cust_gender", Integer.valueOf(zzax.zzoM));
        }
        if (zzax.zzoN != null) {
            hashMap.put("kw", zzax.zzoN);
        }
        if (zzax.zzoP != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(zzax.zzoP));
        }
        if (zzax.zzoO) {
            hashMap.put("adtest", "on");
        }
        if (zzax.versionCode >= 2) {
            if (zzax.zzoQ) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(zzax.zzoR)) {
                hashMap.put("ppid", zzax.zzoR);
            }
            if (zzax.zzoS != null) {
                zza((HashMap) hashMap, zzax.zzoS);
            }
        }
        if (zzax.versionCode >= 3 && zzax.zzoU != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, zzax.zzoU);
        }
        if (zzax.versionCode >= 5) {
            if (zzax.zzoW != null) {
                hashMap.put("custom_targeting", zzax.zzoW);
            }
            if (zzax.zzoX != null) {
                hashMap.put("category_exclusions", zzax.zzoX);
            }
            if (zzax.zzoY != null) {
                hashMap.put("request_agent", zzax.zzoY);
            }
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzbs zzbs) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(zzbs.zzpN) != 0) {
            hashMap.put("acolor", zzy(zzbs.zzpN));
        }
        if (Color.alpha(zzbs.backgroundColor) != 0) {
            hashMap.put("bgcolor", zzy(zzbs.backgroundColor));
        }
        if (!(Color.alpha(zzbs.zzpO) == 0 || Color.alpha(zzbs.zzpP) == 0)) {
            hashMap.put("gradientto", zzy(zzbs.zzpO));
            hashMap.put("gradientfrom", zzy(zzbs.zzpP));
        }
        if (Color.alpha(zzbs.zzpQ) != 0) {
            hashMap.put("bcolor", zzy(zzbs.zzpQ));
        }
        hashMap.put("bthick", Integer.toString(zzbs.zzpR));
        switch (zzbs.zzpS) {
            case 0:
                obj = "none";
                break;
            case 1:
                obj = "dashed";
                break;
            case 2:
                obj = "dotted";
                break;
            case 3:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (zzbs.zzpT) {
            case 0:
                obj2 = "light";
                break;
            case 1:
                obj2 = "medium";
                break;
            case 2:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (zzbs.zzpU != null) {
            hashMap.put("channel", zzbs.zzpU);
        }
        if (Color.alpha(zzbs.zzpV) != 0) {
            hashMap.put("dcolor", zzy(zzbs.zzpV));
        }
        if (zzbs.zzpW != null) {
            hashMap.put("font", zzbs.zzpW);
        }
        if (Color.alpha(zzbs.zzpX) != 0) {
            hashMap.put("hcolor", zzy(zzbs.zzpX));
        }
        hashMap.put("headersize", Integer.toString(zzbs.zzpY));
        if (zzbs.zzpZ != null) {
            hashMap.put("q", zzbs.zzpZ);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzhb zzhb) {
        hashMap.put("am", Integer.valueOf(zzhb.zzxY));
        hashMap.put("cog", zzw(zzhb.zzxZ));
        hashMap.put("coh", zzw(zzhb.zzya));
        if (!TextUtils.isEmpty(zzhb.zzyb)) {
            hashMap.put("carrier", zzhb.zzyb);
        }
        hashMap.put("gl", zzhb.zzyc);
        if (zzhb.zzyd) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", zzw(zzhb.zzye));
        hashMap.put("sp", zzw(zzhb.zzyf));
        hashMap.put("hl", zzhb.zzyg);
        if (!TextUtils.isEmpty(zzhb.zzyh)) {
            hashMap.put("mv", zzhb.zzyh);
        }
        hashMap.put("muv", Integer.valueOf(zzhb.zzyi));
        if (zzhb.zzyj != -2) {
            hashMap.put("cnt", Integer.valueOf(zzhb.zzyj));
        }
        hashMap.put("gnt", Integer.valueOf(zzhb.zzyk));
        hashMap.put("pt", Integer.valueOf(zzhb.zzyl));
        hashMap.put("rm", Integer.valueOf(zzhb.zzym));
        hashMap.put("riv", Integer.valueOf(zzhb.zzyn));
        Bundle bundle = new Bundle();
        bundle.putInt("active_network_state", zzhb.zzyr);
        bundle.putBoolean("active_network_metered", zzhb.zzyq);
        hashMap.put("connectivity", bundle);
        bundle = new Bundle();
        bundle.putBoolean("is_charging", zzhb.zzyp);
        bundle.putDouble("battery_level", zzhb.zzyo);
        hashMap.put("battery", bundle);
    }

    private static Integer zzw(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String zzy(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK & i)});
    }
}
