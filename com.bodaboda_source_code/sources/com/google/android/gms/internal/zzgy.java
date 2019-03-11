package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@zzgi
public final class zzgy {
    zzic zzmu;
    private final Object zznh = new Object();
    public final zzcv zzxA = new C03582(this);
    private String zzxv;
    private String zzxw;
    private zzhq<zzha> zzxx = new zzhq();
    zzia<zzah> zzxy;
    public final zzcv zzxz = new C03571(this);

    /* renamed from: com.google.android.gms.internal.zzgy$1 */
    class C03571 implements zzcv {
        final /* synthetic */ zzgy zzxB;

        C03571(zzgy zzgy) {
            this.zzxB = zzgy;
        }

        public void zza(zzic zzic, Map<String, String> map) {
            synchronized (this.zzxB.zznh) {
                if (this.zzxB.zzxx.isDone()) {
                } else if (this.zzxB.zzxv.equals(map.get("request_id"))) {
                    zzha zzha = new zzha(1, map);
                    zzhx.zzac("Invalid " + zzha.getType() + " request error: " + zzha.zzdU());
                    this.zzxB.zzxx.zzb(zzha);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgy$2 */
    class C03582 implements zzcv {
        final /* synthetic */ zzgy zzxB;

        C03582(zzgy zzgy) {
            this.zzxB = zzgy;
        }

        public void zza(zzic zzic, Map<String, String> map) {
            synchronized (this.zzxB.zznh) {
                if (this.zzxB.zzxx.isDone()) {
                    return;
                }
                zzha zzha = new zzha(-2, map);
                if (this.zzxB.zzxv.equals(zzha.getRequestId())) {
                    String url = zzha.getUrl();
                    if (url == null) {
                        zzhx.zzac("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String replaceAll = url.replaceAll("%40mediation_adapters%40", zzhk.zza(zzic.getContext(), (String) map.get("check_adapters"), this.zzxB.zzxw));
                        zzha.setUrl(replaceAll);
                        zzhx.zzab("Ad request URL modified to " + replaceAll);
                    }
                    this.zzxB.zzxx.zzb(zzha);
                    return;
                }
                zzhx.zzac(zzha.getRequestId() + " ==== " + this.zzxB.zzxv);
            }
        }
    }

    public zzgy(String str, String str2) {
        this.zzxw = str2;
        this.zzxv = str;
    }

    public void zza(zzic zzic) {
        this.zzmu = zzic;
    }

    public zzia<zzah> zzdR() {
        return this.zzxy;
    }

    public Future<zzha> zzdS() {
        return this.zzxx;
    }

    public void zzdT() {
        if (this.zzmu != null) {
            this.zzmu.destroy();
            this.zzmu = null;
        }
    }

    public void zze(zzia<zzah> zzia) {
        this.zzxy = zzia;
    }
}
