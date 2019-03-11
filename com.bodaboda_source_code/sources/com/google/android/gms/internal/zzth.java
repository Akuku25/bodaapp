package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzth implements Creator<zztf> {
    static void zza(zztf zztf, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zztf.versionCode);
        zzb.zza(parcel, 2, zztf.zzatM);
        zzb.zza(parcel, 3, zztf.tag, false);
        zzb.zza(parcel, 4, zztf.zzatN, false);
        zzb.zza(parcel, 5, zztf.zzatO, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzev(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgH(x0);
    }

    public zztf zzev(Parcel parcel) {
        Bundle bundle = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        byte[] bArr = null;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    bArr = zza.zzr(parcel, zzI);
                    break;
                case 5:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zztf(i, j, str, bArr, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zztf[] zzgH(int i) {
        return new zztf[i];
    }
}
