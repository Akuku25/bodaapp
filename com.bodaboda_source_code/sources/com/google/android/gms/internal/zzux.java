package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzux implements Creator<zzuw> {
    static void zza(zzuw zzuw, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzuw.zzFG);
        zzb.zza(parcel, 2, zzuw.zzawX);
        zzb.zzc(parcel, 3, zzuw.zzawY, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzha(x0);
    }

    public zzuw zzeN(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzI, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzuw(i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzuw[] zzha(int i) {
        return new zzuw[i];
    }
}
