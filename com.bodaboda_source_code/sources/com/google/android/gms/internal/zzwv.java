package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class zzwv implements Cloneable {
    private zzwt<?, ?> zzaHI;
    private Object zzaHJ;
    private List<zzxa> zzaHK = new ArrayList();

    zzwv() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzc()];
        zza(zzwr.zzu(bArr));
        return bArr;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzvP();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzwv)) {
            return false;
        }
        zzwv zzwv = (zzwv) o;
        if (this.zzaHJ == null || zzwv.zzaHJ == null) {
            if (this.zzaHK != null && zzwv.zzaHK != null) {
                return this.zzaHK.equals(zzwv.zzaHK);
            }
            try {
                return Arrays.equals(toByteArray(), zzwv.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzaHI != zzwv.zzaHI) {
            return false;
        } else {
            if (!this.zzaHI.zzaHC.isArray()) {
                return this.zzaHJ.equals(zzwv.zzaHJ);
            }
            if (this.zzaHJ instanceof byte[]) {
                return Arrays.equals((byte[]) this.zzaHJ, (byte[]) zzwv.zzaHJ);
            }
            if (this.zzaHJ instanceof int[]) {
                return Arrays.equals((int[]) this.zzaHJ, (int[]) zzwv.zzaHJ);
            }
            if (this.zzaHJ instanceof long[]) {
                return Arrays.equals((long[]) this.zzaHJ, (long[]) zzwv.zzaHJ);
            }
            if (this.zzaHJ instanceof float[]) {
                return Arrays.equals((float[]) this.zzaHJ, (float[]) zzwv.zzaHJ);
            }
            if (this.zzaHJ instanceof double[]) {
                return Arrays.equals((double[]) this.zzaHJ, (double[]) zzwv.zzaHJ);
            }
            return this.zzaHJ instanceof boolean[] ? Arrays.equals((boolean[]) this.zzaHJ, (boolean[]) zzwv.zzaHJ) : Arrays.deepEquals((Object[]) this.zzaHJ, (Object[]) zzwv.zzaHJ);
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    void zza(zzwr zzwr) throws IOException {
        if (this.zzaHJ != null) {
            this.zzaHI.zza(this.zzaHJ, zzwr);
            return;
        }
        for (zzxa zza : this.zzaHK) {
            zza.zza(zzwr);
        }
    }

    void zza(zzxa zzxa) {
        this.zzaHK.add(zzxa);
    }

    <T> T zzb(zzwt<?, T> zzwt) {
        if (this.zzaHJ == null) {
            this.zzaHI = zzwt;
            this.zzaHJ = zzwt.zzx(this.zzaHK);
            this.zzaHK = null;
        } else if (this.zzaHI != zzwt) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return this.zzaHJ;
    }

    int zzc() {
        if (this.zzaHJ != null) {
            return this.zzaHI.zzF(this.zzaHJ);
        }
        int i = 0;
        for (zzxa zzc : this.zzaHK) {
            i = zzc.zzc() + i;
        }
        return i;
    }

    public final zzwv zzvP() {
        int i = 0;
        zzwv zzwv = new zzwv();
        try {
            zzwv.zzaHI = this.zzaHI;
            if (this.zzaHK == null) {
                zzwv.zzaHK = null;
            } else {
                zzwv.zzaHK.addAll(this.zzaHK);
            }
            if (this.zzaHJ != null) {
                if (this.zzaHJ instanceof zzwy) {
                    zzwv.zzaHJ = ((zzwy) this.zzaHJ).zzvN();
                } else if (this.zzaHJ instanceof byte[]) {
                    zzwv.zzaHJ = ((byte[]) this.zzaHJ).clone();
                } else if (this.zzaHJ instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.zzaHJ;
                    Object obj = new byte[bArr.length][];
                    zzwv.zzaHJ = obj;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        obj[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.zzaHJ instanceof boolean[]) {
                    zzwv.zzaHJ = ((boolean[]) this.zzaHJ).clone();
                } else if (this.zzaHJ instanceof int[]) {
                    zzwv.zzaHJ = ((int[]) this.zzaHJ).clone();
                } else if (this.zzaHJ instanceof long[]) {
                    zzwv.zzaHJ = ((long[]) this.zzaHJ).clone();
                } else if (this.zzaHJ instanceof float[]) {
                    zzwv.zzaHJ = ((float[]) this.zzaHJ).clone();
                } else if (this.zzaHJ instanceof double[]) {
                    zzwv.zzaHJ = ((double[]) this.zzaHJ).clone();
                } else if (this.zzaHJ instanceof zzwy[]) {
                    zzwy[] zzwyArr = (zzwy[]) this.zzaHJ;
                    Object obj2 = new zzwy[zzwyArr.length];
                    zzwv.zzaHJ = obj2;
                    while (i < zzwyArr.length) {
                        obj2[i] = zzwyArr[i].zzvN();
                        i++;
                    }
                }
            }
            return zzwv;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
