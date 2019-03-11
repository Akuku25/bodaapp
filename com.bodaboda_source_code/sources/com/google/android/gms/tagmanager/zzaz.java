package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.zzl.zza;

class zzaz<K, V> implements zzk<K, V> {
    private LruCache<K, V> zzazc;

    zzaz(int i, final zza<K, V> zza) {
        this.zzazc = new LruCache<K, V>(this, i) {
            final /* synthetic */ zzaz zzaze;

            protected int sizeOf(K key, V value) {
                return zza.sizeOf(key, value);
            }
        };
    }

    public V get(K key) {
        return this.zzazc.get(key);
    }

    public void zze(K k, V v) {
        this.zzazc.put(k, v);
    }
}
