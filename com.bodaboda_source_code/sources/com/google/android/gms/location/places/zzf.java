package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

public final class zzf implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    static final long zzanO = TimeUnit.HOURS.toMillis(1);
    private final int mPriority;
    final int zzFG;
    private final long zzalO;
    private final long zzamf;
    private final PlaceFilter zzanP;

    public zzf(int i, PlaceFilter placeFilter, long j, int i2, long j2) {
        this.zzFG = i;
        this.zzanP = placeFilter;
        this.zzamf = j;
        this.mPriority = i2;
        this.zzalO = j2;
    }

    public int describeContents() {
        zzg zzg = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzf)) {
            return false;
        }
        zzf zzf = (zzf) object;
        return zzw.equal(this.zzanP, zzf.zzanP) && this.zzamf == zzf.zzamf && this.mPriority == zzf.mPriority && this.zzalO == zzf.zzalO;
    }

    public long getExpirationTime() {
        return this.zzalO;
    }

    public long getInterval() {
        return this.zzamf;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanP, Long.valueOf(this.zzamf), Integer.valueOf(this.mPriority), Long.valueOf(this.zzalO));
    }

    public String toString() {
        return zzw.zzk(this).zza("filter", this.zzanP).zza("interval", Long.valueOf(this.zzamf)).zza("priority", Integer.valueOf(this.mPriority)).zza("expireAt", Long.valueOf(this.zzalO)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzg zzg = CREATOR;
        zzg.zza(this, parcel, flags);
    }

    public PlaceFilter zzpH() {
        return this.zzanP;
    }
}
