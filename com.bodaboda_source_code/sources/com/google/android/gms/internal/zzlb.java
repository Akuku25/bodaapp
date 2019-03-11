package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzlb implements Creator<zzla> {
    static void zza(zzla zzla, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzla.getVersionCode());
        zzb.zzc(parcel, 2, zzla.zzjw(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaT(x0);
    }

    public zzla zzN(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzI, zzla.zza.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzla(i, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzla[] zzaT(int i) {
        return new zzla[i];
    }
}
