package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR = new zzf();
    private final int zzFG;
    String zzaCY;
    String zzaCZ;
    ProxyCard zzaDa;
    String zzaDb;
    Address zzaDc;
    Address zzaDd;
    String[] zzaDe;
    UserAddress zzaDf;
    UserAddress zzaDg;
    InstrumentInfo[] zzaDh;

    private FullWallet() {
        this.zzFG = 1;
    }

    FullWallet(int versionCode, String googleTransactionId, String merchantTransactionId, ProxyCard proxyCard, String email, Address billingAddress, Address shippingAddress, String[] paymentDescriptions, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.zzFG = versionCode;
        this.zzaCY = googleTransactionId;
        this.zzaCZ = merchantTransactionId;
        this.zzaDa = proxyCard;
        this.zzaDb = email;
        this.zzaDc = billingAddress;
        this.zzaDd = shippingAddress;
        this.zzaDe = paymentDescriptions;
        this.zzaDf = buyerBillingAddress;
        this.zzaDg = buyerShippingAddress;
        this.zzaDh = instrumentInfos;
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.zzaDc;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzaDf;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzaDg;
    }

    public String getEmail() {
        return this.zzaDb;
    }

    public String getGoogleTransactionId() {
        return this.zzaCY;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzaDh;
    }

    public String getMerchantTransactionId() {
        return this.zzaCZ;
    }

    public String[] getPaymentDescriptions() {
        return this.zzaDe;
    }

    public ProxyCard getProxyCard() {
        return this.zzaDa;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzaDd;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }
}
