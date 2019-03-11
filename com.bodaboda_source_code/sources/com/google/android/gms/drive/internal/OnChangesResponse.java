package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class OnChangesResponse implements SafeParcelable {
    public static final Creator<OnChangesResponse> CREATOR = new zzao();
    final int zzFG;
    final DataHolder zzUL;
    final List<DriveId> zzUM;
    final ChangeSequenceNumber zzUN;
    final boolean zzUO;

    OnChangesResponse(int versionCode, DataHolder newOrModifiedResourcesData, List<DriveId> deleted, ChangeSequenceNumber lastChangeSequenceNumber, boolean moreChangesExist) {
        this.zzFG = versionCode;
        this.zzUL = newOrModifiedResourcesData;
        this.zzUM = deleted;
        this.zzUN = lastChangeSequenceNumber;
        this.zzUO = moreChangesExist;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzao.zza(this, dest, flags | 1);
    }
}
