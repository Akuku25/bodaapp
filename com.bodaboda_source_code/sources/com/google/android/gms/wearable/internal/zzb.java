package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzah.zza;

public class zzb implements SafeParcelable {
    public static final Creator<zzb> CREATOR = new zzc();
    final int zzFG;
    public final zzah zzaFN;
    public final IntentFilter[] zzaFO;

    zzb(int i, IBinder iBinder, IntentFilter[] intentFilterArr) {
        this.zzFG = i;
        if (iBinder != null) {
            this.zzaFN = zza.zzcQ(iBinder);
        } else {
            this.zzaFN = null;
        }
        this.zzaFO = intentFilterArr;
    }

    public zzb(zzbe zzbe) {
        this.zzFG = 1;
        this.zzaFN = zzbe;
        this.zzaFO = zzbe.zzvm();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    IBinder zzva() {
        return this.zzaFN == null ? null : this.zzaFN.asBinder();
    }
}
