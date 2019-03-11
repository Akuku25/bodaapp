package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class zzro implements SafeParcelable {
    public static final zzrp CREATOR = new zzrp();
    private final byte[] content;
    private final String type;
    final int versionCode;

    zzro(int i, byte[] bArr, String str) {
        zzx.zzb(bArr.length <= 1000, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), Integer.valueOf(1000));
        this.versionCode = i;
        this.content = (byte[]) zzx.zzl(bArr);
        this.type = (String) zzx.zzl(str);
    }

    public int describeContents() {
        zzrp zzrp = CREATOR;
        return 0;
    }

    public String getType() {
        return this.type;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzrp zzrp = CREATOR;
        zzrp.zza(this, out, flags);
    }

    public byte[] zzro() {
        return this.content;
    }
}
