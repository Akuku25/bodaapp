package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzll implements Creator<zzlk> {
    static void zza(zzlk zzlk, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzlk.getVersionCode());
        zzb.zza(parcel, 2, zzlk.zzjR(), false);
        zzb.zza(parcel, 3, zzlk.zzjS(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaZ(x0);
    }

    public zzlk zzT(Parcel parcel) {
        zzlh zzlh = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    parcel2 = zza.zzD(parcel, zzI);
                    break;
                case 3:
                    zzlh = (zzlh) zza.zza(parcel, zzI, zzlh.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzlk(i, parcel2, zzlh);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzlk[] zzaZ(int i) {
        return new zzlk[i];
    }
}
