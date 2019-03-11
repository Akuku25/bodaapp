package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR = new zzi();
    private final int zzFG;
    private String zzaDr;
    private String zzaDs;

    InstrumentInfo(int versionCode, String instrumentType, String instrumentDetails) {
        this.zzFG = versionCode;
        this.zzaDr = instrumentType;
        this.zzaDs = instrumentDetails;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.zzaDs;
    }

    public String getInstrumentType() {
        return this.zzaDr;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi.zza(this, out, flags);
    }
}
