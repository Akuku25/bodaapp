package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<zzj> {
    static void zza(zzj zzj, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzj.zzxV, false);
        zzb.zzc(parcel, 1000, zzj.zzFG);
        zzb.zzc(parcel, 2, zzj.zzaoh);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfF(x0);
    }

    public zzj zzdD(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzj(i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzj[] zzfF(int i) {
        return new zzj[i];
    }
}
