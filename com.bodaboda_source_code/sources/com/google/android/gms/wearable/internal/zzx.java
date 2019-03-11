package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.zze;

public class zzx implements Creator<zzw> {
    static void zza(zzw zzw, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzw.versionCode);
        zzb.zzc(parcel, 2, zzw.statusCode);
        zzb.zza(parcel, 3, zzw.zzaGj, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzia(x0);
    }

    public zzw zzfA(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        zze[] zzeArr = null;
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
                    zzeArr = (zze[]) zza.zzb(parcel, zzI, zze.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzw(i2, i, zzeArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzw[] zzia(int i) {
        return new zzw[i];
    }
}
