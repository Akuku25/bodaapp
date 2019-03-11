package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaf implements Creator<zzae> {
    static void zza(zzae zzae, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzae.versionCode);
        zzb.zzc(parcel, 2, zzae.statusCode);
        zzb.zza(parcel, 3, zzae.zzaGn, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzie(x0);
    }

    public zzae zzfE(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        zzao zzao = null;
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
                    zzao = (zzao) zza.zza(parcel, zzI, zzao.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzae(i2, i, zzao);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzae[] zzie(int i) {
        return new zzae[i];
    }
}
