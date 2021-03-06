package com.google.android.gms.internal;

@zzgi
public abstract class zzhl {
    private final Runnable zzmG = new C01971(this);
    private volatile Thread zzzi;

    /* renamed from: com.google.android.gms.internal.zzhl$1 */
    class C01971 implements Runnable {
        final /* synthetic */ zzhl zzzj;

        C01971(zzhl zzhl) {
            this.zzzj = zzhl;
        }

        public final void run() {
            this.zzzj.zzzi = Thread.currentThread();
            this.zzzj.zzdw();
        }
    }

    public final void cancel() {
        onStop();
        if (this.zzzi != null) {
            this.zzzi.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        zzhn.zzb(this.zzmG);
    }

    public abstract void zzdw();

    public final void zzeq() {
        zzhn.zza(1, this.zzmG);
    }
}
