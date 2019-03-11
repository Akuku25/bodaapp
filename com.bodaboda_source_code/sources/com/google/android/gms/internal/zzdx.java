package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzds.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzgi
public final class zzdx<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzsT;
    private final NETWORK_EXTRAS zzsU;

    public zzdx(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzsT = mediationAdapter;
        this.zzsU = network_extras;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                zzhx.zzd("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.zzsT.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public void destroy() throws RemoteException {
        try {
            this.zzsT.destroy();
        } catch (Throwable th) {
            zzhx.zzd("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public zzd getView() throws RemoteException {
        if (this.zzsT instanceof MediationBannerAdapter) {
            try {
                return zze.zzn(((MediationBannerAdapter) this.zzsT).getBannerView());
            } catch (Throwable th) {
                zzhx.zzd("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationBannerAdapter: " + this.zzsT.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (this.zzsT instanceof MediationInterstitialAdapter) {
            zzhx.zzY("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzsT).showInterstitial();
            } catch (Throwable th) {
                zzhx.zzd("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzsT.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, zzax zzax, String str, zzdt zzdt) throws RemoteException {
        zza(zzd, zzax, str, null, zzdt);
    }

    public void zza(zzd zzd, zzax zzax, String str, String str2, zzdt zzdt) throws RemoteException {
        if (this.zzsT instanceof MediationInterstitialAdapter) {
            zzhx.zzY("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzsT).requestInterstitialAd(new zzdy(zzdt), (Activity) zze.zzf(zzd), zzb(str, zzax.zzoP, str2), zzdz.zzd(zzax), this.zzsU);
            } catch (Throwable th) {
                zzhx.zzd("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzsT.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, zzba zzba, zzax zzax, String str, zzdt zzdt) throws RemoteException {
        zza(zzd, zzba, zzax, str, null, zzdt);
    }

    public void zza(zzd zzd, zzba zzba, zzax zzax, String str, String str2, zzdt zzdt) throws RemoteException {
        if (this.zzsT instanceof MediationBannerAdapter) {
            zzhx.zzY("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.zzsT).requestBannerAd(new zzdy(zzdt), (Activity) zze.zzf(zzd), zzb(str, zzax.zzoP, str2), zzdz.zzb(zzba), zzdz.zzd(zzax), this.zzsU);
            } catch (Throwable th) {
                zzhx.zzd("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationBannerAdapter: " + this.zzsT.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
