package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zze<L> {
    private volatile L mListener;
    private final zza zzNk;

    private final class zza extends Handler {
        final /* synthetic */ zze zzNl;

        public zza(zze zze, Looper looper) {
            this.zzNl = zze;
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            zzx.zzO(z);
            this.zzNl.zzb((zzb) msg.obj);
        }
    }

    public interface zzb<L> {
        void zze(L l);

        void zzhX();
    }

    zze(Looper looper, L l) {
        this.zzNk = new zza(this, looper);
        this.mListener = zzx.zzb((Object) l, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzb) {
        zzx.zzb((Object) zzb, (Object) "Notifier must not be null");
        this.zzNk.sendMessage(this.zzNk.obtainMessage(1, zzb));
    }

    void zzb(zzb<? super L> zzb) {
        Object obj = this.mListener;
        if (obj == null) {
            zzb.zzhX();
            return;
        }
        try {
            zzb.zze(obj);
        } catch (RuntimeException e) {
            zzb.zzhX();
            throw e;
        }
    }
}
