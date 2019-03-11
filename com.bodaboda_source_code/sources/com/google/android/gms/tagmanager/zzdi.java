package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzd.zza;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class zzdi {
    private static zzbv<zza> zza(zzbv<zza> zzbv) {
        try {
            return new zzbv(zzde.zzx(zzdv(zzde.zzg((zza) zzbv.getObject()))), zzbv.zztu());
        } catch (Throwable e) {
            zzbf.zzb("Escape URI: unsupported encoding", e);
            return zzbv;
        }
    }

    private static zzbv<zza> zza(zzbv<zza> zzbv, int i) {
        if (zzn((zza) zzbv.getObject())) {
            switch (i) {
                case 12:
                    return zza(zzbv);
                default:
                    zzbf.zzZ("Unsupported Value Escaping: " + i);
                    return zzbv;
            }
        }
        zzbf.zzZ("Escaping can only be applied to strings.");
        return zzbv;
    }

    static zzbv<zza> zza(zzbv<zza> zzbv, int... iArr) {
        zzbv zza;
        for (int zza2 : iArr) {
            zza = zza(zza, zza2);
        }
        return zza;
    }

    static String zzdv(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean zzn(zza zza) {
        return zzde.zzl(zza) instanceof String;
    }
}
