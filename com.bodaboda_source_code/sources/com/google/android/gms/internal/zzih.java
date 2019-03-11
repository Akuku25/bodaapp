package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@zzgi
public class zzih extends zzid {
    public zzih(zzic zzic, boolean z) {
        super(zzic, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (webView instanceof zzic) {
                zzic zzic = (zzic) webView;
                zzic.zzeG().zzde();
                String str = zzic.zzad().zzpb ? (String) zzca.zzqx.get() : zzic.zzeK() ? (String) zzca.zzqw.get() : (String) zzca.zzqv.get();
                zzhx.zzab("shouldInterceptRequest(" + str + ")");
                return zzd(zzic.getContext(), this.zzmu.zzeJ().zzzH, str);
            }
            zzhx.zzac("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, url);
        } catch (IOException e) {
            zzhx.zzac("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }

    protected WebResourceResponse zzd(Context context, String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        try {
            zzab.zzaM().zza(context, str, true, httpURLConnection, true);
            httpURLConnection.addRequestProperty("Cache-Control", "max-stale=3600");
            httpURLConnection.connect();
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(zzab.zzaM().zza(new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
            return webResourceResponse;
        } finally {
            httpURLConnection.disconnect();
        }
    }
}
