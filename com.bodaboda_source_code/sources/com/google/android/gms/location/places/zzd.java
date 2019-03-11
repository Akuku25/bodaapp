package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<zzc> {
    static void zza(zzc zzc, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzc.zzpD());
        zzb.zzc(parcel, 1000, zzc.getVersionCode());
        zzb.zzc(parcel, 2, zzc.zzpG());
        zzb.zza(parcel, 3, zzc.zzpH(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfB(x0);
    }

    public zzc zzdA(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        int i2 = -1;
        PlaceFilter placeFilter = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzI, PlaceFilter.CREATOR);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzc(i3, i, i2, placeFilter);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzc[] zzfB(int i) {
        return new zzc[i];
    }
}
