package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz implements Creator<zzy> {
    static void zza(zzy zzy, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzy.getVersionCode());
        zzb.zza(parcel, 2, zzy.zzqE(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfU(x0);
    }

    public zzy zzdR(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Point point = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    point = (Point) zza.zza(parcel, zzI, Point.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzy(i, point);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzy[] zzfU(int i) {
        return new zzy[i];
    }
}
