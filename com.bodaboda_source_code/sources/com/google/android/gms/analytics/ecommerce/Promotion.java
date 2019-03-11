package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    Map<String, String> zzFz = new HashMap();

    void put(String name, String value) {
        zzx.zzb((Object) name, (Object) "Name should be non-null");
        this.zzFz.put(name, value);
    }

    public Promotion setCreative(String value) {
        put("cr", value);
        return this;
    }

    public Promotion setId(String value) {
        put("id", value);
        return this;
    }

    public Promotion setName(String value) {
        put("nm", value);
        return this;
    }

    public Promotion setPosition(String value) {
        put("ps", value);
        return this;
    }

    public Map<String, String> zzaw(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.zzFz.entrySet()) {
            hashMap.put(str + ((String) entry.getKey()), entry.getValue());
        }
        return hashMap;
    }
}
