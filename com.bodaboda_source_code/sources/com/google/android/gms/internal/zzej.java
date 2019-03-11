package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzej implements Creator<zzek> {
    static void zza(zzek zzek, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzek.versionCode);
        zzb.zza(parcel, 2, zzek.zztQ, false);
        zzb.zza(parcel, 3, zzek.zztR, false);
        zzb.zza(parcel, 4, zzek.mimeType, false);
        zzb.zza(parcel, 5, zzek.packageName, false);
        zzb.zza(parcel, 6, zzek.zztS, false);
        zzb.zza(parcel, 7, zzek.zztT, false);
        zzb.zza(parcel, 8, zzek.zztU, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zze(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzo(x0);
    }

    public zzek zze(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str7 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzek(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzek[] zzo(int i) {
        return new zzek[i];
    }
}
