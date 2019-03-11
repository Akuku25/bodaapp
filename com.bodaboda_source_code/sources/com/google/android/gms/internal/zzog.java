package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzai;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.request.zzao;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzog implements SessionsApi {

    private static class zza extends com.google.android.gms.internal.zznt.zza {
        private final com.google.android.gms.common.api.zza.zzb<SessionReadResult> zzHa;

        private zza(com.google.android.gms.common.api.zza.zzb<SessionReadResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzHa.zzd(sessionReadResult);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zznu.zza {
        private final com.google.android.gms.common.api.zza.zzb<SessionStopResult> zzHa;

        private zzb(com.google.android.gms.common.api.zza.zzb<SessionStopResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzHa.zzd(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zza<SessionStopResult>(this, googleApiClient) {
            final /* synthetic */ zzog zzaaD;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzz(x0);
            }

            protected void zza(zznf zznf) throws RemoteException {
                ((zznp) zznf.zzjb()).zza(new zzam(str, str2, new zzb(this), zznf.getContext().getPackageName()));
            }

            protected SessionStopResult zzz(Status status) {
                return SessionStopResult.zzG(status);
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzog zzaaD;

            protected void zza(zznf zznf) throws RemoteException {
                ((zznp) zznf.zzjb()).zza(new SessionInsertRequest(request, new zzoh(this), zznf.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.zza(new zza<SessionReadResult>(this, client) {
            final /* synthetic */ zzog zzaaD;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzA(x0);
            }

            protected SessionReadResult zzA(Status status) {
                return SessionReadResult.zzF(status);
            }

            protected void zza(zznf zznf) throws RemoteException {
                ((zznp) zznf.zzjb()).zza(new SessionReadRequest(request, new zza(this), zznf.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzog zzaaD;

            protected void zza(zznf zznf) throws RemoteException {
                ((zznp) zznf.zzjb()).zza(new zzai(intent, new zzoh(this), zznf.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        zzx.zzb((Object) session, (Object) "Session cannot be null");
        zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzog zzaaD;

            protected void zza(zznf zznf) throws RemoteException {
                ((zznp) zznf.zzjb()).zza(new zzak(session, new zzoh(this), zznf.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return zza(client, null, identifier);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzog zzaaD;

            protected void zza(zznf zznf) throws RemoteException {
                ((zznp) zznf.zzjb()).zza(new zzao(intent, new zzoh(this), zznf.getContext().getPackageName()));
            }
        });
    }
}
