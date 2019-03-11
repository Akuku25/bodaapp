package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<CreateFileIntentSenderRequest> CREATOR = new zzj();
    final int zzFG;
    final int zzRV;
    final DriveId zzSA;
    final String zzSy;
    final MetadataBundle zzTp;
    final Integer zzTq;

    CreateFileIntentSenderRequest(int versionCode, MetadataBundle metadata, int requestId, String title, DriveId startFolder, Integer fileType) {
        this.zzFG = versionCode;
        this.zzTp = metadata;
        this.zzRV = requestId;
        this.zzSy = title;
        this.zzSA = startFolder;
        this.zzTq = fileType;
    }

    public CreateFileIntentSenderRequest(MetadataBundle metadata, int requestId, String title, DriveId startFolder, int fileType) {
        this(1, metadata, requestId, title, startFolder, Integer.valueOf(fileType));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
