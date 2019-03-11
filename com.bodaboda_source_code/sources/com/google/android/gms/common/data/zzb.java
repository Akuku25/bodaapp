package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<zza> {
    static void zza(zza zza, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, zza.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, zza.zzNJ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, zza.zzJp);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzau(x0);
    }

    public zza[] zzau(int i) {
        return new zza[i];
    }

    public zza zzz(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int zzg;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = zza.zzg(parcel, zzI);
                    zzI = i3;
                    break;
                case 2:
                    zzg = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) zza.zza(parcel, zzI, ParcelFileDescriptor.CREATOR);
                    zzI = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 3:
                    zzI = zza.zzg(parcel, zzI);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzI = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = zzI;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zza(i2, parcelFileDescriptor, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
