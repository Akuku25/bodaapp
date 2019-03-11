package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzvl.zzc;
import com.google.android.gms.internal.zzvl.zzg;
import com.google.android.gms.tagmanager.zzbf;

public abstract class zzvt {
    private zzvj zzaCG;
    private zzvh zzaCH;
    private zzlv zzmW;

    public enum zza {
        NOT_AVAILABLE,
        IO_ERROR,
        SERVER_ERROR
    }

    public class zzb {
        private final Object zzaCM;
        private final com.google.android.gms.internal.zzvk.zza.zza zzaCa;
        private final long zzaCc;

        public Object zzuP() {
            return this.zzaCM;
        }

        public com.google.android.gms.internal.zzvk.zza.zza zzup() {
            return this.zzaCa;
        }

        public long zzut() {
            return this.zzaCc;
        }
    }

    public zzvt(zzvj zzvj, zzvh zzvh) {
        this(zzvj, zzvh, zzlx.zzkc());
    }

    public zzvt(zzvj zzvj, zzvh zzvh, zzlv zzlv) {
        boolean z = true;
        if (zzvj.zzun().size() != 1) {
            z = false;
        }
        zzx.zzO(z);
        this.zzaCG = zzvj;
        this.zzaCH = zzvh;
        this.zzmW = zzlv;
    }

    protected abstract zzb zza(zzve zzve);

    protected abstract void zza(zzvk zzvk);

    public void zza(zza zza) {
        zzbf.zzZ("ResourceManager: Failed to download a resource: " + zza.name());
        zzve zzve = (zzve) this.zzaCG.zzun().get(0);
        zzb zza2 = zza(zzve);
        com.google.android.gms.internal.zzvk.zza zza3 = (zza2 == null || !(zza2.zzuP() instanceof zzc)) ? new com.google.android.gms.internal.zzvk.zza(Status.zzNq, zzve, com.google.android.gms.internal.zzvk.zza.zza.NETWORK) : new com.google.android.gms.internal.zzvk.zza(Status.zzNo, zzve, null, (zzc) zza2.zzuP(), zza2.zzup(), zza2.zzut());
        zza(new zzvk(zza3));
    }

    public void zzo(byte[] bArr) {
        zzb zza;
        long j;
        com.google.android.gms.internal.zzvk.zza.zza zza2;
        Object obj;
        com.google.android.gms.internal.zzvk.zza zza3;
        zzbf.zzab("ResourceManager: Resource downloaded from Network: " + this.zzaCG.getId());
        zzve zzve = (zzve) this.zzaCG.zzun().get(0);
        com.google.android.gms.internal.zzvk.zza.zza zza4 = com.google.android.gms.internal.zzvk.zza.zza.NETWORK;
        Object zzn;
        try {
            zzn = this.zzaCH.zzn(bArr);
            long currentTimeMillis = this.zzmW.currentTimeMillis();
            if (zzn == null) {
                zzbf.zzaa("Parsed resource from network is null");
                zza = zza(zzve);
                if (zza != null) {
                    zzn = zza.zzuP();
                    zza4 = zza.zzup();
                    currentTimeMillis = zza.zzut();
                }
            }
            j = currentTimeMillis;
            zza2 = zza4;
            obj = zzn;
        } catch (zzg e) {
            zzbf.zzaa("Resource from network is corrupted");
            zza = zza(zzve);
            if (zza != null) {
                zzn = zza.zzuP();
                j = 0;
                zza2 = zza.zzup();
                obj = zzn;
            } else {
                j = 0;
                zza2 = zza4;
                obj = null;
            }
        }
        if (obj != null) {
            zza3 = new com.google.android.gms.internal.zzvk.zza(Status.zzNo, zzve, bArr, (zzc) obj, zza2, j);
        } else {
            zza3 = new com.google.android.gms.internal.zzvk.zza(Status.zzNq, zzve, com.google.android.gms.internal.zzvk.zza.zza.NETWORK);
        }
        zza(new zzvk(zza3));
    }
}
