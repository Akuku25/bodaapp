package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

public class zza {

    public interface zzb<R> {
        void zzd(R r);
    }

    public static abstract class zza<R extends Result, A extends com.google.android.gms.common.api.Api.zza> extends AbstractPendingResult<R> implements zzb<R>, zzg<A> {
        private final zzc<A> zzLT;
        private AtomicReference<zze> zzLV = new AtomicReference();

        protected zza(zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(((GoogleApiClient) zzx.zzb((Object) googleApiClient, (Object) "GoogleApiClient must not be null")).getLooper());
            this.zzLT = (zzc) zzx.zzl(zzc);
        }

        private void zza(RemoteException remoteException) {
            zzk(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected void onResultConsumed() {
            zze zze = (zze) this.zzLV.getAndSet(null);
            if (zze != null) {
                zze.zzb(this);
            }
        }

        protected abstract void zza(A a) throws RemoteException;

        public void zza(zze zze) {
            this.zzLV.set(zze);
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza((com.google.android.gms.common.api.Api.zza) a);
            } catch (RemoteException e) {
                zza(e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        public /* synthetic */ void zzd(Object obj) {
            super.setResult((Result) obj);
        }

        public final zzc<A> zzhV() {
            return this.zzLT;
        }

        public int zzhW() {
            return 0;
        }

        public final void zzk(Status status) {
            zzx.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            setResult(createFailedResult(status));
        }
    }
}
