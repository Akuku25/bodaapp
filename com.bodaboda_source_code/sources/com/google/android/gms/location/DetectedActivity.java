package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    public static final Comparator<DetectedActivity> zzalK = new C02381();
    private final int zzFG;
    int zzalL;
    int zzalM;

    /* renamed from: com.google.android.gms.location.DetectedActivity$1 */
    static class C02381 implements Comparator<DetectedActivity> {
        C02381() {
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return zza((DetectedActivity) x0, (DetectedActivity) x1);
        }

        public int zza(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : compareTo;
        }
    }

    public DetectedActivity(int activityType, int confidence) {
        this.zzFG = 1;
        this.zzalL = activityType;
        this.zzalM = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.zzFG = versionCode;
        this.zzalL = activityType;
        this.zzalM = confidence;
    }

    private int zzff(int i) {
        return i > 9 ? 4 : i;
    }

    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.zzalM;
    }

    public int getType() {
        return zzff(this.zzalL);
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        return "DetectedActivity [type=" + getType() + ", confidence=" + this.zzalM + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.zza(this, out, flags);
    }
}
