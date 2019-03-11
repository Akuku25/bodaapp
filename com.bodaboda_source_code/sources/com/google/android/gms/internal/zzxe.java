package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import java.io.IOException;

public interface zzxe {

    public static final class zza extends zzwy {
        public String description;
        public String name;
        public Long zzaIL;
        public Long zzaIM;
        public Long zzaIN;
        public Integer zzaIO;
        public com.google.android.gms.internal.zzxc.zza zzaIe;
        public String zzfl;

        public zza() {
            zzwn();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.zzfl == null) {
                if (zza.zzfl != null) {
                    return false;
                }
            } else if (!this.zzfl.equals(zza.zzfl)) {
                return false;
            }
            if (this.name == null) {
                if (zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zza.name)) {
                return false;
            }
            if (this.description == null) {
                if (zza.description != null) {
                    return false;
                }
            } else if (!this.description.equals(zza.description)) {
                return false;
            }
            if (this.zzaIL == null) {
                if (zza.zzaIL != null) {
                    return false;
                }
            } else if (!this.zzaIL.equals(zza.zzaIL)) {
                return false;
            }
            if (this.zzaIM == null) {
                if (zza.zzaIM != null) {
                    return false;
                }
            } else if (!this.zzaIM.equals(zza.zzaIM)) {
                return false;
            }
            if (this.zzaIN == null) {
                if (zza.zzaIN != null) {
                    return false;
                }
            } else if (!this.zzaIN.equals(zza.zzaIN)) {
                return false;
            }
            if (this.zzaIe == null) {
                if (zza.zzaIe != null) {
                    return false;
                }
            } else if (!this.zzaIe.equals(zza.zzaIe)) {
                return false;
            }
            return this.zzaIO == null ? zza.zzaIO == null : this.zzaIO.equals(zza.zzaIO);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaIe == null ? 0 : this.zzaIe.hashCode()) + (((this.zzaIN == null ? 0 : this.zzaIN.hashCode()) + (((this.zzaIM == null ? 0 : this.zzaIM.hashCode()) + (((this.zzaIL == null ? 0 : this.zzaIL.hashCode()) + (((this.description == null ? 0 : this.description.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzfl == null ? 0 : this.zzfl.hashCode()) + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzaIO != null) {
                i = this.zzaIO.hashCode();
            }
            return hashCode + i;
        }

        public zza zzJ(zzwq zzwq) throws IOException {
            while (true) {
                int zzvu = zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzfl = zzwq.readString();
                        continue;
                    case 18:
                        this.name = zzwq.readString();
                        continue;
                    case 26:
                        this.description = zzwq.readString();
                        continue;
                    case 32:
                        this.zzaIL = Long.valueOf(zzwq.zzvw());
                        continue;
                    case 40:
                        this.zzaIM = Long.valueOf(zzwq.zzvw());
                        continue;
                    case 64:
                        this.zzaIN = Long.valueOf(zzwq.zzvw());
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        if (this.zzaIe == null) {
                            this.zzaIe = new com.google.android.gms.internal.zzxc.zza();
                        }
                        zzwq.zza(this.zzaIe);
                        continue;
                    case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                        this.zzaIO = Integer.valueOf(zzwq.zzvx());
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
            if (this.zzfl != null) {
                zzwr.zzb(1, this.zzfl);
            }
            if (this.name != null) {
                zzwr.zzb(2, this.name);
            }
            if (this.description != null) {
                zzwr.zzb(3, this.description);
            }
            if (this.zzaIL != null) {
                zzwr.zzb(4, this.zzaIL.longValue());
            }
            if (this.zzaIM != null) {
                zzwr.zzb(5, this.zzaIM.longValue());
            }
            if (this.zzaIN != null) {
                zzwr.zzb(8, this.zzaIN.longValue());
            }
            if (this.zzaIe != null) {
                zzwr.zza(9, this.zzaIe);
            }
            if (this.zzaIO != null) {
                zzwr.zzy(10, this.zzaIO.intValue());
            }
            super.zza(zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq zzwq) throws IOException {
            return zzJ(zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzfl != null) {
                zzc += zzwr.zzj(1, this.zzfl);
            }
            if (this.name != null) {
                zzc += zzwr.zzj(2, this.name);
            }
            if (this.description != null) {
                zzc += zzwr.zzj(3, this.description);
            }
            if (this.zzaIL != null) {
                zzc += zzwr.zzd(4, this.zzaIL.longValue());
            }
            if (this.zzaIM != null) {
                zzc += zzwr.zzd(5, this.zzaIM.longValue());
            }
            if (this.zzaIN != null) {
                zzc += zzwr.zzd(8, this.zzaIN.longValue());
            }
            if (this.zzaIe != null) {
                zzc += zzwr.zzc(9, this.zzaIe);
            }
            return this.zzaIO != null ? zzc + zzwr.zzA(10, this.zzaIO.intValue()) : zzc;
        }

        public zza zzwn() {
            this.zzfl = null;
            this.name = null;
            this.description = null;
            this.zzaIL = null;
            this.zzaIM = null;
            this.zzaIN = null;
            this.zzaIe = null;
            this.zzaIO = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
