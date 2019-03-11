package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import java.util.concurrent.Executors;

public final class zzup {
    public static final Api<zzus> API = new Api(zzGS, zzGR, new Scope[0]);
    public static final zzc<zzvc> zzGR = new zzc();
    public static final zzb<zzvc, zzus> zzGS = new C03811();
    public static final zzuq zzawO = new zzvb();

    /* renamed from: com.google.android.gms.internal.zzup$1 */
    static class C03811 implements zzb<zzvc, zzus> {
        C03811() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzvc zza(Context context, Looper looper, zzf zzf, zzus zzus, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzvc(context, looper, zzf, zzus == null ? zzus.zzawP : zzus, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
    }
}
