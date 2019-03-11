package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
    public static final Creator<DataDeleteRequest> CREATOR = new zzd();
    private final int zzFG;
    private final String zzFO;
    private final long zzON;
    private final List<DataType> zzYA;
    private final long zzYq;
    private final zznv zzaaN;
    private final List<DataSource> zzaaO;
    private final List<Session> zzaaP;
    private final boolean zzaaQ;
    private final boolean zzaaR;

    public static class Builder {
        private long zzON;
        private List<DataType> zzYA = new ArrayList();
        private long zzYq;
        private List<DataSource> zzaaO = new ArrayList();
        private List<Session> zzaaP = new ArrayList();
        private boolean zzaaQ = false;
        private boolean zzaaR = false;

        private void zzlT() {
            if (!this.zzaaP.isEmpty()) {
                for (Session session : this.zzaaP) {
                    boolean z = session.getStartTime(TimeUnit.MILLISECONDS) >= this.zzON && session.getEndTime(TimeUnit.MILLISECONDS) <= this.zzYq;
                    zzx.zza(z, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.zzON), Long.valueOf(this.zzYq));
                }
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            zzx.zzb(!this.zzaaQ, (Object) "All data is already marked for deletion");
            if (dataSource == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data source");
            if (!this.zzaaO.contains(dataSource)) {
                this.zzaaO.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            zzx.zzb(!this.zzaaQ, (Object) "All data is already marked for deletion");
            if (dataType == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data type");
            if (!this.zzYA.contains(dataType)) {
                this.zzYA.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            zzx.zzb(!this.zzaaR, (Object) "All sessions already marked for deletion");
            zzx.zzb(session != null, (Object) "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a session that has already ended");
            this.zzaaP.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            boolean z = false;
            boolean z2 = this.zzON > 0 && this.zzYq > this.zzON;
            zzx.zza(z2, (Object) "Must specify a valid time interval");
            z2 = (!this.zzaaQ && this.zzaaO.isEmpty() && this.zzYA.isEmpty()) ? false : true;
            boolean z3 = this.zzaaR || !this.zzaaP.isEmpty();
            if (z2 || z3) {
                z = true;
            }
            zzx.zza(z, (Object) "No data or session marked for deletion");
            zzlT();
            return new DataDeleteRequest();
        }

        public Builder deleteAllData() {
            boolean z = this.zzYA.isEmpty() && this.zzaaO.isEmpty();
            zzx.zzb(z, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", this.zzaaO, this.zzYA);
            this.zzaaQ = true;
            return this;
        }

        public Builder deleteAllSessions() {
            zzx.zzb(this.zzaaP.isEmpty(), "Specific sessions already added for deletion: %s", this.zzaaP);
            this.zzaaR = true;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            zzx.zzb(startTime > 0, "Invalid start time :%d", Long.valueOf(startTime));
            zzx.zzb(endTime > startTime, "Invalid end time :%d", Long.valueOf(endTime));
            this.zzON = timeUnit.toMillis(startTime);
            this.zzYq = timeUnit.toMillis(endTime);
            return this;
        }
    }

    DataDeleteRequest(int versionCode, long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions, IBinder callback, String packageName) {
        this.zzFG = versionCode;
        this.zzON = startTimeMillis;
        this.zzYq = endTimeMillis;
        this.zzaaO = Collections.unmodifiableList(dataSources);
        this.zzYA = Collections.unmodifiableList(dataTypes);
        this.zzaaP = sessions;
        this.zzaaQ = deleteAllData;
        this.zzaaR = deleteAllSessions;
        this.zzaaN = callback == null ? null : zza.zzaS(callback);
        this.zzFO = packageName;
    }

    public DataDeleteRequest(long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions, zznv callback, String packageName) {
        this.zzFG = 2;
        this.zzON = startTimeMillis;
        this.zzYq = endTimeMillis;
        this.zzaaO = Collections.unmodifiableList(dataSources);
        this.zzYA = Collections.unmodifiableList(dataTypes);
        this.zzaaP = sessions;
        this.zzaaQ = deleteAllData;
        this.zzaaR = deleteAllSessions;
        this.zzaaN = callback;
        this.zzFO = packageName;
    }

    private DataDeleteRequest(Builder builder) {
        this(builder.zzON, builder.zzYq, builder.zzaaO, builder.zzYA, builder.zzaaP, builder.zzaaQ, builder.zzaaR, null, null);
    }

    public DataDeleteRequest(DataDeleteRequest request, zznv callback, String packageName) {
        this(request.zzON, request.zzYq, request.zzaaO, request.zzYA, request.zzaaP, request.zzaaQ, request.zzaaR, callback, packageName);
    }

    private boolean zzb(DataDeleteRequest dataDeleteRequest) {
        return this.zzON == dataDeleteRequest.zzON && this.zzYq == dataDeleteRequest.zzYq && zzw.equal(this.zzaaO, dataDeleteRequest.zzaaO) && zzw.equal(this.zzYA, dataDeleteRequest.zzYA) && zzw.equal(this.zzaaP, dataDeleteRequest.zzaaP) && this.zzaaQ == dataDeleteRequest.zzaaQ && this.zzaaR == dataDeleteRequest.zzaaR;
    }

    public boolean deleteAllData() {
        return this.zzaaQ;
    }

    public boolean deleteAllSessions() {
        return this.zzaaR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataDeleteRequest) && zzb((DataDeleteRequest) o));
    }

    public List<DataSource> getDataSources() {
        return this.zzaaO;
    }

    public List<DataType> getDataTypes() {
        return this.zzYA;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzYq, TimeUnit.MILLISECONDS);
    }

    public String getPackageName() {
        return this.zzFO;
    }

    public List<Session> getSessions() {
        return this.zzaaP;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzON, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzON), Long.valueOf(this.zzYq));
    }

    public String toString() {
        return zzw.zzk(this).zza("startTimeMillis", Long.valueOf(this.zzON)).zza("endTimeMillis", Long.valueOf(this.zzYq)).zza("dataSources", this.zzaaO).zza("dateTypes", this.zzYA).zza("sessions", this.zzaaP).zza("deleteAllData", Boolean.valueOf(this.zzaaQ)).zza("deleteAllSessions", Boolean.valueOf(this.zzaaR)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public boolean zzlR() {
        return this.zzaaQ;
    }

    public boolean zzlS() {
        return this.zzaaR;
    }

    public long zzlp() {
        return this.zzON;
    }

    public long zzlq() {
        return this.zzYq;
    }
}
