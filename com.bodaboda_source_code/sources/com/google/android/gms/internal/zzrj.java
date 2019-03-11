package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzrm.zza;
import com.google.android.gms.nearby.connection.AppMetadata;

public abstract class zzrj extends zza {
    public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
    }

    public void onDisconnected(String remoteEndpointId) throws RemoteException {
    }

    public void onEndpointFound(String endpointId, String deviceId, String applicationId, String name) throws RemoteException {
    }

    public void onEndpointLost(String endpointId) throws RemoteException {
    }

    public void onMessageReceived(String remoteEndpointId, byte[] payload, boolean isReliable) throws RemoteException {
    }

    public void zza(String str, int i, byte[] bArr) throws RemoteException {
    }

    public void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException {
    }

    public void zzcw(String str) throws RemoteException {
    }

    public void zzgs(int i) throws RemoteException {
    }

    public void zzgt(int i) throws RemoteException {
    }

    public void zzgu(int i) throws RemoteException {
    }

    public void zzgv(int i) throws RemoteException {
    }

    public void zzgw(int i) throws RemoteException {
    }

    public void zzi(int i, String str) throws RemoteException {
    }
}
