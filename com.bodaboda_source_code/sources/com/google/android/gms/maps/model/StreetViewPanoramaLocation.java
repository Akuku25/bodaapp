package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final zzs CREATOR = new zzs();
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;
    private final int zzFG;

    StreetViewPanoramaLocation(int versionCode, StreetViewPanoramaLink[] links, LatLng position, String panoId) {
        this.zzFG = versionCode;
        this.links = links;
        this.position = position;
        this.panoId = panoId;
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] links, LatLng position, String panoId) {
        this(1, links, position, panoId);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) o;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.position, this.panoId);
    }

    public String toString() {
        return zzw.zzk(this).zza("panoId", this.panoId).zza("position", this.position.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzs.zza(this, out, flags);
    }
}
