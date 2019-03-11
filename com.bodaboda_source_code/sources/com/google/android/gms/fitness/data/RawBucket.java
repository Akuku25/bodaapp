package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket implements SafeParcelable {
    public static final Creator<RawBucket> CREATOR = new zzm();
    final int zzFG;
    public final long zzON;
    public final List<RawDataSet> zzYD;
    public final int zzYE;
    public final boolean zzYF;
    public final long zzYq;
    public final Session zzYs;
    public final int zzZI;

    public RawBucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activity, List<RawDataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.zzFG = versionCode;
        this.zzON = startTimeMillis;
        this.zzYq = endTimeMillis;
        this.zzYs = session;
        this.zzZI = activity;
        this.zzYD = dataSets;
        this.zzYE = bucketType;
        this.zzYF = serverHasMoreData;
    }

    public RawBucket(Bucket bucket, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.zzFG = 2;
        this.zzON = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.zzYq = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.zzYs = bucket.getSession();
        this.zzZI = bucket.zzln();
        this.zzYE = bucket.getBucketType();
        this.zzYF = bucket.zzlo();
        List<DataSet> dataSets = bucket.getDataSets();
        this.zzYD = new ArrayList(dataSets.size());
        for (DataSet rawDataSet : dataSets) {
            this.zzYD.add(new RawDataSet(rawDataSet, uniqueDataSources, uniqueDataTypes));
        }
    }

    private boolean zza(RawBucket rawBucket) {
        return this.zzON == rawBucket.zzON && this.zzYq == rawBucket.zzYq && this.zzZI == rawBucket.zzZI && zzw.equal(this.zzYD, rawBucket.zzYD) && this.zzYE == rawBucket.zzYE && this.zzYF == rawBucket.zzYF;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawBucket) && zza((RawBucket) o));
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzON), Long.valueOf(this.zzYq), Integer.valueOf(this.zzYE));
    }

    public String toString() {
        return zzw.zzk(this).zza("startTime", Long.valueOf(this.zzON)).zza("endTime", Long.valueOf(this.zzYq)).zza("activity", Integer.valueOf(this.zzZI)).zza("dataSets", this.zzYD).zza("bucketType", Integer.valueOf(this.zzYE)).zza("serverHasMoreData", Boolean.valueOf(this.zzYF)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm.zza(this, parcel, flags);
    }
}
