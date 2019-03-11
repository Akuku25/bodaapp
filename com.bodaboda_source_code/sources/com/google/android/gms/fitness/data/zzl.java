package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzl extends com.google.android.gms.fitness.data.zzk.zza {
    private final OnDataPointListener zzZF;

    public static class zza {
        private static final zza zzZG = new zza();
        private final Map<OnDataPointListener, zzl> zzZH = new HashMap();

        private zza() {
        }

        public static zza zzlG() {
            return zzZG;
        }

        public zzl zza(OnDataPointListener onDataPointListener) {
            zzl zzl;
            synchronized (this.zzZH) {
                zzl = (zzl) this.zzZH.get(onDataPointListener);
                if (zzl == null) {
                    zzl = new zzl(onDataPointListener);
                    this.zzZH.put(onDataPointListener, zzl);
                }
            }
            return zzl;
        }

        public zzl zzb(OnDataPointListener onDataPointListener) {
            zzl zzl;
            synchronized (this.zzZH) {
                zzl = (zzl) this.zzZH.get(onDataPointListener);
            }
            return zzl;
        }

        public zzl zzc(OnDataPointListener onDataPointListener) {
            zzl zzl;
            synchronized (this.zzZH) {
                zzl = (zzl) this.zzZH.remove(onDataPointListener);
                if (zzl != null) {
                } else {
                    zzl = new zzl(onDataPointListener);
                }
            }
            return zzl;
        }
    }

    private zzl(OnDataPointListener onDataPointListener) {
        this.zzZF = (OnDataPointListener) zzx.zzl(onDataPointListener);
    }

    public void zzc(DataPoint dataPoint) throws RemoteException {
        this.zzZF.onDataPoint(dataPoint);
    }
}
