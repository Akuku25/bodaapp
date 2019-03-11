package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<OpenFileIntentSenderRequest> CREATOR = new zzbf();
    final int zzFG;
    final DriveId zzSA;
    final String zzSy;
    final String[] zzSz;

    OpenFileIntentSenderRequest(int versionCode, String title, String[] mimeTypes, DriveId startFolder) {
        this.zzFG = versionCode;
        this.zzSy = title;
        this.zzSz = mimeTypes;
        this.zzSA = startFolder;
    }

    public OpenFileIntentSenderRequest(String title, String[] mimeTypes, DriveId startFolder) {
        this(1, title, mimeTypes, startFolder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbf.zza(this, dest, flags);
    }
}
