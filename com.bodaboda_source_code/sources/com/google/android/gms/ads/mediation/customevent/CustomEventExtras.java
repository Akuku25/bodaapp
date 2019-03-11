package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> zzAw = new HashMap();

    public Object getExtra(String label) {
        return this.zzAw.get(label);
    }

    public void setExtra(String label, Object value) {
        this.zzAw.put(label, value);
    }
}
