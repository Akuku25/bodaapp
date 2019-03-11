package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter extends AbstractFilter {
    public static final zzk CREATOR = new zzk();
    final int zzFG;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int versionCode) {
        this.zzFG = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzk.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zzlf();
    }
}
