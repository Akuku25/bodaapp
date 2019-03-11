package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzrx implements Creator<zzrw> {
    static void zza(zzrw zzrw, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzrw.zzati, i, false);
        zzb.zzc(parcel, 1000, zzrw.versionCode);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzen(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgz(x0);
    }

    public zzrw zzen(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzro zzro = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    zzro = (zzro) zza.zza(parcel, zzI, zzro.CREATOR);
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
            return new zzrw(i, zzro);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzrw[] zzgz(int i) {
        return new zzrw[i];
    }
}
