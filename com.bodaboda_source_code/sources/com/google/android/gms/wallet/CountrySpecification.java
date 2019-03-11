package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new zzc();
    private final int zzFG;
    String zzyc;

    CountrySpecification(int versionCode, String countryCode) {
        this.zzFG = versionCode;
        this.zzyc = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.zzFG = 1;
        this.zzyc = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.zzyc;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
