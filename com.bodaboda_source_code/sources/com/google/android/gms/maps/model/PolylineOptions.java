package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    private int mColor;
    private final int zzFG;
    private final List<LatLng> zzarB;
    private boolean zzarD;
    private float zzarb;
    private boolean zzarc;
    private float zzarg;

    public PolylineOptions() {
        this.zzarg = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzarb = 0.0f;
        this.zzarc = true;
        this.zzarD = false;
        this.zzFG = 1;
        this.zzarB = new ArrayList();
    }

    PolylineOptions(int versionCode, List points, float width, int color, float zIndex, boolean visible, boolean geodesic) {
        this.zzarg = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzarb = 0.0f;
        this.zzarc = true;
        this.zzarD = false;
        this.zzFG = versionCode;
        this.zzarB = points;
        this.zzarg = width;
        this.mColor = color;
        this.zzarb = zIndex;
        this.zzarc = visible;
        this.zzarD = geodesic;
    }

    public PolylineOptions add(LatLng point) {
        this.zzarB.add(point);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        this.zzarB.addAll(Arrays.asList(points));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.zzarB.add(add);
        }
        return this;
    }

    public PolylineOptions color(int color) {
        this.mColor = color;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean geodesic) {
        this.zzarD = geodesic;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public List<LatLng> getPoints() {
        return this.zzarB;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public float getWidth() {
        return this.zzarg;
    }

    public float getZIndex() {
        return this.zzarb;
    }

    public boolean isGeodesic() {
        return this.zzarD;
    }

    public boolean isVisible() {
        return this.zzarc;
    }

    public PolylineOptions visible(boolean visible) {
        this.zzarc = visible;
        return this;
    }

    public PolylineOptions width(float width) {
        this.zzarg = width;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (zzaa.zzqF()) {
            zzp.zza(this, out, flags);
        } else {
            zzo.zza(this, out, flags);
        }
    }

    public PolylineOptions zIndex(float zIndex) {
        this.zzarb = zIndex;
        return this;
    }
}
