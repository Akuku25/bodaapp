package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.data.zzk.zza;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class zzac implements SafeParcelable {
    public static final Creator<zzac> CREATOR = new zzad();
    private final PendingIntent mPendingIntent;
    private final int zzFG;
    private final String zzFO;
    private final DataType zzYo;
    private final DataSource zzYp;
    private final long zzZQ;
    private final int zzZR;
    private final zznv zzaaN;
    private zzk zzabp;
    int zzabq;
    int zzabr;
    private final long zzabs;
    private final long zzabt;
    private final List<LocationRequest> zzabu;
    private final long zzabv;
    private final List<Object> zzabw;

    zzac(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4, IBinder iBinder2, String str) {
        this.zzFG = i;
        this.zzYp = dataSource;
        this.zzYo = dataType;
        this.zzabp = iBinder == null ? null : zza.zzav(iBinder);
        if (j == 0) {
            j = (long) i2;
        }
        this.zzZQ = j;
        this.zzabt = j3;
        if (j2 == 0) {
            j2 = (long) i3;
        }
        this.zzabs = j2;
        this.zzabu = list;
        this.mPendingIntent = pendingIntent;
        this.zzZR = i4;
        this.zzabw = Collections.emptyList();
        this.zzabv = j4;
        this.zzaaN = iBinder2 == null ? null : zznv.zza.zzaS(iBinder2);
        this.zzFO = str;
    }

    public zzac(DataSource dataSource, DataType dataType, zzk zzk, PendingIntent pendingIntent, long j, long j2, long j3, int i, List<LocationRequest> list, List<Object> list2, long j4, zznv zznv, String str) {
        this.zzFG = 5;
        this.zzYp = dataSource;
        this.zzYo = dataType;
        this.zzabp = zzk;
        this.mPendingIntent = pendingIntent;
        this.zzZQ = j;
        this.zzabt = j2;
        this.zzabs = j3;
        this.zzZR = i;
        this.zzabu = list;
        this.zzabw = list2;
        this.zzabv = j4;
        this.zzaaN = zznv;
        this.zzFO = str;
    }

    public zzac(SensorRequest sensorRequest, zzk zzk, PendingIntent pendingIntent, zznv zznv, String str) {
        zzk zzk2 = zzk;
        PendingIntent pendingIntent2 = pendingIntent;
        this(sensorRequest.getDataSource(), sensorRequest.getDataType(), zzk2, pendingIntent2, sensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), sensorRequest.getFastestRate(TimeUnit.MICROSECONDS), sensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), sensorRequest.getAccuracyMode(), null, Collections.emptyList(), sensorRequest.zzmh(), zznv, str);
    }

    private boolean zzb(zzac zzac) {
        return zzw.equal(this.zzYp, zzac.zzYp) && zzw.equal(this.zzYo, zzac.zzYo) && this.zzZQ == zzac.zzZQ && this.zzabt == zzac.zzabt && this.zzabs == zzac.zzabs && this.zzZR == zzac.zzZR && zzw.equal(this.zzabu, zzac.zzabu);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof zzac) && zzb((zzac) that));
    }

    public int getAccuracyMode() {
        return this.zzZR;
    }

    public DataSource getDataSource() {
        return this.zzYp;
    }

    public DataType getDataType() {
        return this.zzYo;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYp, this.zzYo, this.zzabp, Long.valueOf(this.zzZQ), Long.valueOf(this.zzabt), Long.valueOf(this.zzabs), Integer.valueOf(this.zzZR), this.zzabu);
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.zzYo, this.zzYp, Long.valueOf(this.zzZQ), Long.valueOf(this.zzabt), Long.valueOf(this.zzabs)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzad.zza(this, parcel, flags);
    }

    public long zzlI() {
        return this.zzZQ;
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public PendingIntent zzmb() {
        return this.mPendingIntent;
    }

    public long zzmc() {
        return this.zzabt;
    }

    public long zzmd() {
        return this.zzabs;
    }

    public List<LocationRequest> zzme() {
        return this.zzabu;
    }

    public long zzmf() {
        return this.zzabv;
    }

    IBinder zzmg() {
        return this.zzabp == null ? null : this.zzabp.asBinder();
    }
}
