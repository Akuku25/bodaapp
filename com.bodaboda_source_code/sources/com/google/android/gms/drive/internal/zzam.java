package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzwq;
import com.google.android.gms.internal.zzwr;
import com.google.android.gms.internal.zzws;
import com.google.android.gms.internal.zzwy;
import java.io.IOException;

public final class zzam extends zzws<zzam> {
    public int versionCode;
    public long zzUF;
    public long zzUG;
    public long zzUH;

    public zzam() {
        zzkJ();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzam)) {
            return false;
        }
        zzam zzam = (zzam) o;
        return (this.versionCode == zzam.versionCode && this.zzUF == zzam.zzUF && this.zzUG == zzam.zzUG && this.zzUH == zzam.zzUH) ? zza((zzws) zzam) : false;
    }

    public int hashCode() {
        return ((((((((this.versionCode + 527) * 31) + ((int) (this.zzUF ^ (this.zzUF >>> 32)))) * 31) + ((int) (this.zzUG ^ (this.zzUG >>> 32)))) * 31) + ((int) (this.zzUH ^ (this.zzUH >>> 32)))) * 31) + zzvL();
    }

    public void zza(zzwr zzwr) throws IOException {
        zzwr.zzy(1, this.versionCode);
        zzwr.zzc(2, this.zzUF);
        zzwr.zzc(3, this.zzUG);
        zzwr.zzc(4, this.zzUH);
        super.zza(zzwr);
    }

    public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
        return zzm(zzwq);
    }

    protected int zzc() {
        return (((super.zzc() + zzwr.zzA(1, this.versionCode)) + zzwr.zze(2, this.zzUF)) + zzwr.zze(3, this.zzUG)) + zzwr.zze(4, this.zzUH);
    }

    public zzam zzkJ() {
        this.versionCode = 1;
        this.zzUF = -1;
        this.zzUG = -1;
        this.zzUH = -1;
        this.zzaHB = null;
        this.zzaHM = -1;
        return this;
    }

    public zzam zzm(zzwq zzwq) throws IOException {
        while (true) {
            int zzvu = zzwq.zzvu();
            switch (zzvu) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzwq.zzvx();
                    continue;
                case 16:
                    this.zzUF = zzwq.zzvA();
                    continue;
                case 24:
                    this.zzUG = zzwq.zzvA();
                    continue;
                case 32:
                    this.zzUH = zzwq.zzvA();
                    continue;
                default:
                    if (!zza(zzwq, zzvu)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
