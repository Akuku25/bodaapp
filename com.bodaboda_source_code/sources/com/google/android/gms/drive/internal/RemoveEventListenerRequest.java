package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Creator<RemoveEventListenerRequest> CREATOR = new zzbh();
    final int zzFG;
    final DriveId zzRX;
    final int zzTe;

    RemoveEventListenerRequest(int versionCode, DriveId driveId, int eventType) {
        this.zzFG = versionCode;
        this.zzRX = driveId;
        this.zzTe = eventType;
    }

    public RemoveEventListenerRequest(DriveId id, int eventType) {
        this(1, id, eventType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbh.zza(this, dest, flags);
    }
}
