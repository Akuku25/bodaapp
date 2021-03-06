package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzjc implements Creator<zzjb> {
    static void zza(zzjb zzjb, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzjb.zzGw, i, false);
        zzb.zzc(parcel, 1000, zzjb.zzFG);
        zzb.zza(parcel, 2, zzjb.zzGx);
        zzb.zzc(parcel, 3, zzjb.zzGy);
        zzb.zza(parcel, 4, zzjb.zzpZ, false);
        zzb.zza(parcel, 5, zzjb.zzGz, i, false);
        zzb.zza(parcel, 6, zzjb.zzGA);
        zzb.zzc(parcel, 7, zzjb.zzGB);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzY(x0);
    }

    public zzjb[] zzY(int i) {
        return new zzjb[i];
    }

    public zzjb zzs(Parcel parcel) {
        zzin zzin = null;
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        long j = 0;
        int i = -1;
        String str = null;
        int i2 = 0;
        zzip zzip = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    zzip = (zzip) zza.zza(parcel, zzI, zzip.CREATOR);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    zzin = (zzin) zza.zza(parcel, zzI, zzin.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzjb(i3, zzip, j, i2, str, zzin, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
