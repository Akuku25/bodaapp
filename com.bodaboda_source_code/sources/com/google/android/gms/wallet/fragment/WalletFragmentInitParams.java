package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR = new zza();
    final int zzFG;
    private String zzHg;
    private MaskedWallet zzaEA;
    private int zzaEN;
    private MaskedWalletRequest zzaEz;

    public final class Builder {
        final /* synthetic */ WalletFragmentInitParams zzaEO;

        private Builder(WalletFragmentInitParams walletFragmentInitParams) {
            this.zzaEO = walletFragmentInitParams;
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            boolean z2 = (this.zzaEO.zzaEA != null && this.zzaEO.zzaEz == null) || (this.zzaEO.zzaEA == null && this.zzaEO.zzaEz != null);
            zzx.zza(z2, (Object) "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (this.zzaEO.zzaEN < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "masked wallet request code is required and must be non-negative");
            return this.zzaEO;
        }

        public Builder setAccountName(String accountName) {
            this.zzaEO.zzHg = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            this.zzaEO.zzaEA = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            this.zzaEO.zzaEz = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            this.zzaEO.zzaEN = requestCode;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.zzFG = 1;
        this.zzaEN = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.zzFG = versionCode;
        this.zzHg = accountName;
        this.zzaEz = maskedWalletRequest;
        this.zzaEN = maskedWalletRequestCode;
        this.zzaEA = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzHg;
    }

    public MaskedWallet getMaskedWallet() {
        return this.zzaEA;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzaEz;
    }

    public int getMaskedWalletRequestCode() {
        return this.zzaEN;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
