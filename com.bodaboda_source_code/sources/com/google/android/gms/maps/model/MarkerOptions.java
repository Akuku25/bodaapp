package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.maps.internal.zzaa;

public final class MarkerOptions implements SafeParcelable {
    public static final zzk CREATOR = new zzk();
    private float mAlpha;
    private final int zzFG;
    private String zzSy;
    private LatLng zzaqx;
    private boolean zzarc;
    private float zzark;
    private float zzarl;
    private String zzart;
    private BitmapDescriptor zzaru;
    private boolean zzarv;
    private boolean zzarw;
    private float zzarx;
    private float zzary;
    private float zzarz;

    public MarkerOptions() {
        this.zzark = 0.5f;
        this.zzarl = 1.0f;
        this.zzarc = true;
        this.zzarw = false;
        this.zzarx = 0.0f;
        this.zzary = 0.5f;
        this.zzarz = 0.0f;
        this.mAlpha = 1.0f;
        this.zzFG = 1;
    }

    MarkerOptions(int versionCode, LatLng position, String title, String snippet, IBinder wrappedIcon, float anchorU, float anchorV, boolean draggable, boolean visible, boolean flat, float rotation, float infoWindowAnchorU, float infoWindowAnchorV, float alpha) {
        this.zzark = 0.5f;
        this.zzarl = 1.0f;
        this.zzarc = true;
        this.zzarw = false;
        this.zzarx = 0.0f;
        this.zzary = 0.5f;
        this.zzarz = 0.0f;
        this.mAlpha = 1.0f;
        this.zzFG = versionCode;
        this.zzaqx = position;
        this.zzSy = title;
        this.zzart = snippet;
        this.zzaru = wrappedIcon == null ? null : new BitmapDescriptor(zza.zzau(wrappedIcon));
        this.zzark = anchorU;
        this.zzarl = anchorV;
        this.zzarv = draggable;
        this.zzarc = visible;
        this.zzarw = flat;
        this.zzarx = rotation;
        this.zzary = infoWindowAnchorU;
        this.zzarz = infoWindowAnchorV;
        this.mAlpha = alpha;
    }

    public MarkerOptions alpha(float alpha) {
        this.mAlpha = alpha;
        return this;
    }

    public MarkerOptions anchor(float u, float v) {
        this.zzark = u;
        this.zzarl = v;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean draggable) {
        this.zzarv = draggable;
        return this;
    }

    public MarkerOptions flat(boolean flat) {
        this.zzarw = flat;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.zzark;
    }

    public float getAnchorV() {
        return this.zzarl;
    }

    public BitmapDescriptor getIcon() {
        return this.zzaru;
    }

    public float getInfoWindowAnchorU() {
        return this.zzary;
    }

    public float getInfoWindowAnchorV() {
        return this.zzarz;
    }

    public LatLng getPosition() {
        return this.zzaqx;
    }

    public float getRotation() {
        return this.zzarx;
    }

    public String getSnippet() {
        return this.zzart;
    }

    public String getTitle() {
        return this.zzSy;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public MarkerOptions icon(BitmapDescriptor icon) {
        this.zzaru = icon;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float u, float v) {
        this.zzary = u;
        this.zzarz = v;
        return this;
    }

    public boolean isDraggable() {
        return this.zzarv;
    }

    public boolean isFlat() {
        return this.zzarw;
    }

    public boolean isVisible() {
        return this.zzarc;
    }

    public MarkerOptions position(LatLng position) {
        this.zzaqx = position;
        return this;
    }

    public MarkerOptions rotation(float rotation) {
        this.zzarx = rotation;
        return this;
    }

    public MarkerOptions snippet(String snippet) {
        this.zzart = snippet;
        return this;
    }

    public MarkerOptions title(String title) {
        this.zzSy = title;
        return this;
    }

    public MarkerOptions visible(boolean visible) {
        this.zzarc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (zzaa.zzqF()) {
            zzl.zza(this, out, flags);
        } else {
            zzk.zza(this, out, flags);
        }
    }

    IBinder zzqI() {
        return this.zzaru == null ? null : this.zzaru.zzqe().asBinder();
    }
}
