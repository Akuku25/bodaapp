package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zziz.zza;

public class zzir implements SafeParcelable {
    public static final zzis CREATOR = new zzis();
    public static final int zzFR = Integer.parseInt("-1");
    private static final zziz zzFS = new zza("SsbContext").zzI(true).zzaz("blob").zzgX();
    final int zzFG;
    public final String zzFT;
    final zziz zzFU;
    public final int zzFV;
    public final byte[] zzFW;

    zzir(int i, String str, zziz zziz, int i2, byte[] bArr) {
        boolean z = i2 == zzFR || zziy.zzV(i2) != null;
        zzx.zzb(z, "Invalid section type " + i2);
        this.zzFG = i;
        this.zzFT = str;
        this.zzFU = zziz;
        this.zzFV = i2;
        this.zzFW = bArr;
        String zzgV = zzgV();
        if (zzgV != null) {
            throw new IllegalArgumentException(zzgV);
        }
    }

    public zzir(String str, zziz zziz) {
        this(1, str, zziz, zzFR, null);
    }

    public zzir(String str, zziz zziz, String str2) {
        this(1, str, zziz, zziy.zzay(str2), null);
    }

    public zzir(byte[] bArr, zziz zziz) {
        this(1, null, zziz, zzFR, bArr);
    }

    public static zzir zzd(byte[] bArr) {
        return new zzir(bArr, zzFS);
    }

    public int describeContents() {
        zzis zzis = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzis zzis = CREATOR;
        zzis.zza(this, dest, flags);
    }

    public String zzgV() {
        return (this.zzFV == zzFR || zziy.zzV(this.zzFV) != null) ? (this.zzFT == null || this.zzFW == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.zzFV;
    }
}
