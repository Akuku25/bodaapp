package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;
import java.util.List;

public final class zzrl implements Connections {
    public static final com.google.android.gms.common.api.Api.zzc<zzrk> zzGR = new com.google.android.gms.common.api.Api.zzc();
    public static final com.google.android.gms.common.api.Api.zzb<zzrk, NoOptions> zzGS = new C03771();

    /* renamed from: com.google.android.gms.internal.zzrl$1 */
    static class C03771 implements com.google.android.gms.common.api.Api.zzb<zzrk, NoOptions> {
        C03771() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzl(context, looper, zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzrk zzl(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzrk(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzrk> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzrl.zzGR, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StartAdvertisingResult> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzaF(x0);
        }

        public StartAdvertisingResult zzaF(final Status status) {
            return new StartAdvertisingResult(this) {
                final /* synthetic */ zzb zzate;

                public String getLocalEndpointName() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    public static zzrk zzd(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzrk zze(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), (Object) "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean zzb = googleApiClient.zzb(Nearby.CONNECTIONS_API);
        if (!z || zzb) {
            return zzb ? (zzrk) googleApiClient.zza(zzGR) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload, MessageListener messageListener) {
        final zze zzf = apiClient.zzf(messageListener);
        final String str = remoteEndpointId;
        final byte[] bArr = payload;
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk zzrk) throws RemoteException {
                zzrk.zza((com.google.android.gms.common.api.zza.zzb) this, str, bArr, zzf);
            }
        });
    }

    public void disconnectFromEndpoint(GoogleApiClient apiClient, String remoteEndpointId) {
        zzd(apiClient, false).zzcy(remoteEndpointId);
    }

    public String getLocalDeviceId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzrl();
    }

    public String getLocalEndpointId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzrk();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient apiClient, final String remoteEndpointId) {
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk zzrk) throws RemoteException {
                zzrk.zzq(this, remoteEndpointId);
            }
        });
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient apiClient, String name, String remoteEndpointId, byte[] payload, ConnectionResponseCallback connectionResponseCallback, MessageListener messageListener) {
        final zze zzf = apiClient.zzf(connectionResponseCallback);
        final zze zzf2 = apiClient.zzf(messageListener);
        final String str = name;
        final String str2 = remoteEndpointId;
        final byte[] bArr = payload;
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk zzrk) throws RemoteException {
                zzrk.zza(this, str, str2, bArr, zzf, zzf2);
            }
        });
    }

    public void sendReliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zza(new String[]{remoteEndpointId}, payload);
    }

    public void sendReliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zza((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zzb(new String[]{remoteEndpointId}, payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zzb((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public PendingResult<StartAdvertisingResult> startAdvertising(GoogleApiClient apiClient, String name, AppMetadata appMetadata, long durationMillis, ConnectionRequestListener connectionRequestListener) {
        final zze zzf = apiClient.zzf(connectionRequestListener);
        final String str = name;
        final AppMetadata appMetadata2 = appMetadata;
        final long j = durationMillis;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk zzrk) throws RemoteException {
                zzrk.zza(this, str, appMetadata2, j, zzf);
            }
        });
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient apiClient, String serviceId, long durationMillis, EndpointDiscoveryListener listener) {
        final zze zzf = apiClient.zzf(listener);
        final String str = serviceId;
        final long j = durationMillis;
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk zzrk) throws RemoteException {
                zzrk.zza((com.google.android.gms.common.api.zza.zzb) this, str, j, zzf);
            }
        });
    }

    public void stopAdvertising(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzrm();
    }

    public void stopAllEndpoints(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzrn();
    }

    public void stopDiscovery(GoogleApiClient apiClient, String serviceId) {
        zzd(apiClient, false).zzcx(serviceId);
    }
}
