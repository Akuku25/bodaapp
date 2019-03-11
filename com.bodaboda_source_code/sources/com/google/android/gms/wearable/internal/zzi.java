package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzi implements DataApi {

    public static class zzb implements DataItemResult {
        private final Status zzHb;
        private final DataItem zzaGc;

        public zzb(Status status, DataItem dataItem) {
            this.zzHb = status;
            this.zzaGc = dataItem;
        }

        public DataItem getDataItem() {
            return this.zzaGc;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public static class zzc implements DeleteDataItemsResult {
        private final Status zzHb;
        private final int zzaGd;

        public zzc(Status status, int i) {
            this.zzHb = status;
            this.zzaGd = i;
        }

        public int getNumDeleted() {
            return this.zzaGd;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public static class zzd implements GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzHb;
        private volatile ParcelFileDescriptor zzaGe;
        private volatile InputStream zzaGf;

        public zzd(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzHb = status;
            this.zzaGe = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzaGe;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzaGe == null) {
                return null;
            } else {
                if (this.zzaGf == null) {
                    this.zzaGf = new AutoCloseInputStream(this.zzaGe);
                }
                return this.zzaGf;
            }
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public void release() {
            if (this.zzaGe != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzaGf != null) {
                        this.zzaGf.close();
                    } else {
                        this.zzaGe.close();
                    }
                    this.mClosed = true;
                    this.zzaGe = null;
                    this.zzaGf = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private static final class zza extends zzg<Status> {
        private DataListener zzaGa;
        private IntentFilter[] zzaGb;

        private zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzaGa = dataListener;
            this.zzaGb = intentFilterArr;
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzbd zzbd) throws RemoteException {
            zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaGa, this.zzaGb);
            this.zzaGa = null;
            this.zzaGb = null;
        }

        public Status zzb(Status status) {
            this.zzaGa = null;
            this.zzaGb = null;
            return status;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, dataListener, intentFilterArr));
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return zza(client, listener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri) {
        return client.zza(new zzg<DeleteDataItemsResult>(this, client) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzaR(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zzc(this, uri);
            }

            protected DeleteDataItemsResult zzaR(Status status) {
                return new zzc(status, 0);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.zza(new zzg<DataItemResult>(this, client) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzaP(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, uri);
            }

            protected DataItemResult zzaP(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.zza(new zzg<DataItemBuffer>(this, client) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzaQ(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zzm(this);
            }

            protected DataItemBuffer zzaQ(Status status) {
                return new DataItemBuffer(DataHolder.zzay(status.getStatusCode()));
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri) {
        return client.zza(new zzg<DataItemBuffer>(this, client) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzaQ(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zzb((com.google.android.gms.common.api.zza.zzb) this, uri);
            }

            protected DataItemBuffer zzaQ(Status status) {
                return new DataItemBuffer(DataHolder.zzay(status.getStatusCode()));
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        zza(asset);
        return client.zza(new zzg<GetFdForAssetResult>(this, client) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzaS(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, asset);
            }

            protected GetFdForAssetResult zzaS(Status status) {
                return new zzd(status, null);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.zza(new zzg<GetFdForAssetResult>(this, client) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzaS(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, asset);
            }

            protected GetFdForAssetResult zzaS(Status status) {
                return new zzd(status, null);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.zza(new zzg<DataItemResult>(this, client) {
            final /* synthetic */ zzi zzaFW;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzaP(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, request);
            }

            public DataItemResult zzaP(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataListener listener) {
        return client.zza(new zzg<Status>(this, client) {
            final /* synthetic */ zzi zzaFW;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, listener);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }
}
