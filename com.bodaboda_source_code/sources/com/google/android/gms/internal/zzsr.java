package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

public final class zzsr implements zzsk {
    public static final zzc<zzso> zzGR = new zzc();
    public static final zzb<zzso, NoOptions> zzGS = new C03791();

    /* renamed from: com.google.android.gms.internal.zzsr$1 */
    static class C03791 implements zzb<zzso, NoOptions> {
        C03791() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ zza zza(Context context, Looper looper, zzf zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzn(context, looper, zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzso zzn(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzso(context, looper, connectionCallbacks, onConnectionFailedListener, zzf);
        }
    }
}
