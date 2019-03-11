package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class AppIdentifier implements SafeParcelable {
    public static final AppIdentifierCreator CREATOR = new AppIdentifierCreator();
    private final int zzFG;
    private final String zzZN;

    AppIdentifier(int versionCode, String identifier) {
        this.zzFG = versionCode;
        this.zzZN = zzx.zzb(identifier, (Object) "Missing application identifier value");
    }

    public AppIdentifier(String identifier) {
        this(1, identifier);
    }

    public int describeContents() {
        AppIdentifierCreator appIdentifierCreator = CREATOR;
        return 0;
    }

    public String getIdentifier() {
        return this.zzZN;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        AppIdentifierCreator appIdentifierCreator = CREATOR;
        AppIdentifierCreator.zza(this, out, flags);
    }
}
