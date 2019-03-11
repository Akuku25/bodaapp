package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zze implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final int zzFG;
    private zza zzarQ;

    public zze() {
        this.zzFG = 1;
    }

    zze(int i, zza zza) {
        this.zzFG = i;
        this.zzarQ = zza;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    public zza zzqM() {
        return this.zzarQ;
    }
}
