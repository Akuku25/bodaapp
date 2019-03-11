package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.api.zze.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.zzvc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

public final class GamesClientImpl extends zzk<IGamesService> implements ConnectionCallbacks, OnConnectionFailedListener {
    EventIncrementManager zzadP = new C03221(this);
    private final String zzadQ;
    private PlayerEntity zzadR;
    private GameEntity zzadS;
    private final PopupManager zzadT;
    private boolean zzadU = false;
    private final Binder zzadV;
    private final long zzadW;
    private final GamesOptions zzadX;

    /* renamed from: com.google.android.gms.games.internal.GamesClientImpl$1 */
    class C03221 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl zzadY;

        C03221(GamesClientImpl gamesClientImpl) {
            this.zzadY = gamesClientImpl;
        }

        public EventIncrementCache zznM() {
            return new GameClientEventIncrementCache(this.zzadY);
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl zzadY;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.zzadY = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), 1000);
        }

        protected void zzs(String str, int i) {
            try {
                if (this.zzadY.isConnected()) {
                    ((IGamesService) this.zzadY.zzjb()).zzp(str, i);
                } else {
                    GamesLog.zzs("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesLog.zzr("GamesClientImpl", "service died");
            }
        }
    }

    private static final class InvitationReceivedNotifier implements zzb<OnInvitationReceivedListener> {
        private final Invitation zzaej;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzaej = invitation;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzaej);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class InvitationRemovedNotifier implements zzb<OnInvitationReceivedListener> {
        private final String zzaek;

        InvitationRemovedNotifier(String invitationId) {
            this.zzaek = invitationId;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzaek);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class LeftRoomNotifier implements zzb<RoomUpdateListener> {
        private final int zzLs;
        private final String zzaem;

        LeftRoomNotifier(int statusCode, String roomId) {
            this.zzLs = statusCode;
            this.zzaem = roomId;
        }

        public void zza(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzLs, this.zzaem);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((RoomUpdateListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class MatchRemovedNotifier implements zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzaeF;

        MatchRemovedNotifier(String matchId) {
            this.zzaeF = matchId;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzaeF);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class MatchUpdateReceivedNotifier implements zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzaeG;

        MatchUpdateReceivedNotifier(TurnBasedMatch match) {
            this.zzaeG = match;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzaeG);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class MessageReceivedNotifier implements zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzaeH;

        MessageReceivedNotifier(RealTimeMessage message) {
            this.zzaeH = message;
        }

        public void zza(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzaeH);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((RealTimeMessageReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzaeI;

        public void zza(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzaeI);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnNearbyPlayerDetectedListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class P2PConnectedNotifier implements zzb<RoomStatusUpdateListener> {
        private final String zzaeO;

        P2PConnectedNotifier(String participantId) {
            this.zzaeO = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzaeO);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class P2PDisconnectedNotifier implements zzb<RoomStatusUpdateListener> {
        private final String zzaeO;

        P2PDisconnectedNotifier(String participantId) {
            this.zzaeO = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzaeO);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class QuestCompletedNotifier implements zzb<QuestUpdateListener> {
        private final Quest zzaea;

        QuestCompletedNotifier(Quest quest) {
            this.zzaea = quest;
        }

        public void zza(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzaea);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((QuestUpdateListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class RealTimeMessageSentNotifier implements zzb<ReliableMessageSentCallback> {
        private final int zzLs;
        private final String zzaeT;
        private final int zzaeU;

        RealTimeMessageSentNotifier(int statusCode, int token, String recipientParticipantId) {
            this.zzLs = statusCode;
            this.zzaeU = token;
            this.zzaeT = recipientParticipantId;
        }

        public void zza(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzLs, this.zzaeU, this.zzaeT);
            }
        }

        public /* synthetic */ void zze(Object obj) {
            zza((ReliableMessageSentCallback) obj);
        }

        public void zzhX() {
        }
    }

    private static final class RequestReceivedNotifier implements zzb<OnRequestReceivedListener> {
        private final GameRequest zzaeW;

        RequestReceivedNotifier(GameRequest request) {
            this.zzaeW = request;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzaeW);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    private static final class RequestRemovedNotifier implements zzb<OnRequestReceivedListener> {
        private final String zzxv;

        RequestRemovedNotifier(String requestId) {
            this.zzxv = requestId;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzxv);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    private static abstract class AbstractRoomNotifier extends com.google.android.gms.common.api.zzb<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzR(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class AbstractRoomStatusNotifier extends com.google.android.gms.common.api.zzb<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzR(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status zzHb;
        private final String zzaec;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.zzHb = status;
            this.zzaec = externalMatchId;
        }

        public String getMatchId() {
            return this.zzaec;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status zzHb;
        private final String zzaef;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.zzHb = GamesStatusCodes.zzep(statusCode);
            this.zzaef = snapshotId;
        }

        public String getSnapshotId() {
            return this.zzaef;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status zzHb;
        private final String zzaeg;
        private final boolean zzaeh;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.zzHb = GamesStatusCodes.zzep(statusCode);
            this.zzaeg = externalGameId;
            this.zzaeh = isMuted;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status zzHb;
        private final String zzaeg;
        private final boolean zzaeh;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzHb = GamesStatusCodes.zzep(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaeg = dataHolder.zzc("external_game_id", 0, 0);
                    this.zzaeh = dataHolder.zzd("muted", 0, 0);
                } else {
                    this.zzaeg = null;
                    this.zzaeh = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static abstract class GamesDataHolderResult extends zzc {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzep(dataHolder.getStatusCode()));
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Status zzHb;
        private final Bundle zzaei;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.zzHb = status;
            this.zzaei = inboxCounts;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status zzHb;
        private final LoadMatchesResponse zzaev;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.zzHb = status;
            this.zzaev = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.zzaev;
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public void release() {
            this.zzaev.release();
        }
    }

    private static final class LoadOwnerCoverPhotoUrisResultImpl implements LoadOwnerCoverPhotoUrisResult {
        private final Bundle zzGK;
        private final Status zzHb;

        LoadOwnerCoverPhotoUrisResultImpl(int statusCode, Bundle bundle) {
            this.zzHb = GamesStatusCodes.zzep(statusCode);
            this.zzGK = bundle;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status zzHb;
        private final Bundle zzaez;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.zzHb = status;
            this.zzaez = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String zzeJ = RequestType.zzeJ(requestType);
            return !this.zzaez.containsKey(zzeJ) ? null : new GameRequestBuffer((DataHolder) this.zzaez.get(zzeJ));
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public void release() {
            for (String parcelable : this.zzaez.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzaez.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status zzHb;
        private final List<String> zzaeC;
        private final Bundle zzaeD;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.zzHb = status;
            this.zzaeC = xpData.getStringArrayList("game_category_list");
            this.zzaeD = xpData;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status zzHb;
        private final String zzacY;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.zzHb = GamesStatusCodes.zzep(statusCode);
            this.zzacY = achievementId;
        }

        public String getAchievementId() {
            return this.zzacY;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzadZ = new ArrayList();

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder);
            for (Object add : participantIds) {
                this.zzadZ.add(add);
            }
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzadZ);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements AcceptQuestResult {
        private final Quest zzaea;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaea = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzaea = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.zzaea;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateAchievementResult> zzHa;

        AchievementUpdatedBinderCallback(zza.zzb<UpdateAchievementResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzf(int i, String str) {
            this.zzHa.zzd(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAchievementsResult> zzHa;

        AchievementsLoadedBinderCallback(zza.zzb<LoadAchievementsResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzc(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAppContentResult> zzaeb;

        public AppContentLoadedBinderCallbacks(zza.zzb<LoadAppContentResult> resultHolder) {
            this.zzaeb = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder[] dataHolderArr) {
            this.zzaeb.zzd(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements ClaimMilestoneResult {
        private final Quest zzaea;
        private final Milestone zzaed;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaea = new QuestEntity((Quest) questBuffer.get(0));
                    List zzoZ = this.zzaea.zzoZ();
                    int size = zzoZ.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) zzoZ.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.zzaed = (Milestone) zzoZ.get(i);
                            return;
                        }
                    }
                    this.zzaed = null;
                } else {
                    this.zzaed = null;
                    this.zzaea = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.zzaed;
        }

        public Quest getQuest() {
            return this.zzaea;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements CommitSnapshotResult {
        private final SnapshotMetadata zzaee;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzaee = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzaee = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzaee;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<ContactSettingLoadResult> zzHa;

        ContactSettingsLoadedBinderCallback(zza.zzb<ContactSettingLoadResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzD(DataHolder dataHolder) {
            this.zzHa.zzd(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzHa;

        ContactSettingsUpdatedBinderCallback(zza.zzb<Status> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzey(int i) {
            this.zzHa.zzd(GamesStatusCodes.zzep(i));
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadEventsResult> zzHa;

        EventsLoadedBinderCallback(zza.zzb<LoadEventsResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzd(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadEventResultImpl(dataHolder));
        }
    }

    private static final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadExtendedGamesResult> zzHa;

        ExtendedGamesLoadedBinderCallback(zza.zzb<LoadExtendedGamesResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzj(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadExtendedGamesResultImpl(dataHolder));
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGameInstancesResult> zzHa;

        GameInstancesLoadedBinderCallback(zza.zzb<LoadGameInstancesResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzk(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GameMuteStatusChangeResult> zzHa;

        GameMuteStatusChangedBinderCallback(zza.zzb<GameMuteStatusChangeResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zza(int i, String str, boolean z) {
            this.zzHa.zzd(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GameMuteStatusLoadResult> zzHa;

        GameMuteStatusLoadedBinderCallback(zza.zzb<GameMuteStatusLoadResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzB(DataHolder dataHolder) {
            this.zzHa.zzd(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGameSearchSuggestionsResult> zzHa;

        GameSearchSuggestionsLoadedBinderCallback(zza.zzb<LoadGameSearchSuggestionsResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzl(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGamesResult> zzHa;

        GamesLoadedBinderCallback(zza.zzb<LoadGamesResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzi(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<InboxCountResult> zzHa;

        InboxCountsLoadedBinderCallback(zza.zzb<InboxCountResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzh(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzHa.zzd(new InboxCountResultImpl(GamesStatusCodes.zzep(i), bundle));
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zze<OnInvitationReceivedListener> zzTW;

        InvitationReceivedBinderCallback(zze<OnInvitationReceivedListener> listener) {
            this.zzTW = listener;
        }

        public void onInvitationRemoved(String invitationId) {
            this.zzTW.zza(new InvitationRemovedNotifier(invitationId));
        }

        public void zzn(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.zzTW.zza(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadInvitationsResult> zzHa;

        InvitationsLoadedBinderCallback(zza.zzb<LoadInvitationsResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzm(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements LeaderboardMetadataResult {
        private final LeaderboardBuffer zzael;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzael = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.zzael;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadScoresResult> zzHa;

        LeaderboardScoresLoadedBinderCallback(zza.zzb<LoadScoresResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzHa.zzd(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LeaderboardMetadataResult> zzHa;

        LeaderboardsLoadedBinderCallback(zza.zzb<LeaderboardMetadataResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zze(DataHolder dataHolder) {
            this.zzHa.zzd(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements LoadAchievementsResult {
        private final AchievementBuffer zzaen;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaen = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.zzaen;
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements LoadAppContentResult {
        private final ArrayList<DataHolder> zzaeo;

        LoadAppContentsResultImpl(DataHolder[] appContentData) {
            super(appContentData[0]);
            this.zzaeo = new ArrayList(Arrays.asList(appContentData));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements LoadEventsResult {
        private final EventBuffer zzaep;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaep = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.zzaep;
        }
    }

    private static final class LoadExtendedGamesResultImpl extends GamesDataHolderResult implements LoadExtendedGamesResult {
        private final ExtendedGameBuffer zzaeq;

        LoadExtendedGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaeq = new ExtendedGameBuffer(dataHolder);
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements LoadGameInstancesResult {
        private final GameInstanceBuffer zzaer;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaer = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaes;

        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
            this.zzaes = new GameSearchSuggestionBuffer(data);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements LoadGamesResult {
        private final GameBuffer zzaet;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaet = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.zzaet;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements LoadInvitationsResult {
        private final InvitationBuffer zzaeu;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaeu = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.zzaeu;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzaew;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzaew = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzaew = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.zzaew;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements LoadPlayersResult {
        private final PlayerBuffer zzaex;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaex = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.zzaex;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements LoadProfileSettingsResult {
        private final boolean zzadM;
        private final boolean zzaey;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int zzax = dataHolder.zzax(0);
                    this.zzadM = dataHolder.zzd("profile_visible", 0, zzax);
                    this.zzaey = dataHolder.zzd("profile_visibility_explicitly_set", 0, zzax);
                } else {
                    this.zzadM = true;
                    this.zzaey = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public boolean isProfileVisible() {
            return this.zzadM;
        }

        public boolean isVisibilityExplicitlySet() {
            return this.zzaey;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements LoadQuestsResult {
        private final DataHolder zzMd;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzMd = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzMd);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements LoadScoresResult {
        private final LeaderboardEntity zzaeA;
        private final LeaderboardScoreBuffer zzaeB;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzaeA = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzaeA = null;
                }
                leaderboardBuffer.release();
                this.zzaeB = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.zzaeA;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzaeB;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzMd);
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements LoadXpStreamResult {
        private final ExperienceEventBuffer zzaeE;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaeE = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zze<OnTurnBasedMatchUpdateReceivedListener> zzTW;

        MatchUpdateReceivedBinderCallback(zze<OnTurnBasedMatchUpdateReceivedListener> listener) {
            this.zzTW = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.zzTW.zza(new MatchRemovedNotifier(matchId));
        }

        public void zzt(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.zzTW.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAclResult> zzHa;

        NotifyAclLoadedBinderCallback(zza.zzb<LoadAclResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzC(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzHa;

        NotifyAclUpdatedBinderCallback(zza.zzb<Status> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzex(int i) {
            this.zzHa.zzd(GamesStatusCodes.zzep(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements OpenSnapshotResult {
        private final Snapshot zzaeJ;
        private final String zzaeK;
        private final Snapshot zzaeL;
        private final Contents zzaeM;
        private final SnapshotContents zzaeN;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzaeJ = null;
                    this.zzaeL = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == 4004) {
                        z = false;
                    }
                    com.google.android.gms.common.internal.zzb.zzN(z);
                    this.zzaeJ = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzaeL = null;
                } else {
                    this.zzaeJ = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzaeL = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.zzaeK = conflictId;
                this.zzaeM = resolutionContents;
                this.zzaeN = new SnapshotContentsEntity(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.zzaeK;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzaeL;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzaeN;
        }

        public Snapshot getSnapshot() {
            return this.zzaeJ;
        }
    }

    private static final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadOwnerCoverPhotoUrisResult> zzHa;

        OwnerCoverPhotoUrisLoadedBinderCallback(zza.zzb<LoadOwnerCoverPhotoUrisResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzHa.zzd(new LoadOwnerCoverPhotoUrisResultImpl(i, bundle));
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadPlayerScoreResult> zzHa;

        PlayerLeaderboardScoreLoadedBinderCallback(zza.zzb<LoadPlayerScoreResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzE(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadXpForGameCategoriesResult> zzHa;

        PlayerXpForGameCategoriesLoadedBinderCallback(zza.zzb<LoadXpForGameCategoriesResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzHa.zzd(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzep(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadXpStreamResult> zzHa;

        PlayerXpStreamLoadedBinderCallback(zza.zzb<LoadXpStreamResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzP(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadPlayersResult> zzHa;

        PlayersLoadedBinderCallback(zza.zzb<LoadPlayersResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzg(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadPlayersResultImpl(dataHolder));
        }

        public void zzh(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzadT;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzadT = popupManager;
        }

        public PopupLocationInfoParcelable zznk() {
            return new PopupLocationInfoParcelable(this.zzadT.zzof());
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadProfileSettingsResult> zzHa;

        ProfileSettingsLoadedBinderCallback(zza.zzb<LoadProfileSettingsResult> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzQ(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzHa;

        ProfileSettingsUpdatedBinderCallback(zza.zzb<Status> holder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzez(int i) {
            this.zzHa.zzd(GamesStatusCodes.zzep(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<AcceptQuestResult> zzaeP;

        public QuestAcceptedBinderCallbacks(zza.zzb<AcceptQuestResult> resultHolder) {
            this.zzaeP = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzL(DataHolder dataHolder) {
            this.zzaeP.zzd(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<ClaimMilestoneResult> zzaeQ;
        private final String zzaeR;

        public QuestMilestoneClaimBinderCallbacks(zza.zzb<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.zzaeQ = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
            this.zzaeR = (String) zzx.zzb((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        public void zzK(DataHolder dataHolder) {
            this.zzaeQ.zzd(new ClaimMilestoneResultImpl(dataHolder, this.zzaeR));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zze<QuestUpdateListener> zzTW;

        QuestUpdateBinderCallback(zze<QuestUpdateListener> listener) {
            this.zzTW = listener;
        }

        private Quest zzT(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public void zzM(DataHolder dataHolder) {
            Quest zzT = zzT(dataHolder);
            if (zzT != null) {
                this.zzTW.zza(new QuestCompletedNotifier(zzT));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadQuestsResult> zzaeS;

        public QuestsLoadedBinderCallbacks(zza.zzb<LoadQuestsResult> resultHolder) {
            this.zzaeS = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzO(DataHolder dataHolder) {
            this.zzaeS.zzd(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zze<ReliableMessageSentCallback> zzaeV;

        public RealTimeReliableMessageBinderCallbacks(zze<ReliableMessageSentCallback> messageSentCallbacks) {
            this.zzaeV = messageSentCallbacks;
        }

        public void zzb(int i, int i2, String str) {
            if (this.zzaeV != null) {
                this.zzaeV.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zze<OnRequestReceivedListener> zzTW;

        RequestReceivedBinderCallback(zze<OnRequestReceivedListener> listener) {
            this.zzTW = listener;
        }

        public void onRequestRemoved(String requestId) {
            this.zzTW.zza(new RequestRemovedNotifier(requestId));
        }

        public void zzo(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.zzTW.zza(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<SendRequestResult> zzaeX;

        public RequestSentBinderCallbacks(zza.zzb<SendRequestResult> resultHolder) {
            this.zzaeX = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzG(DataHolder dataHolder) {
            this.zzaeX.zzd(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadRequestSummariesResult> zzaeY;

        public RequestSummariesLoadedBinderCallbacks(zza.zzb<LoadRequestSummariesResult> resultHolder) {
            this.zzaeY = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzH(DataHolder dataHolder) {
            this.zzaeY.zzd(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadRequestsResult> zzaeZ;

        public RequestsLoadedBinderCallbacks(zza.zzb<LoadRequestsResult> resultHolder) {
            this.zzaeZ = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zze(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaeZ.zzd(new LoadRequestsResultImpl(GamesStatusCodes.zzep(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateRequestsResult> zzafa;

        public RequestsUpdatedBinderCallbacks(zza.zzb<UpdateRequestsResult> resultHolder) {
            this.zzafa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzF(DataHolder dataHolder) {
            this.zzafa.zzd(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zze<? extends RoomUpdateListener> zzafb;
        private final zze<? extends RoomStatusUpdateListener> zzafc;
        private final zze<RealTimeMessageReceivedListener> zzafd;

        public RoomBinderCallbacks(zze<RoomUpdateListener> roomCallbacks) {
            this.zzafb = (zze) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzafc = null;
            this.zzafd = null;
        }

        public RoomBinderCallbacks(zze<? extends RoomUpdateListener> roomCallbacks, zze<? extends RoomStatusUpdateListener> roomStatusCallbacks, zze<RealTimeMessageReceivedListener> realTimeMessageReceivedCallbacks) {
            this.zzafb = (zze) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzafc = roomStatusCallbacks;
            this.zzafd = realTimeMessageReceivedCallbacks;
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.zzafb.zza(new LeftRoomNotifier(statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            if (this.zzafc != null) {
                this.zzafc.zza(new P2PConnectedNotifier(participantId));
            }
        }

        public void onP2PDisconnected(String participantId) {
            if (this.zzafc != null) {
                this.zzafc.zza(new P2PDisconnectedNotifier(participantId));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            if (this.zzafd != null) {
                this.zzafd.zza(new MessageReceivedNotifier(message));
            }
        }

        public void zzA(DataHolder dataHolder) {
            if (this.zzafc != null) {
                this.zzafc.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzu(DataHolder dataHolder) {
            this.zzafb.zza(new RoomCreatedNotifier(dataHolder));
        }

        public void zzv(DataHolder dataHolder) {
            this.zzafb.zza(new JoinedRoomNotifier(dataHolder));
        }

        public void zzw(DataHolder dataHolder) {
            if (this.zzafc != null) {
                this.zzafc.zza(new RoomConnectingNotifier(dataHolder));
            }
        }

        public void zzx(DataHolder dataHolder) {
            if (this.zzafc != null) {
                this.zzafc.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void zzy(DataHolder dataHolder) {
            this.zzafb.zza(new RoomConnectedNotifier(dataHolder));
        }

        public void zzz(DataHolder dataHolder) {
            if (this.zzafc != null) {
                this.zzafc.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements SendRequestResult {
        private final GameRequest zzaeW;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzaeW = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzaeW = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzHa;

        public SignOutCompleteBinderCallbacks(zza.zzb<Status> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzhb() {
            this.zzHa.zzd(GamesStatusCodes.zzep(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<CommitSnapshotResult> zzafe;

        public SnapshotCommittedBinderCallbacks(zza.zzb<CommitSnapshotResult> resultHolder) {
            this.zzafe = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzJ(DataHolder dataHolder) {
            this.zzafe.zzd(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<DeleteSnapshotResult> zzHa;

        public SnapshotDeletedBinderCallbacks(zza.zzb<DeleteSnapshotResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(int i, String str) {
            this.zzHa.zzd(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<OpenSnapshotResult> zzaff;

        public SnapshotOpenedBinderCallbacks(zza.zzb<OpenSnapshotResult> resultHolder) {
            this.zzaff = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzaff.zzd(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzaff.zzd(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadSnapshotsResult> zzafg;

        public SnapshotsLoadedBinderCallbacks(zza.zzb<LoadSnapshotsResult> resultHolder) {
            this.zzafg = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzI(DataHolder dataHolder) {
            this.zzafg.zzd(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<SubmitScoreResult> zzHa;

        public SubmitScoreBinderCallbacks(zza.zzb<SubmitScoreResult> resultHolder) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzf(DataHolder dataHolder) {
            this.zzHa.zzd(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements SubmitScoreResult {
        private final ScoreSubmissionData zzafh;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzafh = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.zzafh;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<CancelMatchResult> zzafi;

        public TurnBasedMatchCanceledBinderCallbacks(zza.zzb<CancelMatchResult> resultHolder) {
            this.zzafi = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzg(int i, String str) {
            this.zzafi.zzd(new CancelMatchResultImpl(GamesStatusCodes.zzep(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<InitiateMatchResult> zzafj;

        public TurnBasedMatchInitiatedBinderCallbacks(zza.zzb<InitiateMatchResult> resultHolder) {
            this.zzafj = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzq(DataHolder dataHolder) {
            this.zzafj.zzd(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LeaveMatchResult> zzafk;

        public TurnBasedMatchLeftBinderCallbacks(zza.zzb<LeaveMatchResult> resultHolder) {
            this.zzafk = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzs(DataHolder dataHolder) {
            this.zzafk.zzd(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadMatchResult> zzafl;

        public TurnBasedMatchLoadedBinderCallbacks(zza.zzb<LoadMatchResult> resultHolder) {
            this.zzafl = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzp(DataHolder dataHolder) {
            this.zzafl.zzd(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzaeG;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzaeG = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzaeG = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzaeG;
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateMatchResult> zzafm;

        public TurnBasedMatchUpdatedBinderCallbacks(zza.zzb<UpdateMatchResult> resultHolder) {
            this.zzafm = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzr(DataHolder dataHolder) {
            this.zzafm.zzd(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadMatchesResult> zzafn;

        public TurnBasedMatchesLoadedBinderCallbacks(zza.zzb<LoadMatchesResult> resultHolder) {
            this.zzafn = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzafn.zzd(new LoadMatchesResultImpl(GamesStatusCodes.zzep(i), bundle));
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements UpdateRequestsResult {
        private final RequestUpdateOutcomes zzafo;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzafo = RequestUpdateOutcomes.zzW(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.zzafo.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.zzafo.getRequestOutcome(requestId);
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    public GamesClientImpl(Context context, Looper looper, zzf clientSettings, GamesOptions options, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
        super(context, looper, 1, connectedListener, connectionFailedListener, clientSettings);
        this.zzadQ = clientSettings.zziR();
        this.zzadV = new Binder();
        this.zzadT = PopupManager.zza(this, clientSettings.zziO());
        zzl(clientSettings.zziT());
        this.zzadW = (long) hashCode();
        this.zzadX = options;
        registerConnectionCallbacks(this);
        registerConnectionFailedListener(this);
    }

    private static Room zzR(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private void zznn() {
        this.zzadR = null;
        this.zzadS = null;
    }

    public void connect() {
        zznn();
        super.connect();
    }

    public void disconnect() {
        this.zzadU = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zzjb();
                iGamesService.zznL();
                this.zzadP.flush();
                iGamesService.zzu(this.zzadW);
            } catch (RemoteException e) {
                GamesLog.zzr("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnected(Bundle connectionHint) {
        if (this.zzadU) {
            this.zzadT.zzoc();
            this.zzadU = false;
        }
        if (!this.zzadX.zzacA) {
            zzno();
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.zzadU = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    public int zza(zze<ReliableMessageSentCallback> zze, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zzjb()).zza(new RealTimeReliableMessageBinderCallbacks(zze), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzx.zzb((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) zzjb()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent zza(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzjb()).zza(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = ((IGamesService) zzjb()).zza(i, bArr, i2, str);
            zzx.zzb((Object) bitmap, (Object) "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zzjb()).zza(playerEntity);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zzjb()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zzjb()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzadU = bundle.getBoolean("show_welcome_popup");
            this.zzadR = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzadS = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zzjb()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.zzr("GamesClientImpl", "service died");
            }
        }
    }

    public void zza(zza.zzb<LoadRequestsResult> zzb, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzjb()).zza(new RequestsLoadedBinderCallbacks(zzb), i, i2, i3);
    }

    public void zza(zza.zzb<LoadExtendedGamesResult> zzb, int i, int i2, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zza(new ExtendedGamesLoadedBinderCallback(zzb), i, i2, z, z2);
    }

    public void zza(zza.zzb<LoadAppContentResult> zzb, int i, String str, String[] strArr, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zza(new AppContentLoadedBinderCallbacks(zzb), i, str, strArr, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> zzb, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zza(new PlayersLoadedBinderCallback(zzb), i, z, z2);
    }

    public void zza(zza.zzb<LoadMatchesResult> zzb, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchesLoadedBinderCallbacks(zzb), i, iArr);
    }

    public void zza(zza.zzb<LoadScoresResult> zzb, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        ((IGamesService) zzjb()).zza(new LeaderboardScoresLoadedBinderCallback(zzb), leaderboardScoreBuffer.zzoQ().zzoR(), i, i2);
    }

    public void zza(zza.zzb<InitiateMatchResult> zzb, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchInitiatedBinderCallbacks(zzb), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzoX(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zza.zzb<CommitSnapshotResult> zzb, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        com.google.android.gms.common.data.zza zzpc = snapshotMetadataChange.zzpc();
        if (zzpc != null) {
            zzpc.zza(getContext().getCacheDir());
        }
        Contents zzkq = snapshotContents.zzkq();
        snapshotContents.close();
        ((IGamesService) zzjb()).zza(new SnapshotCommittedBinderCallbacks(zzb), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzkq);
    }

    public void zza(zza.zzb<UpdateAchievementResult> zzb, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (zzb == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(zzb);
        }
        ((IGamesService) zzjb()).zza(iGamesCallbacks, str, this.zzadT.zzoe(), this.zzadT.zzod());
    }

    public void zza(zza.zzb<UpdateAchievementResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzjb()).zza(zzb == null ? null : new AchievementUpdatedBinderCallback(zzb), str, i, this.zzadT.zzoe(), this.zzadT.zzod());
    }

    public void zza(zza.zzb<LoadScoresResult> zzb, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zza(new LeaderboardScoresLoadedBinderCallback(zzb), str, i, i2, i3, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> zzb, String str, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                ((IGamesService) zzjb()).zzd(new PlayersLoadedBinderCallback(zzb), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<LoadExtendedGamesResult> zzb, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException {
        ((IGamesService) zzjb()).zza(new ExtendedGamesLoadedBinderCallback(zzb), str, i, z, z2, z3, z4);
    }

    public void zza(zza.zzb<LoadMatchesResult> zzb, String str, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchesLoadedBinderCallbacks(zzb), str, i, iArr);
    }

    public void zza(zza.zzb<SubmitScoreResult> zzb, String str, long j, String str2) throws RemoteException {
        ((IGamesService) zzjb()).zza(zzb == null ? null : new SubmitScoreBinderCallbacks(zzb), str, j, str2);
    }

    public void zza(zza.zzb<LeaveMatchResult> zzb, String str, String str2) throws RemoteException {
        ((IGamesService) zzjb()).zzc(new TurnBasedMatchLeftBinderCallbacks(zzb), str, str2);
    }

    public void zza(zza.zzb<LoadPlayerScoreResult> zzb, String str, String str2, int i, int i2) throws RemoteException {
        ((IGamesService) zzjb()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(zzb), str, str2, i, i2);
    }

    public void zza(zza.zzb<LoadRequestsResult> zzb, String str, String str2, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzjb()).zza(new RequestsLoadedBinderCallbacks(zzb), str, str2, i, i2, i3);
    }

    public void zza(zza.zzb<LoadScoresResult> zzb, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zza(new LeaderboardScoresLoadedBinderCallback(zzb), str, str2, i, i2, i3, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> zzb, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
                ((IGamesService) zzjb()).zza(new PlayersLoadedBinderCallback(zzb), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<OpenSnapshotResult> zzb, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzx.zza(!snapshotContents.isClosed(), (Object) "SnapshotContents already closed");
        com.google.android.gms.common.data.zza zzpc = snapshotMetadataChange.zzpc();
        if (zzpc != null) {
            zzpc.zza(getContext().getCacheDir());
        }
        Contents zzkq = snapshotContents.zzkq();
        snapshotContents.close();
        ((IGamesService) zzjb()).zza(new SnapshotOpenedBinderCallbacks(zzb), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzkq);
    }

    public void zza(zza.zzb<LeaderboardMetadataResult> zzb, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new LeaderboardsLoadedBinderCallback(zzb), str, str2, z);
    }

    public void zza(zza.zzb<LoadQuestsResult> zzb, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new QuestsLoadedBinderCallbacks(zzb), str, str2, strArr, z);
    }

    public void zza(zza.zzb<LoadQuestsResult> zzb, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new QuestsLoadedBinderCallbacks(zzb), str, str2, iArr, i, z);
    }

    public void zza(zza.zzb<UpdateRequestsResult> zzb, String str, String str2, String[] strArr) throws RemoteException {
        ((IGamesService) zzjb()).zza(new RequestsUpdatedBinderCallbacks(zzb), str, str2, strArr);
    }

    public void zza(zza.zzb<LoadPlayersResult> zzb, String str, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzf(new PlayersLoadedBinderCallback(zzb), str, z);
    }

    public void zza(zza.zzb<OpenSnapshotResult> zzb, String str, boolean z, int i) throws RemoteException {
        ((IGamesService) zzjb()).zza(new SnapshotOpenedBinderCallbacks(zzb), str, z, i);
    }

    public void zza(zza.zzb<UpdateMatchResult> zzb, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchUpdatedBinderCallbacks(zzb), str, bArr, str2, participantResultArr);
    }

    public void zza(zza.zzb<UpdateMatchResult> zzb, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchUpdatedBinderCallbacks(zzb), str, bArr, participantResultArr);
    }

    public void zza(zza.zzb<SendRequestResult> zzb, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        ((IGamesService) zzjb()).zza(new RequestSentBinderCallbacks(zzb), str, strArr, i, bArr, i2);
    }

    public void zza(zza.zzb<LoadPlayersResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzc(new PlayersLoadedBinderCallback(zzb), z);
    }

    public void zza(zza.zzb<Status> zzb, boolean z, Bundle bundle) throws RemoteException {
        ((IGamesService) zzjb()).zza(new ContactSettingsUpdatedBinderCallback(zzb), z, bundle);
    }

    public void zza(zza.zzb<LoadEventsResult> zzb, boolean z, String... strArr) throws RemoteException {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new EventsLoadedBinderCallback(zzb), z, strArr);
    }

    public void zza(zza.zzb<LoadQuestsResult> zzb, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new QuestsLoadedBinderCallbacks(zzb), iArr, i, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> zzb, String[] strArr) throws RemoteException {
        ((IGamesService) zzjb()).zzc(new PlayersLoadedBinderCallback(zzb), strArr);
    }

    public void zza(zze<OnInvitationReceivedListener> zze) {
        try {
            ((IGamesService) zzjb()).zza(new InvitationReceivedBinderCallback(zze), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zza(zze<RoomUpdateListener> zze, zze<RoomStatusUpdateListener> zze2, zze<RealTimeMessageReceivedListener> zze3, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzjb()).zza(new RoomBinderCallbacks(zze, zze2, zze3), this.zzadV, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zza(zze<RoomUpdateListener> zze, String str) {
        try {
            ((IGamesService) zzjb()).zzc(new RoomBinderCallbacks(zze), str);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        Contents zzkq = snapshotContents.zzkq();
        snapshotContents.close();
        try {
            ((IGamesService) zzjb()).zza(zzkq);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    protected IGamesService zzaW(IBinder iBinder) {
        return Stub.zzaZ(iBinder);
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzjb()).zzb(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return ((IGamesService) zzjb()).zzb(iArr);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public void zzb(zza.zzb<Status> zzb) throws RemoteException {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new SignOutCompleteBinderCallbacks(zzb));
    }

    public void zzb(zza.zzb<LoadPlayersResult> zzb, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new PlayersLoadedBinderCallback(zzb), i, z, z2);
    }

    public void zzb(zza.zzb<UpdateAchievementResult> zzb, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (zzb == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(zzb);
        }
        ((IGamesService) zzjb()).zzb(iGamesCallbacks, str, this.zzadT.zzoe(), this.zzadT.zzod());
    }

    public void zzb(zza.zzb<UpdateAchievementResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzjb()).zzb(zzb == null ? null : new AchievementUpdatedBinderCallback(zzb), str, i, this.zzadT.zzoe(), this.zzadT.zzod());
    }

    public void zzb(zza.zzb<LoadScoresResult> zzb, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new LeaderboardScoresLoadedBinderCallback(zzb), str, i, i2, i3, z);
    }

    public void zzb(zza.zzb<LoadExtendedGamesResult> zzb, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zza(new ExtendedGamesLoadedBinderCallback(zzb), str, i, z, z2);
    }

    public void zzb(zza.zzb<ClaimMilestoneResult> zzb, String str, String str2) throws RemoteException {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zzf(new QuestMilestoneClaimBinderCallbacks(zzb, str2), str, str2);
    }

    public void zzb(zza.zzb<LoadScoresResult> zzb, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new LeaderboardScoresLoadedBinderCallback(zzb), str, str2, i, i2, i3, z);
    }

    public void zzb(zza.zzb<LoadPlayersResult> zzb, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new PlayersLoadedBinderCallback(zzb), str, str2, i, z, z2);
    }

    public void zzb(zza.zzb<LoadAchievementsResult> zzb, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zza(new AchievementsLoadedBinderCallback(zzb), str, str2, z);
    }

    public void zzb(zza.zzb<LeaderboardMetadataResult> zzb, String str, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzc(new LeaderboardsLoadedBinderCallback(zzb), str, z);
    }

    public void zzb(zza.zzb<LeaderboardMetadataResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new LeaderboardsLoadedBinderCallback(zzb), z);
    }

    public void zzb(zza.zzb<LoadQuestsResult> zzb, boolean z, String[] strArr) throws RemoteException {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new QuestsLoadedBinderCallbacks(zzb), strArr, z);
    }

    public void zzb(zza.zzb<UpdateRequestsResult> zzb, String[] strArr) throws RemoteException {
        ((IGamesService) zzjb()).zza(new RequestsUpdatedBinderCallbacks(zzb), strArr);
    }

    public void zzb(zze<OnTurnBasedMatchUpdateReceivedListener> zze) {
        try {
            ((IGamesService) zzjb()).zzb(new MatchUpdateReceivedBinderCallback(zze), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzb(zze<RoomUpdateListener> zze, zze<RoomStatusUpdateListener> zze2, zze<RealTimeMessageReceivedListener> zze3, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzjb()).zza(new RoomBinderCallbacks(zze, zze2, zze3), this.zzadV, roomConfig.getInvitationId(), false, this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzbO(String str) {
        try {
            ((IGamesService) zzjb()).zzbW(str);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public Intent zzbP(String str) {
        try {
            return ((IGamesService) zzjb()).zzbP(str);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public void zzbQ(String str) {
        try {
            ((IGamesService) zzjb()).zza(str, this.zzadT.zzoe(), this.zzadT.zzod());
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzc(zza.zzb<LoadInvitationsResult> zzb, int i) throws RemoteException {
        ((IGamesService) zzjb()).zza(new InvitationsLoadedBinderCallback(zzb), i);
    }

    public void zzc(zza.zzb<LoadPlayersResult> zzb, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zzc(new PlayersLoadedBinderCallback(zzb), i, z, z2);
    }

    public void zzc(zza.zzb<InitiateMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(zzb), str);
    }

    public void zzc(zza.zzb<LoadXpStreamResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new PlayerXpStreamLoadedBinderCallback(zzb), str, i);
    }

    public void zzc(zza.zzb<LoadExtendedGamesResult> zzb, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zze(new ExtendedGamesLoadedBinderCallback(zzb), str, i, z, z2);
    }

    public void zzc(zza.zzb<InitiateMatchResult> zzb, String str, String str2) throws RemoteException {
        ((IGamesService) zzjb()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(zzb), str, str2);
    }

    public void zzc(zza.zzb<LoadSnapshotsResult> zzb, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzc(new SnapshotsLoadedBinderCallbacks(zzb), str, str2, z);
    }

    public void zzc(zza.zzb<LeaderboardMetadataResult> zzb, String str, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzd(new LeaderboardsLoadedBinderCallback(zzb), str, z);
    }

    public void zzc(zza.zzb<LoadAchievementsResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zza(new AchievementsLoadedBinderCallback(zzb), z);
    }

    public void zzc(zza.zzb<UpdateRequestsResult> zzb, String[] strArr) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new RequestsUpdatedBinderCallbacks(zzb), strArr);
    }

    public void zzc(zze<QuestUpdateListener> zze) {
        try {
            ((IGamesService) zzjb()).zzd(new QuestUpdateBinderCallback(zze), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    protected String zzcF() {
        return "com.google.android.gms.games.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return ((IGamesService) zzjb()).zzb(bArr, str, null);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void zzd(zza.zzb<LoadPlayersResult> zzb, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zze(new PlayersLoadedBinderCallback(zzb), i, z, z2);
    }

    public void zzd(zza.zzb<InitiateMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(zzb), str);
    }

    public void zzd(zza.zzb<LoadXpStreamResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzjb()).zzc(new PlayerXpStreamLoadedBinderCallback(zzb), str, i);
    }

    public void zzd(zza.zzb<LoadExtendedGamesResult> zzb, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zzf(new ExtendedGamesLoadedBinderCallback(zzb), str, i, z, z2);
    }

    public void zzd(zza.zzb<InitiateMatchResult> zzb, String str, String str2) throws RemoteException {
        ((IGamesService) zzjb()).zze(new TurnBasedMatchInitiatedBinderCallbacks(zzb), str, str2);
    }

    public void zzd(zza.zzb<GameMuteStatusChangeResult> zzb, String str, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zza(new GameMuteStatusChangedBinderCallback(zzb), str, z);
    }

    public void zzd(zza.zzb<LoadEventsResult> zzb, boolean z) throws RemoteException {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zzf(new EventsLoadedBinderCallback(zzb), z);
    }

    public void zzd(zze<OnRequestReceivedListener> zze) {
        try {
            ((IGamesService) zzjb()).zzc(new RequestReceivedBinderCallback(zze), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zze(zza.zzb<LeaveMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzo(new TurnBasedMatchLeftBinderCallbacks(zzb), str);
    }

    public void zze(zza.zzb<LoadInvitationsResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new InvitationsLoadedBinderCallback(zzb), str, i, false);
    }

    public void zze(zza.zzb<LoadExtendedGamesResult> zzb, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zzc(new ExtendedGamesLoadedBinderCallback(zzb), str, i, z, z2);
    }

    public void zze(zza.zzb<LoadSnapshotsResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzd(new SnapshotsLoadedBinderCallbacks(zzb), z);
    }

    public void zzeB(int i) {
        this.zzadT.setGravity(i);
    }

    public void zzeC(int i) {
        try {
            ((IGamesService) zzjb()).zzeC(i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    protected List<String> zzf(List<String> list) {
        int size = list.size();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < size) {
            int i3;
            boolean z2;
            String str = (String) list.get(i);
            if (str.equals(Scopes.GAMES)) {
                i3 = i2;
                z2 = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i3 = 1;
                z2 = z;
            } else {
                i3 = i2;
                z2 = z;
            }
            i++;
            z = z2;
            i2 = i3;
        }
        if (i2 != 0) {
            zzx.zza(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.zza(z, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return list;
    }

    public void zzf(zza.zzb<LoadGamesResult> zzb) throws RemoteException {
        ((IGamesService) zzjb()).zzd(new GamesLoadedBinderCallback(zzb));
    }

    public void zzf(zza.zzb<CancelMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzn(new TurnBasedMatchCanceledBinderCallbacks(zzb), str);
    }

    public void zzf(zza.zzb<LoadRequestSummariesResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzjb()).zza(new RequestSummariesLoadedBinderCallbacks(zzb), str, i);
    }

    public void zzf(zza.zzb<LoadPlayersResult> zzb, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzjb()).zzb(new PlayersLoadedBinderCallback(zzb), str, i, z, z2);
    }

    public void zzf(zza.zzb<LoadProfileSettingsResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzg(new ProfileSettingsLoadedBinderCallback(zzb), z);
    }

    public void zzg(zza.zzb<LoadOwnerCoverPhotoUrisResult> zzb) throws RemoteException {
        ((IGamesService) zzjb()).zzj(new OwnerCoverPhotoUrisLoadedBinderCallback(zzb));
    }

    public void zzg(zza.zzb<LoadMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzp(new TurnBasedMatchLoadedBinderCallbacks(zzb), str);
    }

    public void zzg(zza.zzb<Status> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zzh(new ProfileSettingsUpdatedBinderCallback(zzb), z);
    }

    public void zzh(zza.zzb<LoadAclResult> zzb) throws RemoteException {
        ((IGamesService) zzjb()).zzh(new NotifyAclLoadedBinderCallback(zzb));
    }

    public void zzh(zza.zzb<AcceptQuestResult> zzb, String str) throws RemoteException {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zzu(new QuestAcceptedBinderCallbacks(zzb), str);
    }

    public void zzh(zza.zzb<ContactSettingLoadResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzjb()).zze(new ContactSettingsLoadedBinderCallback(zzb), z);
    }

    public boolean zzhc() {
        return true;
    }

    public Bundle zzhp() {
        try {
            Bundle zzhp = ((IGamesService) zzjb()).zzhp();
            if (zzhp == null) {
                return zzhp;
            }
            zzhp.setClassLoader(GamesClientImpl.class.getClassLoader());
            return zzhp;
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    protected Bundle zzhq() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putString("com.google.android.gms.games.key.gamePackageName", this.zzadQ);
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzadX.zzacA);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzadX.zzacB);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzadX.zzacC);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzadX.zzacD);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzadX.zzacE);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzadX.zzacF);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzadX.zzacG);
        bundle.putString("com.google.android.gms.games.key.desiredLocale", locale);
        bundle.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzadT.zzoe()));
        zzf zzja = zzja();
        if (zzja.zziU() != null) {
            bundle.putBundle("com.google.android.gms.games.key.signInOptions", zzvc.zza(zzja.zziU(), zzja.zziV(), Executors.newSingleThreadExecutor()));
        }
        return bundle;
    }

    public void zzi(zza.zzb<InboxCountResult> zzb) throws RemoteException {
        ((IGamesService) zzjb()).zzt(new InboxCountsLoadedBinderCallback(zzb), null);
    }

    public void zzi(zza.zzb<DeleteSnapshotResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzr(new SnapshotDeletedBinderCallbacks(zzb), str);
    }

    public void zzj(zza.zzb<LoadExtendedGamesResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zze(new ExtendedGamesLoadedBinderCallback(zzb), str);
    }

    public void zzk(zza.zzb<LoadGameInstancesResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzf(new GameInstancesLoadedBinderCallback(zzb), str);
    }

    public void zzl(View view) {
        this.zzadT.zzm(view);
    }

    public void zzl(zza.zzb<LoadGameSearchSuggestionsResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzq(new GameSearchSuggestionsLoadedBinderCallback(zzb), str);
    }

    public void zzm(zza.zzb<LoadXpForGameCategoriesResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(zzb), str);
    }

    public void zzn(zza.zzb<LoadInvitationsResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzk(new InvitationsLoadedBinderCallback(zzb), str);
    }

    public void zznA() {
        try {
            ((IGamesService) zzjb()).zzx(this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public Intent zznB() {
        try {
            return ((IGamesService) zzjb()).zznB();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zznC() {
        try {
            return ((IGamesService) zzjb()).zznC();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public int zznD() {
        try {
            return ((IGamesService) zzjb()).zznD();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String zznE() {
        try {
            return ((IGamesService) zzjb()).zznE();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public int zznF() {
        try {
            return ((IGamesService) zzjb()).zznF();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent zznG() {
        try {
            return ((IGamesService) zzjb()).zznG();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public int zznH() {
        try {
            return ((IGamesService) zzjb()).zznH();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int zznI() {
        try {
            return ((IGamesService) zzjb()).zznI();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int zznJ() {
        try {
            return ((IGamesService) zzjb()).zznJ();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int zznK() {
        try {
            return ((IGamesService) zzjb()).zznK();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void zznL() {
        if (isConnected()) {
            try {
                ((IGamesService) zzjb()).zznL();
            } catch (RemoteException e) {
                GamesLog.zzr("GamesClientImpl", "service died");
            }
        }
    }

    public void zzno() {
        try {
            ((IGamesService) zzjb()).zza(new PopupLocationInfoBinderCallbacks(this.zzadT), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public String zznp() {
        try {
            return ((IGamesService) zzjb()).zznp();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public String zznq() {
        if (this.zzadR != null) {
            return this.zzadR.getPlayerId();
        }
        try {
            return ((IGamesService) zzjb()).zznq();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player zznr() {
        PlayerBuffer playerBuffer;
        zzfc();
        synchronized (this) {
            if (this.zzadR == null) {
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) zzjb()).zznN());
                    if (playerBuffer.getCount() > 0) {
                        this.zzadR = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.zzr("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.zzadR;
    }

    public Game zzns() {
        zzfc();
        synchronized (this) {
            if (this.zzadS == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((IGamesService) zzjb()).zznP());
                    if (gameBuffer.getCount() > 0) {
                        this.zzadS = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.zzr("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.zzadS;
    }

    public Intent zznt() {
        try {
            return ((IGamesService) zzjb()).zznt();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zznu() {
        try {
            return ((IGamesService) zzjb()).zznu();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zznv() {
        try {
            return ((IGamesService) zzjb()).zznv();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zznw() {
        try {
            return ((IGamesService) zzjb()).zznw();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public void zznx() {
        try {
            ((IGamesService) zzjb()).zzv(this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzny() {
        try {
            ((IGamesService) zzjb()).zzw(this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zznz() {
        try {
            ((IGamesService) zzjb()).zzy(this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public Intent zzo(String str, int i) {
        try {
            return ((IGamesService) zzjb()).zzv(str, i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public void zzo(zza.zzb<Status> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzj(new NotifyAclUpdatedBinderCallback(zzb), str);
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzaW(iBinder);
    }

    public void zzp(zza.zzb<GameMuteStatusLoadResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzjb()).zzi(new GameMuteStatusLoadedBinderCallback(zzb), str);
    }

    public void zzp(String str, int i) {
        this.zzadP.zzp(str, i);
    }

    public void zzq(String str, int i) {
        try {
            ((IGamesService) zzjb()).zzq(str, i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzr(String str, int i) {
        try {
            ((IGamesService) zzjb()).zzr(str, i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }
}
