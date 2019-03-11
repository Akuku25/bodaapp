package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;

public final class zzkq implements zzkp {

    private static class zza extends zzkn {
        private final zzb<Status> zzHa;

        public zza(zzb<Status> zzb) {
            this.zzHa = zzb;
        }

        public void zzaQ(int i) throws RemoteException {
            this.zzHa.zzd(new Status(i));
        }
    }

    public PendingResult<Status> zzc(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzkq zzQz;

            protected void zza(zzks zzks) throws RemoteException {
                ((zzku) zzks.zzjb()).zza(new zza(this));
            }
        });
    }
}
