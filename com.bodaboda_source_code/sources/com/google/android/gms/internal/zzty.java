package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zztw.zza;
import java.util.HashSet;
import java.util.Set;

public class zzty implements Creator<zza> {
    static void zza(zza zza, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        Set set = zza.zzauX;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, zza.zzFG);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, zza.zzawo);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzc(parcel, 3, zza.zzawp);
        }
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgP(x0);
    }

    public zza zzeC(Parcel parcel) {
        int i = 0;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zza(hashSet, i3, i2, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zza[] zzgP(int i) {
        return new zza[i];
    }
}
