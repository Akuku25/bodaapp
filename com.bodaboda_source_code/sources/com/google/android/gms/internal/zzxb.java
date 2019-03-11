package com.google.android.gms.internal;

import java.io.IOException;

public final class zzxb {
    public static final int[] zzaHO = new int[0];
    public static final long[] zzaHP = new long[0];
    public static final float[] zzaHQ = new float[0];
    public static final double[] zzaHR = new double[0];
    public static final boolean[] zzaHS = new boolean[0];
    public static final String[] zzaHT = new String[0];
    public static final byte[][] zzaHU = new byte[0][];
    public static final byte[] zzaHV = new byte[0];

    static int zzD(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean zzb(zzwq zzwq, int i) throws IOException {
        return zzwq.zzin(i);
    }

    public static final int zzc(zzwq zzwq, int i) throws IOException {
        int i2 = 1;
        int position = zzwq.getPosition();
        zzwq.zzin(i);
        while (zzwq.zzvu() == i) {
            zzwq.zzin(i);
            i2++;
        }
        zzwq.zzir(position);
        return i2;
    }

    static int zziH(int i) {
        return i & 7;
    }

    public static int zziI(int i) {
        return i >>> 3;
    }
}
