package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzkg {
    private static final zzkc zzKh = new zzkc("RequestTracker");
    public static final Object zzLm = new Object();
    private long zzLi;
    private long zzLj = -1;
    private long zzLk = 0;
    private zzkf zzLl;

    public zzkg(long j) {
        this.zzLi = j;
    }

    private void zzhH() {
        this.zzLj = -1;
        this.zzLl = null;
        this.zzLk = 0;
    }

    public void zza(long j, zzkf zzkf) {
        synchronized (zzLm) {
            zzkf zzkf2 = this.zzLl;
            long j2 = this.zzLj;
            this.zzLj = j;
            this.zzLl = zzkf;
            this.zzLk = SystemClock.elapsedRealtime();
        }
        if (zzkf2 != null) {
            zzkf2.zzn(j2);
        }
    }

    public boolean zzb(long j, int i, Object obj) {
        boolean z = true;
        zzkf zzkf = null;
        synchronized (zzLm) {
            if (this.zzLj == -1 || this.zzLj != j) {
                z = false;
            } else {
                zzKh.zzb("request %d completed", Long.valueOf(this.zzLj));
                zzkf = this.zzLl;
                zzhH();
            }
        }
        if (zzkf != null) {
            zzkf.zza(j, i, obj);
        }
        return z;
    }

    public boolean zzc(long j, int i) {
        return zzb(j, i, null);
    }

    public boolean zzd(long j, int i) {
        zzkf zzkf;
        boolean z = true;
        long j2 = 0;
        synchronized (zzLm) {
            if (this.zzLj == -1 || j - this.zzLk < this.zzLi) {
                z = false;
                zzkf = null;
            } else {
                zzKh.zzb("request %d timed out", Long.valueOf(this.zzLj));
                j2 = this.zzLj;
                zzkf = this.zzLl;
                zzhH();
            }
        }
        if (zzkf != null) {
            zzkf.zza(j2, i, null);
        }
        return z;
    }

    public boolean zzhI() {
        boolean z;
        synchronized (zzLm) {
            z = this.zzLj != -1;
        }
        return z;
    }

    public boolean zzq(long j) {
        boolean z;
        synchronized (zzLm) {
            z = this.zzLj != -1 && this.zzLj == j;
        }
        return z;
    }
}
