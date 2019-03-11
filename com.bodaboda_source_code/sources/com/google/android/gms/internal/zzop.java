package com.google.android.gms.internal;

import java.io.IOException;

public interface zzop {

    public static final class zza extends zzws<zza> {
        public zza[] zzale;

        public static final class zza extends zzws<zza> {
            private static volatile zza[] zzalf;
            public int viewId;
            public String zzalg;
            public String zzalh;

            public zza() {
                zzph();
            }

            public static zza[] zzpg() {
                if (zzalf == null) {
                    synchronized (zzww.zzaHL) {
                        if (zzalf == null) {
                            zzalf = new zza[0];
                        }
                    }
                }
                return zzalf;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof zza)) {
                    return false;
                }
                zza zza = (zza) o;
                if (this.zzalg == null) {
                    if (zza.zzalg != null) {
                        return false;
                    }
                } else if (!this.zzalg.equals(zza.zzalg)) {
                    return false;
                }
                if (this.zzalh == null) {
                    if (zza.zzalh != null) {
                        return false;
                    }
                } else if (!this.zzalh.equals(zza.zzalh)) {
                    return false;
                }
                return this.viewId == zza.viewId ? zza((zzws) zza) : false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.zzalg == null ? 0 : this.zzalg.hashCode()) + 527) * 31;
                if (this.zzalh != null) {
                    i = this.zzalh.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + zzvL();
            }

            public void zza(zzwr zzwr) throws IOException {
                if (!this.zzalg.equals("")) {
                    zzwr.zzb(1, this.zzalg);
                }
                if (!this.zzalh.equals("")) {
                    zzwr.zzb(2, this.zzalh);
                }
                if (this.viewId != 0) {
                    zzwr.zzy(3, this.viewId);
                }
                super.zza(zzwr);
            }

            public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
                return zzp(zzwq);
            }

            protected int zzc() {
                int zzc = super.zzc();
                if (!this.zzalg.equals("")) {
                    zzc += zzwr.zzj(1, this.zzalg);
                }
                if (!this.zzalh.equals("")) {
                    zzc += zzwr.zzj(2, this.zzalh);
                }
                return this.viewId != 0 ? zzc + zzwr.zzA(3, this.viewId) : zzc;
            }

            public zza zzp(zzwq zzwq) throws IOException {
                while (true) {
                    int zzvu = zzwq.zzvu();
                    switch (zzvu) {
                        case 0:
                            break;
                        case 10:
                            this.zzalg = zzwq.readString();
                            continue;
                        case 18:
                            this.zzalh = zzwq.readString();
                            continue;
                        case 24:
                            this.viewId = zzwq.zzvx();
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

            public zza zzph() {
                this.zzalg = "";
                this.zzalh = "";
                this.viewId = 0;
                this.zzaHB = null;
                this.zzaHM = -1;
                return this;
            }
        }

        public zza() {
            zzpf();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            return zzww.equals(this.zzale, zza.zzale) ? zza((zzws) zza) : false;
        }

        public int hashCode() {
            return ((zzww.hashCode(this.zzale) + 527) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            if (this.zzale != null && this.zzale.length > 0) {
                for (zzwy zzwy : this.zzale) {
                    if (zzwy != null) {
                        zzwr.zza(1, zzwy);
                    }
                }
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzo(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzale != null && this.zzale.length > 0) {
                for (zzwy zzwy : this.zzale) {
                    if (zzwy != null) {
                        zzc += zzwr.zzc(1, zzwy);
                    }
                }
            }
            return zzc;
        }

        public zza zzo(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzxb.zzc(zzwq, 10);
                        zzvu = this.zzale == null ? 0 : this.zzale.length;
                        Object obj = new zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzale, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zza();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zza();
                        zzwq.zza(obj[zzvu]);
                        this.zzale = obj;
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

        public zza zzpf() {
            this.zzale = zza.zzpg();
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzb extends zzws<zzb> {
        private static volatile zzb[] zzali;
        public String name;
        public zzd zzalj;

        public zzb() {
            zzpj();
        }

        public static zzb[] zzpi() {
            if (zzali == null) {
                synchronized (zzww.zzaHL) {
                    if (zzali == null) {
                        zzali = new zzb[0];
                    }
                }
            }
            return zzali;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.name == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzb.name)) {
                return false;
            }
            if (this.zzalj == null) {
                if (zzb.zzalj != null) {
                    return false;
                }
            } else if (!this.zzalj.equals(zzb.zzalj)) {
                return false;
            }
            return zza((zzws) zzb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.zzalj != null) {
                i = this.zzalj.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            if (!this.name.equals("")) {
                zzwr.zzb(1, this.name);
            }
            if (this.zzalj != null) {
                zzwr.zza(2, this.zzalj);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzq(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (!this.name.equals("")) {
                zzc += zzwr.zzj(1, this.name);
            }
            return this.zzalj != null ? zzc + zzwr.zzc(2, this.zzalj) : zzc;
        }

        public zzb zzpj() {
            this.name = "";
            this.zzalj = null;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }

        public zzb zzq(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzwq.readString();
                        continue;
                    case 18:
                        if (this.zzalj == null) {
                            this.zzalj = new zzd();
                        }
                        zzwq.zza(this.zzalj);
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

    public static final class zzc extends zzws<zzc> {
        public String type;
        public zzb[] zzalk;

        public zzc() {
            zzpk();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (this.type == null) {
                if (zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(zzc.type)) {
                return false;
            }
            return zzww.equals(this.zzalk, zzc.zzalk) ? zza((zzws) zzc) : false;
        }

        public int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + zzww.hashCode(this.zzalk)) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            if (!this.type.equals("")) {
                zzwr.zzb(1, this.type);
            }
            if (this.zzalk != null && this.zzalk.length > 0) {
                for (zzwy zzwy : this.zzalk) {
                    if (zzwy != null) {
                        zzwr.zza(2, zzwy);
                    }
                }
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzr(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (!this.type.equals("")) {
                zzc += zzwr.zzj(1, this.type);
            }
            if (this.zzalk == null || this.zzalk.length <= 0) {
                return zzc;
            }
            int i = zzc;
            for (zzwy zzwy : this.zzalk) {
                if (zzwy != null) {
                    i += zzwr.zzc(2, zzwy);
                }
            }
            return i;
        }

        public zzc zzpk() {
            this.type = "";
            this.zzalk = zzb.zzpi();
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }

        public zzc zzr(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.type = zzwq.readString();
                        continue;
                    case 18:
                        int zzc = zzxb.zzc(zzwq, 18);
                        zzvu = this.zzalk == null ? 0 : this.zzalk.length;
                        Object obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzalk, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        zzwq.zza(obj[zzvu]);
                        this.zzalk = obj;
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

    public static final class zzd extends zzws<zzd> {
        public String zzQN;
        public boolean zzall;
        public long zzalm;
        public double zzaln;
        public zzc zzalo;

        public zzd() {
            zzpl();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (this.zzall != zzd.zzall) {
                return false;
            }
            if (this.zzQN == null) {
                if (zzd.zzQN != null) {
                    return false;
                }
            } else if (!this.zzQN.equals(zzd.zzQN)) {
                return false;
            }
            if (this.zzalm != zzd.zzalm || Double.doubleToLongBits(this.zzaln) != Double.doubleToLongBits(zzd.zzaln)) {
                return false;
            }
            if (this.zzalo == null) {
                if (zzd.zzalo != null) {
                    return false;
                }
            } else if (!this.zzalo.equals(zzd.zzalo)) {
                return false;
            }
            return zza((zzws) zzd);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzQN == null ? 0 : this.zzQN.hashCode()) + (((this.zzall ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.zzalm ^ (this.zzalm >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzaln);
            hashCode = ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            if (this.zzalo != null) {
                i = this.zzalo.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            if (this.zzall) {
                zzwr.zzb(1, this.zzall);
            }
            if (!this.zzQN.equals("")) {
                zzwr.zzb(2, this.zzQN);
            }
            if (this.zzalm != 0) {
                zzwr.zzb(3, this.zzalm);
            }
            if (Double.doubleToLongBits(this.zzaln) != Double.doubleToLongBits(0.0d)) {
                zzwr.zza(4, this.zzaln);
            }
            if (this.zzalo != null) {
                zzwr.zza(5, this.zzalo);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzs(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzall) {
                zzc += zzwr.zzc(1, this.zzall);
            }
            if (!this.zzQN.equals("")) {
                zzc += zzwr.zzj(2, this.zzQN);
            }
            if (this.zzalm != 0) {
                zzc += zzwr.zzd(3, this.zzalm);
            }
            if (Double.doubleToLongBits(this.zzaln) != Double.doubleToLongBits(0.0d)) {
                zzc += zzwr.zzb(4, this.zzaln);
            }
            return this.zzalo != null ? zzc + zzwr.zzc(5, this.zzalo) : zzc;
        }

        public zzd zzpl() {
            this.zzall = false;
            this.zzQN = "";
            this.zzalm = 0;
            this.zzaln = 0.0d;
            this.zzalo = null;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }

        public zzd zzs(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzall = zzwq.zzvy();
                        continue;
                    case 18:
                        this.zzQN = zzwq.readString();
                        continue;
                    case 24:
                        this.zzalm = zzwq.zzvw();
                        continue;
                    case 33:
                        this.zzaln = zzwq.readDouble();
                        continue;
                    case 42:
                        if (this.zzalo == null) {
                            this.zzalo = new zzc();
                        }
                        zzwq.zza(this.zzalo);
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
}
