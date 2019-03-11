package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.location.places.Place;
import java.io.IOException;

public interface zzc {

    public static final class zza extends zzws<zza> {
        public int level;
        public int zzfn;
        public int zzfo;

        public zza() {
            zzb();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            return (this.level == zza.level && this.zzfn == zza.zzfn && this.zzfo == zza.zzfo) ? zza((zzws) zza) : false;
        }

        public int hashCode() {
            return ((((((this.level + 527) * 31) + this.zzfn) * 31) + this.zzfo) * 31) + zzvL();
        }

        public zza zza(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        zzvu = zzwq.zzvx();
                        switch (zzvu) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = zzvu;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zzfn = zzwq.zzvx();
                        continue;
                    case 24:
                        this.zzfo = zzwq.zzvx();
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

        public void zza(zzwr zzwr) throws IOException {
            if (this.level != 1) {
                zzwr.zzy(1, this.level);
            }
            if (this.zzfn != 0) {
                zzwr.zzy(2, this.zzfn);
            }
            if (this.zzfo != 0) {
                zzwr.zzy(3, this.zzfo);
            }
            super.zza(zzwr);
        }

        public zza zzb() {
            this.level = 1;
            this.zzfn = 0;
            this.zzfo = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zza(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.level != 1) {
                zzc += zzwr.zzA(1, this.level);
            }
            if (this.zzfn != 0) {
                zzc += zzwr.zzA(2, this.zzfn);
            }
            return this.zzfo != 0 ? zzc + zzwr.zzA(3, this.zzfo) : zzc;
        }
    }

    public static final class zzb extends zzws<zzb> {
        private static volatile zzb[] zzfp;
        public int name;
        public int[] zzfq;
        public int zzfr;
        public boolean zzfs;
        public boolean zzft;

        public zzb() {
            zze();
        }

        public static zzb[] zzd() {
            if (zzfp == null) {
                synchronized (zzww.zzaHL) {
                    if (zzfp == null) {
                        zzfp = new zzb[0];
                    }
                }
            }
            return zzfp;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            return (zzww.equals(this.zzfq, zzb.zzfq) && this.zzfr == zzb.zzfr && this.name == zzb.name && this.zzfs == zzb.zzfs && this.zzft == zzb.zzft) ? zza((zzws) zzb) : false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzfs ? 1231 : 1237) + ((((((zzww.hashCode(this.zzfq) + 527) * 31) + this.zzfr) * 31) + this.name) * 31)) * 31;
            if (!this.zzft) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            if (this.zzft) {
                zzwr.zzb(1, this.zzft);
            }
            zzwr.zzy(2, this.zzfr);
            if (this.zzfq != null && this.zzfq.length > 0) {
                for (int zzy : this.zzfq) {
                    zzwr.zzy(3, zzy);
                }
            }
            if (this.name != 0) {
                zzwr.zzy(4, this.name);
            }
            if (this.zzfs) {
                zzwr.zzb(6, this.zzfs);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzc(zzwq);
        }

        protected int zzc() {
            int i = 0;
            int zzc = super.zzc();
            if (this.zzft) {
                zzc += zzwr.zzc(1, this.zzft);
            }
            int zzA = zzwr.zzA(2, this.zzfr) + zzc;
            if (this.zzfq == null || this.zzfq.length <= 0) {
                zzc = zzA;
            } else {
                for (int zziw : this.zzfq) {
                    i += zzwr.zziw(zziw);
                }
                zzc = (zzA + i) + (this.zzfq.length * 1);
            }
            if (this.name != 0) {
                zzc += zzwr.zzA(4, this.name);
            }
            return this.zzfs ? zzc + zzwr.zzc(6, this.zzfs) : zzc;
        }

        public zzb zzc(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                int zzc;
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzft = zzwq.zzvy();
                        continue;
                    case 16:
                        this.zzfr = zzwq.zzvx();
                        continue;
                    case 24:
                        zzc = zzxb.zzc(zzwq, 24);
                        zzvu = this.zzfq == null ? 0 : this.zzfq.length;
                        Object obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfq, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzfq = obj;
                        continue;
                    case 26:
                        int zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzfq == null ? 0 : this.zzfq.length;
                        Object obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfq, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfq = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 32:
                        this.name = zzwq.zzvx();
                        continue;
                    case 48:
                        this.zzfs = zzwq.zzvy();
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

        public zzb zze() {
            this.zzfq = zzxb.zzaHO;
            this.zzfr = 0;
            this.name = 0;
            this.zzfs = false;
            this.zzft = false;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzc extends zzws<zzc> {
        private static volatile zzc[] zzfu;
        public String zzfv;
        public long zzfw;
        public long zzfx;
        public boolean zzfy;
        public long zzfz;

        public zzc() {
            zzg();
        }

        public static zzc[] zzf() {
            if (zzfu == null) {
                synchronized (zzww.zzaHL) {
                    if (zzfu == null) {
                        zzfu = new zzc[0];
                    }
                }
            }
            return zzfu;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (this.zzfv == null) {
                if (zzc.zzfv != null) {
                    return false;
                }
            } else if (!this.zzfv.equals(zzc.zzfv)) {
                return false;
            }
            return (this.zzfw == zzc.zzfw && this.zzfx == zzc.zzfx && this.zzfy == zzc.zzfy && this.zzfz == zzc.zzfz) ? zza((zzws) zzc) : false;
        }

        public int hashCode() {
            return (((((this.zzfy ? 1231 : 1237) + (((((((this.zzfv == null ? 0 : this.zzfv.hashCode()) + 527) * 31) + ((int) (this.zzfw ^ (this.zzfw >>> 32)))) * 31) + ((int) (this.zzfx ^ (this.zzfx >>> 32)))) * 31)) * 31) + ((int) (this.zzfz ^ (this.zzfz >>> 32)))) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            if (!this.zzfv.equals("")) {
                zzwr.zzb(1, this.zzfv);
            }
            if (this.zzfw != 0) {
                zzwr.zzb(2, this.zzfw);
            }
            if (this.zzfx != 2147483647L) {
                zzwr.zzb(3, this.zzfx);
            }
            if (this.zzfy) {
                zzwr.zzb(4, this.zzfy);
            }
            if (this.zzfz != 0) {
                zzwr.zzb(5, this.zzfz);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzd(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (!this.zzfv.equals("")) {
                zzc += zzwr.zzj(1, this.zzfv);
            }
            if (this.zzfw != 0) {
                zzc += zzwr.zzd(2, this.zzfw);
            }
            if (this.zzfx != 2147483647L) {
                zzc += zzwr.zzd(3, this.zzfx);
            }
            if (this.zzfy) {
                zzc += zzwr.zzc(4, this.zzfy);
            }
            return this.zzfz != 0 ? zzc + zzwr.zzd(5, this.zzfz) : zzc;
        }

        public zzc zzd(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzfv = zzwq.readString();
                        continue;
                    case 16:
                        this.zzfw = zzwq.zzvw();
                        continue;
                    case 24:
                        this.zzfx = zzwq.zzvw();
                        continue;
                    case 32:
                        this.zzfy = zzwq.zzvy();
                        continue;
                    case 40:
                        this.zzfz = zzwq.zzvw();
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

        public zzc zzg() {
            this.zzfv = "";
            this.zzfw = 0;
            this.zzfx = 2147483647L;
            this.zzfy = false;
            this.zzfz = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzd extends zzws<zzd> {
        public com.google.android.gms.internal.zzd.zza[] zzfA;
        public com.google.android.gms.internal.zzd.zza[] zzfB;
        public zzc[] zzfC;

        public zzd() {
            zzh();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            return (zzww.equals(this.zzfA, zzd.zzfA) && zzww.equals(this.zzfB, zzd.zzfB) && zzww.equals(this.zzfC, zzd.zzfC)) ? zza((zzws) zzd) : false;
        }

        public int hashCode() {
            return ((((((zzww.hashCode(this.zzfA) + 527) * 31) + zzww.hashCode(this.zzfB)) * 31) + zzww.hashCode(this.zzfC)) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            int i = 0;
            if (this.zzfA != null && this.zzfA.length > 0) {
                for (zzwy zzwy : this.zzfA) {
                    if (zzwy != null) {
                        zzwr.zza(1, zzwy);
                    }
                }
            }
            if (this.zzfB != null && this.zzfB.length > 0) {
                for (zzwy zzwy2 : this.zzfB) {
                    if (zzwy2 != null) {
                        zzwr.zza(2, zzwy2);
                    }
                }
            }
            if (this.zzfC != null && this.zzfC.length > 0) {
                while (i < this.zzfC.length) {
                    zzwy zzwy3 = this.zzfC[i];
                    if (zzwy3 != null) {
                        zzwr.zza(3, zzwy3);
                    }
                    i++;
                }
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zze(zzwq);
        }

        protected int zzc() {
            int i;
            int i2 = 0;
            int zzc = super.zzc();
            if (this.zzfA != null && this.zzfA.length > 0) {
                i = zzc;
                for (zzwy zzwy : this.zzfA) {
                    if (zzwy != null) {
                        i += zzwr.zzc(1, zzwy);
                    }
                }
                zzc = i;
            }
            if (this.zzfB != null && this.zzfB.length > 0) {
                i = zzc;
                for (zzwy zzwy2 : this.zzfB) {
                    if (zzwy2 != null) {
                        i += zzwr.zzc(2, zzwy2);
                    }
                }
                zzc = i;
            }
            if (this.zzfC != null && this.zzfC.length > 0) {
                while (i2 < this.zzfC.length) {
                    zzwy zzwy3 = this.zzfC[i2];
                    if (zzwy3 != null) {
                        zzc += zzwr.zzc(3, zzwy3);
                    }
                    i2++;
                }
            }
            return zzc;
        }

        public zzd zze(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                int zzc;
                Object obj;
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        zzc = zzxb.zzc(zzwq, 10);
                        zzvu = this.zzfA == null ? 0 : this.zzfA.length;
                        obj = new com.google.android.gms.internal.zzd.zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfA, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                        zzwq.zza(obj[zzvu]);
                        this.zzfA = obj;
                        continue;
                    case 18:
                        zzc = zzxb.zzc(zzwq, 18);
                        zzvu = this.zzfB == null ? 0 : this.zzfB.length;
                        obj = new com.google.android.gms.internal.zzd.zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfB, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                        zzwq.zza(obj[zzvu]);
                        this.zzfB = obj;
                        continue;
                    case 26:
                        zzc = zzxb.zzc(zzwq, 26);
                        zzvu = this.zzfC == null ? 0 : this.zzfC.length;
                        obj = new zzc[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfC, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzc();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzc();
                        zzwq.zza(obj[zzvu]);
                        this.zzfC = obj;
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

        public zzd zzh() {
            this.zzfA = com.google.android.gms.internal.zzd.zza.zzr();
            this.zzfB = com.google.android.gms.internal.zzd.zza.zzr();
            this.zzfC = zzc.zzf();
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zze extends zzws<zze> {
        private static volatile zze[] zzfD;
        public int key;
        public int value;

        public zze() {
            zzj();
        }

        public static zze[] zzi() {
            if (zzfD == null) {
                synchronized (zzww.zzaHL) {
                    if (zzfD == null) {
                        zzfD = new zze[0];
                    }
                }
            }
            return zzfD;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zze = (zze) o;
            return (this.key == zze.key && this.value == zze.value) ? zza((zzws) zze) : false;
        }

        public int hashCode() {
            return ((((this.key + 527) * 31) + this.value) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            zzwr.zzy(1, this.key);
            zzwr.zzy(2, this.value);
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzf(zzwq);
        }

        protected int zzc() {
            return (super.zzc() + zzwr.zzA(1, this.key)) + zzwr.zzA(2, this.value);
        }

        public zze zzf(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzwq.zzvx();
                        continue;
                    case 16:
                        this.value = zzwq.zzvx();
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

        public zze zzj() {
            this.key = 0;
            this.value = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzf extends zzws<zzf> {
        public String version;
        public String[] zzfE;
        public String[] zzfF;
        public com.google.android.gms.internal.zzd.zza[] zzfG;
        public zze[] zzfH;
        public zzb[] zzfI;
        public zzb[] zzfJ;
        public zzb[] zzfK;
        public zzg[] zzfL;
        public String zzfM;
        public String zzfN;
        public String zzfO;
        public zza zzfP;
        public float zzfQ;
        public boolean zzfR;
        public String[] zzfS;
        public int zzfT;

        public zzf() {
            zzk();
        }

        public static zzf zza(byte[] bArr) throws zzwx {
            return (zzf) zzwy.zza(new zzf(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) o;
            if (!zzww.equals(this.zzfE, zzf.zzfE) || !zzww.equals(this.zzfF, zzf.zzfF) || !zzww.equals(this.zzfG, zzf.zzfG) || !zzww.equals(this.zzfH, zzf.zzfH) || !zzww.equals(this.zzfI, zzf.zzfI) || !zzww.equals(this.zzfJ, zzf.zzfJ) || !zzww.equals(this.zzfK, zzf.zzfK) || !zzww.equals(this.zzfL, zzf.zzfL)) {
                return false;
            }
            if (this.zzfM == null) {
                if (zzf.zzfM != null) {
                    return false;
                }
            } else if (!this.zzfM.equals(zzf.zzfM)) {
                return false;
            }
            if (this.zzfN == null) {
                if (zzf.zzfN != null) {
                    return false;
                }
            } else if (!this.zzfN.equals(zzf.zzfN)) {
                return false;
            }
            if (this.zzfO == null) {
                if (zzf.zzfO != null) {
                    return false;
                }
            } else if (!this.zzfO.equals(zzf.zzfO)) {
                return false;
            }
            if (this.version == null) {
                if (zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzf.version)) {
                return false;
            }
            if (this.zzfP == null) {
                if (zzf.zzfP != null) {
                    return false;
                }
            } else if (!this.zzfP.equals(zzf.zzfP)) {
                return false;
            }
            return (Float.floatToIntBits(this.zzfQ) == Float.floatToIntBits(zzf.zzfQ) && this.zzfR == zzf.zzfR && zzww.equals(this.zzfS, zzf.zzfS) && this.zzfT == zzf.zzfT) ? zza((zzws) zzf) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzfO == null ? 0 : this.zzfO.hashCode()) + (((this.zzfN == null ? 0 : this.zzfN.hashCode()) + (((this.zzfM == null ? 0 : this.zzfM.hashCode()) + ((((((((((((((((zzww.hashCode(this.zzfE) + 527) * 31) + zzww.hashCode(this.zzfF)) * 31) + zzww.hashCode(this.zzfG)) * 31) + zzww.hashCode(this.zzfH)) * 31) + zzww.hashCode(this.zzfI)) * 31) + zzww.hashCode(this.zzfJ)) * 31) + zzww.hashCode(this.zzfK)) * 31) + zzww.hashCode(this.zzfL)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzfP != null) {
                i = this.zzfP.hashCode();
            }
            return (((((((this.zzfR ? 1231 : 1237) + ((((hashCode + i) * 31) + Float.floatToIntBits(this.zzfQ)) * 31)) * 31) + zzww.hashCode(this.zzfS)) * 31) + this.zzfT) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            int i = 0;
            if (this.zzfF != null && this.zzfF.length > 0) {
                for (String str : this.zzfF) {
                    if (str != null) {
                        zzwr.zzb(1, str);
                    }
                }
            }
            if (this.zzfG != null && this.zzfG.length > 0) {
                for (zzwy zzwy : this.zzfG) {
                    if (zzwy != null) {
                        zzwr.zza(2, zzwy);
                    }
                }
            }
            if (this.zzfH != null && this.zzfH.length > 0) {
                for (zzwy zzwy2 : this.zzfH) {
                    if (zzwy2 != null) {
                        zzwr.zza(3, zzwy2);
                    }
                }
            }
            if (this.zzfI != null && this.zzfI.length > 0) {
                for (zzwy zzwy22 : this.zzfI) {
                    if (zzwy22 != null) {
                        zzwr.zza(4, zzwy22);
                    }
                }
            }
            if (this.zzfJ != null && this.zzfJ.length > 0) {
                for (zzwy zzwy222 : this.zzfJ) {
                    if (zzwy222 != null) {
                        zzwr.zza(5, zzwy222);
                    }
                }
            }
            if (this.zzfK != null && this.zzfK.length > 0) {
                for (zzwy zzwy2222 : this.zzfK) {
                    if (zzwy2222 != null) {
                        zzwr.zza(6, zzwy2222);
                    }
                }
            }
            if (this.zzfL != null && this.zzfL.length > 0) {
                for (zzwy zzwy22222 : this.zzfL) {
                    if (zzwy22222 != null) {
                        zzwr.zza(7, zzwy22222);
                    }
                }
            }
            if (!this.zzfM.equals("")) {
                zzwr.zzb(9, this.zzfM);
            }
            if (!this.zzfN.equals("")) {
                zzwr.zzb(10, this.zzfN);
            }
            if (!this.zzfO.equals("0")) {
                zzwr.zzb(12, this.zzfO);
            }
            if (!this.version.equals("")) {
                zzwr.zzb(13, this.version);
            }
            if (this.zzfP != null) {
                zzwr.zza(14, this.zzfP);
            }
            if (Float.floatToIntBits(this.zzfQ) != Float.floatToIntBits(0.0f)) {
                zzwr.zzb(15, this.zzfQ);
            }
            if (this.zzfS != null && this.zzfS.length > 0) {
                for (String str2 : this.zzfS) {
                    if (str2 != null) {
                        zzwr.zzb(16, str2);
                    }
                }
            }
            if (this.zzfT != 0) {
                zzwr.zzy(17, this.zzfT);
            }
            if (this.zzfR) {
                zzwr.zzb(18, this.zzfR);
            }
            if (this.zzfE != null && this.zzfE.length > 0) {
                while (i < this.zzfE.length) {
                    String str3 = this.zzfE[i];
                    if (str3 != null) {
                        zzwr.zzb(19, str3);
                    }
                    i++;
                }
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzg(zzwq);
        }

        protected int zzc() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzc = super.zzc();
            if (this.zzfF == null || this.zzfF.length <= 0) {
                i = zzc;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzfF) {
                    if (str != null) {
                        i3++;
                        i2 += zzwr.zzdM(str);
                    }
                }
                i = (zzc + i2) + (i3 * 1);
            }
            if (this.zzfG != null && this.zzfG.length > 0) {
                i2 = i;
                for (zzwy zzwy : this.zzfG) {
                    if (zzwy != null) {
                        i2 += zzwr.zzc(2, zzwy);
                    }
                }
                i = i2;
            }
            if (this.zzfH != null && this.zzfH.length > 0) {
                i2 = i;
                for (zzwy zzwy2 : this.zzfH) {
                    if (zzwy2 != null) {
                        i2 += zzwr.zzc(3, zzwy2);
                    }
                }
                i = i2;
            }
            if (this.zzfI != null && this.zzfI.length > 0) {
                i2 = i;
                for (zzwy zzwy22 : this.zzfI) {
                    if (zzwy22 != null) {
                        i2 += zzwr.zzc(4, zzwy22);
                    }
                }
                i = i2;
            }
            if (this.zzfJ != null && this.zzfJ.length > 0) {
                i2 = i;
                for (zzwy zzwy222 : this.zzfJ) {
                    if (zzwy222 != null) {
                        i2 += zzwr.zzc(5, zzwy222);
                    }
                }
                i = i2;
            }
            if (this.zzfK != null && this.zzfK.length > 0) {
                i2 = i;
                for (zzwy zzwy2222 : this.zzfK) {
                    if (zzwy2222 != null) {
                        i2 += zzwr.zzc(6, zzwy2222);
                    }
                }
                i = i2;
            }
            if (this.zzfL != null && this.zzfL.length > 0) {
                i2 = i;
                for (zzwy zzwy22222 : this.zzfL) {
                    if (zzwy22222 != null) {
                        i2 += zzwr.zzc(7, zzwy22222);
                    }
                }
                i = i2;
            }
            if (!this.zzfM.equals("")) {
                i += zzwr.zzj(9, this.zzfM);
            }
            if (!this.zzfN.equals("")) {
                i += zzwr.zzj(10, this.zzfN);
            }
            if (!this.zzfO.equals("0")) {
                i += zzwr.zzj(12, this.zzfO);
            }
            if (!this.version.equals("")) {
                i += zzwr.zzj(13, this.version);
            }
            if (this.zzfP != null) {
                i += zzwr.zzc(14, this.zzfP);
            }
            if (Float.floatToIntBits(this.zzfQ) != Float.floatToIntBits(0.0f)) {
                i += zzwr.zzc(15, this.zzfQ);
            }
            if (this.zzfS != null && this.zzfS.length > 0) {
                i3 = 0;
                zzc = 0;
                for (String str2 : this.zzfS) {
                    if (str2 != null) {
                        zzc++;
                        i3 += zzwr.zzdM(str2);
                    }
                }
                i = (i + i3) + (zzc * 2);
            }
            if (this.zzfT != 0) {
                i += zzwr.zzA(17, this.zzfT);
            }
            if (this.zzfR) {
                i += zzwr.zzc(18, this.zzfR);
            }
            if (this.zzfE == null || this.zzfE.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.zzfE.length) {
                String str3 = this.zzfE[i4];
                if (str3 != null) {
                    i3++;
                    i2 += zzwr.zzdM(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }

        public zzf zzg(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                int zzc;
                Object obj;
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        zzc = zzxb.zzc(zzwq, 10);
                        zzvu = this.zzfF == null ? 0 : this.zzfF.length;
                        obj = new String[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfF, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.readString();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.readString();
                        this.zzfF = obj;
                        continue;
                    case 18:
                        zzc = zzxb.zzc(zzwq, 18);
                        zzvu = this.zzfG == null ? 0 : this.zzfG.length;
                        obj = new com.google.android.gms.internal.zzd.zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfG, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                        zzwq.zza(obj[zzvu]);
                        this.zzfG = obj;
                        continue;
                    case 26:
                        zzc = zzxb.zzc(zzwq, 26);
                        zzvu = this.zzfH == null ? 0 : this.zzfH.length;
                        obj = new zze[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfH, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zze();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zze();
                        zzwq.zza(obj[zzvu]);
                        this.zzfH = obj;
                        continue;
                    case 34:
                        zzc = zzxb.zzc(zzwq, 34);
                        zzvu = this.zzfI == null ? 0 : this.zzfI.length;
                        obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfI, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        zzwq.zza(obj[zzvu]);
                        this.zzfI = obj;
                        continue;
                    case 42:
                        zzc = zzxb.zzc(zzwq, 42);
                        zzvu = this.zzfJ == null ? 0 : this.zzfJ.length;
                        obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfJ, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        zzwq.zza(obj[zzvu]);
                        this.zzfJ = obj;
                        continue;
                    case 50:
                        zzc = zzxb.zzc(zzwq, 50);
                        zzvu = this.zzfK == null ? 0 : this.zzfK.length;
                        obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfK, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        zzwq.zza(obj[zzvu]);
                        this.zzfK = obj;
                        continue;
                    case 58:
                        zzc = zzxb.zzc(zzwq, 58);
                        zzvu = this.zzfL == null ? 0 : this.zzfL.length;
                        obj = new zzg[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfL, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzg();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzg();
                        zzwq.zza(obj[zzvu]);
                        this.zzfL = obj;
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        this.zzfM = zzwq.readString();
                        continue;
                    case Place.TYPE_SCHOOL /*82*/:
                        this.zzfN = zzwq.readString();
                        continue;
                    case 98:
                        this.zzfO = zzwq.readString();
                        continue;
                    case 106:
                        this.version = zzwq.readString();
                        continue;
                    case 114:
                        if (this.zzfP == null) {
                            this.zzfP = new zza();
                        }
                        zzwq.zza(this.zzfP);
                        continue;
                    case 125:
                        this.zzfQ = zzwq.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        zzc = zzxb.zzc(zzwq, TransportMediator.KEYCODE_MEDIA_RECORD);
                        zzvu = this.zzfS == null ? 0 : this.zzfS.length;
                        obj = new String[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfS, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.readString();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.readString();
                        this.zzfS = obj;
                        continue;
                    case 136:
                        this.zzfT = zzwq.zzvx();
                        continue;
                    case 144:
                        this.zzfR = zzwq.zzvy();
                        continue;
                    case 154:
                        zzc = zzxb.zzc(zzwq, 154);
                        zzvu = this.zzfE == null ? 0 : this.zzfE.length;
                        obj = new String[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfE, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.readString();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.readString();
                        this.zzfE = obj;
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

        public zzf zzk() {
            this.zzfE = zzxb.zzaHT;
            this.zzfF = zzxb.zzaHT;
            this.zzfG = com.google.android.gms.internal.zzd.zza.zzr();
            this.zzfH = zze.zzi();
            this.zzfI = zzb.zzd();
            this.zzfJ = zzb.zzd();
            this.zzfK = zzb.zzd();
            this.zzfL = zzg.zzl();
            this.zzfM = "";
            this.zzfN = "";
            this.zzfO = "0";
            this.version = "";
            this.zzfP = null;
            this.zzfQ = 0.0f;
            this.zzfR = false;
            this.zzfS = zzxb.zzaHT;
            this.zzfT = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzg extends zzws<zzg> {
        private static volatile zzg[] zzfU;
        public int[] zzfV;
        public int[] zzfW;
        public int[] zzfX;
        public int[] zzfY;
        public int[] zzfZ;
        public int[] zzga;
        public int[] zzgb;
        public int[] zzgc;
        public int[] zzgd;
        public int[] zzge;

        public zzg() {
            zzm();
        }

        public static zzg[] zzl() {
            if (zzfU == null) {
                synchronized (zzww.zzaHL) {
                    if (zzfU == null) {
                        zzfU = new zzg[0];
                    }
                }
            }
            return zzfU;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) o;
            return (zzww.equals(this.zzfV, zzg.zzfV) && zzww.equals(this.zzfW, zzg.zzfW) && zzww.equals(this.zzfX, zzg.zzfX) && zzww.equals(this.zzfY, zzg.zzfY) && zzww.equals(this.zzfZ, zzg.zzfZ) && zzww.equals(this.zzga, zzg.zzga) && zzww.equals(this.zzgb, zzg.zzgb) && zzww.equals(this.zzgc, zzg.zzgc) && zzww.equals(this.zzgd, zzg.zzgd) && zzww.equals(this.zzge, zzg.zzge)) ? zza((zzws) zzg) : false;
        }

        public int hashCode() {
            return ((((((((((((((((((((zzww.hashCode(this.zzfV) + 527) * 31) + zzww.hashCode(this.zzfW)) * 31) + zzww.hashCode(this.zzfX)) * 31) + zzww.hashCode(this.zzfY)) * 31) + zzww.hashCode(this.zzfZ)) * 31) + zzww.hashCode(this.zzga)) * 31) + zzww.hashCode(this.zzgb)) * 31) + zzww.hashCode(this.zzgc)) * 31) + zzww.hashCode(this.zzgd)) * 31) + zzww.hashCode(this.zzge)) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            int i = 0;
            if (this.zzfV != null && this.zzfV.length > 0) {
                for (int zzy : this.zzfV) {
                    zzwr.zzy(1, zzy);
                }
            }
            if (this.zzfW != null && this.zzfW.length > 0) {
                for (int zzy2 : this.zzfW) {
                    zzwr.zzy(2, zzy2);
                }
            }
            if (this.zzfX != null && this.zzfX.length > 0) {
                for (int zzy22 : this.zzfX) {
                    zzwr.zzy(3, zzy22);
                }
            }
            if (this.zzfY != null && this.zzfY.length > 0) {
                for (int zzy222 : this.zzfY) {
                    zzwr.zzy(4, zzy222);
                }
            }
            if (this.zzfZ != null && this.zzfZ.length > 0) {
                for (int zzy2222 : this.zzfZ) {
                    zzwr.zzy(5, zzy2222);
                }
            }
            if (this.zzga != null && this.zzga.length > 0) {
                for (int zzy22222 : this.zzga) {
                    zzwr.zzy(6, zzy22222);
                }
            }
            if (this.zzgb != null && this.zzgb.length > 0) {
                for (int zzy222222 : this.zzgb) {
                    zzwr.zzy(7, zzy222222);
                }
            }
            if (this.zzgc != null && this.zzgc.length > 0) {
                for (int zzy2222222 : this.zzgc) {
                    zzwr.zzy(8, zzy2222222);
                }
            }
            if (this.zzgd != null && this.zzgd.length > 0) {
                for (int zzy22222222 : this.zzgd) {
                    zzwr.zzy(9, zzy22222222);
                }
            }
            if (this.zzge != null && this.zzge.length > 0) {
                while (i < this.zzge.length) {
                    zzwr.zzy(10, this.zzge[i]);
                    i++;
                }
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzh(zzwq);
        }

        protected int zzc() {
            int i;
            int i2;
            int i3 = 0;
            int zzc = super.zzc();
            if (this.zzfV == null || this.zzfV.length <= 0) {
                i = zzc;
            } else {
                i2 = 0;
                for (int zziw : this.zzfV) {
                    i2 += zzwr.zziw(zziw);
                }
                i = (zzc + i2) + (this.zzfV.length * 1);
            }
            if (this.zzfW != null && this.zzfW.length > 0) {
                zzc = 0;
                for (int zziw2 : this.zzfW) {
                    zzc += zzwr.zziw(zziw2);
                }
                i = (i + zzc) + (this.zzfW.length * 1);
            }
            if (this.zzfX != null && this.zzfX.length > 0) {
                zzc = 0;
                for (int zziw22 : this.zzfX) {
                    zzc += zzwr.zziw(zziw22);
                }
                i = (i + zzc) + (this.zzfX.length * 1);
            }
            if (this.zzfY != null && this.zzfY.length > 0) {
                zzc = 0;
                for (int zziw222 : this.zzfY) {
                    zzc += zzwr.zziw(zziw222);
                }
                i = (i + zzc) + (this.zzfY.length * 1);
            }
            if (this.zzfZ != null && this.zzfZ.length > 0) {
                zzc = 0;
                for (int zziw2222 : this.zzfZ) {
                    zzc += zzwr.zziw(zziw2222);
                }
                i = (i + zzc) + (this.zzfZ.length * 1);
            }
            if (this.zzga != null && this.zzga.length > 0) {
                zzc = 0;
                for (int zziw22222 : this.zzga) {
                    zzc += zzwr.zziw(zziw22222);
                }
                i = (i + zzc) + (this.zzga.length * 1);
            }
            if (this.zzgb != null && this.zzgb.length > 0) {
                zzc = 0;
                for (int zziw222222 : this.zzgb) {
                    zzc += zzwr.zziw(zziw222222);
                }
                i = (i + zzc) + (this.zzgb.length * 1);
            }
            if (this.zzgc != null && this.zzgc.length > 0) {
                zzc = 0;
                for (int zziw2222222 : this.zzgc) {
                    zzc += zzwr.zziw(zziw2222222);
                }
                i = (i + zzc) + (this.zzgc.length * 1);
            }
            if (this.zzgd != null && this.zzgd.length > 0) {
                zzc = 0;
                for (int zziw22222222 : this.zzgd) {
                    zzc += zzwr.zziw(zziw22222222);
                }
                i = (i + zzc) + (this.zzgd.length * 1);
            }
            if (this.zzge == null || this.zzge.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.zzge.length) {
                i2 += zzwr.zziw(this.zzge[i3]);
                i3++;
            }
            return (i + i2) + (this.zzge.length * 1);
        }

        public zzg zzh(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                int zzc;
                Object obj;
                int zzip;
                Object obj2;
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        zzc = zzxb.zzc(zzwq, 8);
                        zzvu = this.zzfV == null ? 0 : this.zzfV.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfV, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzfV = obj;
                        continue;
                    case 10:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzfV == null ? 0 : this.zzfV.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfV, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfV = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 16:
                        zzc = zzxb.zzc(zzwq, 16);
                        zzvu = this.zzfW == null ? 0 : this.zzfW.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfW, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzfW = obj;
                        continue;
                    case 18:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzfW == null ? 0 : this.zzfW.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfW, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfW = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 24:
                        zzc = zzxb.zzc(zzwq, 24);
                        zzvu = this.zzfX == null ? 0 : this.zzfX.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfX, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzfX = obj;
                        continue;
                    case 26:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzfX == null ? 0 : this.zzfX.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfX, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfX = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 32:
                        zzc = zzxb.zzc(zzwq, 32);
                        zzvu = this.zzfY == null ? 0 : this.zzfY.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfY, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzfY = obj;
                        continue;
                    case 34:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzfY == null ? 0 : this.zzfY.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfY, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfY = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 40:
                        zzc = zzxb.zzc(zzwq, 40);
                        zzvu = this.zzfZ == null ? 0 : this.zzfZ.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfZ, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzfZ = obj;
                        continue;
                    case 42:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzfZ == null ? 0 : this.zzfZ.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfZ, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfZ = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 48:
                        zzc = zzxb.zzc(zzwq, 48);
                        zzvu = this.zzga == null ? 0 : this.zzga.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzga, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzga = obj;
                        continue;
                    case 50:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzga == null ? 0 : this.zzga.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzga, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzga = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 56:
                        zzc = zzxb.zzc(zzwq, 56);
                        zzvu = this.zzgb == null ? 0 : this.zzgb.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgb, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzgb = obj;
                        continue;
                    case 58:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzgb == null ? 0 : this.zzgb.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgb, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgb = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 64:
                        zzc = zzxb.zzc(zzwq, 64);
                        zzvu = this.zzgc == null ? 0 : this.zzgc.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgc, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzgc = obj;
                        continue;
                    case 66:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzgc == null ? 0 : this.zzgc.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgc, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgc = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case Place.TYPE_PHARMACY /*72*/:
                        zzc = zzxb.zzc(zzwq, 72);
                        zzvu = this.zzgd == null ? 0 : this.zzgd.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgd, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzgd = obj;
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzgd == null ? 0 : this.zzgd.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgd, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgd = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                        zzc = zzxb.zzc(zzwq, 80);
                        zzvu = this.zzge == null ? 0 : this.zzge.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzge, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzge = obj;
                        continue;
                    case Place.TYPE_SCHOOL /*82*/:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzge == null ? 0 : this.zzge.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzge, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzge = obj2;
                        zzwq.zziq(zzip);
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

        public zzg zzm() {
            this.zzfV = zzxb.zzaHO;
            this.zzfW = zzxb.zzaHO;
            this.zzfX = zzxb.zzaHO;
            this.zzfY = zzxb.zzaHO;
            this.zzfZ = zzxb.zzaHO;
            this.zzga = zzxb.zzaHO;
            this.zzgb = zzxb.zzaHO;
            this.zzgc = zzxb.zzaHO;
            this.zzgd = zzxb.zzaHO;
            this.zzge = zzxb.zzaHO;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzh extends zzws<zzh> {
        public static final zzwt<com.google.android.gms.internal.zzd.zza, zzh> zzgf = zzwt.zza(11, zzh.class, 810);
        private static final zzh[] zzgg = new zzh[0];
        public int[] zzgh;
        public int[] zzgi;
        public int[] zzgj;
        public int zzgk;
        public int[] zzgl;
        public int zzgm;
        public int zzgn;

        public zzh() {
            zzn();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzh)) {
                return false;
            }
            zzh zzh = (zzh) o;
            return (zzww.equals(this.zzgh, zzh.zzgh) && zzww.equals(this.zzgi, zzh.zzgi) && zzww.equals(this.zzgj, zzh.zzgj) && this.zzgk == zzh.zzgk && zzww.equals(this.zzgl, zzh.zzgl) && this.zzgm == zzh.zzgm && this.zzgn == zzh.zzgn) ? zza((zzws) zzh) : false;
        }

        public int hashCode() {
            return ((((((((((((((zzww.hashCode(this.zzgh) + 527) * 31) + zzww.hashCode(this.zzgi)) * 31) + zzww.hashCode(this.zzgj)) * 31) + this.zzgk) * 31) + zzww.hashCode(this.zzgl)) * 31) + this.zzgm) * 31) + this.zzgn) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            int i = 0;
            if (this.zzgh != null && this.zzgh.length > 0) {
                for (int zzy : this.zzgh) {
                    zzwr.zzy(1, zzy);
                }
            }
            if (this.zzgi != null && this.zzgi.length > 0) {
                for (int zzy2 : this.zzgi) {
                    zzwr.zzy(2, zzy2);
                }
            }
            if (this.zzgj != null && this.zzgj.length > 0) {
                for (int zzy22 : this.zzgj) {
                    zzwr.zzy(3, zzy22);
                }
            }
            if (this.zzgk != 0) {
                zzwr.zzy(4, this.zzgk);
            }
            if (this.zzgl != null && this.zzgl.length > 0) {
                while (i < this.zzgl.length) {
                    zzwr.zzy(5, this.zzgl[i]);
                    i++;
                }
            }
            if (this.zzgm != 0) {
                zzwr.zzy(6, this.zzgm);
            }
            if (this.zzgn != 0) {
                zzwr.zzy(7, this.zzgn);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzi(zzwq);
        }

        protected int zzc() {
            int i;
            int i2;
            int i3 = 0;
            int zzc = super.zzc();
            if (this.zzgh == null || this.zzgh.length <= 0) {
                i = zzc;
            } else {
                i2 = 0;
                for (int zziw : this.zzgh) {
                    i2 += zzwr.zziw(zziw);
                }
                i = (zzc + i2) + (this.zzgh.length * 1);
            }
            if (this.zzgi != null && this.zzgi.length > 0) {
                zzc = 0;
                for (int zziw2 : this.zzgi) {
                    zzc += zzwr.zziw(zziw2);
                }
                i = (i + zzc) + (this.zzgi.length * 1);
            }
            if (this.zzgj != null && this.zzgj.length > 0) {
                zzc = 0;
                for (int zziw22 : this.zzgj) {
                    zzc += zzwr.zziw(zziw22);
                }
                i = (i + zzc) + (this.zzgj.length * 1);
            }
            if (this.zzgk != 0) {
                i += zzwr.zzA(4, this.zzgk);
            }
            if (this.zzgl != null && this.zzgl.length > 0) {
                i2 = 0;
                while (i3 < this.zzgl.length) {
                    i2 += zzwr.zziw(this.zzgl[i3]);
                    i3++;
                }
                i = (i + i2) + (this.zzgl.length * 1);
            }
            if (this.zzgm != 0) {
                i += zzwr.zzA(6, this.zzgm);
            }
            return this.zzgn != 0 ? i + zzwr.zzA(7, this.zzgn) : i;
        }

        public zzh zzi(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                int zzc;
                Object obj;
                int zzip;
                Object obj2;
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        zzc = zzxb.zzc(zzwq, 8);
                        zzvu = this.zzgh == null ? 0 : this.zzgh.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgh, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzgh = obj;
                        continue;
                    case 10:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzgh == null ? 0 : this.zzgh.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgh, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgh = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 16:
                        zzc = zzxb.zzc(zzwq, 16);
                        zzvu = this.zzgi == null ? 0 : this.zzgi.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgi, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzgi = obj;
                        continue;
                    case 18:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzgi == null ? 0 : this.zzgi.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgi, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgi = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 24:
                        zzc = zzxb.zzc(zzwq, 24);
                        zzvu = this.zzgj == null ? 0 : this.zzgj.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgj, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzgj = obj;
                        continue;
                    case 26:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzgj == null ? 0 : this.zzgj.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgj, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgj = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 32:
                        this.zzgk = zzwq.zzvx();
                        continue;
                    case 40:
                        zzc = zzxb.zzc(zzwq, 40);
                        zzvu = this.zzgl == null ? 0 : this.zzgl.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgl, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzgl = obj;
                        continue;
                    case 42:
                        zzip = zzwq.zzip(zzwq.zzvB());
                        zzc = zzwq.getPosition();
                        zzvu = 0;
                        while (zzwq.zzvG() > 0) {
                            zzwq.zzvx();
                            zzvu++;
                        }
                        zzwq.zzir(zzc);
                        zzc = this.zzgl == null ? 0 : this.zzgl.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgl, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgl = obj2;
                        zzwq.zziq(zzip);
                        continue;
                    case 48:
                        this.zzgm = zzwq.zzvx();
                        continue;
                    case 56:
                        this.zzgn = zzwq.zzvx();
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

        public zzh zzn() {
            this.zzgh = zzxb.zzaHO;
            this.zzgi = zzxb.zzaHO;
            this.zzgj = zzxb.zzaHO;
            this.zzgk = 0;
            this.zzgl = zzxb.zzaHO;
            this.zzgm = 0;
            this.zzgn = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzi extends zzws<zzi> {
        private static volatile zzi[] zzgo;
        public String name;
        public com.google.android.gms.internal.zzd.zza zzgp;
        public zzd zzgq;

        public zzi() {
            zzp();
        }

        public static zzi[] zzo() {
            if (zzgo == null) {
                synchronized (zzww.zzaHL) {
                    if (zzgo == null) {
                        zzgo = new zzi[0];
                    }
                }
            }
            return zzgo;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzi)) {
                return false;
            }
            zzi zzi = (zzi) o;
            if (this.name == null) {
                if (zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzi.name)) {
                return false;
            }
            if (this.zzgp == null) {
                if (zzi.zzgp != null) {
                    return false;
                }
            } else if (!this.zzgp.equals(zzi.zzgp)) {
                return false;
            }
            if (this.zzgq == null) {
                if (zzi.zzgq != null) {
                    return false;
                }
            } else if (!this.zzgq.equals(zzi.zzgq)) {
                return false;
            }
            return zza((zzws) zzi);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzgp == null ? 0 : this.zzgp.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.zzgq != null) {
                i = this.zzgq.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            if (!this.name.equals("")) {
                zzwr.zzb(1, this.name);
            }
            if (this.zzgp != null) {
                zzwr.zza(2, this.zzgp);
            }
            if (this.zzgq != null) {
                zzwr.zza(3, this.zzgq);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzj(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (!this.name.equals("")) {
                zzc += zzwr.zzj(1, this.name);
            }
            if (this.zzgp != null) {
                zzc += zzwr.zzc(2, this.zzgp);
            }
            return this.zzgq != null ? zzc + zzwr.zzc(3, this.zzgq) : zzc;
        }

        public zzi zzj(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzwq.readString();
                        continue;
                    case 18:
                        if (this.zzgp == null) {
                            this.zzgp = new com.google.android.gms.internal.zzd.zza();
                        }
                        zzwq.zza(this.zzgp);
                        continue;
                    case 26:
                        if (this.zzgq == null) {
                            this.zzgq = new zzd();
                        }
                        zzwq.zza(this.zzgq);
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

        public zzi zzp() {
            this.name = "";
            this.zzgp = null;
            this.zzgq = null;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzj extends zzws<zzj> {
        public zzi[] zzgr;
        public zzf zzgs;
        public String zzgt;

        public zzj() {
            zzq();
        }

        public static zzj zzb(byte[] bArr) throws zzwx {
            return (zzj) zzwy.zza(new zzj(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzj)) {
                return false;
            }
            zzj zzj = (zzj) o;
            if (!zzww.equals(this.zzgr, zzj.zzgr)) {
                return false;
            }
            if (this.zzgs == null) {
                if (zzj.zzgs != null) {
                    return false;
                }
            } else if (!this.zzgs.equals(zzj.zzgs)) {
                return false;
            }
            if (this.zzgt == null) {
                if (zzj.zzgt != null) {
                    return false;
                }
            } else if (!this.zzgt.equals(zzj.zzgt)) {
                return false;
            }
            return zza((zzws) zzj);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzgs == null ? 0 : this.zzgs.hashCode()) + ((zzww.hashCode(this.zzgr) + 527) * 31)) * 31;
            if (this.zzgt != null) {
                i = this.zzgt.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            if (this.zzgr != null && this.zzgr.length > 0) {
                for (zzwy zzwy : this.zzgr) {
                    if (zzwy != null) {
                        zzwr.zza(1, zzwy);
                    }
                }
            }
            if (this.zzgs != null) {
                zzwr.zza(2, this.zzgs);
            }
            if (!this.zzgt.equals("")) {
                zzwr.zzb(3, this.zzgt);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzk(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzgr != null && this.zzgr.length > 0) {
                for (zzwy zzwy : this.zzgr) {
                    if (zzwy != null) {
                        zzc += zzwr.zzc(1, zzwy);
                    }
                }
            }
            if (this.zzgs != null) {
                zzc += zzwr.zzc(2, this.zzgs);
            }
            return !this.zzgt.equals("") ? zzc + zzwr.zzj(3, this.zzgt) : zzc;
        }

        public zzj zzk(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzxb.zzc(zzwq, 10);
                        zzvu = this.zzgr == null ? 0 : this.zzgr.length;
                        Object obj = new zzi[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgr, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzi();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzi();
                        zzwq.zza(obj[zzvu]);
                        this.zzgr = obj;
                        continue;
                    case 18:
                        if (this.zzgs == null) {
                            this.zzgs = new zzf();
                        }
                        zzwq.zza(this.zzgs);
                        continue;
                    case 26:
                        this.zzgt = zzwq.readString();
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

        public zzj zzq() {
            this.zzgr = zzi.zzo();
            this.zzgs = null;
            this.zzgt = "";
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
