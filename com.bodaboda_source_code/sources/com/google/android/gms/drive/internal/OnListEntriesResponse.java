package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzk;

public class OnListEntriesResponse extends zzk implements SafeParcelable {
    public static final Creator<OnListEntriesResponse> CREATOR = new zzaw();
    final int zzFG;
    final boolean zzTB;
    final DataHolder zzUY;

    OnListEntriesResponse(int versionCode, DataHolder entries, boolean moreEntriesMayExist) {
        this.zzFG = versionCode;
        this.zzUY = entries;
        this.zzTB = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    protected void zzI(Parcel parcel, int i) {
        zzaw.zza(this, parcel, i);
    }

    public DataHolder zzkR() {
        return this.zzUY;
    }

    public boolean zzkS() {
        return this.zzTB;
    }
}
