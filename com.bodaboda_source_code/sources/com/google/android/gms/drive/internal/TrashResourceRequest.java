package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest implements SafeParcelable {
    public static final Creator<TrashResourceRequest> CREATOR = new zzbm();
    final int zzFG;
    final DriveId zzTh;

    TrashResourceRequest(int versionCode, DriveId id) {
        this.zzFG = versionCode;
        this.zzTh = id;
    }

    public TrashResourceRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbm.zza(this, dest, flags);
    }
}
