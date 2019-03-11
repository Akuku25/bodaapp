package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzia.zzc;
import com.google.android.gms.internal.zzia.zzd;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.WeakHashMap;

@zzgi
public class zzdf {
    private final Context mContext;
    private final Object zznh;
    private final zzhy zznl;
    private final String zzrR;
    private final WeakHashMap<zzia<zzah>, Integer> zzrS;
    private zzd<zzah> zzrT;
    private zzd<zzah> zzrU;
    private zzia<zzah> zzrV;
    private zzah zzrW;
    private int zzrX;

    static class zza {
        static int zzsc = 60000;
        static int zzsd = 10000;
    }

    /* renamed from: com.google.android.gms.internal.zzdf$5 */
    class C03475 implements zzd<zzah> {
        final /* synthetic */ zzdf zzrZ;

        C03475(zzdf zzdf) {
            this.zzrZ = zzdf;
        }

        public /* synthetic */ void zza(Object obj) {
            zzb((zzah) obj);
        }

        public void zzb(zzah zzah) {
            zzah.destroy();
        }
    }

    public zzdf(Context context, zzhy zzhy, String str) {
        this.zznh = new Object();
        this.zzrX = 1;
        this.zzrR = str;
        this.mContext = context.getApplicationContext();
        this.zznl = zzhy;
        this.zzrS = new WeakHashMap();
        this.zzrT = new zzc();
        this.zzrU = new zzc();
    }

    public zzdf(Context context, zzhy zzhy, String str, zzd<zzah> zzd, zzd<zzah> zzd2) {
        this(context, zzhy, str);
        this.zzrT = zzd;
        this.zzrU = zzd2;
    }

    private void zza(final zzia<zzah> zzia) {
        this.zzrX = 2;
        this.zzrW = zza(this.mContext, this.zznl);
        this.zzrW.zza(new com.google.android.gms.internal.zzah.zza(this) {
            final /* synthetic */ zzdf zzrZ;

            /* renamed from: com.google.android.gms.internal.zzdf$1$1 */
            class C01601 extends TimerTask {
                final /* synthetic */ C03441 zzsa;

                C01601(C03441 c03441) {
                    this.zzsa = c03441;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    r4 = this;
                    r3 = 1;
                    r0 = r4.zzsa;
                    r0 = r0.zzrZ;
                    r1 = r0.zznh;
                    monitor-enter(r1);
                    r0 = r4.zzsa;	 Catch:{ all -> 0x0032 }
                    r0 = r5;	 Catch:{ all -> 0x0032 }
                    r0 = r0.getStatus();	 Catch:{ all -> 0x0032 }
                    r2 = -1;
                    if (r0 == r2) goto L_0x001f;
                L_0x0015:
                    r0 = r4.zzsa;	 Catch:{ all -> 0x0032 }
                    r0 = r5;	 Catch:{ all -> 0x0032 }
                    r0 = r0.getStatus();	 Catch:{ all -> 0x0032 }
                    if (r0 != r3) goto L_0x0021;
                L_0x001f:
                    monitor-exit(r1);	 Catch:{ all -> 0x0032 }
                L_0x0020:
                    return;
                L_0x0021:
                    r0 = r4.zzsa;	 Catch:{ all -> 0x0032 }
                    r0 = r0.zzrZ;	 Catch:{ all -> 0x0032 }
                    r2 = 1;
                    r0.zzrX = r2;	 Catch:{ all -> 0x0032 }
                    r0 = r4.zzsa;	 Catch:{ all -> 0x0032 }
                    r0 = r5;	 Catch:{ all -> 0x0032 }
                    r0.reject();	 Catch:{ all -> 0x0032 }
                    monitor-exit(r1);	 Catch:{ all -> 0x0032 }
                    goto L_0x0020;
                L_0x0032:
                    r0 = move-exception;
                    monitor-exit(r1);	 Catch:{ all -> 0x0032 }
                    throw r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdf.1.1.run():void");
                }
            }

            public void zzbk() {
                new Timer().schedule(new C01601(this), (long) zza.zzsd);
            }
        });
        this.zzrW.zza("/jsLoaded", new zzcv(this) {
            final /* synthetic */ zzdf zzrZ;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void zza(com.google.android.gms.internal.zzic r5, java.util.Map<java.lang.String, java.lang.String> r6) {
                /*
                r4 = this;
                r0 = r4.zzrZ;
                r1 = r0.zznh;
                monitor-enter(r1);
                r0 = r5;	 Catch:{ all -> 0x0065 }
                r0 = r0.getStatus();	 Catch:{ all -> 0x0065 }
                r2 = -1;
                if (r0 == r2) goto L_0x0019;
            L_0x0010:
                r0 = r5;	 Catch:{ all -> 0x0065 }
                r0 = r0.getStatus();	 Catch:{ all -> 0x0065 }
                r2 = 1;
                if (r0 != r2) goto L_0x001b;
            L_0x0019:
                monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            L_0x001a:
                return;
            L_0x001b:
                r0 = r5;	 Catch:{ all -> 0x0065 }
                r2 = r4.zzrZ;	 Catch:{ all -> 0x0065 }
                r2 = r2.zzrW;	 Catch:{ all -> 0x0065 }
                r0.zzc(r2);	 Catch:{ all -> 0x0065 }
                r0 = r5;	 Catch:{ all -> 0x0065 }
                r2 = r4.zzrZ;	 Catch:{ all -> 0x0065 }
                r2 = r2.zzrT;	 Catch:{ all -> 0x0065 }
                r3 = new com.google.android.gms.internal.zzia$zzb;	 Catch:{ all -> 0x0065 }
                r3.<init>();	 Catch:{ all -> 0x0065 }
                r0.zza(r2, r3);	 Catch:{ all -> 0x0065 }
                r0 = r4.zzrZ;	 Catch:{ all -> 0x0065 }
                r2 = 0;
                r0.zzrX = r2;	 Catch:{ all -> 0x0065 }
                r0 = r5;	 Catch:{ all -> 0x0065 }
                r2 = r4.zzrZ;	 Catch:{ all -> 0x0065 }
                r2 = r2.zzrV;	 Catch:{ all -> 0x0065 }
                if (r0 == r2) goto L_0x0051;
            L_0x0046:
                r0 = r4.zzrZ;	 Catch:{ all -> 0x0065 }
                r2 = r4.zzrZ;	 Catch:{ all -> 0x0065 }
                r2 = r2.zzrV;	 Catch:{ all -> 0x0065 }
                r0.zzd(r2);	 Catch:{ all -> 0x0065 }
            L_0x0051:
                r0 = r4.zzrZ;	 Catch:{ all -> 0x0065 }
                r2 = r5;	 Catch:{ all -> 0x0065 }
                r0.zzrV = r2;	 Catch:{ all -> 0x0065 }
                r0 = r4.zzrZ;	 Catch:{ all -> 0x0065 }
                r2 = r4.zzrZ;	 Catch:{ all -> 0x0065 }
                r2 = r2.zzrV;	 Catch:{ all -> 0x0065 }
                r0.zzc(r2);	 Catch:{ all -> 0x0065 }
                monitor-exit(r1);	 Catch:{ all -> 0x0065 }
                goto L_0x001a;
            L_0x0065:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0065 }
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdf.2.zza(com.google.android.gms.internal.zzic, java.util.Map):void");
            }
        });
        final zzhv zzhv = new zzhv();
        zzcv c03463 = new zzcv(this) {
            final /* synthetic */ zzdf zzrZ;

            public void zza(zzic zzic, Map<String, String> map) {
                synchronized (this.zzrZ.zznh) {
                    this.zzrZ.zzrX = 1;
                    zzhx.zzaa("Javascript is requesting an update");
                    this.zzrZ.zzrW.zzb("/requestReload", (zzcv) zzhv.get());
                }
            }
        };
        zzhv.set(c03463);
        this.zzrW.zza("/requestReload", c03463);
        if (this.zzrR.endsWith(".js")) {
            this.zzrW.zzf(this.zzrR);
        } else {
            this.zzrW.zzg(this.zzrR);
        }
        new Timer().schedule(new TimerTask(this) {
            final /* synthetic */ zzdf zzrZ;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r4 = this;
                r3 = 1;
                r0 = r4.zzrZ;
                r1 = r0.zznh;
                monitor-enter(r1);
                r0 = r5;	 Catch:{ all -> 0x0028 }
                r0 = r0.getStatus();	 Catch:{ all -> 0x0028 }
                r2 = -1;
                if (r0 == r2) goto L_0x0019;
            L_0x0011:
                r0 = r5;	 Catch:{ all -> 0x0028 }
                r0 = r0.getStatus();	 Catch:{ all -> 0x0028 }
                if (r0 != r3) goto L_0x001b;
            L_0x0019:
                monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            L_0x001a:
                return;
            L_0x001b:
                r0 = r4.zzrZ;	 Catch:{ all -> 0x0028 }
                r2 = 1;
                r0.zzrX = r2;	 Catch:{ all -> 0x0028 }
                r0 = r5;	 Catch:{ all -> 0x0028 }
                r0.reject();	 Catch:{ all -> 0x0028 }
                monitor-exit(r1);	 Catch:{ all -> 0x0028 }
                goto L_0x001a;
            L_0x0028:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0028 }
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdf.4.run():void");
            }
        }, (long) zza.zzsc);
    }

    protected zzah zza(Context context, zzhy zzhy) {
        return new zzaj(context, zzhy);
    }

    public void zzb(zzia<zzah> zzia) {
        synchronized (this.zznh) {
            zzd((zzia) zzia);
        }
    }

    protected void zzc(zzia<zzah> zzia) {
        synchronized (this.zznh) {
            Integer num = (Integer) this.zzrS.get(zzia);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            zzhx.zzab("Incremented use-counter for js engine.");
            this.zzrS.put(zzia, Integer.valueOf(num.intValue() + 1));
        }
    }

    public zzia<zzah> zzcJ() {
        zzia<zzah> zzib;
        synchronized (this.zznh) {
            if (this.zzrV == null || this.zzrV.getStatus() == -1) {
                zzib = new zzib();
                this.zzrV = zzib;
                zza((zzia) zzib);
                zzc((zzia) zzib);
            } else if (this.zzrX == 0) {
                zzc(this.zzrV);
                zzib = this.zzrV;
            } else if (this.zzrX == 1) {
                zza(new zzib());
                zzc(this.zzrV);
                zzib = this.zzrV;
            } else if (this.zzrX == 2) {
                zzc(this.zzrV);
                zzib = this.zzrV;
            } else {
                zzc(this.zzrV);
                zzib = this.zzrV;
            }
        }
        return zzib;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void zzd(com.google.android.gms.internal.zzia<com.google.android.gms.internal.zzah> r4) {
        /*
        r3 = this;
        r1 = r3.zznh;
        monitor-enter(r1);
        r0 = r3.zzrS;	 Catch:{ all -> 0x0031 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0031 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0013;
    L_0x000d:
        r2 = r0.intValue();	 Catch:{ all -> 0x0031 }
        if (r2 != 0) goto L_0x0015;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
    L_0x0014:
        return;
    L_0x0015:
        r0 = r0.intValue();	 Catch:{ all -> 0x0031 }
        r0 = r0 + -1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0031 }
        r2 = r0.intValue();	 Catch:{ all -> 0x0031 }
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = "Decremented use-counter for js engine.";
        com.google.android.gms.internal.zzhx.zzab(r2);	 Catch:{ all -> 0x0031 }
        r2 = r3.zzrS;	 Catch:{ all -> 0x0031 }
        r2.put(r4, r0);	 Catch:{ all -> 0x0031 }
    L_0x002f:
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        goto L_0x0014;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        throw r0;
    L_0x0034:
        r0 = "Removing js engine.";
        com.google.android.gms.internal.zzhx.zzab(r0);	 Catch:{ all -> 0x0031 }
        r0 = r3.zzrS;	 Catch:{ all -> 0x0031 }
        r0.remove(r4);	 Catch:{ all -> 0x0031 }
        r0 = r3.zzrU;	 Catch:{ all -> 0x0031 }
        r2 = new com.google.android.gms.internal.zzia$zzb;	 Catch:{ all -> 0x0031 }
        r2.<init>();	 Catch:{ all -> 0x0031 }
        r4.zza(r0, r2);	 Catch:{ all -> 0x0031 }
        r0 = new com.google.android.gms.internal.zzdf$5;	 Catch:{ all -> 0x0031 }
        r0.<init>(r3);	 Catch:{ all -> 0x0031 }
        r2 = new com.google.android.gms.internal.zzia$zzb;	 Catch:{ all -> 0x0031 }
        r2.<init>();	 Catch:{ all -> 0x0031 }
        r4.zza(r0, r2);	 Catch:{ all -> 0x0031 }
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdf.zzd(com.google.android.gms.internal.zzia):void");
    }
}
