package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaf implements Creator<zzae> {
    static void zza(zzae zzae, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzae.zzmg(), false);
        zzb.zzc(parcel, 1000, zzae.getVersionCode());
        zzb.zza(parcel, 2, zzae.zzmb(), i, false);
        zzb.zza(parcel, 3, zzae.zzlQ(), false);
        zzb.zza(parcel, 4, zzae.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdQ(x0);
    }

    public zzae zzcr(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    iBinder2 = zza.zzp(parcel, zzI);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzI, PendingIntent.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzae(i, iBinder2, pendingIntent, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzae[] zzdQ(int i) {
        return new zzae[i];
    }
}
