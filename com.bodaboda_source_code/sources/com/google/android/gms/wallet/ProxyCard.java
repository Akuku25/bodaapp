package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR = new zzp();
    private final int zzFG;
    String zzaEi;
    String zzaEj;
    int zzaEk;
    int zzaEl;

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.zzFG = versionCode;
        this.zzaEi = pan;
        this.zzaEj = cvn;
        this.zzaEk = expirationMonth;
        this.zzaEl = expirationYear;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.zzaEj;
    }

    public int getExpirationMonth() {
        return this.zzaEk;
    }

    public int getExpirationYear() {
        return this.zzaEl;
    }

    public String getPan() {
        return this.zzaEi;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzp.zza(this, out, flags);
    }
}
