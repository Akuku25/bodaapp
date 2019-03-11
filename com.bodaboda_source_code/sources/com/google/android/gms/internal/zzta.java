package com.google.android.gms.internal;

public final class zzta {
    private final String zzFr;
    private final boolean zzatB;
    private final boolean zzatC;
    private final String zzatD;

    public static final class zza {
        private String zzFr;
        private boolean zzatB = true;
        private boolean zzatC = false;
        private final String zzatD;

        public zza(String str) {
            this.zzatD = str;
        }

        public zza zzab(boolean z) {
            this.zzatB = z;
            return this;
        }

        public zza zzac(boolean z) {
            this.zzatC = z;
            return this;
        }

        public zza zzcA(String str) {
            this.zzFr = str;
            return this;
        }

        public zzta zzrA() {
            return new zzta();
        }
    }

    private zzta(zza zza) {
        this.zzatD = zza.zzatD;
        this.zzatB = zza.zzatB;
        this.zzatC = zza.zzatC;
        this.zzFr = zza.zzFr;
    }

    public String zzgL() {
        return this.zzFr;
    }

    public String zzrx() {
        return this.zzatD;
    }

    public boolean zzry() {
        return this.zzatB;
    }

    public boolean zzrz() {
        return this.zzatC;
    }
}
