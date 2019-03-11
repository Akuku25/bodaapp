package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.internal.zzx;

@zzgi
public final class zzdw implements MediationBannerListener, MediationInterstitialListener {
    private final zzdt zzsS;

    public zzdw(zzdt zzdt) {
        this.zzsS = zzdt;
    }

    public void onAdClicked(MediationBannerAdapter adapter) {
        zzx.zzbd("onAdClicked must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdClicked.");
        try {
            this.zzsS.onAdClicked();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter adapter) {
        zzx.zzbd("onAdClicked must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdClicked.");
        try {
            this.zzsS.onAdClicked();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationBannerAdapter adapter) {
        zzx.zzbd("onAdClosed must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdClosed.");
        try {
            this.zzsS.onAdClosed();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter adapter) {
        zzx.zzbd("onAdClosed must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdClosed.");
        try {
            this.zzsS.onAdClosed();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter adapter, int errorCode) {
        zzx.zzbd("onAdFailedToLoad must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdFailedToLoad with error. " + errorCode);
        try {
            this.zzsS.onAdFailedToLoad(errorCode);
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter adapter, int errorCode) {
        zzx.zzbd("onAdFailedToLoad must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdFailedToLoad with error " + errorCode + ".");
        try {
            this.zzsS.onAdFailedToLoad(errorCode);
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter adapter) {
        zzx.zzbd("onAdLeftApplication must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdLeftApplication.");
        try {
            this.zzsS.onAdLeftApplication();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter adapter) {
        zzx.zzbd("onAdLeftApplication must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdLeftApplication.");
        try {
            this.zzsS.onAdLeftApplication();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter adapter) {
        zzx.zzbd("onAdLoaded must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdLoaded.");
        try {
            this.zzsS.onAdLoaded();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter adapter) {
        zzx.zzbd("onAdLoaded must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdLoaded.");
        try {
            this.zzsS.onAdLoaded();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter adapter) {
        zzx.zzbd("onAdOpened must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdOpened.");
        try {
            this.zzsS.onAdOpened();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter adapter) {
        zzx.zzbd("onAdOpened must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdOpened.");
        try {
            this.zzsS.onAdOpened();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdOpened.", e);
        }
    }
}
