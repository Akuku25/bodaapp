package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

public class zzh implements zzr {
    private final Context mContext;
    private final HttpClient zzBe;
    private URL zzBf;
    private int zzBg;
    private int zzBh;
    private int zzBi;
    private String zzBj;
    private String zzBk;
    private zzi zzBl;
    private zzl zzBm;
    private Set<Integer> zzBn = new HashSet();
    private boolean zzBo = false;
    private long zzBp;
    private long zzBq;
    private zzo zzBr;
    private volatile boolean zzBs = false;
    private final String zzyW;

    zzh(HttpClient httpClient, Context context, zzo zzo) {
        this.mContext = context.getApplicationContext();
        this.zzBr = zzo;
        this.zzyW = zza("GoogleAnalytics", "4.0.6", VERSION.RELEASE, zzan.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzBe = httpClient;
    }

    private String zza(zzab zzab, List<String> list, zzi zzi) {
        if (zzi == zzi.NONE) {
            CharSequence zzgr = (zzab.zzgr() == null || zzab.zzgr().length() == 0) ? "" : zzab.zzgr();
            return TextUtils.isEmpty(zzgr) ? "" : zzac.zza(zzab, System.currentTimeMillis());
        } else {
            String str = "";
            for (String str2 : list) {
                if (str2.length() != 0) {
                    if (str.length() != 0) {
                        str = str + "\n";
                    }
                    str = str + str2;
                }
            }
            return str;
        }
    }

    private URL zza(zzab zzab) {
        if (this.zzBf != null) {
            return this.zzBf;
        }
        try {
            return new URL("http:".equals(zzab.zzgu()) ? "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect");
        } catch (MalformedURLException e) {
            zzae.zzZ("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
    }

    private void zza(zzaf zzaf, HttpHost httpHost, zzi zzi, zzl zzl) {
        zzaf.zzk("_bs", zzi.toString());
        zzaf.zzk("_cs", zzl.toString());
        Object zzgx = zzaf.zzgx();
        if (!TextUtils.isEmpty(zzgx)) {
            HttpHost httpHost2;
            if (httpHost == null) {
                try {
                    URL url = new URL("https://ssl.google-analytics.com");
                    httpHost2 = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
                } catch (MalformedURLException e) {
                    return;
                }
            }
            httpHost2 = httpHost;
            zza(zzgx, httpHost2, 1, zzaf, zzl.NONE);
        }
    }

    private void zza(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                zzae.zzac("Error Writing hit to log...");
            }
        }
        zzae.zzaa(stringBuffer.toString());
    }

    private boolean zza(String str, HttpHost httpHost, int i, zzaf zzaf, zzl zzl) {
        boolean z = i > 1;
        if (str.getBytes().length > this.zzBi || str.getBytes().length > this.zzBh) {
            zzae.zzac("Request too long (> " + Math.min(this.zzBh, this.zzBi) + " bytes)--not sent");
            return true;
        } else if (this.zzBs) {
            zzae.zzaa("Dry run enabled. Hit not actually sent.");
            return true;
        } else {
            HttpEntityEnclosingRequest zzc = zzc(str, z);
            if (zzc == null) {
                return true;
            }
            int length;
            int length2;
            if (zzc.getRequestLine().getMethod().equals("GET")) {
                length = str.getBytes().length;
                length2 = str.getBytes().length;
            } else {
                try {
                    switch (zzl) {
                        case GZIP:
                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(str.getBytes());
                            gZIPOutputStream.close();
                            byte[] toByteArray = byteArrayOutputStream.toByteArray();
                            length2 = toByteArray.length + 0;
                            zzc.setEntity(new ByteArrayEntity(toByteArray));
                            zzc.addHeader("Content-Encoding", "gzip");
                            break;
                        default:
                            length2 = str.getBytes().length;
                            zzc.setEntity(new StringEntity(str));
                            break;
                    }
                    length = str.getBytes().length;
                } catch (UnsupportedEncodingException e) {
                    zzae.zzZ("Encoding error, hit will be discarded");
                    return true;
                } catch (IOException e2) {
                    zzae.zzZ("Unexpected IOException: " + e2.getMessage());
                    zzae.zzZ("Request will be discarded");
                    return true;
                }
            }
            zzc.addHeader("Host", httpHost.toHostString());
            if (zzae.zzgw()) {
                zza(zzc);
            }
            try {
                HttpResponse execute = this.zzBe.execute(httpHost, zzc);
                zzaf.zze("_td", length);
                zzaf.zze("_cd", length2);
                length2 = execute.getStatusLine().getStatusCode();
                HttpEntity entity = execute.getEntity();
                if (entity != null) {
                    entity.consumeContent();
                }
                if (length2 == 200) {
                    return true;
                }
                if (z && this.zzBn.contains(Integer.valueOf(length2))) {
                    zzae.zzaa("Falling back to single hit per request mode.");
                    this.zzBo = true;
                    this.zzBp = System.currentTimeMillis();
                    return false;
                }
                zzae.zzac("Bad response: " + execute.getStatusLine().getStatusCode());
                return true;
            } catch (ClientProtocolException e3) {
                zzae.zzac("ClientProtocolException sending hit; discarding hit...");
                return true;
            } catch (IOException e22) {
                zzae.zzac("Exception sending hit: " + e22.getClass().getSimpleName());
                zzae.zzac(e22.getMessage());
                return false;
            }
        }
    }

    private HttpEntityEnclosingRequest zzc(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            System.out.println("Empty hit, discarding.");
            return null;
        }
        String str2 = this.zzBj + "?" + str;
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest = (str2.length() >= this.zzBg || z) ? z ? new BasicHttpEntityEnclosingRequest("POST", this.zzBk) : new BasicHttpEntityEnclosingRequest("POST", this.zzBj) : new BasicHttpEntityEnclosingRequest("GET", str2);
        basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.zzyW);
        return basicHttpEntityEnclosingRequest;
    }

    public void setDryRun(boolean dryRun) {
        this.zzBs = dryRun;
    }

    int zza(List<zzab> list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        if (i > list.size()) {
            i = list.size();
        }
        int i2 = i - 1;
        long j = 0;
        int i3 = i;
        while (i2 > 0) {
            int i4;
            zzab zzab = (zzab) list.get(i2);
            long zzgt = ((zzab) list.get(i2 - 1)).zzgt();
            long zzgt2 = zzab.zzgt();
            if (zzgt == 0 || zzgt2 == 0 || zzgt2 - zzgt <= j) {
                zzgt2 = j;
                i4 = i3;
            } else {
                zzgt2 -= zzgt;
                i4 = i2;
            }
            i2--;
            i3 = i4;
            j = zzgt2;
        }
        return i3;
    }

    public int zza(List<zzab> list, zzaf zzaf, boolean z) {
        zzl zzl;
        zzi zzi;
        zzab zzab;
        int i;
        int i2;
        String str;
        List subList;
        HttpHost httpHost;
        int i3;
        URL zza;
        int max;
        this.zzBg = this.zzBr.zzfl();
        this.zzBh = this.zzBr.zzfm();
        this.zzBi = this.zzBr.zzfn();
        int zzfo = this.zzBr.zzfo();
        this.zzBj = this.zzBr.zzfq();
        this.zzBk = this.zzBr.zzfr();
        this.zzBl = this.zzBr.zzfs();
        this.zzBm = this.zzBr.zzft();
        this.zzBn.clear();
        this.zzBn.addAll(this.zzBr.zzfu());
        this.zzBq = this.zzBr.zzfp();
        if (!this.zzBo && this.zzBn.isEmpty()) {
            this.zzBo = true;
            this.zzBp = System.currentTimeMillis();
        }
        if (this.zzBo && System.currentTimeMillis() - this.zzBp > 1000 * this.zzBq) {
            this.zzBo = false;
        }
        zzi zzi2;
        if (this.zzBo) {
            zzi2 = zzi.NONE;
            zzl = zzl.NONE;
            zzi = zzi2;
        } else {
            zzi2 = this.zzBl;
            zzl = this.zzBm;
            zzi = zzi2;
        }
        int i4 = 0;
        int min = Math.min(list.size(), zzfo);
        zzaf.zze("_hr", list.size());
        long currentTimeMillis = System.currentTimeMillis();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        long j = 0;
        if (zzi != zzi.NONE) {
            zzfo = 0;
            for (zzab zzab2 : list) {
                Object zza2 = TextUtils.isEmpty(zzab2.zzgr()) ? "" : zzac.zza(zzab2, currentTimeMillis);
                if (zza2.getBytes().length > this.zzBh) {
                    zza2 = "";
                }
                arrayList.add(zza2);
                if (!TextUtils.isEmpty(zza2)) {
                    j += (long) ((zzfo == 0 ? 0 : 1) + zza2.getBytes().length);
                }
                arrayList2.add(Long.valueOf(j));
                i = j <= ((long) this.zzBi) ? zzfo + 1 : zzfo;
                if (i == min) {
                    zzfo = i;
                    i2 = 1;
                    break;
                }
                zzfo = i;
            }
            i2 = 1;
        } else {
            zzfo = 0;
            i2 = min;
        }
        while (zzfo > 1 && ((Long) arrayList2.get(zzfo - 1)).longValue() > ((long) this.zzBi)) {
            zzfo--;
        }
        if (j > ((long) this.zzBi)) {
            switch (zzi) {
                case BATCH_BY_COUNT:
                    i = arrayList.size() / 2;
                    if (zzfo <= i) {
                        i = zzfo;
                        break;
                    }
                    break;
                case BATCH_BY_TIME:
                    i = zza(list, zzfo);
                    break;
                case BATCH_BY_SESSION:
                    i = zzb(list, zzfo);
                    break;
                case BATCH_BY_SIZE:
                    if (j >= ((long) (this.zzBi * 2))) {
                        i = zzfo;
                        break;
                    }
                    zzfo = arrayList2.size() - 1;
                    while (zzfo > 0 && ((Long) arrayList2.get(zzfo)).longValue() > j / 2) {
                        zzfo--;
                    }
                    i = zzfo;
                    break;
                case BATCH_BY_BRUTE_FORCE:
                    i = zzfo;
                    break;
                default:
                    zzae.zzac("Unexpected batching strategy encountered; sending a single hit.");
                    str = (String) arrayList.get(0);
                    arrayList.clear();
                    arrayList.add(str);
                    i = 1;
                    break;
            }
            if (i < arrayList.size()) {
                subList = arrayList.subList(0, i);
                min = 0;
                httpHost = null;
                i3 = 0;
                while (i3 < i2) {
                    zzab2 = (zzab) list.get(i3);
                    zza = zza(zzab2);
                    max = Math.max(1, r9.size());
                    if (zza != null) {
                        zzae.zzac("No destination: discarding hit.");
                        zzfo = min + max;
                        i = i4 + max;
                    } else {
                        httpHost = new HttpHost(zza.getHost(), zza.getPort(), zza.getProtocol());
                        if (zza(zza(zzab2, (List) r9, zzi), httpHost, max, zzaf, zzl)) {
                            zzaf.zze("_de", 1);
                            zzaf.zze("_hd", min);
                            zzaf.zze("_hs", i4);
                            zza(zzaf, httpHost, zzi, zzl);
                            return i4;
                        }
                        zzfo = min;
                        for (String str2 : r9) {
                            zzfo = TextUtils.isEmpty(str2) ? zzfo + 1 : zzfo;
                        }
                        zzaf.zze("_rs", 1);
                        i = i4 + max;
                    }
                    i3++;
                    min = zzfo;
                    i4 = i;
                }
                zzaf.zze("_hd", min);
                zzaf.zze("_hs", i4);
                if (z) {
                    zza(zzaf, httpHost, zzi, zzl);
                }
                return i4;
            }
        }
        subList = arrayList;
        min = 0;
        httpHost = null;
        i3 = 0;
        while (i3 < i2) {
            zzab2 = (zzab) list.get(i3);
            zza = zza(zzab2);
            max = Math.max(1, r9.size());
            if (zza != null) {
                httpHost = new HttpHost(zza.getHost(), zza.getPort(), zza.getProtocol());
                if (zza(zza(zzab2, (List) r9, zzi), httpHost, max, zzaf, zzl)) {
                    zzfo = min;
                    while (r6.hasNext()) {
                        if (TextUtils.isEmpty(str2)) {
                        }
                        zzfo = TextUtils.isEmpty(str2) ? zzfo + 1 : zzfo;
                    }
                    zzaf.zze("_rs", 1);
                    i = i4 + max;
                } else {
                    zzaf.zze("_de", 1);
                    zzaf.zze("_hd", min);
                    zzaf.zze("_hs", i4);
                    zza(zzaf, httpHost, zzi, zzl);
                    return i4;
                }
            }
            zzae.zzac("No destination: discarding hit.");
            zzfo = min + max;
            i = i4 + max;
            i3++;
            min = zzfo;
            i4 = i;
        }
        zzaf.zze("_hd", min);
        zzaf.zze("_hs", i4);
        if (z) {
            zza(zzaf, httpHost, zzi, zzl);
        }
        return i4;
    }

    String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    public void zzak(String str) {
        try {
            this.zzBf = new URL(str);
        } catch (MalformedURLException e) {
            this.zzBf = null;
        }
    }

    int zzb(List<zzab> list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        for (int i2 = i - 1; i2 > 0; i2--) {
            String zzgr = ((zzab) list.get(i2)).zzgr();
            if (!TextUtils.isEmpty(zzgr)) {
                if (zzgr.contains("sc=start")) {
                    return i2;
                }
                if (zzgr.contains("sc=end")) {
                    return i2 + 1;
                }
            }
        }
        return i;
    }

    public boolean zzfk() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzae.zzab("...no network connectivity");
        return false;
    }
}
