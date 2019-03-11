package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@zzgi
public class zzt extends com.google.android.gms.internal.zzbi.zza implements zzac, zzat, zzct, zzcw, zzcy, zzdl, zzeh, zzep, zzes, zzfk, com.google.android.gms.internal.zzgc.zza, com.google.android.gms.internal.zzgj.zza, zzhi, zzv {
    private zzce zzlA;
    private zzce zzlB;
    private zzax zzlC;
    private final zzdr zzlD;
    private final zzb zzlE;
    private final zzaa zzlF;
    private final zzae zzlG;
    private boolean zzlH;
    private zzcf zzlz;

    @zzgi
    public static final class zza extends ViewSwitcher {
        private final zzhs zzlL;

        public zza(Context context) {
            super(context);
            this.zzlL = new zzhs(context);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.zzlL.zzc(event);
            return false;
        }

        public void removeAllViews() {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof zzic)) {
                    ((zzic) childAt).destroy();
                }
            }
            super.removeAllViews();
        }
    }

    @zzgi
    static class zzb implements OnGlobalLayoutListener {
        public final String zzlM;
        public final Context zzlN;
        public final zzk zzlO;
        public final zzhy zzlP;
        public zzhl zzlQ;
        public zzbg zzlR;
        public zza zzlS;
        public zzbh zzlT;
        public zzhl zzlU;
        public zzba zzlV;
        public zzhe zzlW;
        public com.google.android.gms.internal.zzhe.zza zzlX;
        public zzhf zzlY;
        public zzbk zzlZ;
        public zzfs zzma;
        public zzfo zzmb;
        public zzcq zzmc;
        public zzcr zzmd;
        public zzcj zzme;
        public List<String> zzmf;
        public zzfl zzmg;
        public zzhj zzmh;
        public View zzmi;
        public int zzmj;
        public boolean zzmk;
        public boolean zzml;
        public zzbl zzmm;
        private HashSet<zzhf> zzmn;
        private int zzmo;
        private int zzmp;

        public zzb(Context context, zzba zzba, String str, zzhy zzhy) {
            this(context, zzba, str, zzhy, null);
        }

        zzb(Context context, zzba zzba, String str, zzhy zzhy, zzk zzk) {
            this.zzmh = null;
            this.zzmi = null;
            this.zzmj = 0;
            this.zzmk = false;
            this.zzml = false;
            this.zzmn = null;
            this.zzmo = -1;
            this.zzmp = -1;
            if (zzba.zzpb) {
                this.zzlS = null;
            } else {
                this.zzlS = new zza(context);
                this.zzlS.setMinimumWidth(zzba.widthPixels);
                this.zzlS.setMinimumHeight(zzba.heightPixels);
                this.zzlS.setVisibility(4);
            }
            if (!(context == null || !(context instanceof Activity) || this.zzlS == null)) {
                zzab.zzaM().zza((Activity) context, (OnGlobalLayoutListener) this);
            }
            this.zzlV = zzba;
            this.zzlM = str;
            this.zzlN = context;
            this.zzlP = zzhy;
            if (zzk == null) {
                zzk = new zzk(new zzw(this));
            }
            this.zzlO = zzk;
        }

        public void destroy() {
            this.zzlT = null;
            this.zzlZ = null;
            this.zzma = null;
            this.zzmb = null;
            this.zzme = null;
            this.zzmm = null;
            if (!(this.zzlN == null || !(this.zzlN instanceof Activity) || this.zzlS == null)) {
                zzab.zzaO().zzb((Activity) this.zzlN, (OnGlobalLayoutListener) this);
            }
            zzf(false);
            if (this.zzlS != null) {
                this.zzlS.removeAllViews();
            }
            zzay();
            zzaA();
            this.zzlW = null;
        }

        public void onGlobalLayout() {
            if (this.zzlS != null && this.zzlW != null && this.zzlW.zzuq != null && this.zzlW.zzuq.zzeG().zzba()) {
                int[] iArr = new int[2];
                this.zzlS.getLocationOnScreen(iArr);
                int zzc = zzbe.zzbD().zzc(this.zzlN, iArr[0]);
                int zzc2 = zzbe.zzbD().zzc(this.zzlN, iArr[1]);
                if (zzc != this.zzmo || zzc2 != this.zzmp) {
                    this.zzmo = zzc;
                    this.zzmp = zzc2;
                    this.zzlW.zzuq.zzeG().zzb(this.zzmo, this.zzmp);
                }
            }
        }

        public void zza(HashSet<zzhf> hashSet) {
            this.zzmn = hashSet;
        }

        public void zzaA() {
            if (this.zzlW != null && this.zzlW.zzsM != null) {
                try {
                    this.zzlW.zzsM.destroy();
                } catch (RemoteException e) {
                    zzhx.zzac("Could not destroy mediation adapter.");
                }
            }
        }

        public HashSet<zzhf> zzax() {
            return this.zzmn;
        }

        public void zzay() {
            if (this.zzlW != null && this.zzlW.zzuq != null) {
                this.zzlW.zzuq.destroy();
            }
        }

        public void zzaz() {
            if (this.zzlW != null && this.zzlW.zzuq != null) {
                this.zzlW.zzuq.stopLoading();
            }
        }

        public void zzf(boolean z) {
            if (this.zzmj == 0) {
                zzaz();
            }
            if (this.zzlQ != null) {
                this.zzlQ.cancel();
            }
            if (this.zzlU != null) {
                this.zzlU.cancel();
            }
            if (z) {
                this.zzlW = null;
            }
        }
    }

    public zzt(Context context, zzba zzba, String str, zzdr zzdr, zzhy zzhy) {
        this(new zzb(context, zzba, str, zzhy), zzdr, null);
    }

    zzt(zzb zzb, zzdr zzdr, zzaa zzaa) {
        zzca.zzl(zzb.zzlN);
        this.zzlE = zzb;
        this.zzlD = zzdr;
        if (zzaa == null) {
            zzaa = new zzaa(this);
        }
        this.zzlF = zzaa;
        zzab.zzaM().zzu(this.zzlE.zzlN);
        zzab.zzaP().zzb(this.zzlE.zzlN, this.zzlE.zzlP);
        this.zzlG = zzab.zzaP().zzel();
    }

    private com.google.android.gms.internal.zzgo.zza zza(zzax zzax, Bundle bundle) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.zzlE.zzlN.getApplicationInfo();
        try {
            packageInfo = this.zzlE.zzlN.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzlE.zzlN.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.zzlE.zzlV.zzpb || this.zzlE.zzlS.getParent() == null)) {
            int[] iArr = new int[2];
            this.zzlE.zzlS.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.zzlE.zzlS.getWidth();
            int height = this.zzlE.zzlS.getHeight();
            int i3 = 0;
            if (this.zzlE.zzlS.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String zzee = zzab.zzaP().zzee();
        this.zzlE.zzlY = new zzhf(zzee, this.zzlE.zzlM);
        this.zzlE.zzlY.zze(zzax);
        String zza = zzab.zzaM().zza(this.zzlE.zzlN, this.zzlE.zzlS, this.zzlE.zzlV);
        int zzaF = zzz.zzj(this.zzlE.zzlN).zzaF();
        boolean isInitialized = zzz.zzj(this.zzlE.zzlN).isInitialized();
        long j = 0;
        if (this.zzlE.zzmm != null) {
            try {
                j = this.zzlE.zzmm.getValue();
            } catch (RemoteException e2) {
                zzhx.zzac("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        return new com.google.android.gms.internal.zzgo.zza(bundle2, zzax, this.zzlE.zzlV, this.zzlE.zzlM, applicationInfo, packageInfo, zzee, zzab.zzaP().getSessionId(), this.zzlE.zzlP, zzab.zzaP().zza(this.zzlE.zzlN, this, zzee), this.zzlE.zzmf, bundle, zzab.zzaP().zzei(), new Messenger(new zzey(this.zzlE.zzlN)), displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, zza, isInitialized, zzaF, j, uuid);
    }

    private zzic zza(zzu zzu) {
        if (this.zzlE.zzlV.zzpb) {
            zzic zza = zzab.zzaN().zza(this.zzlE.zzlN, this.zzlE.zzlV, false, false, this.zzlE.zzlO, this.zzlE.zzlP);
            zza.zzeG().zzb(this, null, this, this, ((Boolean) zzca.zzqJ.get()).booleanValue(), this, this, zzu, null);
            return zza;
        }
        zzic zzic;
        View nextView = this.zzlE.zzlS.getNextView();
        if (nextView instanceof zzic) {
            zzic = (zzic) nextView;
            zzic.zza(this.zzlE.zzlN, this.zzlE.zzlV);
        } else {
            if (nextView != null) {
                this.zzlE.zzlS.removeView(nextView);
            }
            zzic = zzab.zzaN().zza(this.zzlE.zzlN, this.zzlE.zzlV, false, false, this.zzlE.zzlO, this.zzlE.zzlP);
            if (this.zzlE.zzlV.zzpc == null) {
                zzc(zzic.getWebView());
            }
        }
        zzic.zzeG().zzb(this, this, this, this, false, this, null, zzu, this);
        return zzic;
    }

    private void zza(int i) {
        zzhx.zzac("Failed to load ad: " + i);
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdFailedToLoad(i);
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void zzap() {
        zzhx.zzaa("Ad closing.");
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdClosed();
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void zzaq() {
        zzhx.zzaa("Ad leaving application.");
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdLeftApplication();
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void zzar() {
        zzhx.zzaa("Ad opening.");
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdOpened();
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void zzas() {
        zzhx.zzaa("Ad finished loading.");
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdLoaded();
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private void zzat() {
        try {
            if ((this.zzlE.zzlW.zzyx instanceof zzcl) && this.zzlE.zzmc != null) {
                this.zzlE.zzmc.zza((zzcl) this.zzlE.zzlW.zzyx);
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }

    private void zzau() {
        try {
            if ((this.zzlE.zzlW.zzyx instanceof zzcm) && this.zzlE.zzmd != null) {
                this.zzlE.zzmd.zza((zzcm) this.zzlE.zzlW.zzyx);
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }

    private void zzaw() {
        if (this.zzlE.zzmj == 0) {
            this.zzlE.zzay();
            this.zzlE.zzlW = null;
            this.zzlE.zzml = false;
        }
    }

    private boolean zzb(zzhe zzhe) {
        View view;
        if (zzhe.zzwI) {
            try {
                view = (View) zze.zzf(zzhe.zzsM.getView());
                View nextView = this.zzlE.zzlS.getNextView();
                if (nextView != null) {
                    if (nextView instanceof zzic) {
                        ((zzic) nextView).destroy();
                    }
                    this.zzlE.zzlS.removeView(nextView);
                }
                try {
                    zzc(view);
                } catch (Throwable th) {
                    zzhx.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                zzhx.zzd("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (zzhe.zzyu != null) {
            zzhe.zzuq.zza(zzhe.zzyu);
            this.zzlE.zzlS.removeAllViews();
            this.zzlE.zzlS.setMinimumWidth(zzhe.zzyu.widthPixels);
            this.zzlE.zzlS.setMinimumHeight(zzhe.zzyu.heightPixels);
            zzc(zzhe.zzuq.getWebView());
        }
        if (this.zzlE.zzlS.getChildCount() > 1) {
            this.zzlE.zzlS.showNext();
        }
        if (this.zzlE.zzlW != null) {
            view = this.zzlE.zzlS.getNextView();
            if (view instanceof zzic) {
                ((zzic) view).zza(this.zzlE.zzlN, this.zzlE.zzlV);
            } else if (view != null) {
                this.zzlE.zzlS.removeView(view);
            }
            this.zzlE.zzaA();
        }
        this.zzlE.zzlS.setVisibility(0);
        return true;
    }

    private void zze(boolean z) {
        if (this.zzlE.zzlW == null) {
            zzhx.zzac("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzhx.zzY("Pinging Impression URLs.");
        this.zzlE.zzlY.zzdX();
        if (this.zzlE.zzlW.zzsu != null) {
            zzab.zzaM().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, zzb(this.zzlE.zzlW.zzsu));
        }
        if (!(this.zzlE.zzlW.zzyt == null || this.zzlE.zzlW.zzyt.zzsu == null)) {
            zzab.zzaV().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, this.zzlE.zzlW, this.zzlE.zzlM, z, zzb(this.zzlE.zzlW.zzyt.zzsu));
        }
        if (this.zzlE.zzlW.zzsL != null && this.zzlE.zzlW.zzsL.zzsp != null) {
            zzab.zzaV().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, this.zzlE.zzlW, this.zzlE.zzlM, z, this.zzlE.zzlW.zzsL.zzsp);
        }
    }

    public void destroy() {
        zzx.zzbd("destroy must be called on the main UI thread.");
        this.zzlF.cancel();
        this.zzlG.zze(this.zzlE.zzlW);
        this.zzlE.destroy();
    }

    public String getMediationAdapterClassName() {
        return this.zzlE.zzlW != null ? this.zzlE.zzlW.zzsN : null;
    }

    public boolean isReady() {
        zzx.zzbd("isLoaded must be called on the main UI thread.");
        return this.zzlE.zzlQ == null && this.zzlE.zzlU == null && this.zzlE.zzlW != null;
    }

    public void onAdClicked() {
        recordClick();
    }

    public void onAppEvent(String name, String info) {
        if (this.zzlE.zzlZ != null) {
            try {
                this.zzlE.zzlZ.onAppEvent(name, info);
            } catch (Throwable e) {
                zzhx.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzx.zzbd("pause must be called on the main UI thread.");
        if (this.zzlE.zzlW != null && this.zzlE.zzmj == 0) {
            zzab.zzaO().zza(this.zzlE.zzlW.zzuq.getWebView());
        }
        if (!(this.zzlE.zzlW == null || this.zzlE.zzlW.zzsM == null)) {
            try {
                this.zzlE.zzlW.zzsM.pause();
            } catch (RemoteException e) {
                zzhx.zzac("Could not pause mediation adapter.");
            }
        }
        this.zzlG.zzf(this.zzlE.zzlW);
        this.zzlF.pause();
    }

    public void recordClick() {
        if (this.zzlE.zzlW == null) {
            zzhx.zzac("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzhx.zzY("Pinging click URLs.");
        this.zzlE.zzlY.zzdY();
        if (this.zzlE.zzlW.zzst != null) {
            zzab.zzaM().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, zzb(this.zzlE.zzlW.zzst));
        }
        if (!(this.zzlE.zzlW.zzyt == null || this.zzlE.zzlW.zzyt.zzst == null)) {
            zzab.zzaV().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, this.zzlE.zzlW, this.zzlE.zzlM, false, zzb(this.zzlE.zzlW.zzyt.zzst));
        }
        if (this.zzlE.zzlR != null) {
            try {
                this.zzlE.zzlR.onAdClicked();
            } catch (Throwable e) {
                zzhx.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void recordImpression() {
        zze(false);
    }

    public void resume() {
        zzx.zzbd("resume must be called on the main UI thread.");
        if (this.zzlE.zzlW != null && this.zzlE.zzmj == 0) {
            zzab.zzaO().zzb(this.zzlE.zzlW.zzuq.getWebView());
        }
        if (!(this.zzlE.zzlW == null || this.zzlE.zzlW.zzsM == null)) {
            try {
                this.zzlE.zzlW.zzsM.resume();
            } catch (RemoteException e) {
                zzhx.zzac("Could not resume mediation adapter.");
            }
        }
        this.zzlF.resume();
        this.zzlG.zzg(this.zzlE.zzlW);
    }

    public void showInterstitial() {
        zzx.zzbd("showInterstitial must be called on the main UI thread.");
        if (!this.zzlE.zzlV.zzpb) {
            zzhx.zzac("Cannot call showInterstitial on a banner ad.");
        } else if (this.zzlE.zzlW == null) {
            zzhx.zzac("The interstitial has not loaded.");
        } else if (this.zzlE.zzmj == 1) {
        } else {
            if (this.zzlE.zzlW.zzuq.zzeK()) {
                zzhx.zzac("The interstitial is already showing.");
                return;
            }
            this.zzlE.zzlW.zzuq.zzA(true);
            if (this.zzlE.zzlW.zzuq.zzeG().zzba() || this.zzlE.zzlW.zzys != null) {
                zzaf zza = this.zzlG.zza(this.zzlE.zzlV, this.zzlE.zzlW);
                if (this.zzlE.zzlW.zzuq.zzeG().zzba() && zza != null) {
                    zza.zza((zzac) this);
                }
            }
            if (this.zzlE.zzlW.zzwI) {
                try {
                    this.zzlE.zzlW.zzsM.showInterstitial();
                    return;
                } catch (Throwable e) {
                    zzhx.zzd("Could not show interstitial.", e);
                    zzaw();
                    return;
                }
            }
            zzx zzx = new zzx(this.zzlE.zzml, zzao());
            int requestedOrientation = this.zzlE.zzlW.zzuq.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = this.zzlE.zzlW.orientation;
            }
            zzab.zzaK().zza(this.zzlE.zzlN, new zzeo(this, this, this, this.zzlE.zzlW.zzuq, requestedOrientation, this.zzlE.zzlP, this.zzlE.zzlW.zzwN, zzx));
        }
    }

    public void stopLoading() {
        zzx.zzbd("stopLoading must be called on the main UI thread.");
        this.zzlE.zzf(true);
    }

    Bundle zza(zzan zzan) {
        if (zzan == null) {
            return null;
        }
        String zzbm;
        if (zzan.zzbx()) {
            zzan.wakeup();
        }
        zzak zzbv = zzan.zzbv();
        if (zzbv != null) {
            zzbm = zzbv.zzbm();
            zzhx.zzY("In AdManger: loadAd, " + zzbv.toString());
        } else {
            zzbm = null;
        }
        if (zzbm == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", zzbm);
        bundle.putInt("v", 1);
        return bundle;
    }

    public String zza(String str, String str2, int i) {
        return (((Boolean) zzca.zzqL.get()).booleanValue() && zzz.zzj(this.zzlE.zzlN).isInitialized() && !TextUtils.isEmpty(str)) ? Uri.parse(str).buildUpon().appendQueryParameter("ga_cid", str2).appendQueryParameter("ga_hid", String.valueOf(i)).build().toString() : str;
    }

    public void zza(int i, int i2, int i3, int i4) {
        zzar();
    }

    public void zza(zzaf zzaf, boolean z) {
        if (this.zzlE.zzlW != null && this.zzlE.zzlW.zzuq != null) {
            Map hashMap = new HashMap();
            hashMap.put("isVisible", z ? "1" : "0");
            this.zzlE.zzlW.zzuq.zzb("onAdVisibilityChanged", hashMap);
        }
    }

    public void zza(zzba zzba) {
        zzx.zzbd("setAdSize must be called on the main UI thread.");
        this.zzlE.zzlV = zzba;
        if (this.zzlE.zzlW != null && this.zzlE.zzmj == 0) {
            this.zzlE.zzlW.zzuq.zza(zzba);
        }
        if (this.zzlE.zzlS.getChildCount() > 1) {
            this.zzlE.zzlS.removeView(this.zzlE.zzlS.getNextView());
        }
        this.zzlE.zzlS.setMinimumWidth(zzba.widthPixels);
        this.zzlE.zzlS.setMinimumHeight(zzba.heightPixels);
        this.zzlE.zzlS.requestLayout();
    }

    public void zza(zzbg zzbg) {
        zzx.zzbd("setAdListener must be called on the main UI thread.");
        this.zzlE.zzlR = zzbg;
    }

    public void zza(zzbh zzbh) {
        zzx.zzbd("setAdListener must be called on the main UI thread.");
        this.zzlE.zzlT = zzbh;
    }

    public void zza(zzbk zzbk) {
        zzx.zzbd("setAppEventListener must be called on the main UI thread.");
        this.zzlE.zzlZ = zzbk;
    }

    public void zza(zzbl zzbl) {
        zzx.zzbd("setCorrelationIdProvider must be called on the main UI thread");
        this.zzlE.zzmm = zzbl;
    }

    public void zza(zzcj zzcj) {
        zzx.zzbd("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzlE.zzme = zzcj;
    }

    public void zza(zzfo zzfo) {
        zzx.zzbd("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzlE.zzmb = zzfo;
    }

    public void zza(zzfs zzfs, String str) {
        zzx.zzbd("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzlE.zzmg = new zzfl(str);
        this.zzlE.zzma = zzfs;
        if (!zzab.zzaP().zzeh() && zzfs != null) {
            new zzfd(this.zzlE.zzlN, this.zzlE.zzma, this.zzlE.zzmg).start();
        }
    }

    public void zza(com.google.android.gms.internal.zzhe.zza zza) {
        zzic zzic;
        String str = null;
        this.zzlz.zza(this.zzlA, "arf");
        this.zzlB = this.zzlz.zzcq();
        this.zzlE.zzlQ = null;
        this.zzlE.zzlX = zza;
        zza(null);
        if (zza.zzyz.zzwS) {
            zzic = null;
        } else {
            final zzu zzu = new zzu();
            zzic = zza(zzu);
            zzu.zza(new com.google.android.gms.internal.zzu.zzb(zza, zzic));
            zzic.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ zzt zzlJ;

                public boolean onTouch(View v, MotionEvent event) {
                    zzu.recordClick();
                    return false;
                }
            });
            zzic.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ zzt zzlJ;

                public void onClick(View v) {
                    zzu.recordClick();
                }
            });
        }
        if (zza.zzlV != null) {
            this.zzlE.zzlV = zza.zzlV;
        }
        if (zza.errorCode != -2) {
            zza(new zzhe(zza, zzic, null, null, null, null, null));
            return;
        }
        if (!zza.zzyz.zzwI && zza.zzyz.zzwR) {
            if (zza.zzyz.zzus != null) {
                str = Uri.parse(zza.zzyz.zzus).buildUpon().query(null).build().toString();
            }
            zzci zzcg = new zzcg(this, str, zza.zzyz.zzwG);
            try {
                if (this.zzlE.zzme != null) {
                    this.zzlE.zzmj = 1;
                    this.zzlE.zzme.zza(zzcg);
                    return;
                }
            } catch (Throwable e) {
                zzhx.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
            }
        }
        this.zzlE.zzmj = 0;
        this.zzlE.zzlU = zzab.zzaL().zza(this.zzlE.zzlN, this, zza, zzic, this.zzlD, this);
        zzhx.zzY("AdRenderer: " + this.zzlE.zzlU.getClass().getName());
    }

    public void zza(zzhe zzhe) {
        this.zzlz.zza(this.zzlB, "awr");
        this.zzlz.zza(this.zzlA, "ttc");
        this.zzlE.zzlU = null;
        boolean z = zzhe.zzyx != null;
        if (!(zzhe.errorCode == -2 || zzhe.errorCode == 3)) {
            zzab.zzaP().zzb(this.zzlE.zzax());
        }
        if (zzhe.errorCode != -1) {
            if (zza(zzhe, z)) {
                zzhx.zzY("Ad refresh scheduled.");
            }
            if (!(zzhe.errorCode != 3 || zzhe.zzyt == null || zzhe.zzyt.zzsv == null)) {
                zzhx.zzY("Pinging no fill URLs.");
                zzab.zzaV().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, zzhe, this.zzlE.zzlM, false, zzhe.zzyt.zzsv);
            }
            if (zzhe.errorCode != -2) {
                zza(zzhe.errorCode);
                return;
            }
            int i;
            int i2;
            if (!(this.zzlE.zzlV.zzpb || z || this.zzlE.zzmj != 0)) {
                if (!zzb(zzhe)) {
                    zza(0);
                    return;
                } else if (this.zzlE.zzlS != null) {
                    this.zzlE.zzlS.zzlL.zzV(zzhe.zzwN);
                }
            }
            if (!(this.zzlE.zzlW == null || this.zzlE.zzlW.zzsO == null)) {
                this.zzlE.zzlW.zzsO.zza(null);
            }
            if (zzhe.zzsO != null) {
                zzhe.zzsO.zza((zzdl) this);
            }
            this.zzlG.zzd(this.zzlE.zzlW);
            this.zzlE.zzlW = zzhe;
            this.zzlE.zzlY.zzj(zzhe.zzyv);
            this.zzlE.zzlY.zzk(zzhe.zzyw);
            this.zzlE.zzlY.zzx(this.zzlE.zzlV.zzpb);
            this.zzlE.zzlY.zzy(zzhe.zzwI);
            if (!(this.zzlE.zzlV.zzpb || z || this.zzlE.zzmj != 0)) {
                zze(false);
            }
            if (this.zzlE.zzmh == null) {
                this.zzlE.zzmh = new zzhj(this.zzlE.zzlM);
            }
            if (zzhe.zzyt != null) {
                i = zzhe.zzyt.zzsy;
                i2 = zzhe.zzyt.zzsz;
            } else {
                i2 = 0;
                i = 0;
            }
            this.zzlE.zzmh.zzg(i, i2);
            if (this.zzlE.zzmj == 0) {
                if (!(this.zzlE.zzlV.zzpb || zzhe.zzuq == null || (!zzhe.zzuq.zzeG().zzba() && zzhe.zzys == null))) {
                    zzaf zza = this.zzlG.zza(this.zzlE.zzlV, this.zzlE.zzlW);
                    if (zzhe.zzuq.zzeG().zzba() && zza != null) {
                        zza.zza((zzac) this);
                    }
                }
                if (this.zzlE.zzlW.zzuq != null) {
                    this.zzlE.zzlW.zzuq.zzeG().zzeR();
                }
                if (z) {
                    com.google.android.gms.internal.zzcn.zza zza2 = zzhe.zzyx;
                    if ((zza2 instanceof zzcm) && this.zzlE.zzmd != null) {
                        zzau();
                    } else if (!(zza2 instanceof zzcl) || this.zzlE.zzmc == null) {
                        zzhx.zzac("No matching listener for retrieved native ad template.");
                        zza(0);
                        return;
                    } else {
                        zzat();
                    }
                }
                zzas();
            } else if (!(this.zzlE.zzmi == null || zzhe.zzys == null)) {
                this.zzlG.zza(this.zzlE.zzlV, this.zzlE.zzlW, this.zzlE.zzmi);
            }
            if (zzab.zzaP().zzeg() != null) {
                zzab.zzaP().zzeg().zza(this.zzlz);
            }
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        zzfn zzfe = new zzfe(str, arrayList, this.zzlE.zzlN, this.zzlE.zzlP.zzzH);
        if (this.zzlE.zzmb == null) {
            zzhx.zzac("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!zzbe.zzbD().zzA(this.zzlE.zzlN)) {
                zzhx.zzac("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.zzlE.zzma == null) {
                zzhx.zzac("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.zzlE.zzmg == null) {
                zzhx.zzac("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.zzlE.zzmk) {
                zzhx.zzac("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.zzlE.zzmk = true;
                try {
                    if (this.zzlE.zzma.isValidPurchase(str)) {
                        zzab.zzaU().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzK, new zzfb(this.zzlE.zzlN, this.zzlE.zzmg, zzfe, this));
                        return;
                    } else {
                        this.zzlE.zzmk = false;
                        return;
                    }
                } catch (RemoteException e) {
                    zzhx.zzac("Could not start In-App purchase.");
                    this.zzlE.zzmk = false;
                    return;
                }
            }
        }
        try {
            this.zzlE.zzmb.zza(zzfe);
        } catch (RemoteException e2) {
            zzhx.zzac("Could not start In-App purchase.");
        }
    }

    public void zza(String str, boolean z, int i, final Intent intent, zzfg zzfg) {
        try {
            if (this.zzlE.zzma != null) {
                this.zzlE.zzma.zza(new zzfh(this.zzlE.zzlN, str, z, i, intent, zzfg));
            }
        } catch (RemoteException e) {
            zzhx.zzac("Fail to invoke PlayStorePurchaseListener.");
        }
        zzhw.zzzG.postDelayed(new Runnable(this) {
            final /* synthetic */ zzt zzlJ;

            public void run() {
                int zzd = zzab.zzaU().zzd(intent);
                zzab.zzaU();
                if (!(zzd != 0 || this.zzlJ.zzlE.zzlW == null || this.zzlJ.zzlE.zzlW.zzuq == null || this.zzlJ.zzlE.zzlW.zzuq.zzeF() == null)) {
                    this.zzlJ.zzlE.zzlW.zzuq.zzeF().close();
                }
                this.zzlJ.zzlE.zzmk = false;
            }
        }, 500);
    }

    public void zza(HashSet<zzhf> hashSet) {
        this.zzlE.zza(hashSet);
    }

    public void zza(List<String> list) {
        zzx.zzbd("setNativeTemplates must be called on the main UI thread.");
        this.zzlE.zzmf = list;
    }

    public boolean zza(zzax zzax) {
        zzx.zzbd("loadAd must be called on the main UI thread.");
        if (this.zzlE.zzlQ != null || this.zzlE.zzlU != null) {
            if (this.zzlC != null) {
                zzhx.zzac("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            this.zzlC = zzax;
            return false;
        } else if (this.zzlE.zzlV.zzpb && this.zzlE.zzlW != null) {
            zzhx.zzac("An interstitial is already loading. Aborting.");
            return false;
        } else if (!zzav()) {
            return false;
        } else {
            zzhx.zzaa("Starting ad request.");
            zzab();
            this.zzlA = this.zzlz.zzcq();
            if (!zzax.zzoO) {
                zzhx.zzaa("Use AdRequest.Builder.addTestDevice(\"" + zzbe.zzbD().zzz(this.zzlE.zzlN) + "\") to get test ads on this device.");
            }
            Bundle zza = zza(zzab.zzaP().zzo(this.zzlE.zzlN));
            this.zzlF.cancel();
            this.zzlE.zzmj = 0;
            com.google.android.gms.internal.zzgo.zza zza2 = zza(zzax, zza);
            this.zzlE.zzlQ = zzab.zzaI().zza(this.zzlE.zzlN, zza2, this.zzlE.zzlO, this);
            return true;
        }
    }

    boolean zza(zzhe zzhe, boolean z) {
        zzax zzax;
        int i = 0;
        if (this.zzlC != null) {
            zzax = this.zzlC;
            this.zzlC = null;
        } else {
            zzax = zzhe.zzwn;
            if (zzax.extras != null) {
                i = zzax.extras.getBoolean("_noRefresh", false);
            }
        }
        i |= z;
        if (this.zzlE.zzlV.zzpb) {
            if (this.zzlE.zzmj == 0) {
                zzab.zzaO().zza(zzhe.zzuq.getWebView());
            }
        } else if (i == 0 && this.zzlE.zzmj == 0) {
            if (zzhe.zzsx > 0) {
                this.zzlF.zza(zzax, zzhe.zzsx);
            } else if (zzhe.zzyt != null && zzhe.zzyt.zzsx > 0) {
                this.zzlF.zza(zzax, zzhe.zzyt.zzsx);
            } else if (!zzhe.zzwI && zzhe.errorCode == 2) {
                this.zzlF.zzc(zzax);
            }
        }
        return this.zzlF.zzaG();
    }

    void zzab() {
        this.zzlz = new zzcf("load_ad");
        this.zzlA = new zzce(-1, null, null);
        this.zzlB = new zzce(-1, null, null);
    }

    public zzd zzac() {
        zzx.zzbd("getAdFrame must be called on the main UI thread.");
        return zze.zzn(this.zzlE.zzlS);
    }

    public zzba zzad() {
        zzx.zzbd("getAdSize must be called on the main UI thread.");
        return this.zzlE.zzlV;
    }

    public void zzae() {
        zzaq();
    }

    public void zzaf() {
        this.zzlG.zzd(this.zzlE.zzlW);
        if (this.zzlE.zzlV.zzpb) {
            zzaw();
        }
        this.zzlH = false;
        zzap();
        this.zzlE.zzlY.zzdZ();
    }

    public void zzag() {
        if (this.zzlE.zzlV.zzpb) {
            zze(false);
        }
        this.zzlH = true;
        zzar();
    }

    public void zzah() {
        onAdClicked();
    }

    public void zzai() {
        zzaf();
    }

    public void zzaj() {
        zzae();
    }

    public void zzak() {
        zzag();
    }

    public void zzal() {
        if (this.zzlE.zzlW != null) {
            zzhx.zzac("Mediation adapter " + this.zzlE.zzlW.zzsN + " refreshed, but mediation adapters should never refresh.");
        }
        zze(true);
        zzas();
    }

    public void zzam() {
        zzap();
    }

    public void zzan() {
        zzx.zzbd("recordManualImpression must be called on the main UI thread.");
        if (this.zzlE.zzlW == null) {
            zzhx.zzac("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzhx.zzY("Pinging manual tracking URLs.");
        if (this.zzlE.zzlW.zzwK != null) {
            zzab.zzaM().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, this.zzlE.zzlW.zzwK);
        }
    }

    protected boolean zzao() {
        if (!(this.zzlE.zzlN instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.zzlE.zzlN).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public boolean zzav() {
        boolean z = true;
        if (!zzab.zzaM().zza(this.zzlE.zzlN.getPackageManager(), this.zzlE.zzlN.getPackageName(), "android.permission.INTERNET")) {
            if (!this.zzlE.zzlV.zzpb) {
                zzbe.zzbD().zza(this.zzlE.zzlS, this.zzlE.zzlV, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!zzab.zzaM().zzt(this.zzlE.zzlN)) {
            if (!this.zzlE.zzlV.zzpb) {
                zzbe.zzbD().zza(this.zzlE.zzlS, this.zzlE.zzlV, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!(z || this.zzlE.zzlV.zzpb)) {
            this.zzlE.zzlS.setVisibility(0);
        }
        return z;
    }

    public ArrayList<String> zzb(List<String> list) {
        String str = this.zzlE.zzlW.zzwD;
        int zzaF = zzz.zzj(this.zzlE.zzlN).zzaF();
        ArrayList<String> arrayList = new ArrayList();
        for (String zza : list) {
            arrayList.add(zza(zza, str, zzaF));
        }
        return arrayList;
    }

    public void zzb(View view) {
        this.zzlE.zzmi = view;
        zza(new zzhe(this.zzlE.zzlX, null, null, null, null, null, null));
    }

    public void zzb(zzax zzax) {
        ViewParent parent = this.zzlE.zzlS.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && zzab.zzaM().zzes() && !this.zzlH) {
            zza(zzax);
            return;
        }
        zzhx.zzaa("Ad is not visible. Not refreshing ad.");
        this.zzlF.zzc(zzax);
    }

    protected void zzc(View view) {
        this.zzlE.zzlS.addView(view, new LayoutParams(-2, -2));
    }

    public void zzd(boolean z) {
        this.zzlE.zzml = z;
    }
}
