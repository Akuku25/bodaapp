package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new zzj();
    String description;
    private final int zzFG;
    String zzaCR;
    String zzaCS;
    String zzaDt;
    String zzaDu;
    int zzaDv;

    public final class Builder {
        final /* synthetic */ LineItem zzaDw;

        private Builder(LineItem lineItem) {
            this.zzaDw = lineItem;
        }

        public LineItem build() {
            return this.zzaDw;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzaDw.zzaCS = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzaDw.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.zzaDw.zzaDt = quantity;
            return this;
        }

        public Builder setRole(int role) {
            this.zzaDw.zzaDv = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzaDw.zzaCR = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            this.zzaDw.zzaDu = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.zzFG = 1;
        this.zzaDv = 0;
    }

    LineItem(int versionCode, String description, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.zzFG = versionCode;
        this.description = description;
        this.zzaDt = quantity;
        this.zzaDu = unitPrice;
        this.zzaCR = totalPrice;
        this.zzaDv = role;
        this.zzaCS = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaCS;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzaDt;
    }

    public int getRole() {
        return this.zzaDv;
    }

    public String getTotalPrice() {
        return this.zzaCR;
    }

    public String getUnitPrice() {
        return this.zzaDu;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
