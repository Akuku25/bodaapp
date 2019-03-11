package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new zzm();
    private final String zzFA;
    final int zzFG;
    private final String zzqd;

    DataItemAssetParcelable(int versionCode, String id, String key) {
        this.zzFG = versionCode;
        this.zzFA = id;
        this.zzqd = key;
    }

    public DataItemAssetParcelable(DataItemAsset value) {
        this.zzFG = 1;
        this.zzFA = (String) zzx.zzl(value.getId());
        this.zzqd = (String) zzx.zzl(value.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzvi();
    }

    public String getDataItemKey() {
        return this.zzqd;
    }

    public String getId() {
        return this.zzFA;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzFA == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.zzFA);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.zzqd);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }

    public DataItemAsset zzvi() {
        return this;
    }
}
