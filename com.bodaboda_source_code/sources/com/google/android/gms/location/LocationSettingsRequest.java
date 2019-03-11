package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LocationSettingsRequest implements SafeParcelable {
    public static final Creator<LocationSettingsRequest> CREATOR = new zzj();
    private final int zzFG;
    private final List<LocationRequest> zzabu;
    private final boolean zzamm;
    private final boolean zzamn;

    public static final class Builder {
        private boolean zzamm = false;
        private boolean zzamn = false;
        private final ArrayList<LocationRequest> zzamo = new ArrayList();

        public Builder addAllLocationRequests(Collection<LocationRequest> requests) {
            this.zzamo.addAll(requests);
            return this;
        }

        public Builder addLocationRequest(LocationRequest request) {
            this.zzamo.add(request);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zzamo, this.zzamm, this.zzamn);
        }

        public Builder setAlwaysShow(boolean show) {
            this.zzamm = show;
            return this;
        }

        public Builder setNeedBle(boolean needBle) {
            this.zzamn = needBle;
            return this;
        }
    }

    LocationSettingsRequest(int version, List<LocationRequest> locationRequests, boolean alwaysShow, boolean needBle) {
        this.zzFG = version;
        this.zzabu = locationRequests;
        this.zzamm = alwaysShow;
        this.zzamn = needBle;
    }

    private LocationSettingsRequest(List<LocationRequest> locationRequests, boolean alwaysShow, boolean needBle) {
        this(1, (List) locationRequests, alwaysShow, needBle);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public List<LocationRequest> zzme() {
        return Collections.unmodifiableList(this.zzabu);
    }

    public boolean zzps() {
        return this.zzamm;
    }

    public boolean zzpt() {
        return this.zzamn;
    }
}
