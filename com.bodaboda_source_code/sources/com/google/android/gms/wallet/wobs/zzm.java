package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<zzl> {
    static void zza(zzl zzl, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzl.getVersionCode());
        zzb.zza(parcel, 2, zzl.zzaFm);
        zzb.zza(parcel, 3, zzl.zzaFn);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhO(x0);
    }

    public zzl zzfo(Parcel parcel) {
        long j = 0;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
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
                    j = zza.zzi(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzl(i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzl[] zzhO(int i) {
        return new zzl[i];
    }
}
