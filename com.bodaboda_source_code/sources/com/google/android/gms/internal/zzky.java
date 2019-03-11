package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzld.zzb;

public class zzky implements SafeParcelable {
    public static final zzkz CREATOR = new zzkz();
    private final int zzFG;
    private final zzla zzQJ;

    zzky(int i, zzla zzla) {
        this.zzFG = i;
        this.zzQJ = zzla;
    }

    private zzky(zzla zzla) {
        this.zzFG = 1;
        this.zzQJ = zzla;
    }

    public static zzky zza(zzb<?, ?> zzb) {
        if (zzb instanceof zzla) {
            return new zzky((zzla) zzb);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        zzkz zzkz = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzkz zzkz = CREATOR;
        zzkz.zza(this, out, flags);
    }

    zzla zzju() {
        return this.zzQJ;
    }

    public zzb<?, ?> zzjv() {
        if (this.zzQJ != null) {
            return this.zzQJ;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
