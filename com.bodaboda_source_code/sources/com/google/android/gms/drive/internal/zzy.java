package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class zzy implements DriveResource {
    protected final DriveId zzRX;

    private static class zzc implements MetadataResult {
        private final Status zzHb;
        private final Metadata zzUo;

        public zzc(Status status, Metadata metadata) {
            this.zzHb = status;
            this.zzUo = metadata;
        }

        public Metadata getMetadata() {
            return this.zzUo;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static class zza extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> zzHa;

        public zza(com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzHa.zzd(new zzf(Status.zzNo, new MetadataBuffer(onListParentsResponse.zzkT()), false));
        }

        public void zzm(Status status) throws RemoteException {
            this.zzHa.zzd(new zzf(status, null, false));
        }
    }

    private static class zzb extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<MetadataResult> zzHa;

        public zzb(com.google.android.gms.common.api.zza.zzb<MetadataResult> zzb) {
            this.zzHa = zzb;
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzHa.zzd(new zzc(Status.zzNo, new zzm(onMetadataResponse.zzkU())));
        }

        public void zzm(Status status) throws RemoteException {
            this.zzHa.zzd(new zzc(status, null));
        }
    }

    private abstract class zzd extends zzq<MetadataResult> {
        final /* synthetic */ zzy zzUm;

        private zzd(zzy zzy, GoogleApiClient googleApiClient) {
            this.zzUm = zzy;
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzt(x0);
        }

        public MetadataResult zzt(Status status) {
            return new zzc(status, null);
        }
    }

    protected zzy(DriveId driveId) {
        this.zzRX = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(this, googleApiClient) {
            final /* synthetic */ zzy zzUm;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zza(new GetMetadataRequest(this.zzUm.zzRX, z), new zzb(this));
            }
        });
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzr) apiClient.zza(Drive.zzGR)).zza(apiClient, this.zzRX, 1, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((zzr) apiClient.zza(Drive.zzGR)).zza(apiClient, this.zzRX, 1);
    }

    public DriveId getDriveId() {
        return this.zzRX;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return zza(apiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.zza(new zzg(this, apiClient) {
            final /* synthetic */ zzy zzUm;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zza(new ListParentsRequest(this.zzUm.zzRX), new zza(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzr) apiClient.zza(Drive.zzGR)).zzb(apiClient, this.zzRX, 1, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((zzr) apiClient.zza(Drive.zzGR)).zzb(apiClient, this.zzRX, 1);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else if (parentIds.isEmpty()) {
            throw new IllegalArgumentException("ParentIds must contain at least one parent.");
        } else {
            final List arrayList = new ArrayList(parentIds);
            return apiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, apiClient) {
                final /* synthetic */ zzy zzUm;

                protected void zza(zzr zzr) throws RemoteException {
                    zzr.zzkF().zza(new SetResourceParentsRequest(this.zzUm.zzRX, arrayList), new zzbl(this));
                }
            });
        }
    }

    public PendingResult<Status> trash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, apiClient) {
            final /* synthetic */ zzy zzUm;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zza(new TrashResourceRequest(this.zzUm.zzRX), new zzbl(this));
            }
        });
    }

    public PendingResult<Status> untrash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, apiClient) {
            final /* synthetic */ zzy zzUm;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zza(new UntrashResourceRequest(this.zzUm.zzRX), new zzbl(this));
            }
        });
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.zzb(new zzd(this, apiClient) {
                final /* synthetic */ zzy zzUm;

                protected void zza(zzr zzr) throws RemoteException {
                    changeSet.zzkx().setContext(zzr.getContext());
                    zzr.zzkF().zza(new UpdateMetadataRequest(this.zzUm.zzRX, changeSet.zzkx()), new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
