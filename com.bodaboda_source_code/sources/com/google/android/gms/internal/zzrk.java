package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzrk extends zzk<zzrn> {
    private final long zzadW = ((long) hashCode());

    private static final class zze implements StartAdvertisingResult {
        private final Status zzHb;
        private final String zzasS;

        zze(Status status, String str) {
            this.zzHb = status;
            this.zzasS = str;
        }

        public String getLocalEndpointName() {
            return this.zzasS;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static class zzb extends zzrj {
        private final com.google.android.gms.common.api.zze<MessageListener> zzasI;

        zzb(com.google.android.gms.common.api.zze<MessageListener> zze) {
            this.zzasI = zze;
        }

        public void onDisconnected(final String remoteEndpointId) throws RemoteException {
            this.zzasI.zza(new com.google.android.gms.common.api.zze.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzasL;

                public void zza(MessageListener messageListener) {
                    messageListener.onDisconnected(remoteEndpointId);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((MessageListener) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void onMessageReceived(final String remoteEndpointId, final byte[] payload, final boolean isReliable) throws RemoteException {
            this.zzasI.zza(new com.google.android.gms.common.api.zze.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzasL;

                public void zza(MessageListener messageListener) {
                    messageListener.onMessageReceived(remoteEndpointId, payload, isReliable);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((MessageListener) obj);
                }

                public void zzhX() {
                }
            });
        }
    }

    private static final class zzd extends zzrj {
        private final com.google.android.gms.common.api.zza.zzb<StartAdvertisingResult> zzHa;
        private final com.google.android.gms.common.api.zze<ConnectionRequestListener> zzasO;

        zzd(com.google.android.gms.common.api.zza.zzb<StartAdvertisingResult> zzb, com.google.android.gms.common.api.zze<ConnectionRequestListener> zze) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzl(zzb);
            this.zzasO = (com.google.android.gms.common.api.zze) zzx.zzl(zze);
        }

        public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
            final String str = remoteEndpointId;
            final String str2 = remoteDeviceId;
            final String str3 = remoteEndpointName;
            final byte[] bArr = payload;
            this.zzasO.zza(new com.google.android.gms.common.api.zze.zzb<ConnectionRequestListener>(this) {
                final /* synthetic */ zzd zzasR;

                public void zza(ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(str, str2, str3, bArr);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((ConnectionRequestListener) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void zzi(int i, String str) throws RemoteException {
            this.zzHa.zzd(new zze(new Status(i), str));
        }
    }

    private static final class zzf extends zzrj {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;
        private final com.google.android.gms.common.api.zze<EndpointDiscoveryListener> zzasO;

        zzf(com.google.android.gms.common.api.zza.zzb<Status> zzb, com.google.android.gms.common.api.zze<EndpointDiscoveryListener> zze) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzl(zzb);
            this.zzasO = (com.google.android.gms.common.api.zze) zzx.zzl(zze);
        }

        public void onEndpointFound(String endpointId, String deviceId, String serviceId, String name) throws RemoteException {
            final String str = endpointId;
            final String str2 = deviceId;
            final String str3 = serviceId;
            final String str4 = name;
            this.zzasO.zza(new com.google.android.gms.common.api.zze.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzf zzasW;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(str, str2, str3, str4);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void onEndpointLost(final String endpointId) throws RemoteException {
            this.zzasO.zza(new com.google.android.gms.common.api.zze.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzf zzasW;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(endpointId);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void zzgs(int i) throws RemoteException {
            this.zzHa.zzd(new Status(i));
        }
    }

    private static final class zza extends zzb {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;

        public zza(com.google.android.gms.common.api.zza.zzb<Status> zzb, com.google.android.gms.common.api.zze<MessageListener> zze) {
            super(zze);
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzl(zzb);
        }

        public void zzgv(int i) throws RemoteException {
            this.zzHa.zzd(new Status(i));
        }
    }

    private static final class zzc extends zzb {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;
        private final com.google.android.gms.common.api.zze<ConnectionResponseCallback> zzasM;

        public zzc(com.google.android.gms.common.api.zza.zzb<Status> zzb, com.google.android.gms.common.api.zze<ConnectionResponseCallback> zze, com.google.android.gms.common.api.zze<MessageListener> zze2) {
            super(zze2);
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzl(zzb);
            this.zzasM = (com.google.android.gms.common.api.zze) zzx.zzl(zze);
        }

        public void zza(final String str, final int i, final byte[] bArr) throws RemoteException {
            this.zzasM.zza(new com.google.android.gms.common.api.zze.zzb<ConnectionResponseCallback>(this) {
                final /* synthetic */ zzc zzasN;

                public void zza(ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((ConnectionResponseCallback) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void zzgu(int i) throws RemoteException {
            this.zzHa.zzd(new Status(i));
        }
    }

    public zzrk(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, connectionCallbacks, onConnectionFailedListener);
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzrn) zzjb()).zzu(this.zzadW);
            } catch (Throwable e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> zzb, String str, long j, com.google.android.gms.common.api.zze<EndpointDiscoveryListener> zze) throws RemoteException {
        ((zzrn) zzjb()).zza(new zzf(zzb, zze), str, j, this.zzadW);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StartAdvertisingResult> zzb, String str, AppMetadata appMetadata, long j, com.google.android.gms.common.api.zze<ConnectionRequestListener> zze) throws RemoteException {
        ((zzrn) zzjb()).zza(new zzd(zzb, zze), str, appMetadata, j, this.zzadW);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> zzb, String str, String str2, byte[] bArr, com.google.android.gms.common.api.zze<ConnectionResponseCallback> zze, com.google.android.gms.common.api.zze<MessageListener> zze2) throws RemoteException {
        ((zzrn) zzjb()).zza(new zzc(zzb, zze, zze2), str, str2, bArr, this.zzadW);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> zzb, String str, byte[] bArr, com.google.android.gms.common.api.zze<MessageListener> zze) throws RemoteException {
        ((zzrn) zzjb()).zza(new zza(zzb, zze), str, bArr, this.zzadW);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzrn) zzjb()).zza(strArr, bArr, this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzrn) zzjb()).zzb(strArr, bArr, this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    protected String zzcF() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    protected zzrn zzcg(IBinder iBinder) {
        return com.google.android.gms.internal.zzrn.zza.zzci(iBinder);
    }

    public void zzcx(String str) {
        try {
            ((zzrn) zzjb()).zzb(str, this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    public void zzcy(String str) {
        try {
            ((zzrn) zzjb()).zzc(str, this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzcg(iBinder);
    }

    public void zzq(final com.google.android.gms.common.api.zza.zzb<Status> zzb, String str) throws RemoteException {
        ((zzrn) zzjb()).zza(new zzrj(this) {
            final /* synthetic */ zzrk zzasH;

            public void zzgw(int i) throws RemoteException {
                zzb.zzd(new Status(i));
            }
        }, str, this.zzadW);
    }

    public String zzrk() {
        try {
            return ((zzrn) zzjb()).zzE(this.zzadW);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String zzrl() {
        try {
            return ((zzrn) zzjb()).zzrl();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zzrm() {
        try {
            ((zzrn) zzjb()).zzB(this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzrn() {
        try {
            ((zzrn) zzjb()).zzD(this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }
}
