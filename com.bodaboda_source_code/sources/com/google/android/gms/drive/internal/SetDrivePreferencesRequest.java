package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class SetDrivePreferencesRequest implements SafeParcelable {
    public static final Creator<SetDrivePreferencesRequest> CREATOR = new zzbi();
    final int zzFG;
    final DrivePreferences zzUT;

    SetDrivePreferencesRequest(int versionCode, DrivePreferences prefs) {
        this.zzFG = versionCode;
        this.zzUT = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbi.zza(this, dest, flags);
    }
}
