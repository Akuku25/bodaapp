package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    private final int zzFG;
    private Boolean zzapK;
    private Boolean zzapQ;
    private Boolean zzaqA;
    private Boolean zzaqB;
    private StreetViewPanoramaCamera zzaqv;
    private String zzaqw;
    private LatLng zzaqx;
    private Integer zzaqy;
    private Boolean zzaqz;

    public StreetViewPanoramaOptions() {
        this.zzaqz = Boolean.valueOf(true);
        this.zzapQ = Boolean.valueOf(true);
        this.zzaqA = Boolean.valueOf(true);
        this.zzaqB = Boolean.valueOf(true);
        this.zzFG = 1;
    }

    StreetViewPanoramaOptions(int versionCode, StreetViewPanoramaCamera camera, String panoId, LatLng position, Integer radius, byte userNavigationEnabled, byte zoomGesturesEnabled, byte panningGesturesEnabled, byte streetNamesEnabled, byte useViewLifecycleInFragment) {
        this.zzaqz = Boolean.valueOf(true);
        this.zzapQ = Boolean.valueOf(true);
        this.zzaqA = Boolean.valueOf(true);
        this.zzaqB = Boolean.valueOf(true);
        this.zzFG = versionCode;
        this.zzaqv = camera;
        this.zzaqx = position;
        this.zzaqy = radius;
        this.zzaqw = panoId;
        this.zzaqz = zza.zza(userNavigationEnabled);
        this.zzapQ = zza.zza(zoomGesturesEnabled);
        this.zzaqA = zza.zza(panningGesturesEnabled);
        this.zzaqB = zza.zza(streetNamesEnabled);
        this.zzapK = zza.zza(useViewLifecycleInFragment);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.zzaqA;
    }

    public String getPanoramaId() {
        return this.zzaqw;
    }

    public LatLng getPosition() {
        return this.zzaqx;
    }

    public Integer getRadius() {
        return this.zzaqy;
    }

    public Boolean getStreetNamesEnabled() {
        return this.zzaqB;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzaqv;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzapK;
    }

    public Boolean getUserNavigationEnabled() {
        return this.zzaqz;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzapQ;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean enabled) {
        this.zzaqA = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera camera) {
        this.zzaqv = camera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String panoId) {
        this.zzaqw = panoId;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position) {
        this.zzaqx = position;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position, Integer radius) {
        this.zzaqx = position;
        this.zzaqy = radius;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean enabled) {
        this.zzaqB = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.zzapK = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean enabled) {
        this.zzaqz = Boolean.valueOf(enabled);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean enabled) {
        this.zzapQ = Boolean.valueOf(enabled);
        return this;
    }

    byte zzqi() {
        return zza.zzd(this.zzapK);
    }

    byte zzqm() {
        return zza.zzd(this.zzapQ);
    }

    byte zzqw() {
        return zza.zzd(this.zzaqz);
    }

    byte zzqx() {
        return zza.zzd(this.zzaqA);
    }

    byte zzqy() {
        return zza.zzd(this.zzaqB);
    }
}
