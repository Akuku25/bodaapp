package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Creator<ValuesRemovedDetails> CREATOR = new zzj();
    final int mIndex;
    final int zzFG;
    final String zzXF;
    final int zzXG;
    final int zzXf;
    final int zzXg;

    ValuesRemovedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedToId, int movedToIndex) {
        this.zzFG = versionCode;
        this.mIndex = index;
        this.zzXf = valueIndex;
        this.zzXg = valueCount;
        this.zzXF = movedToId;
        this.zzXG = movedToIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
