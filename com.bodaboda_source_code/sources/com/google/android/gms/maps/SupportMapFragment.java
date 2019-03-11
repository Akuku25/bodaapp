package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
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

public class SupportMapFragment extends Fragment {
    private GoogleMap zzapW;
    private final zzb zzaqH = new zzb(this);

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Fragment zzPt;
        protected zzf<zza> zzaqa;
        private final List<OnMapReadyCallback> zzaqb = new ArrayList();
        private Activity zzoi;

        zzb(Fragment fragment) {
            this.zzPt = fragment;
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
                    this.zzaqa.zza(new zza(this.zzPt, zzx.zzac(this.zzoi).zzj(zze.zzn(this.zzoi))));
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
        private final Fragment zzPt;
        private final IMapFragmentDelegate zzapX;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.zzapX = (IMapFragmentDelegate) com.google.android.gms.common.internal.zzx.zzl(iMapFragmentDelegate);
            this.zzPt = (Fragment) com.google.android.gms.common.internal.zzx.zzl(fragment);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.zzapX.getMapAsync(new com.google.android.gms.maps.internal.zzm.zza(this) {
                    final /* synthetic */ zza zzaqI;

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
            Bundle arguments = this.zzPt.getArguments();
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

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
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
        this.zzaqH.getMapAsync(callback);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzaqH.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzaqH.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaqH.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.zzaqH.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzaqH.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.zzaqH.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.zzaqH.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.zzaqH.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzaqH.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaqH.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.zzaqH.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    protected IMapFragmentDelegate zzqr() {
        this.zzaqH.zzqs();
        return this.zzaqH.zzlg() == null ? null : ((zza) this.zzaqH.zzlg()).zzqr();
    }
}
