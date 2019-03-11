package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class zzqa implements SafeParcelable, PlaceLikelihood {
    public static final Creator<zzqa> CREATOR = new zzqb();
    final int zzFG;
    final zzpy zzaoO;
    final float zzaoP;

    zzqa(int i, zzpy zzpy, float f) {
        this.zzFG = i;
        this.zzaoO = zzpy;
        this.zzaoP = f;
    }

    public static zzqa zza(zzpy zzpy, float f) {
        return new zzqa(0, (zzpy) zzx.zzl(zzpy), f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzqa)) {
            return false;
        }
        zzqa zzqa = (zzqa) object;
        return this.zzaoO.equals(zzqa.zzaoO) && this.zzaoP == zzqa.zzaoP;
    }

    public /* synthetic */ Object freeze() {
        return zzpX();
    }

    public float getLikelihood() {
        return this.zzaoP;
    }

    public Place getPlace() {
        return this.zzaoO;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaoO, Float.valueOf(this.zzaoP));
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzk(this).zza("place", this.zzaoO).zza("likelihood", Float.valueOf(this.zzaoP)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzqb.zza(this, parcel, flags);
    }

    public PlaceLikelihood zzpX() {
        return this;
    }
}
