package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.util.Arrays;

public interface zzxf {

    public static final class zza extends zzws<zza> {
        public String[] zzaIP;
        public String[] zzaIQ;
        public int[] zzaIR;

        public zza() {
            zzwo();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            return (zzww.equals(this.zzaIP, zza.zzaIP) && zzww.equals(this.zzaIQ, zza.zzaIQ) && zzww.equals(this.zzaIR, zza.zzaIR)) ? zza((zzws) zza) : false;
        }

        public int hashCode() {
            return ((((((zzww.hashCode(this.zzaIP) + 527) * 31) + zzww.hashCode(this.zzaIQ)) * 31) + zzww.hashCode(this.zzaIR)) * 31) + zzvL();
        }

        public zza zzK(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                int zzc;
                Object obj;
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        zzc = zzxb.zzc(zzwq, 10);
                        zzvu = this.zzaIP == null ? 0 : this.zzaIP.length;
                        obj = new String[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIP, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.readString();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.readString();
                        this.zzaIP = obj;
                        continue;
                    case 18:
                        zzc = zzxb.zzc(zzwq, 18);
                        zzvu = this.zzaIQ == null ? 0 : this.zzaIQ.length;
                        obj = new String[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIQ, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.readString();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.readString();
                        this.zzaIQ = obj;
                        continue;
                    case 24:
                        zzc = zzxb.zzc(zzwq, 24);
                        zzvu = this.zzaIR == null ? 0 : this.zzaIR.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIR, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.zzvx();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.zzvx();
                        this.zzaIR = obj;
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
                        zzc = this.zzaIR == null ? 0 : this.zzaIR.length;
                        Object obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzaIR, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = zzwq.zzvx();
                            zzc++;
                        }
                        this.zzaIR = obj2;
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

        public void zza(zzwr zzwr) throws IOException {
            int i = 0;
            if (this.zzaIP != null && this.zzaIP.length > 0) {
                for (String str : this.zzaIP) {
                    if (str != null) {
                        zzwr.zzb(1, str);
                    }
                }
            }
            if (this.zzaIQ != null && this.zzaIQ.length > 0) {
                for (String str2 : this.zzaIQ) {
                    if (str2 != null) {
                        zzwr.zzb(2, str2);
                    }
                }
            }
            if (this.zzaIR != null && this.zzaIR.length > 0) {
                while (i < this.zzaIR.length) {
                    zzwr.zzy(3, this.zzaIR[i]);
                    i++;
                }
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzK(zzwq);
        }

        protected int zzc() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzc = super.zzc();
            if (this.zzaIP == null || this.zzaIP.length <= 0) {
                i = zzc;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzaIP) {
                    if (str != null) {
                        i3++;
                        i2 += zzwr.zzdM(str);
                    }
                }
                i = (zzc + i2) + (i3 * 1);
            }
            if (this.zzaIQ != null && this.zzaIQ.length > 0) {
                i3 = 0;
                zzc = 0;
                for (String str2 : this.zzaIQ) {
                    if (str2 != null) {
                        zzc++;
                        i3 += zzwr.zzdM(str2);
                    }
                }
                i = (i + i3) + (zzc * 1);
            }
            if (this.zzaIR == null || this.zzaIR.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.zzaIR.length) {
                i2 += zzwr.zziw(this.zzaIR[i4]);
                i4++;
            }
            return (i + i2) + (this.zzaIR.length * 1);
        }

        public zza zzwo() {
            this.zzaIP = zzxb.zzaHT;
            this.zzaIQ = zzxb.zzaHT;
            this.zzaIR = zzxb.zzaHO;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzb extends zzws<zzb> {
        public String version;
        public int zzaIS;
        public String zzaIT;

        public zzb() {
            zzwp();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.zzaIS != zzb.zzaIS) {
                return false;
            }
            if (this.zzaIT == null) {
                if (zzb.zzaIT != null) {
                    return false;
                }
            } else if (!this.zzaIT.equals(zzb.zzaIT)) {
                return false;
            }
            if (this.version == null) {
                if (zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzb.version)) {
                return false;
            }
            return zza((zzws) zzb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaIT == null ? 0 : this.zzaIT.hashCode()) + ((this.zzaIS + 527) * 31)) * 31;
            if (this.version != null) {
                i = this.version.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public zzb zzL(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        zzvu = zzwq.zzvx();
                        switch (zzvu) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                                this.zzaIS = zzvu;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzaIT = zzwq.readString();
                        continue;
                    case 26:
                        this.version = zzwq.readString();
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
            if (this.zzaIS != 0) {
                zzwr.zzy(1, this.zzaIS);
            }
            if (!this.zzaIT.equals("")) {
                zzwr.zzb(2, this.zzaIT);
            }
            if (!this.version.equals("")) {
                zzwr.zzb(3, this.version);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzL(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaIS != 0) {
                zzc += zzwr.zzA(1, this.zzaIS);
            }
            if (!this.zzaIT.equals("")) {
                zzc += zzwr.zzj(2, this.zzaIT);
            }
            return !this.version.equals("") ? zzc + zzwr.zzj(3, this.version) : zzc;
        }

        public zzb zzwp() {
            this.zzaIS = 0;
            this.zzaIT = "";
            this.version = "";
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzc extends zzws<zzc> {
        public byte[] zzaIU;
        public byte[][] zzaIV;
        public boolean zzaIW;

        public zzc() {
            zzwq();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            return (Arrays.equals(this.zzaIU, zzc.zzaIU) && zzww.zza(this.zzaIV, zzc.zzaIV) && this.zzaIW == zzc.zzaIW) ? zza((zzws) zzc) : false;
        }

        public int hashCode() {
            return (((this.zzaIW ? 1231 : 1237) + ((((Arrays.hashCode(this.zzaIU) + 527) * 31) + zzww.zza(this.zzaIV)) * 31)) * 31) + zzvL();
        }

        public zzc zzM(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzaIU = zzwq.readBytes();
                        continue;
                    case 18:
                        int zzc = zzxb.zzc(zzwq, 18);
                        zzvu = this.zzaIV == null ? 0 : this.zzaIV.length;
                        Object obj = new byte[(zzc + zzvu)][];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIV, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = zzwq.readBytes();
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = zzwq.readBytes();
                        this.zzaIV = obj;
                        continue;
                    case 24:
                        this.zzaIW = zzwq.zzvy();
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
            if (!Arrays.equals(this.zzaIU, zzxb.zzaHV)) {
                zzwr.zza(1, this.zzaIU);
            }
            if (this.zzaIV != null && this.zzaIV.length > 0) {
                for (byte[] bArr : this.zzaIV) {
                    if (bArr != null) {
                        zzwr.zza(2, bArr);
                    }
                }
            }
            if (this.zzaIW) {
                zzwr.zzb(3, this.zzaIW);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzM(zzwq);
        }

        protected int zzc() {
            int i = 0;
            int zzc = super.zzc();
            if (!Arrays.equals(this.zzaIU, zzxb.zzaHV)) {
                zzc += zzwr.zzb(1, this.zzaIU);
            }
            if (this.zzaIV != null && this.zzaIV.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.zzaIV.length) {
                    byte[] bArr = this.zzaIV[i];
                    if (bArr != null) {
                        i3++;
                        i2 += zzwr.zzw(bArr);
                    }
                    i++;
                }
                zzc = (zzc + i2) + (i3 * 1);
            }
            return this.zzaIW ? zzc + zzwr.zzc(3, this.zzaIW) : zzc;
        }

        public zzc zzwq() {
            this.zzaIU = zzxb.zzaHV;
            this.zzaIV = zzxb.zzaHU;
            this.zzaIW = false;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zzd extends zzws<zzd> {
        public String tag;
        public long zzaIX;
        public int zzaIY;
        public int zzaIZ;
        public boolean zzaJa;
        public zze[] zzaJb;
        public zzb zzaJc;
        public byte[] zzaJd;
        public byte[] zzaJe;
        public byte[] zzaJf;
        public zza zzaJg;
        public String zzaJh;
        public long zzaJi;
        public zzc zzaJj;

        public zzd() {
            zzwr();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (this.zzaIX != zzd.zzaIX) {
                return false;
            }
            if (this.tag == null) {
                if (zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(zzd.tag)) {
                return false;
            }
            if (this.zzaIY != zzd.zzaIY || this.zzaIZ != zzd.zzaIZ || this.zzaJa != zzd.zzaJa || !zzww.equals(this.zzaJb, zzd.zzaJb)) {
                return false;
            }
            if (this.zzaJc == null) {
                if (zzd.zzaJc != null) {
                    return false;
                }
            } else if (!this.zzaJc.equals(zzd.zzaJc)) {
                return false;
            }
            if (!Arrays.equals(this.zzaJd, zzd.zzaJd) || !Arrays.equals(this.zzaJe, zzd.zzaJe) || !Arrays.equals(this.zzaJf, zzd.zzaJf)) {
                return false;
            }
            if (this.zzaJg == null) {
                if (zzd.zzaJg != null) {
                    return false;
                }
            } else if (!this.zzaJg.equals(zzd.zzaJg)) {
                return false;
            }
            if (this.zzaJh == null) {
                if (zzd.zzaJh != null) {
                    return false;
                }
            } else if (!this.zzaJh.equals(zzd.zzaJh)) {
                return false;
            }
            if (this.zzaJi != zzd.zzaJi) {
                return false;
            }
            if (this.zzaJj == null) {
                if (zzd.zzaJj != null) {
                    return false;
                }
            } else if (!this.zzaJj.equals(zzd.zzaJj)) {
                return false;
            }
            return zza((zzws) zzd);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzaJh == null ? 0 : this.zzaJh.hashCode()) + (((this.zzaJg == null ? 0 : this.zzaJg.hashCode()) + (((((((((this.zzaJc == null ? 0 : this.zzaJc.hashCode()) + (((((this.zzaJa ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((int) (this.zzaIX ^ (this.zzaIX >>> 32))) + 527) * 31)) * 31) + this.zzaIY) * 31) + this.zzaIZ) * 31)) * 31) + zzww.hashCode(this.zzaJb)) * 31)) * 31) + Arrays.hashCode(this.zzaJd)) * 31) + Arrays.hashCode(this.zzaJe)) * 31) + Arrays.hashCode(this.zzaJf)) * 31)) * 31)) * 31) + ((int) (this.zzaJi ^ (this.zzaJi >>> 32)))) * 31;
            if (this.zzaJj != null) {
                i = this.zzaJj.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public zzd zzN(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaIX = zzwq.zzvw();
                        continue;
                    case 18:
                        this.tag = zzwq.readString();
                        continue;
                    case 26:
                        int zzc = zzxb.zzc(zzwq, 26);
                        zzvu = this.zzaJb == null ? 0 : this.zzaJb.length;
                        Object obj = new zze[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaJb, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zze();
                            zzwq.zza(obj[zzvu]);
                            zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zze();
                        zzwq.zza(obj[zzvu]);
                        this.zzaJb = obj;
                        continue;
                    case 50:
                        this.zzaJd = zzwq.readBytes();
                        continue;
                    case 58:
                        if (this.zzaJg == null) {
                            this.zzaJg = new zza();
                        }
                        zzwq.zza(this.zzaJg);
                        continue;
                    case 66:
                        this.zzaJe = zzwq.readBytes();
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        if (this.zzaJc == null) {
                            this.zzaJc = new zzb();
                        }
                        zzwq.zza(this.zzaJc);
                        continue;
                    case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                        this.zzaJa = zzwq.zzvy();
                        continue;
                    case Place.TYPE_STORE /*88*/:
                        this.zzaIY = zzwq.zzvx();
                        continue;
                    case Place.TYPE_ZOO /*96*/:
                        this.zzaIZ = zzwq.zzvx();
                        continue;
                    case 106:
                        this.zzaJf = zzwq.readBytes();
                        continue;
                    case 114:
                        this.zzaJh = zzwq.readString();
                        continue;
                    case 120:
                        this.zzaJi = zzwq.zzvA();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        if (this.zzaJj == null) {
                            this.zzaJj = new zzc();
                        }
                        zzwq.zza(this.zzaJj);
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
            if (this.zzaIX != 0) {
                zzwr.zzb(1, this.zzaIX);
            }
            if (!this.tag.equals("")) {
                zzwr.zzb(2, this.tag);
            }
            if (this.zzaJb != null && this.zzaJb.length > 0) {
                for (zzwy zzwy : this.zzaJb) {
                    if (zzwy != null) {
                        zzwr.zza(3, zzwy);
                    }
                }
            }
            if (!Arrays.equals(this.zzaJd, zzxb.zzaHV)) {
                zzwr.zza(6, this.zzaJd);
            }
            if (this.zzaJg != null) {
                zzwr.zza(7, this.zzaJg);
            }
            if (!Arrays.equals(this.zzaJe, zzxb.zzaHV)) {
                zzwr.zza(8, this.zzaJe);
            }
            if (this.zzaJc != null) {
                zzwr.zza(9, this.zzaJc);
            }
            if (this.zzaJa) {
                zzwr.zzb(10, this.zzaJa);
            }
            if (this.zzaIY != 0) {
                zzwr.zzy(11, this.zzaIY);
            }
            if (this.zzaIZ != 0) {
                zzwr.zzy(12, this.zzaIZ);
            }
            if (!Arrays.equals(this.zzaJf, zzxb.zzaHV)) {
                zzwr.zza(13, this.zzaJf);
            }
            if (!this.zzaJh.equals("")) {
                zzwr.zzb(14, this.zzaJh);
            }
            if (this.zzaJi != 180000) {
                zzwr.zzc(15, this.zzaJi);
            }
            if (this.zzaJj != null) {
                zzwr.zza(16, this.zzaJj);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzN(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaIX != 0) {
                zzc += zzwr.zzd(1, this.zzaIX);
            }
            if (!this.tag.equals("")) {
                zzc += zzwr.zzj(2, this.tag);
            }
            if (this.zzaJb != null && this.zzaJb.length > 0) {
                int i = zzc;
                for (zzwy zzwy : this.zzaJb) {
                    if (zzwy != null) {
                        i += zzwr.zzc(3, zzwy);
                    }
                }
                zzc = i;
            }
            if (!Arrays.equals(this.zzaJd, zzxb.zzaHV)) {
                zzc += zzwr.zzb(6, this.zzaJd);
            }
            if (this.zzaJg != null) {
                zzc += zzwr.zzc(7, this.zzaJg);
            }
            if (!Arrays.equals(this.zzaJe, zzxb.zzaHV)) {
                zzc += zzwr.zzb(8, this.zzaJe);
            }
            if (this.zzaJc != null) {
                zzc += zzwr.zzc(9, this.zzaJc);
            }
            if (this.zzaJa) {
                zzc += zzwr.zzc(10, this.zzaJa);
            }
            if (this.zzaIY != 0) {
                zzc += zzwr.zzA(11, this.zzaIY);
            }
            if (this.zzaIZ != 0) {
                zzc += zzwr.zzA(12, this.zzaIZ);
            }
            if (!Arrays.equals(this.zzaJf, zzxb.zzaHV)) {
                zzc += zzwr.zzb(13, this.zzaJf);
            }
            if (!this.zzaJh.equals("")) {
                zzc += zzwr.zzj(14, this.zzaJh);
            }
            if (this.zzaJi != 180000) {
                zzc += zzwr.zze(15, this.zzaJi);
            }
            return this.zzaJj != null ? zzc + zzwr.zzc(16, this.zzaJj) : zzc;
        }

        public zzd zzwr() {
            this.zzaIX = 0;
            this.tag = "";
            this.zzaIY = 0;
            this.zzaIZ = 0;
            this.zzaJa = false;
            this.zzaJb = zze.zzws();
            this.zzaJc = null;
            this.zzaJd = zzxb.zzaHV;
            this.zzaJe = zzxb.zzaHV;
            this.zzaJf = zzxb.zzaHV;
            this.zzaJg = null;
            this.zzaJh = "";
            this.zzaJi = 180000;
            this.zzaJj = null;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public static final class zze extends zzws<zze> {
        private static volatile zze[] zzaJk;
        public String value;
        public String zzfv;

        public zze() {
            zzwt();
        }

        public static zze[] zzws() {
            if (zzaJk == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaJk == null) {
                        zzaJk = new zze[0];
                    }
                }
            }
            return zzaJk;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zze = (zze) o;
            if (this.zzfv == null) {
                if (zze.zzfv != null) {
                    return false;
                }
            } else if (!this.zzfv.equals(zze.zzfv)) {
                return false;
            }
            if (this.value == null) {
                if (zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(zze.value)) {
                return false;
            }
            return zza((zzws) zze);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzfv == null ? 0 : this.zzfv.hashCode()) + 527) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public zze zzO(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzfv = zzwq.readString();
                        continue;
                    case 18:
                        this.value = zzwq.readString();
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
            if (!this.zzfv.equals("")) {
                zzwr.zzb(1, this.zzfv);
            }
            if (!this.value.equals("")) {
                zzwr.zzb(2, this.value);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzO(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (!this.zzfv.equals("")) {
                zzc += zzwr.zzj(1, this.zzfv);
            }
            return !this.value.equals("") ? zzc + zzwr.zzj(2, this.value) : zzc;
        }

        public zze zzwt() {
            this.zzfv = "";
            this.value = "";
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
