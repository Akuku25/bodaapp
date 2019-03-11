package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzx implements DrivePreferencesApi {

    private class zzb implements FileUploadPreferencesResult {
        private final Status zzHb;
        final /* synthetic */ zzx zzUi;
        private final FileUploadPreferences zzUk;

        private zzb(zzx zzx, Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzUi = zzx;
            this.zzHb = status;
            this.zzUk = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzUk;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private class zza extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<FileUploadPreferencesResult> zzHa;
        final /* synthetic */ zzx zzUi;

        private zza(zzx zzx, com.google.android.gms.common.api.zza.zzb<FileUploadPreferencesResult> zzb) {
            this.zzUi = zzx;
            this.zzHa = zzb;
        }

        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzHa.zzd(new zzb(Status.zzNo, onDeviceUsagePreferenceResponse.zzkN()));
        }

        public void zzm(Status status) throws RemoteException {
            this.zzHa.zzd(new zzb(status, null));
        }
    }

    private abstract class zzc extends zzq<FileUploadPreferencesResult> {
        final /* synthetic */ zzx zzUi;

        public zzc(zzx zzx, GoogleApiClient googleApiClient) {
            this.zzUi = zzx;
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzs(x0);
        }

        protected FileUploadPreferencesResult zzs(Status status) {
            return new zzb(status, null);
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.zza(new zzc(this, apiClient) {
            final /* synthetic */ zzx zzUi;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zzh(new zza(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
            return apiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, apiClient) {
                final /* synthetic */ zzx zzUi;

                protected void zza(zzr zzr) throws RemoteException {
                    zzr.zzkF().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new zzbl(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
