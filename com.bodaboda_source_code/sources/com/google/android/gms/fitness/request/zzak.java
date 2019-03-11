package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzak implements SafeParcelable {
    public static final Creator<zzak> CREATOR = new zzal();
    private final int zzFG;
    private final String zzFO;
    private final Session zzYs;
    private final zznv zzaaN;

    zzak(int i, Session session, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzYs = session;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str;
    }

    public zzak(Session session, zznv zznv, String str) {
        zzx.zzb(session.isOngoing(), (Object) "Cannot start a session which has already ended");
        this.zzFG = 2;
        this.zzYs = session;
        this.zzaaN = zznv;
        this.zzFO = str;
    }

    private boolean zzb(zzak zzak) {
        return zzw.equal(this.zzYs, zzak.zzYs);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof zzak) && zzb((zzak) o));
    }

    public String getPackageName() {
        return this.zzFO;
    }

    public Session getSession() {
        return this.zzYs;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYs);
    }

    public String toString() {
        return zzw.zzk(this).zza("session", this.zzYs).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzal.zza(this, dest, flags);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }
}
