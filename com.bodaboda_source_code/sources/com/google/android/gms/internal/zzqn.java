package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzqn implements Creator<zzqm> {
    static void zza(zzqm zzqm, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzqm.getData(), false);
        zzb.zzc(parcel, 1000, zzqm.zzFG);
        zzb.zzc(parcel, 2, zzqm.getActions(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfO(x0);
    }

    public zzqm zzdL(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzI, zzqm.zza.CREATOR);
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
            return new zzqm(i, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzqm[] zzfO(int i) {
        return new zzqm[i];
    }
}
