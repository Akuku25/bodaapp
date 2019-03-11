package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzaq();
    final int zzFG;
    final FileUploadPreferencesImpl zzUQ;

    OnDeviceUsagePreferenceResponse(int versionCode, FileUploadPreferencesImpl preferences) {
        this.zzFG = versionCode;
        this.zzUQ = preferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaq.zza(this, dest, flags);
    }

    public FileUploadPreferencesImpl zzkN() {
        return this.zzUQ;
    }
}
