package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new zzae();
    final int zzFG;
    final boolean zzUA;
    final String zzUz;

    GetDriveIdFromUniqueIdentifierRequest(int versionCode, String uniqueIdentifier, boolean isInAppFolder) {
        this.zzFG = versionCode;
        this.zzUz = uniqueIdentifier;
        this.zzUA = isInAppFolder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzae.zza(this, dest, flags);
    }
}
