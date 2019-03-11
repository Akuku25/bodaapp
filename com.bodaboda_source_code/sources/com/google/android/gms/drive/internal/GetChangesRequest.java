package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetChangesRequest implements SafeParcelable {
    public static final Creator<GetChangesRequest> CREATOR = new zzad();
    final int zzFG;
    final ChangeSequenceNumber zzUv;
    final int zzUw;
    final List<DriveSpace> zzUx;
    private final Set<DriveSpace> zzUy;

    GetChangesRequest(int versionCode, ChangeSequenceNumber fromSequenceNumber, int maxResults, List<DriveSpace> spacesList) {
        this(versionCode, fromSequenceNumber, maxResults, spacesList, spacesList == null ? null : new HashSet(spacesList));
    }

    private GetChangesRequest(int versionCode, ChangeSequenceNumber fromSequenceNumber, int maxResults, List<DriveSpace> spacesList, Set<DriveSpace> spaces) {
        this.zzFG = versionCode;
        this.zzUv = fromSequenceNumber;
        this.zzUw = maxResults;
        this.zzUx = spacesList;
        this.zzUy = spaces;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzad.zza(this, dest, flags);
    }
}
