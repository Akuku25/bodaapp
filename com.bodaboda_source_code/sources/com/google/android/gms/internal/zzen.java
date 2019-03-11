package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzen implements Creator<zzeo> {
    static void zza(zzeo zzeo, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzeo.versionCode);
        zzb.zza(parcel, 2, zzeo.zzun, i, false);
        zzb.zza(parcel, 3, zzeo.zzdi(), false);
        zzb.zza(parcel, 4, zzeo.zzdj(), false);
        zzb.zza(parcel, 5, zzeo.zzdk(), false);
        zzb.zza(parcel, 6, zzeo.zzdl(), false);
        zzb.zza(parcel, 7, zzeo.zzus, false);
        zzb.zza(parcel, 8, zzeo.zzut);
        zzb.zza(parcel, 9, zzeo.zzuu, false);
        zzb.zza(parcel, 10, zzeo.zzdn(), false);
        zzb.zzc(parcel, 11, zzeo.orientation);
        zzb.zzc(parcel, 12, zzeo.zzuw);
        zzb.zza(parcel, 13, zzeo.zztR, false);
        zzb.zza(parcel, 14, zzeo.zzlP, i, false);
        zzb.zza(parcel, 15, zzeo.zzdm(), false);
        zzb.zza(parcel, 17, zzeo.zzuz, i, false);
        zzb.zza(parcel, 16, zzeo.zzuy, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzq(x0);
    }

    public zzeo zzf(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzek zzek = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        zzhy zzhy = null;
        IBinder iBinder6 = null;
        String str4 = null;
        zzx zzx = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    zzek = (zzek) zza.zza(parcel, zzI, zzek.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 4:
                    iBinder2 = zza.zzp(parcel, zzI);
                    break;
                case 5:
                    iBinder3 = zza.zzp(parcel, zzI);
                    break;
                case 6:
                    iBinder4 = zza.zzp(parcel, zzI);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 9:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 10:
                    iBinder5 = zza.zzp(parcel, zzI);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 13:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 14:
                    zzhy = (zzhy) zza.zza(parcel, zzI, (Creator) zzhy.CREATOR);
                    break;
                case 15:
                    iBinder6 = zza.zzp(parcel, zzI);
                    break;
                case 16:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 17:
                    zzx = (zzx) zza.zza(parcel, zzI, (Creator) zzx.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzeo(i, zzek, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, zzhy, iBinder6, str4, zzx);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzeo[] zzq(int i) {
        return new zzeo[i];
    }
}
