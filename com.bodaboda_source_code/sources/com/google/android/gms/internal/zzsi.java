package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zzsi implements SafeParcelable {
    public static final Creator<zzsi> CREATOR = new zzsj();
    private String mimeType;
    private String type;
    private final int versionCode;
    private int zzato;
    private String zzatp;
    private String zzatq;
    private byte[] zzatr;

    private zzsi() {
        this.versionCode = 1;
    }

    zzsi(int i, int i2, String str, String str2, String str3, String str4, byte[] bArr) {
        this.versionCode = i;
        this.zzato = i2;
        this.zzatp = str;
        this.mimeType = str2;
        this.zzatq = str3;
        this.type = str4;
        this.zzatr = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsi)) {
            return false;
        }
        zzsi zzsi = (zzsi) o;
        return zzw.equal(Integer.valueOf(this.zzato), Integer.valueOf(zzsi.zzato)) && zzw.equal(this.zzatp, zzsi.zzatp) && zzw.equal(this.mimeType, zzsi.mimeType) && zzw.equal(this.zzatq, zzsi.zzatq) && zzw.equal(this.type, zzsi.type) && zzw.equal(this.zzatr, zzsi.zzatr);
    }

    public int getContentType() {
        return this.zzato;
    }

    public String getDomain() {
        return this.zzatq;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public byte[] getPayload() {
        return this.zzatr;
    }

    public String getType() {
        return this.type;
    }

    public String getUri() {
        return this.zzatp;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzato), this.zzatp, this.mimeType, this.zzatq, this.type, this.zzatr);
    }

    public String toString() {
        return "ShardContent[uri=" + this.zzatp + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzsj.zza(this, dest, flags);
    }
}
