package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzab implements Creator<FetchThumbnailRequest> {
    static void zza(FetchThumbnailRequest fetchThumbnailRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, fetchThumbnailRequest.zzFG);
        zzb.zza(parcel, 2, fetchThumbnailRequest.zzTh, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzau(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbL(x0);
    }

    public FetchThumbnailRequest zzau(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new FetchThumbnailRequest(i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public FetchThumbnailRequest[] zzbL(int i) {
        return new FetchThumbnailRequest[i];
    }
}
