package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzw;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaFragment extends Fragment {
    private final zzb zzaqp = new zzb(this);
    private StreetViewPanorama zzaqq;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Fragment zzXZ;
        protected zzf<zza> zzaqa;
        private final List<OnStreetViewPanoramaReadyCallback> zzaqu = new ArrayList();
        private Activity zzoi;

        zzb(Fragment fragment) {
            this.zzXZ = fragment;
        }

        private void setActivity(Activity activity) {
            this.zzoi = activity;
            zzqs();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            if (zzlg() != null) {
                ((zza) zzlg()).getStreetViewPanoramaAsync(callback);
            } else {
                this.zzaqu.add(callback);
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
                    this.zzaqa.zza(new zza(this.zzXZ, zzx.zzac(this.zzoi).zzk(zze.zzn(this.zzoi))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.zzaqu) {
                        ((zza) zzlg()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.zzaqu.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    static class zza implements StreetViewLifecycleDelegate {
        private final Fragment zzXZ;
        private final IStreetViewPanoramaFragmentDelegate zzaqr;

        public zza(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.zzaqr = (IStreetViewPanoramaFragmentDelegate) com.google.android.gms.common.internal.zzx.zzl(iStreetViewPanoramaFragmentDelegate);
            this.zzXZ = (Fragment) com.google.android.gms.common.internal.zzx.zzl(fragment);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.zzaqr.getStreetViewPanoramaAsync(new com.google.android.gms.maps.internal.zzu.zza(this) {
                    final /* synthetic */ zza zzaqt;

                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        callback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
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
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                zzw.zza(savedInstanceState, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.zzaqr.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzf(this.zzaqr.onCreateView(zze.zzn(inflater), zze.zzn(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.zzaqr.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.zzaqr.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaqr.onInflate(zze.zzn(activity), null, savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.zzaqr.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaqr.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaqr.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaqr.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaFragmentDelegate zzqv() {
            return this.zzaqr;
        }
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate zzqv = zzqv();
        if (zzqv == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = zzqv.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.zzaqq == null || this.zzaqq.zzqu().asBinder() != streetViewPanorama.asBinder()) {
                this.zzaqq = new StreetViewPanorama(streetViewPanorama);
            }
            return this.zzaqq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        com.google.android.gms.common.internal.zzx.zzbd("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzaqp.getStreetViewPanoramaAsync(callback);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzaqp.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzaqp.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaqp.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.zzaqp.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzaqp.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.zzaqp.setActivity(activity);
        this.zzaqp.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.zzaqp.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzaqp.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaqp.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.zzaqp.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    protected IStreetViewPanoramaFragmentDelegate zzqv() {
        this.zzaqp.zzqs();
        return this.zzaqp.zzlg() == null ? null : ((zza) this.zzaqp.zzlg()).zzqv();
    }
}
