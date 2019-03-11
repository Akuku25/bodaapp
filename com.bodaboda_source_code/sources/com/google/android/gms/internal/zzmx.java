package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.internal.zzxc.zzd;
import com.google.android.gms.internal.zzxc.zzf;

public class zzmx {
    public static Value zza(zzd zzd, zzf zzf) {
        if (zzf == null) {
            return null;
        }
        Value value = new Value(zzd.zzaIh.intValue());
        if (zzf.zzaIp != null) {
            zzx.zzb(zzd.zzaIh.intValue() == 2, "Field format %d does not match stored value %s", zzd.zzaIh, zzf.zzaIp);
            value.setFloat(zzf.zzaIp.floatValue());
        } else if (zzf.zzaIo != null) {
            zzx.zzb(zzd.zzaIh.intValue() == 1, "Field format %d does not match stored value %s", zzd.zzaIh, zzf.zzaIo);
            value.setInt(zzf.zzaIo.intValue());
        }
        return value;
    }

    public static Value[] zza(zzd[] zzdArr, zzf[] zzfArr) {
        Value[] valueArr = new Value[zzfArr.length];
        int min = Math.min(zzdArr.length, zzfArr.length);
        for (int i = 0; i < min; i++) {
            valueArr[i] = zza(zzdArr[i], zzfArr[i]);
        }
        return valueArr;
    }

    public static zzf[] zza(Value[] valueArr) {
        zzf[] zzfArr = new zzf[valueArr.length];
        for (int i = 0; i < valueArr.length; i++) {
            zzfArr[i] = zzb(valueArr[i]);
        }
        return zzfArr;
    }

    public static zzf zzb(Value value) {
        zzf zzf = new zzf();
        if (value != null && value.isSet()) {
            if (2 == value.getFormat()) {
                zzf.zzaIp = Double.valueOf((double) value.asFloat());
            } else if (1 == value.getFormat()) {
                zzf.zzaIo = Integer.valueOf(value.asInt());
            } else {
                throw new IllegalArgumentException("unknown type: " + value.getFormat() + " in: " + value);
            }
        }
        return zzf;
    }
}
