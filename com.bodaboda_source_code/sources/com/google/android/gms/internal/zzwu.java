package com.google.android.gms.internal;

class zzwu implements Cloneable {
    private static final zzwv zzaHE = new zzwv();
    private int mSize;
    private boolean zzaHF;
    private int[] zzaHG;
    private zzwv[] zzaHH;

    public zzwu() {
        this(10);
    }

    public zzwu(int i) {
        this.zzaHF = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzaHG = new int[idealIntArraySize];
        this.zzaHH = new zzwv[idealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzaHG;
        zzwv[] zzwvArr = this.zzaHH;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzwv zzwv = zzwvArr[i3];
            if (zzwv != zzaHE) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzwvArr[i2] = zzwv;
                    zzwvArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzaHF = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzwv[] zzwvArr, zzwv[] zzwvArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzwvArr[i2].equals(zzwvArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zziG(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzaHG[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzvO();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzwu)) {
            return false;
        }
        zzwu zzwu = (zzwu) o;
        if (size() != zzwu.size()) {
            return false;
        }
        return zza(this.zzaHG, zzwu.zzaHG, this.mSize) && zza(this.zzaHH, zzwu.zzaHH, this.mSize);
    }

    public int hashCode() {
        if (this.zzaHF) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzaHG[i2]) * 31) + this.zzaHH[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if (this.zzaHF) {
            gc();
        }
        return this.mSize;
    }

    public void zza(int i, zzwv zzwv) {
        int zziG = zziG(i);
        if (zziG >= 0) {
            this.zzaHH[zziG] = zzwv;
            return;
        }
        zziG ^= -1;
        if (zziG >= this.mSize || this.zzaHH[zziG] != zzaHE) {
            if (this.zzaHF && this.mSize >= this.zzaHG.length) {
                gc();
                zziG = zziG(i) ^ -1;
            }
            if (this.mSize >= this.zzaHG.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new zzwv[idealIntArraySize];
                System.arraycopy(this.zzaHG, 0, obj, 0, this.zzaHG.length);
                System.arraycopy(this.zzaHH, 0, obj2, 0, this.zzaHH.length);
                this.zzaHG = obj;
                this.zzaHH = obj2;
            }
            if (this.mSize - zziG != 0) {
                System.arraycopy(this.zzaHG, zziG, this.zzaHG, zziG + 1, this.mSize - zziG);
                System.arraycopy(this.zzaHH, zziG, this.zzaHH, zziG + 1, this.mSize - zziG);
            }
            this.zzaHG[zziG] = i;
            this.zzaHH[zziG] = zzwv;
            this.mSize++;
            return;
        }
        this.zzaHG[zziG] = i;
        this.zzaHH[zziG] = zzwv;
    }

    public zzwv zziE(int i) {
        int zziG = zziG(i);
        return (zziG < 0 || this.zzaHH[zziG] == zzaHE) ? null : this.zzaHH[zziG];
    }

    public zzwv zziF(int i) {
        if (this.zzaHF) {
            gc();
        }
        return this.zzaHH[i];
    }

    public final zzwu zzvO() {
        int i = 0;
        int size = size();
        zzwu zzwu = new zzwu(size);
        System.arraycopy(this.zzaHG, 0, zzwu.zzaHG, 0, size);
        while (i < size) {
            if (this.zzaHH[i] != null) {
                zzwu.zzaHH[i] = this.zzaHH[i].zzvP();
            }
            i++;
        }
        zzwu.mSize = size;
        return zzwu;
    }
}
