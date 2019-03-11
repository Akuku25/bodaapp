package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzwb;
import com.google.android.gms.internal.zzwj;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private boolean mCreated = false;
    private final Fragment zzPt = this;
    private MaskedWallet zzaEA;
    private Boolean zzaEB;
    private zzb zzaEt;
    private final zzh zzaEu = zzh.zza(this);
    private final zzc zzaEv = new zzc();
    private zza zzaEw = new zza(this);
    private WalletFragmentOptions zzaEx;
    private WalletFragmentInitParams zzaEy;
    private MaskedWalletRequest zzaEz;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
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
        final /* synthetic */ SupportWalletFragment zzaEF;

        private zzc(SupportWalletFragment supportWalletFragment) {
            this.zzaEF = supportWalletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzaEF.zzPt.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzaEF.zzPt.getActivity());
            button.setText(C0099R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzaEF.zzaEx != null) {
                WalletFragmentStyle fragmentStyle = this.zzaEF.zzaEx.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzaEF.zzPt.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> zzf) {
            Activity activity = this.zzaEF.zzPt.getActivity();
            if (this.zzaEF.zzaEt == null && this.zzaEF.mCreated && activity != null) {
                try {
                    this.zzaEF.zzaEt = new zzb(zzwj.zza(activity, this.zzaEF.zzaEu, this.zzaEF.zzaEx, this.zzaEF.zzaEw));
                    this.zzaEF.zzaEx = null;
                    zzf.zza(this.zzaEF.zzaEt);
                    if (this.zzaEF.zzaEy != null) {
                        this.zzaEF.zzaEt.initialize(this.zzaEF.zzaEy);
                        this.zzaEF.zzaEy = null;
                    }
                    if (this.zzaEF.zzaEz != null) {
                        this.zzaEF.zzaEt.updateMaskedWalletRequest(this.zzaEF.zzaEz);
                        this.zzaEF.zzaEz = null;
                    }
                    if (this.zzaEF.zzaEA != null) {
                        this.zzaEF.zzaEt.updateMaskedWallet(this.zzaEF.zzaEA);
                        this.zzaEF.zzaEA = null;
                    }
                    if (this.zzaEF.zzaEB != null) {
                        this.zzaEF.zzaEt.setEnabled(this.zzaEF.zzaEB.booleanValue());
                        this.zzaEF.zzaEB = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    static class zza extends com.google.android.gms.internal.zzwc.zza {
        private OnStateChangedListener zzaEC;
        private final SupportWalletFragment zzaED;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzaED = supportWalletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaEC != null) {
                this.zzaEC.onStateChanged(this.zzaED, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaEC = onStateChangedListener;
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.zzPt.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        return this.zzaEt != null ? this.zzaEt.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzaEt != null) {
            this.zzaEt.initialize(initParams);
            this.zzaEy = null;
        } else if (this.zzaEy == null) {
            this.zzaEy = initParams;
            if (this.zzaEz != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaEA != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzaEt != null) {
            this.zzaEt.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaEy != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.zzPt.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzPt.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzao(this.zzPt.getActivity());
                this.zzaEx = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzaEv.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaEv.onCreateView(inflater, container, savedInstanceState);
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
        this.zzaEv.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzaEv.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaEv.onResume();
        FragmentManager supportFragmentManager = this.zzPt.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzPt.getActivity()), this.zzPt.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaEv.onSaveInstanceState(outState);
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
        this.zzaEv.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaEv.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzaEt != null) {
            this.zzaEt.setEnabled(enabled);
            this.zzaEB = null;
            return;
        }
        this.zzaEB = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzaEw.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaEt != null) {
            this.zzaEt.updateMaskedWallet(maskedWallet);
            this.zzaEA = null;
            return;
        }
        this.zzaEA = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzaEt != null) {
            this.zzaEt.updateMaskedWalletRequest(request);
            this.zzaEz = null;
            return;
        }
        this.zzaEz = request;
    }
}
