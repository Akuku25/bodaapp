package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@zzgi
public abstract class zzgm extends zzhl {
    private final zzgo zzse;
    private final com.google.android.gms.internal.zzgl.zza zzwk;

    @zzgi
    public static final class zza extends zzgm {
        private final Context mContext;

        public zza(Context context, zzgo zzgo, com.google.android.gms.internal.zzgl.zza zza) {
            super(zzgo, zza);
            this.mContext = context;
        }

        public void zzdJ() {
        }

        public zzgs zzdK() {
            return zzgw.zza(this.mContext, new zzbv((String) zzca.zzql.get(), zzca.zzcb()), new zzdh(), new zzhd());
        }
    }

    @zzgi
    public static class zzb extends zzgm implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object zznh = new Object();
        private final com.google.android.gms.internal.zzgl.zza zzwk;
        protected zzgn zzwl;

        public zzb(Context context, zzgo zzgo, com.google.android.gms.internal.zzgl.zza zza) {
            super(zzgo, zza);
            this.zzwk = zza;
            this.zzwl = new zzgn(context, this, this, zzgo.zzlP.zzzJ);
            connect();
        }

        protected void connect() {
            this.zzwl.connect();
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zzwk.zzb(new zzgq(0));
        }

        public void onConnectionSuspended(int cause) {
            zzhx.zzY("Disconnected from remote ad request service.");
        }

        public void zzdJ() {
            synchronized (this.zznh) {
                if (this.zzwl.isConnected() || this.zzwl.isConnecting()) {
                    this.zzwl.disconnect();
                }
                Binder.flushPendingCommands();
            }
        }

        public zzgs zzdK() {
            zzgs zzdL;
            synchronized (this.zznh) {
                try {
                    zzdL = this.zzwl.zzdL();
                } catch (IllegalStateException e) {
                    zzdL = null;
                    return zzdL;
                } catch (DeadObjectException e2) {
                    zzdL = null;
                    return zzdL;
                }
            }
            return zzdL;
        }
    }

    public zzgm(zzgo zzgo, com.google.android.gms.internal.zzgl.zza zza) {
        this.zzse = zzgo;
        this.zzwk = zza;
    }

    static zzgq zza(zzgs zzgs, zzgo zzgo) {
        zzgq zzgq = null;
        try {
            zzgq = zzgs.zzd(zzgo);
        } catch (Throwable e) {
            zzhx.zzd("Could not fetch ad response from ad request service.", e);
            zzab.zzaP().zze(e);
        } catch (Throwable e2) {
            zzhx.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzab.zzaP().zze(e2);
        } catch (Throwable e22) {
            zzhx.zzd("Could not fetch ad response from ad request service due to an Exception.", e22);
            zzab.zzaP().zze(e22);
        } catch (Throwable e222) {
            zzab.zzaP().zze(e222);
        }
        return zzgq;
    }

    public final void onStop() {
        zzdJ();
    }

    public abstract void zzdJ();

    public abstract zzgs zzdK();

    public void zzdw() {
        try {
            zzgq zzgq;
            zzgs zzdK = zzdK();
            if (zzdK == null) {
                zzgq = new zzgq(0);
            } else {
                zzgq = zza(zzdK, this.zzse);
                if (zzgq == null) {
                    zzgq = new zzgq(0);
                }
            }
            zzdJ();
            this.zzwk.zzb(zzgq);
        } catch (Throwable th) {
            zzdJ();
        }
    }
}
