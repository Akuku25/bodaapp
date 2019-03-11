package com.google.android.gms.internal;

import java.io.IOException;

public final class zzwo extends zzws<zzwo> {
    public String[] zzaHl;
    public int[] zzaHm;
    public byte[][] zzaHn;

    public zzwo() {
        zzvt();
    }

    public static zzwo zzr(byte[] bArr) throws zzwx {
        return (zzwo) zzwy.zza(new zzwo(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzwo)) {
            return false;
        }
        zzwo zzwo = (zzwo) o;
        return (zzww.equals(this.zzaHl, zzwo.zzaHl) && zzww.equals(this.zzaHm, zzwo.zzaHm) && zzww.zza(this.zzaHn, zzwo.zzaHn)) ? zza((zzws) zzwo) : false;
    }

    public int hashCode() {
        return ((((((zzww.hashCode(this.zzaHl) + 527) * 31) + zzww.hashCode(this.zzaHm)) * 31) + zzww.zza(this.zzaHn)) * 31) + zzvL();
    }

    public void zza(zzwr zzwr) throws IOException {
        int i = 0;
        if (this.zzaHl != null && this.zzaHl.length > 0) {
            for (String str : this.zzaHl) {
                if (str != null) {
                    zzwr.zzb(1, str);
                }
            }
        }
        if (this.zzaHm != null && this.zzaHm.length > 0) {
            for (int zzy : this.zzaHm) {
                zzwr.zzy(2, zzy);
            }
        }
        if (this.zzaHn != null && this.zzaHn.length > 0) {
            while (i < this.zzaHn.length) {
                byte[] bArr = this.zzaHn[i];
                if (bArr != null) {
                    zzwr.zza(3, bArr);
                }
                i++;
            }
        }
        super.zza(zzwr);
    }

    public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
        return zzy(zzwq);
    }

    protected int zzc() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int zzc = super.zzc();
        if (this.zzaHl == null || this.zzaHl.length <= 0) {
            i = zzc;
        } else {
            i2 = 0;
            i3 = 0;
            for (String str : this.zzaHl) {
                if (str != null) {
                    i3++;
                    i2 += zzwr.zzdM(str);
                }
            }
            i = (zzc + i2) + (i3 * 1);
        }
        if (this.zzaHm != null && this.zzaHm.length > 0) {
            i3 = 0;
            for (int zzc2 : this.zzaHm) {
                i3 += zzwr.zziw(zzc2);
            }
            i = (i + i3) + (this.zzaHm.length * 1);
        }
        if (this.zzaHn == null || this.zzaHn.length <= 0) {
            return i;
        }
        i2 = 0;
        i3 = 0;
        while (i4 < this.zzaHn.length) {
            byte[] bArr = this.zzaHn[i4];
            if (bArr != null) {
                i3++;
                i2 += zzwr.zzw(bArr);
            }
            i4++;
        }
        return (i + i2) + (i3 * 1);
    }

    public zzwo zzvt() {
        this.zzaHl = zzxb.zzaHT;
        this.zzaHm = zzxb.zzaHO;
        this.zzaHn = zzxb.zzaHU;
        this.zzaHB = null;
        this.zzaHM = -1;
        return this;
    }

    public zzwo zzy(zzwq zzwq) throws IOException {
        while (true) {
            int zzvu = zzwq.zzvu();
            int zzc;
            Object obj;
            switch (zzvu) {
                case 0:
                    break;
                case 10:
                    zzc = zzxb.zzc(zzwq, 10);
                    zzvu = this.zzaHl == null ? 0 : this.zzaHl.length;
                    obj = new String[(zzc + zzvu)];
                    if (zzvu != 0) {
                        System.arraycopy(this.zzaHl, 0, obj, 0, zzvu);
                    }
                    while (zzvu < obj.length - 1) {
                        obj[zzvu] = zzwq.readString();
                        zzwq.zzvu();
                        zzvu++;
                    }
                    obj[zzvu] = zzwq.readString();
                    this.zzaHl = obj;
                    continue;
                case 16:
                    zzc = zzxb.zzc(zzwq, 16);
                    zzvu = this.zzaHm == null ? 0 : this.zzaHm.length;
                    obj = new int[(zzc + zzvu)];
                    if (zzvu != 0) {
                        System.arraycopy(this.zzaHm, 0, obj, 0, zzvu);
                    }
                    while (zzvu < obj.length - 1) {
                        obj[zzvu] = zzwq.zzvx();
                        zzwq.zzvu();
                        zzvu++;
                    }
                    obj[zzvu] = zzwq.zzvx();
                    this.zzaHm = obj;
                    continue;
                case 18:
                    int zzip = zzwq.zzip(zzwq.zzvB());
                    zzc = zzwq.getPosition();
                    zzvu = 0;
                    while (zzwq.zzvG() > 0) {
                        zzwq.zzvx();
                        zzvu++;
                    }
                    zzwq.zzir(zzc);
                    zzc = this.zzaHm == null ? 0 : this.zzaHm.length;
                    Object obj2 = new int[(zzvu + zzc)];
                    if (zzc != 0) {
                        System.arraycopy(this.zzaHm, 0, obj2, 0, zzc);
                    }
                    while (zzc < obj2.length) {
                        obj2[zzc] = zzwq.zzvx();
                        zzc++;
                    }
                    this.zzaHm = obj2;
                    zzwq.zziq(zzip);
                    continue;
                case 26:
                    zzc = zzxb.zzc(zzwq, 26);
                    zzvu = this.zzaHn == null ? 0 : this.zzaHn.length;
                    obj = new byte[(zzc + zzvu)][];
                    if (zzvu != 0) {
                        System.arraycopy(this.zzaHn, 0, obj, 0, zzvu);
                    }
                    while (zzvu < obj.length - 1) {
                        obj[zzvu] = zzwq.readBytes();
                        zzwq.zzvu();
                        zzvu++;
                    }
                    obj[zzvu] = zzwq.readBytes();
                    this.zzaHn = obj;
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
