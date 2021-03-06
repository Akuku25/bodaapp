package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzs;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Product {
    Map<String, String> zzFz = new HashMap();

    void put(String name, String value) {
        zzx.zzb((Object) name, (Object) "Name should be non-null");
        this.zzFz.put(name, value);
    }

    public Product setBrand(String value) {
        put("br", value);
        return this;
    }

    public Product setCategory(String value) {
        put("ca", value);
        return this;
    }

    public Product setCouponCode(String value) {
        put("cc", value);
        return this;
    }

    public Product setCustomDimension(int index, String value) {
        put(zzs.zzK(index), value);
        return this;
    }

    public Product setCustomMetric(int index, int value) {
        put(zzs.zzL(index), Integer.toString(value));
        return this;
    }

    public Product setId(String value) {
        put("id", value);
        return this;
    }

    public Product setName(String value) {
        put("nm", value);
        return this;
    }

    public Product setPosition(int value) {
        put("ps", Integer.toString(value));
        return this;
    }

    public Product setPrice(double value) {
        put("pr", Double.toString(value));
        return this;
    }

    public Product setQuantity(int value) {
        put("qt", Integer.toString(value));
        return this;
    }

    public Product setVariant(String value) {
        put("va", value);
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
