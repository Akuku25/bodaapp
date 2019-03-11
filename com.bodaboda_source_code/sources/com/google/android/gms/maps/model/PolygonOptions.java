package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    private final int zzFG;
    private float zzaqY;
    private int zzaqZ;
    private final List<LatLng> zzarB;
    private final List<List<LatLng>> zzarC;
    private boolean zzarD;
    private int zzara;
    private float zzarb;
    private boolean zzarc;

    public PolygonOptions() {
        this.zzaqY = 10.0f;
        this.zzaqZ = ViewCompat.MEASURED_STATE_MASK;
        this.zzara = 0;
        this.zzarb = 0.0f;
        this.zzarc = true;
        this.zzarD = false;
        this.zzFG = 1;
        this.zzarB = new ArrayList();
        this.zzarC = new ArrayList();
    }

    PolygonOptions(int versionCode, List<LatLng> points, List holes, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible, boolean geodesic) {
        this.zzaqY = 10.0f;
        this.zzaqZ = ViewCompat.MEASURED_STATE_MASK;
        this.zzara = 0;
        this.zzarb = 0.0f;
        this.zzarc = true;
        this.zzarD = false;
        this.zzFG = versionCode;
        this.zzarB = points;
        this.zzarC = holes;
        this.zzaqY = strokeWidth;
        this.zzaqZ = strokeColor;
        this.zzara = fillColor;
        this.zzarb = zIndex;
        this.zzarc = visible;
        this.zzarD = geodesic;
    }

    public PolygonOptions add(LatLng point) {
        this.zzarB.add(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        this.zzarB.addAll(Arrays.asList(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.zzarB.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : points) {
            arrayList.add(add);
        }
        this.zzarC.add(arrayList);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int color) {
        this.zzara = color;
        return this;
    }

    public PolygonOptions geodesic(boolean geodesic) {
        this.zzarD = geodesic;
        return this;
    }

    public int getFillColor() {
        return this.zzara;
    }

    public List<List<LatLng>> getHoles() {
        return this.zzarC;
    }

    public List<LatLng> getPoints() {
        return this.zzarB;
    }

    public int getStrokeColor() {
        return this.zzaqZ;
    }

    public float getStrokeWidth() {
        return this.zzaqY;
    }

    int getVersionCode() {
        return this.zzFG;
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

    public PolygonOptions strokeColor(int color) {
        this.zzaqZ = color;
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        this.zzaqY = width;
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        this.zzarc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (zzaa.zzqF()) {
            zzn.zza(this, out, flags);
        } else {
            zzm.zza(this, out, flags);
        }
    }

    public PolygonOptions zIndex(float zIndex) {
        this.zzarb = zIndex;
        return this;
    }

    List zzqJ() {
        return this.zzarC;
    }
}
