package com.google.android.gms.internal;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zzlr {
    private final long zzRK;
    private final int zzRL;
    private final SimpleArrayMap<Long, Long> zzRM;

    public zzlr() {
        this.zzRK = 60000;
        this.zzRL = 10;
        this.zzRM = new SimpleArrayMap(10);
    }

    public zzlr(int i, long j) {
        this.zzRK = j;
        this.zzRL = i;
        this.zzRM = new SimpleArrayMap();
    }

    private void zzc(long j, long j2) {
        for (int size = this.zzRM.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.zzRM.valueAt(size)).longValue() > j) {
                this.zzRM.removeAt(size);
            }
        }
    }

    public Long zza(Long l) {
        Long l2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzRK;
        synchronized (this) {
            while (this.zzRM.size() >= this.zzRL) {
                zzc(j, elapsedRealtime);
                j /= 2;
                Log.w("PassiveTimedConnectionMap", "The max capacity " + this.zzRL + " is not enough. Current durationThreshold is: " + j);
            }
            l2 = (Long) this.zzRM.put(l, Long.valueOf(elapsedRealtime));
        }
        return l2;
    }

    public boolean zzr(long j) {
        boolean z;
        synchronized (this) {
            z = this.zzRM.remove(Long.valueOf(j)) != null;
        }
        return z;
    }
}
