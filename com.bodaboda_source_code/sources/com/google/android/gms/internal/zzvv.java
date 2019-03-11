package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.tagmanager.zzbf;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzvv {
    private boolean mClosed;
    private final ScheduledExecutorService zzasc;
    private String zzaya;
    private ScheduledFuture<?> zzazR;

    public zzvv() {
        this(Executors.newSingleThreadScheduledExecutor());
    }

    public zzvv(String str) {
        this(Executors.newSingleThreadScheduledExecutor());
        this.zzaya = str;
    }

    zzvv(ScheduledExecutorService scheduledExecutorService) {
        this.zzazR = null;
        this.zzaya = null;
        this.zzasc = scheduledExecutorService;
        this.mClosed = false;
    }

    public void zza(Context context, zzvj zzvj, long j, zzvt zzvt) {
        synchronized (this) {
            zzbf.zzab("ResourceLoaderScheduler: Loading new resource.");
            if (this.zzazR != null) {
                return;
            }
            this.zzazR = this.zzasc.schedule(this.zzaya != null ? new zzvu(context, zzvj, zzvt, this.zzaya) : new zzvu(context, zzvj, zzvt), j, TimeUnit.MILLISECONDS);
        }
    }
}
