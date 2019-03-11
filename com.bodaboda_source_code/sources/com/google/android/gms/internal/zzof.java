package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzac;
import com.google.android.gms.fitness.request.zzae;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zzof implements SensorsApi {

    private interface zza {
        void zzlN();
    }

    private static class zzb extends com.google.android.gms.internal.zznh.zza {
        private final com.google.android.gms.common.api.zza.zzb<DataSourcesResult> zzHa;

        private zzb(com.google.android.gms.common.api.zza.zzb<DataSourcesResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzHa.zzd(dataSourcesResult);
        }
    }

    private static class zzc extends com.google.android.gms.internal.zznv.zza {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;
        private final zza zzaaB;

        private zzc(com.google.android.gms.common.api.zza.zzb<Status> zzb, zza zza) {
            this.zzHa = zzb;
            this.zzaaB = zza;
        }

        public void zzi(Status status) {
            if (this.zzaaB != null && status.isSuccess()) {
                this.zzaaB.zzlN();
            }
            this.zzHa.zzd(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzk zzk, PendingIntent pendingIntent, zza zza) {
        final zza zza2 = zza;
        final zzk zzk2 = zzk;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzof zzaat;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzne zzne) throws RemoteException {
                ((zzno) zzne.zzjb()).zza(new zzae(zzk2, pendingIntent2, new zzc(this, zza2), zzne.getContext().getPackageName()));
            }

            protected Status zzb(Status status) {
                return status;
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzk zzk, PendingIntent pendingIntent) {
        final SensorRequest sensorRequest2 = sensorRequest;
        final zzk zzk2 = zzk;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzof zzaat;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzne zzne) throws RemoteException {
                ((zzno) zzne.zzjb()).zza(new zzac(sensorRequest2, zzk2, pendingIntent2, new zzoh(this), zzne.getContext().getPackageName()));
            }

            protected Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return zza(client, request, null, intent);
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return zza(client, request, com.google.android.gms.fitness.data.zzl.zza.zzlG().zza(listener), null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.zza(new zza<DataSourcesResult>(this, client) {
            final /* synthetic */ zzof zzaat;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzy(x0);
            }

            protected void zza(zzne zzne) throws RemoteException {
                ((zzno) zzne.zzjb()).zza(new DataSourcesRequest(request, new zzb(this), zzne.getContext().getPackageName()));
            }

            protected DataSourcesResult zzy(Status status) {
                return DataSourcesResult.zzC(status);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return zza(client, null, pendingIntent, null);
    }

    public PendingResult<Status> remove(GoogleApiClient client, final OnDataPointListener listener) {
        zzk zzb = com.google.android.gms.fitness.data.zzl.zza.zzlG().zzb(listener);
        return zzb == null ? new zznx(Status.zzNo) : zza(client, zzb, null, new zza(this) {
            final /* synthetic */ zzof zzaat;

            public void zzlN() {
                com.google.android.gms.fitness.data.zzl.zza.zzlG().zzc(listener);
            }
        });
    }
}
