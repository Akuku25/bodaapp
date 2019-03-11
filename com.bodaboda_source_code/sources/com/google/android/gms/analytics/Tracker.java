package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlx;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {
    private final GoogleAnalytics zzBN;
    private final TrackerHandler zzFe;
    private final Map<String, String> zzFf = new HashMap();
    private final zzah zzFg;
    private final zza zzFh;
    private ExceptionReporter zzFi;
    private zzam zzFj;
    private final Map<String, String> zzsZ = new HashMap();

    private class zza implements zza {
        private boolean zzFk;
        private int zzFl;
        private long zzFm = -1;
        private boolean zzFn;
        private long zzFo;
        final /* synthetic */ Tracker zzFp;
        private zzlv zzmW = zzlx.zzkc();

        public zza(Tracker tracker) {
            this.zzFp = tracker;
        }

        private void zzgH() {
            if (this.zzFm >= 0 || this.zzFk) {
                this.zzFp.zzBN.zza(this.zzFp.zzFh);
            } else {
                this.zzFp.zzBN.zzb(this.zzFp.zzFh);
            }
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.zzFk = enabled;
            zzgH();
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.zzFm = sessionTimeout;
            zzgH();
        }

        public long zzgE() {
            return this.zzFm;
        }

        public boolean zzgF() {
            return this.zzFk;
        }

        public boolean zzgG() {
            boolean z = this.zzFn;
            this.zzFn = false;
            return z;
        }

        boolean zzgI() {
            return this.zzmW.elapsedRealtime() >= this.zzFo + Math.max(1000, this.zzFm);
        }

        public void zzn(Activity activity) {
            zzy.zzfV().zza(com.google.android.gms.analytics.zzy.zza.EASY_TRACKER_ACTIVITY_START);
            if (this.zzFl == 0 && zzgI()) {
                this.zzFn = true;
            }
            this.zzFl++;
            if (this.zzFk) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.zzFp.setCampaignParamsOnNextHit(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                zzy.zzfV().zzF(true);
                this.zzFp.set("&cd", this.zzFp.zzFj != null ? this.zzFp.zzFj.zzq(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    CharSequence zzp = Tracker.zzp(activity);
                    if (!TextUtils.isEmpty(zzp)) {
                        hashMap.put("&dr", zzp);
                    }
                }
                this.zzFp.send(hashMap);
                zzy.zzfV().zzF(false);
            }
        }

        public void zzo(Activity activity) {
            zzy.zzfV().zza(com.google.android.gms.analytics.zzy.zza.EASY_TRACKER_ACTIVITY_STOP);
            this.zzFl--;
            this.zzFl = Math.max(0, this.zzFl);
            if (this.zzFl == 0) {
                this.zzFo = this.zzmW.elapsedRealtime();
            }
        }
    }

    Tracker(GoogleAnalytics googleAnalytics, String trackingId, TrackerHandler handler, zzah rateLimiter) {
        zzx.zzl(googleAnalytics);
        this.zzBN = googleAnalytics;
        if (handler == null) {
            this.zzFe = googleAnalytics;
        } else {
            this.zzFe = handler;
        }
        if (trackingId != null) {
            this.zzsZ.put("&tid", trackingId);
        }
        this.zzsZ.put("useSecure", "1");
        this.zzsZ.put("&a", Integer.toString(new Random().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        if (rateLimiter == null) {
            this.zzFg = new zzad("tracking");
        } else {
            this.zzFg = rateLimiter;
        }
        this.zzFh = new zza(this);
        enableAdvertisingIdCollection(false);
    }

    private boolean zzgD() {
        return this.zzFi != null;
    }

    static String zzp(Activity activity) {
        zzx.zzl(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        CharSequence stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return !TextUtils.isEmpty(stringExtra) ? stringExtra : null;
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        if (enabled) {
            if (this.zzsZ.containsKey("&ate")) {
                this.zzsZ.remove("&ate");
            }
            if (this.zzsZ.containsKey("&adid")) {
                this.zzsZ.remove("&adid");
                return;
            }
            return;
        }
        this.zzsZ.put("&ate", null);
        this.zzsZ.put("&adid", null);
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.zzFh.enableAutoActivityTracking(enabled);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enableExceptionReporting(boolean r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.zzgD();	 Catch:{ all -> 0x0028 }
        if (r0 != r4) goto L_0x0009;
    L_0x0007:
        monitor-exit(r3);	 Catch:{ all -> 0x0028 }
    L_0x0008:
        return;
    L_0x0009:
        if (r4 == 0) goto L_0x002b;
    L_0x000b:
        r0 = r3.zzBN;	 Catch:{ all -> 0x0028 }
        r0 = r0.getContext();	 Catch:{ all -> 0x0028 }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ all -> 0x0028 }
        r2 = new com.google.android.gms.analytics.ExceptionReporter;	 Catch:{ all -> 0x0028 }
        r2.<init>(r3, r1, r0);	 Catch:{ all -> 0x0028 }
        r3.zzFi = r2;	 Catch:{ all -> 0x0028 }
        r0 = r3.zzFi;	 Catch:{ all -> 0x0028 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0028 }
        r0 = "Uncaught exceptions will be reported to Google Analytics.";
        com.google.android.gms.analytics.zzae.zzab(r0);	 Catch:{ all -> 0x0028 }
    L_0x0026:
        monitor-exit(r3);	 Catch:{ all -> 0x0028 }
        goto L_0x0008;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0028 }
        throw r0;
    L_0x002b:
        r0 = r3.zzFi;	 Catch:{ all -> 0x0028 }
        r0 = r0.zzfD();	 Catch:{ all -> 0x0028 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0028 }
        r0 = "Uncaught exceptions will not be reported to Google Analytics.";
        com.google.android.gms.analytics.zzae.zzab(r0);	 Catch:{ all -> 0x0028 }
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.Tracker.enableExceptionReporting(boolean):void");
    }

    public String get(String key) {
        zzy.zzfV().zza(com.google.android.gms.analytics.zzy.zza.GET);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.zzsZ.containsKey(key)) {
            return (String) this.zzsZ.get(key);
        }
        if (key.equals("&ul")) {
            return zzan.zza(Locale.getDefault());
        }
        zzk zzgp = this.zzBN.zzgp();
        if (zzgp.zzaj(key)) {
            return zzgp.getValue(key);
        }
        zzai zzgn = this.zzBN.zzgn();
        if (zzgn.zzaj(key)) {
            return zzgn.getValue(key);
        }
        zzg zzgo = this.zzBN.zzgo();
        return zzgo.zzaj(key) ? zzgo.getValue(key) : null;
    }

    public void send(Map<String, String> params) {
        zzy.zzfV().zza(com.google.android.gms.analytics.zzy.zza.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.zzsZ);
        if (params != null) {
            hashMap.putAll(params);
        }
        for (String str : this.zzFf.keySet()) {
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, this.zzFf.get(str));
            }
        }
        this.zzFf.clear();
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            zzae.zzac(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str2 = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str2)) {
            zzae.zzac(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str2 = "";
        }
        if (this.zzFh.zzgG()) {
            hashMap.put("&sc", "start");
        }
        String toLowerCase = str2.toLowerCase();
        if ("screenview".equals(toLowerCase) || "pageview".equals(toLowerCase) || "appview".equals(toLowerCase) || TextUtils.isEmpty(toLowerCase)) {
            int parseInt = Integer.parseInt((String) this.zzsZ.get("&a")) + 1;
            if (parseInt >= ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                parseInt = 1;
            }
            this.zzsZ.put("&a", Integer.toString(parseInt));
        }
        if (toLowerCase.equals("transaction") || toLowerCase.equals("item") || this.zzFg.zzgv()) {
            this.zzFe.zzx(hashMap);
        } else {
            zzae.zzac("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String key, String value) {
        zzx.zzb((Object) key, (Object) "Key should be non-null");
        zzy.zzfV().zza(com.google.android.gms.analytics.zzy.zza.SET);
        this.zzsZ.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", zzan.zzG(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            Object queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                Uri parse = Uri.parse("http://hostname/?" + queryParameter);
                String queryParameter2 = parse.getQueryParameter("utm_id");
                if (queryParameter2 != null) {
                    this.zzFf.put("&ci", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_campaign");
                if (queryParameter2 != null) {
                    this.zzFf.put("&cn", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_content");
                if (queryParameter2 != null) {
                    this.zzFf.put("&cc", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_medium");
                if (queryParameter2 != null) {
                    this.zzFf.put("&cm", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_source");
                if (queryParameter2 != null) {
                    this.zzFf.put("&cs", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_term");
                if (queryParameter2 != null) {
                    this.zzFf.put("&ck", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("dclid");
                if (queryParameter2 != null) {
                    this.zzFf.put("&dclid", queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("gclid");
                if (queryParameter3 != null) {
                    this.zzFf.put("&gclid", queryParameter3);
                }
            }
        }
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            zzae.zzac("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.zzFh.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", zzan.zzG(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }

    void zza(zzam zzam) {
        zzae.zzab("Loading Tracker config values.");
        this.zzFj = zzam;
        if (this.zzFj.zzgK()) {
            String zzgL = this.zzFj.zzgL();
            set("&tid", zzgL);
            zzae.zzab("[Tracker] trackingId loaded: " + zzgL);
        }
        if (this.zzFj.zzgM()) {
            zzgL = Double.toString(this.zzFj.zzgN());
            set("&sf", zzgL);
            zzae.zzab("[Tracker] sample frequency loaded: " + zzgL);
        }
        if (this.zzFj.zzgO()) {
            setSessionTimeout((long) this.zzFj.getSessionTimeout());
            zzae.zzab("[Tracker] session timeout loaded: " + zzgE());
        }
        if (this.zzFj.zzgP()) {
            enableAutoActivityTracking(this.zzFj.zzgQ());
            zzae.zzab("[Tracker] auto activity tracking loaded: " + zzgF());
        }
        if (this.zzFj.zzgR()) {
            if (this.zzFj.zzgS()) {
                set("&aip", "1");
                zzae.zzab("[Tracker] anonymize ip loaded: true");
            }
            zzae.zzab("[Tracker] anonymize ip loaded: false");
        }
        enableExceptionReporting(this.zzFj.zzgT());
    }

    long zzgE() {
        return this.zzFh.zzgE();
    }

    boolean zzgF() {
        return this.zzFh.zzgF();
    }
}
