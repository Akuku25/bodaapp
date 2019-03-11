package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zzqu extends zzqt implements SafeParcelable {
    public static final zzqv CREATOR = new zzqv();
    final int zzFG;
    private final String zzapn;

    zzqu(int i, String str) {
        this.zzFG = i;
        this.zzapn = str;
    }

    public int describeContents() {
        zzqv zzqv = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzqu)) {
            return false;
        }
        return this.zzapn.equals(((zzqu) object).zzapn);
    }

    public int hashCode() {
        return this.zzapn.hashCode();
    }

    public String toString() {
        return zzw.zzk(this).zza("testName", this.zzapn).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzqv zzqv = CREATOR;
        zzqv.zza(this, parcel, flags);
    }

    public String zzqd() {
        return this.zzapn;
    }
}
