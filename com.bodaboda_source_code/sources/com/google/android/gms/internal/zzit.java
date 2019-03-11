package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzit implements SafeParcelable {
    public static final zziu CREATOR = new zziu();
    public final int id;
    final int zzFG;
    final Bundle zzFX;

    zzit(int i, int i2, Bundle bundle) {
        this.zzFG = i;
        this.id = i2;
        this.zzFX = bundle;
    }

    public int describeContents() {
        zziu zziu = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zziu zziu = CREATOR;
        zziu.zza(this, dest, flags);
    }
}
