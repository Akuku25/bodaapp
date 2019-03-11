package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzak implements MessageApi {

    public static class zzb implements SendMessageResult {
        private final Status zzHb;
        private final int zzRV;

        public zzb(Status status, int i) {
            this.zzHb = status;
            this.zzRV = i;
        }

        public int getRequestId() {
            return this.zzRV;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static final class zza extends zzg<Status> {
        private IntentFilter[] zzaGb;
        private MessageListener zzaGv;

        private zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzaGv = messageListener;
            this.zzaGb = intentFilterArr;
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzbd zzbd) throws RemoteException {
            zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaGv, this.zzaGb);
            this.zzaGv = null;
            this.zzaGb = null;
        }

        public Status zzb(Status status) {
            this.zzaGv = null;
            this.zzaGb = null;
            return status;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return zza(client, listener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageListener listener) {
        return client.zza(new zzg<Status>(this, client) {
            final /* synthetic */ zzak zzaGt;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, listener);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, String nodeId, String action, byte[] data) {
        final String str = nodeId;
        final String str2 = action;
        final byte[] bArr = data;
        return client.zza(new zzg<SendMessageResult>(this, client) {
            final /* synthetic */ zzak zzaGt;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzaT(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zza(this, str, str2, bArr);
            }

            protected SendMessageResult zzaT(Status status) {
                return new zzb(status, -1);
            }
        });
    }
}
