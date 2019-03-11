package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab implements Creator<zzaa> {
    static void zza(zzaa zzaa, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzaa.versionCode);
        zzb.zzc(parcel, 2, zzaa.statusCode);
        zzb.zza(parcel, 3, zzaa.zzaGl, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzic(x0);
    }

    public zzaa zzfC(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        zzp zzp = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    zzp = (zzp) zza.zza(parcel, zzI, zzp.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzaa(i2, i, zzp);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzaa[] zzic(int i) {
        return new zzaa[i];
    }
}
