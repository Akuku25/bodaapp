package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmn;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Creator<BleDevice> CREATOR = new zzc();
    private final String mName;
    private final int zzFG;
    private final List<DataType> zzYA;
    private final String zzYy;
    private final List<String> zzYz;

    BleDevice(int versionCode, String address, String name, List<String> profiles, List<DataType> dataTypes) {
        this.zzFG = versionCode;
        this.zzYy = address;
        this.mName = name;
        this.zzYz = Collections.unmodifiableList(profiles);
        this.zzYA = Collections.unmodifiableList(dataTypes);
    }

    private boolean zza(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.zzYy.equals(bleDevice.zzYy) && zzmn.zza(bleDevice.zzYz, this.zzYz) && zzmn.zza(this.zzYA, bleDevice.zzYA);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof BleDevice) && zza((BleDevice) o));
    }

    public String getAddress() {
        return this.zzYy;
    }

    public List<DataType> getDataTypes() {
        return this.zzYA;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.zzYz;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzYy, this.zzYz, this.zzYA);
    }

    public String toString() {
        return zzw.zzk(this).zza("name", this.mName).zza("address", this.zzYy).zza("dataTypes", this.zzYA).zza("supportedProfiles", this.zzYz).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc.zza(this, parcel, flags);
    }
}
