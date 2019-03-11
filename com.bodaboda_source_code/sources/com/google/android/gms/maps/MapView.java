package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private GoogleMap zzapW;
    private final zzb zzaqc;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Context mContext;
        protected zzf<zza> zzaqa;
        private final List<OnMapReadyCallback> zzaqb = new ArrayList();
        private final ViewGroup zzaqh;
        private final GoogleMapOptions zzaqi;

        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.zzaqh = viewGroup;
            this.mContext = context;
            this.zzaqi = googleMapOptions;
        }

        public void getMapAsync(OnMapReadyCallback callback) {
            if (zzlg() != null) {
                ((zza) zzlg()).getMapAsync(callback);
            } else {
                this.zzaqb.add(callback);
            }
        }

        protected void zza(zzf<zza> zzf) {
            this.zzaqa = zzf;
            zzqs();
        }

        public void zzqs() {
            if (this.zzaqa != null && zzlg() == null) {
                try {
                    this.zzaqa.zza(new zza(this.zzaqh, zzx.zzac(this.mContext).zza(zze.zzn(this.mContext), this.zzaqi)));
                    for (OnMapReadyCallback mapAsync : this.zzaqb) {
                        ((zza) zzlg()).getMapAsync(mapAsync);
                    }
                    this.zzaqb.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    static class zza implements MapLifecycleDelegate {
        private final ViewGroup zzaqd;
        private final IMapViewDelegate zzaqe;
        private View zzaqf;

        public zza(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.zzaqe = (IMapViewDelegate) com.google.android.gms.common.internal.zzx.zzl(iMapViewDelegate);
            this.zzaqd = (ViewGroup) com.google.android.gms.common.internal.zzx.zzl(viewGroup);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.zzaqe.getMapAsync(new com.google.android.gms.maps.internal.zzm.zza(this) {
                    final /* synthetic */ zza zzaqg;

                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        callback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaqe.onCreate(savedInstanceState);
                this.zzaqf = (View) zze.zzf(this.zzaqe.getView());
                this.zzaqd.removeAllViews();
                this.zzaqd.addView(this.zzaqf);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.zzaqe.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.zzaqe.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaqe.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaqe.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaqe.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IMapViewDelegate zzqt() {
            return this.zzaqe;
        }
    }

    public MapView(Context context) {
        super(context);
        this.zzaqc = new zzb(this, context, null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzaqc = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzaqc = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.zzaqc = new zzb(this, context, options);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.zzapW != null) {
            return this.zzapW;
        }
        this.zzaqc.zzqs();
        if (this.zzaqc.zzlg() == null) {
            return null;
        }
        try {
            this.zzapW = new GoogleMap(((zza) this.zzaqc.zzlg()).zzqt().getMap());
            return this.zzapW;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        com.google.android.gms.common.internal.zzx.zzbd("getMapAsync() must be called on the main thread");
        this.zzaqc.getMapAsync(callback);
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.zzaqc.onCreate(savedInstanceState);
        if (this.zzaqc.zzlg() == null) {
            com.google.android.gms.dynamic.zza.zzb((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.zzaqc.onDestroy();
    }

    public final void onLowMemory() {
        this.zzaqc.onLowMemory();
    }

    public final void onPause() {
        this.zzaqc.onPause();
    }

    public final void onResume() {
        this.zzaqc.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.zzaqc.onSaveInstanceState(outState);
    }
}
