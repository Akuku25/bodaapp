package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.zzaa;

public final class LatLngBounds implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    public final LatLng northeast;
    public final LatLng southwest;
    private final int zzFG;

    public static final class Builder {
        private double zzaro = Double.POSITIVE_INFINITY;
        private double zzarp = Double.NEGATIVE_INFINITY;
        private double zzarq = Double.NaN;
        private double zzarr = Double.NaN;

        private boolean zzd(double d) {
            boolean z = false;
            if (this.zzarq <= this.zzarr) {
                return this.zzarq <= d && d <= this.zzarr;
            } else {
                if (this.zzarq <= d || d <= this.zzarr) {
                    z = true;
                }
                return z;
            }
        }

        public LatLngBounds build() {
            zzx.zza(!Double.isNaN(this.zzarq), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.zzaro, this.zzarq), new LatLng(this.zzarp, this.zzarr));
        }

        public Builder include(LatLng point) {
            this.zzaro = Math.min(this.zzaro, point.latitude);
            this.zzarp = Math.max(this.zzarp, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.zzarq)) {
                this.zzarq = d;
                this.zzarr = d;
            } else if (!zzd(d)) {
                if (LatLngBounds.zzb(this.zzarq, d) < LatLngBounds.zzc(this.zzarr, d)) {
                    this.zzarq = d;
                } else {
                    this.zzarr = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest, LatLng northeast) {
        zzx.zzb((Object) southwest, (Object) "null southwest");
        zzx.zzb((Object) northeast, (Object) "null northeast");
        zzx.zzb(northeast.latitude >= southwest.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest.latitude), Double.valueOf(northeast.latitude));
        this.zzFG = versionCode;
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this(1, southwest, northeast);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double zzb(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double zzc(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean zzc(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean zzd(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        } else {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
    }

    public boolean contains(LatLng point) {
        return zzc(point.latitude) && zzd(point.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = point.longitude;
        if (zzd(d3)) {
            d3 = d2;
            d2 = d;
        } else if (zzb(d2, d3) < zzc(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public String toString() {
        return zzw.zzk(this).zza("southwest", this.southwest).zza("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (zzaa.zzqF()) {
            zzh.zza(this, out, flags);
        } else {
            zzg.zza(this, out, flags);
        }
    }
}
