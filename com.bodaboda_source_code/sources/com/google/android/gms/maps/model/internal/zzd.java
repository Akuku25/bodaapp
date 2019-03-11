package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<zzc> {
    static void zza(zzc zzc, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzc.getVersionCode());
        zzb.zzc(parcel, 2, zzc.getType());
        zzb.zza(parcel, 3, zzc.zzqL(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzei(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgl(x0);
    }

    public zzc zzei(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        Bundle bundle = null;
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
                    bundle = zza.zzq(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzc(i2, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzc[] zzgl(int i) {
        return new zzc[i];
    }
}
