package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzls;
import java.util.ArrayList;

public class zze implements Creator<zzd> {
    static void zza(zzd zzd, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzd.getVersionCode());
        zzb.zza(parcel, 2, zzd.zzaFc, false);
        zzb.zza(parcel, 3, zzd.zzaFd, false);
        zzb.zzc(parcel, 4, zzd.zzaFe, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhK(x0);
    }

    public zzd zzfk(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        ArrayList zzkb = zzls.zzkb();
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
                    zzkb = zza.zzc(parcel, zzI, zzb.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzd(i, str2, str, zzkb);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzd[] zzhK(int i) {
        return new zzd[i];
    }
}
