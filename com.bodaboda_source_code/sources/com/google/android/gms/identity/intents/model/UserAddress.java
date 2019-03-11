package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants.Extras;

public final class UserAddress implements SafeParcelable {
    public static final Creator<UserAddress> CREATOR = new zzb();
    String name;
    private final int zzFG;
    String zzalA;
    String zzalB;
    String zzalC;
    String zzalD;
    boolean zzalE;
    String zzalF;
    String zzalG;
    String zzalu;
    String zzalv;
    String zzalw;
    String zzalx;
    String zzaly;
    String zzalz;
    String zzyc;

    UserAddress() {
        this.zzFG = 1;
    }

    UserAddress(int versionCode, String name, String address1, String address2, String address3, String address4, String address5, String administrativeArea, String locality, String countryCode, String postalCode, String sortingCode, String phoneNumber, boolean isPostBox, String companyName, String emailAddress) {
        this.zzFG = versionCode;
        this.name = name;
        this.zzalu = address1;
        this.zzalv = address2;
        this.zzalw = address3;
        this.zzalx = address4;
        this.zzaly = address5;
        this.zzalz = administrativeArea;
        this.zzalA = locality;
        this.zzyc = countryCode;
        this.zzalB = postalCode;
        this.zzalC = sortingCode;
        this.zzalD = phoneNumber;
        this.zzalE = isPostBox;
        this.zzalF = companyName;
        this.zzalG = emailAddress;
    }

    public static UserAddress fromIntent(Intent data) {
        return (data == null || !data.hasExtra(Extras.EXTRA_ADDRESS)) ? null : (UserAddress) data.getParcelableExtra(Extras.EXTRA_ADDRESS);
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

    public String getAddress4() {
        return this.zzalx;
    }

    public String getAddress5() {
        return this.zzaly;
    }

    public String getAdministrativeArea() {
        return this.zzalz;
    }

    public String getCompanyName() {
        return this.zzalF;
    }

    public String getCountryCode() {
        return this.zzyc;
    }

    public String getEmailAddress() {
        return this.zzalG;
    }

    public String getLocality() {
        return this.zzalA;
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

    public String getSortingCode() {
        return this.zzalC;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean isPostBox() {
        return this.zzalE;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
