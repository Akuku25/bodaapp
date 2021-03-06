package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<zzp> {
    static void zza(zzp zzp, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzp.getVersionCode());
        zzb.zza(parcel, 2, zzp.zzaFl, false);
        zzb.zza(parcel, 3, zzp.zzwG, false);
        zzb.zza(parcel, 4, zzp.zzaFo, i, false);
        zzb.zza(parcel, 5, zzp.zzaFp, i, false);
        zzb.zza(parcel, 6, zzp.zzaFq, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhQ(x0);
    }

    public zzp zzfq(Parcel parcel) {
        zzn zzn = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzn zzn2 = null;
        zzl zzl = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    zzl = (zzl) zza.zza(parcel, zzI, zzl.CREATOR);
                    break;
                case 5:
                    zzn2 = (zzn) zza.zza(parcel, zzI, zzn.CREATOR);
                    break;
                case 6:
                    zzn = (zzn) zza.zza(parcel, zzI, zzn.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzp(i, str2, str, zzl, zzn2, zzn);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzp[] zzhQ(int i) {
        return new zzp[i];
    }
}
