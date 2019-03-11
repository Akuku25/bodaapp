package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR = new zzb();
    private final int zzFG;
    String zzaCR;
    String zzaCS;
    ArrayList<LineItem> zzaCT;

    public final class Builder {
        final /* synthetic */ Cart zzaCU;

        private Builder(Cart cart) {
            this.zzaCU = cart;
        }

        public Builder addLineItem(LineItem lineItem) {
            this.zzaCU.zzaCT.add(lineItem);
            return this;
        }

        public Cart build() {
            return this.zzaCU;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzaCU.zzaCS = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            this.zzaCU.zzaCT.clear();
            this.zzaCU.zzaCT.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzaCU.zzaCR = totalPrice;
            return this;
        }
    }

    Cart() {
        this.zzFG = 1;
        this.zzaCT = new ArrayList();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.zzFG = versionCode;
        this.zzaCR = totalPrice;
        this.zzaCS = currencyCode;
        this.zzaCT = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaCS;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzaCT;
    }

    public String getTotalPrice() {
        return this.zzaCR;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
