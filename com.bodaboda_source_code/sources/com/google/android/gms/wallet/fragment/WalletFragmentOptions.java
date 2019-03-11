package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.C0099R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR = new zzb();
    private int mTheme;
    final int zzFG;
    private int zzRW;
    private WalletFragmentStyle zzaEP;
    private int zzaEo;

    public final class Builder {
        final /* synthetic */ WalletFragmentOptions zzaEQ;

        private Builder(WalletFragmentOptions walletFragmentOptions) {
            this.zzaEQ = walletFragmentOptions;
        }

        public WalletFragmentOptions build() {
            return this.zzaEQ;
        }

        public Builder setEnvironment(int environment) {
            this.zzaEQ.zzaEo = environment;
            return this;
        }

        public Builder setFragmentStyle(int styleResourceId) {
            this.zzaEQ.zzaEP = new WalletFragmentStyle().setStyleResourceId(styleResourceId);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle fragmentStyle) {
            this.zzaEQ.zzaEP = fragmentStyle;
            return this;
        }

        public Builder setMode(int mode) {
            this.zzaEQ.zzRW = mode;
            return this;
        }

        public Builder setTheme(int theme) {
            this.zzaEQ.mTheme = theme;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.zzFG = 1;
    }

    WalletFragmentOptions(int versionCode, int environment, int theme, WalletFragmentStyle fragmentStyle, int mode) {
        this.zzFG = versionCode;
        this.zzaEo = environment;
        this.mTheme = theme;
        this.zzaEP = fragmentStyle;
        this.zzRW = mode;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zza(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0099R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(C0099R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(C0099R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(C0099R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(C0099R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzaEo = i2;
        walletFragmentOptions.zzaEP = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzaEP.zzao(context);
        walletFragmentOptions.zzRW = i3;
        return walletFragmentOptions;
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.zzaEo;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.zzaEP;
    }

    public int getMode() {
        return this.zzRW;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public void zzao(Context context) {
        if (this.zzaEP != null) {
            this.zzaEP.zzao(context);
        }
    }
}
