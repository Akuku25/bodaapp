package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1 */
    class C05971 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzagt;

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzX(x0);
        }

        public GameMuteStatusChangeResult zzX(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C05971 zzagu;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzagt, true);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2 */
    class C05982 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzagt;

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzX(x0);
        }

        public GameMuteStatusChangeResult zzX(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C05982 zzagv;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzagt, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3 */
    class C05993 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String zzagt;

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzY(x0);
        }

        public GameMuteStatusLoadResult zzY(final Status status) {
            return new GameMuteStatusLoadResult(this) {
                final /* synthetic */ C05993 zzagw;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzp((zzb) this, this.zzagt);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzZ(x0);
        }

        public ContactSettingLoadResult zzZ(final Status status) {
            return new ContactSettingLoadResult(this) {
                final /* synthetic */ ContactSettingLoadImpl zzagz;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzaa(x0);
        }

        public InboxCountResult zzaa(final Status status) {
            return new InboxCountResult(this) {
                final /* synthetic */ InboxCountImpl zzagA;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4 */
    class C07084 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, this.zzafy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5 */
    class C07095 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzagx;
        final /* synthetic */ Bundle zzagy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzagx, this.zzagy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6 */
    class C07106 extends InboxCountImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi(this);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzeC(notificationTypes);
        }
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
