package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzav implements Creator<zzau> {
    static void zza(zzau zzau, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzau.zzFG);
        zzb.zza(parcel, 2, zzau.zzva(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzij(x0);
    }

    public zzau zzfJ(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzau(i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzau[] zzij(int i) {
        return new zzau[i];
    }
}
