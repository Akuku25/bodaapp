package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.internal.zznv.zza;

public class zzoh extends zza {
    private final zzb<Status> zzHa;

    public zzoh(zzb<Status> zzb) {
        this.zzHa = zzb;
    }

    public void zzi(Status status) {
        this.zzHa.zzd(status);
    }
}
