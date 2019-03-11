package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@zzgi
public final class zzgo implements SafeParcelable {
    public static final zzgp CREATOR = new zzgp();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final String zzlM;
    public final zzhy zzlP;
    public final zzba zzlV;
    public final List<String> zzmf;
    public final String zzwA;
    public final boolean zzwB;
    public final int zzwC;
    public final String zzwD;
    public final long zzwE;
    public final String zzwF;
    public final Bundle zzwm;
    public final zzax zzwn;
    public final PackageInfo zzwo;
    public final String zzwp;
    public final String zzwq;
    public final String zzwr;
    public final Bundle zzws;
    public final int zzwt;
    public final Bundle zzwu;
    public final boolean zzwv;
    public final Messenger zzww;
    public final int zzwx;
    public final int zzwy;
    public final float zzwz;

    @zzgi
    public static final class zza {
        public final ApplicationInfo applicationInfo;
        public final String zzlM;
        public final zzhy zzlP;
        public final zzba zzlV;
        public final List<String> zzmf;
        public final String zzwA;
        public final boolean zzwB;
        public final int zzwC;
        public final long zzwE;
        public final String zzwF;
        public final Bundle zzwm;
        public final zzax zzwn;
        public final PackageInfo zzwo;
        public final String zzwq;
        public final String zzwr;
        public final Bundle zzws;
        public final int zzwt;
        public final Bundle zzwu;
        public final boolean zzwv;
        public final Messenger zzww;
        public final int zzwx;
        public final int zzwy;
        public final float zzwz;

        public zza(Bundle bundle, zzax zzax, zzba zzba, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, zzhy zzhy, Bundle bundle2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, boolean z2, int i3, long j, String str5) {
            this.zzwm = bundle;
            this.zzwn = zzax;
            this.zzlV = zzba;
            this.zzlM = str;
            this.applicationInfo = applicationInfo;
            this.zzwo = packageInfo;
            this.zzwq = str2;
            this.zzwr = str3;
            this.zzlP = zzhy;
            this.zzws = bundle2;
            this.zzwv = z;
            this.zzww = messenger;
            this.zzwx = i;
            this.zzwy = i2;
            this.zzwz = f;
            if (list == null || list.size() <= 0) {
                this.zzwt = 0;
                this.zzmf = null;
            } else {
                this.zzwt = 2;
                this.zzmf = list;
            }
            this.zzwu = bundle3;
            this.zzwA = str4;
            this.zzwB = z2;
            this.zzwC = i3;
            this.zzwE = j;
            this.zzwF = str5;
        }
    }

    zzgo(int i, Bundle bundle, zzax zzax, zzba zzba, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzhy zzhy, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, boolean z2, int i5, String str6, long j, String str7) {
        this.versionCode = i;
        this.zzwm = bundle;
        this.zzwn = zzax;
        this.zzlV = zzba;
        this.zzlM = str;
        this.applicationInfo = applicationInfo;
        this.zzwo = packageInfo;
        this.zzwp = str2;
        this.zzwq = str3;
        this.zzwr = str4;
        this.zzlP = zzhy;
        this.zzws = bundle2;
        this.zzwt = i2;
        this.zzmf = list;
        this.zzwu = bundle3;
        this.zzwv = z;
        this.zzww = messenger;
        this.zzwx = i3;
        this.zzwy = i4;
        this.zzwz = f;
        this.zzwA = str5;
        this.zzwB = z2;
        this.zzwC = i5;
        this.zzwD = str6;
        this.zzwE = j;
        this.zzwF = str7;
    }

    public zzgo(Bundle bundle, zzax zzax, zzba zzba, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzhy zzhy, Bundle bundle2, int i, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, boolean z2, int i4, String str6, long j, String str7) {
        this(7, bundle, zzax, zzba, str, applicationInfo, packageInfo, str2, str3, str4, zzhy, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, z2, i4, str6, j, str7);
    }

    public zzgo(zza zza, String str, String str2) {
        this(zza.zzwm, zza.zzwn, zza.zzlV, zza.zzlM, zza.applicationInfo, zza.zzwo, str, zza.zzwq, zza.zzwr, zza.zzlP, zza.zzws, zza.zzwt, zza.zzmf, zza.zzwu, zza.zzwv, zza.zzww, zza.zzwx, zza.zzwy, zza.zzwz, zza.zzwA, zza.zzwB, zza.zzwC, str2, zza.zzwE, zza.zzwF);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzgp.zza(this, out, flags);
    }
}
