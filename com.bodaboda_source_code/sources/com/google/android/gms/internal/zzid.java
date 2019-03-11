package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@zzgi
public class zzid extends WebViewClient {
    protected final zzic zzmu;
    private boolean zzng;
    private final Object zznh;
    private zzat zzoJ;
    private zzcy zzrJ;
    private zzu zzrK;
    private zzeb zzrL;
    private zzcw zzrN;
    private zzct zzry;
    private zzeh zztq;
    private zza zzvD;
    private final HashMap<String, List<zzcv>> zzzQ;
    private zzep zzzR;
    private boolean zzzS;
    private zzes zzzT;
    private final zzef zzzU;
    private boolean zzzV;
    private boolean zzzW;
    private int zzzX;

    public interface zza {
        void zza(zzic zzic, boolean z);
    }

    private class zzb implements zzcv {
        final /* synthetic */ zzid zzzZ;

        private zzb(zzid zzid) {
            this.zzzZ = zzid;
        }

        public void zza(zzic zzic, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                this.zzzZ.zzeN();
            } else if (map.keySet().contains("stop")) {
                this.zzzZ.zzeO();
            } else if (map.keySet().contains("cancel")) {
                this.zzzZ.zzeP();
            }
        }
    }

    public zzid(zzic zzic, boolean z) {
        this(zzic, z, new zzef(zzic, zzic.zzeE(), new zzbu(zzic.getContext())));
    }

    zzid(zzic zzic, boolean z, zzef zzef) {
        this.zzzQ = new HashMap();
        this.zznh = new Object();
        this.zzzS = false;
        this.zzmu = zzic;
        this.zzng = z;
        this.zzzU = zzef;
    }

    private void zzeN() {
        this.zzzX++;
        zzeQ();
    }

    private void zzeO() {
        this.zzzX--;
        zzeQ();
    }

    private void zzeP() {
        this.zzzW = true;
        zzeQ();
    }

    private static boolean zzf(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void zzg(Uri uri) {
        String path = uri.getPath();
        List<zzcv> list = (List) this.zzzQ.get(path);
        if (list != null) {
            Map zzd = zzab.zzaM().zzd(uri);
            if (zzhx.zzA(2)) {
                zzhx.zzab("Received GMSG: " + path);
                for (String path2 : zzd.keySet()) {
                    zzhx.zzab("  " + path2 + ": " + ((String) zzd.get(path2)));
                }
            }
            for (zzcv zza : list) {
                zza.zza(this.zzmu, zzd);
            }
            return;
        }
        zzhx.zzab("No GMSG handler found for GMSG: " + uri);
    }

    public final void onLoadResource(WebView webView, String url) {
        zzhx.zzab("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzg(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        this.zzzV = true;
        zzeQ();
    }

    public final void reset() {
        synchronized (this.zznh) {
            this.zzzQ.clear();
            this.zzoJ = null;
            this.zzzR = null;
            this.zzvD = null;
            this.zzry = null;
            this.zzzS = false;
            this.zzng = false;
            this.zzrN = null;
            this.zzzT = null;
            if (this.zzrL != null) {
                this.zzrL.zzm(true);
                this.zzrL = null;
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        zzhx.zzab("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzg(parse);
        } else if (this.zzzS && webView == this.zzmu && zzf(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (this.zzmu.willNotDraw()) {
                zzhx.zzac("AdWebView unable to handle URL: " + url);
            } else {
                Uri uri;
                try {
                    zzk zzeI = this.zzmu.zzeI();
                    if (zzeI != null && zzeI.zzb(parse)) {
                        parse = zzeI.zza(parse, this.zzmu.getContext());
                    }
                    uri = parse;
                } catch (zzl e) {
                    zzhx.zzac("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                if (this.zzrK == null || this.zzrK.zzaB()) {
                    zza(new zzek("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.zzrK.zzd(url);
                }
            }
        }
        return true;
    }

    public void zzC(boolean z) {
        this.zzzS = z;
    }

    public final void zza(zzek zzek) {
        zzep zzep = null;
        boolean zzeK = this.zzmu.zzeK();
        zzat zzat = (!zzeK || this.zzmu.zzad().zzpb) ? this.zzoJ : null;
        if (!zzeK) {
            zzep = this.zzzR;
        }
        zza(new zzeo(zzek, zzat, zzep, this.zzzT, this.zzmu.zzeJ()));
    }

    public void zza(zzeo zzeo) {
        boolean z = false;
        boolean zzcP = this.zzrL != null ? this.zzrL.zzcP() : false;
        zzem zzaK = zzab.zzaK();
        Context context = this.zzmu.getContext();
        if (!zzcP) {
            z = true;
        }
        zzaK.zza(context, zzeo, z);
    }

    public void zza(zza zza) {
        this.zzvD = zza;
    }

    public final void zza(String str, zzcv zzcv) {
        synchronized (this.zznh) {
            List list = (List) this.zzzQ.get(str);
            if (list == null) {
                list = new ArrayList();
                this.zzzQ.put(str, list);
            }
            list.add(zzcv);
        }
    }

    public final void zza(boolean z, int i) {
        zzat zzat = (!this.zzmu.zzeK() || this.zzmu.zzad().zzpb) ? this.zzoJ : null;
        zza(new zzeo(zzat, this.zzzR, this.zzzT, this.zzmu, z, i, this.zzmu.zzeJ()));
    }

    public final void zza(boolean z, int i, String str) {
        zzep zzep = null;
        boolean zzeK = this.zzmu.zzeK();
        zzat zzat = (!zzeK || this.zzmu.zzad().zzpb) ? this.zzoJ : null;
        if (!zzeK) {
            zzep = this.zzzR;
        }
        zza(new zzeo(zzat, zzep, this.zzry, this.zzzT, this.zzmu, z, i, str, this.zzmu.zzeJ(), this.zzrN));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzeK = this.zzmu.zzeK();
        zzat zzat = (!zzeK || this.zzmu.zzad().zzpb) ? this.zzoJ : null;
        zza(new zzeo(zzat, zzeK ? null : this.zzzR, this.zzry, this.zzzT, this.zzmu, z, i, str, str2, this.zzmu.zzeJ(), this.zzrN));
    }

    public void zzb(int i, int i2) {
        this.zzzU.zzf(i, i2);
        if (this.zzrL != null) {
            this.zzrL.zzb(i, i2);
        }
    }

    public void zzb(zzat zzat, zzep zzep, zzct zzct, zzes zzes, boolean z, zzcw zzcw, zzcy zzcy, zzu zzu, zzeh zzeh) {
        if (zzu == null) {
            zzu = new zzu(false);
        }
        this.zzrL = new zzeb(this.zzmu, zzeh);
        zza("/appEvent", new zzcs(zzct));
        zza("/canOpenURLs", zzcu.zzrA);
        zza("/canOpenIntents", zzcu.zzrB);
        zza("/click", zzcu.zzrC);
        zza("/close", zzcu.zzrD);
        zza("/customClose", zzcu.zzrE);
        zza("/delayPageLoaded", new zzb());
        zza("/httpTrack", zzcu.zzrF);
        zza("/log", zzcu.zzrG);
        zza("/mraid", new zzcz(zzu, this.zzrL));
        zza("/open", new zzda(zzcw, zzu, this.zzrL));
        zza("/touch", zzcu.zzrH);
        zza("/video", zzcu.zzrI);
        if (zzcy != null) {
            zza("/setInterstitialProperties", new zzcx(zzcy));
        }
        this.zzoJ = zzat;
        this.zzzR = zzep;
        this.zzry = zzct;
        this.zzrN = zzcw;
        this.zzzT = zzes;
        this.zzrK = zzu;
        this.zztq = zzeh;
        this.zzrJ = zzcy;
        zzC(z);
    }

    public final void zzb(String str, zzcv zzcv) {
        synchronized (this.zznh) {
            List list = (List) this.zzzQ.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzcv);
        }
    }

    public boolean zzba() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzng;
        }
        return z;
    }

    public final void zzde() {
        synchronized (this.zznh) {
            this.zzzS = false;
            this.zzng = true;
            this.zzmu.zzeL();
            final zzel zzeF = this.zzmu.zzeF();
            if (zzeF != null) {
                if (zzbe.zzbD().zzeC()) {
                    zzeF.zzde();
                } else {
                    zzhw.zzzG.post(new Runnable(this) {
                        final /* synthetic */ zzid zzzZ;

                        public void run() {
                            zzeF.zzde();
                        }
                    });
                }
            }
        }
    }

    public void zze(int i, int i2) {
        if (this.zzrL != null) {
            this.zzrL.zze(i, i2);
        }
    }

    public zzu zzeM() {
        return this.zzrK;
    }

    public final void zzeQ() {
        if (this.zzvD == null) {
            return;
        }
        if ((this.zzzV && this.zzzX == 0) || this.zzzW) {
            this.zzvD.zza(this.zzmu, !this.zzzW);
            this.zzvD = null;
        }
    }

    public void zzeR() {
        if (zzba()) {
            this.zzzU.zzcV();
        }
    }
}
