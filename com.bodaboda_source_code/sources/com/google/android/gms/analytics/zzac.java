package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzac {
    public static String encode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }

    static Map<String, String> zzC(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                CharSequence substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }

    public static String zza(zzab zzab, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(zzab.zzgr());
        if (zzab.zzgt() > 0) {
            long zzgt = j - zzab.zzgt();
            if (zzgt >= 0) {
                stringBuilder.append("&qt").append("=").append(zzgt);
            }
        }
        stringBuilder.append("&z").append("=").append(zzab.zzgs());
        return stringBuilder.toString();
    }
}
