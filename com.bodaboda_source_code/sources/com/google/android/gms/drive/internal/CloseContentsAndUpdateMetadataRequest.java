package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzf();
    final int zzFG;
    final String zzSq;
    final boolean zzSr;
    final DriveId zzTh;
    final MetadataBundle zzTi;
    final Contents zzTj;
    final int zzTk;

    CloseContentsAndUpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, boolean notifyOnCompletion, String trackingTag, int commitStrategy) {
        this.zzFG = versionCode;
        this.zzTh = id;
        this.zzTi = metadataChangeSet;
        this.zzTj = contentsReference;
        this.zzSr = notifyOnCompletion;
        this.zzSq = trackingTag;
        this.zzTk = commitStrategy;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, ExecutionOptions executionOptions) {
        this(1, id, metadataChangeSet, contentsReference, executionOptions.zzku(), executionOptions.zzkt(), executionOptions.zzkv());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
