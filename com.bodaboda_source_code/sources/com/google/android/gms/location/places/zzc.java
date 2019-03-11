package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class zzc implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    private final int zzFG;
    private final int zzalN;
    private final int zzanA;
    private final PlaceFilter zzanB;

    zzc(int i, int i2, int i3, PlaceFilter placeFilter) {
        this.zzFG = i;
        this.zzalN = i2;
        this.zzanA = i3;
        this.zzanB = placeFilter;
    }

    public int describeContents() {
        zzd zzd = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzc)) {
            return false;
        }
        zzc zzc = (zzc) object;
        return this.zzalN == zzc.zzalN && this.zzanA == zzc.zzanA && this.zzanB.equals(zzc.zzanB);
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzalN), Integer.valueOf(this.zzanA));
    }

    public String toString() {
        return zzw.zzk(this).zza("transitionTypes", Integer.valueOf(this.zzalN)).zza("loiteringTimeMillis", Integer.valueOf(this.zzanA)).zza("placeFilter", this.zzanB).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzd zzd = CREATOR;
        zzd.zza(this, parcel, flags);
    }

    public int zzpD() {
        return this.zzalN;
    }

    public int zzpG() {
        return this.zzanA;
    }

    public PlaceFilter zzpH() {
        return this.zzanB;
    }
}
