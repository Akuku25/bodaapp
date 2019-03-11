package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbo;
import com.google.android.gms.internal.zzbo.zza;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = zzbo.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final zzbo zzlg;

    public static final class Builder {
        private final zza zzlh = new zza();

        public Builder() {
            this.zzlh.zzs(AdRequest.DEVICE_ID_EMULATOR);
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.zzlh.zzb(adapterClass, customEventExtras);
            return this;
        }

        public Builder addKeyword(String keyword) {
            this.zzlh.zzr(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzlh.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.zzlh.zza(adapterClass, networkExtras);
            if (adapterClass.equals(AdMobAdapter.class) && networkExtras.getBoolean("_emulatorLiveAds")) {
                this.zzlh.zzt(AdRequest.DEVICE_ID_EMULATOR);
            }
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.zzlh.zzs(deviceId);
            return this;
        }

        public AdRequest build() {
            return new AdRequest();
        }

        public Builder setBirthday(Date birthday) {
            this.zzlh.zza(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            zzx.zzb((Object) contentUrl, (Object) "Content URL must be non-null.");
            zzx.zzb(contentUrl, (Object) "Content URL must be non-empty.");
            zzx.zzb(contentUrl.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(contentUrl.length()));
            this.zzlh.zzu(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.zzlh.zzh(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzlh.zza(location);
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

    private AdRequest(Builder builder) {
        this.zzlg = new zzbo(builder.zzlh);
    }

    public Date getBirthday() {
        return this.zzlg.getBirthday();
    }

    public String getContentUrl() {
        return this.zzlg.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.zzlg.getCustomEventExtrasBundle(adapterClass);
    }

    public int getGender() {
        return this.zzlg.getGender();
    }

    public Set<String> getKeywords() {
        return this.zzlg.getKeywords();
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

    public boolean isTestDevice(Context context) {
        return this.zzlg.isTestDevice(context);
    }

    zzbo zzY() {
        return this.zzlg;
    }
}
