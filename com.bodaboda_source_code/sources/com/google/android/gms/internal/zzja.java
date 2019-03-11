package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzja implements Creator<zziz> {
    static void zza(zziz zziz, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zziz.name, false);
        zzb.zzc(parcel, 1000, zziz.zzFG);
        zzb.zza(parcel, 2, zziz.zzGh, false);
        zzb.zza(parcel, 3, zziz.zzGi);
        zzb.zzc(parcel, 4, zziz.weight);
        zzb.zza(parcel, 5, zziz.zzGj);
        zzb.zza(parcel, 6, zziz.zzGk, false);
        zzb.zza(parcel, 7, zziz.zzGl, i, false);
        zzb.zza(parcel, 8, zziz.zzGm, false);
        zzb.zza(parcel, 11, zziz.zzGn, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzX(x0);
    }

    public zziz[] zzX(int i) {
        return new zziz[i];
    }

    public zziz zzr(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 1;
        int[] iArr = null;
        zzit[] zzitArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    zzitArr = (zzit[]) zza.zzb(parcel, zzI, zzit.CREATOR);
                    break;
                case 8:
                    iArr = zza.zzu(parcel, zzI);
                    break;
                case 11:
                    str = zza.zzo(parcel, zzI);
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
            return new zziz(i2, str4, str3, z2, i, z, str2, zzitArr, iArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
