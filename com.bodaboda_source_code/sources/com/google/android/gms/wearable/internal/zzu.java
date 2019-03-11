package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zze;

@Deprecated
public class zzu implements SafeParcelable {
    public static final Creator<zzu> CREATOR = new zzv();
    public final int statusCode;
    public final int versionCode;
    public final zze zzaGi;

    zzu(int i, int i2, zze zze) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaGi = zze;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzv.zza(this, dest, flags);
    }
}
