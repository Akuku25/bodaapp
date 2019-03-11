package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.ArrayList;
import java.util.List;

public final class zzan implements NodeApi {

    public static class zzb implements GetConnectedNodesResult {
        private final Status zzHb;
        private final List<Node> zzaGA;

        public zzb(Status status, List<Node> list) {
            this.zzHb = status;
            this.zzaGA = list;
        }

        public List<Node> getNodes() {
            return this.zzaGA;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public static class zzc implements GetLocalNodeResult {
        private final Status zzHb;
        private final Node zzaGB;

        public zzc(Status status, Node node) {
            this.zzHb = status;
            this.zzaGB = node;
        }

        public Node getNode() {
            return this.zzaGB;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static final class zza extends zzg<Status> {
        private NodeListener zzaGz;

        private zza(GoogleApiClient googleApiClient, NodeListener nodeListener) {
            super(googleApiClient);
            this.zzaGz = nodeListener;
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzbd zzbd) throws RemoteException {
            zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaGz);
            this.zzaGz = null;
        }

        public Status zzb(Status status) {
            this.zzaGz = null;
            return status;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, NodeListener listener) {
        return client.zza(new zza(client, listener));
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.zza(new zzg<GetConnectedNodesResult>(this, client) {
            final /* synthetic */ zzan zzaGx;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzaV(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zzo(this);
            }

            protected GetConnectedNodesResult zzaV(Status status) {
                return new zzb(status, new ArrayList());
            }
        });
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.zza(new zzg<GetLocalNodeResult>(this, client) {
            final /* synthetic */ zzan zzaGx;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzaU(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zzn(this);
            }

            protected GetLocalNodeResult zzaU(Status status) {
                return new zzc(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeListener listener) {
        return client.zza(new zzg<Status>(this, client) {
            final /* synthetic */ zzan zzaGx;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzbd zzbd) throws RemoteException {
                zzbd.zzb((com.google.android.gms.common.api.zza.zzb) this, listener);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }
}
