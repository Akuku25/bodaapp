package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR = new zzl();
    private final int zzFG;
    String zzaCY;
    String zzaCZ;
    LoyaltyWalletObject[] zzaDQ;
    OfferWalletObject[] zzaDR;
    String zzaDb;
    Address zzaDc;
    Address zzaDd;
    String[] zzaDe;
    UserAddress zzaDf;
    UserAddress zzaDg;
    InstrumentInfo[] zzaDh;

    public final class Builder {
        final /* synthetic */ MaskedWallet zzaDS;

        private Builder(MaskedWallet maskedWallet) {
            this.zzaDS = maskedWallet;
        }

        public MaskedWallet build() {
            return this.zzaDS;
        }

        public Builder setBillingAddress(Address billingAddress) {
            this.zzaDS.zzaDc = billingAddress;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress buyerBillingAddress) {
            this.zzaDS.zzaDf = buyerBillingAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress buyerShippingAddress) {
            this.zzaDS.zzaDg = buyerShippingAddress;
            return this;
        }

        public Builder setEmail(String email) {
            this.zzaDS.zzaDb = email;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzaDS.zzaCY = googleTransactionId;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfos) {
            this.zzaDS.zzaDh = instrumentInfos;
            return this;
        }

        public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] loyaltyWalletObjects) {
            this.zzaDS.zzaDQ = loyaltyWalletObjects;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzaDS.zzaCZ = merchantTransactionId;
            return this;
        }

        public Builder setOfferWalletObjects(OfferWalletObject[] offerWalletObjects) {
            this.zzaDS.zzaDR = offerWalletObjects;
            return this;
        }

        public Builder setPaymentDescriptions(String[] paymentDescriptions) {
            this.zzaDS.zzaDe = paymentDescriptions;
            return this;
        }

        public Builder setShippingAddress(Address shippingAddress) {
            this.zzaDS.zzaDd = shippingAddress;
            return this;
        }
    }

    private MaskedWallet() {
        this.zzFG = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.zzFG = versionCode;
        this.zzaCY = googleTransactionId;
        this.zzaCZ = merchantTransactionId;
        this.zzaDe = paymentDescriptions;
        this.zzaDb = email;
        this.zzaDc = billingAddress;
        this.zzaDd = shippingAddress;
        this.zzaDQ = loyaltyWalletObjects;
        this.zzaDR = offerWalletObjects;
        this.zzaDf = buyerBillingAddress;
        this.zzaDg = buyerShippingAddress;
        this.zzaDh = instrumentInfos;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzx.zzl(maskedWallet);
        return zzuR().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).setLoyaltyWalletObjects(maskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(maskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder zzuR() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder();
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

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.zzaDQ;
    }

    public String getMerchantTransactionId() {
        return this.zzaCZ;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.zzaDR;
    }

    public String[] getPaymentDescriptions() {
        return this.zzaDe;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzaDd;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}
