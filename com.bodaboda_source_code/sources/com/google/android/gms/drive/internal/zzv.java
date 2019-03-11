package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

public class zzv extends zzy implements DriveFolder {

    private static class zzc implements DriveFileResult {
        private final Status zzHb;
        private final DriveFile zzUf;

        public zzc(Status status, DriveFile driveFile) {
            this.zzHb = status;
            this.zzUf = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.zzUf;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static class zze implements DriveFolderResult {
        private final Status zzHb;
        private final DriveFolder zzUg;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzHb = status;
            this.zzUg = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.zzUg;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static class zza extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<DriveFileResult> zzHa;

        public zza(com.google.android.gms.common.api.zza.zzb<DriveFileResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzHa.zzd(new zzc(Status.zzNo, new zzt(onDriveIdResponse.getDriveId())));
        }

        public void zzm(Status status) throws RemoteException {
            this.zzHa.zzd(new zzc(status, null));
        }
    }

    private static class zzb extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<DriveFolderResult> zzHa;

        public zzb(com.google.android.gms.common.api.zza.zzb<DriveFolderResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzHa.zzd(new zze(Status.zzNo, new zzv(onDriveIdResponse.getDriveId())));
        }

        public void zzm(Status status) throws RemoteException {
            this.zzHa.zzd(new zze(status, null));
        }
    }

    static abstract class zzd extends zzq<DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzq(x0);
        }

        public DriveFileResult zzq(Status status) {
            return new zzc(status, null);
        }
    }

    static abstract class zzf extends zzq<DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzr(x0);
        }

        public DriveFolderResult zzr(Status status) {
            return new zze(status, null);
        }
    }

    public zzv(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        ExecutionOptions.zza(googleApiClient, executionOptions);
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i3 = i;
        final int i4 = i2;
        final ExecutionOptions executionOptions2 = executionOptions;
        return googleApiClient.zzb(new zzd(this, googleApiClient) {
            final /* synthetic */ zzv zzUe;

            protected void zza(zzr zzr) throws RemoteException {
                metadataChangeSet2.zzkx().setContext(zzr.getContext());
                zzr.zzkF().zza(new CreateFileRequest(this.zzUe.getDriveId(), metadataChangeSet2.zzkx(), i3, i4, executionOptions2), new zza(this));
            }
        });
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else if (!(driveContents instanceof zzs)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzks()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            i = driveContents.zzkq().getRequestId();
            driveContents.zzkr();
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return zza(googleApiClient, metadataChangeSet, i, 0, executionOptions);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    private Query zza(Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents) {
        return createFile(apiClient, changeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new ExecutionOptions.Builder().build();
        }
        if (executionOptions.zzkv() == 0) {
            return zza(apiClient, changeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.zzb(new zzf(this, apiClient) {
                final /* synthetic */ zzv zzUe;

                protected void zza(zzr zzr) throws RemoteException {
                    changeSet.zzkx().setContext(zzr.getContext());
                    zzr.zzkF().zza(new CreateFolderRequest(this.zzUe.getDriveId(), changeSet.zzkx()), new zzb(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        return new zzp().query(apiClient, zza(query));
    }
}
