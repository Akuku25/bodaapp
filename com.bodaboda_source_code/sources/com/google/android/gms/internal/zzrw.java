package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class zzrw implements SafeParcelable {
    public static final zzrx CREATOR = new zzrx();
    final int versionCode;
    public final zzro zzati;

    zzrw(int i, zzro zzro) {
        this.versionCode = i;
        this.zzati = (zzro) zzx.zzl(zzro);
    }

    public int describeContents() {
        zzrx zzrx = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzrx zzrx = CREATOR;
        zzrx.zza(this, out, flags);
    }
}
