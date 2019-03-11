package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnFetchThumbnailResponse implements SafeParcelable {
    public static final Creator<OnFetchThumbnailResponse> CREATOR = new zzav();
    final int zzFG;
    final ParcelFileDescriptor zzUX;

    OnFetchThumbnailResponse(int versionCode, ParcelFileDescriptor thumbnailPfd) {
        this.zzFG = versionCode;
        this.zzUX = thumbnailPfd;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzav.zza(this, dest, flags | 1);
    }
}
