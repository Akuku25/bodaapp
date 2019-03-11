package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zze;

public class zzw implements SafeParcelable {
    public static final Creator<zzw> CREATOR = new zzx();
    public final int statusCode;
    public final int versionCode;
    public final zze[] zzaGj;

    zzw(int i, int i2, zze[] zzeArr) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaGj = zzeArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzx.zza(this, dest, flags);
    }
}
