package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
    private final int zzFG;
    List<DetectedActivity> zzalH;
    long zzalI;
    long zzalJ;

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis) {
        this.zzFG = 1;
        this.zzalH = probableActivities;
        this.zzalI = timeMillis;
        this.zzalJ = elapsedRealtimeMillis;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this(Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        boolean z = false;
        boolean z2 = probableActivities != null && probableActivities.size() > 0;
        zzx.zzb(z2, (Object) "Must have at least 1 detected activity");
        if (time > 0 && elapsedRealtimeMillis > 0) {
            z = true;
        }
        zzx.zzb(z, (Object) "Must set times");
        this.zzFG = 1;
        this.zzalH = probableActivities;
        this.zzalI = time;
        this.zzalJ = elapsedRealtimeMillis;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get(EXTRA_ACTIVITY_RESULT);
        if (!(obj instanceof byte[])) {
            return obj instanceof ActivityRecognitionResult ? (ActivityRecognitionResult) obj : null;
        } else {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall((byte[]) obj, 0, ((byte[]) obj).length);
            obtain.setDataPosition(0);
            return CREATOR.createFromParcel(obtain);
        }
    }

    public static boolean hasResult(Intent intent) {
        return intent == null ? false : intent.hasExtra(EXTRA_ACTIVITY_RESULT);
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int activityType) {
        for (DetectedActivity detectedActivity : this.zzalH) {
            if (detectedActivity.getType() == activityType) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzalJ;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.zzalH.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zzalH;
    }

    public long getTime() {
        return this.zzalI;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.zzalH + ", timeMillis=" + this.zzalI + ", elapsedRealtimeMillis=" + this.zzalJ + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.zza(this, out, flags);
    }
}
