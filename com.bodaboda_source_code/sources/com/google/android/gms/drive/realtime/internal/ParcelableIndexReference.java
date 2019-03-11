package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Creator<ParcelableIndexReference> CREATOR = new zzq();
    final int mIndex;
    final int zzFG;
    final String zzXc;
    final boolean zzXd;

    ParcelableIndexReference(int versionCode, String objectId, int index, boolean canBeDeleted) {
        this.zzFG = versionCode;
        this.zzXc = objectId;
        this.mIndex = index;
        this.zzXd = canBeDeleted;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }
}
