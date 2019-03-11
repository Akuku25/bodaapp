package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Creator<DataTypeResult> CREATOR = new zzh();
    private final int zzFG;
    private final Status zzHb;
    private final DataType zzYo;

    DataTypeResult(int versionCode, Status status, DataType dataType) {
        this.zzFG = versionCode;
        this.zzHb = status;
        this.zzYo = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.zzFG = 2;
        this.zzHb = status;
        this.zzYo = dataType;
    }

    public static DataTypeResult zzD(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult dataTypeResult) {
        return this.zzHb.equals(dataTypeResult.zzHb) && zzw.equal(this.zzYo, dataTypeResult.zzYo);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataTypeResult) && zzb((DataTypeResult) that));
    }

    public DataType getDataType() {
        return this.zzYo;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, this.zzYo);
    }

    public String toString() {
        return zzw.zzk(this).zza(Games.EXTRA_STATUS, this.zzHb).zza("dataType", this.zzYo).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
