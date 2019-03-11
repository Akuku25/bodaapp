package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<zzb> {
    static void zza(zzb zzb, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzb.zzpq(), false);
        zzb.zzc(parcel, 1000, zzb.getVersionCode());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfi(x0);
    }

    public zzb zzdo(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    list = zza.zzB(parcel, zzI);
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
            return new zzb(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzb[] zzfi(int i) {
        return new zzb[i];
    }
}
