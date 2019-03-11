package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;

public class zzbl extends zzc {
    private final zzb<Status> zzHa;

    public zzbl(zzb<Status> zzb) {
        this.zzHa = zzb;
    }

    public void onSuccess() throws RemoteException {
        this.zzHa.zzd(Status.zzNo);
    }

    public void zzm(Status status) throws RemoteException {
        this.zzHa.zzd(status);
    }
}
