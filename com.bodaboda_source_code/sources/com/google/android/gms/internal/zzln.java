package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzln implements Creator<zzlm> {
    static void zza(zzlm zzlm, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzlm.zzFG);
        zzb.zza(parcel, 2, zzlm.getTimeMillis());
        zzb.zza(parcel, 3, zzlm.zzjT(), false);
        zzb.zza(parcel, 4, zzlm.zzjU(), false);
        zzb.zza(parcel, 5, zzlm.zzjV(), false);
        zzb.zza(parcel, 6, zzlm.zzjW(), false);
        zzb.zza(parcel, 7, zzlm.zzjX(), false);
        zzb.zza(parcel, 8, zzlm.zzjY(), false);
        zzb.zza(parcel, 9, zzlm.zzjZ());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzba(x0);
    }

    public zzlm zzU(Parcel parcel) {
        long j = 0;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 9:
                    j = zza.zzi(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzlm(i, j2, str6, str5, str4, str3, str2, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzlm[] zzba(int i) {
        return new zzlm[i];
    }
}
