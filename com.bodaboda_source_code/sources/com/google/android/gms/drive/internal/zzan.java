package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzwq;
import com.google.android.gms.internal.zzwr;
import com.google.android.gms.internal.zzws;
import com.google.android.gms.internal.zzwx;
import com.google.android.gms.internal.zzwy;
import java.io.IOException;

public final class zzan extends zzws<zzan> {
    public int versionCode;
    public long zzUG;
    public String zzUI;
    public long zzUJ;
    public int zzUK;

    public zzan() {
        zzkK();
    }

    public static zzan zzh(byte[] bArr) throws zzwx {
        return (zzan) zzwy.zza(new zzan(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzan)) {
            return false;
        }
        zzan zzan = (zzan) o;
        if (this.versionCode != zzan.versionCode) {
            return false;
        }
        if (this.zzUI == null) {
            if (zzan.zzUI != null) {
                return false;
            }
        } else if (!this.zzUI.equals(zzan.zzUI)) {
            return false;
        }
        return (this.zzUJ == zzan.zzUJ && this.zzUG == zzan.zzUG && this.zzUK == zzan.zzUK) ? zza((zzws) zzan) : false;
    }

    public int hashCode() {
        return (((((((((this.zzUI == null ? 0 : this.zzUI.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.zzUJ ^ (this.zzUJ >>> 32)))) * 31) + ((int) (this.zzUG ^ (this.zzUG >>> 32)))) * 31) + this.zzUK) * 31) + zzvL();
    }

    public void zza(zzwr zzwr) throws IOException {
        zzwr.zzy(1, this.versionCode);
        zzwr.zzb(2, this.zzUI);
        zzwr.zzc(3, this.zzUJ);
        zzwr.zzc(4, this.zzUG);
        if (this.zzUK != -1) {
            zzwr.zzy(5, this.zzUK);
        }
        super.zza(zzwr);
    }

    public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
        return zzn(zzwq);
    }

    protected int zzc() {
        int zzc = (((super.zzc() + zzwr.zzA(1, this.versionCode)) + zzwr.zzj(2, this.zzUI)) + zzwr.zze(3, this.zzUJ)) + zzwr.zze(4, this.zzUG);
        return this.zzUK != -1 ? zzc + zzwr.zzA(5, this.zzUK) : zzc;
    }

    public zzan zzkK() {
        this.versionCode = 1;
        this.zzUI = "";
        this.zzUJ = -1;
        this.zzUG = -1;
        this.zzUK = -1;
        this.zzaHB = null;
        this.zzaHM = -1;
        return this;
    }

    public zzan zzn(zzwq zzwq) throws IOException {
        while (true) {
            int zzvu = zzwq.zzvu();
            switch (zzvu) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzwq.zzvx();
                    continue;
                case 18:
                    this.zzUI = zzwq.readString();
                    continue;
                case 24:
                    this.zzUJ = zzwq.zzvA();
                    continue;
                case 32:
                    this.zzUG = zzwq.zzvA();
                    continue;
                case 40:
                    this.zzUK = zzwq.zzvx();
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
