package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter {
    public static final Creator<NotFilter> CREATOR = new zzl();
    final int zzFG;
    final FilterHolder zzWL;

    NotFilter(int versionCode, FilterHolder toNegate) {
        this.zzFG = versionCode;
        this.zzWL = toNegate;
    }

    public NotFilter(Filter toNegate) {
        this(1, new FilterHolder(toNegate));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzl.zza(this, out, flags);
    }

    public <T> T zza(zzf<T> zzf) {
        return zzf.zzm(this.zzWL.getFilter().zza(zzf));
    }
}
