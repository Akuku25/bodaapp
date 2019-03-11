package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Creator<OnSyncMoreResponse> CREATOR = new zzbc();
    final int zzFG;
    final boolean zzTB;

    OnSyncMoreResponse(int versionCode, boolean moreEntriesMayExist) {
        this.zzFG = versionCode;
        this.zzTB = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbc.zza(this, dest, flags);
    }
}
