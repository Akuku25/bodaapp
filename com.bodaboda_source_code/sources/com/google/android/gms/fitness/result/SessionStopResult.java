package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.games.Games;
import java.util.Collections;
import java.util.List;

public class SessionStopResult implements Result, SafeParcelable {
    public static final Creator<SessionStopResult> CREATOR = new zzm();
    private final int zzFG;
    private final Status zzHb;
    private final List<Session> zzaaP;

    SessionStopResult(int versionCode, Status status, List<Session> sessions) {
        this.zzFG = versionCode;
        this.zzHb = status;
        this.zzaaP = Collections.unmodifiableList(sessions);
    }

    public SessionStopResult(Status status, List<Session> sessions) {
        this.zzFG = 3;
        this.zzHb = status;
        this.zzaaP = Collections.unmodifiableList(sessions);
    }

    public static SessionStopResult zzG(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean zzb(SessionStopResult sessionStopResult) {
        return this.zzHb.equals(sessionStopResult.zzHb) && zzw.equal(this.zzaaP, sessionStopResult.zzaaP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof SessionStopResult) && zzb((SessionStopResult) o));
    }

    public List<Session> getSessions() {
        return this.zzaaP;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, this.zzaaP);
    }

    public String toString() {
        return zzw.zzk(this).zza(Games.EXTRA_STATUS, this.zzHb).zza("sessions", this.zzaaP).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }
}
