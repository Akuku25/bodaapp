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

public class zzmz extends zzmy<zznj> {

    public static class zzb implements com.google.android.gms.common.api.Api.zzb<zzmz, NoOptions> {
        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzd(context, looper, zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzmz zzd(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmz(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzmz> {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzYd, googleApiClient);
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

    public zzmz(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 59, connectionCallbacks, onConnectionFailedListener, zzf);
    }

    protected zznj zzaw(IBinder iBinder) {
        return com.google.android.gms.internal.zznj.zza.zzaG(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.gms.fitness.BleApi";
    }

    protected String zzcG() {
        return "com.google.android.gms.fitness.internal.IGoogleFitBleApi";
    }

    protected List<String> zzf(List<String> list) {
        return com.google.android.gms.fitness.zza.zzj(list);
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzaw(iBinder);
    }
}
