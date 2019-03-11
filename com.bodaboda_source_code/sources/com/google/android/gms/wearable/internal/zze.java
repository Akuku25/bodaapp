package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzb;

public class zze implements SafeParcelable, zzb {
    public static final Creator<zze> CREATOR = new zzf();
    private int mId;
    private final String zzBc;
    final int zzFG;
    private String zzSJ;
    private final String zzSy;
    private final String zzaFP;
    private final String zzaFQ;
    private byte zzaFR;
    private byte zzaFS;
    private byte zzaFT;
    private byte zzaFU;
    private final String zzadw;

    zze(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4) {
        this.mId = i2;
        this.zzFG = i;
        this.zzBc = str;
        this.zzaFP = str2;
        this.zzaFQ = str3;
        this.zzSy = str4;
        this.zzadw = str5;
        this.zzSJ = str6;
        this.zzaFR = b;
        this.zzaFS = b2;
        this.zzaFT = b3;
        this.zzaFU = b4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        zze zze = (zze) o;
        if (this.zzaFU != zze.zzaFU) {
            return false;
        }
        if (this.zzaFT != zze.zzaFT) {
            return false;
        }
        if (this.zzaFS != zze.zzaFS) {
            return false;
        }
        if (this.zzaFR != zze.zzaFR) {
            return false;
        }
        if (this.mId != zze.mId) {
            return false;
        }
        if (this.zzFG != zze.zzFG) {
            return false;
        }
        if (!this.zzBc.equals(zze.zzBc)) {
            return false;
        }
        if (this.zzaFP == null ? zze.zzaFP != null : !this.zzaFP.equals(zze.zzaFP)) {
            return false;
        }
        if (!this.zzSJ.equals(zze.zzSJ)) {
            return false;
        }
        if (!this.zzaFQ.equals(zze.zzaFQ)) {
            return false;
        }
        if (this.zzadw.equals(zze.zzadw)) {
            return this.zzSy.equals(zze.zzSy);
        } else {
            return false;
        }
    }

    public String getDisplayName() {
        return this.zzSJ == null ? this.zzBc : this.zzSJ;
    }

    public int getId() {
        return this.mId;
    }

    public String getTitle() {
        return this.zzSy;
    }

    public int hashCode() {
        return (((((((((((((((((this.zzaFP != null ? this.zzaFP.hashCode() : 0) + (((((this.zzFG * 31) + this.mId) * 31) + this.zzBc.hashCode()) * 31)) * 31) + this.zzaFQ.hashCode()) * 31) + this.zzSy.hashCode()) * 31) + this.zzadw.hashCode()) * 31) + this.zzSJ.hashCode()) * 31) + this.zzaFR) * 31) + this.zzaFS) * 31) + this.zzaFT) * 31) + this.zzaFU;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.zzFG + ", mId=" + this.mId + ", mAppId='" + this.zzBc + '\'' + ", mDateTime='" + this.zzaFP + '\'' + ", mNotificationText='" + this.zzaFQ + '\'' + ", mTitle='" + this.zzSy + '\'' + ", mSubtitle='" + this.zzadw + '\'' + ", mDisplayName='" + this.zzSJ + '\'' + ", mEventId=" + this.zzaFR + ", mEventFlags=" + this.zzaFS + ", mCategoryId=" + this.zzaFT + ", mCategoryCount=" + this.zzaFU + '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public String zzmV() {
        return this.zzadw;
    }

    public String zznE() {
        return this.zzBc;
    }

    public String zzvb() {
        return this.zzaFP;
    }

    public String zzvc() {
        return this.zzaFQ;
    }

    public byte zzvd() {
        return this.zzaFR;
    }

    public byte zzve() {
        return this.zzaFS;
    }

    public byte zzvf() {
        return this.zzaFT;
    }

    public byte zzvg() {
        return this.zzaFU;
    }
}
