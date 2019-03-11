package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;

public class CreateContentsRequest implements SafeParcelable {
    public static final Creator<CreateContentsRequest> CREATOR = new zzh();
    final int zzFG;
    final int zzRW;

    public CreateContentsRequest(int mode) {
        this(1, mode);
    }

    CreateContentsRequest(int versionCode, int mode) {
        this.zzFG = versionCode;
        boolean z = mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE;
        zzx.zzb(z, (Object) "Cannot create a new read-only contents!");
        this.zzRW = mode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
