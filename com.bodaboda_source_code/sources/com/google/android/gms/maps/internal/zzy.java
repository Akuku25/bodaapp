package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzy implements SafeParcelable {
    public static final zzz CREATOR = new zzz();
    private final int versionCode;
    private final Point zzaqO;

    public zzy(int i, Point point) {
        this.versionCode = i;
        this.zzaqO = point;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zzy)) {
            return false;
        }
        return this.zzaqO.equals(((zzy) o).zzaqO);
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.zzaqO.hashCode();
    }

    public String toString() {
        return this.zzaqO.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzz.zza(this, out, flags);
    }

    public Point zzqE() {
        return this.zzaqO;
    }
}
