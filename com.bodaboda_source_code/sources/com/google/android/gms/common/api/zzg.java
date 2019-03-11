package com.google.android.gms.common.api;

import android.os.Looper;

public class zzg extends AbstractPendingResult<Status> {
    public zzg(Looper looper) {
        super(looper);
    }

    protected /* synthetic */ Result createFailedResult(Status x0) {
        return zzb(x0);
    }

    protected Status zzb(Status status) {
        return status;
    }
}
