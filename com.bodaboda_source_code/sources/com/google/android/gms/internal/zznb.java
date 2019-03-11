package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.Fitness;
import java.util.List;

public class zznb extends zzmy<zznl> {

    public static class zzb implements com.google.android.gms.common.api.Api.zzb<zznb, NoOptions> {
        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzf(context, looper, zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zznb zzf(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zznb(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zznb> {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzYf, googleApiClient);
        }
    }

    static abstract class zzc extends zza<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected Status zzb(Status status) {
            zzx.zzO(!status.isSuccess());
            return status;
        }
    }

    public zznb(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 57, connectionCallbacks, onConnectionFailedListener, zzf);
    }

    protected zznl zzay(IBinder iBinder) {
        return com.google.android.gms.internal.zznl.zza.zzaI(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.gms.fitness.HistoryApi";
    }

    protected String zzcG() {
        return "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi";
    }

    protected List<String> zzf(List<String> list) {
        return com.google.android.gms.fitness.zza.zzj(list);
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzay(iBinder);
    }
}
