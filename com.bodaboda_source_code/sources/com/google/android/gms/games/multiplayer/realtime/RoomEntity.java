package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzlw;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
    private final int zzFG;
    private final String zzZO;
    private final String zzaem;
    private final int zzajA;
    private final Bundle zzajQ;
    private final String zzajS;
    private final int zzajT;
    private final int zzajU;
    private final long zzajw;
    private final ArrayList<ParticipantEntity> zzajz;

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        RoomEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdh(x0);
        }

        public RoomEntity zzdh(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(zzh.zziX()) || zzh.zzbf(RoomEntity.class.getCanonicalName())) {
                return super.zzdh(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }
    }

    RoomEntity(int versionCode, String roomId, String creatorId, long creationTimestamp, int roomStatus, String description, int variant, Bundle autoMatchCriteria, ArrayList<ParticipantEntity> participants, int autoMatchWaitEstimateSeconds) {
        this.zzFG = versionCode;
        this.zzaem = roomId;
        this.zzajS = creatorId;
        this.zzajw = creationTimestamp;
        this.zzajT = roomStatus;
        this.zzZO = description;
        this.zzajA = variant;
        this.zzajQ = autoMatchCriteria;
        this.zzajz = participants;
        this.zzajU = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.zzFG = 2;
        this.zzaem = room.getRoomId();
        this.zzajS = room.getCreatorId();
        this.zzajw = room.getCreationTimestamp();
        this.zzajT = room.getStatus();
        this.zzZO = room.getDescription();
        this.zzajA = room.getVariant();
        this.zzajQ = room.getAutoMatchCriteria();
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        this.zzajz = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzajz.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
        this.zzajU = room.getAutoMatchWaitEstimateSeconds();
    }

    static int zza(Room room) {
        return zzw.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static int zza(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    static boolean zza(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return zzw.equal(room2.getRoomId(), room.getRoomId()) && zzw.equal(room2.getCreatorId(), room.getCreatorId()) && zzw.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && zzw.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && zzw.equal(room2.getDescription(), room.getDescription()) && zzw.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && zzw.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && zzw.equal(room2.getParticipants(), room.getParticipants()) && zzw.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static String zzb(Room room) {
        return zzw.zzk(room).zza("RoomId", room.getRoomId()).zza("CreatorId", room.getCreatorId()).zza("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).zza("RoomStatus", Integer.valueOf(room.getStatus())).zza("Description", room.getDescription()).zza("Variant", Integer.valueOf(room.getVariant())).zza("AutoMatchCriteria", room.getAutoMatchCriteria()).zza("Participants", room.getParticipants()).zza("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String zzb(Room room, String str) {
        ArrayList participants = room.getParticipants();
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

    static Participant zzc(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    static ArrayList<String> zzc(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzajQ;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.zzajU;
    }

    public long getCreationTimestamp() {
        return this.zzajw;
    }

    public String getCreatorId() {
        return this.zzajS;
    }

    public String getDescription() {
        return this.zzZO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzlw.zzb(this.zzZO, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return zzc(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return zzb(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return zzc((Room) this);
    }

    public int getParticipantStatus(String participantId) {
        return zza((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzajz);
    }

    public String getRoomId() {
        return this.zzaem;
    }

    public int getStatus() {
        return this.zzajT;
    }

    public int getVariant() {
        return this.zzajA;
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

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (zziY()) {
            dest.writeString(this.zzaem);
            dest.writeString(this.zzajS);
            dest.writeLong(this.zzajw);
            dest.writeInt(this.zzajT);
            dest.writeString(this.zzZO);
            dest.writeInt(this.zzajA);
            dest.writeBundle(this.zzajQ);
            int size = this.zzajz.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.zzajz.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        RoomEntityCreator.zza(this, dest, flags);
    }
}
