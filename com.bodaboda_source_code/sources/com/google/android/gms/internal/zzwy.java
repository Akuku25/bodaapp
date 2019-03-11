package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzwy {
    protected volatile int zzaHM = -1;

    public static final <T extends zzwy> T zza(T t, byte[] bArr) throws zzwx {
        return zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzwy zzwy, byte[] bArr, int i, int i2) {
        try {
            zzwr zzb = zzwr.zzb(bArr, i, i2);
            zzwy.zza(zzb);
            zzb.zzvK();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzwy> T zzb(T t, byte[] bArr, int i, int i2) throws zzwx {
        try {
            zzwq zza = zzwq.zza(bArr, i, i2);
            t.zzb(zza);
            zza.zzim(0);
            return t;
        } catch (zzwx e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] zzf(zzwy zzwy) {
        byte[] bArr = new byte[zzwy.zzvY()];
        zza(zzwy, bArr, 0, bArr.length);
        return bArr;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzvN();
    }

    public String toString() {
        return zzwz.zzg(this);
    }

    public void zza(zzwr zzwr) throws IOException {
    }

    public abstract zzwy zzb(zzwq zzwq) throws IOException;

    protected int zzc() {
        return 0;
    }

    public zzwy zzvN() throws CloneNotSupportedException {
        return (zzwy) super.clone();
    }

    public int zzvX() {
        if (this.zzaHM < 0) {
            zzvY();
        }
        return this.zzaHM;
    }

    public int zzvY() {
        int zzc = zzc();
        this.zzaHM = zzc;
        return zzc;
    }
}
