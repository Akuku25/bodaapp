package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public final class AppMetadata implements SafeParcelable {
    public static final AppMetadataCreator CREATOR = new AppMetadataCreator();
    private final int zzFG;
    private final List<AppIdentifier> zzasE;

    AppMetadata(int versionCode, List<AppIdentifier> appIdentifiers) {
        this.zzFG = versionCode;
        this.zzasE = (List) zzx.zzb((Object) appIdentifiers, (Object) "Must specify application identifiers");
        zzx.zza(appIdentifiers.size(), (Object) "Application identifiers cannot be empty");
    }

    public AppMetadata(List<AppIdentifier> appIdentifiers) {
        this(1, appIdentifiers);
    }

    public int describeContents() {
        AppMetadataCreator appMetadataCreator = CREATOR;
        return 0;
    }

    public List<AppIdentifier> getAppIdentifiers() {
        return this.zzasE;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        AppMetadataCreator appMetadataCreator = CREATOR;
        AppMetadataCreator.zza(this, out, flags);
    }
}
