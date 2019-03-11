package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class zzp implements DriveApi {

    static class zza implements DriveContentsResult {
        private final Status zzHb;
        private final DriveContents zzSa;

        public zza(Status status, DriveContents driveContents) {
            this.zzHb = status;
            this.zzSa = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.zzSa;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static class zzd implements DriveIdResult {
        private final Status zzHb;
        private final DriveId zzRX;

        public zzd(Status status, DriveId driveId) {
            this.zzHb = status;
            this.zzRX = driveId;
        }

        public DriveId getDriveId() {
            return this.zzRX;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    static class zzf implements MetadataBufferResult {
        private final Status zzHb;
        private final MetadataBuffer zzTA;
        private final boolean zzTB;

        public zzf(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzHb = status;
            this.zzTA = metadataBuffer;
            this.zzTB = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.zzTA;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    static class zzc extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<DriveIdResult> zzHa;

        public zzc(com.google.android.gms.common.api.zza.zzb<DriveIdResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzHa.zzd(new zzd(Status.zzNo, onDriveIdResponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzHa.zzd(new zzd(Status.zzNo, new zzm(onMetadataResponse.zzkU()).getDriveId()));
        }

        public void zzm(Status status) throws RemoteException {
            this.zzHa.zzd(new zzd(status, null));
        }
    }

    private static class zzh extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<DriveContentsResult> zzHa;

        public zzh(com.google.android.gms.common.api.zza.zzb<DriveContentsResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
            this.zzHa.zzd(new zza(Status.zzNo, new zzs(onContentsResponse.zzkL())));
        }

        public void zzm(Status status) throws RemoteException {
            this.zzHa.zzd(new zza(status, null));
        }
    }

    private static class zzi extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> zzHa;

        public zzi(com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.zzHa.zzd(new zzf(Status.zzNo, new MetadataBuffer(onListEntriesResponse.zzkR()), onListEntriesResponse.zzkS()));
        }

        public void zzm(Status status) throws RemoteException {
            this.zzHa.zzd(new zzf(status, null, false));
        }
    }

    static abstract class zzb extends zzq<DriveContentsResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzn(x0);
        }

        public DriveContentsResult zzn(Status status) {
            return new zza(status, null);
        }
    }

    static abstract class zze extends zzq<DriveIdResult> {
        zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzo(x0);
        }

        public DriveIdResult zzo(Status status) {
            return new zzd(status, null);
        }
    }

    static abstract class zzg extends zzq<MetadataBufferResult> {
        zzg(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzp(x0);
        }

        public MetadataBufferResult zzp(Status status) {
            return new zzf(status, null, false);
        }
    }

    static class zzj extends com.google.android.gms.drive.internal.zzq.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            setResult(status);
        }

        protected void zza(zzr zzr) {
        }
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, List<String> trackingTags) {
        return ((zzr) apiClient.zza(Drive.zzGR)).cancelPendingActions(apiClient, trackingTags);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.zza(new zze(this, apiClient) {
            final /* synthetic */ zzp zzTx;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zza(new GetMetadataRequest(DriveId.zzbu(resourceId), false), new zzc(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId zzkH = ((zzr) apiClient.zza(Drive.zzGR)).zzkH();
            return zzkH != null ? new zzv(zzkH) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzt(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzv(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new zzv(((zzr) apiClient.zza(Drive.zzGR)).zzkG());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient apiClient) {
        return zza(apiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.zza(new zzg(this, apiClient) {
                final /* synthetic */ zzp zzTx;

                protected void zza(zzr zzr) throws RemoteException {
                    zzr.zzkF().zza(new QueryRequest(query), new zzi(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, apiClient) {
            final /* synthetic */ zzp zzTx;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zza(new zzbl(this));
            }
        });
    }

    public PendingResult<DriveContentsResult> zza(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzp zzTx;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zza(new CreateContentsRequest(i), new zzh(this));
            }
        });
    }
}
