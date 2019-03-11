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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private final zzb zzaqC;
    private StreetViewPanorama zzaqq;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Context mContext;
        private final StreetViewPanoramaOptions zzaqG;
        protected zzf<zza> zzaqa;
        private final ViewGroup zzaqh;
        private final List<OnStreetViewPanoramaReadyCallback> zzaqu = new ArrayList();

        zzb(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.zzaqh = viewGroup;
            this.mContext = context;
            this.zzaqG = streetViewPanoramaOptions;
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
            if (this.zzaqa != null && zzlg() == null) {
                try {
                    this.zzaqa.zza(new zza(this.zzaqh, zzx.zzac(this.mContext).zza(zze.zzn(this.mContext), this.zzaqG)));
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
        private final IStreetViewPanoramaViewDelegate zzaqD;
        private View zzaqE;
        private final ViewGroup zzaqd;

        public zza(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.zzaqD = (IStreetViewPanoramaViewDelegate) com.google.android.gms.common.internal.zzx.zzl(iStreetViewPanoramaViewDelegate);
            this.zzaqd = (ViewGroup) com.google.android.gms.common.internal.zzx.zzl(viewGroup);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.zzaqD.getStreetViewPanoramaAsync(new com.google.android.gms.maps.internal.zzu.zza(this) {
                    final /* synthetic */ zza zzaqF;

                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        callback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaqD.onCreate(savedInstanceState);
                this.zzaqE = (View) zze.zzf(this.zzaqD.getView());
                this.zzaqd.removeAllViews();
                this.zzaqd.addView(this.zzaqE);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.zzaqD.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.zzaqD.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaqD.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaqD.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaqD.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaViewDelegate zzqz() {
            return this.zzaqD;
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.zzaqC = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzaqC = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzaqC = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions options) {
        super(context);
        this.zzaqC = new zzb(this, context, options);
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.zzaqq != null) {
            return this.zzaqq;
        }
        this.zzaqC.zzqs();
        if (this.zzaqC.zzlg() == null) {
            return null;
        }
        try {
            this.zzaqq = new StreetViewPanorama(((zza) this.zzaqC.zzlg()).zzqz().getStreetViewPanorama());
            return this.zzaqq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        com.google.android.gms.common.internal.zzx.zzbd("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzaqC.getStreetViewPanoramaAsync(callback);
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.zzaqC.onCreate(savedInstanceState);
        if (this.zzaqC.zzlg() == null) {
            com.google.android.gms.dynamic.zza.zzb((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.zzaqC.onDestroy();
    }

    public final void onLowMemory() {
        this.zzaqC.onLowMemory();
    }

    public final void onPause() {
        this.zzaqC.onPause();
    }

    public final void onResume() {
        this.zzaqC.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.zzaqC.onSaveInstanceState(outState);
    }
}
