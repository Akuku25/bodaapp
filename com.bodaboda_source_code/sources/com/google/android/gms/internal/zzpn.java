package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.location.LocationServices.zza;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

public class zzpn implements SettingsApi {
    public PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient client, LocationSettingsRequest request) {
        return zza(client, request, null);
    }

    public PendingResult<LocationSettingsResult> zza(GoogleApiClient googleApiClient, final LocationSettingsRequest locationSettingsRequest, final String str) {
        return googleApiClient.zza(new zza<LocationSettingsResult>(this, googleApiClient) {
            final /* synthetic */ zzpn zzans;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzax(x0);
            }

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zza(locationSettingsRequest, (zzb) this, str);
            }

            public LocationSettingsResult zzax(Status status) {
                return new LocationSettingsResult(status);
            }
        });
    }
}
