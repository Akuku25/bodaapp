package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzsb implements Creator<zzsa> {
    static void zza(zzsa zzsa, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzsa.versionCode);
        zzb.zza(parcel, 2, zzsa.zzatk, i, false);
        zzb.zza(parcel, 3, zzsa.zzatl, i, false);
        zzb.zza(parcel, 4, zzsa.zzrq(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgA(x0);
    }

    public zzsa zzeo(Parcel parcel) {
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzrr zzrr = null;
        zzrw zzrw = null;
        while (parcel.dataPosition() < zzJ) {
            zzrr zzrr2;
            zzrw zzrw2;
            int zzg;
            IBinder iBinder2;
            int zzI = zza.zzI(parcel);
            IBinder iBinder3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    iBinder3 = iBinder;
                    zzrr2 = zzrr;
                    zzrw2 = zzrw;
                    zzg = zza.zzg(parcel, zzI);
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    zzg = i;
                    zzrr zzrr3 = zzrr;
                    zzrw2 = (zzrw) zza.zza(parcel, zzI, zzrw.CREATOR);
                    iBinder2 = iBinder;
                    zzrr2 = zzrr3;
                    break;
                case 3:
                    zzrw2 = zzrw;
                    zzg = i;
                    iBinder3 = iBinder;
                    zzrr2 = (zzrr) zza.zza(parcel, zzI, zzrr.CREATOR);
                    iBinder2 = iBinder3;
                    break;
                case 4:
                    iBinder2 = zza.zzp(parcel, zzI);
                    zzrr2 = zzrr;
                    zzrw2 = zzrw;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    iBinder2 = iBinder;
                    zzrr2 = zzrr;
                    zzrw2 = zzrw;
                    zzg = i;
                    break;
            }
            i = zzg;
            zzrw = zzrw2;
            zzrr = zzrr2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzsa(i, zzrw, zzrr, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzsa[] zzgA(int i) {
        return new zzsa[i];
    }
}
