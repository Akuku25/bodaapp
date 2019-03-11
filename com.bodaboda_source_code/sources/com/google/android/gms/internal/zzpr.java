package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzi;
import com.google.android.gms.location.places.zzi.zza;
import com.google.android.gms.location.places.zzi.zzc;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

public class zzpr implements GeoDataApi {
    private static final String TAG = zzpr.class.getSimpleName();

    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient client, final AddPlaceRequest addPlaceRequest) {
        return client.zzb(new zzc<zzps>(this, Places.zzanT, client) {
            final /* synthetic */ zzpr zzaol;

            protected void zza(zzps zzps) throws RemoteException {
                zzps.zza(new zzi((zzc) this, zzps.getContext()), addPlaceRequest);
            }
        });
    }

    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient client, String query, LatLngBounds bounds, AutocompleteFilter filter) {
        final String str = query;
        final LatLngBounds latLngBounds = bounds;
        final AutocompleteFilter autocompleteFilter = filter;
        return client.zza(new zza<zzps>(this, Places.zzanT, client) {
            final /* synthetic */ zzpr zzaol;

            protected void zza(zzps zzps) throws RemoteException {
                zzps.zza(new zzi((zza) this), str, latLngBounds, autocompleteFilter);
            }
        });
    }

    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient client, final String... placeIds) {
        boolean z = true;
        if (placeIds == null || placeIds.length < 1) {
            z = false;
        }
        zzx.zzO(z);
        return client.zza(new zzc<zzps>(this, Places.zzanT, client) {
            final /* synthetic */ zzpr zzaol;

            protected void zza(zzps zzps) throws RemoteException {
                zzps.zza(new zzi((zzc) this, zzps.getContext()), Arrays.asList(placeIds));
            }
        });
    }
}
