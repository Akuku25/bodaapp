package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzi;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public class zzps extends zzk<zzpu> {
    private final zzqh zzaop;
    private final Locale zzaoq = Locale.getDefault();

    public static class zza implements zzb<zzps, PlacesOptions> {
        private final String zzaor;
        private final String zzaos;

        public zza(String str, String str2) {
            this.zzaor = str;
            this.zzaos = str2;
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzps zza(Context context, Looper looper, zzf zzf, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzps(context, looper, zzf, connectionCallbacks, onConnectionFailedListener, this.zzaor != null ? this.zzaor : context.getPackageName(), this.zzaos != null ? this.zzaos : context.getPackageName(), placesOptions == null ? new Builder().build() : placesOptions);
        }
    }

    public zzps(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 65, connectionCallbacks, onConnectionFailedListener, zzf);
        String str3 = null;
        if (zzf.getAccount() != null) {
            str3 = zzf.getAccount().name;
        }
        this.zzaop = new zzqh(str, this.zzaoq, str3, placesOptions.zzaob, str2);
    }

    public void zza(zzi zzi, AddPlaceRequest addPlaceRequest) throws RemoteException {
        zzx.zzb((Object) addPlaceRequest, (Object) "userAddedPlace == null");
        ((zzpu) zzjb()).zza(addPlaceRequest, this.zzaop, (zzpv) zzi);
    }

    public void zza(zzi zzi, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) throws RemoteException {
        zzx.zzb((Object) str, (Object) "query == null");
        zzx.zzb((Object) latLngBounds, (Object) "bounds == null");
        zzx.zzb((Object) zzi, (Object) "callback == null");
        ((zzpu) zzjb()).zza(str, latLngBounds, autocompleteFilter == null ? AutocompleteFilter.create(null) : autocompleteFilter, this.zzaop, (zzpv) zzi);
    }

    public void zza(zzi zzi, List<String> list) throws RemoteException {
        ((zzpu) zzjb()).zzb((List) list, this.zzaop, (zzpv) zzi);
    }

    protected zzpu zzbm(IBinder iBinder) {
        return com.google.android.gms.internal.zzpu.zza.zzbo(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    protected String zzcG() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzbm(iBinder);
    }
}
