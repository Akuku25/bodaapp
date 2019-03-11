package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzoz implements FusedLocationProviderApi {

    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.zze(client).zzpx();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zzd(callbackIntent);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zza(listener);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zzb(request, callbackIntent);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zza(request, listener, null);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener, Looper looper) {
        final LocationRequest locationRequest = request;
        final LocationListener locationListener = listener;
        final Looper looper2 = looper;
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zza(locationRequest, locationListener, looper2);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zzb(mockLocation);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zzW(isMockMode);
                setResult(Status.zzNo);
            }
        });
    }
}
