package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class zzpf extends zzow {
    private final zzpe zzamX;
    private final zzot zzamY;

    private final class zza extends zzc<com.google.android.gms.location.zzf.zza> {
        private final int zzLs;
        private final String[] zzamZ;
        final /* synthetic */ zzpf zzana;

        public zza(zzpf zzpf, com.google.android.gms.location.zzf.zza zza, int i, String[] strArr) {
            this.zzana = zzpf;
            super(zzpf, zza);
            this.zzLs = LocationStatusCodes.zzfq(i);
            this.zzamZ = strArr;
        }

        protected void zza(com.google.android.gms.location.zzf.zza zza) {
            if (zza != null) {
                zza.zza(this.zzLs, this.zzamZ);
            }
        }

        protected /* synthetic */ void zzi(Object obj) {
            zza((com.google.android.gms.location.zzf.zza) obj);
        }

        protected void zzjf() {
        }
    }

    private final class zzc extends zzc<com.google.android.gms.location.zzf.zzb> {
        private final PendingIntent mPendingIntent;
        private final int zzLs;
        private final String[] zzamZ;
        final /* synthetic */ zzpf zzana;
        private final int zzane;

        public zzc(zzpf zzpf, int i, com.google.android.gms.location.zzf.zzb zzb, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            this.zzana = zzpf;
            super(zzpf, zzb);
            if (i != 1) {
                z = false;
            }
            com.google.android.gms.common.internal.zzb.zzN(z);
            this.zzane = i;
            this.zzLs = LocationStatusCodes.zzfq(i2);
            this.mPendingIntent = pendingIntent;
            this.zzamZ = null;
        }

        public zzc(zzpf zzpf, int i, com.google.android.gms.location.zzf.zzb zzb, int i2, String[] strArr) {
            this.zzana = zzpf;
            super(zzpf, zzb);
            com.google.android.gms.common.internal.zzb.zzN(i == 2);
            this.zzane = i;
            this.zzLs = LocationStatusCodes.zzfq(i2);
            this.zzamZ = strArr;
            this.mPendingIntent = null;
        }

        protected void zza(com.google.android.gms.location.zzf.zzb zzb) {
            if (zzb != null) {
                switch (this.zzane) {
                    case 1:
                        zzb.zzb(this.zzLs, this.mPendingIntent);
                        return;
                    case 2:
                        zzb.zzb(this.zzLs, this.zzamZ);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.zzane);
                        return;
                }
            }
        }

        protected /* synthetic */ void zzi(Object obj) {
            zza((com.google.android.gms.location.zzf.zzb) obj);
        }

        protected void zzjf() {
        }
    }

    private static final class zzb extends com.google.android.gms.internal.zzpb.zza {
        private com.google.android.gms.location.zzf.zza zzanb;
        private com.google.android.gms.location.zzf.zzb zzanc;
        private zzpf zzand;

        public zzb(com.google.android.gms.location.zzf.zza zza, zzpf zzpf) {
            this.zzanb = zza;
            this.zzanc = null;
            this.zzand = zzpf;
        }

        public zzb(com.google.android.gms.location.zzf.zzb zzb, zzpf zzpf) {
            this.zzanc = zzb;
            this.zzanb = null;
            this.zzand = zzpf;
        }

        public void zza(int i, String[] strArr) throws RemoteException {
            if (this.zzand == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            zzpf zzpf = this.zzand;
            zzpf zzpf2 = this.zzand;
            zzpf2.getClass();
            zzpf.zza(new zza(zzpf2, this.zzanb, i, strArr));
            this.zzand = null;
            this.zzanb = null;
            this.zzanc = null;
        }

        public void zzb(int i, PendingIntent pendingIntent) {
            if (this.zzand == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            zzpf zzpf = this.zzand;
            zzpf zzpf2 = this.zzand;
            zzpf2.getClass();
            zzpf.zza(new zzc(zzpf2, 1, this.zzanc, i, pendingIntent));
            this.zzand = null;
            this.zzanb = null;
            this.zzanc = null;
        }

        public void zzb(int i, String[] strArr) {
            if (this.zzand == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            zzpf zzpf = this.zzand;
            zzpf zzpf2 = this.zzand;
            zzpf2.getClass();
            zzpf.zza(new zzc(zzpf2, 2, this.zzanc, i, strArr));
            this.zzand = null;
            this.zzanb = null;
            this.zzanc = null;
        }
    }

    private static final class zzd extends com.google.android.gms.internal.zzpd.zza {
        private com.google.android.gms.common.api.zza.zzb<LocationSettingsResult> zzanf;

        public zzd(com.google.android.gms.common.api.zza.zzb<LocationSettingsResult> zzb) {
            zzx.zzb(zzb != null, (Object) "listener can't be null.");
            this.zzanf = zzb;
        }

        public void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
            this.zzanf.zzd(locationSettingsResult);
            this.zzanf = null;
        }
    }

    public zzpf(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, null);
    }

    public zzpf(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, str3, null);
    }

    public zzpf(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3, String str4) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str2);
        this.zzamX = new zzpe(context, this.zzamz);
        this.zzamY = zzot.zza(context, str3, str4, this.zzamz);
    }

    public void disconnect() {
        synchronized (this.zzamX) {
            if (isConnected()) {
                try {
                    this.zzamX.removeAllListeners();
                    this.zzamX.zzpy();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public void zzW(boolean z) throws RemoteException {
        this.zzamX.zzW(z);
    }

    public void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        zzfc();
        zzx.zzl(pendingIntent);
        zzx.zzb(j >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((zzpc) zzjb()).zza(j, true, pendingIntent);
    }

    public void zza(PendingIntent pendingIntent) throws RemoteException {
        zzfc();
        zzx.zzl(pendingIntent);
        ((zzpc) zzjb()).zza(pendingIntent);
    }

    public void zza(PendingIntent pendingIntent, com.google.android.gms.location.zzf.zzb zzb) throws RemoteException {
        zzpb zzpb;
        zzfc();
        zzx.zzb((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        zzx.zzb((Object) zzb, (Object) "OnRemoveGeofencesResultListener not provided.");
        if (zzb == null) {
            zzpb = null;
        } else {
            Object zzb2 = new zzb(zzb, this);
        }
        ((zzpc) zzjb()).zza(pendingIntent, zzpb, getContext().getPackageName());
    }

    public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, com.google.android.gms.location.zzf.zza zza) throws RemoteException {
        zzpb zzpb;
        zzfc();
        zzx.zzb((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        zzx.zzb((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        zzx.zzb((Object) zza, (Object) "OnAddGeofencesResultListener not provided.");
        if (zza == null) {
            zzpb = null;
        } else {
            Object zzb = new zzb(zza, this);
        }
        ((zzpc) zzjb()).zza(geofencingRequest, pendingIntent, zzpb);
    }

    public void zza(LocationListener locationListener) throws RemoteException {
        this.zzamX.zza(locationListener);
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        synchronized (this.zzamX) {
            this.zzamX.zza(locationRequest, locationListener, looper);
        }
    }

    public void zza(LocationSettingsRequest locationSettingsRequest, com.google.android.gms.common.api.zza.zzb<LocationSettingsResult> zzb, String str) throws RemoteException {
        boolean z = true;
        zzfc();
        zzx.zzb(locationSettingsRequest != null, (Object) "locationSettingsRequest can't be null nor empty.");
        if (zzb == null) {
            z = false;
        }
        zzx.zzb(z, (Object) "listener can't be null.");
        ((zzpc) zzjb()).zza(locationSettingsRequest, new zzd(zzb), str);
    }

    public void zza(List<String> list, com.google.android.gms.location.zzf.zzb zzb) throws RemoteException {
        zzpb zzpb;
        zzfc();
        boolean z = list != null && list.size() > 0;
        zzx.zzb(z, (Object) "geofenceRequestIds can't be null nor empty.");
        zzx.zzb((Object) zzb, (Object) "OnRemoveGeofencesResultListener not provided.");
        String[] strArr = (String[]) list.toArray(new String[0]);
        if (zzb == null) {
            zzpb = null;
        } else {
            Object zzb2 = new zzb(zzb, this);
        }
        ((zzpc) zzjb()).zza(strArr, zzpb, getContext().getPackageName());
    }

    public void zzb(Location location) throws RemoteException {
        this.zzamX.zzb(location);
    }

    public void zzb(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.zzamX.zzb(locationRequest, pendingIntent);
    }

    public void zzd(PendingIntent pendingIntent) throws RemoteException {
        this.zzamX.zzd(pendingIntent);
    }

    public Location zzpx() {
        return this.zzamX.zzpx();
    }
}
