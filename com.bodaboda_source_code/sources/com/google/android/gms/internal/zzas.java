package com.google.android.gms.internal;

import java.util.PriorityQueue;

public class zzas {

    public static class zza {
        final long value;
        final String zzoI;

        zza(long j, String str) {
            this.value = j;
            this.zzoI = str;
        }

        public boolean equals(Object other) {
            return other != null && (other instanceof zza) && ((zza) other).value == this.value;
        }

        public int hashCode() {
            return (int) this.value;
        }
    }

    static long zza(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long zza(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? zza((j * j) % 1073807359, i / 2) % 1073807359 : ((zza((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String zza(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            zzhx.zzZ("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void zza(int i, long j, String str, PriorityQueue<zza> priorityQueue) {
        zza zza = new zza(j, str);
        if ((priorityQueue.size() != i || ((zza) priorityQueue.peek()).value <= zza.value) && !priorityQueue.contains(zza)) {
            priorityQueue.add(zza);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zza> priorityQueue) {
        long zzb = zzb(strArr, 0, i2);
        zza(i, zzb, zza(strArr, 0, i2), (PriorityQueue) priorityQueue);
        long zza = zza(16785407, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            zzb = zza(zzaq.zzo(strArr[i3 - 1]), zzaq.zzo(strArr[(i3 + i2) - 1]), zzb, zza, 16785407);
            zza(i, zzb, zza(strArr, i3, i2), (PriorityQueue) priorityQueue);
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        long zzo = (((long) zzaq.zzo(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            zzo = (((zzo * 16785407) % 1073807359) + ((((long) zzaq.zzo(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzo;
    }
}
