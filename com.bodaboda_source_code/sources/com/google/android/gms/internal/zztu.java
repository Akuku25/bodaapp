package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zztu implements Creator<zztt> {
    static void zza(zztt zztt, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        Set set = zztt.zzauX;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, zztt.zzFG);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, zztt.zzFA, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, zztt.zzavS, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, zztt.zzavK, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, zztt.zzavT, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, zztt.zzxV, true);
        }
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgN(x0);
    }

    public zztt zzeA(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        zztr zztr = null;
        String str2 = null;
        zztr zztr2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            zztr zztr3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    zztr3 = (zztr) zza.zza(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    zztr2 = zztr3;
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    zztr3 = (zztr) zza.zza(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    zztr = zztr3;
                    break;
                case 7:
                    str = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zztt(hashSet, i, str3, zztr2, str2, zztr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zztt[] zzgN(int i) {
        return new zztt[i];
    }
}
