package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
    private final int zzFG;
    private final int zzJp;
    private final GameEntity zzahV;
    private final long zzajw;
    private final Bundle zzakA;
    private final byte[] zzakd;
    private final PlayerEntity zzakx;
    private final ArrayList<PlayerEntity> zzaky;
    private final long zzakz;
    private final int zzrX;
    private final String zzxv;

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses, int status) {
        this.zzFG = versionCode;
        this.zzahV = game;
        this.zzakx = sender;
        this.zzakd = data;
        this.zzxv = requestId;
        this.zzaky = recipients;
        this.zzJp = type;
        this.zzajw = creationTimestamp;
        this.zzakz = expirationTimestamp;
        this.zzakA = recipientStatuses;
        this.zzrX = status;
    }

    public GameRequestEntity(GameRequest request) {
        this.zzFG = 2;
        this.zzahV = new GameEntity(request.getGame());
        this.zzakx = new PlayerEntity(request.getSender());
        this.zzxv = request.getRequestId();
        this.zzJp = request.getType();
        this.zzajw = request.getCreationTimestamp();
        this.zzakz = request.getExpirationTimestamp();
        this.zzrX = request.getStatus();
        Object data = request.getData();
        if (data == null) {
            this.zzakd = null;
        } else {
            this.zzakd = new byte[data.length];
            System.arraycopy(data, 0, this.zzakd, 0, data.length);
        }
        List recipients = request.getRecipients();
        int size = recipients.size();
        this.zzaky = new ArrayList(size);
        this.zzakA = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.zzaky.add((PlayerEntity) player);
            this.zzakA.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzw.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzw.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzw.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzw.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzw.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzw.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzw.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzw.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzw.zzk(gameRequest).zza("Game", gameRequest.getGame()).zza("Sender", gameRequest.getSender()).zza("Recipients", gameRequest.getRecipients()).zza("Data", gameRequest.getData()).zza("RequestId", gameRequest.getRequestId()).zza("Type", Integer.valueOf(gameRequest.getType())).zza("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zza("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.zzajw;
    }

    public byte[] getData() {
        return this.zzakd;
    }

    public long getExpirationTimestamp() {
        return this.zzakz;
    }

    public Game getGame() {
        return this.zzahV;
    }

    public int getRecipientStatus(String playerId) {
        return this.zzakA.getInt(playerId, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.zzaky);
    }

    public String getRequestId() {
        return this.zzxv;
    }

    public Player getSender() {
        return this.zzakx;
    }

    public int getStatus() {
        return this.zzrX;
    }

    public int getType() {
        return this.zzJp;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.zza(this, dest, flags);
    }

    public Bundle zzpb() {
        return this.zzakA;
    }
}
