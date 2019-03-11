package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Creator<ParcelableCollaborator> CREATOR = new zzp();
    final int zzFG;
    final String zzSJ;
    final boolean zzWX;
    final boolean zzWY;
    final String zzWZ;
    final String zzXa;
    final String zzXb;
    final String zzyL;

    ParcelableCollaborator(int versionCode, boolean isMe, boolean isAnonymous, String sessionId, String userId, String displayName, String color, String photoUrl) {
        this.zzFG = versionCode;
        this.zzWX = isMe;
        this.zzWY = isAnonymous;
        this.zzyL = sessionId;
        this.zzWZ = userId;
        this.zzSJ = displayName;
        this.zzXa = color;
        this.zzXb = photoUrl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.zzyL.equals(((ParcelableCollaborator) obj).zzyL);
    }

    public int hashCode() {
        return this.zzyL.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.zzWX + ", isAnonymous=" + this.zzWY + ", sessionId=" + this.zzyL + ", userId=" + this.zzWZ + ", displayName=" + this.zzSJ + ", color=" + this.zzXa + ", photoUrl=" + this.zzXb + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzp.zza(this, dest, flags);
    }
}
