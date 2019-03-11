package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zze implements SafeParcelable {
    public static final Creator<zze> CREATOR = new zzf();
    private final String mName;
    final int zzFG;
    private final int zzJp;
    private final String zzYy;
    private final int zzaFt;
    private final boolean zzaFu;
    private boolean zzaFv;
    private String zzaFw;

    zze(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3) {
        this.zzFG = i;
        this.mName = str;
        this.zzYy = str2;
        this.zzJp = i2;
        this.zzaFt = i3;
        this.zzaFu = z;
        this.zzaFv = z2;
        this.zzaFw = str3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof zze)) {
            return false;
        }
        zze zze = (zze) o;
        return zzw.equal(Integer.valueOf(this.zzFG), Integer.valueOf(zze.zzFG)) && zzw.equal(this.mName, zze.mName) && zzw.equal(this.zzYy, zze.zzYy) && zzw.equal(Integer.valueOf(this.zzJp), Integer.valueOf(zze.zzJp)) && zzw.equal(Integer.valueOf(this.zzaFt), Integer.valueOf(zze.zzaFt)) && zzw.equal(Boolean.valueOf(this.zzaFu), Boolean.valueOf(zze.zzaFu));
    }

    public String getAddress() {
        return this.zzYy;
    }

    public String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.zzaFt;
    }

    public int getType() {
        return this.zzJp;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzFG), this.mName, this.zzYy, Integer.valueOf(this.zzJp), Integer.valueOf(this.zzaFt), Boolean.valueOf(this.zzaFu));
    }

    public boolean isConnected() {
        return this.zzaFv;
    }

    public boolean isEnabled() {
        return this.zzaFu;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.zzYy);
        stringBuilder.append(", mType=" + this.zzJp);
        stringBuilder.append(", mRole=" + this.zzaFt);
        stringBuilder.append(", mEnabled=" + this.zzaFu);
        stringBuilder.append(", mIsConnected=" + this.zzaFv);
        stringBuilder.append(", mEnabled=" + this.zzaFw);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public String zzuX() {
        return this.zzaFw;
    }
}
