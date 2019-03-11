package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0099R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzwb;
import com.google.android.gms.internal.zzwj;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private boolean mCreated = false;
    private final Fragment zzXZ = this;
    private MaskedWallet zzaEA;
    private Boolean zzaEB;
    private zzb zzaEG;
    private final com.google.android.gms.dynamic.zzb zzaEH = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzaEI = new zzc();
    private zza zzaEJ = new zza(this);
    private WalletFragmentOptions zzaEx;
    private WalletFragmentInitParams zzaEy;
    private MaskedWalletRequest zzaEz;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    private static class zzb implements LifecycleDelegate {
        private final zzwb zzaEE;

        private zzb(zzwb zzwb) {
            this.zzaEE = zzwb;
        }

        private int getState() {
            try {
                return this.zzaEE.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.zzaEE.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.zzaEE.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.zzaEE.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzaEE.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.zzaEE.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaEE.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzf(this.zzaEE.onCreateView(zze.zzn(inflater), zze.zzn(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaEE.zza(zze.zzn(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.zzaEE.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaEE.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaEE.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.zzaEE.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.zzaEE.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements OnClickListener {
        final /* synthetic */ WalletFragment zzaEM;

        private zzc(WalletFragment walletFragment) {
            this.zzaEM = walletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzaEM.zzXZ.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzaEM.zzXZ.getActivity());
            button.setText(C0099R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzaEM.zzaEx != null) {
                WalletFragmentStyle fragmentStyle = this.zzaEM.zzaEx.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzaEM.zzXZ.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> zzf) {
            Activity activity = this.zzaEM.zzXZ.getActivity();
            if (this.zzaEM.zzaEG == null && this.zzaEM.mCreated && activity != null) {
                try {
                    this.zzaEM.zzaEG = new zzb(zzwj.zza(activity, this.zzaEM.zzaEH, this.zzaEM.zzaEx, this.zzaEM.zzaEJ));
                    this.zzaEM.zzaEx = null;
                    zzf.zza(this.zzaEM.zzaEG);
                    if (this.zzaEM.zzaEy != null) {
                        this.zzaEM.zzaEG.initialize(this.zzaEM.zzaEy);
                        this.zzaEM.zzaEy = null;
                    }
                    if (this.zzaEM.zzaEz != null) {
                        this.zzaEM.zzaEG.updateMaskedWalletRequest(this.zzaEM.zzaEz);
                        this.zzaEM.zzaEz = null;
                    }
                    if (this.zzaEM.zzaEA != null) {
                        this.zzaEM.zzaEG.updateMaskedWallet(this.zzaEM.zzaEA);
                        this.zzaEM.zzaEA = null;
                    }
                    if (this.zzaEM.zzaEB != null) {
                        this.zzaEM.zzaEG.setEnabled(this.zzaEM.zzaEB.booleanValue());
                        this.zzaEM.zzaEB = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    static class zza extends com.google.android.gms.internal.zzwc.zza {
        private OnStateChangedListener zzaEK;
        private final WalletFragment zzaEL;

        zza(WalletFragment walletFragment) {
            this.zzaEL = walletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaEK != null) {
                this.zzaEK.onStateChanged(this.zzaEL, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaEK = onStateChangedListener;
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.zzXZ.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        return this.zzaEG != null ? this.zzaEG.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzaEG != null) {
            this.zzaEG.initialize(initParams);
            this.zzaEy = null;
        } else if (this.zzaEy == null) {
            this.zzaEy = initParams;
            if (this.zzaEz != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaEA != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzaEG != null) {
            this.zzaEG.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaEy != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzaEy = walletFragmentInitParams;
            }
            if (this.zzaEz == null) {
                this.zzaEz = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.zzaEA == null) {
                this.zzaEA = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.zzaEx = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.zzaEB = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.zzXZ.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzXZ.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzao(this.zzXZ.getActivity());
                this.zzaEx = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzaEI.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaEI.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.zzaEx == null) {
            this.zzaEx = WalletFragmentOptions.zza((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.zzaEx);
        this.zzaEI.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzaEI.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaEI.onResume();
        FragmentManager fragmentManager = this.zzXZ.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzXZ.getActivity()), this.zzXZ.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaEI.onSaveInstanceState(outState);
        if (this.zzaEy != null) {
            outState.putParcelable("walletFragmentInitParams", this.zzaEy);
            this.zzaEy = null;
        }
        if (this.zzaEz != null) {
            outState.putParcelable("maskedWalletRequest", this.zzaEz);
            this.zzaEz = null;
        }
        if (this.zzaEA != null) {
            outState.putParcelable("maskedWallet", this.zzaEA);
            this.zzaEA = null;
        }
        if (this.zzaEx != null) {
            outState.putParcelable("walletFragmentOptions", this.zzaEx);
            this.zzaEx = null;
        }
        if (this.zzaEB != null) {
            outState.putBoolean("enabled", this.zzaEB.booleanValue());
            this.zzaEB = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.zzaEI.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaEI.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzaEG != null) {
            this.zzaEG.setEnabled(enabled);
            this.zzaEB = null;
            return;
        }
        this.zzaEB = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzaEJ.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaEG != null) {
            this.zzaEG.updateMaskedWallet(maskedWallet);
            this.zzaEA = null;
            return;
        }
        this.zzaEA = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzaEG != null) {
            this.zzaEG.updateMaskedWalletRequest(request);
            this.zzaEz = null;
            return;
        }
        this.zzaEz = request;
    }
}
