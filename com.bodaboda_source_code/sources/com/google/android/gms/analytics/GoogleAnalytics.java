package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzra;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static volatile GoogleAnalytics zzEl;
    private static List<Runnable> zzEm;
    private static boolean zzEv;
    private final Context mContext;
    private final zzra zzAM;
    private final zzk zzAN;
    private final zzf zzBS;
    private String zzBa;
    private String zzBb;
    private boolean zzBs;
    private final zzy zzEn;
    private final zzaj zzEo;
    private final zzai zzEp;
    private final zzg zzEq;
    private final zza zzEr;
    private Set<zza> zzEs;
    private boolean zzEt;
    private volatile boolean zzEu;

    interface zza {
        void zzn(Activity activity);

        void zzo(Activity activity);
    }

    class zzb implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics zzEw;

        zzb(GoogleAnalytics googleAnalytics) {
            this.zzEw = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            this.zzEw.zzl(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.zzEw.zzm(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, null, zzv.zzfE(), null);
    }

    protected GoogleAnalytics(Context context, zzf thread, zzaj serviceManager, zzak proxy) {
        zzx.zzl(context);
        Context applicationContext = context.getApplicationContext();
        zzx.zzl(applicationContext);
        zzx.zzl(serviceManager);
        this.zzEn = zzy.zzfV();
        this.mContext = applicationContext;
        this.zzAM = zzra.zzaf(applicationContext);
        zzx.zzl(this.zzAM);
        this.zzEo = serviceManager;
        if (thread != null) {
            this.zzBS = thread;
        } else {
            this.zzBS = new zzx(this, proxy);
        }
        this.zzAN = new zzk(this.zzAM);
        this.zzEq = new zzg(this.zzAM);
        this.zzEp = new zzai(this.zzAM);
        this.zzEr = new zza(this.zzAM, this.zzAN);
        this.zzEs = new HashSet();
        zzgk();
    }

    public static GoogleAnalytics getInstance(Context context) {
        zzx.zzl(context);
        if (zzEl == null) {
            synchronized (GoogleAnalytics.class) {
                if (zzEl == null) {
                    zzEl = new GoogleAnalytics(context);
                    if (zzEm != null) {
                        for (Runnable run : zzEm) {
                            run.run();
                        }
                        zzEm = null;
                    }
                }
            }
        }
        return zzEl;
    }

    private Tracker zza(Tracker tracker) {
        if (this.zzBa != null) {
            tracker.set("&an", this.zzBa);
        }
        if (this.zzBb != null) {
            tracker.set("&av", this.zzBb);
        }
        return tracker;
    }

    private int zzao(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    static GoogleAnalytics zzgj() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = zzEl;
        }
        return googleAnalytics;
    }

    private void zzgk() {
        if (!zzEv) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                zzae.zzab("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                zzae.zzac("Couldn't get ApplicationInfo to load global config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    zzaa zzaa = (zzaa) new zzz(this.mContext).zzD(i);
                    if (zzaa != null) {
                        zza(zzaa);
                    }
                }
            }
        }
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.zzEo.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.zzEt) {
            application.registerActivityLifecycleCallbacks(new zzb(this));
            this.zzEt = true;
        }
    }

    public boolean getAppOptOut() {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.GET_APP_OPT_OUT);
        return this.zzEu;
    }

    public String getClientId() {
        return this.zzAN.getValue("&cid");
    }

    public Context getContext() {
        return this.mContext;
    }

    public Logger getLogger() {
        return zzae.getLogger();
    }

    public boolean isDryRunEnabled() {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.GET_DRY_RUN);
        return this.zzBs;
    }

    public Tracker newTracker(int configResId) {
        Tracker zza;
        synchronized (this) {
            this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.GET_TRACKER);
            Tracker tracker = new Tracker(this, null, null, null);
            if (configResId > 0) {
                zzam zzam = (zzam) new zzal(this.mContext).zzD(configResId);
                if (zzam != null) {
                    tracker.zza(zzam);
                }
            }
            zza = zza(tracker);
        }
        return zza;
    }

    public Tracker newTracker(String trackingId) {
        Tracker zza;
        synchronized (this) {
            this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.GET_TRACKER);
            zza = zza(new Tracker(this, trackingId, null, null));
        }
        return zza;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.zzEt) {
            zzl(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.zzEt) {
            zzm(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.SET_APP_OPT_OUT);
        this.zzEu = optOut;
        if (this.zzEu) {
            this.zzBS.zzfa();
        }
    }

    public void setDryRun(boolean dryRun) {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.SET_DRY_RUN);
        this.zzBs = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.zzEo.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.SET_LOGGER);
        zzae.setLogger(logger);
    }

    void zza(zza zza) {
        this.zzEs.add(zza);
        if (this.mContext instanceof Application) {
            enableAutoActivityReports((Application) this.mContext);
        }
    }

    void zza(zzaa zzaa) {
        zzae.zzab("Loading global config values.");
        if (zzaa.zzfZ()) {
            this.zzBa = zzaa.zzga();
            zzae.zzab("app name loaded: " + this.zzBa);
        }
        if (zzaa.zzgb()) {
            this.zzBb = zzaa.zzgc();
            zzae.zzab("app version loaded: " + this.zzBb);
        }
        if (zzaa.zzgd()) {
            int zzao = zzao(zzaa.zzge());
            if (zzao >= 0) {
                zzae.zzab("log level loaded: " + zzao);
                getLogger().setLogLevel(zzao);
            }
        }
        if (zzaa.zzgf()) {
            this.zzEo.setLocalDispatchPeriod(zzaa.zzgg());
        }
        if (zzaa.zzgh()) {
            setDryRun(zzaa.zzgi());
        }
    }

    void zzb(zza zza) {
        this.zzEs.remove(zza);
    }

    void zzfj() {
        this.zzBS.zzfj();
    }

    zzd zzgl() {
        return this.zzEo.zzE(this.mContext);
    }

    zzf zzgm() {
        return this.zzBS;
    }

    public zzai zzgn() {
        return this.zzEp;
    }

    public zzg zzgo() {
        return this.zzEq;
    }

    public zzk zzgp() {
        return this.zzAN;
    }

    public zza zzgq() {
        return this.zzEr;
    }

    void zzl(Activity activity) {
        for (zza zzn : this.zzEs) {
            zzn.zzn(activity);
        }
    }

    void zzm(Activity activity) {
        for (zza zzo : this.zzEs) {
            zzo.zzo(activity);
        }
    }

    void zzx(Map<String, String> map) {
        zzx.zzl(map);
        synchronized (this) {
            zzan.zza((Map) map, "&ul", zzan.zza(Locale.getDefault()));
            zzan.zza((Map) map, "&sr", this.zzEp);
            map.put("&_u", this.zzEn.zzfX());
            this.zzEn.zzfW();
            this.zzBS.zzx(map);
        }
    }
}
