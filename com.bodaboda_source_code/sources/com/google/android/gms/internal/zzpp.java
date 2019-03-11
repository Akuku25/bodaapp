package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzpp implements Creator<zzpo> {
    static void zza(zzpo zzpo, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzpo.zzZO, false);
        zzb.zzc(parcel, 1000, zzpo.zzFG);
        zzb.zza(parcel, 2, zzpo.zzanM, false);
        zzb.zza(parcel, 3, zzpo.zzanu, false);
        zzb.zzc(parcel, 4, zzpo.zzaoi, false);
        zzb.zzc(parcel, 5, zzpo.zzaoj);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfG(x0);
    }

    public zzpo zzdE(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzJ = zza.zzJ(parcel);
        List list2 = null;
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    list2 = zza.zzB(parcel, zzI);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzI, zzpo.zza.CREATOR);
                    break;
                case 5:
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
            return new zzpo(i2, str2, str, list2, list, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzpo[] zzfG(int i) {
        return new zzpo[i];
    }
}
