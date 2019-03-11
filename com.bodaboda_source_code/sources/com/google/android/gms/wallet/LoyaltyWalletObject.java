package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.zzd;
import com.google.android.gms.wallet.wobs.zzf;
import com.google.android.gms.wallet.wobs.zzj;
import com.google.android.gms.wallet.wobs.zzl;
import com.google.android.gms.wallet.wobs.zzn;
import com.google.android.gms.wallet.wobs.zzp;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator<LoyaltyWalletObject> CREATOR = new zzk();
    int state;
    private final int zzFG;
    String zzaDA;
    String zzaDB;
    String zzaDC;
    String zzaDD;
    String zzaDE;
    ArrayList<zzp> zzaDF;
    zzl zzaDG;
    ArrayList<LatLng> zzaDH;
    String zzaDI;
    String zzaDJ;
    ArrayList<zzd> zzaDK;
    boolean zzaDL;
    ArrayList<zzn> zzaDM;
    ArrayList<zzj> zzaDN;
    ArrayList<zzn> zzaDO;
    zzf zzaDP;
    String zzaDx;
    String zzaDy;
    String zzaDz;
    String zzapd;
    String zzfl;

    LoyaltyWalletObject() {
        this.zzFG = 4;
        this.zzaDF = zzls.zzkb();
        this.zzaDH = zzls.zzkb();
        this.zzaDK = zzls.zzkb();
        this.zzaDM = zzls.zzkb();
        this.zzaDN = zzls.zzkb();
        this.zzaDO = zzls.zzkb();
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, String classId, int state, ArrayList<zzp> messages, zzl validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<zzd> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<zzn> imageModuleDataMainImageUris, ArrayList<zzj> textModulesData, ArrayList<zzn> linksModuleDataUris, zzf loyaltyPoints) {
        this.zzFG = versionCode;
        this.zzfl = id;
        this.zzaDx = accountId;
        this.zzaDy = issuerName;
        this.zzaDz = programName;
        this.zzapd = accountName;
        this.zzaDA = barcodeAlternateText;
        this.zzaDB = barcodeType;
        this.zzaDC = barcodeValue;
        this.zzaDD = barcodeLabel;
        this.zzaDE = classId;
        this.state = state;
        this.zzaDF = messages;
        this.zzaDG = validTimeInterval;
        this.zzaDH = locations;
        this.zzaDI = infoModuleDataHexFontColor;
        this.zzaDJ = infoModuleDataHexBackgroundColor;
        this.zzaDK = infoModuleDataLabelValueRows;
        this.zzaDL = infoModuleDataShowLastUpdateTime;
        this.zzaDM = imageModuleDataMainImageUris;
        this.zzaDN = textModulesData;
        this.zzaDO = linksModuleDataUris;
        this.zzaDP = loyaltyPoints;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.zzaDx;
    }

    public String getAccountName() {
        return this.zzapd;
    }

    public String getBarcodeAlternateText() {
        return this.zzaDA;
    }

    public String getBarcodeType() {
        return this.zzaDB;
    }

    public String getBarcodeValue() {
        return this.zzaDC;
    }

    public String getId() {
        return this.zzfl;
    }

    public String getIssuerName() {
        return this.zzaDy;
    }

    public String getProgramName() {
        return this.zzaDz;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
