package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static int initialize(Context context) {
        zzx.zzl(context);
        try {
            zza(com.google.android.gms.maps.internal.zzx.zzac(context));
            return 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            return e.errorCode;
        }
    }

    public static void zza(zzc zzc) {
        try {
            CameraUpdateFactory.zza(zzc.zzqA());
            BitmapDescriptorFactory.zza(zzc.zzqB());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
