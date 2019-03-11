package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Set;

public class zzc implements SafeParcelable {
    public static final Creator<zzc> CREATOR = new zzd();
    final int zzFG;
    final IBinder zzPn;
    final Scope[] zzPo;

    zzc(int i, IBinder iBinder, Scope[] scopeArr) {
        this.zzFG = i;
        this.zzPn = iBinder;
        this.zzPo = scopeArr;
    }

    public zzc(zzq zzq, Set<Scope> set) {
        this(1, zzq.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
