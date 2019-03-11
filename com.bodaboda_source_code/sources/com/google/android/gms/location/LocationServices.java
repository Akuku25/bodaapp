package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoz;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpf;
import com.google.android.gms.internal.zzpn;

public class LocationServices {
    public static final Api<NoOptions> API = new Api(zzGS, zzGR, new Scope[0]);
    public static FusedLocationProviderApi FusedLocationApi = new zzoz();
    public static GeofencingApi GeofencingApi = new zzpa();
    public static SettingsApi SettingsApi = new zzpn();
    private static final zzc<zzpf> zzGR = new zzc();
    private static final zzb<zzpf, NoOptions> zzGS = new C03851();

    /* renamed from: com.google.android.gms.location.LocationServices$1 */
    static class C03851 implements zzb<zzpf, NoOptions> {
        C03851() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzk(context, looper, zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzpf zzk(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzpf(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, "locationServices", zzf.getAccountName());
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzpf> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.zzGR, googleApiClient);
        }
    }

    private LocationServices() {
    }

    public static zzpf zze(GoogleApiClient googleApiClient) {
        boolean z = true;
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzpf zzpf = (zzpf) googleApiClient.zza(zzGR);
        if (zzpf == null) {
            z = false;
        }
        zzx.zza(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzpf;
    }
}
