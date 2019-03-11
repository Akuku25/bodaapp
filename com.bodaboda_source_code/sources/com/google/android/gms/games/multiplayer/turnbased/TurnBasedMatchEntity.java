package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzlw;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
    private final int zzFG;
    private final int zzHe;
    private final String zzZO;
    private final long zzadi;
    private final String zzaeF;
    private final GameEntity zzahV;
    private final int zzajA;
    private final Bundle zzajQ;
    private final String zzajS;
    private final long zzajw;
    private final ArrayList<ParticipantEntity> zzajz;
    private final String zzaka;
    private final String zzakb;
    private final int zzakc;
    private final byte[] zzakd;
    private final String zzake;
    private final byte[] zzakf;
    private final int zzakg;
    private final int zzakh;
    private final boolean zzaki;
    private final String zzakj;

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList<ParticipantEntity> participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.zzFG = versionCode;
        this.zzahV = game;
        this.zzaeF = matchId;
        this.zzajS = creatorId;
        this.zzajw = creationTimestamp;
        this.zzaka = lastUpdaterId;
        this.zzadi = lastUpdatedTimestamp;
        this.zzakb = pendingParticipantId;
        this.zzakc = matchStatus;
        this.zzakh = turnStatus;
        this.zzajA = variant;
        this.zzHe = version;
        this.zzakd = data;
        this.zzajz = participants;
        this.zzake = rematchId;
        this.zzakf = previousData;
        this.zzakg = matchNumber;
        this.zzajQ = autoMatchCriteria;
        this.zzaki = isLocallyModified;
        this.zzZO = description;
        this.zzakj = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.zzFG = 2;
        this.zzahV = new GameEntity(match.getGame());
        this.zzaeF = match.getMatchId();
        this.zzajS = match.getCreatorId();
        this.zzajw = match.getCreationTimestamp();
        this.zzaka = match.getLastUpdaterId();
        this.zzadi = match.getLastUpdatedTimestamp();
        this.zzakb = match.getPendingParticipantId();
        this.zzakc = match.getStatus();
        this.zzakh = match.getTurnStatus();
        this.zzajA = match.getVariant();
        this.zzHe = match.getVersion();
        this.zzake = match.getRematchId();
        this.zzakg = match.getMatchNumber();
        this.zzajQ = match.getAutoMatchCriteria();
        this.zzaki = match.isLocallyModified();
        this.zzZO = match.getDescription();
        this.zzakj = match.getDescriptionParticipantId();
        Object data = match.getData();
        if (data == null) {
            this.zzakd = null;
        } else {
            this.zzakd = new byte[data.length];
            System.arraycopy(data, 0, this.zzakd, 0, data.length);
        }
        data = match.getPreviousMatchData();
        if (data == null) {
            this.zzakf = null;
        } else {
            this.zzakf = new byte[data.length];
            System.arraycopy(data, 0, this.zzakf, 0, data.length);
        }
        ArrayList participants = match.getParticipants();
        int size = participants.size();
        this.zzajz = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzajz.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int zza(TurnBasedMatch turnBasedMatch) {
        return zzw.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int zza(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean zza(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return zzw.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && zzw.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && zzw.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && zzw.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && zzw.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && zzw.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && zzw.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && zzw.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && zzw.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && zzw.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && zzw.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && zzw.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && zzw.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && zzw.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String zzb(TurnBasedMatch turnBasedMatch) {
        return zzw.zzk(turnBasedMatch).zza("Game", turnBasedMatch.getGame()).zza("MatchId", turnBasedMatch.getMatchId()).zza("CreatorId", turnBasedMatch.getCreatorId()).zza("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).zza("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).zza("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).zza("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).zza("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).zza("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).zza("Description", turnBasedMatch.getDescription()).zza("Variant", Integer.valueOf(turnBasedMatch.getVariant())).zza("Data", turnBasedMatch.getData()).zza("Version", Integer.valueOf(turnBasedMatch.getVersion())).zza("Participants", turnBasedMatch.getParticipants()).zza("RematchId", turnBasedMatch.getRematchId()).zza("PreviousData", turnBasedMatch.getPreviousMatchData()).zza("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).zza("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).zza("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).zza("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).zza("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String zzb(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant zzc(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList<String> zzc(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.zzakc == 2 && this.zzake == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzajQ;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzajQ == null ? 0 : this.zzajQ.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.zzajw;
    }

    public String getCreatorId() {
        return this.zzajS;
    }

    public byte[] getData() {
        return this.zzakd;
    }

    public String getDescription() {
        return this.zzZO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzlw.zzb(this.zzZO, dataOut);
    }

    public Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        return descriptionParticipantId == null ? null : getParticipant(descriptionParticipantId);
    }

    public String getDescriptionParticipantId() {
        return this.zzakj;
    }

    public Game getGame() {
        return this.zzahV;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzadi;
    }

    public String getLastUpdaterId() {
        return this.zzaka;
    }

    public String getMatchId() {
        return this.zzaeF;
    }

    public int getMatchNumber() {
        return this.zzakg;
    }

    public Participant getParticipant(String participantId) {
        return zzc(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return zzb(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return zzc(this);
    }

    public int getParticipantStatus(String participantId) {
        return zza((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzajz);
    }

    public String getPendingParticipantId() {
        return this.zzakb;
    }

    public byte[] getPreviousMatchData() {
        return this.zzakf;
    }

    public String getRematchId() {
        return this.zzake;
    }

    public int getStatus() {
        return this.zzakc;
    }

    public int getTurnStatus() {
        return this.zzakh;
    }

    public int getVariant() {
        return this.zzajA;
    }

    public int getVersion() {
        return this.zzHe;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isLocallyModified() {
        return this.zzaki;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.zza(this, out, flags);
    }
}
