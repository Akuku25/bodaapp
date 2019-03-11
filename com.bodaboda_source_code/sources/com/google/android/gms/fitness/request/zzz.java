package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzz implements Creator<zzy> {
    static void zza(zzy zzy, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzy.zzlQ(), false);
        zzb.zzc(parcel, 1000, zzy.getVersionCode());
        zzb.zza(parcel, 2, zzy.getPackageName(), false);
        zzb.zzc(parcel, 3, zzy.zzma(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzco(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdM(x0);
    }

    public zzy zzco(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzI, zzh.CREATOR);
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
            return new zzy(i, iBinder, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzy[] zzdM(int i) {
        return new zzy[i];
    }
}
