package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse implements SafeParcelable {
    public static final Creator<OnStorageStatsResponse> CREATOR = new zzbb();
    final int zzFG;
    StorageStats zzVa;

    OnStorageStatsResponse(int versionCode, StorageStats storageStats) {
        this.zzFG = versionCode;
        this.zzVa = storageStats;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbb.zza(this, dest, flags);
    }
}
