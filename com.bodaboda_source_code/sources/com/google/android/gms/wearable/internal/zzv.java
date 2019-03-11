package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.zze;

public class zzv implements Creator<zzu> {
    static void zza(zzu zzu, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzu.versionCode);
        zzb.zzc(parcel, 2, zzu.statusCode);
        zzb.zza(parcel, 3, zzu.zzaGi, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhZ(x0);
    }

    public zzu zzfz(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        zze zze = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    zze = (zze) zza.zza(parcel, zzI, zze.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzu(i2, i, zze);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzu[] zzhZ(int i) {
        return new zzu[i];
    }
}
