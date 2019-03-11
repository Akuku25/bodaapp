package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<zzc> {
    static void zza(zzc zzc, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzc.zzFG);
        zzb.zza(parcel, 2, zzc.zzPn, false);
        zzb.zza(parcel, 3, zzc.zzPo, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaF(x0);
    }

    public zzc zzC(Parcel parcel) {
        Scope[] scopeArr = null;
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
                case 3:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzI, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzc(i, iBinder, scopeArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzc[] zzaF(int i) {
        return new zzc[i];
    }
}
