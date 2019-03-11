package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR = new zzb();
    final int zzFG;
    final ParcelFileDescriptor zzOx;
    final int zzRV;
    final int zzRW;
    final DriveId zzRX;
    final boolean zzRY;

    Contents(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int requestId, int mode, DriveId driveId, boolean validForConflictDetection) {
        this.zzFG = versionCode;
        this.zzOx = parcelFileDescriptor;
        this.zzRV = requestId;
        this.zzRW = mode;
        this.zzRX = driveId;
        this.zzRY = validForConflictDetection;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzRX;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.zzOx.getFileDescriptor());
    }

    public int getMode() {
        return this.zzRW;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.zzOx.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzOx;
    }

    public int getRequestId() {
        return this.zzRV;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public boolean zzko() {
        return this.zzRY;
    }
}
