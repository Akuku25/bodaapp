package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

abstract class zzaj<T> {
    private final HashMap<T, zzbe> zzaGo = new HashMap();

    static final class zzb extends zzaj<com.google.android.gms.wearable.zza.zza> {
        zzb() {
        }

        zzbe zza(com.google.android.gms.wearable.zza.zza zza, IntentFilter[] intentFilterArr) {
            return zzbe.zza(zza);
        }
    }

    static final class zzc extends zzaj<DataListener> {
        zzc() {
        }

        zzbe zza(DataListener dataListener, IntentFilter[] intentFilterArr) {
            return zzbe.zzb(dataListener, intentFilterArr);
        }
    }

    static final class zzd extends zzaj<MessageListener> {
        zzd() {
        }

        zzbe zza(MessageListener messageListener, IntentFilter[] intentFilterArr) {
            return zzbe.zzb(messageListener, intentFilterArr);
        }
    }

    static final class zze extends zzaj<NodeListener> {
        zze() {
        }

        zzbe zza(NodeListener nodeListener, IntentFilter[] intentFilterArr) {
            return zzbe.zza(nodeListener);
        }
    }

    private static class zza<T> extends zza<Status> {
        private WeakReference<Map<T, zzbe>> zzaGp;
        private WeakReference<T> zzaGq;

        zza(Map<T, zzbe> map, T t, com.google.android.gms.common.api.zza.zzb<Status> zzb) {
            super(zzb);
            this.zzaGp = new WeakReference(map);
            this.zzaGq = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzaGp.get();
            Object obj = this.zzaGq.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    zzbe zzbe = (zzbe) map.remove(obj);
                    if (zzbe != null) {
                        zzbe.clear();
                    }
                }
            }
            zzE(status);
        }
    }

    private static class zzf<T> extends zza<Status> {
        private WeakReference<Map<T, zzbe>> zzaGp;
        private WeakReference<T> zzaGq;

        zzf(Map<T, zzbe> map, T t, com.google.android.gms.common.api.zza.zzb<Status> zzb) {
            super(zzb);
            this.zzaGp = new WeakReference(map);
            this.zzaGq = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzaGp.get();
            Object obj = this.zzaGq.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
                synchronized (map) {
                    zzbe zzbe = (zzbe) map.remove(obj);
                    if (zzbe != null) {
                        zzbe.clear();
                    }
                }
            }
            zzE(status);
        }
    }

    zzaj() {
    }

    abstract zzbe zza(T t, IntentFilter[] intentFilterArr);

    public void zza(zzbd zzbd, com.google.android.gms.common.api.zza.zzb<Status> zzb, T t) throws RemoteException {
        synchronized (this.zzaGo) {
            zzbe zzbe = (zzbe) this.zzaGo.remove(t);
            if (zzbe == null) {
                zzb.zzd(new Status(4002));
                return;
            }
            zzbe.clear();
            ((zzai) zzbd.zzjb()).zza(new zzf(this.zzaGo, t, zzb), new zzau(zzbe));
        }
    }

    public void zza(zzbd zzbd, com.google.android.gms.common.api.zza.zzb<Status> zzb, T t, IntentFilter[] intentFilterArr) throws RemoteException {
        zzbe zza = zza(t, intentFilterArr);
        synchronized (this.zzaGo) {
            if (this.zzaGo.get(t) != null) {
                zzb.zzd(new Status(4001));
                return;
            }
            this.zzaGo.put(t, zza);
            try {
                ((zzai) zzbd.zzjb()).zza(new zza(this.zzaGo, t, zzb), new zzb(zza));
            } catch (RemoteException e) {
                this.zzaGo.remove(t);
                throw e;
            }
        }
    }

    public void zzb(zzbd zzbd) {
        synchronized (this.zzaGo) {
            zzag zzh = new zzh();
            for (Entry entry : this.zzaGo.entrySet()) {
                zzbe zzbe = (zzbe) entry.getValue();
                if (zzbe != null) {
                    zzbe.clear();
                    if (zzbd.isConnected()) {
                        try {
                            ((zzai) zzbd.zzjb()).zza(zzh, new zzau(zzbe));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + entry.getKey() + "/" + zzbe);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + entry.getKey() + "/" + zzbe);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.zzaGo.clear();
        }
    }

    public void zzcS(IBinder iBinder) {
        synchronized (this.zzaGo) {
            zzai zzcR = com.google.android.gms.wearable.internal.zzai.zza.zzcR(iBinder);
            zzag zzh = new zzh();
            for (Entry entry : this.zzaGo.entrySet()) {
                zzbe zzbe = (zzbe) entry.getValue();
                try {
                    zzcR.zza(zzh, new zzb(zzbe));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + zzbe);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + zzbe);
                }
            }
        }
    }
}
