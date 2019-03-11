package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class zztj implements SafeParcelable {
    public static final zztk CREATOR = new zztk();
    public final String packageName;
    public final int versionCode;
    public final int zzatW;
    public final int zzatX;
    public final String zzatY;
    public final String zzatZ;
    public final boolean zzaua;
    public final String zzaub;

    public zztj(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4) {
        this.versionCode = i;
        this.packageName = str;
        this.zzatW = i2;
        this.zzatX = i3;
        this.zzatY = str2;
        this.zzatZ = str3;
        this.zzaua = z;
        this.zzaub = str4;
    }

    @Deprecated
    public zztj(String str, int i, int i2, String str2, String str3, boolean z) {
        this.versionCode = 1;
        this.packageName = (String) zzx.zzl(str);
        this.zzatW = i;
        this.zzatX = i2;
        this.zzaub = null;
        this.zzatY = str2;
        this.zzatZ = str3;
        this.zzaua = z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zztj)) {
            return false;
        }
        zztj zztj = (zztj) object;
        return this.packageName.equals(zztj.packageName) && this.zzatW == zztj.zzatW && this.zzatX == zztj.zzatX && zzw.equal(this.zzaub, zztj.zzaub) && zzw.equal(this.zzatY, zztj.zzatY) && zzw.equal(this.zzatZ, zztj.zzatZ) && this.zzaua == zztj.zzaua;
    }

    public int hashCode() {
        return zzw.hashCode(this.packageName, Integer.valueOf(this.zzatW), Integer.valueOf(this.zzatX), this.zzatY, this.zzatZ, Boolean.valueOf(this.zzaua));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("package=").append(this.packageName).append(',');
        stringBuilder.append("versionCode=").append(this.versionCode).append(',');
        stringBuilder.append("logSource=").append(this.zzatX).append(',');
        stringBuilder.append("logSourceName=").append(this.zzaub).append(',');
        stringBuilder.append("uploadAccount=").append(this.zzatY).append(',');
        stringBuilder.append("loggingId=").append(this.zzatZ).append(',');
        stringBuilder.append("logAndroidId=").append(this.zzaua);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zztk.zza(this, out, flags);
    }
}
