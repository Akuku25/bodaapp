package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@zzgi
public final class zzda implements zzcv {
    private final zzu zzrK;
    private final zzeb zzrL;
    private final zzcw zzrN;

    public zzda(zzcw zzcw, zzu zzu, zzeb zzeb) {
        this.zzrN = zzcw;
        this.zzrK = zzu;
        this.zzrL = zzeb;
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzab.zzaO().zzey();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzab.zzaO().zzex();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzab.zzaO().zzez();
            }
        }
        return -1;
    }

    private void zzl(boolean z) {
        if (this.zzrL != null) {
            this.zzrL.zzm(z);
        }
    }

    public void zza(zzic zzic, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            zzhx.zzac("Action missing from an open GMSG.");
        } else if (this.zzrK == null || this.zzrK.zzaB()) {
            zzid zzeG = zzic.zzeG();
            if ("expand".equalsIgnoreCase(str)) {
                if (zzic.zzeK()) {
                    zzhx.zzac("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzl(false);
                zzeG.zza(zzc(map), zzd(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                zzl(false);
                if (str != null) {
                    zzeG.zza(zzc(map), zzd(map), str);
                } else {
                    zzeG.zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.zzrN == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.zzrN.zza(str, new ArrayList());
                } else {
                    this.zzrN.zza(str, new ArrayList(Arrays.asList(str2.split(" "))));
                }
            } else {
                zzl(true);
                zzic.zzeI();
                str = (String) map.get("u");
                zzeG.zza(new zzek((String) map.get("i"), !TextUtils.isEmpty(str) ? zzab.zzaM().zzb(zzic, str) : str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.zzrK.zzd((String) map.get("u"));
        }
    }
}
