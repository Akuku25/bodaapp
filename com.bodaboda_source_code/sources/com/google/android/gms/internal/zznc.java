package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import java.util.List;

public class zznc extends zzmy<zznm> {

    public static class zza implements zzb<zznc, NoOptions> {
        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzg(context, looper, zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zznc zzg(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zznc(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zznc(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 61, connectionCallbacks, onConnectionFailedListener, zzf);
    }

    protected zznm zzaz(IBinder iBinder) {
        return com.google.android.gms.internal.zznm.zza.zzaJ(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.gms.fitness.InternalApi";
    }

    protected String zzcG() {
        return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
    }

    protected List<String> zzf(List<String> list) {
        return com.google.android.gms.fitness.zza.zzj(list);
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzaz(iBinder);
    }
}
