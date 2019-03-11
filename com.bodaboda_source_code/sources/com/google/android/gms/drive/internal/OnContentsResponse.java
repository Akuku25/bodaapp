package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR = new zzap();
    final int zzFG;
    final Contents zzTO;
    final boolean zzUP;

    OnContentsResponse(int versionCode, Contents contents, boolean outOfDate) {
        this.zzFG = versionCode;
        this.zzTO = contents;
        this.zzUP = outOfDate;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzap.zza(this, dest, flags);
    }

    public Contents zzkL() {
        return this.zzTO;
    }

    public boolean zzkM() {
        return this.zzUP;
    }
}
