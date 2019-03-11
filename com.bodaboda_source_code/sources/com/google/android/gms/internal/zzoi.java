package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzoi implements BleApi {
    private static final Status zzaaH = new Status(FitnessStatusCodes.UNSUPPORTED_PLATFORM);

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return new zznx(zzaaH);
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, String deviceAddress) {
        return new zznx(zzaaH);
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return new zznx(BleDevicesResult.zzB(zzaaH));
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, StartBleScanRequest request) {
        return new zznx(zzaaH);
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, BleScanCallback callback) {
        return new zznx(zzaaH);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return new zznx(zzaaH);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, String deviceAddress) {
        return new zznx(zzaaH);
    }
}
