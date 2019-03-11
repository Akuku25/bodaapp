package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private final int zzFG;
    private int zzJp;
    private String zzSy;
    private String zzZO;
    private Uri zzacc;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzda(x0);
        }

        public GameBadgeEntity zzda(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(zzh.zziX()) || zzh.zzbf(GameBadgeEntity.class.getCanonicalName())) {
                return super.zzda(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    GameBadgeEntity(int versionCode, int type, String title, String description, Uri iconImageUri) {
        this.zzFG = versionCode;
        this.zzJp = type;
        this.zzSy = title;
        this.zzZO = description;
        this.zzacc = iconImageUri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.zzFG = 1;
        this.zzJp = gameBadge.getType();
        this.zzSy = gameBadge.getTitle();
        this.zzZO = gameBadge.getDescription();
        this.zzacc = gameBadge.getIconImageUri();
    }

    static int zza(GameBadge gameBadge) {
        return zzw.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean zza(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return zzw.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && zzw.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String zzb(GameBadge gameBadge) {
        return zzw.zzk(gameBadge).zza("Type", Integer.valueOf(gameBadge.getType())).zza("Title", gameBadge.getTitle()).zza("Description", gameBadge.getDescription()).zza("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzot();
    }

    public String getDescription() {
        return this.zzZO;
    }

    public Uri getIconImageUri() {
        return this.zzacc;
    }

    public String getTitle() {
        return this.zzSy;
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

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (zziY()) {
            dest.writeInt(this.zzJp);
            dest.writeString(this.zzSy);
            dest.writeString(this.zzZO);
            dest.writeString(this.zzacc == null ? null : this.zzacc.toString());
            return;
        }
        GameBadgeEntityCreator.zza(this, dest, flags);
    }

    public GameBadge zzot() {
        return this;
    }
}
