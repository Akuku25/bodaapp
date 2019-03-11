package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

final class zzbc {

    static abstract class zza<T> extends zza {
        private com.google.android.gms.common.api.zza.zzb<T> zzGC;

        public zza(com.google.android.gms.common.api.zza.zzb<T> zzb) {
            this.zzGC = zzb;
        }

        public void zzE(T t) {
            com.google.android.gms.common.api.zza.zzb zzb = this.zzGC;
            if (zzb != null) {
                zzb.zzd(t);
                this.zzGC = null;
            }
        }
    }

    static final class zzh extends zza {
        zzh() {
        }

        public void zza(Status status) {
        }
    }

    static final class zzb extends zza<DeleteDataItemsResult> {
        public zzb(com.google.android.gms.common.api.zza.zzb<DeleteDataItemsResult> zzb) {
            super(zzb);
        }

        public void zza(zzs zzs) {
            zzE(new com.google.android.gms.wearable.internal.zzi.zzc(zzay.zzep(zzs.statusCode), zzs.zzaGh));
        }
    }

    static final class zzc extends zza<GetConnectedNodesResult> {
        public zzc(com.google.android.gms.common.api.zza.zzb<GetConnectedNodesResult> zzb) {
            super(zzb);
        }

        public void zza(zzy zzy) {
            List arrayList = new ArrayList();
            arrayList.addAll(zzy.zzaGk);
            zzE(new com.google.android.gms.wearable.internal.zzan.zzb(zzay.zzep(zzy.statusCode), arrayList));
        }
    }

    static final class zzd extends zza<DataItemResult> {
        public zzd(com.google.android.gms.common.api.zza.zzb<DataItemResult> zzb) {
            super(zzb);
        }

        public void zza(zzaa zzaa) {
            zzE(new com.google.android.gms.wearable.internal.zzi.zzb(zzay.zzep(zzaa.statusCode), zzaa.zzaGl));
        }
    }

    static final class zze extends zza<DataItemBuffer> {
        public zze(com.google.android.gms.common.api.zza.zzb<DataItemBuffer> zzb) {
            super(zzb);
        }

        public void zzac(DataHolder dataHolder) {
            zzE(new DataItemBuffer(dataHolder));
        }
    }

    static final class zzf extends zza<GetFdForAssetResult> {
        public zzf(com.google.android.gms.common.api.zza.zzb<GetFdForAssetResult> zzb) {
            super(zzb);
        }

        public void zza(zzac zzac) {
            zzE(new com.google.android.gms.wearable.internal.zzi.zzd(zzay.zzep(zzac.statusCode), zzac.zzaGm));
        }
    }

    static final class zzg extends zza<GetLocalNodeResult> {
        public zzg(com.google.android.gms.common.api.zza.zzb<GetLocalNodeResult> zzb) {
            super(zzb);
        }

        public void zza(zzae zzae) {
            zzE(new com.google.android.gms.wearable.internal.zzan.zzc(zzay.zzep(zzae.statusCode), zzae.zzaGn));
        }
    }

    static final class zzi extends zza<DataItemResult> {
        private final List<FutureTask<Boolean>> zzaGF;

        zzi(com.google.android.gms.common.api.zza.zzb<DataItemResult> zzb, List<FutureTask<Boolean>> list) {
            super(zzb);
            this.zzaGF = list;
        }

        public void zza(zzas zzas) {
            zzE(new com.google.android.gms.wearable.internal.zzi.zzb(zzay.zzep(zzas.statusCode), zzas.zzaGl));
            if (zzas.statusCode != 0) {
                for (FutureTask cancel : this.zzaGF) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class zzj extends zza<SendMessageResult> {
        public zzj(com.google.android.gms.common.api.zza.zzb<SendMessageResult> zzb) {
            super(zzb);
        }

        public void zza(zzaw zzaw) {
            zzE(new com.google.android.gms.wearable.internal.zzak.zzb(zzay.zzep(zzaw.statusCode), zzaw.zzaGD));
        }
    }
}
