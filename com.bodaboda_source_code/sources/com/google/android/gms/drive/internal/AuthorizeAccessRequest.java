package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR = new zzb();
    final int zzFG;
    final DriveId zzRX;
    final long zzTf;

    AuthorizeAccessRequest(int versionCode, long appId, DriveId driveId) {
        this.zzFG = versionCode;
        this.zzTf = appId;
        this.zzRX = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
