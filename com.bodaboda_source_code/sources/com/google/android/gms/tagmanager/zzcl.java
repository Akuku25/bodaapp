package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzc.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcl implements zze {
    private boolean mClosed;
    private final Context mContext;
    private final ScheduledExecutorService zzasc;
    private String zzaxT;
    private final String zzaxw;
    private zzbe<zzj> zzazN;
    private zzr zzazO;
    private final zza zzazQ;
    private ScheduledFuture<?> zzazR;

    interface zza {
        zzck zza(zzr zzr);
    }

    interface zzb {
        ScheduledExecutorService zztE();
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcl$1 */
    class C03961 implements zzb {
        final /* synthetic */ zzcl zzazS;

        C03961(zzcl zzcl) {
            this.zzazS = zzcl;
        }

        public ScheduledExecutorService zztE() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcl$2 */
    class C03972 implements zza {
        final /* synthetic */ zzcl zzazS;

        C03972(zzcl zzcl) {
            this.zzazS = zzcl;
        }

        public zzck zza(zzr zzr) {
            return new zzck(this.zzazS.mContext, this.zzazS.zzaxw, zzr);
        }
    }

    public zzcl(Context context, String str, zzr zzr) {
        this(context, str, zzr, null, null);
    }

    zzcl(Context context, String str, zzr zzr, zzb zzb, zza zza) {
        this.zzazO = zzr;
        this.mContext = context;
        this.zzaxw = str;
        if (zzb == null) {
            zzb = new C03961(this);
        }
        this.zzasc = zzb.zztE();
        if (zza == null) {
            this.zzazQ = new C03972(this);
        } else {
            this.zzazQ = zza;
        }
    }

    private zzck zzdh(String str) {
        zzck zza = this.zzazQ.zza(this.zzazO);
        zza.zza(this.zzazN);
        zza.zzcT(this.zzaxT);
        zza.zzdg(str);
        return zza;
    }

    private synchronized void zztD() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void release() {
        zztD();
        if (this.zzazR != null) {
            this.zzazR.cancel(false);
        }
        this.zzasc.shutdown();
        this.mClosed = true;
    }

    public synchronized void zza(zzbe<zzj> zzbe) {
        zztD();
        this.zzazN = zzbe;
    }

    public synchronized void zzcT(String str) {
        zztD();
        this.zzaxT = str;
    }

    public synchronized void zze(long j, String str) {
        zzbf.zzab("loadAfterDelay: containerId=" + this.zzaxw + " delay=" + j);
        zztD();
        if (this.zzazN == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.zzazR != null) {
            this.zzazR.cancel(false);
        }
        this.zzazR = this.zzasc.schedule(zzdh(str), j, TimeUnit.MILLISECONDS);
    }
}
