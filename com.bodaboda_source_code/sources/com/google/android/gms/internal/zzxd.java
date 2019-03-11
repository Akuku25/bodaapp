package com.google.android.gms.internal;

import com.google.android.gms.internal.zzxc.zzf;
import com.google.android.gms.location.places.Place;
import java.io.IOException;

public interface zzxd {

    public static final class zza extends zzwy {
        public long zzaIq;
        public long zzaIr;
        public int zzaIs;
        public com.google.android.gms.internal.zzxe.zza zzaIt;
        public int zzaIu;
        public zzc[] zzaIv;
        public int zzaIw;
        public boolean zzaIx;
        public com.google.android.gms.internal.zzxc.zzb[] zzaIy;

        public zza() {
            zzwi();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.zzaIq != zza.zzaIq) {
                return false;
            }
            if (this.zzaIr != zza.zzaIr) {
                return false;
            }
            if (this.zzaIs != zza.zzaIs) {
                return false;
            }
            if (this.zzaIt == null) {
                if (zza.zzaIt != null) {
                    return false;
                }
            } else if (!this.zzaIt.equals(zza.zzaIt)) {
                return false;
            }
            if (this.zzaIu != zza.zzaIu) {
                return false;
            }
            if (!zzww.equals(this.zzaIv, zza.zzaIv)) {
                return false;
            }
            if (this.zzaIw != zza.zzaIw) {
                return false;
            }
            if (this.zzaIx != zza.zzaIx) {
                return false;
            }
            return zzww.equals(this.zzaIy, zza.zzaIy);
        }

        public int hashCode() {
            return (((this.zzaIx ? 1231 : 1237) + (((((((((this.zzaIt == null ? 0 : this.zzaIt.hashCode()) + ((((((((int) (this.zzaIq ^ (this.zzaIq >>> 32))) + 527) * 31) + ((int) (this.zzaIr ^ (this.zzaIr >>> 32)))) * 31) + this.zzaIs) * 31)) * 31) + this.zzaIu) * 31) + zzww.hashCode(this.zzaIv)) * 31) + this.zzaIw) * 31)) * 31) + zzww.hashCode(this.zzaIy);
        }

        public zza zzG(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                int zzc;
                Object obj;
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaIq = zzwq.zzvw();
                        continue;
                    case 16:
                        this.zzaIr = zzwq.zzvw();
                        continue;
                    case 24:
                        this.zzaIs = zzwq.zzvx();
                        continue;
                    case 34:
                        if (this.zzaIt == null) {
                            this.zzaIt = new com.google.android.gms.internal.zzxe.zza();
                        }
                        zzwq.zza(this.zzaIt);
                        continue;
                    case 40:
                        this.zzaIu = zzwq.zzvx();
                        continue;
                    case 50:
                        zzc = zzxb.zzc(zzwq, 50);
                        zzvu = this.zzaIv == null ? 0 : this.zzaIv.length;
                        obj = new zzc[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIv, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzc();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzc();
                        zzwq.zza(obj[zzvu]);
                        this.zzaIv = obj;
                        continue;
                    case 56:
                        zzvu = zzwq.zzvx();
                        switch (zzvu) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.zzaIw = zzvu;
                                break;
                            default:
                                continue;
                        }
                    case 64:
                        this.zzaIx = zzwq.zzvy();
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        zzc = zzxb.zzc(zzwq, 74);
                        zzvu = this.zzaIy == null ? 0 : this.zzaIy.length;
                        obj = new com.google.android.gms.internal.zzxc.zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIy, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new com.google.android.gms.internal.zzxc.zzb();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new com.google.android.gms.internal.zzxc.zzb();
                        zzwq.zza(obj[zzvu]);
                        this.zzaIy = obj;
                        continue;
                    default:
                        if (!zzxb.zzb(zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr zzwr) throws IOException {
            int i = 0;
            if (this.zzaIq != 0) {
                zzwr.zzb(1, this.zzaIq);
            }
            if (this.zzaIr != 0) {
                zzwr.zzb(2, this.zzaIr);
            }
            if (this.zzaIs != 0) {
                zzwr.zzy(3, this.zzaIs);
            }
            if (this.zzaIt != null) {
                zzwr.zza(4, this.zzaIt);
            }
            if (this.zzaIu != 0) {
                zzwr.zzy(5, this.zzaIu);
            }
            if (this.zzaIv != null && this.zzaIv.length > 0) {
                for (zzwy zzwy : this.zzaIv) {
                    if (zzwy != null) {
                        zzwr.zza(6, zzwy);
                    }
                }
            }
            if (this.zzaIw != 0) {
                zzwr.zzy(7, this.zzaIw);
            }
            if (this.zzaIx) {
                zzwr.zzb(8, this.zzaIx);
            }
            if (this.zzaIy != null && this.zzaIy.length > 0) {
                while (i < this.zzaIy.length) {
                    zzwy zzwy2 = this.zzaIy[i];
                    if (zzwy2 != null) {
                        zzwr.zza(9, zzwy2);
                    }
                    i++;
                }
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzG(zzwq);
        }

        protected int zzc() {
            int i = 0;
            int zzc = super.zzc();
            if (this.zzaIq != 0) {
                zzc += zzwr.zzd(1, this.zzaIq);
            }
            if (this.zzaIr != 0) {
                zzc += zzwr.zzd(2, this.zzaIr);
            }
            if (this.zzaIs != 0) {
                zzc += zzwr.zzA(3, this.zzaIs);
            }
            if (this.zzaIt != null) {
                zzc += zzwr.zzc(4, this.zzaIt);
            }
            if (this.zzaIu != 0) {
                zzc += zzwr.zzA(5, this.zzaIu);
            }
            if (this.zzaIv != null && this.zzaIv.length > 0) {
                int i2 = zzc;
                for (zzwy zzwy : this.zzaIv) {
                    if (zzwy != null) {
                        i2 += zzwr.zzc(6, zzwy);
                    }
                }
                zzc = i2;
            }
            if (this.zzaIw != 0) {
                zzc += zzwr.zzA(7, this.zzaIw);
            }
            if (this.zzaIx) {
                zzc += zzwr.zzc(8, this.zzaIx);
            }
            if (this.zzaIy != null && this.zzaIy.length > 0) {
                while (i < this.zzaIy.length) {
                    zzwy zzwy2 = this.zzaIy[i];
                    if (zzwy2 != null) {
                        zzc += zzwr.zzc(9, zzwy2);
                    }
                    i++;
                }
            }
            return zzc;
        }

        public zza zzwi() {
            this.zzaIq = 0;
            this.zzaIr = 0;
            this.zzaIs = 0;
            this.zzaIt = null;
            this.zzaIu = 0;
            this.zzaIv = zzc.zzwl();
            this.zzaIw = 0;
            this.zzaIx = false;
            this.zzaIy = com.google.android.gms.internal.zzxc.zzb.zzwa();
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzb extends zzwy {
        private static volatile zzb[] zzaIz;
        public long zzaIA;
        public long zzaIB;
        public zzf[] zzaIC;
        public int zzaID;
        public com.google.android.gms.internal.zzxc.zzb zzaIE;
        public int zzaIF;
        public com.google.android.gms.internal.zzxc.zzb zzaIG;
        public long zzaIH;
        public long zzaII;

        public zzb() {
            zzwk();
        }

        public static zzb[] zzwj() {
            if (zzaIz == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaIz == null) {
                        zzaIz = new zzb[0];
                    }
                }
            }
            return zzaIz;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.zzaIA != zzb.zzaIA) {
                return false;
            }
            if (this.zzaIB != zzb.zzaIB) {
                return false;
            }
            if (!zzww.equals(this.zzaIC, zzb.zzaIC)) {
                return false;
            }
            if (this.zzaID != zzb.zzaID) {
                return false;
            }
            if (this.zzaIE == null) {
                if (zzb.zzaIE != null) {
                    return false;
                }
            } else if (!this.zzaIE.equals(zzb.zzaIE)) {
                return false;
            }
            if (this.zzaIF != zzb.zzaIF) {
                return false;
            }
            if (this.zzaIG == null) {
                if (zzb.zzaIG != null) {
                    return false;
                }
            } else if (!this.zzaIG.equals(zzb.zzaIG)) {
                return false;
            }
            if (this.zzaIH != zzb.zzaIH) {
                return false;
            }
            return this.zzaII == zzb.zzaII;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzaIE == null ? 0 : this.zzaIE.hashCode()) + ((((((((((int) (this.zzaIA ^ (this.zzaIA >>> 32))) + 527) * 31) + ((int) (this.zzaIB ^ (this.zzaIB >>> 32)))) * 31) + zzww.hashCode(this.zzaIC)) * 31) + this.zzaID) * 31)) * 31) + this.zzaIF) * 31;
            if (this.zzaIG != null) {
                i = this.zzaIG.hashCode();
            }
            return ((((hashCode + i) * 31) + ((int) (this.zzaIH ^ (this.zzaIH >>> 32)))) * 31) + ((int) (this.zzaII ^ (this.zzaII >>> 32)));
        }

        public zzb zzH(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaIA = zzwq.zzvw();
                        continue;
                    case 16:
                        this.zzaIB = zzwq.zzvw();
                        continue;
                    case 26:
                        int zzc = zzxb.zzc(zzwq, 26);
                        zzvu = this.zzaIC == null ? 0 : this.zzaIC.length;
                        Object obj = new zzf[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIC, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzf();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzf();
                        zzwq.zza(obj[zzvu]);
                        this.zzaIC = obj;
                        continue;
                    case 32:
                        this.zzaID = zzwq.zzvx();
                        continue;
                    case 42:
                        if (this.zzaIE == null) {
                            this.zzaIE = new com.google.android.gms.internal.zzxc.zzb();
                        }
                        zzwq.zza(this.zzaIE);
                        continue;
                    case 48:
                        this.zzaIF = zzwq.zzvx();
                        continue;
                    case 58:
                        if (this.zzaIG == null) {
                            this.zzaIG = new com.google.android.gms.internal.zzxc.zzb();
                        }
                        zzwq.zza(this.zzaIG);
                        continue;
                    case 64:
                        this.zzaIH = zzwq.zzvw();
                        continue;
                    case Place.TYPE_PHARMACY /*72*/:
                        this.zzaII = zzwq.zzvw();
                        continue;
                    default:
                        if (!zzxb.zzb(zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr zzwr) throws IOException {
            if (this.zzaIA != 0) {
                zzwr.zzb(1, this.zzaIA);
            }
            if (this.zzaIB != 0) {
                zzwr.zzb(2, this.zzaIB);
            }
            if (this.zzaIC != null && this.zzaIC.length > 0) {
                for (zzwy zzwy : this.zzaIC) {
                    if (zzwy != null) {
                        zzwr.zza(3, zzwy);
                    }
                }
            }
            if (this.zzaID != 0) {
                zzwr.zzy(4, this.zzaID);
            }
            if (this.zzaIE != null) {
                zzwr.zza(5, this.zzaIE);
            }
            if (this.zzaIF != 0) {
                zzwr.zzy(6, this.zzaIF);
            }
            if (this.zzaIG != null) {
                zzwr.zza(7, this.zzaIG);
            }
            if (this.zzaIH != 0) {
                zzwr.zzb(8, this.zzaIH);
            }
            if (this.zzaII != 0) {
                zzwr.zzb(9, this.zzaII);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzH(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaIA != 0) {
                zzc += zzwr.zzd(1, this.zzaIA);
            }
            if (this.zzaIB != 0) {
                zzc += zzwr.zzd(2, this.zzaIB);
            }
            if (this.zzaIC != null && this.zzaIC.length > 0) {
                int i = zzc;
                for (zzwy zzwy : this.zzaIC) {
                    if (zzwy != null) {
                        i += zzwr.zzc(3, zzwy);
                    }
                }
                zzc = i;
            }
            if (this.zzaID != 0) {
                zzc += zzwr.zzA(4, this.zzaID);
            }
            if (this.zzaIE != null) {
                zzc += zzwr.zzc(5, this.zzaIE);
            }
            if (this.zzaIF != 0) {
                zzc += zzwr.zzA(6, this.zzaIF);
            }
            if (this.zzaIG != null) {
                zzc += zzwr.zzc(7, this.zzaIG);
            }
            if (this.zzaIH != 0) {
                zzc += zzwr.zzd(8, this.zzaIH);
            }
            return this.zzaII != 0 ? zzc + zzwr.zzd(9, this.zzaII) : zzc;
        }

        public zzb zzwk() {
            this.zzaIA = 0;
            this.zzaIB = 0;
            this.zzaIC = zzf.zzwg();
            this.zzaID = 0;
            this.zzaIE = null;
            this.zzaIF = 0;
            this.zzaIG = null;
            this.zzaIH = 0;
            this.zzaII = 0;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzc extends zzwy {
        private static volatile zzc[] zzaIJ;
        public int zzaID;
        public com.google.android.gms.internal.zzxc.zzb zzaIE;
        public zzb[] zzaIK;
        public boolean zzaIx;

        public zzc() {
            zzwm();
        }

        public static zzc[] zzwl() {
            if (zzaIJ == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaIJ == null) {
                        zzaIJ = new zzc[0];
                    }
                }
            }
            return zzaIJ;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (this.zzaID != zzc.zzaID) {
                return false;
            }
            if (this.zzaIE == null) {
                if (zzc.zzaIE != null) {
                    return false;
                }
            } else if (!this.zzaIE.equals(zzc.zzaIE)) {
                return false;
            }
            if (zzww.equals(this.zzaIK, zzc.zzaIK)) {
                return this.zzaIx == zzc.zzaIx;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return (this.zzaIx ? 1231 : 1237) + (((((this.zzaIE == null ? 0 : this.zzaIE.hashCode()) + ((this.zzaID + 527) * 31)) * 31) + zzww.hashCode(this.zzaIK)) * 31);
        }

        public zzc zzI(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaID = zzwq.zzvx();
                        continue;
                    case 18:
                        if (this.zzaIE == null) {
                            this.zzaIE = new com.google.android.gms.internal.zzxc.zzb();
                        }
                        zzwq.zza(this.zzaIE);
                        continue;
                    case 26:
                        int zzc = zzxb.zzc(zzwq, 26);
                        zzvu = this.zzaIK == null ? 0 : this.zzaIK.length;
                        Object obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIK, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        zzwq.zza(obj[zzvu]);
                        this.zzaIK = obj;
                        continue;
                    case 32:
                        this.zzaIx = zzwq.zzvy();
                        continue;
                    default:
                        if (!zzxb.zzb(zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr zzwr) throws IOException {
            if (this.zzaID != 0) {
                zzwr.zzy(1, this.zzaID);
            }
            if (this.zzaIE != null) {
                zzwr.zza(2, this.zzaIE);
            }
            if (this.zzaIK != null && this.zzaIK.length > 0) {
                for (zzwy zzwy : this.zzaIK) {
                    if (zzwy != null) {
                        zzwr.zza(3, zzwy);
                    }
                }
            }
            if (this.zzaIx) {
                zzwr.zzb(4, this.zzaIx);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzI(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaID != 0) {
                zzc += zzwr.zzA(1, this.zzaID);
            }
            if (this.zzaIE != null) {
                zzc += zzwr.zzc(2, this.zzaIE);
            }
            if (this.zzaIK != null && this.zzaIK.length > 0) {
                int i = zzc;
                for (zzwy zzwy : this.zzaIK) {
                    if (zzwy != null) {
                        i += zzwr.zzc(3, zzwy);
                    }
                }
                zzc = i;
            }
            return this.zzaIx ? zzc + zzwr.zzc(4, this.zzaIx) : zzc;
        }

        public zzc zzwm() {
            this.zzaID = 0;
            this.zzaIE = null;
            this.zzaIK = zzb.zzwj();
            this.zzaIx = false;
            this.zzaHM = -1;
            return this;
        }
    }
}
