package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<zzl> {
    static void zza(zzl zzl, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzl.zzamw);
        zzb.zzc(parcel, 1000, zzl.getVersionCode());
        zzb.zzc(parcel, 2, zzl.zzamx);
        zzb.zza(parcel, 3, zzl.zzamy);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfs(x0);
    }

    public zzl zzdt(Parcel parcel) {
        int i = 1;
        int zzJ = zza.zzJ(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzl(i2, i3, i, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzl[] zzfs(int i) {
        return new zzl[i];
    }
}
