package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzbo;
import com.google.android.gms.internal.zzbo.zza;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = zzbo.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int zzAA;
    private final int zzAB;
    private final int zzAC;
    private final int zzAD;
    private final int zzAE;
    private final int zzAF;
    private final String zzAG;
    private final int zzAH;
    private final String zzAI;
    private final int zzAJ;
    private final int zzAK;
    private final String zzAL;
    private final int zzAy;
    private final int zzAz;
    private final zzbo zzlg;

    public static final class Builder {
        private int zzAA;
        private int zzAB;
        private int zzAC;
        private int zzAD;
        private int zzAE = 0;
        private int zzAF;
        private String zzAG;
        private int zzAH;
        private String zzAI;
        private int zzAJ;
        private int zzAK;
        private String zzAL;
        private int zzAy;
        private int zzAz;
        private final zza zzlh = new zza();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.zzlh.zzb(adapterClass, customEventExtras);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzlh.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.zzlh.zza(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.zzlh.zzs(deviceId);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public Builder setAnchorTextColor(int anchorTextColor) {
            this.zzAy = anchorTextColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.zzAz = backgroundColor;
            this.zzAA = Color.argb(0, 0, 0, 0);
            this.zzAB = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int top, int bottom) {
            this.zzAz = Color.argb(0, 0, 0, 0);
            this.zzAA = bottom;
            this.zzAB = top;
            return this;
        }

        public Builder setBorderColor(int borderColor) {
            this.zzAC = borderColor;
            return this;
        }

        public Builder setBorderThickness(int borderThickness) {
            this.zzAD = borderThickness;
            return this;
        }

        public Builder setBorderType(int borderType) {
            this.zzAE = borderType;
            return this;
        }

        public Builder setCallButtonColor(int callButtonColor) {
            this.zzAF = callButtonColor;
            return this;
        }

        public Builder setCustomChannels(String channelIds) {
            this.zzAG = channelIds;
            return this;
        }

        public Builder setDescriptionTextColor(int descriptionTextColor) {
            this.zzAH = descriptionTextColor;
            return this;
        }

        public Builder setFontFace(String fontFace) {
            this.zzAI = fontFace;
            return this;
        }

        public Builder setHeaderTextColor(int headerTextColor) {
            this.zzAJ = headerTextColor;
            return this;
        }

        public Builder setHeaderTextSize(int headerTextSize) {
            this.zzAK = headerTextSize;
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzlh.zza(location);
            return this;
        }

        public Builder setQuery(String query) {
            this.zzAL = query;
            return this;
        }

        public Builder setRequestAgent(String requestAgent) {
            this.zzlh.zzw(requestAgent);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.zzlh.zzk(tagForChildDirectedTreatment);
            return this;
        }
    }

    private SearchAdRequest(Builder builder) {
        this.zzAy = builder.zzAy;
        this.zzAz = builder.zzAz;
        this.zzAA = builder.zzAA;
        this.zzAB = builder.zzAB;
        this.zzAC = builder.zzAC;
        this.zzAD = builder.zzAD;
        this.zzAE = builder.zzAE;
        this.zzAF = builder.zzAF;
        this.zzAG = builder.zzAG;
        this.zzAH = builder.zzAH;
        this.zzAI = builder.zzAI;
        this.zzAJ = builder.zzAJ;
        this.zzAK = builder.zzAK;
        this.zzAL = builder.zzAL;
        this.zzlg = new zzbo(builder.zzlh, this);
    }

    public int getAnchorTextColor() {
        return this.zzAy;
    }

    public int getBackgroundColor() {
        return this.zzAz;
    }

    public int getBackgroundGradientBottom() {
        return this.zzAA;
    }

    public int getBackgroundGradientTop() {
        return this.zzAB;
    }

    public int getBorderColor() {
        return this.zzAC;
    }

    public int getBorderThickness() {
        return this.zzAD;
    }

    public int getBorderType() {
        return this.zzAE;
    }

    public int getCallButtonColor() {
        return this.zzAF;
    }

    public String getCustomChannels() {
        return this.zzAG;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.zzlg.getCustomEventExtrasBundle(adapterClass);
    }

    public int getDescriptionTextColor() {
        return this.zzAH;
    }

    public String getFontFace() {
        return this.zzAI;
    }

    public int getHeaderTextColor() {
        return this.zzAJ;
    }

    public int getHeaderTextSize() {
        return this.zzAK;
    }

    public Location getLocation() {
        return this.zzlg.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.zzlg.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.zzlg.getNetworkExtrasBundle(adapterClass);
    }

    public String getQuery() {
        return this.zzAL;
    }

    public boolean isTestDevice(Context context) {
        return this.zzlg.isTestDevice(context);
    }

    zzbo zzY() {
        return this.zzlg;
    }
}
