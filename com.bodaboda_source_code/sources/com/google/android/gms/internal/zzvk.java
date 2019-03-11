package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzvl.zzc;

public class zzvk implements Result {
    private final zza zzaBZ;

    public static class zza {
        private final Status zzHb;
        private final zza zzaCa;
        private final byte[] zzaCb;
        private final long zzaCc;
        private final zzve zzaCd;
        private final zzc zzaCe;

        public enum zza {
            NETWORK,
            DISK,
            DEFAULT
        }

        public zza(Status status, zzve zzve, zza zza) {
            this(status, zzve, null, null, zza, 0);
        }

        public zza(Status status, zzve zzve, byte[] bArr, zzc zzc, zza zza, long j) {
            this.zzHb = status;
            this.zzaCd = zzve;
            this.zzaCb = bArr;
            this.zzaCe = zzc;
            this.zzaCa = zza;
            this.zzaCc = j;
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public zza zzup() {
            return this.zzaCa;
        }

        public byte[] zzuq() {
            return this.zzaCb;
        }

        public zzve zzur() {
            return this.zzaCd;
        }

        public zzc zzus() {
            return this.zzaCe;
        }

        public long zzut() {
            return this.zzaCc;
        }
    }

    public zzvk(zza zza) {
        this.zzaBZ = zza;
    }

    public Status getStatus() {
        return this.zzaBZ.getStatus();
    }

    public zza zzuo() {
        return this.zzaBZ;
    }
}
