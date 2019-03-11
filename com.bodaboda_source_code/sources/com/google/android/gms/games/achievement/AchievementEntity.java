package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlw;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final AchievementEntityCreator CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int zzFG;
    private final int zzJp;
    private final String zzZO;
    private final String zzacY;
    private final Uri zzacZ;
    private final String zzada;
    private final Uri zzadb;
    private final String zzadc;
    private final int zzadd;
    private final String zzade;
    private final PlayerEntity zzadf;
    private final int zzadg;
    private final String zzadh;
    private final long zzadi;
    private final long zzadj;

    AchievementEntity(int versionCode, String achievementId, int type, String name, String description, Uri unlockedImageUri, String unlockedImageUrl, Uri revealedImageUri, String revealedImageUrl, int totalSteps, String formattedTotalSteps, PlayerEntity player, int state, int currentSteps, String formattedCurrentSteps, long lastUpdatedTimestamp, long xpValue) {
        this.zzFG = versionCode;
        this.zzacY = achievementId;
        this.zzJp = type;
        this.mName = name;
        this.zzZO = description;
        this.zzacZ = unlockedImageUri;
        this.zzada = unlockedImageUrl;
        this.zzadb = revealedImageUri;
        this.zzadc = revealedImageUrl;
        this.zzadd = totalSteps;
        this.zzade = formattedTotalSteps;
        this.zzadf = player;
        this.mState = state;
        this.zzadg = currentSteps;
        this.zzadh = formattedCurrentSteps;
        this.zzadi = lastUpdatedTimestamp;
        this.zzadj = xpValue;
    }

    public AchievementEntity(Achievement achievement) {
        this.zzFG = 1;
        this.zzacY = achievement.getAchievementId();
        this.zzJp = achievement.getType();
        this.mName = achievement.getName();
        this.zzZO = achievement.getDescription();
        this.zzacZ = achievement.getUnlockedImageUri();
        this.zzada = achievement.getUnlockedImageUrl();
        this.zzadb = achievement.getRevealedImageUri();
        this.zzadc = achievement.getRevealedImageUrl();
        this.zzadf = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzadi = achievement.getLastUpdatedTimestamp();
        this.zzadj = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzadd = achievement.getTotalSteps();
            this.zzade = achievement.getFormattedTotalSteps();
            this.zzadg = achievement.getCurrentSteps();
            this.zzadh = achievement.getFormattedCurrentSteps();
        } else {
            this.zzadd = 0;
            this.zzade = null;
            this.zzadg = 0;
            this.zzadh = null;
        }
        zzb.zzh(this.zzacY);
        zzb.zzh(this.zzZO);
    }

    static int zza(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return zzw.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean zza(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        boolean equal;
        boolean equal2;
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            equal = zzw.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            equal2 = zzw.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            equal2 = true;
            equal = true;
        }
        return zzw.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzw.equal(achievement2.getName(), achievement.getName()) && zzw.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzw.equal(achievement2.getDescription(), achievement.getDescription()) && zzw.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzw.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzw.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzw.equal(achievement2.getPlayer(), achievement.getPlayer()) && equal && equal2;
    }

    static String zzb(Achievement achievement) {
        zza zza = zzw.zzk(achievement).zza("Id", achievement.getAchievementId()).zza("Type", Integer.valueOf(achievement.getType())).zza("Name", achievement.getName()).zza("Description", achievement.getDescription()).zza("Player", achievement.getPlayer()).zza("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zza.zza("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zza.zza("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zza.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.zzacY;
    }

    public int getCurrentSteps() {
        return this.zzadg;
    }

    public String getDescription() {
        return this.zzZO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzlw.zzb(this.zzZO, dataOut);
    }

    public String getFormattedCurrentSteps() {
        return this.zzadh;
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        zzlw.zzb(this.zzadh, dataOut);
    }

    public String getFormattedTotalSteps() {
        return this.zzade;
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        zzlw.zzb(this.zzade, dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return this.zzadi;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zzlw.zzb(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.zzadf;
    }

    public Uri getRevealedImageUri() {
        return this.zzadb;
    }

    public String getRevealedImageUrl() {
        return this.zzadc;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        return this.zzadd;
    }

    public int getType() {
        return this.zzJp;
    }

    public Uri getUnlockedImageUri() {
        return this.zzacZ;
    }

    public String getUnlockedImageUrl() {
        return this.zzada;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public long getXpValue() {
        return this.zzadj;
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
        AchievementEntityCreator.zza(this, dest, flags);
    }
}
