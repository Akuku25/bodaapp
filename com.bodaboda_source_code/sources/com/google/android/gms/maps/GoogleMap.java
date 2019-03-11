package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzj;
import com.google.android.gms.maps.model.internal.zzl;
import com.google.android.gms.maps.model.internal.zzn;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzapq;
    private UiSettings zzapr;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback zzapI;

        zza(CancelableCallback cancelableCallback) {
            this.zzapI = cancelableCallback;
        }

        public void onCancel() {
            this.zzapI.onCancel();
        }

        public void onFinish() {
            this.zzapI.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.zzapq = (IGoogleMapDelegate) zzx.zzl(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.zzapq.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            zzi addGroundOverlay = this.zzapq.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            zzl addMarker = this.zzapq.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.zzapq.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.zzapq.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            zzn addTileOverlay = this.zzapq.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.zzapq.animateCamera(update.zzqe());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.zzapq.animateCameraWithDurationAndCallback(update.zzqe(), durationMs, callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.zzapq.animateCameraWithCallback(update.zzqe(), callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.zzapq.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zzapq.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzj focusedBuilding = this.zzapq.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.zzapq.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zzapq.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zzapq.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zzapq.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zzapq.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzapr == null) {
                this.zzapr = new UiSettings(this.zzapq.getUiSettings());
            }
            return this.zzapr;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zzapq.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zzapq.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zzapq.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zzapq.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.zzapq.moveCamera(update.zzqe());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.zzapq.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String description) {
        try {
            this.zzapq.setContentDescription(description);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.zzapq.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.zzapq.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setInfoWindowAdapter(new com.google.android.gms.maps.internal.zzd.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public zzd zzf(zzl zzl) {
                return zze.zzn(adapter.getInfoWindow(new Marker(zzl)));
            }

            public zzd zzg(zzl zzl) {
                return zze.zzn(adapter.getInfoContents(new Marker(zzl)));
            }
        });
    }

    public final void setLocationSource(final LocationSource source) {
        if (source == null) {
            try {
                this.zzapq.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setLocationSource(new com.google.android.gms.maps.internal.ILocationSourceDelegate.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public void activate(final com.google.android.gms.maps.internal.zzi listener) {
                source.activate(new OnLocationChangedListener(this) {
                    final /* synthetic */ C05786 zzapA;

                    public void onLocationChanged(Location location) {
                        try {
                            listener.zzd(location);
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    }
                });
            }

            public void deactivate() {
                source.deactivate();
            }
        });
    }

    public final void setMapType(int type) {
        try {
            this.zzapq.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.zzapq.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.zzapq.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnCameraChangeListener(new com.google.android.gms.maps.internal.zzf.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public void onCameraChange(CameraPosition position) {
                listener.onCameraChange(position);
            }
        });
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.zzapq.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnIndoorStateChangeListener(new com.google.android.gms.maps.internal.zzg.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public void onIndoorBuildingFocused() {
                listener.onIndoorBuildingFocused();
            }

            public void zza(zzj zzj) {
                listener.onIndoorLevelActivated(new IndoorBuilding(zzj));
            }
        });
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.zzapq.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnInfoWindowClickListener(new com.google.android.gms.maps.internal.zzh.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public void zze(zzl zzl) {
                listener.onInfoWindowClick(new Marker(zzl));
            }
        });
    }

    public final void setOnMapClickListener(final OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.zzapq.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnMapClickListener(new com.google.android.gms.maps.internal.zzj.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public void onMapClick(LatLng point) {
                listener.onMapClick(point);
            }
        });
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.zzapq.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnMapLoadedCallback(new com.google.android.gms.maps.internal.zzk.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public void onMapLoaded() throws RemoteException {
                callback.onMapLoaded();
            }
        });
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.zzapq.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnMapLongClickListener(new com.google.android.gms.maps.internal.zzl.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public void onMapLongClick(LatLng point) {
                listener.onMapLongClick(point);
            }
        });
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.zzapq.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnMarkerClickListener(new com.google.android.gms.maps.internal.zzn.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public boolean zza(zzl zzl) {
                return listener.onMarkerClick(new Marker(zzl));
            }
        });
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.zzapq.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnMarkerDragListener(new com.google.android.gms.maps.internal.zzo.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public void zzb(zzl zzl) {
                listener.onMarkerDragStart(new Marker(zzl));
            }

            public void zzc(zzl zzl) {
                listener.onMarkerDragEnd(new Marker(zzl));
            }

            public void zzd(zzl zzl) {
                listener.onMarkerDrag(new Marker(zzl));
            }
        });
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.zzapq.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnMyLocationButtonClickListener(new com.google.android.gms.maps.internal.zzp.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public boolean onMyLocationButtonClick() throws RemoteException {
                return listener.onMyLocationButtonClick();
            }
        });
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.zzapq.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzapq.setOnMyLocationChangeListener(new com.google.android.gms.maps.internal.zzq.zza(this) {
            final /* synthetic */ GoogleMap zzapt;

            public void zzc(Location location) {
                listener.onMyLocationChange(location);
            }

            public void zzg(zzd zzd) {
                listener.onMyLocationChange((Location) zze.zzf(zzd));
            }
        });
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.zzapq.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.zzapq.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.zzapq.snapshot(new com.google.android.gms.maps.internal.zzv.zza(this) {
                final /* synthetic */ GoogleMap zzapt;

                public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                    callback.onSnapshotReady(snapshot);
                }

                public void zzh(zzd zzd) throws RemoteException {
                    callback.onSnapshotReady((Bitmap) zze.zzf(zzd));
                }
            }, (zze) (bitmap != null ? zze.zzn(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.zzapq.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate zzqg() {
        return this.zzapq;
    }
}
