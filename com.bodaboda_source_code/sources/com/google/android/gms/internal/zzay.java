package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzay implements Creator<zzax> {
    static void zza(zzax zzax, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzax.versionCode);
        zzb.zza(parcel, 2, zzax.zzoL);
        zzb.zza(parcel, 3, zzax.extras, false);
        zzb.zzc(parcel, 4, zzax.zzoM);
        zzb.zzb(parcel, 5, zzax.zzoN, false);
        zzb.zza(parcel, 6, zzax.zzoO);
        zzb.zzc(parcel, 7, zzax.zzoP);
        zzb.zza(parcel, 8, zzax.zzoQ);
        zzb.zza(parcel, 9, zzax.zzoR, false);
        zzb.zza(parcel, 10, zzax.zzoS, i, false);
        zzb.zza(parcel, 11, zzax.zzoT, i, false);
        zzb.zza(parcel, 12, zzax.zzoU, false);
        zzb.zza(parcel, 13, zzax.zzoV, false);
        zzb.zza(parcel, 14, zzax.zzoW, false);
        zzb.zzb(parcel, 15, zzax.zzoX, false);
        zzb.zza(parcel, 16, zzax.zzoY, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzf(x0);
    }

    public zzax zzb(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        zzbs zzbs = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
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
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    list = zza.zzC(parcel, zzI);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 7:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 10:
                    zzbs = (zzbs) zza.zza(parcel, zzI, zzbs.CREATOR);
                    break;
                case 11:
                    location = (Location) zza.zza(parcel, zzI, Location.CREATOR);
                    break;
                case 12:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 13:
                    bundle2 = zza.zzq(parcel, zzI);
                    break;
                case 14:
                    bundle3 = zza.zzq(parcel, zzI);
                    break;
                case 15:
                    list2 = zza.zzC(parcel, zzI);
                    break;
                case 16:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzax(i, j, bundle, i2, list, z, i3, z2, str, zzbs, location, str2, bundle2, bundle3, list2, str3);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzax[] zzf(int i) {
        return new zzax[i];
    }
}
