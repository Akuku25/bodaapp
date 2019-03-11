package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class zzol implements Creator<zzok> {
    static void zza(zzok zzok, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzok.getDataTypes(), false);
        zzb.zzc(parcel, 1000, zzok.getVersionCode());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdx(x0);
    }

    public zzok zzbZ(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    list = zza.zzc(parcel, zzI, DataType.CREATOR);
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
            return new zzok(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzok[] zzdx(int i) {
        return new zzok[i];
    }
}
