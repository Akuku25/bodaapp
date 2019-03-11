package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
    private final int zzFG;
    private final long zzacS;
    private final long zzacT;
    private final PlayerLevel zzacU;
    private final PlayerLevel zzacV;

    PlayerLevelInfo(int versionCode, long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        zzx.zzN(currentXpTotal != -1);
        zzx.zzl(currentLevel);
        zzx.zzl(nextLevel);
        this.zzFG = versionCode;
        this.zzacS = currentXpTotal;
        this.zzacT = lastLevelUpTimestamp;
        this.zzacU = currentLevel;
        this.zzacV = nextLevel;
    }

    public PlayerLevelInfo(long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        this(1, currentXpTotal, lastLevelUpTimestamp, currentLevel, nextLevel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzw.equal(Long.valueOf(this.zzacS), Long.valueOf(playerLevelInfo.zzacS)) && zzw.equal(Long.valueOf(this.zzacT), Long.valueOf(playerLevelInfo.zzacT)) && zzw.equal(this.zzacU, playerLevelInfo.zzacU) && zzw.equal(this.zzacV, playerLevelInfo.zzacV);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzacU;
    }

    public long getCurrentXpTotal() {
        return this.zzacS;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzacT;
    }

    public PlayerLevel getNextLevel() {
        return this.zzacV;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzacS), Long.valueOf(this.zzacT), this.zzacU, this.zzacV);
    }

    public boolean isMaxLevel() {
        return this.zzacU.equals(this.zzacV);
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelInfoCreator.zza(this, out, flags);
    }
}
