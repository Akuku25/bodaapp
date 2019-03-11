package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSet;

public class zzf implements Creator<zze> {
    static void zza(zze zze, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zze.zzlH(), i, false);
        zzb.zzc(parcel, 1000, zze.getVersionCode());
        zzb.zza(parcel, 2, zze.zzlQ(), false);
        zzb.zza(parcel, 3, zze.getPackageName(), false);
        zzb.zza(parcel, 4, zze.zzlU());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdB(x0);
    }

    public zze zzcd(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        IBinder iBinder = null;
        DataSet dataSet = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    dataSet = (DataSet) zza.zza(parcel, zzI, DataSet.CREATOR);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzI);
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
            return new zze(i, dataSet, iBinder, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zze[] zzdB(int i) {
        return new zze[i];
    }
}
