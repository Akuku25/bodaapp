package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzbi.zza;

@zzgi
public class zzaw extends zzg<zzbj> {
    public zzaw() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzbi zzb(Context context, zzba zzba, String str, zzdq zzdq) {
        try {
            return zza.zzg(((zzbj) zzS(context)).zza(zze.zzn(context), zzba, str, zzdq, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            zzhx.zzd("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            zzhx.zzd("Could not create remote AdManager.", e2);
            return null;
        }
    }

    public zzbi zza(Context context, zzba zzba, String str, zzdq zzdq) {
        if (zzbe.zzbD().zzA(context)) {
            zzbi zzb = zzb(context, zzba, str, zzdq);
            if (zzb != null) {
                return zzb;
            }
        }
        zzhx.zzY("Using AdManager from the client jar.");
        return new zzt(context, zzba, str, zzdq, new zzhy(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    protected zzbj zzc(IBinder iBinder) {
        return zzbj.zza.zzh(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzc(iBinder);
    }
}
