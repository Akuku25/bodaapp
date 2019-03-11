package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzkz implements Creator<zzky> {
    static void zza(zzky zzky, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzky.getVersionCode());
        zzb.zza(parcel, 2, zzky.zzju(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaS(x0);
    }

    public zzky zzM(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzla zzla = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    zzla = (zzla) zza.zza(parcel, zzI, zzla.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzky(i, zzla);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzky[] zzaS(int i) {
        return new zzky[i];
    }
}
