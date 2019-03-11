package com.google.android.gms.drive.events;

import android.os.Parcel;

public class QueryEvent implements DriveEvent {
    public static final zze CREATOR = new zze();
    final int zzFG;

    public QueryEvent() {
        this(1);
    }

    QueryEvent(int versionCode) {
        this.zzFG = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return 3;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
