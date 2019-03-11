package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.internal.zzxc.zzd;
import com.google.android.gms.internal.zzxd.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzmu {
    public static RawDataPoint zza(zzd[] zzdArr, zzb zzb) {
        return new RawDataPoint(4, zzb.zzaIA, zzmt.zza(zzb), zzmx.zza(zzdArr, zzb.zzaIC), zzb.zzaID, zzb.zzaIF, zzmt.zzb(zzb), zzmt.zzc(zzb));
    }

    public static List<RawDataPoint> zza(zzd[] zzdArr, zzb[] zzbArr) {
        List<RawDataPoint> arrayList = new ArrayList(zzbArr.length);
        for (zzb zza : zzbArr) {
            arrayList.add(zza(zzdArr, zza));
        }
        return arrayList;
    }

    public static zzb zzb(RawDataPoint rawDataPoint) {
        zzb zzb = new zzb();
        zzb.zzaIA = rawDataPoint.zzYG;
        zzb.zzaIC = zzmx.zza(rawDataPoint.zzYI);
        zzb.zzaID = rawDataPoint.zzZJ;
        zzb.zzaIF = rawDataPoint.zzZK;
        zzb.zzaIB = rawDataPoint.zzYH;
        zzb.zzaIH = rawDataPoint.zzYK;
        zzb.zzaII = rawDataPoint.zzYL;
        return zzb;
    }

    public static zzb[] zzl(List<RawDataPoint> list) {
        zzb[] zzbArr = new zzb[list.size()];
        for (int i = 0; i < list.size(); i++) {
            zzbArr[i] = zzb((RawDataPoint) list.get(i));
        }
        return zzbArr;
    }
}
