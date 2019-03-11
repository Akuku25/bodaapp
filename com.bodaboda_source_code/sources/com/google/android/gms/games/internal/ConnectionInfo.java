package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
    private final int zzFG;
    private final String zzadN;
    private final int zzadO;

    public ConnectionInfo(int versionCode, String clientAddress, int registrationLatency) {
        this.zzFG = versionCode;
        this.zzadN = clientAddress;
        this.zzadO = registrationLatency;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        ConnectionInfoCreator.zza(this, out, flags);
    }

    public String zznl() {
        return this.zzadN;
    }

    public int zznm() {
        return this.zzadO;
    }
}
