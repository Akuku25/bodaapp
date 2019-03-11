package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztm;
import com.google.android.gms.internal.zztn;
import com.google.android.gms.internal.zzto;
import com.google.android.gms.internal.zztp;
import com.google.android.gms.internal.zztq;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.internal.zzh;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api(zzGS, zzGR, new Scope[0]);
    public static final Account AccountApi = new zztm();
    public static final Moments MomentsApi = new zztp();
    public static final People PeopleApi = new zztq();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final zzc<zze> zzGR = new zzc();
    static final zzb<zze, PlusOptions> zzGS = new C03891();
    public static final zzb zzauf = new zzto();
    public static final zza zzaug = new zztn();

    /* renamed from: com.google.android.gms.plus.Plus$1 */
    static class C03891 implements zzb<zze, PlusOptions> {
        C03891() {
        }

        public int getPriority() {
            return 2;
        }

        public zze zza(Context context, Looper looper, zzf zzf, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new zze(context, looper, zzf, new zzh(zzf.zziM(), zzf.zziQ(), (String[]) plusOptions.zzaui.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class PlusOptions implements Optional {
        final String zzauh;
        final Set<String> zzaui;

        public static final class Builder {
            String zzauh;
            final Set<String> zzaui = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                zzx.zzb((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.zzaui.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.zzauh = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.zzauh = null;
            this.zzaui = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.zzauh = builder.zzauh;
            this.zzaui = builder.zzaui;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.zzGR, googleApiClient);
        }
    }

    private Plus() {
    }

    public static zze zzf(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean zzb = googleApiClient.zzb(API);
        if (!z || zzb) {
            return zzb ? (zze) googleApiClient.zza(zzGR) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
