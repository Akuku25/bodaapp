package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzqb implements Creator<zzqa> {
    static void zza(zzqa zzqa, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzqa.zzaoO, i, false);
        zzb.zzc(parcel, 1000, zzqa.zzFG);
        zzb.zza(parcel, 2, zzqa.zzaoP);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfJ(x0);
    }

    public zzqa zzdG(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzpy zzpy = null;
        float f = 0.0f;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            float f2;
            zzpy zzpy2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = i;
                    zzpy zzpy3 = (zzpy) zza.zza(parcel, zzI, zzpy.CREATOR);
                    f2 = f;
                    zzpy2 = zzpy3;
                    break;
                case 2:
                    f2 = zza.zzl(parcel, zzI);
                    zzpy2 = zzpy;
                    i2 = i;
                    break;
                case 1000:
                    float f3 = f;
                    zzpy2 = zzpy;
                    i2 = zza.zzg(parcel, zzI);
                    f2 = f3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    f2 = f;
                    zzpy2 = zzpy;
                    i2 = i;
                    break;
            }
            i = i2;
            zzpy = zzpy2;
            f = f2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzqa(i, zzpy, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzqa[] zzfJ(int i) {
        return new zzqa[i];
    }
}
