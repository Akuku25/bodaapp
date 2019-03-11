package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class Status implements Result, SafeParcelable {
    public static final StatusCreator CREATOR = new StatusCreator();
    public static final Status zzNo = new Status(0);
    public static final Status zzNp = new Status(14);
    public static final Status zzNq = new Status(8);
    public static final Status zzNr = new Status(15);
    public static final Status zzNs = new Status(16);
    private final PendingIntent mPendingIntent;
    private final int zzFG;
    private final int zzLs;
    private final String zzNt;

    public Status(int statusCode) {
        this(statusCode, null);
    }

    Status(int versionCode, int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this.zzFG = versionCode;
        this.zzLs = statusCode;
        this.zzNt = statusMessage;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int statusCode, String statusMessage) {
        this(1, statusCode, statusMessage, null);
    }

    public Status(int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this(1, statusCode, statusMessage, pendingIntent);
    }

    private String zzhK() {
        return this.zzNt != null ? this.zzNt : CommonStatusCodes.getStatusCodeString(this.zzLs);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzFG == status.zzFG && this.zzLs == status.zzLs && zzw.equal(this.zzNt, status.zzNt) && zzw.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzLs;
    }

    public String getStatusMessage() {
        return this.zzNt;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzFG), Integer.valueOf(this.zzLs), this.zzNt, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzLs == 16;
    }

    public boolean isInterrupted() {
        return this.zzLs == 14;
    }

    public boolean isSuccess() {
        return this.zzLs <= 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzw.zzk(this).zza("statusCode", zzhK()).zza("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        StatusCreator.zza(this, out, flags);
    }

    PendingIntent zzip() {
        return this.mPendingIntent;
    }
}
