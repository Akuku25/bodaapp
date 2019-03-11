package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class LocationSettingsStates implements SafeParcelable {
    public static final Creator<LocationSettingsStates> CREATOR = new zzk();
    private final int zzFG;
    private final boolean zzamq;
    private final boolean zzamr;
    private final boolean zzams;
    private final boolean zzamt;
    private final boolean zzamu;
    private final boolean zzamv;

    LocationSettingsStates(int version, boolean gpsUsable, boolean nlpUsable, boolean bleUsable, boolean gpsPresent, boolean nlpPresent, boolean blePresent) {
        this.zzFG = version;
        this.zzamq = gpsUsable;
        this.zzamr = nlpUsable;
        this.zzams = bleUsable;
        this.zzamt = gpsPresent;
        this.zzamu = nlpPresent;
        this.zzamv = blePresent;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        return (LocationSettingsStates) zzc.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean isBlePresent() {
        return this.zzamv;
    }

    public boolean isBleUsable() {
        return this.zzams;
    }

    public boolean isGpsPresent() {
        return this.zzamt;
    }

    public boolean isGpsUsable() {
        return this.zzamq;
    }

    public boolean isLocationPresent() {
        return this.zzamt || this.zzamu;
    }

    public boolean isLocationUsable() {
        return this.zzamq || this.zzamr;
    }

    public boolean isNetworkLocationPresent() {
        return this.zzamu;
    }

    public boolean isNetworkLocationUsable() {
        return this.zzamr;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
