package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int zzFG;
    boolean zzabz;
    long zzalO;
    long zzamf;
    long zzamg;
    int zzamh;
    float zzami;
    long zzamj;

    public LocationRequest() {
        this.zzFG = 1;
        this.mPriority = 102;
        this.zzamf = 3600000;
        this.zzamg = 600000;
        this.zzabz = false;
        this.zzalO = Long.MAX_VALUE;
        this.zzamh = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzami = 0.0f;
        this.zzamj = 0;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement, long maxWaitTime) {
        this.zzFG = versionCode;
        this.mPriority = priority;
        this.zzamf = interval;
        this.zzamg = fastestInterval;
        this.zzabz = explicitFastestInterval;
        this.zzalO = expireAt;
        this.zzamh = numUpdates;
        this.zzami = smallestDisplacement;
        this.zzamj = maxWaitTime;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzA(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zza(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void zzfj(int i) {
        switch (i) {
            case 100:
            case 102:
            case PRIORITY_LOW_POWER /*104*/:
            case PRIORITY_NO_POWER /*105*/:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzfk(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /*104*/:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) object;
        return this.mPriority == locationRequest.mPriority && this.zzamf == locationRequest.zzamf && this.zzamg == locationRequest.zzamg && this.zzabz == locationRequest.zzabz && this.zzalO == locationRequest.zzalO && this.zzamh == locationRequest.zzamh && this.zzami == locationRequest.zzami;
    }

    public long getExpirationTime() {
        return this.zzalO;
    }

    public long getFastestInterval() {
        return this.zzamg;
    }

    public long getInterval() {
        return this.zzamf;
    }

    public int getNumUpdates() {
        return this.zzamh;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.zzami;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzamf), Long.valueOf(this.zzamg), Boolean.valueOf(this.zzabz), Long.valueOf(this.zzalO), Integer.valueOf(this.zzamh), Float.valueOf(this.zzami));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.zzalO = Long.MAX_VALUE;
        } else {
            this.zzalO = elapsedRealtime + millis;
        }
        if (this.zzalO < 0) {
            this.zzalO = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.zzalO = millis;
        if (this.zzalO < 0) {
            this.zzalO = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        zzA(millis);
        this.zzabz = true;
        this.zzamg = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        zzA(millis);
        this.zzamf = millis;
        if (!this.zzabz) {
            this.zzamg = (long) (((double) this.zzamf) / 6.0d);
        }
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.zzamh = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        zzfj(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        zza(smallestDisplacementMeters);
        this.zzami = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(zzfk(this.mPriority));
        if (this.mPriority != PRIORITY_NO_POWER) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.zzamf + "ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.zzamg + "ms");
        if (this.zzamj > this.zzamf) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.zzamj + "ms");
        }
        if (this.zzalO != Long.MAX_VALUE) {
            long elapsedRealtime = this.zzalO - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime + "ms");
        }
        if (this.zzamh != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            stringBuilder.append(" num=").append(this.zzamh);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzg.zza(this, parcel, flags);
    }
}
