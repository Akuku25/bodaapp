package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR = new zzf();
    final int zzFG;
    private final String zzNn;

    Scope(int versionCode, String scopeUri) {
        zzx.zzb(scopeUri, (Object) "scopeUri must not be null or empty");
        this.zzFG = versionCode;
        this.zzNn = scopeUri;
    }

    public Scope(String scopeUri) {
        this(1, scopeUri);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return !(o instanceof Scope) ? false : this.zzNn.equals(((Scope) o).zzNn);
    }

    public int hashCode() {
        return this.zzNn.hashCode();
    }

    public String toString() {
        return this.zzNn;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public String zzio() {
        return this.zzNn;
    }
}
