package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzpl implements Creator<zzpk> {
    static void zza(zzpk zzpk, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzpk.getRequestId(), false);
        zzb.zzc(parcel, 1000, zzpk.getVersionCode());
        zzb.zza(parcel, 2, zzpk.getExpirationTime());
        zzb.zza(parcel, 3, zzpk.zzpB());
        zzb.zza(parcel, 4, zzpk.getLatitude());
        zzb.zza(parcel, 5, zzpk.getLongitude());
        zzb.zza(parcel, 6, zzpk.zzpC());
        zzb.zzc(parcel, 7, zzpk.zzpD());
        zzb.zzc(parcel, 8, zzpk.getNotificationResponsiveness());
        zzb.zzc(parcel, 9, zzpk.zzpE());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfy(x0);
    }

    public zzpk zzdx(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    s = zza.zzf(parcel, zzI);
                    break;
                case 4:
                    d = zza.zzm(parcel, zzI);
                    break;
                case 5:
                    d2 = zza.zzm(parcel, zzI);
                    break;
                case 6:
                    f = zza.zzl(parcel, zzI);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 8:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 9:
                    i4 = zza.zzg(parcel, zzI);
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
            return new zzpk(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzpk[] zzfy(int i) {
        return new zzpk[i];
    }
}
