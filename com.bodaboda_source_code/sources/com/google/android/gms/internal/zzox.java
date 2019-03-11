package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zzox implements SafeParcelable {
    public static final zzoy CREATOR = new zzoy();
    public final String packageName;
    public final int uid;
    private final int zzFG;

    zzox(int i, int i2, String str) {
        this.zzFG = i;
        this.uid = i2;
        this.packageName = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof zzox)) {
            return false;
        }
        zzox zzox = (zzox) o;
        return zzox.uid == this.uid && zzw.equal(zzox.packageName, this.packageName);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.uid), this.packageName});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzoy.zza(this, parcel, flags);
    }
}
