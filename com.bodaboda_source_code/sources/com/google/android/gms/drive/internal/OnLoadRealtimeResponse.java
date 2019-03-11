package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Creator<OnLoadRealtimeResponse> CREATOR = new zzaz();
    final int zzFG;
    final boolean zzmE;

    OnLoadRealtimeResponse(int versionCode, boolean isInitialized) {
        this.zzFG = versionCode;
        this.zzmE = isInitialized;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaz.zza(this, dest, flags);
    }
}
