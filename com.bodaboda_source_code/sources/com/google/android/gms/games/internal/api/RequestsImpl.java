package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzaj(x0);
        }

        public LoadRequestSummariesResult zzaj(final Status status) {
            return new LoadRequestSummariesResult(this) {
                final /* synthetic */ LoadRequestSummariesImpl zzahd;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzak(x0);
        }

        public LoadRequestsResult zzak(final Status status) {
            return new LoadRequestsResult(this) {
                final /* synthetic */ LoadRequestsImpl zzahe;

                public GameRequestBuffer getRequests(int type) {
                    return new GameRequestBuffer(DataHolder.zzay(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzal(x0);
        }

        public SendRequestResult zzal(final Status status) {
            return new SendRequestResult(this) {
                final /* synthetic */ SendRequestImpl zzahf;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzam(x0);
        }

        public UpdateRequestsResult zzam(final Status status) {
            return new UpdateRequestsResult(this) {
                final /* synthetic */ UpdateRequestsImpl zzahg;

                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$4 */
    class C07294 extends SendRequestImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ String[] zzagZ;
        final /* synthetic */ int zzaha;
        final /* synthetic */ byte[] zzahb;
        final /* synthetic */ int zzahc;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagZ, this.zzaha, this.zzahb, this.zzahc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$5 */
    class C07305 extends SendRequestImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ String[] zzagZ;
        final /* synthetic */ int zzaha;
        final /* synthetic */ byte[] zzahb;
        final /* synthetic */ int zzahc;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagZ, this.zzaha, this.zzahb, this.zzahc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$6 */
    class C07316 extends UpdateRequestsImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ String zzagR;
        final /* synthetic */ String[] zzagV;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagR, this.zzagV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$7 */
    class C07327 extends LoadRequestsImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ String zzagR;
        final /* synthetic */ int zzagX;
        final /* synthetic */ int zzagY;
        final /* synthetic */ int zzagc;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagR, this.zzagX, this.zzagY, this.zzagc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$8 */
    class C07338 extends LoadRequestSummariesImpl {
        final /* synthetic */ String zzagR;
        final /* synthetic */ int zzagY;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(this, this.zzagR, this.zzagY);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl zzagW;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl zzagW;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zznG();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zznI();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zznH();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.zzd(apiClient).zza(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        final int i = requestDirection;
        final int i2 = types;
        final int i3 = sortOrder;
        return apiClient.zza(new LoadRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl zzagW;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, i, i2, i3);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzd(apiClient.zzf(listener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zznA();
        }
    }
}
