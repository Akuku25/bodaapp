package com.google.android.gms.internal;

import com.google.android.gms.internal.zzia.zzd;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzgi
public class zzib<T> implements zzia<T> {
    private final Object zznh = new Object();
    protected int zzrX = 0;
    protected final BlockingQueue<zza> zzzL = new LinkedBlockingQueue();
    protected T zzzM;

    class zza {
        public final zzd<T> zzzN;
        public final com.google.android.gms.internal.zzia.zza zzzO;
        final /* synthetic */ zzib zzzP;

        public zza(zzib zzib, zzd<T> zzd, com.google.android.gms.internal.zzia.zza zza) {
            this.zzzP = zzib;
            this.zzzN = zzd;
            this.zzzO = zza;
        }
    }

    public int getStatus() {
        return this.zzrX;
    }

    public void reject() {
        synchronized (this.zznh) {
            if (this.zzrX != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzrX = -1;
            for (zza zza : this.zzzL) {
                zza.zzzO.run();
            }
        }
    }

    public void zza(zzd<T> zzd, com.google.android.gms.internal.zzia.zza zza) {
        synchronized (this.zznh) {
            if (this.zzrX == 1) {
                zzd.zza(this.zzzM);
            } else if (this.zzrX == -1) {
                zza.run();
            } else if (this.zzrX == 0) {
                this.zzzL.add(new zza(this, zzd, zza));
            }
        }
    }

    public void zzc(T t) {
        synchronized (this.zznh) {
            if (this.zzrX != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzzM = t;
            this.zzrX = 1;
            for (zza zza : this.zzzL) {
                zza.zzzN.zza(t);
            }
        }
    }
}
