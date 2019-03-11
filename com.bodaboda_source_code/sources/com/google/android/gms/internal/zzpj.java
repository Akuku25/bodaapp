package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzpj implements Creator<zzpi> {
    static void zza(zzpi zzpi, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzpi.zzanl);
        zzb.zzc(parcel, 1000, zzpi.getVersionCode());
        zzb.zza(parcel, 2, zzpi.zzanm, i, false);
        zzb.zza(parcel, 3, zzpi.zzpz(), false);
        zzb.zza(parcel, 4, zzpi.mPendingIntent, i, false);
        zzb.zza(parcel, 5, zzpi.zzpA(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfv(x0);
    }

    public zzpi zzdw(Parcel parcel) {
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = 1;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        zzpg zzpg = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    zzpg = (zzpg) zza.zza(parcel, zzI, zzpg.CREATOR);
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzI);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzI, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder = zza.zzp(parcel, zzI);
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
            return new zzpi(i, i2, zzpg, iBinder2, pendingIntent, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzpi[] zzfv(int i) {
        return new zzpi[i];
    }
}
