package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzis implements Creator<zzir> {
    static void zza(zzir zzir, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzir.zzFT, false);
        zzb.zzc(parcel, 1000, zzir.zzFG);
        zzb.zza(parcel, 3, zzir.zzFU, i, false);
        zzb.zzc(parcel, 4, zzir.zzFV);
        zzb.zza(parcel, 5, zzir.zzFW, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzR(x0);
    }

    public zzir[] zzR(int i) {
        return new zzir[i];
    }

    public zzir zzn(Parcel parcel) {
        byte[] bArr = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = -1;
        zziz zziz = null;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    zziz = (zziz) zza.zza(parcel, zzI, zziz.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    bArr = zza.zzr(parcel, zzI);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzir(i, str, zziz, i2, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
