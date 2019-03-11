package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<zzb> {
    static void zza(zzb zzb, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzb.zzFG);
        zzb.zza(parcel, 2, zzb.zzva(), false);
        zzb.zza(parcel, 3, zzb.zzaFO, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhU(x0);
    }

    public zzb zzfu(Parcel parcel) {
        IntentFilter[] intentFilterArr = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) zza.zzb(parcel, zzI, IntentFilter.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzb(i, iBinder, intentFilterArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzb[] zzhU(int i) {
        return new zzb[i];
    }
}
