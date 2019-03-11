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
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzi;
import java.util.Locale;

public class zzpx extends zzk<zzpt> {
    private final zzqh zzaop;
    private final Locale zzaoq = Locale.getDefault();

    public static class zza implements zzb<zzpx, PlacesOptions> {
        private final String zzaor;
        private final String zzaos;

        public zza(String str, String str2) {
            this.zzaor = str;
            this.zzaos = str2;
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, zzf, (PlacesOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzpx zzb(Context context, Looper looper, zzf zzf, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzpx(context, looper, zzf, connectionCallbacks, onConnectionFailedListener, this.zzaor != null ? this.zzaor : context.getPackageName(), this.zzaos != null ? this.zzaos : context.getPackageName(), placesOptions == null ? new Builder().build() : placesOptions);
        }
    }

    public zzpx(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 67, connectionCallbacks, onConnectionFailedListener, zzf);
        String str3 = null;
        if (zzf.getAccount() != null) {
            str3 = zzf.getAccount().name;
        }
        this.zzaop = new zzqh(str, this.zzaoq, str3, placesOptions.zzaob, str2);
    }

    public void zza(zzi zzi, PlaceFilter placeFilter) throws RemoteException {
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzpJ();
        }
        ((zzpt) zzjb()).zza(placeFilter, this.zzaop, (zzpv) zzi);
    }

    public void zza(zzi zzi, PlaceReport placeReport) throws RemoteException {
        zzx.zzl(placeReport);
        ((zzpt) zzjb()).zza(placeReport, this.zzaop, (zzpv) zzi);
    }

    protected zzpt zzbq(IBinder iBinder) {
        return com.google.android.gms.internal.zzpt.zza.zzbn(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    protected String zzcG() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzbq(iBinder);
    }
}
