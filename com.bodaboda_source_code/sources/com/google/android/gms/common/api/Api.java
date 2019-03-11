package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {
    private final zzb<?, O> zzLS;
    private final zzc<?> zzLT;
    private final ArrayList<Scope> zzLU;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public interface zza {
        void connect();

        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        void zza(com.google.android.gms.common.api.GoogleApiClient.zza zza);

        void zza(zzq zzq);

        void zzb(zzq zzq);

        boolean zzhc();
    }

    public interface zzb<T extends zza, O> {
        int getPriority();

        T zza(Context context, Looper looper, zzf zzf, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);
    }

    public static final class zzc<C extends zza> {
    }

    public <C extends zza> Api(zzb<C, O> clientBuilder, zzc<C> clientKey, Scope... impliedScopes) {
        this.zzLS = clientBuilder;
        this.zzLT = clientKey;
        this.zzLU = new ArrayList(Arrays.asList(impliedScopes));
    }

    public zzb<?, O> zzhT() {
        return this.zzLS;
    }

    public List<Scope> zzhU() {
        return this.zzLU;
    }

    public zzc<?> zzhV() {
        return this.zzLT;
    }
}
