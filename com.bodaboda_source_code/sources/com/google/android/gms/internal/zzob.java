package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.zzl;
import com.google.android.gms.fitness.request.zzp;
import com.google.android.gms.fitness.result.DataTypeResult;

public class zzob implements ConfigApi {

    private static class zza extends com.google.android.gms.internal.zzni.zza {
        private final zzb<DataTypeResult> zzHa;

        private zza(zzb<DataTypeResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzHa.zzd(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.zzb(new zza<DataTypeResult>(this, client) {
            final /* synthetic */ zzob zzaaf;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzv(x0);
            }

            protected void zza(zzna zzna) throws RemoteException {
                ((zznk) zzna.zzjb()).zza(new DataTypeCreateRequest(request, new zza(this), zzna.getContext().getPackageName()));
            }

            protected DataTypeResult zzv(Status status) {
                return DataTypeResult.zzD(status);
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzob zzaaf;

            protected void zza(zzna zzna) throws RemoteException {
                ((zznk) zzna.zzjb()).zza(new zzp(new zzoh(this), zzna.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, final String dataTypeName) {
        return client.zza(new zza<DataTypeResult>(this, client) {
            final /* synthetic */ zzob zzaaf;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzv(x0);
            }

            protected void zza(zzna zzna) throws RemoteException {
                ((zznk) zzna.zzjb()).zza(new zzl(dataTypeName, new zza(this), zzna.getContext().getPackageName()));
            }

            protected DataTypeResult zzv(Status status) {
                return DataTypeResult.zzD(status);
            }
        });
    }
}
