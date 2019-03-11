package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zzaa;

public final class Tile implements SafeParcelable {
    public static final zzu CREATOR = new zzu();
    public final byte[] data;
    public final int height;
    public final int width;
    private final int zzFG;

    Tile(int versionCode, int width, int height, byte[] data) {
        this.zzFG = versionCode;
        this.width = width;
        this.height = height;
        this.data = data;
    }

    public Tile(int width, int height, byte[] data) {
        this(1, width, height, data);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (zzaa.zzqF()) {
            zzv.zza(this, out, flags);
        } else {
            zzu.zza(this, out, flags);
        }
    }
}
