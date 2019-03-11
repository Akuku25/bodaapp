package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<zzf> {
    static void zza(zzf zzf, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzf.getVersionCode());
        zzb.zza(parcel, 2, zzf.label, false);
        zzb.zza(parcel, 3, zzf.zzaFf, i, false);
        zzb.zza(parcel, 4, zzf.type, false);
        zzb.zza(parcel, 5, zzf.zzaDG, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfm(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhM(x0);
    }

    public zzf zzfm(Parcel parcel) {
        zzl zzl = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        zzg zzg = null;
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
                    zzg = (zzg) zza.zza(parcel, zzI, zzg.CREATOR);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    zzl = (zzl) zza.zza(parcel, zzI, zzl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzf(i, str2, zzg, str, zzl);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzf[] zzhM(int i) {
        return new zzf[i];
    }
}
