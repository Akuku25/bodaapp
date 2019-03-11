package com.google.android.gms.safetynet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzum;
import com.google.android.gms.internal.zzun;
import com.google.android.gms.internal.zzuo;

public final class SafetyNet {
    public static final Api<NoOptions> API = new Api(zzGS, zzGR, new Scope[0]);
    public static final SafetyNetApi SafetyNetApi = new zzum();
    public static final zzc<zzun> zzGR = new zzc();
    public static final zzb<zzun, NoOptions> zzGS = new C03901();
    public static final zzc zzawG = new zzuo();

    /* renamed from: com.google.android.gms.safetynet.SafetyNet$1 */
    static class C03901 implements zzb<zzun, NoOptions> {
        C03901() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ zza zza(Context context, Looper looper, zzf zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzp(context, looper, zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzun zzp(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzun(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private SafetyNet() {
    }
}
