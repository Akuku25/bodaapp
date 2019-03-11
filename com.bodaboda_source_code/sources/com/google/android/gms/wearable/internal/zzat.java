package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzat implements Creator<zzas> {
    static void zza(zzas zzas, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzas.versionCode);
        zzb.zzc(parcel, 2, zzas.statusCode);
        zzb.zza(parcel, 3, zzas.zzaGl, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzii(x0);
    }

    public zzas zzfI(Parcel parcel) {
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
            return new zzas(i2, i, zzp);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzas[] zzii(int i) {
        return new zzas[i];
    }
}
