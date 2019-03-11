package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzas implements Creator<zzar> {
    static void zza(zzar zzar, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzar.zzmk(), false);
        zzb.zzc(parcel, 1000, zzar.getVersionCode());
        zzb.zza(parcel, 2, zzar.zzlQ(), false);
        zzb.zza(parcel, 3, zzar.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdY(x0);
    }

    public zzar zzcz(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    iBinder2 = zza.zzp(parcel, zzI);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 3:
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
            return new zzar(i, iBinder2, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzar[] zzdY(int i) {
        return new zzar[i];
    }
}
