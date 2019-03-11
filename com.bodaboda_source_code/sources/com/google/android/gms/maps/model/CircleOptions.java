package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zzaa;

public final class CircleOptions implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    private final int zzFG;
    private LatLng zzaqW;
    private double zzaqX;
    private float zzaqY;
    private int zzaqZ;
    private int zzara;
    private float zzarb;
    private boolean zzarc;

    public CircleOptions() {
        this.zzaqW = null;
        this.zzaqX = 0.0d;
        this.zzaqY = 10.0f;
        this.zzaqZ = ViewCompat.MEASURED_STATE_MASK;
        this.zzara = 0;
        this.zzarb = 0.0f;
        this.zzarc = true;
        this.zzFG = 1;
    }

    CircleOptions(int versionCode, LatLng center, double radius, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible) {
        this.zzaqW = null;
        this.zzaqX = 0.0d;
        this.zzaqY = 10.0f;
        this.zzaqZ = ViewCompat.MEASURED_STATE_MASK;
        this.zzara = 0;
        this.zzarb = 0.0f;
        this.zzarc = true;
        this.zzFG = versionCode;
        this.zzaqW = center;
        this.zzaqX = radius;
        this.zzaqY = strokeWidth;
        this.zzaqZ = strokeColor;
        this.zzara = fillColor;
        this.zzarb = zIndex;
        this.zzarc = visible;
    }

    public CircleOptions center(LatLng center) {
        this.zzaqW = center;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int color) {
        this.zzara = color;
        return this;
    }

    public LatLng getCenter() {
        return this.zzaqW;
    }

    public int getFillColor() {
        return this.zzara;
    }

    public double getRadius() {
        return this.zzaqX;
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

    public boolean isVisible() {
        return this.zzarc;
    }

    public CircleOptions radius(double radius) {
        this.zzaqX = radius;
        return this;
    }

    public CircleOptions strokeColor(int color) {
        this.zzaqZ = color;
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        this.zzaqY = width;
        return this;
    }

    public CircleOptions visible(boolean visible) {
        this.zzarc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (zzaa.zzqF()) {
            zzd.zza(this, out, flags);
        } else {
            zzc.zza(this, out, flags);
        }
    }

    public CircleOptions zIndex(float zIndex) {
        this.zzarb = zIndex;
        return this;
    }
}
