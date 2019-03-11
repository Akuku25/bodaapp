package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzru.zza;

public final class zzse implements SafeParcelable {
    public static final Creator<zzse> CREATOR = new zzsf();
    final int versionCode;
    public zzrw zzatk;
    public zzru zzatm;

    zzse() {
        this.versionCode = 1;
    }

    zzse(int i, zzrw zzrw, IBinder iBinder) {
        this.versionCode = i;
        this.zzatk = zzrw;
        this.zzatm = zza.zzck(iBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzsf.zza(this, dest, flags);
    }

    IBinder zzrq() {
        return this.zzatm.asBinder();
    }
}
