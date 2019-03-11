package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzgi
public final class zzdy<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzdt zzsS;

    /* renamed from: com.google.android.gms.internal.zzdy$1 */
    class C01641 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01641(zzdy zzdy) {
            this.zzsV = zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdClicked();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy$2 */
    class C01652 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01652(zzdy zzdy) {
            this.zzsV = zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdOpened();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy$3 */
    class C01663 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01663(zzdy zzdy) {
            this.zzsV = zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdLoaded();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy$4 */
    class C01674 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01674(zzdy zzdy) {
            this.zzsV = zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdClosed();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy$6 */
    class C01696 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01696(zzdy zzdy) {
            this.zzsV = zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdLeftApplication();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy$7 */
    class C01707 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01707(zzdy zzdy) {
            this.zzsV = zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdOpened();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy$8 */
    class C01718 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01718(zzdy zzdy) {
            this.zzsV = zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdLoaded();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy$9 */
    class C01729 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01729(zzdy zzdy) {
            this.zzsV = zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdClosed();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    public zzdy(zzdt zzdt) {
        this.zzsS = zzdt;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onClick.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdClicked();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClicked.", e);
                return;
            }
        }
        zzhx.zzac("onClick must be called on the main UI thread.");
        zzhw.zzzG.post(new C01641(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onDismissScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdClosed();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzhx.zzac("onDismissScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C01674(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onDismissScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdClosed();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzhx.zzac("onDismissScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C01729(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        zzhx.zzY("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzhx.zzac("onFailedToReceiveAd must be called on the main UI thread.");
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzdy zzsV;

            public void run() {
                try {
                    this.zzsV.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                } catch (Throwable e) {
                    zzhx.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        zzhx.zzY("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzhx.zzac("onFailedToReceiveAd must be called on the main UI thread.");
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzdy zzsV;

            public void run() {
                try {
                    this.zzsV.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                } catch (Throwable e) {
                    zzhx.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onLeaveApplication.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzhx.zzac("onLeaveApplication must be called on the main UI thread.");
        zzhw.zzzG.post(new C01696(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onLeaveApplication.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzhx.zzac("onLeaveApplication must be called on the main UI thread.");
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzdy zzsV;

            {
                this.zzsV = r1;
            }

            public void run() {
                try {
                    this.zzsV.zzsS.onAdLeftApplication();
                } catch (Throwable e) {
                    zzhx.zzd("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onPresentScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdOpened();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzhx.zzac("onPresentScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C01707(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onPresentScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdOpened();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzhx.zzac("onPresentScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C01652(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onReceivedAd.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzhx.zzac("onReceivedAd must be called on the main UI thread.");
        zzhw.zzzG.post(new C01718(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onReceivedAd.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzhx.zzac("onReceivedAd must be called on the main UI thread.");
        zzhw.zzzG.post(new C01663(this));
    }
}
