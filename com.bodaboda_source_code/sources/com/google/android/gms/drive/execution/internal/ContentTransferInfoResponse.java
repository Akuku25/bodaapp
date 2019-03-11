package com.google.android.gms.drive.execution.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ContentTransferInfoResponse implements SafeParcelable {
    public static final Creator<ContentTransferInfoResponse> CREATOR = new zza();
    final int zzFG;
    final int zzJp;
    final long zzTc;
    final long zzTd;
    final int zzrX;

    ContentTransferInfoResponse(int versionCode, int type, int status, long bytesTransferred, long totalBytes) {
        this.zzFG = versionCode;
        this.zzJp = type;
        this.zzrX = status;
        this.zzTc = bytesTransferred;
        this.zzTd = totalBytes;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
