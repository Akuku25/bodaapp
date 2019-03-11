package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl<LoadExtendedGamesResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzO(x0);
        }

        public LoadExtendedGamesResult zzO(final Status status) {
            return new LoadExtendedGamesResult(this) {
                final /* synthetic */ LoadExtendedGamesImpl zzafY;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzP(x0);
        }

        public LoadGameInstancesResult zzP(final Status status) {
            return new LoadGameInstancesResult(this) {
                final /* synthetic */ LoadGameInstancesImpl zzafZ;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzQ(x0);
        }

        public LoadGameSearchSuggestionsResult zzQ(final Status status) {
            return new LoadGameSearchSuggestionsResult(this) {
                final /* synthetic */ LoadGameSearchSuggestionsImpl zzaga;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzR(x0);
        }

        public LoadGamesResult zzR(final Status status) {
            return new LoadGamesResult(this) {
                final /* synthetic */ LoadGamesImpl zzagb;

                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.zzay(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$10 */
    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafS;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafU;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafS, this.zzafT, false, true, false, this.zzafU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$11 */
    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc(this, this.zzafA, this.zzafT, false, this.zzafy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$12 */
    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc(this, this.zzafA, this.zzafT, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$13 */
    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzafA, this.zzafT, false, this.zzafy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$14 */
    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzafA, this.zzafT, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$15 */
    class AnonymousClass15 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafS;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafU;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafS, this.zzafT, true, false, this.zzafy, this.zzafU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$16 */
    class AnonymousClass16 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafS;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafU;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafS, this.zzafT, true, true, false, this.zzafU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$17 */
    class AnonymousClass17 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ String zzafV;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, this.zzafV, this.zzafT, false, this.zzafy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$18 */
    class AnonymousClass18 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ String zzafV;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, this.zzafV, this.zzafT, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$19 */
    class AnonymousClass19 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String zzafV;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this, this.zzafV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$2 */
    class C06882 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafB;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this, this.zzafB);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$3 */
    class C06893 extends LoadGameInstancesImpl {
        final /* synthetic */ String zzafB;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this, this.zzafB);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$4 */
    class C06904 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, this.zzafT, false, this.zzafy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$5 */
    class C06915 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, this.zzafT, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$6 */
    class C06926 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzafA, this.zzafT, false, this.zzafy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$7 */
    class C06937 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzafA, this.zzafT, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$8 */
    class C06948 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ int zzafW;
        final /* synthetic */ boolean zzafX;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafT, this.zzafW, this.zzafX, this.zzafy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$9 */
    class C06959 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafS;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafU;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafS, this.zzafT, false, false, this.zzafy, this.zzafU);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzns();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.zza(new LoadGamesImpl(this, apiClient) {
            final /* synthetic */ GamesMetadataImpl zzafR;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf((zzb) this);
            }
        });
    }
}
