package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zztw.zzd;
import java.util.HashSet;
import java.util.Set;

public class zzud implements Creator<zzd> {
    static void zza(zzd zzd, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        Set set = zzd.zzauX;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, zzd.zzFG);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, zzd.zzavv, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, zzd.zzawv, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, zzd.zzavy, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, zzd.zzaww, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, zzd.zzawx, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, zzd.zzawy, true);
        }
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgU(x0);
    }

    public zzd zzeH(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(6));
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
            return new zzd(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzd[] zzgU(int i) {
        return new zzd[i];
    }
}
