package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class FullTextSearchFilter extends AbstractFilter {
    public static final zzg CREATOR = new zzg();
    final String mValue;
    final int zzFG;

    FullTextSearchFilter(int versionCode, String value) {
        this.zzFG = versionCode;
        this.mValue = value;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zzbE(this.mValue);
    }
}
