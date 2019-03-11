package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzgi
public class zzhf {
    private final zzhg zzmV;
    private final Object zznh;
    private boolean zzxJ;
    private final LinkedList<zza> zzyA;
    private final String zzyB;
    private final String zzyC;
    private long zzyD;
    private long zzyE;
    private long zzyF;
    private long zzyG;
    private long zzyH;
    private long zzyI;

    @zzgi
    private static final class zza {
        private long zzyJ = -1;
        private long zzyK = -1;

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.zzyJ);
            bundle.putLong("tclose", this.zzyK);
            return bundle;
        }

        public long zzea() {
            return this.zzyK;
        }

        public void zzeb() {
            this.zzyK = SystemClock.elapsedRealtime();
        }

        public void zzec() {
            this.zzyJ = SystemClock.elapsedRealtime();
        }
    }

    public zzhf(zzhg zzhg, String str, String str2) {
        this.zznh = new Object();
        this.zzyD = -1;
        this.zzyE = -1;
        this.zzxJ = false;
        this.zzyF = -1;
        this.zzyG = 0;
        this.zzyH = -1;
        this.zzyI = -1;
        this.zzmV = zzhg;
        this.zzyB = str;
        this.zzyC = str2;
        this.zzyA = new LinkedList();
    }

    public zzhf(String str, String str2) {
        this(zzab.zzaP(), str, str2);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zznh) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzyB);
            bundle.putString("slotid", this.zzyC);
            bundle.putBoolean("ismediation", this.zzxJ);
            bundle.putLong("treq", this.zzyH);
            bundle.putLong("tresponse", this.zzyI);
            bundle.putLong("timp", this.zzyE);
            bundle.putLong("tload", this.zzyF);
            bundle.putLong("pcc", this.zzyG);
            bundle.putLong("tfetch", this.zzyD);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzyA.iterator();
            while (it.hasNext()) {
                arrayList.add(((zza) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public void zzdX() {
        synchronized (this.zznh) {
            if (this.zzyI != -1 && this.zzyE == -1) {
                this.zzyE = SystemClock.elapsedRealtime();
                this.zzmV.zza(this);
            }
            this.zzmV.zzef().zzdX();
        }
    }

    public void zzdY() {
        synchronized (this.zznh) {
            if (this.zzyI != -1) {
                zza zza = new zza();
                zza.zzec();
                this.zzyA.add(zza);
                this.zzyG++;
                this.zzmV.zzef().zzdY();
                this.zzmV.zza(this);
            }
        }
    }

    public void zzdZ() {
        synchronized (this.zznh) {
            if (!(this.zzyI == -1 || this.zzyA.isEmpty())) {
                zza zza = (zza) this.zzyA.getLast();
                if (zza.zzea() == -1) {
                    zza.zzeb();
                    this.zzmV.zza(this);
                }
            }
        }
    }

    public void zze(zzax zzax) {
        synchronized (this.zznh) {
            this.zzyH = SystemClock.elapsedRealtime();
            this.zzmV.zzef().zzb(zzax, this.zzyH);
        }
    }

    public void zzj(long j) {
        synchronized (this.zznh) {
            this.zzyI = j;
            if (this.zzyI != -1) {
                this.zzmV.zza(this);
            }
        }
    }

    public void zzk(long j) {
        synchronized (this.zznh) {
            if (this.zzyI != -1) {
                this.zzyD = j;
                this.zzmV.zza(this);
            }
        }
    }

    public void zzx(boolean z) {
        synchronized (this.zznh) {
            if (this.zzyI != -1) {
                this.zzyF = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzyE = this.zzyF;
                    this.zzmV.zza(this);
                }
            }
        }
    }

    public void zzy(boolean z) {
        synchronized (this.zznh) {
            if (this.zzyI != -1) {
                this.zzxJ = z;
                this.zzmV.zza(this);
            }
        }
    }
}
