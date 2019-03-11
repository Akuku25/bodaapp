package com.google.ads.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.zzat;
import com.google.android.gms.internal.zzbe;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private AdView zzi;
    private InterstitialAd zzj;

    static final class zza extends AdListener implements zzat {
        final AdMobAdapter zzk;
        final MediationBannerListener zzl;

        public zza(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.zzk = adMobAdapter;
            this.zzl = mediationBannerListener;
        }

        public void onAdClicked() {
            this.zzl.onAdClicked(this.zzk);
        }

        public void onAdClosed() {
            this.zzl.onAdClosed(this.zzk);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.zzl.onAdFailedToLoad(this.zzk, errorCode);
        }

        public void onAdLeftApplication() {
            this.zzl.onAdLeftApplication(this.zzk);
        }

        public void onAdLoaded() {
            this.zzl.onAdLoaded(this.zzk);
        }

        public void onAdOpened() {
            this.zzl.onAdOpened(this.zzk);
        }
    }

    static final class zzb extends AdListener implements zzat {
        final AdMobAdapter zzk;
        final MediationInterstitialListener zzm;

        public zzb(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzk = adMobAdapter;
            this.zzm = mediationInterstitialListener;
        }

        public void onAdClicked() {
            this.zzm.onAdClicked(this.zzk);
        }

        public void onAdClosed() {
            this.zzm.onAdClosed(this.zzk);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.zzm.onAdFailedToLoad(this.zzk, errorCode);
        }

        public void onAdLeftApplication() {
            this.zzm.onAdLeftApplication(this.zzk);
        }

        public void onAdLoaded() {
            this.zzm.onAdLoaded(this.zzk);
        }

        public void onAdOpened() {
            this.zzm.onAdOpened(this.zzk);
        }
    }

    static AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(zzbe.zzbD().zzz(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.zzi;
    }

    public void onDestroy() {
        if (this.zzi != null) {
            this.zzi.destroy();
            this.zzi = null;
        }
        if (this.zzj != null) {
            this.zzj = null;
        }
    }

    public void onPause() {
        if (this.zzi != null) {
            this.zzi.pause();
        }
    }

    public void onResume() {
        if (this.zzi != null) {
            this.zzi.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.zzi = new AdView(context);
        this.zzi.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzi.setAdUnitId(serverParameters.getString("pubid"));
        this.zzi.setAdListener(new zza(this, bannerListener));
        this.zzi.loadAd(zza(context, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener interstitialListener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.zzj = new InterstitialAd(context);
        this.zzj.setAdUnitId(serverParameters.getString("pubid"));
        this.zzj.setAdListener(new zzb(this, interstitialListener));
        this.zzj.loadAd(zza(context, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.zzj.show();
    }
}
