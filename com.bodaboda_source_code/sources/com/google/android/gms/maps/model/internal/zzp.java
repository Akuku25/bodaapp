package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzp implements SafeParcelable {
    public static final zzq CREATOR = new zzq();
    private final int zzFG;
    private zza zzarR;

    public zzp() {
        this.zzFG = 1;
    }

    zzp(int i, zza zza) {
        this.zzFG = i;
        this.zzarR = zza;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzq.zza(this, out, flags);
    }

    public zza zzqO() {
        return this.zzarR;
    }
}
