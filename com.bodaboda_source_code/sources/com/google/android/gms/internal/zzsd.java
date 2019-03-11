package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzsd implements Creator<zzsc> {
    static void zza(zzsc zzsc, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzsc.versionCode);
        zzb.zza(parcel, 2, zzsc.zzrr(), false);
        zzb.zza(parcel, 3, zzsc.zzatl, i, false);
        zzb.zza(parcel, 4, zzsc.zzrq(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzep(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgB(x0);
    }

    public zzsc zzep(Parcel parcel) {
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzrr zzrr = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzJ) {
            zzrr zzrr2;
            IBinder iBinder3;
            int zzg;
            IBinder iBinder4;
            int zzI = zza.zzI(parcel);
            IBinder iBinder5;
            switch (zza.zzaP(zzI)) {
                case 1:
                    iBinder5 = iBinder;
                    zzrr2 = zzrr;
                    iBinder3 = iBinder2;
                    zzg = zza.zzg(parcel, zzI);
                    iBinder4 = iBinder5;
                    break;
                case 2:
                    zzg = i;
                    zzrr zzrr3 = zzrr;
                    iBinder3 = zza.zzp(parcel, zzI);
                    iBinder4 = iBinder;
                    zzrr2 = zzrr3;
                    break;
                case 3:
                    iBinder3 = iBinder2;
                    zzg = i;
                    iBinder5 = iBinder;
                    zzrr2 = (zzrr) zza.zza(parcel, zzI, zzrr.CREATOR);
                    iBinder4 = iBinder5;
                    break;
                case 4:
                    iBinder4 = zza.zzp(parcel, zzI);
                    zzrr2 = zzrr;
                    iBinder3 = iBinder2;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    iBinder4 = iBinder;
                    zzrr2 = zzrr;
                    iBinder3 = iBinder2;
                    zzg = i;
                    break;
            }
            i = zzg;
            iBinder2 = iBinder3;
            zzrr = zzrr2;
            iBinder = iBinder4;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzsc(i, iBinder2, zzrr, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzsc[] zzgB(int i) {
        return new zzsc[i];
    }
}
