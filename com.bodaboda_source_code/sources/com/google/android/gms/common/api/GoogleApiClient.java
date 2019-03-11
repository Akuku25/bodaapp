package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzup;
import com.google.android.gms.internal.zzur;
import com.google.android.gms.internal.zzus;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {

    public static final class Builder {
        private final Context mContext;
        private Account zzFN;
        private Looper zzMc;
        private final Set<String> zzMe;
        private int zzMf;
        private View zzMg;
        private String zzMh;
        private String zzMi;
        private final Map<Api<?>, ApiOptions> zzMj;
        private final Map<Api<?>, Boolean> zzMk;
        private FragmentActivity zzMl;
        private int zzMm;
        private OnConnectionFailedListener zzMn;
        private zzb<? extends zzur, zzus> zzMo;
        private final Set<ConnectionCallbacks> zzMp;
        private final Set<OnConnectionFailedListener> zzMq;
        private com.google.android.gms.internal.zzus.zza zzMr;

        public Builder(Context context) {
            this.zzMe = new HashSet();
            this.zzMj = new HashMap();
            this.zzMk = new HashMap();
            this.zzMm = -1;
            this.zzMp = new HashSet();
            this.zzMq = new HashSet();
            this.zzMr = new com.google.android.gms.internal.zzus.zza();
            this.mContext = context;
            this.zzMc = context.getMainLooper();
            this.zzMh = context.getPackageName();
            this.zzMi = context.getClass().getName();
            this.zzMo = zzup.zzGS;
        }

        public Builder(Context context, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
            this(context);
            zzx.zzb((Object) connectedListener, (Object) "Must provide a connected listener");
            this.zzMp.add(connectedListener);
            zzx.zzb((Object) connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.zzMq.add(connectionFailedListener);
        }

        private GoogleApiClient zzhZ() {
            zzh zza = zzh.zza(this.zzMl);
            GoogleApiClient zzar = zza.zzar(this.zzMm);
            if (zzar == null) {
                zzar = new zzd(this.mContext.getApplicationContext(), this.zzMc, zzhY(), this.zzMo, this.zzMj, this.zzMk, this.zzMp, this.zzMq, this.zzMm);
            }
            zza.zza(this.zzMm, zzar, this.zzMn);
            return zzar;
        }

        public Builder addApi(Api<? extends NotRequiredOptions> api) {
            this.zzMj.put(api, null);
            List zzhU = api.zzhU();
            int size = zzhU.size();
            for (int i = 0; i < size; i++) {
                this.zzMe.add(((Scope) zzhU.get(i)).zzio());
            }
            return this;
        }

        public <O extends HasOptions> Builder addApi(Api<O> api, O options) {
            zzx.zzb((Object) options, (Object) "Null options are not permitted for this Api");
            this.zzMj.put(api, options);
            List zzhU = api.zzhU();
            int size = zzhU.size();
            for (int i = 0; i < size; i++) {
                this.zzMe.add(((Scope) zzhU.get(i)).zzio());
            }
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks listener) {
            this.zzMp.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener listener) {
            this.zzMq.add(listener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.zzMe.add(scope.zzio());
            return this;
        }

        public GoogleApiClient build() {
            zzx.zzb(!this.zzMj.isEmpty(), (Object) "must call addApi() to add at least one API");
            return this.zzMm >= 0 ? zzhZ() : new zzd(this.mContext, this.zzMc, zzhY(), this.zzMo, this.zzMj, this.zzMk, this.zzMp, this.zzMq, -1);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int clientId, OnConnectionFailedListener unresolvedConnectionFailedListener) {
            zzx.zzb(clientId >= 0, (Object) "clientId must be non-negative");
            this.zzMm = clientId;
            this.zzMl = (FragmentActivity) zzx.zzb((Object) fragmentActivity, (Object) "Null activity is not permitted.");
            this.zzMn = unresolvedConnectionFailedListener;
            return this;
        }

        public Builder requestServerAuthCode(String serverClientId, ServerAuthCodeCallbacks callbacks) {
            this.zzMr.zza(serverClientId, callbacks);
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.zzFN = accountName == null ? null : new Account(accountName, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.zzMf = gravityForPopups;
            return this;
        }

        public Builder setHandler(Handler handler) {
            zzx.zzb((Object) handler, (Object) "Handler must not be null");
            this.zzMc = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View viewForPopups) {
            this.zzMg = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzhY() {
            return new zzf(this.zzFN, this.zzMe, this.zzMf, this.zzMg, this.zzMh, this.zzMi, this.zzMr.zzsy());
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public interface ServerAuthCodeCallbacks {

        public static class CheckResult {
            private Set<Scope> zzMe;
            private boolean zzMs;

            private CheckResult(boolean requiresNewAuthCode, Set<Scope> requiredScopes) {
                this.zzMs = requiresNewAuthCode;
                this.zzMe = requiredScopes;
            }

            public static CheckResult newAuthNotRequiredResult() {
                return new CheckResult(false, null);
            }

            public static CheckResult newAuthRequiredResult(Set<Scope> requiredScopes) {
                boolean z = (requiredScopes == null || requiredScopes.isEmpty()) ? false : true;
                zzx.zzb(z, (Object) "A non-empty scope set is required if further auth is needed.");
                return new CheckResult(true, requiredScopes);
            }

            public boolean zzic() {
                return this.zzMs;
            }

            public Set<Scope> zzid() {
                return this.zzMe;
            }
        }

        CheckResult onCheckServerAuthorization(String str, Set<Scope> set);

        boolean onUploadServerAuthCode(String str, String str2);
    }

    public interface zza {
        void zzia();

        void zzib();
    }

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    PendingResult<Status> clearDefaultAccountAndReconnect();

    void connect();

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    Context getContext();

    Looper getLooper();

    int getSessionId();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void stopAutoManage(FragmentActivity fragmentActivity);

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    <C extends com.google.android.gms.common.api.Api.zza> C zza(zzc<C> zzc);

    <A extends com.google.android.gms.common.api.Api.zza, R extends Result, T extends com.google.android.gms.common.api.zza.zza<R, A>> T zza(T t);

    boolean zza(Api<?> api);

    boolean zza(Scope scope);

    <A extends com.google.android.gms.common.api.Api.zza, T extends com.google.android.gms.common.api.zza.zza<? extends Result, A>> T zzb(T t);

    boolean zzb(Api<?> api);

    <L> zze<L> zzf(L l);
}
