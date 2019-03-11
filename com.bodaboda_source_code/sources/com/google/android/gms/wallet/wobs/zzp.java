package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzp implements SafeParcelable {
    public static final Creator<zzp> CREATOR = new zzq();
    private final int zzFG;
    String zzaFl;
    zzl zzaFo;
    zzn zzaFp;
    zzn zzaFq;
    String zzwG;

    zzp() {
        this.zzFG = 1;
    }

    zzp(int i, String str, String str2, zzl zzl, zzn zzn, zzn zzn2) {
        this.zzFG = i;
        this.zzaFl = str;
        this.zzwG = str2;
        this.zzaFo = zzl;
        this.zzaFp = zzn;
        this.zzaFq = zzn2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }
}
