package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zzqo implements SafeParcelable {
    public static final zzqp CREATOR = new zzqp();
    public static final zzqo zzaph = new zzqo(0, "Home");
    public static final zzqo zzapi = new zzqo(0, "Work");
    final int zzFG;
    private final String zzapj;

    zzqo(int i, String str) {
        this.zzFG = i;
        this.zzapj = str;
    }

    public int describeContents() {
        zzqp zzqp = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzqo)) {
            return false;
        }
        return zzw.equal(this.zzapj, ((zzqo) object).zzapj);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapj);
    }

    public String toString() {
        return zzw.zzk(this).zza("alias", this.zzapj).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzqp zzqp = CREATOR;
        zzqp.zza(this, parcel, flags);
    }

    public String zzpY() {
        return this.zzapj;
    }
}
