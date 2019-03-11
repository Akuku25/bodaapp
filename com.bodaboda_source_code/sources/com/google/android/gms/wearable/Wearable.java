package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.wearable.internal.zzak;
import com.google.android.gms.wearable.internal.zzan;
import com.google.android.gms.wearable.internal.zzbb;
import com.google.android.gms.wearable.internal.zzbd;
import com.google.android.gms.wearable.internal.zzd;
import com.google.android.gms.wearable.internal.zzh;
import com.google.android.gms.wearable.internal.zzi;

public class Wearable {
    public static final Api<WearableOptions> API = new Api(zzGS, zzGR, new Scope[0]);
    public static final DataApi DataApi = new zzi();
    public static final MessageApi MessageApi = new zzak();
    public static final NodeApi NodeApi = new zzan();
    public static final zzc<zzbd> zzGR = new zzc();
    private static final zzb<zzbd, WearableOptions> zzGS = new C04101();
    public static final zza zzaFC = new zzd();
    public static final zzd zzaFD = new zzh();
    public static final zzh zzaFE = new zzbb();

    /* renamed from: com.google.android.gms.wearable.Wearable$1 */
    static class C04101 implements zzb<zzbd, WearableOptions> {
        C04101() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzbd zza(Context context, Looper looper, zzf zzf, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(new Builder());
            }
            return new zzbd(context, looper, connectionCallbacks, onConnectionFailedListener, zzf);
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
