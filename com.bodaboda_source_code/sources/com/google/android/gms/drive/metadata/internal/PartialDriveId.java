package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class PartialDriveId implements SafeParcelable {
    public static final Creator<PartialDriveId> CREATOR = new zzl();
    final int zzFG;
    final String zzSh;
    final long zzSi;
    final int zzSj;

    PartialDriveId(int versionCode, String resourceId, long sqlId, int resourceType) {
        this.zzFG = versionCode;
        this.zzSh = resourceId;
        this.zzSi = sqlId;
        this.zzSj = resourceType;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzl.zza(this, out, flags);
    }

    public DriveId zzt(long j) {
        return new DriveId(this.zzSh, this.zzSi, j, this.zzSj);
    }
}
