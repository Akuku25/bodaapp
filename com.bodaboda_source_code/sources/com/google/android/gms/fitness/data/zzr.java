package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Creator<zzq> {
    static void zza(zzq zzq, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzq.getSession(), i, false);
        zzb.zzc(parcel, 1000, zzq.zzFG);
        zzb.zza(parcel, 2, zzq.zzlH(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdu(x0);
    }

    public zzq zzbW(Parcel parcel) {
        DataSet dataSet = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            DataSet dataSet2;
            Session session2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = i;
                    Session session3 = (Session) zza.zza(parcel, zzI, Session.CREATOR);
                    dataSet2 = dataSet;
                    session2 = session3;
                    break;
                case 2:
                    dataSet2 = (DataSet) zza.zza(parcel, zzI, DataSet.CREATOR);
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet;
                    session2 = session;
                    i2 = zza.zzg(parcel, zzI);
                    dataSet2 = dataSet3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    dataSet2 = dataSet;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzq(i, session, dataSet);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzq[] zzdu(int i) {
        return new zzq[i];
    }
}
