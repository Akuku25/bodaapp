package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.tagmanager.zzbf;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzvg {
    private final Context mContext;
    private final zzvn zzaBP;
    Map<String, zzc<com.google.android.gms.internal.zzvl.zzc>> zzaBQ;
    private final Map<String, zzvv> zzaBR;
    private String zzaya;
    private final zzlv zzmW;

    public interface zza {
        void zza(zzvk zzvk);
    }

    static class zzc<T> {
        private T mData;
        private Status zzHb;
        private long zzaBW;

        public zzc(Status status, T t, long j) {
            this.zzHb = status;
            this.mData = t;
            this.zzaBW = j;
        }

        public void zzD(T t) {
            this.mData = t;
        }

        public void zzJ(long j) {
            this.zzaBW = j;
        }

        public void zzaO(Status status) {
            this.zzHb = status;
        }

        public long zzum() {
            return this.zzaBW;
        }
    }

    class zzb extends zzvt {
        final /* synthetic */ zzvg zzaBU;
        private final zza zzaBV;

        zzb(zzvg zzvg, zzvj zzvj, zzvh zzvh, zza zza) {
            this.zzaBU = zzvg;
            super(zzvj, zzvh);
            this.zzaBV = zza;
        }

        protected com.google.android.gms.internal.zzvt.zzb zza(zzve zzve) {
            return null;
        }

        protected void zza(zzvk zzvk) {
            com.google.android.gms.internal.zzvk.zza zzuo = zzvk.zzuo();
            this.zzaBU.zza(zzuo);
            if (zzuo.getStatus() != Status.zzNo || zzuo.zzup() != com.google.android.gms.internal.zzvk.zza.zza.NETWORK || zzuo.zzuq() == null || zzuo.zzuq().length <= 0) {
                zzbf.zzab("Response status: " + (zzuo.getStatus().isSuccess() ? "SUCCESS" : "FAILURE"));
                if (zzuo.getStatus().isSuccess()) {
                    zzbf.zzab("Response source: " + zzuo.zzup().toString());
                    zzbf.zzab("Response size: " + zzuo.zzuq().length);
                }
                this.zzaBU.zza(zzuo.zzur(), this.zzaBV);
                return;
            }
            this.zzaBU.zzaBP.zzf(zzuo.zzur().zzuj(), zzuo.zzuq());
            zzbf.zzab("Resource successfully load from Network.");
            this.zzaBV.zza(zzvk);
        }
    }

    public zzvg(Context context) {
        this(context, new HashMap(), new zzvn(context), zzlx.zzkc());
    }

    zzvg(Context context, Map<String, zzvv> map, zzvn zzvn, zzlv zzlv) {
        this.zzaya = null;
        this.zzaBQ = new HashMap();
        this.mContext = context;
        this.zzmW = zzlv;
        this.zzaBP = zzvn;
        this.zzaBR = map;
    }

    private void zza(zzvj zzvj, zza zza) {
        boolean z = true;
        List zzun = zzvj.zzun();
        if (zzun.size() != 1) {
            z = false;
        }
        zzx.zzO(z);
        zza((zzve) zzun.get(0), zza);
    }

    void zza(final zzve zzve, final zza zza) {
        this.zzaBP.zza(zzve.zzuj(), zzve.zzuh(), zzvi.zzaBX, new zzvm(this) {
            final /* synthetic */ zzvg zzaBU;

            public void zza(Status status, Object obj, Integer num, long j) {
                com.google.android.gms.internal.zzvk.zza zza;
                if (status.isSuccess()) {
                    zza = new com.google.android.gms.internal.zzvk.zza(Status.zzNo, zzve, null, (com.google.android.gms.internal.zzvl.zzc) obj, num == zzvn.zzaCx ? com.google.android.gms.internal.zzvk.zza.zza.DEFAULT : com.google.android.gms.internal.zzvk.zza.zza.DISK, j);
                } else {
                    zza = new com.google.android.gms.internal.zzvk.zza(new Status(16, "There is no valid resource for the container: " + zzve.getContainerId()), null, com.google.android.gms.internal.zzvk.zza.zza.DISK);
                }
                zza.zza(new zzvk(zza));
            }
        });
    }

    void zza(zzvj zzvj, zza zza, zzvt zzvt) {
        Object obj = null;
        for (zzve zzve : zzvj.zzun()) {
            zzc zzc = (zzc) this.zzaBQ.get(zzve.getContainerId());
            obj = (zzc != null ? zzc.zzum() : this.zzaBP.zzdD(zzve.getContainerId())) + 900000 < this.zzmW.currentTimeMillis() ? 1 : obj;
        }
        if (obj != null) {
            zzvv zzvv;
            zzvv zzvv2 = (zzvv) this.zzaBR.get(zzvj.getId());
            if (zzvv2 == null) {
                zzvv2 = this.zzaya == null ? new zzvv() : new zzvv(this.zzaya);
                this.zzaBR.put(zzvj.getId(), zzvv2);
                zzvv = zzvv2;
            } else {
                zzvv = zzvv2;
            }
            zzvv.zza(this.mContext, zzvj, 0, zzvt);
            return;
        }
        zza(zzvj, zza);
    }

    void zza(com.google.android.gms.internal.zzvk.zza zza) {
        String containerId = zza.zzur().getContainerId();
        Status status = zza.getStatus();
        com.google.android.gms.internal.zzvl.zzc zzus = zza.zzus();
        if (this.zzaBQ.containsKey(containerId)) {
            zzc zzc = (zzc) this.zzaBQ.get(containerId);
            zzc.zzJ(this.zzmW.currentTimeMillis());
            if (status == Status.zzNo) {
                zzc.zzaO(status);
                zzc.zzD(zzus);
                return;
            }
            return;
        }
        this.zzaBQ.put(containerId, new zzc(status, zzus, this.zzmW.currentTimeMillis()));
    }

    public void zza(String str, Integer num, String str2, zza zza) {
        zzvj zzb = new zzvj().zzb(new zzve(str, num, str2, false));
        zza(zzb, zza, new zzb(this, zzb, zzvi.zzaBX, zza));
    }

    public void zzdx(String str) {
        this.zzaya = str;
    }
}
