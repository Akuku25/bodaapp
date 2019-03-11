package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzxa {
    final int tag;
    final byte[] zzaHN;

    zzxa(int i, byte[] bArr) {
        this.tag = i;
        this.zzaHN = bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzxa)) {
            return false;
        }
        zzxa zzxa = (zzxa) o;
        return this.tag == zzxa.tag && Arrays.equals(this.zzaHN, zzxa.zzaHN);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzaHN);
    }

    void zza(zzwr zzwr) throws IOException {
        zzwr.zziA(this.tag);
        zzwr.zzx(this.zzaHN);
    }

    int zzc() {
        return (0 + zzwr.zziB(this.tag)) + this.zzaHN.length;
    }
}
