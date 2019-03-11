package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.zze;
import com.google.android.gms.fitness.result.DataReadResult;

public class zzoc implements HistoryApi {

    private static class zza extends com.google.android.gms.internal.zzng.zza {
        private final zzb<DataReadResult> zzHa;
        private int zzaam;
        private DataReadResult zzaan;

        private zza(zzb<DataReadResult> zzb) {
            this.zzaam = 0;
            this.zzaan = null;
            this.zzHa = zzb;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.zzaan == null) {
                    this.zzaan = dataReadResult;
                } else {
                    this.zzaan.zzb(dataReadResult);
                }
                this.zzaam++;
                if (this.zzaam == this.zzaan.zzmn()) {
                    this.zzHa.zzd(this.zzaan);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final DataSet dataSet, final boolean z) {
        zzx.zzb((Object) dataSet, (Object) "Must set the data set");
        zzx.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzx.zzb(dataSet.getDataSource().zzlz(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoc zzaaj;

            protected void zza(zznb zznb) throws RemoteException {
                ((zznl) zznb.zzjb()).zza(new zze(dataSet, new zzoh(this), zznb.getContext().getPackageName(), z));
            }
        });
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, final DataDeleteRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzoc zzaaj;

            protected void zza(zznb zznb) throws RemoteException {
                ((zznl) zznb.zzjb()).zza(new DataDeleteRequest(request, new zzoh(this), zznb.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient client, DataSet dataSet) {
        return zza(client, dataSet, false);
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, final DataReadRequest request) {
        return client.zza(new zza<DataReadResult>(this, client) {
            final /* synthetic */ zzoc zzaaj;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzw(x0);
            }

            protected void zza(zznb zznb) throws RemoteException {
                ((zznl) zznb.zzjb()).zza(new DataReadRequest(request, new zza(this), zznb.getContext().getPackageName()));
            }

            protected DataReadResult zzw(Status status) {
                return DataReadResult.zza(status, request);
            }
        });
    }
}
