package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzxc.zzc;
import com.google.android.gms.internal.zzxc.zzd;
import java.util.List;

public class zzmp {
    public static final zzmp zzZU = new zzmp();

    public zzc zzc(DataType dataType) {
        zzc zzc = new zzc();
        zzc.name = dataType.getName();
        List fields = dataType.getFields();
        zzc.zzaIf = new zzd[fields.size()];
        for (int i = 0; i < fields.size(); i++) {
            zzc.zzaIf[i] = zzmq.zzZV.zzb((Field) fields.get(i));
        }
        return zzc;
    }
}
