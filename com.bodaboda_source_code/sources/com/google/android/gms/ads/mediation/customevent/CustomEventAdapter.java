package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.zzhx;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    CustomEventBanner zzAs;
    CustomEventInterstitial zzAt;
    private View zzn;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzAu;
        private final MediationBannerListener zzl;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzAu = customEventAdapter;
            this.zzl = mediationBannerListener;
        }

        public void onAdClicked() {
            zzhx.zzY("Custom event adapter called onAdClicked.");
            this.zzl.onAdClicked(this.zzAu);
        }

        public void onAdClosed() {
            zzhx.zzY("Custom event adapter called onAdClosed.");
            this.zzl.onAdClosed(this.zzAu);
        }

        public void onAdFailedToLoad(int errorCode) {
            zzhx.zzY("Custom event adapter called onAdFailedToLoad.");
            this.zzl.onAdFailedToLoad(this.zzAu, errorCode);
        }

        public void onAdLeftApplication() {
            zzhx.zzY("Custom event adapter called onAdLeftApplication.");
            this.zzl.onAdLeftApplication(this.zzAu);
        }

        public void onAdLoaded(View view) {
            zzhx.zzY("Custom event adapter called onAdLoaded.");
            this.zzAu.zza(view);
            this.zzl.onAdLoaded(this.zzAu);
        }

        public void onAdOpened() {
            zzhx.zzY("Custom event adapter called onAdOpened.");
            this.zzl.onAdOpened(this.zzAu);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzAu;
        final /* synthetic */ CustomEventAdapter zzAv;
        private final MediationInterstitialListener zzm;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.zzAv = customEventAdapter;
            this.zzAu = customEventAdapter2;
            this.zzm = mediationInterstitialListener;
        }

        public void onAdClicked() {
            zzhx.zzY("Custom event adapter called onAdClicked.");
            this.zzm.onAdClicked(this.zzAu);
        }

        public void onAdClosed() {
            zzhx.zzY("Custom event adapter called onAdClosed.");
            this.zzm.onAdClosed(this.zzAu);
        }

        public void onAdFailedToLoad(int errorCode) {
            zzhx.zzY("Custom event adapter called onFailedToReceiveAd.");
            this.zzm.onAdFailedToLoad(this.zzAu, errorCode);
        }

        public void onAdLeftApplication() {
            zzhx.zzY("Custom event adapter called onAdLeftApplication.");
            this.zzm.onAdLeftApplication(this.zzAu);
        }

        public void onAdLoaded() {
            zzhx.zzY("Custom event adapter called onReceivedAd.");
            this.zzm.onAdLoaded(this.zzAv);
        }

        public void onAdOpened() {
            zzhx.zzY("Custom event adapter called onAdOpened.");
            this.zzm.onAdOpened(this.zzAu);
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

    public View getBannerView() {
        return this.zzn;
    }

    public void onDestroy() {
        if (this.zzAs != null) {
            this.zzAs.onDestroy();
        }
        if (this.zzAt != null) {
            this.zzAt.onDestroy();
        }
    }

    public void onPause() {
        if (this.zzAs != null) {
            this.zzAs.onPause();
        }
        if (this.zzAt != null) {
            this.zzAt.onPause();
        }
    }

    public void onResume() {
        if (this.zzAs != null) {
            this.zzAs.onResume();
        }
        if (this.zzAt != null) {
            this.zzAt.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.zzAs = (CustomEventBanner) zza(serverParameters.getString("class_name"));
        if (this.zzAs == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzAs.requestBannerAd(context, new zza(this, listener), serverParameters.getString("parameter"), adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.zzAt = (CustomEventInterstitial) zza(serverParameters.getString("class_name"));
        if (this.zzAt == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzAt.requestInterstitialAd(context, zza(listener), serverParameters.getString("parameter"), mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void showInterstitial() {
        this.zzAt.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, this, mediationInterstitialListener);
    }
}
