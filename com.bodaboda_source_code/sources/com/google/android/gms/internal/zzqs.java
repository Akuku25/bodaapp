package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzqs implements Creator<zzqq> {
    static void zza(zzqq zzqq, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzqq.zzpZ(), false);
        zzb.zzc(parcel, 1000, zzqq.zzFG);
        zzb.zza(parcel, 2, zzqq.getPlaceId(), false);
        zzb.zzc(parcel, 5, zzqq.zzqc(), false);
        zzb.zzc(parcel, 6, zzqq.zzqa(), false);
        zzb.zzc(parcel, 7, zzqq.zzqb(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfQ(x0);
    }

    public zzqq zzdN(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list2 = null;
        List list3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    list3 = zza.zzc(parcel, zzI, zzqu.CREATOR);
                    break;
                case 6:
                    list2 = zza.zzc(parcel, zzI, zzqo.CREATOR);
                    break;
                case 7:
                    list = zza.zzc(parcel, zzI, zzqm.CREATOR);
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
            return new zzqq(i, str2, str, list3, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzqq[] zzfQ(int i) {
        return new zzqq[i];
    }
}
