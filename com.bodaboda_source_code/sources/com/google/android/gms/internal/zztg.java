package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzxf.zzd;
import java.util.ArrayList;

public class zztg {
    private final ArrayList<zza> zzatP;
    private int zzatQ;

    public static class zza {
        public final zztj zzatR;
        public final zztf zzatS;
        public final zzd zzatT;

        private zza(zztj zztj, zztf zztf) {
            this.zzatR = (zztj) zzx.zzl(zztj);
            this.zzatS = (zztf) zzx.zzl(zztf);
            this.zzatT = null;
        }
    }

    public zztg() {
        this(100);
    }

    public zztg(int i) {
        this.zzatP = new ArrayList();
        this.zzatQ = i;
    }

    private void zzrH() {
        while (getSize() > getCapacity()) {
            this.zzatP.remove(0);
        }
    }

    public void clear() {
        this.zzatP.clear();
    }

    public int getCapacity() {
        return this.zzatQ;
    }

    public int getSize() {
        return this.zzatP.size();
    }

    public boolean isEmpty() {
        return this.zzatP.isEmpty();
    }

    public void zza(zztj zztj, zztf zztf) {
        this.zzatP.add(new zza(zztj, zztf));
        zzrH();
    }

    public ArrayList<zza> zzrG() {
        return this.zzatP;
    }
}
