package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.internal.zzxd.zzc;
import java.util.List;

public class zzmv {
    public static zzc zzb(RawDataSet rawDataSet) {
        zzc zzc = new zzc();
        zzc.zzaID = rawDataSet.zzZJ;
        zzc.zzaIK = zzmu.zzl(rawDataSet.zzZM);
        zzc.zzaIx = rawDataSet.zzYF;
        return zzc;
    }

    public static zzc[] zzm(List<RawDataSet> list) {
        zzc[] zzcArr = new zzc[list.size()];
        for (int i = 0; i < list.size(); i++) {
            zzcArr[i] = zzb((RawDataSet) list.get(i));
        }
        return zzcArr;
    }
}
