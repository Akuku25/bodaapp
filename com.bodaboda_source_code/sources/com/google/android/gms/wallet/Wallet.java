package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzvw;
import com.google.android.gms.internal.zzwh;
import com.google.android.gms.internal.zzwi;
import com.google.android.gms.internal.zzwk;
import com.google.android.gms.internal.zzwl;
import com.google.android.gms.wallet.wobs.zzr;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api(zzGS, zzGR, new Scope[0]);
    public static final Payments Payments = new zzwh();
    private static final zzc<zzwi> zzGR = new zzc();
    private static final com.google.android.gms.common.api.Api.zzb<zzwi, WalletOptions> zzGS = new C04091();
    public static final zzr zzaEm = new zzwl();
    public static final zzvw zzaEn = new zzwk();

    /* renamed from: com.google.android.gms.wallet.Wallet$1 */
    static class C04091 implements com.google.android.gms.common.api.Api.zzb<zzwi, WalletOptions> {
        C04091() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzwi zza(Context context, Looper looper, zzf zzf, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new zzwi(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, zzf.getAccountName(), walletOptions.theme);
        }
    }

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int mTheme = 0;
            private int zzaEo = 0;

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1) {
                    this.zzaEo = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzaEo;
            this.theme = builder.mTheme;
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzwi> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.zzGR, googleApiClient);
        }
    }

    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
