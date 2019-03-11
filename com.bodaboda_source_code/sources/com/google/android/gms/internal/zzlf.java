package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzld.zza;

public class zzlf implements Creator<zza> {
    static void zza(zza zza, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zza.getVersionCode());
        zzb.zzc(parcel, 2, zza.zzjx());
        zzb.zza(parcel, 3, zza.zzjD());
        zzb.zzc(parcel, 4, zza.zzjy());
        zzb.zza(parcel, 5, zza.zzjE());
        zzb.zza(parcel, 6, zza.zzjF(), false);
        zzb.zzc(parcel, 7, zza.zzjG());
        zzb.zza(parcel, 8, zza.zzjI(), false);
        zzb.zza(parcel, 9, zza.zzjK(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaV(x0);
    }

    public zza zzP(Parcel parcel) {
        zzky zzky = null;
        int i = 0;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 9:
                    zzky = (zzky) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, zzky.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zza(i4, i3, z2, i2, z, str2, i, str, zzky);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zza[] zzaV(int i) {
        return new zza[i];
    }
}
