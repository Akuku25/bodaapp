package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzds.zza;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzgi
public final class zzdv extends zza {
    private final MediationAdapter zzsR;

    public zzdv(MediationAdapter mediationAdapter) {
        this.zzsR = mediationAdapter;
    }

    private Bundle zza(String str, int i, String str2) throws RemoteException {
        zzhx.zzac("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.zzsR instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            zzhx.zzd("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.zzsR.onDestroy();
        } catch (Throwable th) {
            zzhx.zzd("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public zzd getView() throws RemoteException {
        if (this.zzsR instanceof MediationBannerAdapter) {
            try {
                return zze.zzn(((MediationBannerAdapter) this.zzsR).getBannerView());
            } catch (Throwable th) {
                zzhx.zzd("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationBannerAdapter: " + this.zzsR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        try {
            this.zzsR.onPause();
        } catch (Throwable th) {
            zzhx.zzd("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void resume() throws RemoteException {
        try {
            this.zzsR.onResume();
        } catch (Throwable th) {
            zzhx.zzd("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (this.zzsR instanceof MediationInterstitialAdapter) {
            zzhx.zzY("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzsR).showInterstitial();
            } catch (Throwable th) {
                zzhx.zzd("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzsR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, zzax zzax, String str, zzdt zzdt) throws RemoteException {
        zza(zzd, zzax, str, null, zzdt);
    }

    public void zza(zzd zzd, zzax zzax, String str, String str2, zzdt zzdt) throws RemoteException {
        if (this.zzsR instanceof MediationInterstitialAdapter) {
            zzhx.zzY("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzsR;
                mediationInterstitialAdapter.requestInterstitialAd((Context) zze.zzf(zzd), new zzdw(zzdt), zza(str, zzax.zzoP, str2), new zzdu(new Date(zzax.zzoL), zzax.zzoM, zzax.zzoN != null ? new HashSet(zzax.zzoN) : null, zzax.zzoT, zzax.zzoO, zzax.zzoP), zzax.zzoV != null ? zzax.zzoV.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzhx.zzd("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzsR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, zzba zzba, zzax zzax, String str, zzdt zzdt) throws RemoteException {
        zza(zzd, zzba, zzax, str, null, zzdt);
    }

    public void zza(zzd zzd, zzba zzba, zzax zzax, String str, String str2, zzdt zzdt) throws RemoteException {
        Bundle bundle = null;
        if (this.zzsR instanceof MediationBannerAdapter) {
            zzhx.zzY("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzsR;
                zzdu zzdu = new zzdu(new Date(zzax.zzoL), zzax.zzoM, zzax.zzoN != null ? new HashSet(zzax.zzoN) : null, zzax.zzoT, zzax.zzoO, zzax.zzoP);
                if (zzax.zzoV != null) {
                    bundle = zzax.zzoV.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) zze.zzf(zzd), new zzdw(zzdt), zza(str, zzax.zzoP, str2), com.google.android.gms.ads.zza.zza(zzba.width, zzba.height, zzba.zzpa), zzdu, bundle);
            } catch (Throwable th) {
                zzhx.zzd("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationBannerAdapter: " + this.zzsR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
