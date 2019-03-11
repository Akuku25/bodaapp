package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.zzhx;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzn;
    CustomEventBanner zzo;
    CustomEventInterstitial zzp;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzq;
        private final MediationBannerListener zzr;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzq = customEventAdapter;
            this.zzr = mediationBannerListener;
        }

        public void onClick() {
            zzhx.zzY("Custom event adapter called onFailedToReceiveAd.");
            this.zzr.onClick(this.zzq);
        }

        public void onDismissScreen() {
            zzhx.zzY("Custom event adapter called onFailedToReceiveAd.");
            this.zzr.onDismissScreen(this.zzq);
        }

        public void onFailedToReceiveAd() {
            zzhx.zzY("Custom event adapter called onFailedToReceiveAd.");
            this.zzr.onFailedToReceiveAd(this.zzq, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            zzhx.zzY("Custom event adapter called onFailedToReceiveAd.");
            this.zzr.onLeaveApplication(this.zzq);
        }

        public void onPresentScreen() {
            zzhx.zzY("Custom event adapter called onFailedToReceiveAd.");
            this.zzr.onPresentScreen(this.zzq);
        }

        public void onReceivedAd(View view) {
            zzhx.zzY("Custom event adapter called onReceivedAd.");
            this.zzq.zza(view);
            this.zzr.onReceivedAd(this.zzq);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzq;
        private final MediationInterstitialListener zzs;
        final /* synthetic */ CustomEventAdapter zzt;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.zzt = customEventAdapter;
            this.zzq = customEventAdapter2;
            this.zzs = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            zzhx.zzY("Custom event adapter called onDismissScreen.");
            this.zzs.onDismissScreen(this.zzq);
        }

        public void onFailedToReceiveAd() {
            zzhx.zzY("Custom event adapter called onFailedToReceiveAd.");
            this.zzs.onFailedToReceiveAd(this.zzq, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            zzhx.zzY("Custom event adapter called onLeaveApplication.");
            this.zzs.onLeaveApplication(this.zzq);
        }

        public void onPresentScreen() {
            zzhx.zzY("Custom event adapter called onPresentScreen.");
            this.zzs.onPresentScreen(this.zzq);
        }

        public void onReceivedAd() {
            zzhx.zzY("Custom event adapter called onReceivedAd.");
            this.zzs.onReceivedAd(this.zzt);
        }
    }

    private static <T> T zza(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            zzhx.zzac("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void zza(View view) {
        this.zzn = view;
    }

    public void destroy() {
        if (this.zzo != null) {
            this.zzo.destroy();
        }
        if (this.zzp != null) {
            this.zzp.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzn;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzo = (CustomEventBanner) zza(serverParameters.className);
        if (this.zzo == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzo.requestBannerAd(new zza(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzp = (CustomEventInterstitial) zza(serverParameters.className);
        if (this.zzp == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzp.requestInterstitialAd(zza(listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.zzp.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, this, mediationInterstitialListener);
    }
}
