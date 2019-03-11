package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

class zzbe extends zzc {
    private final zzb<DriveContentsResult> zzHa;
    private final DownloadProgressListener zzVc;

    zzbe(zzb<DriveContentsResult> zzb, DownloadProgressListener downloadProgressListener) {
        this.zzHa = zzb;
        this.zzVc = downloadProgressListener;
    }

    public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
        this.zzHa.zzd(new zza(onContentsResponse.zzkM() ? new Status(-1) : Status.zzNo, new zzs(onContentsResponse.zzkL())));
    }

    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.zzVc != null) {
            this.zzVc.onProgress(onDownloadProgressResponse.zzkO(), onDownloadProgressResponse.zzkP());
        }
    }

    public void zzm(Status status) throws RemoteException {
        this.zzHa.zzd(new zza(status, null));
    }
}
