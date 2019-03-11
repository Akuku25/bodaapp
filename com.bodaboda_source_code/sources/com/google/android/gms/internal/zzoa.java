package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzar;
import com.google.android.gms.fitness.request.zzav;
import com.google.android.gms.fitness.request.zzu;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzoa implements BleApi {

    private static class zza extends com.google.android.gms.internal.zzoj.zza {
        private final zzb<BleDevicesResult> zzHa;

        private zza(zzb<BleDevicesResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzHa.zzd(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz zzmz) throws RemoteException {
                ((zznj) zzmz.zzjb()).zza(new com.google.android.gms.fitness.request.zzb(bleDevice.getAddress(), bleDevice, new zzoh(this), zzmz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz zzmz) throws RemoteException {
                ((zznj) zzmz.zzjb()).zza(new com.google.android.gms.fitness.request.zzb(deviceAddress, null, new zzoh(this), zzmz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.zza(new zza<BleDevicesResult>(this, client) {
            final /* synthetic */ zzoa zzaaa;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzu(x0);
            }

            protected void zza(zzmz zzmz) throws RemoteException {
                ((zznj) zzmz.zzjb()).zza(new zzu(new zza(this), zzmz.getContext().getPackageName()));
            }

            protected BleDevicesResult zzu(Status status) {
                return BleDevicesResult.zzB(status);
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz zzmz) throws RemoteException {
                ((zznj) zzmz.zzjb()).zza(new StartBleScanRequest(request, new zzoh(this), zzmz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz zzmz) throws RemoteException {
                ((zznj) zzmz.zzjb()).zza(new zzar(requestCallback, new zzoh(this), zzmz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz zzmz) throws RemoteException {
                ((zznj) zzmz.zzjb()).zza(new zzav(deviceAddress, new zzoh(this), zzmz.getContext().getPackageName()));
            }
        });
    }
}
