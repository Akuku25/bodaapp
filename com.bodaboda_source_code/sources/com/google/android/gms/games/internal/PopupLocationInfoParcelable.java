package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.PopupManager.PopupLocationInfo;

public final class PopupLocationInfoParcelable implements SafeParcelable {
    public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
    private final int zzFG;
    private final Bundle zzafr;
    private final IBinder zzafs;

    PopupLocationInfoParcelable(int versionCode, Bundle infoBundle, IBinder windowToken) {
        this.zzFG = versionCode;
        this.zzafr = infoBundle;
        this.zzafs = windowToken;
    }

    public PopupLocationInfoParcelable(PopupLocationInfo popupLocationInfo) {
        this.zzFG = 1;
        this.zzafr = popupLocationInfo.zzob();
        this.zzafs = popupLocationInfo.zzafv;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public IBinder getWindowToken() {
        return this.zzafs;
    }

    public void writeToParcel(Parcel out, int flags) {
        PopupLocationInfoParcelableCreator.zza(this, out, flags);
    }

    public Bundle zzob() {
        return this.zzafr;
    }
}
