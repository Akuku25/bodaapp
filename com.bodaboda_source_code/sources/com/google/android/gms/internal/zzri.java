package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;

public final class zzri implements ActivityLifecycleCallbacks {
    private final zzre zzasy;
    private final Map<Activity, zzrh> zzasz = new ArrayMap();

    public zzri(zzre zzre) {
        zzx.zzl(zzre);
        this.zzasy = zzre;
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Bundle bundle = savedInstanceState.getBundle("com.google.android.gms.measurement.screen_view");
            if (bundle != null) {
                int i = bundle.getInt("id");
                if (i <= 0) {
                    Log.w("com.google.android.gms.measurement.internal.ActivityLifecycleTracker", "Invalid screenId in saved activity state");
                    return;
                }
                zzrh zza = zza(activity, i);
                zza.setScreenName(bundle.getString("name"));
                zza.zzgr(bundle.getInt("referrer_id"));
                zza.zzcv(bundle.getString("referrer_name"));
                zza.zzaa(bundle.getBoolean("interstitial"));
                zza.zzrh();
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.zzasz.remove(activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        if (outState != null) {
            zzrh zzrh = (zzrh) this.zzasz.get(activity);
            if (zzrh != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", zzrh.zzaF());
                bundle.putString("name", zzrh.zzre());
                bundle.putInt("referrer_id", zzrh.zzrf());
                bundle.putString("referrer_name", zzrh.zzrg());
                bundle.putBoolean("interstitial", zzrh.zzri());
                outState.putBundle("com.google.android.gms.measurement.screen_view", bundle);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        this.zzasy.zzb(zza(activity, 0), activity);
    }

    public void onActivityStopped(Activity activity) {
    }

    zzrh zza(Activity activity, int i) {
        zzx.zzl(activity);
        zzrh zzrh = (zzrh) this.zzasz.get(activity);
        if (zzrh == null) {
            zzrh = i == 0 ? new zzrh(true) : new zzrh(true, i);
            zzrh.setScreenName(activity.getClass().getCanonicalName());
            this.zzasz.put(activity, zzrh);
        }
        return zzrh;
    }
}
