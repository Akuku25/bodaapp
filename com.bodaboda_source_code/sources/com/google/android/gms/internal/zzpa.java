package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.zzf.zzb;
import java.util.List;

public class zzpa implements GeofencingApi {

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

    public PendingResult<Status> addGeofences(GoogleApiClient client, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzpa zzamN;

            /* renamed from: com.google.android.gms.internal.zzpa$1$1 */
            class C03681 implements com.google.android.gms.location.zzf.zza {
                final /* synthetic */ C07771 zzamO;

                C03681(C07771 c07771) {
                    this.zzamO = c07771;
                }

                public void zza(int i, String[] strArr) {
                    this.zzamO.setResult(LocationStatusCodes.zzfr(i));
                }
            }

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zza(geofencingRequest, pendingIntent, new C03681(this));
            }
        });
    }

    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(geofences);
        builder.setInitialTrigger(5);
        return addGeofences(client, builder.build(), pendingIntent);
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final PendingIntent pendingIntent) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzpa zzamN;

            /* renamed from: com.google.android.gms.internal.zzpa$2$1 */
            class C03691 implements zzb {
                final /* synthetic */ C07782 zzamP;

                C03691(C07782 c07782) {
                    this.zzamP = c07782;
                }

                public void zzb(int i, PendingIntent pendingIntent) {
                    this.zzamP.setResult(LocationStatusCodes.zzfr(i));
                }

                public void zzb(int i, String[] strArr) {
                    Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                }
            }

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zza(pendingIntent, new C03691(this));
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final List<String> geofenceRequestIds) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzpa zzamN;

            /* renamed from: com.google.android.gms.internal.zzpa$3$1 */
            class C03701 implements zzb {
                final /* synthetic */ C07793 zzamR;

                C03701(C07793 c07793) {
                    this.zzamR = c07793;
                }

                public void zzb(int i, PendingIntent pendingIntent) {
                    Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                }

                public void zzb(int i, String[] strArr) {
                    this.zzamR.setResult(LocationStatusCodes.zzfr(i));
                }
            }

            protected void zza(zzpf zzpf) throws RemoteException {
                zzpf.zza(geofenceRequestIds, new C03701(this));
            }
        });
    }
}
