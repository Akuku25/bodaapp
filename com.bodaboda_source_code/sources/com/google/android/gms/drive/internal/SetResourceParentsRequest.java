package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
    public static final Creator<SetResourceParentsRequest> CREATOR = new zzbk();
    final int zzFG;
    final DriveId zzVe;
    final List<DriveId> zzVf;

    SetResourceParentsRequest(int versionCode, DriveId targetId, List<DriveId> parentIds) {
        this.zzFG = versionCode;
        this.zzVe = targetId;
        this.zzVf = parentIds;
    }

    public SetResourceParentsRequest(DriveId targetId, List<DriveId> parentIds) {
        this(1, targetId, parentIds);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbk.zza(this, dest, flags);
    }
}
