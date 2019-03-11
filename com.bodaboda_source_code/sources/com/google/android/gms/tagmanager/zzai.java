package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzc.zzc;
import com.google.android.gms.internal.zzc.zzd;
import com.google.android.gms.internal.zzc.zzi;
import com.google.android.gms.internal.zzd.zza;
import java.util.Map;

class zzai {
    private static void zza(DataLayer dataLayer, zzd zzd) {
        for (zza zzg : zzd.zzfB) {
            dataLayer.zzcU(zzde.zzg(zzg));
        }
    }

    public static void zza(DataLayer dataLayer, zzi zzi) {
        if (zzi.zzgq == null) {
            zzbf.zzac("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, zzi.zzgq);
        zzb(dataLayer, zzi.zzgq);
        zzc(dataLayer, zzi.zzgq);
    }

    private static void zzb(DataLayer dataLayer, zzd zzd) {
        for (zza zzc : zzd.zzfA) {
            Map zzc2 = zzc(zzc);
            if (zzc2 != null) {
                dataLayer.push(zzc2);
            }
        }
    }

    private static Map<String, Object> zzc(zza zza) {
        Object zzl = zzde.zzl(zza);
        if (zzl instanceof Map) {
            return (Map) zzl;
        }
        zzbf.zzac("value: " + zzl + " is not a map value, ignored.");
        return null;
    }

    private static void zzc(DataLayer dataLayer, zzd zzd) {
        for (zzc zzc : zzd.zzfC) {
            if (zzc.zzfv == null) {
                zzbf.zzac("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(zzc.zzfv);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = zzc.zzfw;
                long j2 = zzc.zzfx;
                if (!zzc.zzfy || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        zzbf.zzac("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.zzcU(zzc.zzfv);
                Map zzc2 = dataLayer.zzc(zzc.zzfv, obj);
                if (zzc.zzfz > 0) {
                    if (zzc2.containsKey("gtm")) {
                        Object obj2 = zzc2.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(zzc.zzfz));
                        } else {
                            zzbf.zzac("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        zzc2.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zzc.zzfz)));
                    }
                }
                dataLayer.push(zzc2);
            }
        }
    }
}
