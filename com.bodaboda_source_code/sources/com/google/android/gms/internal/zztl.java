package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztg.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zztl extends zzk<zzte> {
    private final String zzFO;
    private final zzti zzauc;
    private final zztg zzaud = new zztg();
    private boolean zzaue = true;
    private final Object zznh = new Object();

    public zztl(Context context, Looper looper, zzti zzti, zzf zzf) {
        super(context, looper, 24, zzti, zzti, zzf);
        this.zzFO = context.getPackageName();
        this.zzauc = (zzti) zzx.zzl(zzti);
        this.zzauc.zza(this);
    }

    private void zzc(zztj zztj, zztf zztf) {
        this.zzaud.zza(zztj, zztf);
    }

    private void zzd(zztj zztj, zztf zztf) {
        try {
            zzrI();
            ((zzte) zzjb()).zza(this.zzFO, zztj, zztf);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(zztj, zztf);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            zzc(zztj, zztf);
        }
    }

    private void zzrI() {
        zzb.zzN(!this.zzaue);
        if (!this.zzaud.isEmpty()) {
            zztj zztj = null;
            try {
                List arrayList = new ArrayList();
                Iterator it = this.zzaud.zzrG().iterator();
                while (it.hasNext()) {
                    zza zza = (zza) it.next();
                    if (zza.zzatT != null) {
                        ((zzte) zzjb()).zza(this.zzFO, zza.zzatR, zzwy.zzf(zza.zzatT));
                    } else {
                        zztj zztj2;
                        if (zza.zzatR.equals(zztj)) {
                            arrayList.add(zza.zzatS);
                            zztj2 = zztj;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((zzte) zzjb()).zza(this.zzFO, zztj, arrayList);
                                arrayList.clear();
                            }
                            zztj zztj3 = zza.zzatR;
                            arrayList.add(zza.zzatS);
                            zztj2 = zztj3;
                        }
                        zztj = zztj2;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((zzte) zzjb()).zza(this.zzFO, zztj, arrayList);
                }
                this.zzaud.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
        r3 = this;
        r1 = r3.zznh;
        monitor-enter(r1);
        r0 = r3.isConnecting();	 Catch:{ all -> 0x001c }
        if (r0 != 0) goto L_0x000f;
    L_0x0009:
        r0 = r3.isConnected();	 Catch:{ all -> 0x001c }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.zzauc;	 Catch:{ all -> 0x001c }
        r2 = 1;
        r0.zzad(r2);	 Catch:{ all -> 0x001c }
        r3.connect();	 Catch:{ all -> 0x001c }
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        goto L_0x0010;
    L_0x001c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zztl.start():void");
    }

    public void stop() {
        synchronized (this.zznh) {
            this.zzauc.zzad(false);
            disconnect();
        }
    }

    void zzae(boolean z) {
        synchronized (this.zznh) {
            boolean z2 = this.zzaue;
            this.zzaue = z;
            if (z2 && !this.zzaue) {
                zzrI();
            }
        }
    }

    public void zzb(zztj zztj, zztf zztf) {
        synchronized (this.zznh) {
            if (this.zzaue) {
                zzc(zztj, zztf);
            } else {
                zzd(zztj, zztf);
            }
        }
    }

    protected String zzcF() {
        return "com.google.android.gms.playlog.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    protected zzte zzcv(IBinder iBinder) {
        return zzte.zza.zzcu(iBinder);
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzcv(iBinder);
    }
}
