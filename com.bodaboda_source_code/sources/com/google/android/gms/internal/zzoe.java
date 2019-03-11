package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.zzat;
import com.google.android.gms.fitness.request.zzax;
import com.google.android.gms.fitness.request.zzw;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class zzoe implements RecordingApi {

    private static class zza extends com.google.android.gms.internal.zznq.zza {
        private final zzb<ListSubscriptionsResult> zzHa;

        private zza(zzb<ListSubscriptionsResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzHa.zzd(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoe zzaao;

            protected void zza(zznd zznd) throws RemoteException {
                ((zznn) zznd.zzjb()).zza(new zzat(subscription, false, new zzoh(this), zznd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return client.zza(new zza<ListSubscriptionsResult>(this, client) {
            final /* synthetic */ zzoe zzaao;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzx(x0);
            }

            protected void zza(zznd zznd) throws RemoteException {
                ((zznn) zznd.zzjb()).zza(new zzw(null, new zza(this), zznd.getContext().getPackageName()));
            }

            protected ListSubscriptionsResult zzx(Status status) {
                return ListSubscriptionsResult.zzE(status);
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zza<ListSubscriptionsResult>(this, client) {
            final /* synthetic */ zzoe zzaao;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzx(x0);
            }

            protected void zza(zznd zznd) throws RemoteException {
                ((zznn) zznd.zzjb()).zza(new zzw(dataType, new zza(this), zznd.getContext().getPackageName()));
            }

            protected ListSubscriptionsResult zzx(Status status) {
                return ListSubscriptionsResult.zzE(status);
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataSource).zzlK());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataType).zzlK());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataSource dataSource) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzoe zzaao;

            protected void zza(zznd zznd) throws RemoteException {
                ((zznn) zznd.zzjb()).zza(new zzax(null, dataSource, new zzoh(this), zznd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataType dataType) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzoe zzaao;

            protected void zza(zznd zznd) throws RemoteException {
                ((zznn) zznd.zzjb()).zza(new zzax(dataType, null, new zzoh(this), zznd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
