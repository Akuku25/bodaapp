package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzan implements Creator<zzam> {
    static void zza(zzam zzam, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzam.getName(), false);
        zzb.zzc(parcel, 1000, zzam.getVersionCode());
        zzb.zza(parcel, 2, zzam.getIdentifier(), false);
        zzb.zza(parcel, 3, zzam.zzlQ(), false);
        zzb.zza(parcel, 4, zzam.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdV(x0);
    }

    public zzam zzcw(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzI);
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
            return new zzam(i, str3, str2, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzam[] zzdV(int i) {
        return new zzam[i];
    }
}
