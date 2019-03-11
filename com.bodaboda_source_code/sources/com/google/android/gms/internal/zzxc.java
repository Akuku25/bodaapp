package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import java.io.IOException;

public interface zzxc {

    public static final class zza extends zzwy {
        public String name;
        public String packageName;
        public String version;
        public String zzaHW;
        public long[] zzaHX;

        public zza() {
            zzvZ();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.packageName == null) {
                if (zza.packageName != null) {
                    return false;
                }
            } else if (!this.packageName.equals(zza.packageName)) {
                return false;
            }
            if (this.version == null) {
                if (zza.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zza.version)) {
                return false;
            }
            if (this.zzaHW == null) {
                if (zza.zzaHW != null) {
                    return false;
                }
            } else if (!this.zzaHW.equals(zza.zzaHW)) {
                return false;
            }
            if (zzww.equals(this.zzaHX, zza.zzaHX)) {
                return this.name == null ? zza.name == null : this.name.equals(zza.name);
            } else {
                return false;
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzaHW == null ? 0 : this.zzaHW.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.packageName == null ? 0 : this.packageName.hashCode()) + 527) * 31)) * 31)) * 31) + zzww.hashCode(this.zzaHX)) * 31;
            if (this.name != null) {
                i = this.name.hashCode();
            }
            return hashCode + i;
        }

        public zza zzA(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                int zzc;
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.packageName = zzwq.readString();
                        continue;
                    case 18:
                        this.version = zzwq.readString();
                        continue;
                    case 26:
                        this.zzaHW = zzwq.readString();
                        continue;
                    case 32:
                        zzc = zzxb.zzc(zzwq, 32);
                        zzvu = this.zzaHX == null ? 0 : this.zzaHX.length;
                        Object obj = new long[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaHX, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvw();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvw();
                        this.zzaHX = obj;
                        continue;
                    case 34:
                        int zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvw();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzaHX == null ? 0 : this.zzaHX.length;
                        Object obj2 = new long[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzaHX, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvw();
                            zzc++;
                        }
                        this.zzaHX = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 42:
                        this.name = zzwq.readString();
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
            if (this.packageName != null) {
                zzwr.zzb(1, this.packageName);
            }
            if (this.version != null) {
                zzwr.zzb(2, this.version);
            }
            if (this.zzaHW != null) {
                zzwr.zzb(3, this.zzaHW);
            }
            if (this.zzaHX != null && this.zzaHX.length > 0) {
                for (long zzb : this.zzaHX) {
                    zzwr.zzb(4, zzb);
                }
            }
            if (this.name != null) {
                zzwr.zzb(5, this.name);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzA(zzwq);
        }

        protected int zzc() {
            int i = 0;
            int zzc = super.zzc();
            if (this.packageName != null) {
                zzc += zzwr.zzj(1, this.packageName);
            }
            if (this.version != null) {
                zzc += zzwr.zzj(2, this.version);
            }
            if (this.zzaHW != null) {
                zzc += zzwr.zzj(3, this.zzaHW);
            }
            if (this.zzaHX != null && this.zzaHX.length > 0) {
                int i2 = 0;
                while (i < this.zzaHX.length) {
                    i2 += zzwr.zzN(this.zzaHX[i]);
                    i++;
                }
                zzc = (zzc + i2) + (this.zzaHX.length * 1);
            }
            return this.name != null ? zzc + zzwr.zzj(5, this.name) : zzc;
        }

        public zza zzvZ() {
            this.packageName = null;
            this.version = null;
            this.zzaHW = null;
            this.zzaHX = zzxb.zzaHP;
            this.name = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzb extends zzwy {
        private static volatile zzb[] zzaHY;
        public String name;
        public String zzaHZ;
        public String zzaIa;
        public Integer zzaIb;
        public zzc zzaIc;
        public zze zzaId;
        public zza zzaIe;

        public zzb() {
            zzwb();
        }

        public static zzb[] zzwa() {
            if (zzaHY == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaHY == null) {
                        zzaHY = new zzb[0];
                    }
                }
            }
            return zzaHY;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.zzaHZ == null) {
                if (zzb.zzaHZ != null) {
                    return false;
                }
            } else if (!this.zzaHZ.equals(zzb.zzaHZ)) {
                return false;
            }
            if (this.name == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzb.name)) {
                return false;
            }
            if (this.zzaIa == null) {
                if (zzb.zzaIa != null) {
                    return false;
                }
            } else if (!this.zzaIa.equals(zzb.zzaIa)) {
                return false;
            }
            if (this.zzaIb == null) {
                if (zzb.zzaIb != null) {
                    return false;
                }
            } else if (!this.zzaIb.equals(zzb.zzaIb)) {
                return false;
            }
            if (this.zzaIc == null) {
                if (zzb.zzaIc != null) {
                    return false;
                }
            } else if (!this.zzaIc.equals(zzb.zzaIc)) {
                return false;
            }
            if (this.zzaId == null) {
                if (zzb.zzaId != null) {
                    return false;
                }
            } else if (!this.zzaId.equals(zzb.zzaId)) {
                return false;
            }
            return this.zzaIe == null ? zzb.zzaIe == null : this.zzaIe.equals(zzb.zzaIe);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaId == null ? 0 : this.zzaId.hashCode()) + (((this.zzaIc == null ? 0 : this.zzaIc.hashCode()) + (((this.zzaIb == null ? 0 : this.zzaIb.intValue()) + (((this.zzaIa == null ? 0 : this.zzaIa.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzaHZ == null ? 0 : this.zzaHZ.hashCode()) + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzaIe != null) {
                i = this.zzaIe.hashCode();
            }
            return hashCode + i;
        }

        public zzb zzB(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzaHZ = zzwq.readString();
                        continue;
                    case 34:
                        this.name = zzwq.readString();
                        continue;
                    case 42:
                        this.zzaIa = zzwq.readString();
                        continue;
                    case 48:
                        zzvu = zzwq.zzvx();
                        switch (zzvu) {
                            case 0:
                            case 1:
                                this.zzaIb = Integer.valueOf(zzvu);
                                break;
                            default:
                                continue;
                        }
                    case 58:
                        if (this.zzaIc == null) {
                            this.zzaIc = new zzc();
                        }
                        zzwq.zza(this.zzaIc);
                        continue;
                    case 66:
                        if (this.zzaId == null) {
                            this.zzaId = new zze();
                        }
                        zzwq.zza(this.zzaId);
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        if (this.zzaIe == null) {
                            this.zzaIe = new zza();
                        }
                        zzwq.zza(this.zzaIe);
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
            if (this.zzaHZ != null) {
                zzwr.zzb(1, this.zzaHZ);
            }
            if (this.name != null) {
                zzwr.zzb(4, this.name);
            }
            if (this.zzaIa != null) {
                zzwr.zzb(5, this.zzaIa);
            }
            if (this.zzaIb != null) {
                zzwr.zzy(6, this.zzaIb.intValue());
            }
            if (this.zzaIc != null) {
                zzwr.zza(7, this.zzaIc);
            }
            if (this.zzaId != null) {
                zzwr.zza(8, this.zzaId);
            }
            if (this.zzaIe != null) {
                zzwr.zza(9, this.zzaIe);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzB(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaHZ != null) {
                zzc += zzwr.zzj(1, this.zzaHZ);
            }
            if (this.name != null) {
                zzc += zzwr.zzj(4, this.name);
            }
            if (this.zzaIa != null) {
                zzc += zzwr.zzj(5, this.zzaIa);
            }
            if (this.zzaIb != null) {
                zzc += zzwr.zzA(6, this.zzaIb.intValue());
            }
            if (this.zzaIc != null) {
                zzc += zzwr.zzc(7, this.zzaIc);
            }
            if (this.zzaId != null) {
                zzc += zzwr.zzc(8, this.zzaId);
            }
            return this.zzaIe != null ? zzc + zzwr.zzc(9, this.zzaIe) : zzc;
        }

        public zzb zzwb() {
            this.zzaHZ = null;
            this.name = null;
            this.zzaIa = null;
            this.zzaIb = null;
            this.zzaIc = null;
            this.zzaId = null;
            this.zzaIe = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzc extends zzwy {
        public String name;
        public zzd[] zzaIf;

        public zzc() {
            zzwc();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (this.name == null) {
                if (zzc.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzc.name)) {
                return false;
            }
            return zzww.equals(this.zzaIf, zzc.zzaIf);
        }

        public int hashCode() {
            return (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31) + zzww.hashCode(this.zzaIf);
        }

        public zzc zzC(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzwq.readString();
                        continue;
                    case 18:
                        int zzc = zzxb.zzc(zzwq, 18);
                        zzvu = this.zzaIf == null ? 0 : this.zzaIf.length;
                        Object obj = new zzd[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIf, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzd();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzd();
                        zzwq.zza(obj[zzvu]);
                        this.zzaIf = obj;
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
            if (this.name != null) {
                zzwr.zzb(1, this.name);
            }
            if (this.zzaIf != null && this.zzaIf.length > 0) {
                for (zzwy zzwy : this.zzaIf) {
                    if (zzwy != null) {
                        zzwr.zza(2, zzwy);
                    }
                }
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzC(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.name != null) {
                zzc += zzwr.zzj(1, this.name);
            }
            if (this.zzaIf == null || this.zzaIf.length <= 0) {
                return zzc;
            }
            int i = zzc;
            for (zzwy zzwy : this.zzaIf) {
                if (zzwy != null) {
                    i += zzwr.zzc(2, zzwy);
                }
            }
            return i;
        }

        public zzc zzwc() {
            this.name = null;
            this.zzaIf = zzd.zzwd();
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzd extends zzwy {
        private static volatile zzd[] zzaIg;
        public String name;
        public Integer zzaIh;
        public Boolean zzaIi;

        public zzd() {
            zzwe();
        }

        public static zzd[] zzwd() {
            if (zzaIg == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaIg == null) {
                        zzaIg = new zzd[0];
                    }
                }
            }
            return zzaIg;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (this.name == null) {
                if (zzd.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzd.name)) {
                return false;
            }
            if (this.zzaIh == null) {
                if (zzd.zzaIh != null) {
                    return false;
                }
            } else if (!this.zzaIh.equals(zzd.zzaIh)) {
                return false;
            }
            return this.zzaIi == null ? zzd.zzaIi == null : this.zzaIi.equals(zzd.zzaIi);
        }

        public int hashCode() {
            int i = 0;
            int intValue = ((this.zzaIh == null ? 0 : this.zzaIh.intValue()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.zzaIi != null) {
                i = this.zzaIi.hashCode();
            }
            return intValue + i;
        }

        public zzd zzD(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzwq.readString();
                        continue;
                    case 24:
                        zzvu = zzwq.zzvx();
                        switch (zzvu) {
                            case 1:
                            case 2:
                                this.zzaIh = Integer.valueOf(zzvu);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        this.zzaIi = Boolean.valueOf(zzwq.zzvy());
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
            if (this.name != null) {
                zzwr.zzb(1, this.name);
            }
            if (this.zzaIh != null) {
                zzwr.zzy(3, this.zzaIh.intValue());
            }
            if (this.zzaIi != null) {
                zzwr.zzb(4, this.zzaIi.booleanValue());
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzD(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.name != null) {
                zzc += zzwr.zzj(1, this.name);
            }
            if (this.zzaIh != null) {
                zzc += zzwr.zzA(3, this.zzaIh.intValue());
            }
            return this.zzaIi != null ? zzc + zzwr.zzc(4, this.zzaIi.booleanValue()) : zzc;
        }

        public zzd zzwe() {
            this.name = null;
            this.zzaIh = null;
            this.zzaIi = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zze extends zzwy {
        public String version;
        public Integer zzaIb;
        public String zzaIj;
        public String zzaIk;
        public String zzaIl;
        public Integer zzaIm;

        public zze() {
            zzwf();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zze = (zze) o;
            if (this.zzaIj == null) {
                if (zze.zzaIj != null) {
                    return false;
                }
            } else if (!this.zzaIj.equals(zze.zzaIj)) {
                return false;
            }
            if (this.zzaIb == null) {
                if (zze.zzaIb != null) {
                    return false;
                }
            } else if (!this.zzaIb.equals(zze.zzaIb)) {
                return false;
            }
            if (this.version == null) {
                if (zze.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zze.version)) {
                return false;
            }
            if (this.zzaIk == null) {
                if (zze.zzaIk != null) {
                    return false;
                }
            } else if (!this.zzaIk.equals(zze.zzaIk)) {
                return false;
            }
            if (this.zzaIl == null) {
                if (zze.zzaIl != null) {
                    return false;
                }
            } else if (!this.zzaIl.equals(zze.zzaIl)) {
                return false;
            }
            return this.zzaIm == null ? zze.zzaIm == null : this.zzaIm.equals(zze.zzaIm);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaIl == null ? 0 : this.zzaIl.hashCode()) + (((this.zzaIk == null ? 0 : this.zzaIk.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzaIb == null ? 0 : this.zzaIb.intValue()) + (((this.zzaIj == null ? 0 : this.zzaIj.hashCode()) + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzaIm != null) {
                i = this.zzaIm.intValue();
            }
            return hashCode + i;
        }

        public zze zzE(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzaIj = zzwq.readString();
                        continue;
                    case 16:
                        zzvu = zzwq.zzvx();
                        switch (zzvu) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                this.zzaIb = Integer.valueOf(zzvu);
                                break;
                            default:
                                continue;
                        }
                    case 26:
                        this.version = zzwq.readString();
                        continue;
                    case 34:
                        this.zzaIk = zzwq.readString();
                        continue;
                    case 42:
                        this.zzaIl = zzwq.readString();
                        continue;
                    case 48:
                        zzvu = zzwq.zzvx();
                        switch (zzvu) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzaIm = Integer.valueOf(zzvu);
                                break;
                            default:
                                continue;
                        }
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
            if (this.zzaIj != null) {
                zzwr.zzb(1, this.zzaIj);
            }
            if (this.zzaIb != null) {
                zzwr.zzy(2, this.zzaIb.intValue());
            }
            if (this.version != null) {
                zzwr.zzb(3, this.version);
            }
            if (this.zzaIk != null) {
                zzwr.zzb(4, this.zzaIk);
            }
            if (this.zzaIl != null) {
                zzwr.zzb(5, this.zzaIl);
            }
            if (this.zzaIm != null) {
                zzwr.zzy(6, this.zzaIm.intValue());
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzE(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaIj != null) {
                zzc += zzwr.zzj(1, this.zzaIj);
            }
            if (this.zzaIb != null) {
                zzc += zzwr.zzA(2, this.zzaIb.intValue());
            }
            if (this.version != null) {
                zzc += zzwr.zzj(3, this.version);
            }
            if (this.zzaIk != null) {
                zzc += zzwr.zzj(4, this.zzaIk);
            }
            if (this.zzaIl != null) {
                zzc += zzwr.zzj(5, this.zzaIl);
            }
            return this.zzaIm != null ? zzc + zzwr.zzA(6, this.zzaIm.intValue()) : zzc;
        }

        public zze zzwf() {
            this.zzaIj = null;
            this.zzaIb = null;
            this.version = null;
            this.zzaIk = null;
            this.zzaIl = null;
            this.zzaIm = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzf extends zzwy {
        private static volatile zzf[] zzaIn;
        public Integer zzaIo;
        public Double zzaIp;

        public zzf() {
            zzwh();
        }

        public static zzf[] zzwg() {
            if (zzaIn == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaIn == null) {
                        zzaIn = new zzf[0];
                    }
                }
            }
            return zzaIn;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) o;
            if (this.zzaIo == null) {
                if (zzf.zzaIo != null) {
                    return false;
                }
            } else if (!this.zzaIo.equals(zzf.zzaIo)) {
                return false;
            }
            return this.zzaIp == null ? zzf.zzaIp == null : this.zzaIp.equals(zzf.zzaIp);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaIo == null ? 0 : this.zzaIo.hashCode()) + 527) * 31;
            if (this.zzaIp != null) {
                i = this.zzaIp.hashCode();
            }
            return hashCode + i;
        }

        public zzf zzF(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaIo = Integer.valueOf(zzwq.zzvx());
                        continue;
                    case 17:
                        this.zzaIp = Double.valueOf(zzwq.readDouble());
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
            if (this.zzaIo != null) {
                zzwr.zzy(1, this.zzaIo.intValue());
            }
            if (this.zzaIp != null) {
                zzwr.zza(2, this.zzaIp.doubleValue());
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzF(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaIo != null) {
                zzc += zzwr.zzA(1, this.zzaIo.intValue());
            }
            return this.zzaIp != null ? zzc + zzwr.zzb(2, this.zzaIp.doubleValue()) : zzc;
        }

        public zzf zzwh() {
            this.zzaIo = null;
            this.zzaIp = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
