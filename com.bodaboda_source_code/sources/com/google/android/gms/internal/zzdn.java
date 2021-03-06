package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdo.zza;

@zzgi
public final class zzdn implements zza {
    private final Context mContext;
    private final zzdr zzlD;
    private final zzax zzmH;
    private final Object zznh = new Object();
    private final zzhy zznl;
    private final String zzsC;
    private final long zzsD;
    private final zzdj zzsE;
    private final zzba zzsF;
    private zzds zzsG;
    private int zzsH = -2;

    public zzdn(Context context, String str, zzdr zzdr, zzdk zzdk, zzdj zzdj, zzax zzax, zzba zzba, zzhy zzhy) {
        this.mContext = context;
        this.zzlD = zzdr;
        this.zzsE = zzdj;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.zzsC = zzcK();
        } else {
            this.zzsC = str;
        }
        this.zzsD = zzdk.zzss != -1 ? zzdk.zzss : 10000;
        this.zzmH = zzax;
        this.zzsF = zzba;
        this.zznl = zzhy;
    }

    private void zza(long j, long j2, long j3, long j4) {
        while (this.zzsH == -2) {
            zzb(j, j2, j3, j4);
        }
    }

    private void zza(zzdm zzdm) {
        try {
            if (this.zznl.zzzJ < 4100000) {
                if (this.zzsF.zzpb) {
                    this.zzsG.zza(zze.zzn(this.mContext), this.zzmH, this.zzsE.zzsq, zzdm);
                } else {
                    this.zzsG.zza(zze.zzn(this.mContext), this.zzsF, this.zzmH, this.zzsE.zzsq, (zzdt) zzdm);
                }
            } else if (this.zzsF.zzpb) {
                this.zzsG.zza(zze.zzn(this.mContext), this.zzmH, this.zzsE.zzsq, this.zzsE.zzsk, (zzdt) zzdm);
            } else {
                this.zzsG.zza(zze.zzn(this.mContext), this.zzsF, this.zzmH, this.zzsE.zzsq, this.zzsE.zzsk, zzdm);
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not request ad from mediation adapter.", e);
            zzm(5);
        }
    }

    private void zzb(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            zzhx.zzaa("Timed out waiting for adapter.");
            this.zzsH = 3;
            return;
        }
        try {
            this.zznh.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.zzsH = -1;
        }
    }

    private String zzcK() {
        try {
            if (!TextUtils.isEmpty(this.zzsE.zzso)) {
                return this.zzlD.zzC(this.zzsE.zzso) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            zzhx.zzac("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private zzds zzcL() {
        zzhx.zzaa("Instantiating mediation adapter: " + this.zzsC);
        try {
            return this.zzlD.zzB(this.zzsC);
        } catch (Throwable e) {
            zzhx.zza("Could not instantiate mediation adapter: " + this.zzsC, e);
            return null;
        }
    }

    public void cancel() {
        synchronized (this.zznh) {
            try {
                if (this.zzsG != null) {
                    this.zzsG.destroy();
                }
            } catch (Throwable e) {
                zzhx.zzd("Could not destroy mediation adapter.", e);
            }
            this.zzsH = -1;
            this.zznh.notify();
        }
    }

    public zzdo zzb(long j, long j2) {
        zzdo zzdo;
        synchronized (this.zznh) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final zzdm zzdm = new zzdm();
            zzhw.zzzG.post(new Runnable(this) {
                final /* synthetic */ zzdn zzsJ;

                public void run() {
                    synchronized (this.zzsJ.zznh) {
                        if (this.zzsJ.zzsH != -2) {
                            return;
                        }
                        this.zzsJ.zzsG = this.zzsJ.zzcL();
                        if (this.zzsJ.zzsG == null) {
                            this.zzsJ.zzm(4);
                            return;
                        }
                        zzdm.zza(this.zzsJ);
                        this.zzsJ.zza(zzdm);
                    }
                }
            });
            zza(elapsedRealtime, this.zzsD, j, j2);
            zzdo = new zzdo(this.zzsE, this.zzsG, this.zzsC, zzdm, this.zzsH);
        }
        return zzdo;
    }

    public void zzm(int i) {
        synchronized (this.zznh) {
            this.zzsH = i;
            this.zznh.notify();
        }
    }
}
