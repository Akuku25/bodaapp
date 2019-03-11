package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzsf implements Creator<zzse> {
    static void zza(zzse zzse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzse.versionCode);
        zzb.zza(parcel, 2, zzse.zzatk, i, false);
        zzb.zza(parcel, 3, zzse.zzrq(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgC(x0);
    }

    public zzse zzeq(Parcel parcel) {
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzrw zzrw = null;
        while (parcel.dataPosition() < zzJ) {
            zzrw zzrw2;
            int zzg;
            IBinder iBinder2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    IBinder iBinder3 = iBinder;
                    zzrw2 = zzrw;
                    zzg = zza.zzg(parcel, zzI);
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    zzg = i;
                    zzrw zzrw3 = (zzrw) zza.zza(parcel, zzI, zzrw.CREATOR);
                    iBinder2 = iBinder;
                    zzrw2 = zzrw3;
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzI);
                    zzrw2 = zzrw;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    iBinder2 = iBinder;
                    zzrw2 = zzrw;
                    zzg = i;
                    break;
            }
            i = zzg;
            zzrw = zzrw2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzse(i, zzrw, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzse[] zzgC(int i) {
        return new zzse[i];
    }
}
