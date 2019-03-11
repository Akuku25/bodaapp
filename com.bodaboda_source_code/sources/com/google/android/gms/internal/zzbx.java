package com.google.android.gms.internal;

import android.os.Bundle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@zzgi
public abstract class zzbx<T> implements zzbw {
    private final String zzqd;
    private final T zzqe;

    private zzbx(String str, T t) {
        this.zzqd = str;
        this.zzqe = t;
        zzab.zzaS().zza((zzbw) this);
    }

    public static zzbx<String> zzA(String str) {
        zzbx c05684 = new zzbx<String>(str, null) {
            public /* synthetic */ Object zza(Bundle bundle) {
                return zzd(bundle);
            }

            public zzki<String> zzbZ() {
                return zzki.zzp(getKey(), (String) zzbY());
            }

            public String zzd(Bundle bundle) {
                return zzbx.zza(bundle, getKey(), (String) zzbY());
            }
        };
        zzab.zzaS().zza(c05684);
        return c05684;
    }

    public static zzbx<Integer> zza(String str, int i) {
        return new zzbx<Integer>(str, Integer.valueOf(i)) {
            public /* synthetic */ Object zza(Bundle bundle) {
                return zzc(bundle);
            }

            public zzki<Integer> zzbZ() {
                return zzki.zza(getKey(), (Integer) zzbY());
            }

            public Integer zzc(Bundle bundle) {
                return Integer.valueOf(bundle.getInt(getKey(), ((Integer) zzbY()).intValue()));
            }
        };
    }

    public static zzbx<Boolean> zza(String str, Boolean bool) {
        return new zzbx<Boolean>(str, bool) {
            public /* synthetic */ Object zza(Bundle bundle) {
                return zzb(bundle);
            }

            public Boolean zzb(Bundle bundle) {
                return Boolean.valueOf(bundle.getBoolean(getKey(), ((Boolean) zzbY()).booleanValue()));
            }

            public zzki<Boolean> zzbZ() {
                return zzki.zzg(getKey(), ((Boolean) zzbY()).booleanValue());
            }
        };
    }

    private static String zza(Bundle bundle, String str, String str2) {
        String string = bundle.getString(str);
        return string == null ? str2 : string;
    }

    public static zzbx<String> zzd(String str, String str2) {
        return new zzbx<String>(str, str2) {
            public /* synthetic */ Object zza(Bundle bundle) {
                return zzd(bundle);
            }

            public zzki<String> zzbZ() {
                return zzki.zzp(getKey(), (String) zzbY());
            }

            public String zzd(Bundle bundle) {
                return zzbx.zza(bundle, getKey(), (String) zzbY());
            }
        };
    }

    public T get() {
        Future zzcc = zzab.zzaT().zzcc();
        if (!zzcc.isDone()) {
            return this.zzqe;
        }
        try {
            return zza((Bundle) zzcc.get());
        } catch (CancellationException e) {
            return this.zzqe;
        } catch (ExecutionException e2) {
            return this.zzqe;
        } catch (InterruptedException e3) {
            return this.zzqe;
        }
    }

    public String getKey() {
        return this.zzqd;
    }

    protected abstract T zza(Bundle bundle);

    public T zzbY() {
        return this.zzqe;
    }

    public abstract zzki<T> zzbZ();
}
