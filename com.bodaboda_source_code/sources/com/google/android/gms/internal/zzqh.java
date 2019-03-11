package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class zzqh implements SafeParcelable {
    public static final zzqi CREATOR = new zzqi();
    public static final zzqh zzapa = new zzqh(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, Locale.getDefault(), null);
    public final int versionCode;
    public final String zzaob;
    public final String zzapb;
    public final String zzapc;
    public final String zzapd;
    public final String zzape;

    public zzqh(int i, String str, String str2, String str3, String str4, String str5) {
        this.versionCode = i;
        this.zzapb = str;
        this.zzapc = str2;
        this.zzapd = str3;
        this.zzaob = str4;
        this.zzape = str5;
    }

    public zzqh(String str, Locale locale, String str2) {
        this(1, str, locale.toString(), str2, null, null);
    }

    public zzqh(String str, Locale locale, String str2, String str3, String str4) {
        this(1, str, locale.toString(), str2, str3, str4);
    }

    public int describeContents() {
        zzqi zzqi = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof zzqh)) {
            return false;
        }
        zzqh zzqh = (zzqh) object;
        return this.zzapc.equals(zzqh.zzapc) && this.zzapb.equals(zzqh.zzapb) && zzw.equal(this.zzapd, zzqh.zzapd) && zzw.equal(this.zzaob, zzqh.zzaob) && zzw.equal(this.zzape, zzqh.zzape);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapb, this.zzapc, this.zzapd, this.zzaob, this.zzape);
    }

    public String toString() {
        return zzw.zzk(this).zza("clientPackageName", this.zzapb).zza("locale", this.zzapc).zza("accountName", this.zzapd).zza("gCoreClientName", this.zzaob).zza("chargedPackageName", this.zzape).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzqi zzqi = CREATOR;
        zzqi.zza(this, out, flags);
    }
}
