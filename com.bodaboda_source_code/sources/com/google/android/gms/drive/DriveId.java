package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzan;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.internal.zzwx;
import com.google.android.gms.internal.zzwy;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR = new zzd();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int zzFG;
    final long zzRS;
    private volatile String zzRU;
    final String zzSh;
    final long zzSi;
    final int zzSj;

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        boolean z = false;
        this.zzRU = null;
        this.zzFG = versionCode;
        this.zzSh = resourceId;
        zzx.zzO(!"".equals(resourceId));
        if (!(resourceId == null && sqlId == -1)) {
            z = true;
        }
        zzx.zzO(z);
        this.zzSi = sqlId;
        this.zzRS = databaseInstanceId;
        this.zzSj = resourceType;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        this(1, resourceId, sqlId, databaseInstanceId, resourceType);
    }

    public static DriveId decodeFromString(String s) {
        zzx.zzb(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return zzg(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    public static DriveId zzbu(String str) {
        zzx.zzl(str);
        return new DriveId(str, -1, -1, -1);
    }

    static DriveId zzg(byte[] bArr) {
        try {
            zzan zzh = zzan.zzh(bArr);
            return new DriveId(zzh.versionCode, "".equals(zzh.zzUI) ? null : zzh.zzUI, zzh.zzUJ, zzh.zzUG, zzh.zzUK);
        } catch (zzwx e) {
            throw new IllegalArgumentException();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzRU == null) {
            this.zzRU = "DriveId:" + Base64.encodeToString(zzkn(), 10);
        }
        return this.zzRU;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzRS != this.zzRS) {
            zzw.zzr("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        } else if (driveId.zzSi == -1 && this.zzSi == -1) {
            return driveId.zzSh.equals(this.zzSh);
        } else {
            return driveId.zzSi == this.zzSi;
        }
    }

    public String getResourceId() {
        return this.zzSh;
    }

    public int getResourceType() {
        return this.zzSj;
    }

    public int hashCode() {
        return this.zzSi == -1 ? this.zzSh.hashCode() : (String.valueOf(this.zzRS) + String.valueOf(this.zzSi)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    final byte[] zzkn() {
        zzwy zzan = new zzan();
        zzan.versionCode = this.zzFG;
        zzan.zzUI = this.zzSh == null ? "" : this.zzSh;
        zzan.zzUJ = this.zzSi;
        zzan.zzUG = this.zzRS;
        zzan.zzUK = this.zzSj;
        return zzwy.zzf(zzan);
    }
}
