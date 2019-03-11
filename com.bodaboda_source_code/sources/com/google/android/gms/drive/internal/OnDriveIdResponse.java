package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR = new zzas();
    final int zzFG;
    DriveId zzTh;

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.zzFG = versionCode;
        this.zzTh = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzTh;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzas.zza(this, dest, flags);
    }
}
