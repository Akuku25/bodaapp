package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjl;

@Deprecated
public final class AppStateManager {
    public static final Api<NoOptions> API = new Api(zzGS, zzGR, SCOPE_APP_STATE);
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
    static final com.google.android.gms.common.api.Api.zzc<zzjl> zzGR = new com.google.android.gms.common.api.Api.zzc();
    private static final com.google.android.gms.common.api.Api.zzb<zzjl, NoOptions> zzGS = new C02971();

    /* renamed from: com.google.android.gms.appstate.AppStateManager$1 */
    static class C02971 implements com.google.android.gms.common.api.Api.zzb<zzjl, NoOptions> {
        C02971() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzjl zzb(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjl(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzjl> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppStateManager.zzGR, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StateDeletedResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
    }

    private static abstract class zzc extends zza<StateListResult> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzf(x0);
        }

        public StateListResult zzf(final Status status) {
            return new StateListResult(this) {
                final /* synthetic */ zzc zzGZ;

                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzd extends zza<Status> {
        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    private static abstract class zze extends zza<StateResult> {
        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzg(x0);
        }

        public StateResult zzg(Status status) {
            return AppStateManager.zzc(status);
        }
    }

    private AppStateManager() {
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            public /* synthetic */ Result createFailedResult(Status x0) {
                return zze(x0);
            }

            protected void zza(zzjl zzjl) throws RemoteException {
                zzjl.zza(this, stateKey);
            }

            public StateDeletedResult zze(final Status status) {
                return new StateDeletedResult(this) {
                    final /* synthetic */ C06265 zzGW;

                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzhe();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzhd();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzc(googleApiClient) {
            protected void zza(zzjl zzjl) throws RemoteException {
                zzjl.zza(this);
            }
        });
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.zza(new zze(googleApiClient) {
            protected void zza(zzjl zzjl) throws RemoteException {
                zzjl.zzb(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.zzb(new zze(googleApiClient) {
            protected void zza(zzjl zzjl) throws RemoteException {
                zzjl.zza(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzd(googleApiClient) {
            protected void zza(zzjl zzjl) throws RemoteException {
                zzjl.zzb(this);
            }
        });
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.zzb(new zze(googleApiClient) {
            protected void zza(zzjl zzjl) throws RemoteException {
                zzjl.zza(null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.zzb(new zze(googleApiClient) {
            protected void zza(zzjl zzjl) throws RemoteException {
                zzjl.zza(this, stateKey, data);
            }
        });
    }

    public static zzjl zza(GoogleApiClient googleApiClient) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return (zzjl) googleApiClient.zza(zzGR);
    }

    private static StateResult zzc(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
