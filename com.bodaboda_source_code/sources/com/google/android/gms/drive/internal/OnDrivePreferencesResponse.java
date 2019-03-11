package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class OnDrivePreferencesResponse implements SafeParcelable {
    public static final Creator<OnDrivePreferencesResponse> CREATOR = new zzat();
    final int zzFG;
    DrivePreferences zzUT;

    OnDrivePreferencesResponse(int versionCode, DrivePreferences prefs) {
        this.zzFG = versionCode;
        this.zzUT = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzat.zza(this, dest, flags);
    }
}
