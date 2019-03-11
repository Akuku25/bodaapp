package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint implements SafeParcelable {
    public static final Creator<RawDataPoint> CREATOR = new zzn();
    final int zzFG;
    public final long zzYG;
    public final long zzYH;
    public final Value[] zzYI;
    public final long zzYK;
    public final long zzYL;
    public final int zzZJ;
    public final int zzZK;

    public RawDataPoint(int versionCode, long timestampNanos, long startTimeNanos, Value[] values, int dataSourceIndex, int originalDataSourceIndex, long rawTimestamp, long insertionTimeMillis) {
        this.zzFG = versionCode;
        this.zzYG = timestampNanos;
        this.zzYH = startTimeNanos;
        this.zzZJ = dataSourceIndex;
        this.zzZK = originalDataSourceIndex;
        this.zzYK = rawTimestamp;
        this.zzYL = insertionTimeMillis;
        this.zzYI = values;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> dataSources) {
        this.zzFG = 4;
        this.zzYG = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zzYH = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zzYI = dataPoint.zzls();
        this.zzZJ = zzt.zza(dataPoint.getDataSource(), dataSources);
        this.zzZK = zzt.zza(dataPoint.getOriginalDataSource(), dataSources);
        this.zzYK = dataPoint.zzlt();
        this.zzYL = dataPoint.zzlu();
    }

    private boolean zza(RawDataPoint rawDataPoint) {
        return this.zzYG == rawDataPoint.zzYG && this.zzYH == rawDataPoint.zzYH && Arrays.equals(this.zzYI, rawDataPoint.zzYI) && this.zzZJ == rawDataPoint.zzZJ && this.zzZK == rawDataPoint.zzZK && this.zzYK == rawDataPoint.zzYK;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataPoint) && zza((RawDataPoint) o));
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzYG), Long.valueOf(this.zzYH));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.zzYI), Long.valueOf(this.zzYH), Long.valueOf(this.zzYG), Integer.valueOf(this.zzZJ), Integer.valueOf(this.zzZK)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzn.zza(this, parcel, flags);
    }
}
