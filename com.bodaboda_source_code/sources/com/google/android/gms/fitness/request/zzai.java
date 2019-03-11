package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzai implements SafeParcelable {
    public static final Creator<zzai> CREATOR = new zzaj();
    private final PendingIntent mPendingIntent;
    private final int zzFG;
    private final String zzFO;
    private final zznv zzaaN;

    zzai(int i, PendingIntent pendingIntent, IBinder iBinder, String str) {
        this.zzFG = i;
        this.mPendingIntent = pendingIntent;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str;
    }

    public zzai(PendingIntent pendingIntent, zznv zznv, String str) {
        this.zzFG = 4;
        this.mPendingIntent = pendingIntent;
        this.zzaaN = zznv;
        this.zzFO = str;
    }

    private boolean zzb(zzai zzai) {
        return zzw.equal(this.mPendingIntent, zzai.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof zzai) && zzb((zzai) that));
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return zzw.zzk(this).zza("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzaj.zza(this, parcel, flags);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public PendingIntent zzmb() {
        return this.mPendingIntent;
    }
}
