package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzli implements Creator<zzlh> {
    static void zza(zzlh zzlh, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzlh.getVersionCode());
        zzb.zzc(parcel, 2, zzlh.zzjO(), false);
        zzb.zza(parcel, 3, zzlh.zzjP(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaX(x0);
    }

    public zzlh zzR(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzI, zzlh.zza.CREATOR);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzlh(i, arrayList, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzlh[] zzaX(int i) {
        return new zzlh[i];
    }
}
