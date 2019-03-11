package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpk;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR = new zza();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int zzFG;
    private final List<zzpk> zzalY;
    private final int zzalZ;

    public static final class Builder {
        private final List<zzpk> zzalY = new ArrayList();
        private int zzalZ = 5;

        public static int zzfg(int i) {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence) {
            zzx.zzb((Object) geofence, (Object) "geofence can't be null.");
            zzx.zzb(geofence instanceof zzpk, (Object) "Geofence must be created using Geofence.Builder.");
            this.zzalY.add((zzpk) geofence);
            return this;
        }

        public Builder addGeofences(List<Geofence> geofences) {
            if (!(geofences == null || geofences.isEmpty())) {
                for (Geofence geofence : geofences) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            zzx.zzb(!this.zzalY.isEmpty(), (Object) "No geofence has been added to this request.");
            return new GeofencingRequest(this.zzalY, this.zzalZ);
        }

        public Builder setInitialTrigger(int initialTrigger) {
            this.zzalZ = zzfg(initialTrigger);
            return this;
        }
    }

    GeofencingRequest(int version, List<zzpk> geofences, int initialTrigger) {
        this.zzFG = version;
        this.zzalY = geofences;
        this.zzalZ = initialTrigger;
    }

    private GeofencingRequest(List<zzpk> geofences, int initialTrigger) {
        this(1, (List) geofences, initialTrigger);
    }

    public int describeContents() {
        return 0;
    }

    public List<Geofence> getGeofences() {
        List<Geofence> arrayList = new ArrayList();
        arrayList.addAll(this.zzalY);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzalZ;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public List<zzpk> zzpp() {
        return this.zzalY;
    }
}
