package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Creator<UserMetadata> CREATOR = new zzj();
    final int zzFG;
    final String zzSI;
    final String zzSJ;
    final String zzSK;
    final boolean zzSL;
    final String zzSM;

    UserMetadata(int versionCode, String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this.zzFG = versionCode;
        this.zzSI = permissionId;
        this.zzSJ = displayName;
        this.zzSK = pictureUrl;
        this.zzSL = isAuthenticatedUser;
        this.zzSM = emailAddress;
    }

    public UserMetadata(String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this(1, permissionId, displayName, pictureUrl, isAuthenticatedUser, emailAddress);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.zzSI, this.zzSJ, this.zzSK, Boolean.valueOf(this.zzSL), this.zzSM});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
