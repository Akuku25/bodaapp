package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzvy implements Creator<zzvx> {
    static void zza(zzvx zzvx, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzvx.getVersionCode());
        zzb.zza(parcel, 2, zzvx.zzaEq, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhA(x0);
    }

    public zzvx zzfd(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    iArr = zza.zzu(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzvx(i, iArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzvx[] zzhA(int i) {
        return new zzvx[i];
    }
}
