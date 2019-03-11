package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzq;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Creator<SessionReadResult> CREATOR = new zzl();
    private final int zzFG;
    private final Status zzHb;
    private final List<Session> zzaaP;
    private final List<zzq> zzabU;

    SessionReadResult(int versionCode, List<Session> sessions, List<zzq> sessionDataSets, Status status) {
        this.zzFG = versionCode;
        this.zzaaP = sessions;
        this.zzabU = Collections.unmodifiableList(sessionDataSets);
        this.zzHb = status;
    }

    public SessionReadResult(List<Session> sessions, List<zzq> sessionDataSets, Status status) {
        this.zzFG = 3;
        this.zzaaP = sessions;
        this.zzabU = Collections.unmodifiableList(sessionDataSets);
        this.zzHb = status;
    }

    public static SessionReadResult zzF(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionReadResult) {
        return this.zzHb.equals(sessionReadResult.zzHb) && zzw.equal(this.zzaaP, sessionReadResult.zzaaP) && zzw.equal(this.zzabU, sessionReadResult.zzabU);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionReadResult) && zzb((SessionReadResult) that));
    }

    public List<DataSet> getDataSet(Session session) {
        zzx.zzb(this.zzaaP.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (zzq zzq : this.zzabU) {
            if (zzw.equal(session, zzq.getSession())) {
                arrayList.add(zzq.zzlH());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        zzx.zzb(this.zzaaP.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (zzq zzq : this.zzabU) {
            if (zzw.equal(session, zzq.getSession()) && dataType.equals(zzq.zzlH().getDataType())) {
                arrayList.add(zzq.zzlH());
            }
        }
        return arrayList;
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
        return zzw.hashCode(this.zzHb, this.zzaaP, this.zzabU);
    }

    public String toString() {
        return zzw.zzk(this).zza(Games.EXTRA_STATUS, this.zzHb).zza("sessions", this.zzaaP).zza("sessionDataSets", this.zzabU).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    public List<zzq> zzmt() {
        return this.zzabU;
    }
}
