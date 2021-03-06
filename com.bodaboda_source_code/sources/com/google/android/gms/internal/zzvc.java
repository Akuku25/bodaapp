package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.zzy;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class zzvc extends zzk<zzva> implements zzur {
    private final zzf zzPG;
    private final zzus zzPr;
    private Integer zzPs;
    private final ExecutorService zzawZ;

    private static class zza extends com.google.android.gms.internal.zzuy.zza {
        private final zzus zzPr;
        private final ExecutorService zzawZ;

        public zza(zzus zzus, ExecutorService executorService) {
            this.zzPr = zzus;
            this.zzawZ = executorService;
        }

        private ServerAuthCodeCallbacks zzsx() throws RemoteException {
            return this.zzPr.zzsx();
        }

        public void zza(final String str, final String str2, final zzva zzva) throws RemoteException {
            this.zzawZ.submit(new Runnable(this) {
                final /* synthetic */ zza zzaxd;

                public void run() {
                    try {
                        zzva.zzaf(this.zzaxd.zzsx().onUploadServerAuthCode(str, str2));
                    } catch (Throwable e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", e);
                    }
                }
            });
        }

        public void zza(final String str, final List<Scope> list, final zzva zzva) throws RemoteException {
            this.zzawZ.submit(new Runnable(this) {
                final /* synthetic */ zza zzaxd;

                public void run() {
                    try {
                        CheckResult onCheckServerAuthorization = this.zzaxd.zzsx().onCheckServerAuthorization(str, Collections.unmodifiableSet(new HashSet(list)));
                        zzva.zza(new zzuw(onCheckServerAuthorization.zzic(), onCheckServerAuthorization.zzid()));
                    } catch (Throwable e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", e);
                    }
                }
            });
        }
    }

    public zzvc(Context context, Looper looper, zzf zzf, zzus zzus, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ExecutorService executorService) {
        super(context, looper, 44, connectionCallbacks, onConnectionFailedListener, zzf);
        this.zzPG = zzf;
        this.zzPr = zzus;
        this.zzPs = zzf.zziV();
        this.zzawZ = executorService;
    }

    public static Bundle zza(zzus zzus, Integer num, ExecutorService executorService) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzus.zzsv());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzus.zzsw());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzus.zzrN());
        if (zzus.zzsx() != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new zza(zzus, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        return bundle;
    }

    public void zza(zzq zzq, Set<Scope> set, zzuz zzuz) {
        zzx.zzb((Object) zzuz, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((zzva) zzjb()).zza(new zzc(zzq, set), zzuz);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
            try {
                zzuz.zza(new ConnectionResult(8, null), new zzut());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public void zza(zzq zzq, boolean z) {
        try {
            ((zzva) zzjb()).zza(zzq, this.zzPs.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzt zzt) {
        zzx.zzb((Object) zzt, (Object) "Expecting a valid IResolveAccountCallbacks");
        try {
            ((zzva) zzjb()).zza(new zzy(this.zzPG.zziN(), this.zzPs.intValue()), zzt);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try {
                zzt.zzb(new zzaa(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    protected String zzcF() {
        return "com.google.android.gms.signin.service.START";
    }

    protected zzva zzcG(IBinder iBinder) {
        return com.google.android.gms.internal.zzva.zza.zzcF(iBinder);
    }

    protected String zzcG() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected Bundle zzhq() {
        Bundle zza = zza(this.zzPr, this.zzPG.zziV(), this.zzawZ);
        if (!getContext().getPackageName().equals(this.zzPG.zziR())) {
            zza.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzPG.zziR());
        }
        return zza;
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzcG(iBinder);
    }

    public void zzsu() {
        try {
            ((zzva) zzjb()).zzhb(this.zzPs.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }
}
