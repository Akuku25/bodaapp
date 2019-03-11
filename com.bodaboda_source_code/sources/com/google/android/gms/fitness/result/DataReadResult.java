package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
    public static final Creator<DataReadResult> CREATOR = new zzb();
    private final int zzFG;
    private final Status zzHb;
    private final List<DataSet> zzYD;
    private final List<DataSource> zzYN;
    private final List<Bucket> zzabM;
    private int zzabN;
    private final List<DataType> zzabO;

    DataReadResult(int versionCode, List<RawDataSet> dataSets, Status status, List<RawBucket> buckets, int batchCount, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.zzFG = versionCode;
        this.zzHb = status;
        this.zzabN = batchCount;
        this.zzYN = uniqueDataSources;
        this.zzabO = uniqueDataTypes;
        this.zzYD = new ArrayList(dataSets.size());
        for (RawDataSet dataSet : dataSets) {
            this.zzYD.add(new DataSet(dataSet, (List) uniqueDataSources));
        }
        this.zzabM = new ArrayList(buckets.size());
        for (RawBucket bucket : buckets) {
            this.zzabM.add(new Bucket(bucket, (List) uniqueDataSources));
        }
    }

    public DataReadResult(List<DataSet> dataSets, List<Bucket> buckets, Status status) {
        this.zzFG = 5;
        this.zzYD = dataSets;
        this.zzHb = status;
        this.zzabM = buckets;
        this.zzabN = 1;
        this.zzYN = new ArrayList();
        this.zzabO = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest dataReadRequest) {
        List arrayList = new ArrayList();
        for (DataSource create : dataReadRequest.getDataSources()) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : dataReadRequest.getDataTypes()) {
            arrayList.add(DataSet.create(new Builder().setDataType(dataType).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.zzb(bucket)) {
                for (DataSet zza : bucket.getDataSets()) {
                    zza(zza, bucket2.getDataSets());
                }
                return;
            }
        }
        this.zzabM.add(bucket);
    }

    private void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.zzb(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzHb.equals(dataReadResult.zzHb) && zzw.equal(this.zzYD, dataReadResult.zzYD) && zzw.equal(this.zzabM, dataReadResult.zzabM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadResult) && zzc((DataReadResult) that));
    }

    public List<Bucket> getBuckets() {
        return this.zzabM;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.zzYD) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataSource.getStreamIdentifier()}));
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzYD) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataType.getName()}));
    }

    public List<DataSet> getDataSets() {
        return this.zzYD;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, this.zzYD, this.zzabM);
    }

    public String toString() {
        return zzw.zzk(this).zza(Games.EXTRA_STATUS, this.zzHb).zza("dataSets", this.zzYD.size() > 5 ? this.zzYD.size() + " data sets" : this.zzYD).zza("buckets", this.zzabM.size() > 5 ? this.zzabM.size() + " buckets" : this.zzabM).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public void zzb(DataReadResult dataReadResult) {
        for (DataSet zza : dataReadResult.getDataSets()) {
            zza(zza, this.zzYD);
        }
        for (Bucket zza2 : dataReadResult.getBuckets()) {
            zza(zza2, this.zzabM);
        }
    }

    List<DataSource> zzlx() {
        return this.zzYN;
    }

    public int zzmn() {
        return this.zzabN;
    }

    List<RawBucket> zzmo() {
        List<RawBucket> arrayList = new ArrayList(this.zzabM.size());
        for (Bucket rawBucket : this.zzabM) {
            arrayList.add(new RawBucket(rawBucket, this.zzYN, this.zzabO));
        }
        return arrayList;
    }

    List<RawDataSet> zzmp() {
        List<RawDataSet> arrayList = new ArrayList(this.zzYD.size());
        for (DataSet rawDataSet : this.zzYD) {
            arrayList.add(new RawDataSet(rawDataSet, this.zzYN, this.zzabO));
        }
        return arrayList;
    }

    List<DataType> zzmq() {
        return this.zzabO;
    }
}
