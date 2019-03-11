package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zzlw;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
    private final int zzFG;
    private final String zzSJ;
    private final String zzSy;
    private final String zzacH;
    private final long zzacI;
    private final int zzacJ;
    private final long zzacK;
    private final MostRecentGameInfoEntity zzacL;
    private final PlayerLevelInfo zzacM;
    private final boolean zzacN;
    private final boolean zzacO;
    private final Uri zzacc;
    private final Uri zzacd;
    private final String zzacn;
    private final String zzaco;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzcQ(x0);
        }

        public PlayerEntity zzcQ(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(zzh.zziX()) || zzh.zzbf(PlayerEntity.class.getCanonicalName())) {
                return super.zzcQ(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(12, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null, null, null, null, true, false);
        }
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl, String title, MostRecentGameInfoEntity mostRecentGameInfo, PlayerLevelInfo playerLevelInfo, boolean isProfileVisible, boolean hasDebugAccess) {
        this.zzFG = versionCode;
        this.zzacH = playerId;
        this.zzSJ = displayName;
        this.zzacc = iconImageUri;
        this.zzacn = iconImageUrl;
        this.zzacd = hiResImageUri;
        this.zzaco = hiResImageUrl;
        this.zzacI = retrievedTimestamp;
        this.zzacJ = isInCircles;
        this.zzacK = lastPlayedWithTimestamp;
        this.zzSy = title;
        this.zzacN = isProfileVisible;
        this.zzacL = mostRecentGameInfo;
        this.zzacM = playerLevelInfo;
        this.zzacO = hasDebugAccess;
    }

    public PlayerEntity(Player player) {
        this.zzFG = 12;
        this.zzacH = player.getPlayerId();
        this.zzSJ = player.getDisplayName();
        this.zzacc = player.getIconImageUri();
        this.zzacn = player.getIconImageUrl();
        this.zzacd = player.getHiResImageUri();
        this.zzaco = player.getHiResImageUrl();
        this.zzacI = player.getRetrievedTimestamp();
        this.zzacJ = player.zzmE();
        this.zzacK = player.getLastPlayedWithTimestamp();
        this.zzSy = player.getTitle();
        this.zzacN = player.isProfileVisible();
        MostRecentGameInfo zzmF = player.zzmF();
        this.zzacL = zzmF == null ? null : new MostRecentGameInfoEntity(zzmF);
        this.zzacM = player.getLevelInfo();
        this.zzacO = player.zzmD();
        zzb.zzh(this.zzacH);
        zzb.zzh(this.zzSJ);
        zzb.zzN(this.zzacI > 0);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzw.equal(player2.getPlayerId(), player.getPlayerId()) && zzw.equal(player2.getDisplayName(), player.getDisplayName()) && zzw.equal(Boolean.valueOf(player2.zzmD()), Boolean.valueOf(player.zzmD())) && zzw.equal(player2.getIconImageUri(), player.getIconImageUri()) && zzw.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && zzw.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && zzw.equal(player2.getTitle(), player.getTitle()) && zzw.equal(player2.getLevelInfo(), player.getLevelInfo());
    }

    static int zzb(Player player) {
        return zzw.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzmD()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo());
    }

    static String zzc(Player player) {
        return zzw.zzk(player).zza("PlayerId", player.getPlayerId()).zza("DisplayName", player.getDisplayName()).zza("HasDebugAccess", Boolean.valueOf(player.zzmD())).zza("IconImageUri", player.getIconImageUri()).zza("IconImageUrl", player.getIconImageUrl()).zza("HiResImageUri", player.getHiResImageUri()).zza("HiResImageUrl", player.getHiResImageUrl()).zza("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zza("Title", player.getTitle()).zza("LevelInfo", player.getLevelInfo()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.zzSJ;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzlw.zzb(this.zzSJ, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.zzacd;
    }

    public String getHiResImageUrl() {
        return this.zzaco;
    }

    public Uri getIconImageUri() {
        return this.zzacc;
    }

    public String getIconImageUrl() {
        return this.zzacn;
    }

    public long getLastPlayedWithTimestamp() {
        return this.zzacK;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzacM;
    }

    public String getPlayerId() {
        return this.zzacH;
    }

    public long getRetrievedTimestamp() {
        return this.zzacI;
    }

    public String getTitle() {
        return this.zzSy;
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zzlw.zzb(this.zzSy, dataOut);
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isProfileVisible() {
        return this.zzacN;
    }

    public String toString() {
        return zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (zziY()) {
            dest.writeString(this.zzacH);
            dest.writeString(this.zzSJ);
            dest.writeString(this.zzacc == null ? null : this.zzacc.toString());
            if (this.zzacd != null) {
                str = this.zzacd.toString();
            }
            dest.writeString(str);
            dest.writeLong(this.zzacI);
            return;
        }
        PlayerEntityCreator.zza(this, dest, flags);
    }

    public boolean zzmD() {
        return this.zzacO;
    }

    public int zzmE() {
        return this.zzacJ;
    }

    public MostRecentGameInfo zzmF() {
        return this.zzacL;
    }
}
