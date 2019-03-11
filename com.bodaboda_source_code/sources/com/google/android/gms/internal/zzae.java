package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

@zzgi
public class zzae implements zzag {
    private final Object zznh = new Object();
    private final WeakHashMap<zzhe, zzaf> zzni = new WeakHashMap();
    private final ArrayList<zzaf> zznj = new ArrayList();
    private final Context zznk;
    private final zzhy zznl;
    private final zzdf zznm;

    public zzae(Context context, zzhy zzhy, zzdf zzdf) {
        this.zznk = context.getApplicationContext();
        this.zznl = zzhy;
        this.zznm = zzdf;
    }

    public zzaf zza(zzba zzba, zzhe zzhe) {
        return zza(zzba, zzhe, zzhe.zzuq.getWebView());
    }

    public zzaf zza(zzba zzba, zzhe zzhe, View view) {
        zzaf zzaf;
        synchronized (this.zznh) {
            if (zzc(zzhe)) {
                zzaf = (zzaf) this.zzni.get(zzhe);
            } else {
                zzaf = new zzaf(zzba, zzhe, this.zznl, view, this.zznm);
                zzaf.zza((zzag) this);
                this.zzni.put(zzhe, zzaf);
                this.zznj.add(zzaf);
            }
        }
        return zzaf;
    }

    public void zza(zzaf zzaf) {
        synchronized (this.zznh) {
            if (!zzaf.zzbf()) {
                this.zznj.remove(zzaf);
            }
        }
    }

    public boolean zzc(zzhe zzhe) {
        boolean z;
        synchronized (this.zznh) {
            zzaf zzaf = (zzaf) this.zzni.get(zzhe);
            z = zzaf != null && zzaf.zzbf();
        }
        return z;
    }

    public void zzd(zzhe zzhe) {
        synchronized (this.zznh) {
            zzaf zzaf = (zzaf) this.zzni.get(zzhe);
            if (zzaf != null) {
                zzaf.zzbd();
            }
        }
    }

    public void zze(zzhe zzhe) {
        synchronized (this.zznh) {
            zzaf zzaf = (zzaf) this.zzni.get(zzhe);
            if (zzaf != null) {
                zzaf.stop();
            }
        }
    }

    public void zzf(zzhe zzhe) {
        synchronized (this.zznh) {
            zzaf zzaf = (zzaf) this.zzni.get(zzhe);
            if (zzaf != null) {
                zzaf.pause();
            }
        }
    }

    public void zzg(zzhe zzhe) {
        synchronized (this.zznh) {
            zzaf zzaf = (zzaf) this.zzni.get(zzhe);
            if (zzaf != null) {
                zzaf.resume();
            }
        }
    }
}
