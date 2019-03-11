package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzjx implements Creator<zzjw> {
    static void zza(zzjw zzjw, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzjw.getVersionCode());
        zzb.zza(parcel, 2, zzjw.zzhs());
        zzb.zza(parcel, 3, zzjw.zzhA());
        zzb.zzc(parcel, 4, zzjw.zzhB());
        zzb.zza(parcel, 5, zzjw.getApplicationMetadata(), i, false);
        zzb.zzc(parcel, 6, zzjw.zzhC());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzam(x0);
    }

    public zzjw[] zzam(int i) {
        return new zzjw[i];
    }

    public zzjw zzx(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    d = zza.zzm(parcel, zzI);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) zza.zza(parcel, zzI, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzjw(i3, d, z, i2, applicationMetadata, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
