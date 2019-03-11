package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zziv.zza;

public class zziw implements Creator<zza> {
    static void zza(zza zza, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zza.zzFY, i, false);
        zzb.zzc(parcel, 1000, zza.zzFG);
        zzb.zza(parcel, 2, zza.zzFZ);
        zzb.zza(parcel, 3, zza.zzGa);
        zzb.zza(parcel, 4, zza.zzGb);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzT(x0);
    }

    public zza[] zzT(int i) {
        return new zza[i];
    }

    public zza zzp(Parcel parcel) {
        boolean z = false;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        Account account = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case 1:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, Account.CREATOR);
                    break;
                case 2:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zza(i, account, z3, z2, z);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
