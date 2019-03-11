package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzj implements SafeParcelable {
    public static final zzk CREATOR = new zzk();
    public static final zzj zzaod = zzB("test_type", 1);
    public static final zzj zzaoe = zzB("labeled_place", 6);
    public static final zzj zzaof = zzB("here_content", 7);
    public static final Set<zzj> zzaog = Collections.unmodifiableSet(new HashSet(Arrays.asList(new zzj[]{zzaod, zzaoe, zzaof})));
    final int zzFG;
    final int zzaoh;
    final String zzxV;

    zzj(int i, String str, int i2) {
        zzx.zzbn(str);
        this.zzFG = i;
        this.zzxV = str;
        this.zzaoh = i2;
    }

    private static zzj zzB(String str, int i) {
        return new zzj(0, str, i);
    }

    public int describeContents() {
        zzk zzk = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) object;
        return this.zzxV.equals(zzj.zzxV) && this.zzaoh == zzj.zzaoh;
    }

    public int hashCode() {
        return this.zzxV.hashCode();
    }

    public String toString() {
        return this.zzxV;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzk zzk = CREATOR;
        zzk.zza(this, parcel, flags);
    }
}
