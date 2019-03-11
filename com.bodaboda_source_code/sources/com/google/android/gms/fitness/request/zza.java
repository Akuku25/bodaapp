package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza extends com.google.android.gms.fitness.request.zzt.zza {
    private final BleScanCallback zzaaI;

    public static class zza {
        private static final zza zzaaJ = new zza();
        private final Map<BleScanCallback, zza> zzaaK = new HashMap();

        private zza() {
        }

        public static zza zzlO() {
            return zzaaJ;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza zza;
            synchronized (this.zzaaK) {
                zza = (zza) this.zzaaK.get(bleScanCallback);
                if (zza == null) {
                    zza = new zza(bleScanCallback);
                    this.zzaaK.put(bleScanCallback, zza);
                }
            }
            return zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza zza;
            synchronized (this.zzaaK) {
                zza = (zza) this.zzaaK.get(bleScanCallback);
                if (zza != null) {
                } else {
                    zza = new zza(bleScanCallback);
                }
            }
            return zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzaaI = (BleScanCallback) zzx.zzl(bleScanCallback);
    }

    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.zzaaI.onDeviceFound(device);
    }

    public void onScanStopped() throws RemoteException {
        this.zzaaI.onScanStopped();
    }
}
