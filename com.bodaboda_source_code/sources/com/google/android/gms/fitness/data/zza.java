package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class zza implements SafeParcelable {
    public static final Creator<zza> CREATOR = new zzb();
    public static final zza zzYv = new zza(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    private final int zzFG;
    private final String zzFO;
    private final String zzYw;
    private final String zzYx;

    zza(int i, String str, String str2, String str3) {
        this.zzFG = i;
        this.zzFO = (String) zzx.zzl(str);
        this.zzYw = "";
        this.zzYx = str3;
    }

    public zza(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    private boolean zza(zza zza) {
        return this.zzFO.equals(zza.zzFO) && zzw.equal(this.zzYw, zza.zzYw) && zzw.equal(this.zzYx, zza.zzYx);
    }

    public static zza zzbI(String str) {
        return zzd(str, null, null);
    }

    public static zza zzd(String str, String str2, String str3) {
        return GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(str) ? zzYv : new zza(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof zza) && zza((zza) that));
    }

    public String getPackageName() {
        return this.zzFO;
    }

    public String getVersion() {
        return this.zzYw;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzFO, this.zzYw, this.zzYx);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.zzFO, this.zzYw, this.zzYx});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }

    public String zzlm() {
        return this.zzYx;
    }
}
