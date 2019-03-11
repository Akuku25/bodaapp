package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzgs.zza;
import com.google.android.gms.internal.zzia.zzb;
import com.google.android.gms.internal.zzia.zzc;
import com.google.android.gms.internal.zzia.zzd;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public final class zzgw extends zza {
    private static final Object zzmz = new Object();
    private static zzgw zzxf;
    private final Context mContext;
    private final zzdf zznr;
    private final zzhc zzxg;
    private final zzdg zzxh;
    private final zzbv zzxi;

    /* renamed from: com.google.android.gms.internal.zzgw$5 */
    class C03565 implements zzd<zzah> {
        final /* synthetic */ zzgw zzxt;

        C03565(zzgw zzgw) {
            this.zzxt = zzgw;
        }

        public /* synthetic */ void zza(Object obj) {
            zzb((zzah) obj);
        }

        public void zzb(zzah zzah) {
            zzah.zza("/log", zzcu.zzrG);
        }
    }

    zzgw(Context context, zzbv zzbv, zzdg zzdg, zzhc zzhc) {
        this.mContext = context;
        this.zzxg = zzhc;
        this.zzxh = zzdg;
        this.zzxi = zzbv;
        this.zznr = new zzdf(context.getApplicationContext() != null ? context.getApplicationContext() : context, new zzhy(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true), zzbv.zzbV(), new C03565(this), new zzc());
    }

    private static zzgq zza(Context context, zzdf zzdf, zzbv zzbv, zzdg zzdg, zzhc zzhc, zzgo zzgo) {
        zzhx.zzY("Starting ad request from service.");
        zzab.zzaP().zzb(context, zzgo.zzlP);
        zzca.zzl(context);
        final zzcf zzcf = new zzcf("load_ad");
        zzce zzcq = zzcf.zzcq();
        zzdg.init();
        zzhb zzhb = new zzhb(context);
        if (zzhb.zzyj == -1) {
            zzhx.zzY("Device is offline.");
            return new zzgq(2);
        }
        String uuid = zzgo.versionCode >= 7 ? zzgo.zzwF : UUID.randomUUID().toString();
        final zzgy zzgy = new zzgy(uuid, zzgo.applicationInfo.packageName);
        if (zzgo.zzwn.extras != null) {
            String string = zzgo.zzwn.extras.getString("_ad");
            if (string != null) {
                return zzgx.zza(context, zzgo, string);
            }
        }
        JSONObject zza = zzgx.zza(zzgo, zzhb, zzdg.zzb(250), zzbv);
        if (zzgo.versionCode < 7) {
            try {
                zza.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        if (zza == null) {
            return new zzgq(0);
        }
        final String jSONObject = zza.toString();
        zzcf.zza(zzcq, "arc");
        final zzce zzcq2 = zzcf.zzcq();
        if (((Boolean) zzca.zzqm.get()).booleanValue()) {
            final zzdf zzdf2 = zzdf;
            zzhw.zzzG.post(new Runnable() {

                /* renamed from: com.google.android.gms.internal.zzgw$1$2 */
                class C03532 implements zzia.zza {
                    final /* synthetic */ C01921 zzxp;

                    C03532(C01921 c01921) {
                        this.zzxp = c01921;
                    }

                    public void run() {
                    }
                }

                public void run() {
                    zzia zzcJ = zzdf2.zzcJ();
                    zzgy.zze(zzcJ);
                    zzcf.zza(zzcq2, "rwc");
                    final zzce zzcq = zzcf.zzcq();
                    zzcJ.zza(new zzd<zzah>(this) {
                        final /* synthetic */ C01921 zzxp;

                        public /* synthetic */ void zza(Object obj) {
                            zzb((zzah) obj);
                        }

                        public void zzb(zzah zzah) {
                            zzcf.zza(zzcq, "jsf");
                            zzah.zza("/invalidRequest", zzgy.zzxz);
                            zzah.zza("/loadAdURL", zzgy.zzxA);
                            try {
                                zzah.zzb("AFMA_buildAdURL", jSONObject);
                            } catch (Throwable e) {
                                zzhx.zzb("Error requesting an ad url", e);
                            }
                        }
                    }, new C03532(this));
                }
            });
        } else {
            final Context context2 = context;
            final zzgo zzgo2 = zzgo;
            final zzgy zzgy2 = zzgy;
            final zzcf zzcf2 = zzcf;
            final zzce zzce = zzcq2;
            final String str = jSONObject;
            final zzbv zzbv2 = zzbv;
            zzhw.zzzG.post(new Runnable() {
                public void run() {
                    zzic zza = zzab.zzaN().zza(context2, new zzba(), false, false, null, zzgo2.zzlP);
                    if (zzab.zzaP().zzem()) {
                        zza.getWebView().clearCache(true);
                    }
                    zza.setWillNotDraw(true);
                    zzgy2.zza(zza);
                    zzcf2.zza(zzce, "rwc");
                    zzid.zza zzb = zzgw.zza(str, zzcf2, zzcf2.zzcq());
                    zzid zzeG = zza.zzeG();
                    zzeG.zza("/invalidRequest", zzgy2.zzxz);
                    zzeG.zza("/loadAdURL", zzgy2.zzxA);
                    zzeG.zza("/log", zzcu.zzrG);
                    zzeG.zza(zzb);
                    zzhx.zzY("Loading the JS library.");
                    zza.loadUrl(zzbv2.zzbV());
                }
            });
        }
        zzgq zzgq;
        final zzdf zzdf3;
        try {
            zzha zzha = (zzha) zzgy.zzdS().get(10, TimeUnit.SECONDS);
            if (zzha == null) {
                zzgq = new zzgq(0);
                return zzgq;
            } else if (zzha.getErrorCode() != -2) {
                zzgq zzgq2 = new zzgq(zzha.getErrorCode());
                zzdf3 = zzdf;
                zzhw.zzzG.post(new Runnable() {

                    /* renamed from: com.google.android.gms.internal.zzgw$3$1 */
                    class C03541 implements zzd<zzah> {
                        final /* synthetic */ C01943 zzxs;

                        C03541(C01943 c01943) {
                            this.zzxs = c01943;
                        }

                        public /* synthetic */ void zza(Object obj) {
                            zzb((zzah) obj);
                        }

                        public void zzb(zzah zzah) {
                            zzah.zzb("/invalidRequest", zzgy.zzxz);
                            zzah.zzb("/loadAdURL", zzgy.zzxA);
                        }
                    }

                    public void run() {
                        zzgy.zzdT();
                        if (zzgy.zzdR() != null) {
                            zzgy.zzdR().zza(new C03541(this), new zzb());
                            zzdf3.zzb(zzgy.zzdR());
                        }
                    }
                });
                return zzgq2;
            } else {
                if (zzcf.zzcu() != null) {
                    zzcf.zza(zzcf.zzcu(), "rur");
                }
                String str2 = null;
                if (zzha.zzdW()) {
                    str2 = zzhc.zzR(zzgo.zzwo.packageName);
                }
                zzcq2 = zzcf.zzcq();
                zzgq = zza(context, zzgo.zzlP.zzzH, zzha.getUrl(), str2, zzha);
                zzcf.zza(zzcq2, "ufe");
                zzcf.zza(zzcq, "tts");
                if (zzhk.zzeg() != null) {
                    zzhk.zzeg().zza(zzcf);
                }
                zzdf3 = zzdf;
                zzhw.zzzG.post(/* anonymous class already generated */);
                return zzgq;
            }
        } catch (Exception e2) {
            zzgq = new zzgq(0);
            return zzgq;
        } finally {
            zzdf3 = zzdf;
            zzhw.zzzG.post(/* anonymous class already generated */);
        }
    }

    public static zzgq zza(Context context, String str, String str2, String str3, zzha zzha) {
        HttpURLConnection httpURLConnection;
        try {
            int responseCode;
            zzgq zzgq;
            zzgz zzgz = new zzgz();
            zzhx.zzY("AdRequestServiceImpl: Sending request: " + str2);
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                zzab.zzaM().zza(context, str, false, httpURLConnection);
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                }
                if (!(zzha == null || TextUtils.isEmpty(zzha.zzdV()))) {
                    httpURLConnection.setDoOutput(true);
                    byte[] bytes = zzha.zzdV().getBytes();
                    httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
                responseCode = httpURLConnection.getResponseCode();
                Map headerFields = httpURLConnection.getHeaderFields();
                if (responseCode < 200 || responseCode >= 300) {
                    zza(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    Object headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        zzhx.zzac("No location header to follow redirect.");
                        zzgq = new zzgq(0);
                        httpURLConnection.disconnect();
                        return zzgq;
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        zzhx.zzac("Too many redirects.");
                        zzgq = new zzgq(0);
                        httpURLConnection.disconnect();
                        return zzgq;
                    }
                    zzgz.zzh(headerFields);
                    httpURLConnection.disconnect();
                } else {
                    String url3 = url2.toString();
                    String zza = zzab.zzaM().zza(new InputStreamReader(httpURLConnection.getInputStream()));
                    zza(url3, headerFields, zza, responseCode);
                    zzgz.zza(url3, headerFields, zza);
                    zzgq = zzgz.zzi(elapsedRealtime);
                    httpURLConnection.disconnect();
                    return zzgq;
                }
            }
            zzhx.zzac("Received error HTTP response code: " + responseCode);
            zzgq = new zzgq(0);
            httpURLConnection.disconnect();
            return zzgq;
        } catch (IOException e) {
            zzhx.zzac("Error while connecting to ad server: " + e.getMessage());
            return new zzgq(2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public static zzgw zza(Context context, zzbv zzbv, zzdg zzdg, zzhc zzhc) {
        zzgw zzgw;
        synchronized (zzmz) {
            if (zzxf == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzxf = new zzgw(context, zzbv, zzdg, zzhc);
            }
            zzgw = zzxf;
        }
        return zzgw;
    }

    private static zzid.zza zza(final String str, final zzcf zzcf, final zzce zzce) {
        return new zzid.zza() {
            public void zza(zzic zzic, boolean z) {
                zzcf.zza(zzce, "jsf");
                zzcf.zzcr();
                zzic.zzb("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzhx.zzA(2)) {
            zzhx.zzab("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    zzhx.zzab("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        zzhx.zzab("      " + str32);
                    }
                }
            }
            zzhx.zzab("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzhx.zzab(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzhx.zzab("    null");
            }
            zzhx.zzab("  Response Code:\n    " + i + "\n}");
        }
    }

    public zzgq zzd(zzgo zzgo) {
        zzhk.zzd(this.mContext, zzgo.zzlP.zzzH);
        return zza(this.mContext, this.zznr, this.zzxi, this.zzxh, this.zzxg, zzgo);
    }
}
