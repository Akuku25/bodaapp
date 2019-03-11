package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzH(x0);
        }

        public LoadAchievementsResult zzH(final Status status) {
            return new LoadAchievementsResult(this) {
                final /* synthetic */ LoadImpl zzafE;

                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.zzay(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String zzFA;

        public UpdateImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzFA = id;
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzI(x0);
        }

        public UpdateAchievementResult zzI(final Status status) {
            return new UpdateAchievementResult(this) {
                final /* synthetic */ UpdateImpl zzafF;

                public String getAchievementId() {
                    return this.zzafF.zzFA;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl$10 */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ String zzafB;
        final /* synthetic */ boolean zzafy;

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzafA, this.zzafB, this.zzafy);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zznu();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        apiClient.zzb(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(null, str, i);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        return apiClient.zzb(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, i);
            }
        });
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(this, apiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb) this, forceReload);
            }
        });
    }

    public void reveal(GoogleApiClient apiClient, final String id) {
        apiClient.zzb(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.zzb(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, id);
            }
        });
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        apiClient.zzb(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(null, str, i);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        return apiClient.zzb(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, str, i);
            }
        });
    }

    public void unlock(GoogleApiClient apiClient, final String id) {
        apiClient.zzb(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.zzb(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, id);
            }
        });
    }
}
