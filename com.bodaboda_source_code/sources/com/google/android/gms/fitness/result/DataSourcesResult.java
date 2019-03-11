package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
    public static final Creator<DataSourcesResult> CREATOR = new zze();
    private final int zzFG;
    private final Status zzHb;
    private final List<DataSource> zzaaO;

    DataSourcesResult(int versionCode, List<DataSource> dataSources, Status status) {
        this.zzFG = versionCode;
        this.zzaaO = Collections.unmodifiableList(dataSources);
        this.zzHb = status;
    }

    public DataSourcesResult(List<DataSource> dataSources, Status status) {
        this.zzFG = 3;
        this.zzaaO = Collections.unmodifiableList(dataSources);
        this.zzHb = status;
    }

    public static DataSourcesResult zzC(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean zzb(DataSourcesResult dataSourcesResult) {
        return this.zzHb.equals(dataSourcesResult.zzHb) && zzw.equal(this.zzaaO, dataSourcesResult.zzaaO);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSourcesResult) && zzb((DataSourcesResult) that));
    }

    public List<DataSource> getDataSources() {
        return this.zzaaO;
    }

    public List<DataSource> getDataSources(DataType dataType) {
        List arrayList = new ArrayList();
        for (DataSource dataSource : this.zzaaO) {
            if (dataSource.getDataType().equals(dataType)) {
                arrayList.add(dataSource);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, this.zzaaO);
    }

    public String toString() {
        return zzw.zzk(this).zza(Games.EXTRA_STATUS, this.zzHb).zza("dataSets", this.zzaaO).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
