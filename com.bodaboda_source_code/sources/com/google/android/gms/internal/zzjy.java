package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract class zzjy extends zzjr<Status> {
    public zzjy(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status x0) {
        return zzb(x0);
    }

    public Status zzb(Status status) {
        return status;
    }
}
