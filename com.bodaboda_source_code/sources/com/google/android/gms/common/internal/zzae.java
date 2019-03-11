package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzae implements SafeParcelable {
    public static final Creator<zzae> CREATOR = new zzaf();
    final int zzFG;
    final IBinder zzPn;
    private final Scope[] zzPo;
    private final int zzQv;
    private final Bundle zzQw;
    private final String zzQx;

    zzae(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.zzFG = i;
        this.zzQv = i2;
        this.zzPn = iBinder;
        this.zzPo = scopeArr;
        this.zzQw = bundle;
        this.zzQx = str;
    }

    public zzae(zzq zzq, Scope[] scopeArr, String str, Bundle bundle) {
        this(1, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, zzq == null ? null : zzq.asBinder(), scopeArr, bundle, str);
    }

    public int describeContents() {
        return 0;
    }

    public String getCallingPackage() {
        return this.zzQx;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaf.zza(this, dest, flags);
    }

    public int zzjr() {
        return this.zzQv;
    }

    public Scope[] zzjs() {
        return this.zzPo;
    }

    public Bundle zzjt() {
        return this.zzQw;
    }
}
