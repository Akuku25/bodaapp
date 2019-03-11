package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class zzay implements Creator<zzax> {
    static void zza(zzax zzax, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzax.getDataType(), i, false);
        zzb.zzc(parcel, 1000, zzax.getVersionCode());
        zzb.zza(parcel, 2, zzax.getDataSource(), i, false);
        zzb.zza(parcel, 3, zzax.zzlQ(), false);
        zzb.zza(parcel, 4, zzax.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeb(x0);
    }

    public zzax zzcC(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        DataSource dataSource = null;
        DataType dataType = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    dataType = (DataType) zza.zza(parcel, zzI, DataType.CREATOR);
                    break;
                case 2:
                    dataSource = (DataSource) zza.zza(parcel, zzI, DataSource.CREATOR);
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
            return new zzax(i, dataType, dataSource, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzax[] zzeb(int i) {
        return new zzax[i];
    }
}
