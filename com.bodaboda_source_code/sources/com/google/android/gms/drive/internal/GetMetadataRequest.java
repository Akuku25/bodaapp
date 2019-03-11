package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest implements SafeParcelable {
    public static final Creator<GetMetadataRequest> CREATOR = new zzaf();
    final int zzFG;
    final DriveId zzTh;
    final boolean zzUB;

    GetMetadataRequest(int versionCode, DriveId id, boolean forceFromServer) {
        this.zzFG = versionCode;
        this.zzTh = id;
        this.zzUB = forceFromServer;
    }

    public GetMetadataRequest(DriveId id, boolean forceFromServer) {
        this(1, id, forceFromServer);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaf.zza(this, dest, flags);
    }
}
