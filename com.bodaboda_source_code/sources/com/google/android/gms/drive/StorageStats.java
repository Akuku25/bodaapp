package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats implements SafeParcelable {
    public static final Creator<StorageStats> CREATOR = new zzi();
    final int zzFG;
    final long zzSD;
    final long zzSE;
    final long zzSF;
    final long zzSG;
    final int zzSH;

    StorageStats(int versionCode, long metadataSizeBytes, long cachedContentsSizeBytes, long pinnedItemsSizeBytes, long totalSizeBytes, int numPinnedItems) {
        this.zzFG = versionCode;
        this.zzSD = metadataSizeBytes;
        this.zzSE = cachedContentsSizeBytes;
        this.zzSF = pinnedItemsSizeBytes;
        this.zzSG = totalSizeBytes;
        this.zzSH = numPinnedItems;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi.zza(this, out, flags);
    }
}
