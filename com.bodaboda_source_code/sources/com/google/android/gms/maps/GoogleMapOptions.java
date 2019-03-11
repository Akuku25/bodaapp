package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0099R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int zzFG;
    private Boolean zzapJ;
    private Boolean zzapK;
    private int zzapL;
    private CameraPosition zzapM;
    private Boolean zzapN;
    private Boolean zzapO;
    private Boolean zzapP;
    private Boolean zzapQ;
    private Boolean zzapR;
    private Boolean zzapS;
    private Boolean zzapT;
    private Boolean zzapU;

    public GoogleMapOptions() {
        this.zzapL = -1;
        this.zzFG = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled, byte liteMode, byte mapToolbarEnabled) {
        this.zzapL = -1;
        this.zzFG = versionCode;
        this.zzapJ = zza.zza(zOrderOnTop);
        this.zzapK = zza.zza(useViewLifecycleInFragment);
        this.zzapL = mapType;
        this.zzapM = camera;
        this.zzapN = zza.zza(zoomControlsEnabled);
        this.zzapO = zza.zza(compassEnabled);
        this.zzapP = zza.zza(scrollGesturesEnabled);
        this.zzapQ = zza.zza(zoomGesturesEnabled);
        this.zzapR = zza.zza(tiltGesturesEnabled);
        this.zzapS = zza.zza(rotateGesturesEnabled);
        this.zzapT = zza.zza(liteMode);
        this.zzapU = zza.zza(mapToolbarEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0099R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C0099R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiMapToolbar, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.zzapM = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.zzapO = Boolean.valueOf(enabled);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.zzapM;
    }

    public Boolean getCompassEnabled() {
        return this.zzapO;
    }

    public Boolean getLiteMode() {
        return this.zzapT;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzapU;
    }

    public int getMapType() {
        return this.zzapL;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzapS;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzapP;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzapR;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzapK;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public Boolean getZOrderOnTop() {
        return this.zzapJ;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zzapN;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzapQ;
    }

    public GoogleMapOptions liteMode(boolean enabled) {
        this.zzapT = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean enabled) {
        this.zzapU = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.zzapL = mapType;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.zzapS = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.zzapP = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.zzapR = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.zzapK = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (zzaa.zzqF()) {
            zzb.zza(this, out, flags);
        } else {
            zza.zza(this, out, flags);
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.zzapJ = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.zzapN = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.zzapQ = Boolean.valueOf(enabled);
        return this;
    }

    byte zzqh() {
        return zza.zzd(this.zzapJ);
    }

    byte zzqi() {
        return zza.zzd(this.zzapK);
    }

    byte zzqj() {
        return zza.zzd(this.zzapN);
    }

    byte zzqk() {
        return zza.zzd(this.zzapO);
    }

    byte zzql() {
        return zza.zzd(this.zzapP);
    }

    byte zzqm() {
        return zza.zzd(this.zzapQ);
    }

    byte zzqn() {
        return zza.zzd(this.zzapR);
    }

    byte zzqo() {
        return zza.zzd(this.zzapS);
    }

    byte zzqp() {
        return zza.zzd(this.zzapT);
    }

    byte zzqq() {
        return zza.zzd(this.zzapU);
    }
}
