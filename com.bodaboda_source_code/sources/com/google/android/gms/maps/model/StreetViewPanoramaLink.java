package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final zzr CREATOR = new zzr();
    public final float bearing;
    public final String panoId;
    private final int zzFG;

    StreetViewPanoramaLink(int versionCode, String panoId, float bearing) {
        this.zzFG = versionCode;
        this.panoId = panoId;
        if (((double) bearing) <= 0.0d) {
            bearing = (bearing % 360.0f) + 360.0f;
        }
        this.bearing = bearing % 360.0f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) o;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        return zzw.zzk(this).zza("panoId", this.panoId).zza("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzr.zza(this, out, flags);
    }
}
