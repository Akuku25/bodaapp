package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzi;
import com.google.android.gms.location.places.zzi.zzd;
import com.google.android.gms.location.places.zzi.zzg;

public class zzpw implements PlaceDetectionApi {
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient client, final PlaceFilter filter) {
        return client.zza(new zzd<zzpx>(this, Places.zzanU, client) {
            final /* synthetic */ zzpw zzaou;

            protected void zza(zzpx zzpx) throws RemoteException {
                zzpx.zza(new zzi((zzd) this, zzpx.getContext()), filter);
            }
        });
    }

    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient client, final PlaceReport report) {
        return client.zzb(new zzg<zzpx>(this, Places.zzanU, client) {
            final /* synthetic */ zzpw zzaou;

            protected void zza(zzpx zzpx) throws RemoteException {
                zzpx.zza(new zzi((zzg) this), report);
            }
        });
    }
}
