package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Creator<ReferenceShiftedDetails> CREATOR = new zze();
    final int zzFG;
    final int zzXA;
    final int zzXB;
    final String zzXy;
    final String zzXz;

    ReferenceShiftedDetails(int versionCode, String oldObjectId, String newObjectId, int oldIndex, int newIndex) {
        this.zzFG = versionCode;
        this.zzXy = oldObjectId;
        this.zzXz = newObjectId;
        this.zzXA = oldIndex;
        this.zzXB = newIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
