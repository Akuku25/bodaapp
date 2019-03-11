package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzi implements Creator<zzh> {
    static void zza(zzh zzh, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzh.zzYp, i, false);
        zzb.zzc(parcel, 1000, zzh.zzFG);
        zzb.zza(parcel, 2, zzh.zzHf);
        zzb.zza(parcel, 3, zzh.zzYH);
        zzb.zza(parcel, 4, zzh.zzabb);
        zzb.zzc(parcel, 5, zzh.zzaaX);
        zzb.zzc(parcel, 6, zzh.zzabc);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdD(x0);
    }

    public zzh zzcf(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        DataSource dataSource = null;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzI, DataSource.CREATOR);
                    break;
                case 2:
                    j3 = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 6:
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
            return new zzh(i3, dataSource, j3, j2, j, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzh[] zzdD(int i) {
        return new zzh[i];
    }
}
