package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new zzm();
    private final int zzFG;
    String zzaCS;
    String zzaCZ;
    boolean zzaDT;
    boolean zzaDU;
    boolean zzaDV;
    String zzaDW;
    String zzaDX;
    boolean zzaDY;
    boolean zzaDZ;
    Cart zzaDi;
    CountrySpecification[] zzaEa;
    boolean zzaEb;
    boolean zzaEc;
    ArrayList<CountrySpecification> zzaEd;

    public final class Builder {
        final /* synthetic */ MaskedWalletRequest zzaEe;

        private Builder(MaskedWalletRequest maskedWalletRequest) {
            this.zzaEe = maskedWalletRequest;
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (this.zzaEe.zzaEd == null) {
                this.zzaEe.zzaEd = new ArrayList();
            }
            this.zzaEe.zzaEd.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (this.zzaEe.zzaEd == null) {
                    this.zzaEe.zzaEd = new ArrayList();
                }
                this.zzaEe.zzaEd.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return this.zzaEe;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            this.zzaEe.zzaEc = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            this.zzaEe.zzaEb = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.zzaEe.zzaDi = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzaEe.zzaCS = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            this.zzaEe.zzaDW = estimatedTotalPrice;
            return this;
        }

        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            this.zzaEe.zzaDZ = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            this.zzaEe.zzaDX = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzaEe.zzaCZ = merchantTransactionId;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            this.zzaEe.zzaDT = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            this.zzaEe.zzaDU = shippingAddressRequired;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean shouldRetrieveWalletObjects) {
            this.zzaEe.zzaDY = shouldRetrieveWalletObjects;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            this.zzaEe.zzaDV = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.zzFG = 3;
        this.zzaEb = true;
        this.zzaEc = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<CountrySpecification> allowedCountrySpecificationsForShipping) {
        this.zzFG = versionCode;
        this.zzaCZ = merchantTransactionId;
        this.zzaDT = phoneNumberRequired;
        this.zzaDU = shippingAddressRequired;
        this.zzaDV = useMinimalBillingAddress;
        this.zzaDW = estimatedTotalPrice;
        this.zzaCS = currencyCode;
        this.zzaDX = merchantName;
        this.zzaDi = cart;
        this.zzaDY = shouldRetrieveWalletObjects;
        this.zzaDZ = isBillingAgreement;
        this.zzaEa = allowedShippingCountrySpecifications;
        this.zzaEb = allowPrepaidCard;
        this.zzaEc = allowDebitCard;
        this.zzaEd = allowedCountrySpecificationsForShipping;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.zzaEc;
    }

    public boolean allowPrepaidCard() {
        return this.zzaEb;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzaEd;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzaEa;
    }

    public Cart getCart() {
        return this.zzaDi;
    }

    public String getCurrencyCode() {
        return this.zzaCS;
    }

    public String getEstimatedTotalPrice() {
        return this.zzaDW;
    }

    public String getMerchantName() {
        return this.zzaDX;
    }

    public String getMerchantTransactionId() {
        return this.zzaCZ;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean isBillingAgreement() {
        return this.zzaDZ;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzaDT;
    }

    public boolean isShippingAddressRequired() {
        return this.zzaDU;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.zzaDY;
    }

    public boolean useMinimalBillingAddress() {
        return this.zzaDV;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }
}
