package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzw;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {
    private final zzb zzapV = new zzb(this);
    private GoogleMap zzapW;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Fragment zzXZ;
        protected zzf<zza> zzaqa;
        private final List<OnMapReadyCallback> zzaqb = new ArrayList();
        private Activity zzoi;

        zzb(Fragment fragment) {
            this.zzXZ = fragment;
        }

        private void setActivity(Activity activity) {
            this.zzoi = activity;
            zzqs();
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
            if (this.zzoi != null && this.zzaqa != null && zzlg() == null) {
                try {
                    MapsInitializer.initialize(this.zzoi);
                    this.zzaqa.zza(new zza(this.zzXZ, zzx.zzac(this.zzoi).zzj(zze.zzn(this.zzoi))));
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
        private final Fragment zzXZ;
        private final IMapFragmentDelegate zzapX;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.zzapX = (IMapFragmentDelegate) com.google.android.gms.common.internal.zzx.zzl(iMapFragmentDelegate);
            this.zzXZ = (Fragment) com.google.android.gms.common.internal.zzx.zzl(fragment);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.zzapX.getMapAsync(new com.google.android.gms.maps.internal.zzm.zza(this) {
                    final /* synthetic */ zza zzapZ;

                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        callback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.zzXZ.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzw.zza(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.zzapX.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzf(this.zzapX.onCreateView(zze.zzn(inflater), zze.zzn(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.zzapX.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.zzapX.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzapX.onInflate(zze.zzn(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.zzapX.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzapX.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzapX.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzapX.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IMapFragmentDelegate zzqr() {
            return this.zzapX;
        }
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    @Deprecated
    public final GoogleMap getMap() {
        IMapFragmentDelegate zzqr = zzqr();
        if (zzqr == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = zzqr.getMap();
            if (map == null) {
                return null;
            }
            if (this.zzapW == null || this.zzapW.zzqg().asBinder() != map.asBinder()) {
                this.zzapW = new GoogleMap(map);
            }
            return this.zzapW;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        com.google.android.gms.common.internal.zzx.zzbd("getMapAsync must be called on the main thread.");
        this.zzapV.getMapAsync(callback);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzapV.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzapV.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzapV.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.zzapV.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzapV.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.zzapV.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.zzapV.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.zzapV.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzapV.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzapV.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.zzapV.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    protected IMapFragmentDelegate zzqr() {
        this.zzapV.zzqs();
        return this.zzapV.zzlg() == null ? null : ((zza) this.zzapV.zzlg()).zzqr();
    }
}
