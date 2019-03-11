package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Creator<Address> CREATOR = new zza();
    String name;
    private final int zzFG;
    String zzaCP;
    String zzaCQ;
    String zzalB;
    String zzalD;
    boolean zzalE;
    String zzalF;
    String zzalu;
    String zzalv;
    String zzalw;
    String zzyc;

    Address() {
        this.zzFG = 1;
    }

    Address(int versionCode, String name, String address1, String address2, String address3, String countryCode, String city, String state, String postalCode, String phoneNumber, boolean isPostBox, String companyName) {
        this.zzFG = versionCode;
        this.name = name;
        this.zzalu = address1;
        this.zzalv = address2;
        this.zzalw = address3;
        this.zzyc = countryCode;
        this.zzaCP = city;
        this.zzaCQ = state;
        this.zzalB = postalCode;
        this.zzalD = phoneNumber;
        this.zzalE = isPostBox;
        this.zzalF = companyName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.zzalu;
    }

    public String getAddress2() {
        return this.zzalv;
    }

    public String getAddress3() {
        return this.zzalw;
    }

    public String getCity() {
        return this.zzaCP;
    }

    public String getCompanyName() {
        return this.zzalF;
    }

    public String getCountryCode() {
        return this.zzyc;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.zzalD;
    }

    public String getPostalCode() {
        return this.zzalB;
    }

    public String getState() {
        return this.zzaCQ;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean isPostBox() {
        return this.zzalE;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
