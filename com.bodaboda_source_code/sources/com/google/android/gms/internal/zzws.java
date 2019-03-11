package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzws<M extends zzws<M>> extends zzwy {
    protected zzwu zzaHB;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzvM();
    }

    public final <T> T zza(zzwt<M, T> zzwt) {
        if (this.zzaHB == null) {
            return null;
        }
        zzwv zziE = this.zzaHB.zziE(zzxb.zziI(zzwt.tag));
        return zziE != null ? zziE.zzb(zzwt) : null;
    }

    public void zza(zzwr zzwr) throws IOException {
        if (this.zzaHB != null) {
            for (int i = 0; i < this.zzaHB.size(); i++) {
                this.zzaHB.zziF(i).zza(zzwr);
            }
        }
    }

    protected final boolean zza(zzwq zzwq, int i) throws IOException {
        int position = zzwq.getPosition();
        if (!zzwq.zzin(i)) {
            return false;
        }
        int zziI = zzxb.zziI(i);
        zzxa zzxa = new zzxa(i, zzwq.zzx(position, zzwq.getPosition() - position));
        zzwv zzwv = null;
        if (this.zzaHB == null) {
            this.zzaHB = new zzwu();
        } else {
            zzwv = this.zzaHB.zziE(zziI);
        }
        if (zzwv == null) {
            zzwv = new zzwv();
            this.zzaHB.zza(zziI, zzwv);
        }
        zzwv.zza(zzxa);
        return true;
    }

    protected final boolean zza(M m) {
        return (this.zzaHB == null || this.zzaHB.isEmpty()) ? m.zzaHB == null || m.zzaHB.isEmpty() : this.zzaHB.equals(m.zzaHB);
    }

    protected int zzc() {
        int i = 0;
        if (this.zzaHB == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.zzaHB.size()) {
            i2 += this.zzaHB.zziF(i).zzc();
            i++;
        }
        return i2;
    }

    protected final int zzvL() {
        return (this.zzaHB == null || this.zzaHB.isEmpty()) ? 0 : this.zzaHB.hashCode();
    }

    public M zzvM() throws CloneNotSupportedException {
        zzws zzws = (zzws) super.zzvN();
        zzww.zza(this, zzws);
        return zzws;
    }

    public /* synthetic */ zzwy zzvN() throws CloneNotSupportedException {
        return zzvM();
    }
}
