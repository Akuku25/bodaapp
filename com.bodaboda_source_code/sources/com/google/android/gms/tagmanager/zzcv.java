package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzl.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class zzcv<K, V> implements zzk<K, V> {
    private final Map<K, V> zzaAI = new HashMap();
    private final int zzaAJ;
    private final zza<K, V> zzaAK;
    private int zzaAL;

    zzcv(int i, zza<K, V> zza) {
        this.zzaAJ = i;
        this.zzaAK = zza;
    }

    public synchronized V get(K key) {
        return this.zzaAI.get(key);
    }

    public synchronized void zze(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.zzaAL += this.zzaAK.sizeOf(k, v);
        if (this.zzaAL > this.zzaAJ) {
            Iterator it = this.zzaAI.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.zzaAL -= this.zzaAK.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.zzaAL <= this.zzaAJ) {
                    break;
                }
            }
        }
        this.zzaAI.put(k, v);
    }
}
