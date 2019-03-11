package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR = new zza();
    String name;
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
    String zzaDy;
    String zzfl;

    public final class zza {
        final /* synthetic */ CommonWalletObject zzaFb;

        private zza(CommonWalletObject commonWalletObject) {
            this.zzaFb = commonWalletObject;
        }

        public zza zzdJ(String str) {
            this.zzaFb.zzfl = str;
            return this;
        }

        public CommonWalletObject zzuW() {
            return this.zzaFb;
        }
    }

    CommonWalletObject() {
        this.zzFG = 1;
        this.zzaDF = zzls.zzkb();
        this.zzaDH = zzls.zzkb();
        this.zzaDK = zzls.zzkb();
        this.zzaDM = zzls.zzkb();
        this.zzaDN = zzls.zzkb();
        this.zzaDO = zzls.zzkb();
    }

    CommonWalletObject(int versionCode, String id, String classId, String name, String issuerName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, int state, ArrayList<zzp> messages, zzl validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<zzd> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<zzn> imageModuleDataMainImageUris, ArrayList<zzj> textModulesData, ArrayList<zzn> linksModuleDataUris) {
        this.zzFG = versionCode;
        this.zzfl = id;
        this.zzaDE = classId;
        this.name = name;
        this.zzaDy = issuerName;
        this.zzaDA = barcodeAlternateText;
        this.zzaDB = barcodeType;
        this.zzaDC = barcodeValue;
        this.zzaDD = barcodeLabel;
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
    }

    public static zza zzuV() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new zza();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzfl;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
