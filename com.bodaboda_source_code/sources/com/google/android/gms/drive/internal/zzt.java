package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.api.zze.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;

public class zzt extends zzy implements DriveFile {

    private static class zza implements DownloadProgressListener {
        private final zze<DownloadProgressListener> zzTW;

        public zza(zze<DownloadProgressListener> zze) {
            this.zzTW = zze;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            final long j = bytesDownloaded;
            final long j2 = bytesExpected;
            this.zzTW.zza(new zzb<DownloadProgressListener>(this) {
                final /* synthetic */ zza zzTZ;

                public void zza(DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((DownloadProgressListener) obj);
                }

                public void zzhX() {
                }
            });
        }
    }

    public zzt(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new zza(googleApiClient.zzf(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient apiClient, final int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            final DownloadProgressListener zza = zza(apiClient, listener);
            return apiClient.zza(new zzb(this, apiClient) {
                final /* synthetic */ zzt zzTV;

                protected void zza(zzr zzr) throws RemoteException {
                    zzr.zzkF().zza(new OpenContentsRequest(this.zzTV.getDriveId(), mode, 0), new zzbe(this, zza));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
