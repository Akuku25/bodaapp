package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class zzsw implements PanoramaApi {

    private static final class zzb extends com.google.android.gms.internal.zzsu.zza {
        private final com.google.android.gms.common.api.zza.zzb<PanoramaResult> zzHa;

        public zzb(com.google.android.gms.common.api.zza.zzb<PanoramaResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzHa.zzd(new zzsy(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class zzc<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzsx> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzGR, googleApiClient);
        }

        protected abstract void zza(Context context, zzsv zzsv) throws RemoteException;

        protected final void zza(zzsx zzsx) throws RemoteException {
            zza(zzsx.getContext(), (zzsv) zzsx.zzjb());
        }
    }

    private static abstract class zza extends zzc<PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaH(x0);
        }

        protected PanoramaResult zzaH(Status status) {
            return new zzsy(status, null);
        }
    }

    private static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void zza(final Context context, zzsv zzsv, final zzsu zzsu, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            zzsv.zza(new com.google.android.gms.internal.zzsu.zza() {
                public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    zzsw.zza(context, uri);
                    zzsu.zza(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(this, client) {
            final /* synthetic */ zzsw zzaty;

            protected void zza(Context context, zzsv zzsv) throws RemoteException {
                zzsv.zza(new zzb(this), uri, null, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(this, client) {
            final /* synthetic */ zzsw zzaty;

            protected void zza(Context context, zzsv zzsv) throws RemoteException {
                zzsw.zza(context, zzsv, new zzb(this), uri, null);
            }
        });
    }
}
