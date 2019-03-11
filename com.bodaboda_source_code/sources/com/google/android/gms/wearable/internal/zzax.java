package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzax implements Creator<zzaw> {
    static void zza(zzaw zzaw, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzaw.versionCode);
        zzb.zzc(parcel, 2, zzaw.statusCode);
        zzb.zzc(parcel, 3, zzaw.zzaGD);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzik(x0);
    }

    public zzaw zzfK(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzaw(i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzaw[] zzik(int i) {
        return new zzaw[i];
    }
}
