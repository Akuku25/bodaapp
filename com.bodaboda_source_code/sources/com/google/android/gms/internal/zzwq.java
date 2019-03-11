package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzwq {
    private final byte[] buffer;
    private int zzaHr;
    private int zzaHs;
    private int zzaHt;
    private int zzaHu;
    private int zzaHv;
    private int zzaHw = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzaHx;
    private int zzaHy = 64;
    private int zzaHz = 67108864;

    private zzwq(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzaHr = i;
        this.zzaHs = i + i2;
        this.zzaHu = i;
    }

    public static long zzK(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzwq zza(byte[] bArr, int i, int i2) {
        return new zzwq(bArr, i, i2);
    }

    public static int zzio(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static zzwq zzt(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    private void zzvF() {
        this.zzaHs += this.zzaHt;
        int i = this.zzaHs;
        if (i > this.zzaHw) {
            this.zzaHt = i - this.zzaHw;
            this.zzaHs -= this.zzaHt;
            return;
        }
        this.zzaHt = 0;
    }

    public int getPosition() {
        return this.zzaHu - this.zzaHr;
    }

    public byte[] readBytes() throws IOException {
        int zzvB = zzvB();
        if (zzvB > this.zzaHs - this.zzaHu || zzvB <= 0) {
            return zzis(zzvB);
        }
        Object obj = new byte[zzvB];
        System.arraycopy(this.buffer, this.zzaHu, obj, 0, zzvB);
        this.zzaHu = zzvB + this.zzaHu;
        return obj;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzvE());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzvD());
    }

    public String readString() throws IOException {
        int zzvB = zzvB();
        if (zzvB > this.zzaHs - this.zzaHu || zzvB <= 0) {
            return new String(zzis(zzvB), "UTF-8");
        }
        String str = new String(this.buffer, this.zzaHu, zzvB, "UTF-8");
        this.zzaHu = zzvB + this.zzaHu;
        return str;
    }

    public void zza(zzwy zzwy) throws IOException {
        int zzvB = zzvB();
        if (this.zzaHx >= this.zzaHy) {
            throw zzwx.zzvW();
        }
        zzvB = zzip(zzvB);
        this.zzaHx++;
        zzwy.zzb(this);
        zzim(0);
        this.zzaHx--;
        zziq(zzvB);
    }

    public void zza(zzwy zzwy, int i) throws IOException {
        if (this.zzaHx >= this.zzaHy) {
            throw zzwx.zzvW();
        }
        this.zzaHx++;
        zzwy.zzb(this);
        zzim(zzxb.zzD(i, 4));
        this.zzaHx--;
    }

    public void zzim(int i) throws zzwx {
        if (this.zzaHv != i) {
            throw zzwx.zzvU();
        }
    }

    public boolean zzin(int i) throws IOException {
        switch (zzxb.zziH(i)) {
            case 0:
                zzvx();
                return true;
            case 1:
                zzvE();
                return true;
            case 2:
                zzit(zzvB());
                return true;
            case 3:
                zzvv();
                zzim(zzxb.zzD(zzxb.zziI(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzvD();
                return true;
            default:
                throw zzwx.zzvV();
        }
    }

    public int zzip(int i) throws zzwx {
        if (i < 0) {
            throw zzwx.zzvR();
        }
        int i2 = this.zzaHu + i;
        int i3 = this.zzaHw;
        if (i2 > i3) {
            throw zzwx.zzvQ();
        }
        this.zzaHw = i2;
        zzvF();
        return i3;
    }

    public void zziq(int i) {
        this.zzaHw = i;
        zzvF();
    }

    public void zzir(int i) {
        if (i > this.zzaHu - this.zzaHr) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzaHu - this.zzaHr));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzaHu = this.zzaHr + i;
        }
    }

    public byte[] zzis(int i) throws IOException {
        if (i < 0) {
            throw zzwx.zzvR();
        } else if (this.zzaHu + i > this.zzaHw) {
            zzit(this.zzaHw - this.zzaHu);
            throw zzwx.zzvQ();
        } else if (i <= this.zzaHs - this.zzaHu) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.zzaHu, obj, 0, i);
            this.zzaHu += i;
            return obj;
        } else {
            throw zzwx.zzvQ();
        }
    }

    public void zzit(int i) throws IOException {
        if (i < 0) {
            throw zzwx.zzvR();
        } else if (this.zzaHu + i > this.zzaHw) {
            zzit(this.zzaHw - this.zzaHu);
            throw zzwx.zzvQ();
        } else if (i <= this.zzaHs - this.zzaHu) {
            this.zzaHu += i;
        } else {
            throw zzwx.zzvQ();
        }
    }

    public long zzvA() throws IOException {
        return zzK(zzvC());
    }

    public int zzvB() throws IOException {
        byte zzvI = zzvI();
        if (zzvI >= (byte) 0) {
            return zzvI;
        }
        int i = zzvI & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte zzvI2 = zzvI();
        if (zzvI2 >= (byte) 0) {
            return i | (zzvI2 << 7);
        }
        i |= (zzvI2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        zzvI2 = zzvI();
        if (zzvI2 >= (byte) 0) {
            return i | (zzvI2 << 14);
        }
        i |= (zzvI2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        zzvI2 = zzvI();
        if (zzvI2 >= (byte) 0) {
            return i | (zzvI2 << 21);
        }
        i |= (zzvI2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        zzvI2 = zzvI();
        i |= zzvI2 << 28;
        if (zzvI2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (zzvI() >= (byte) 0) {
                return i;
            }
        }
        throw zzwx.zzvS();
    }

    public long zzvC() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzvI = zzvI();
            j |= ((long) (zzvI & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((zzvI & 128) == 0) {
                return j;
            }
        }
        throw zzwx.zzvS();
    }

    public int zzvD() throws IOException {
        return (((zzvI() & MotionEventCompat.ACTION_MASK) | ((zzvI() & MotionEventCompat.ACTION_MASK) << 8)) | ((zzvI() & MotionEventCompat.ACTION_MASK) << 16)) | ((zzvI() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public long zzvE() throws IOException {
        byte zzvI = zzvI();
        byte zzvI2 = zzvI();
        return ((((((((((long) zzvI2) & 255) << 8) | (((long) zzvI) & 255)) | ((((long) zzvI()) & 255) << 16)) | ((((long) zzvI()) & 255) << 24)) | ((((long) zzvI()) & 255) << 32)) | ((((long) zzvI()) & 255) << 40)) | ((((long) zzvI()) & 255) << 48)) | ((((long) zzvI()) & 255) << 56);
    }

    public int zzvG() {
        if (this.zzaHw == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return -1;
        }
        return this.zzaHw - this.zzaHu;
    }

    public boolean zzvH() {
        return this.zzaHu == this.zzaHs;
    }

    public byte zzvI() throws IOException {
        if (this.zzaHu == this.zzaHs) {
            throw zzwx.zzvQ();
        }
        byte[] bArr = this.buffer;
        int i = this.zzaHu;
        this.zzaHu = i + 1;
        return bArr[i];
    }

    public int zzvu() throws IOException {
        if (zzvH()) {
            this.zzaHv = 0;
            return 0;
        }
        this.zzaHv = zzvB();
        if (this.zzaHv != 0) {
            return this.zzaHv;
        }
        throw zzwx.zzvT();
    }

    public void zzvv() throws IOException {
        int zzvu;
        do {
            zzvu = zzvu();
            if (zzvu == 0) {
                return;
            }
        } while (zzin(zzvu));
    }

    public long zzvw() throws IOException {
        return zzvC();
    }

    public int zzvx() throws IOException {
        return zzvB();
    }

    public boolean zzvy() throws IOException {
        return zzvB() != 0;
    }

    public int zzvz() throws IOException {
        return zzio(zzvB());
    }

    public byte[] zzx(int i, int i2) {
        if (i2 == 0) {
            return zzxb.zzaHV;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.zzaHr + i, obj, 0, i2);
        return obj;
    }
}
