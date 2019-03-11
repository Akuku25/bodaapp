package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Games;

public class zzn implements Result, SafeParcelable {
    public static final Creator<zzn> CREATOR = new zzo();
    private final int zzFG;
    private final Status zzHb;
    private final long zzLk;

    zzn(int i, Status status, long j) {
        this.zzFG = i;
        this.zzHb = status;
        this.zzLk = j;
    }

    private boolean zzb(zzn zzn) {
        return this.zzHb.equals(zzn.zzHb) && zzw.equal(Long.valueOf(this.zzLk), Long.valueOf(zzn.zzLk));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof zzn) && zzb((zzn) that));
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, Long.valueOf(this.zzLk));
    }

    public String toString() {
        return zzw.zzk(this).zza(Games.EXTRA_STATUS, this.zzHb).zza("timestamp", Long.valueOf(this.zzLk)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }

    public long zzmu() {
        return this.zzLk;
    }
}
