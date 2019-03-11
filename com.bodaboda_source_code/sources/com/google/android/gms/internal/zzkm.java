package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.zzw;

public final class zzkm extends zzkv<zza, Drawable> {

    public static final class zza {
        public final int zzPk;
        public final int zzPl;

        public zza(int i, int i2) {
            this.zzPk = i;
            this.zzPl = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza zza = (zza) obj;
            return zza.zzPk == this.zzPk && zza.zzPl == this.zzPl;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.zzPk), Integer.valueOf(this.zzPl));
        }
    }

    public zzkm() {
        super(10);
    }
}
