package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzlx implements zzlv {
    private static zzlx zzRO;

    public static synchronized zzlv zzkc() {
        zzlv zzlv;
        synchronized (zzlx.class) {
            if (zzRO == null) {
                zzRO = new zzlx();
            }
            zzlv = zzRO;
        }
        return zzlv;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
