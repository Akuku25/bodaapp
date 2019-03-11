package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int zzFG;
    private final String zzadA;
    private final Bundle zzadB;
    private final String zzady;
    private final String zzadz;

    AppContentConditionEntity(int versionCode, String defaultValue, String expectedValue, String predicate, Bundle predicateParameters) {
        this.zzFG = versionCode;
        this.zzady = defaultValue;
        this.zzadz = expectedValue;
        this.zzadA = predicate;
        this.zzadB = predicateParameters;
    }

    public AppContentConditionEntity(AppContentCondition condition) {
        this.zzFG = 1;
        this.zzady = condition.zzmY();
        this.zzadz = condition.zzmZ();
        this.zzadA = condition.zzna();
        this.zzadB = condition.zznb();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzw.hashCode(appContentCondition.zzmY(), appContentCondition.zzmZ(), appContentCondition.zzna(), appContentCondition.zznb());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzw.equal(appContentCondition2.zzmY(), appContentCondition.zzmY()) && zzw.equal(appContentCondition2.zzmZ(), appContentCondition.zzmZ()) && zzw.equal(appContentCondition2.zzna(), appContentCondition.zzna()) && zzw.equal(appContentCondition2.zznb(), appContentCondition.zznb());
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzw.zzk(appContentCondition).zza("DefaultValue", appContentCondition.zzmY()).zza("ExpectedValue", appContentCondition.zzmZ()).zza("Predicate", appContentCondition.zzna()).zza("PredicateParameters", appContentCondition.zznb()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zznc();
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

    public void writeToParcel(Parcel out, int flags) {
        AppContentConditionEntityCreator.zza(this, out, flags);
    }

    public String zzmY() {
        return this.zzady;
    }

    public String zzmZ() {
        return this.zzadz;
    }

    public String zzna() {
        return this.zzadA;
    }

    public Bundle zznb() {
        return this.zzadB;
    }

    public AppContentCondition zznc() {
        return this;
    }
}
