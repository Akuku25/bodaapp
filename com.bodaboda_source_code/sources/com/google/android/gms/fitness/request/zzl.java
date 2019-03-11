package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zzni.zza;

public class zzl implements SafeParcelable {
    public static final Creator<zzl> CREATOR = new zzm();
    private final String mName;
    private final int zzFG;
    private final String zzFO;
    private final zzni zzabi;

    zzl(int i, String str, IBinder iBinder, String str2) {
        this.zzFG = i;
        this.mName = str;
        this.zzabi = iBinder == null ? null : zza.zzaF(iBinder);
        this.zzFO = str2;
    }

    public zzl(String str, zzni zzni, String str2) {
        this.zzFG = 2;
        this.mName = str;
        this.zzabi = zzni;
        this.zzFO = str2;
    }

    private boolean zzb(zzl zzl) {
        return zzw.equal(this.mName, zzl.mName);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof zzl) && zzb((zzl) o));
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName);
    }

    public String toString() {
        return zzw.zzk(this).zza("name", this.mName).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }

    public IBinder zzlQ() {
        return this.zzabi.asBinder();
    }
}
