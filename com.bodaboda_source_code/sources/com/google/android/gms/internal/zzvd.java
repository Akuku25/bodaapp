package com.google.android.gms.internal;

import com.google.android.gms.internal.zzc.zzf;
import com.google.android.gms.internal.zzc.zzj;
import java.io.IOException;

public interface zzvd {

    public static final class zza extends zzws<zza> {
        public long zzaBK;
        public zzj zzaBL;
        public zzf zzgs;

        public zza() {
            zzug();
        }

        public static zza zzm(byte[] bArr) throws zzwx {
            return (zza) zzwy.zza(new zza(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.zzaBK != zza.zzaBK) {
                return false;
            }
            if (this.zzgs == null) {
                if (zza.zzgs != null) {
                    return false;
                }
            } else if (!this.zzgs.equals(zza.zzgs)) {
                return false;
            }
            if (this.zzaBL == null) {
                if (zza.zzaBL != null) {
                    return false;
                }
            } else if (!this.zzaBL.equals(zza.zzaBL)) {
                return false;
            }
            return zza((zzws) zza);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzgs == null ? 0 : this.zzgs.hashCode()) + ((((int) (this.zzaBK ^ (this.zzaBK >>> 32))) + 527) * 31)) * 31;
            if (this.zzaBL != null) {
                i = this.zzaBL.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr zzwr) throws IOException {
            zzwr.zzb(1, this.zzaBK);
            if (this.zzgs != null) {
                zzwr.zza(2, this.zzgs);
            }
            if (this.zzaBL != null) {
                zzwr.zza(3, this.zzaBL);
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzt(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc() + zzwr.zzd(1, this.zzaBK);
            if (this.zzgs != null) {
                zzc += zzwr.zzc(2, this.zzgs);
            }
            return this.zzaBL != null ? zzc + zzwr.zzc(3, this.zzaBL) : zzc;
        }

        public zza zzt(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaBK = zzwq.zzvw();
                        continue;
                    case 18:
                        if (this.zzgs == null) {
                            this.zzgs = new zzf();
                        }
                        zzwq.zza(this.zzgs);
                        continue;
                    case 26:
                        if (this.zzaBL == null) {
                            this.zzaBL = new zzj();
                        }
                        zzwq.zza(this.zzaBL);
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

        public zza zzug() {
            this.zzaBK = 0;
            this.zzgs = null;
            this.zzaBL = null;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
