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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {
        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzag(x0);
        }

        public AcceptQuestResult zzag(final Status status) {
            return new AcceptQuestResult(this) {
                final /* synthetic */ AcceptImpl zzagS;

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {
        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzah(x0);
        }

        public ClaimMilestoneResult zzah(final Status status) {
            return new ClaimMilestoneResult(this) {
                final /* synthetic */ ClaimImpl zzagT;

                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzai(x0);
        }

        public LoadQuestsResult zzai(final Status status) {
            return new LoadQuestsResult(this) {
                final /* synthetic */ LoadsImpl zzagU;

                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.zzay(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$5 */
    class C07245 extends LoadsImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ boolean zzafy;
        final /* synthetic */ int[] zzagP;
        final /* synthetic */ String zzagR;
        final /* synthetic */ int zzagc;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagR, this.zzagP, this.zzagc, this.zzafy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$6 */
    class C07256 extends LoadsImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ boolean zzafy;
        final /* synthetic */ String[] zzagQ;
        final /* synthetic */ String zzagR;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagR, this.zzafy, this.zzagQ);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient apiClient, final String questId) {
        return apiClient.zzb(new AcceptImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl zzagN;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzh((zzb) this, questId);
            }
        });
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient apiClient, final String questId, final String milestoneId) {
        return apiClient.zzb(new ClaimImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl zzagN;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, questId, milestoneId);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.zzd(apiClient).zzbP(questId);
    }

    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.zzd(apiClient).zzb(questSelectors);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient apiClient, int[] questSelectors, int sortOrder, boolean forceReload) {
        final int[] iArr = questSelectors;
        final int i = sortOrder;
        final boolean z = forceReload;
        return apiClient.zza(new LoadsImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl zzagN;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, iArr, i, z);
            }
        });
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... questIds) {
        return apiClient.zza(new LoadsImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl zzagN;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, forceReload, questIds);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzc(apiClient.zzf(listener));
        }
    }

    public void showStateChangedPopup(GoogleApiClient apiClient, String questId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzbQ(questId);
        }
    }

    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zznz();
        }
    }
}
