package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzts implements Creator<zztr> {
    static void zza(zztr zztr, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        Set set = zztr.zzauX;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, zztr.zzFG);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, zztr.zzauY, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzb(parcel, 3, zztr.zzauZ, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, zztr.zzava, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, zztr.zzavb, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, zztr.zzavc, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, zztr.zzavd, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zzc(parcel, 8, zztr.zzave, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zzc(parcel, 9, zztr.zzavf);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zzc(parcel, 10, zztr.zzavg, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zza(parcel, 11, zztr.zzavh, i, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zzc(parcel, 12, zztr.zzavi, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, zztr.zzavj, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, zztr.zzavk, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zza(parcel, 15, zztr.zzavl, i, true);
        }
        if (set.contains(Integer.valueOf(17))) {
            zzb.zza(parcel, 17, zztr.zzavn, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzb.zza(parcel, 16, zztr.zzavm, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzb.zzc(parcel, 19, zztr.zzavo, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzb.zza(parcel, 18, zztr.zzpn, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzb.zza(parcel, 21, zztr.zzavq, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzb.zza(parcel, 20, zztr.zzavp, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzb.zza(parcel, 23, zztr.zzZO, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzb.zza(parcel, 22, zztr.zzavr, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzb.zza(parcel, 25, zztr.zzavt, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzb.zza(parcel, 24, zztr.zzavs, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzb.zza(parcel, 27, zztr.zzavv, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzb.zza(parcel, 26, zztr.zzavu, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzb.zza(parcel, 29, zztr.zzavx, i, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzb.zza(parcel, 28, zztr.zzavw, true);
        }
        if (set.contains(Integer.valueOf(31))) {
            zzb.zza(parcel, 31, zztr.zzavz, true);
        }
        if (set.contains(Integer.valueOf(30))) {
            zzb.zza(parcel, 30, zztr.zzavy, true);
        }
        if (set.contains(Integer.valueOf(34))) {
            zzb.zza(parcel, 34, zztr.zzavB, i, true);
        }
        if (set.contains(Integer.valueOf(32))) {
            zzb.zza(parcel, 32, zztr.zzFA, true);
        }
        if (set.contains(Integer.valueOf(33))) {
            zzb.zza(parcel, 33, zztr.zzavA, true);
        }
        if (set.contains(Integer.valueOf(38))) {
            zzb.zza(parcel, 38, zztr.zzalR);
        }
        if (set.contains(Integer.valueOf(39))) {
            zzb.zza(parcel, 39, zztr.mName, true);
        }
        if (set.contains(Integer.valueOf(36))) {
            zzb.zza(parcel, 36, zztr.zzalQ);
        }
        if (set.contains(Integer.valueOf(37))) {
            zzb.zza(parcel, 37, zztr.zzavC, i, true);
        }
        if (set.contains(Integer.valueOf(42))) {
            zzb.zza(parcel, 42, zztr.zzavF, true);
        }
        if (set.contains(Integer.valueOf(43))) {
            zzb.zza(parcel, 43, zztr.zzavG, true);
        }
        if (set.contains(Integer.valueOf(40))) {
            zzb.zza(parcel, 40, zztr.zzavD, i, true);
        }
        if (set.contains(Integer.valueOf(41))) {
            zzb.zzc(parcel, 41, zztr.zzavE, true);
        }
        if (set.contains(Integer.valueOf(46))) {
            zzb.zza(parcel, 46, zztr.zzavJ, i, true);
        }
        if (set.contains(Integer.valueOf(47))) {
            zzb.zza(parcel, 47, zztr.zzavK, true);
        }
        if (set.contains(Integer.valueOf(44))) {
            zzb.zza(parcel, 44, zztr.zzavH, true);
        }
        if (set.contains(Integer.valueOf(45))) {
            zzb.zza(parcel, 45, zztr.zzavI, true);
        }
        if (set.contains(Integer.valueOf(51))) {
            zzb.zza(parcel, 51, zztr.zzavO, true);
        }
        if (set.contains(Integer.valueOf(50))) {
            zzb.zza(parcel, 50, zztr.zzavN, i, true);
        }
        if (set.contains(Integer.valueOf(49))) {
            zzb.zza(parcel, 49, zztr.zzavM, true);
        }
        if (set.contains(Integer.valueOf(48))) {
            zzb.zza(parcel, 48, zztr.zzavL, true);
        }
        if (set.contains(Integer.valueOf(55))) {
            zzb.zza(parcel, 55, zztr.zzavQ, true);
        }
        if (set.contains(Integer.valueOf(54))) {
            zzb.zza(parcel, 54, zztr.zzxX, true);
        }
        if (set.contains(Integer.valueOf(53))) {
            zzb.zza(parcel, 53, zztr.zzxV, true);
        }
        if (set.contains(Integer.valueOf(52))) {
            zzb.zza(parcel, 52, zztr.zzavP, true);
        }
        if (set.contains(Integer.valueOf(56))) {
            zzb.zza(parcel, 56, zztr.zzavR, true);
        }
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzez(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgM(x0);
    }

    public zztr zzez(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        zztr zztr = null;
        List list = null;
        zztr zztr2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        int i2 = 0;
        List list3 = null;
        zztr zztr3 = null;
        List list4 = null;
        String str4 = null;
        String str5 = null;
        zztr zztr4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        List list5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        zztr zztr5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        zztr zztr6 = null;
        double d = 0.0d;
        zztr zztr7 = null;
        double d2 = 0.0d;
        String str22 = null;
        zztr zztr8 = null;
        List list6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        zztr zztr9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        zztr zztr10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            zztr zztr11;
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    zztr11 = (zztr) zza.zza(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    zztr = zztr11;
                    break;
                case 3:
                    list = zza.zzC(parcel, zzI);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    zztr11 = (zztr) zza.zza(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    zztr2 = zztr11;
                    break;
                case 5:
                    str = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str3 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    list2 = zza.zzc(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    i2 = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    list3 = zza.zzc(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    zztr11 = (zztr) zza.zza(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    zztr3 = zztr11;
                    break;
                case 12:
                    list4 = zza.zzc(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str4 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str5 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    zztr11 = (zztr) zza.zza(parcel, zzI, (Creator) zztr.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    zztr4 = zztr11;
                    break;
                case 16:
                    str6 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    str7 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    str8 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    list5 = zza.zzc(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case 20:
                    str9 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    str10 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    str11 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    str12 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    str13 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    str14 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str15 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str16 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    str17 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    zztr11 = (zztr) zza.zza(parcel, zzI, (Creator) zztr.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    zztr5 = zztr11;
                    break;
                case 30:
                    str18 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case 31:
                    str19 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case 32:
                    str20 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str21 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case 34:
                    zztr11 = (zztr) zza.zza(parcel, zzI, (Creator) zztr.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    zztr6 = zztr11;
                    break;
                case 36:
                    d = zza.zzm(parcel, zzI);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    zztr11 = (zztr) zza.zza(parcel, zzI, (Creator) zztr.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    zztr7 = zztr11;
                    break;
                case 38:
                    d2 = zza.zzm(parcel, zzI);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str22 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case 40:
                    zztr11 = (zztr) zza.zza(parcel, zzI, (Creator) zztr.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    zztr8 = zztr11;
                    break;
                case 41:
                    list6 = zza.zzc(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case 42:
                    str23 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str24 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case 44:
                    str25 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str26 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case 46:
                    zztr11 = (zztr) zza.zza(parcel, zzI, (Creator) zztr.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    zztr9 = zztr11;
                    break;
                case 47:
                    str27 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case 48:
                    str28 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case 49:
                    str29 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case 50:
                    zztr11 = (zztr) zza.zza(parcel, zzI, (Creator) zztr.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    zztr10 = zztr11;
                    break;
                case 51:
                    str30 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case 52:
                    str31 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case 53:
                    str32 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case 54:
                    str33 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case 55:
                    str34 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case 56:
                    str35 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zztr(hashSet, i, zztr, list, zztr2, str, str2, str3, list2, i2, list3, zztr3, list4, str4, str5, zztr4, str6, str7, str8, list5, str9, str10, str11, str12, str13, str14, str15, str16, str17, zztr5, str18, str19, str20, str21, zztr6, d, zztr7, d2, str22, zztr8, list6, str23, str24, str25, str26, zztr9, str27, str28, str29, zztr10, str30, str31, str32, str33, str34, str35);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zztr[] zzgM(int i) {
        return new zztr[i];
    }
}
