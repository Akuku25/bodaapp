package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzf implements SafeParcelable {
    public static final Creator<zzf> CREATOR = new zzi();
    String label;
    String type;
    private final int zzFG;
    zzl zzaDG;
    zzg zzaFf;

    zzf() {
        this.zzFG = 1;
    }

    zzf(int i, String str, zzg zzg, String str2, zzl zzl) {
        this.zzFG = i;
        this.label = str;
        this.zzaFf = zzg;
        this.type = str2;
        this.zzaDG = zzl;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
