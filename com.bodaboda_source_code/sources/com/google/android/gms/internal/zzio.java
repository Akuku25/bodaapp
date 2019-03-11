package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzio implements Creator<zzin> {
    static void zza(zzin zzin, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzin.zzFH, i, false);
        zzb.zzc(parcel, 1000, zzin.zzFG);
        zzb.zza(parcel, 2, zzin.zzFI, false);
        zzb.zza(parcel, 3, zzin.zzFJ);
        zzb.zza(parcel, 4, zzin.account, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzP(x0);
    }

    public zzin[] zzP(int i) {
        return new zzin[i];
    }

    public zzin zzl(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int zzJ = zza.zzJ(parcel);
        String str = null;
        zzir[] zzirArr = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    zzirArr = (zzir[]) zza.zzb(parcel, zzI, zzir.CREATOR);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 4:
                    account = (Account) zza.zza(parcel, zzI, Account.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzin(i, zzirArr, str, z, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
