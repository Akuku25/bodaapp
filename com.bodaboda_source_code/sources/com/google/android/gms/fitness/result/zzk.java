package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<zzj> {
    static void zza(zzj zzj, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzj.zzms(), i, false);
        zzb.zzc(parcel, 1000, zzj.getVersionCode());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzej(x0);
    }

    public zzj zzcK(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    dataHolder = (DataHolder) zza.zza(parcel, zzI, DataHolder.CREATOR);
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
            return new zzj(i, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzj[] zzej(int i) {
        return new zzj[i];
    }
}
