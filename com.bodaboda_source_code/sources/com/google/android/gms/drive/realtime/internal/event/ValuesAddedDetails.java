package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Creator<ValuesAddedDetails> CREATOR = new zzi();
    final int mIndex;
    final int zzFG;
    final String zzXD;
    final int zzXE;
    final int zzXf;
    final int zzXg;

    ValuesAddedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedFromId, int movedFromIndex) {
        this.zzFG = versionCode;
        this.mIndex = index;
        this.zzXf = valueIndex;
        this.zzXg = valueCount;
        this.zzXD = movedFromId;
        this.zzXE = movedFromIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
