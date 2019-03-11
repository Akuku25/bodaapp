package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzgc.zza;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgi
public class zzgg extends zzhl {
    private final Object zznh;
    private final zza zzvL;
    private final zzhe.zza zzvN;
    private final zzgq zzvO;
    private final zzgt zzvY;
    private Future<zzhe> zzvZ;

    public zzgg(Context context, zzt zzt, zzai zzai, zzhe.zza zza, zza zza2) {
        this(zza, zza2, new zzgt(context, zzt, zzai, new zzht(), zza));
    }

    zzgg(zzhe.zza zza, zza zza2, zzgt zzgt) {
        this.zznh = new Object();
        this.zzvN = zza;
        this.zzvO = zza.zzyz;
        this.zzvL = zza2;
        this.zzvY = zzgt;
    }

    private zzhe zzu(int i) {
        return new zzhe(this.zzvN.zzyy.zzwn, null, null, i, null, null, this.zzvO.orientation, this.zzvO.zzsx, this.zzvN.zzyy.zzwq, false, null, null, null, null, null, this.zzvO.zzwJ, this.zzvN.zzlV, this.zzvO.zzwH, this.zzvN.zzyv, this.zzvO.zzwM, this.zzvO.zzwN, this.zzvN.zzys, null, this.zzvN.zzyy.zzwD);
    }

    public void onStop() {
        synchronized (this.zznh) {
            if (this.zzvZ != null) {
                this.zzvZ.cancel(true);
            }
        }
    }

    public void zzdw() {
        zzhe zzhe;
        int i;
        try {
            synchronized (this.zznh) {
                this.zzvZ = zzhn.submit(this.zzvY);
            }
            zzhe = (zzhe) this.zzvZ.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            zzhx.zzac("Timed out waiting for native ad.");
            i = 2;
            zzhe = null;
        } catch (ExecutionException e2) {
            i = 0;
            zzhe = null;
        } catch (InterruptedException e3) {
            zzhe = null;
            i = -1;
        } catch (CancellationException e4) {
            zzhe = null;
            i = -1;
        }
        if (zzhe == null) {
            zzhe = zzu(i);
        }
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzgg zzwa;

            public void run() {
                this.zzwa.zzvL.zza(zzhe);
            }
        });
    }
}
