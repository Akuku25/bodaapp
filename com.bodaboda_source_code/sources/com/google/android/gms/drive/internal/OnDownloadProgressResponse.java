package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR = new zzar();
    final int zzFG;
    final long zzUR;
    final long zzUS;

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected) {
        this.zzFG = versionCode;
        this.zzUR = bytesLoaded;
        this.zzUS = bytesExpected;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzar.zza(this, dest, flags);
    }

    public long zzkO() {
        return this.zzUR;
    }

    public long zzkP() {
        return this.zzUS;
    }
}
