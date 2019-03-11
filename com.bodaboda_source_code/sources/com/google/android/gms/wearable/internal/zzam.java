package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzam implements Creator<zzal> {
    static void zza(zzal zzal, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzal.zzFG);
        zzb.zzc(parcel, 2, zzal.getRequestId());
        zzb.zza(parcel, 3, zzal.getPath(), false);
        zzb.zza(parcel, 4, zzal.getData(), false);
        zzb.zza(parcel, 5, zzal.getSourceNodeId(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzif(x0);
    }

    public zzal zzfF(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        byte[] bArr = null;
        String str2 = null;
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
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    bArr = zza.zzr(parcel, zzI);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzal(i2, i, str2, bArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzal[] zzif(int i) {
        return new zzal[i];
    }
}
