package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.maps.internal.zzaa;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public static final float NO_DIMENSION = -1.0f;
    private final int zzFG;
    private float zzaqU;
    private float zzarb;
    private boolean zzarc;
    private BitmapDescriptor zzare;
    private LatLng zzarf;
    private float zzarg;
    private float zzarh;
    private LatLngBounds zzari;
    private float zzarj;
    private float zzark;
    private float zzarl;

    public GroundOverlayOptions() {
        this.zzarc = true;
        this.zzarj = 0.0f;
        this.zzark = 0.5f;
        this.zzarl = 0.5f;
        this.zzFG = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.zzarc = true;
        this.zzarj = 0.0f;
        this.zzark = 0.5f;
        this.zzarl = 0.5f;
        this.zzFG = versionCode;
        this.zzare = new BitmapDescriptor(zza.zzau(wrappedImage));
        this.zzarf = location;
        this.zzarg = width;
        this.zzarh = height;
        this.zzari = bounds;
        this.zzaqU = bearing;
        this.zzarb = zIndex;
        this.zzarc = visible;
        this.zzarj = transparency;
        this.zzark = anchorU;
        this.zzarl = anchorV;
    }

    private GroundOverlayOptions zza(LatLng latLng, float f, float f2) {
        this.zzarf = latLng;
        this.zzarg = f;
        this.zzarh = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.zzark = u;
        this.zzarl = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.zzaqU = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.zzark;
    }

    public float getAnchorV() {
        return this.zzarl;
    }

    public float getBearing() {
        return this.zzaqU;
    }

    public LatLngBounds getBounds() {
        return this.zzari;
    }

    public float getHeight() {
        return this.zzarh;
    }

    public BitmapDescriptor getImage() {
        return this.zzare;
    }

    public LatLng getLocation() {
        return this.zzarf;
    }

    public float getTransparency() {
        return this.zzarj;
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

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.zzare = image;
        return this;
    }

    public boolean isVisible() {
        return this.zzarc;
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        zzx.zza(this.zzari == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        zzx.zzb(z, (Object) "Width must be non-negative");
        return zza(location, width, -1.0f);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        zzx.zza(this.zzari == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(location != null, (Object) "Location must be specified");
        zzx.zzb(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        zzx.zzb(z, (Object) "Height must be non-negative");
        return zza(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        zzx.zza(this.zzarf == null, "Position has already been set using position: " + this.zzarf);
        this.zzari = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        boolean z = transparency >= 0.0f && transparency <= 1.0f;
        zzx.zzb(z, (Object) "Transparency must be in the range [0..1]");
        this.zzarj = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.zzarc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (zzaa.zzqF()) {
            zzf.zza(this, out, flags);
        } else {
            zze.zza(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.zzarb = zIndex;
        return this;
    }

    IBinder zzqH() {
        return this.zzare.zzqe().asBinder();
    }
}
