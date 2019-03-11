package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Creator<OpenContentsRequest> CREATOR = new zzbd();
    final int zzFG;
    final int zzRW;
    final DriveId zzTh;
    final int zzVb;

    OpenContentsRequest(int versionCode, DriveId id, int mode, int baseRequestId) {
        this.zzFG = versionCode;
        this.zzTh = id;
        this.zzRW = mode;
        this.zzVb = baseRequestId;
    }

    public OpenContentsRequest(DriveId id, int mode, int baseRequestId) {
        this(1, id, mode, baseRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbd.zza(this, dest, flags);
    }
}
