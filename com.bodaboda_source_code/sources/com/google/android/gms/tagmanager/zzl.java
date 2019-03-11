package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class zzl<K, V> {
    final zza<K, V> zzaxu = new C04041(this);

    public interface zza<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: com.google.android.gms.tagmanager.zzl$1 */
    class C04041 implements zza<K, V> {
        final /* synthetic */ zzl zzaxv;

        C04041(zzl zzl) {
            this.zzaxv = zzl;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    public zzk<K, V> zza(int i, zza<K, V> zza) {
        if (i > 0) {
            return zzsF() < 12 ? new zzcv(i, zza) : new zzaz(i, zza);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int zzsF() {
        return VERSION.SDK_INT;
    }
}
