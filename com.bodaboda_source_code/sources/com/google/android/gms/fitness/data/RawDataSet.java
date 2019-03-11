package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
    public static final Creator<RawDataSet> CREATOR = new zzo();
    final int zzFG;
    public final boolean zzYF;
    public final int zzZJ;
    public final int zzZL;
    public final List<RawDataPoint> zzZM;

    public RawDataSet(int versionCode, int dataSourceIndex, int dataTypeIndex, List<RawDataPoint> rawDataPoints, boolean serverHasMoreData) {
        this.zzFG = versionCode;
        this.zzZJ = dataSourceIndex;
        this.zzZL = dataTypeIndex;
        this.zzZM = rawDataPoints;
        this.zzYF = serverHasMoreData;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.zzFG = 3;
        this.zzZM = dataSet.zzk(uniqueDataSources);
        this.zzYF = dataSet.zzlo();
        this.zzZJ = zzt.zza(dataSet.getDataSource(), uniqueDataSources);
        this.zzZL = zzt.zza(dataSet.getDataType(), uniqueDataTypes);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzZJ == rawDataSet.zzZJ && this.zzYF == rawDataSet.zzYF && zzw.equal(this.zzZM, rawDataSet.zzZM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataSet) && zza((RawDataSet) o));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzZJ));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.zzZJ), this.zzZM});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo.zza(this, parcel, flags);
    }
}
