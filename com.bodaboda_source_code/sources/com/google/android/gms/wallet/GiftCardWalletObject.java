package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class GiftCardWalletObject implements SafeParcelable {
    public static final Creator<GiftCardWalletObject> CREATOR = new zzh();
    String pin;
    final int zzFG;
    CommonWalletObject zzaDk;
    String zzaDl;
    String zzaDm;
    long zzaDn;
    String zzaDo;
    long zzaDp;
    String zzaDq;

    GiftCardWalletObject() {
        this.zzaDk = CommonWalletObject.zzuV().zzuW();
        this.zzFG = 1;
    }

    GiftCardWalletObject(int versionCode, CommonWalletObject commonWalletObject, String cardNumber, String pin, String cardIdentifier, long balanceMicros, String balanceCurrencyCode, long balanceUpdateTime, String eventNumber) {
        this.zzaDk = CommonWalletObject.zzuV().zzuW();
        this.zzFG = versionCode;
        this.zzaDk = commonWalletObject;
        this.zzaDl = cardNumber;
        this.pin = pin;
        this.zzaDn = balanceMicros;
        this.zzaDo = balanceCurrencyCode;
        this.zzaDp = balanceUpdateTime;
        this.zzaDq = eventNumber;
        this.zzaDm = cardIdentifier;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzaDk.getId();
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
