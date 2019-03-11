package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new zzk();
    final int zzFG;
    final String zzSq;
    final Contents zzTj;
    final MetadataBundle zzTp;
    final Integer zzTq;
    final DriveId zzTr;
    final boolean zzTs;
    final int zzTt;
    final int zzTu;

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference, Integer fileType, boolean sendEventOnCompletion, String trackingTag, int createStrategy, int openContentsRequestId) {
        if (!(contentsReference == null || openContentsRequestId == 0)) {
            zzx.zzb(contentsReference.getRequestId() == openContentsRequestId, (Object) "inconsistent contents reference");
        }
        if ((fileType == null || fileType.intValue() == 0) && contentsReference == null && openContentsRequestId == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.zzFG = versionCode;
        this.zzTr = (DriveId) zzx.zzl(parentDriveId);
        this.zzTp = (MetadataBundle) zzx.zzl(metadata);
        this.zzTj = contentsReference;
        this.zzTq = fileType;
        this.zzSq = trackingTag;
        this.zzTt = createStrategy;
        this.zzTs = sendEventOnCompletion;
        this.zzTu = openContentsRequestId;
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, int openContentsRequestId, int fileType, ExecutionOptions executionOptions) {
        this(2, parentDriveId, metadata, null, Integer.valueOf(fileType), executionOptions.zzku(), executionOptions.zzkt(), executionOptions.zzkv(), openContentsRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
