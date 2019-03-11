package com.google.android.gms.internal;

import android.content.Context;

@zzgi
public final class zzgl {

    public interface zza {
        void zzb(zzgq zzgq);
    }

    interface zzb {
        boolean zzc(zzgo zzgo);
    }

    /* renamed from: com.google.android.gms.internal.zzgl$1 */
    static class C03491 implements zzb {
        C03491() {
        }

        public boolean zzc(zzgo zzgo) {
            return zzgo.zzlP.zzzK;
        }
    }

    public static zzhl zza(Context context, zzgo zzgo, zza zza) {
        return zza(context, zzgo, zza, new C03491());
    }

    static zzhl zza(Context context, zzgo zzgo, zza zza, zzb zzb) {
        return zzb.zzc(zzgo) ? zzb(context, zzgo, zza) : zzc(context, zzgo, zza);
    }

    private static zzhl zzb(Context context, zzgo zzgo, zza zza) {
        zzhx.zzY("Fetching ad response from local ad request service.");
        zzhl zza2 = new com.google.android.gms.internal.zzgm.zza(context, zzgo, zza);
        zza2.start();
        return zza2;
    }

    private static zzhl zzc(Context context, zzgo zzgo, zza zza) {
        zzhx.zzY("Fetching ad response from remote ad request service.");
        if (zzbe.zzbD().zzA(context)) {
            return new com.google.android.gms.internal.zzgm.zzb(context, zzgo, zza);
        }
        zzhx.zzac("Failed to connect to remote ad request service.");
        return null;
    }
}
