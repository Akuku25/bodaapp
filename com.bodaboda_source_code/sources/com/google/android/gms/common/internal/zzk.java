package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzmh;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class zzk<T extends IInterface> implements com.google.android.gms.common.api.Api.zza, com.google.android.gms.common.internal.zzl.zza {
    public static final String[] zzPR = new String[]{"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Account zzFN;
    private final List<String> zzMM;
    private final Looper zzMc;
    private final zzl zzMu;
    private final zzf zzPG;
    private final zzm zzPH;
    private zzs zzPI;
    private boolean zzPJ;
    private com.google.android.gms.common.api.GoogleApiClient.zza zzPK;
    private T zzPL;
    private final ArrayList<zzc<?>> zzPM;
    private zze zzPN;
    private int zzPO;
    boolean zzPP;
    private final int zzPQ;
    private final Object zznh;

    final class zzb extends Handler {
        final /* synthetic */ zzk zzPT;

        public zzb(zzk zzk, Looper looper) {
            this.zzPT = zzk;
            super(looper);
        }

        public void handleMessage(Message msg) {
            zzc zzc;
            if ((msg.what == 1 || msg.what == 5 || msg.what == 6) && !this.zzPT.isConnecting()) {
                zzc = (zzc) msg.obj;
                zzc.zzjf();
                zzc.unregister();
            } else if (msg.what == 3) {
                this.zzPT.zzMu.zzg(new ConnectionResult(((Integer) msg.obj).intValue(), null));
            } else if (msg.what == 4) {
                this.zzPT.zza(4, null);
                this.zzPT.zzMu.zzaJ(((Integer) msg.obj).intValue());
                this.zzPT.zza(4, 1, null);
            } else if (msg.what == 2 && !this.zzPT.isConnected()) {
                zzc = (zzc) msg.obj;
                zzc.zzjf();
                zzc.unregister();
            } else if (msg.what == 2 || msg.what == 1 || msg.what == 5 || msg.what == 6) {
                ((zzc) msg.obj).zzjg();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    protected abstract class zzc<TListener> {
        private TListener mListener;
        final /* synthetic */ zzk zzPT;
        private boolean zzPU = false;

        public zzc(zzk zzk, TListener tListener) {
            this.zzPT = zzk;
            this.mListener = tListener;
        }

        public void unregister() {
            zzjh();
            synchronized (this.zzPT.zzPM) {
                this.zzPT.zzPM.remove(this);
            }
        }

        protected abstract void zzi(TListener tListener);

        protected abstract void zzjf();

        public void zzjg() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.zzPU) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    zzi(obj);
                } catch (RuntimeException e) {
                    zzjf();
                    throw e;
                }
            }
            zzjf();
            synchronized (this) {
                this.zzPU = true;
            }
            unregister();
        }

        public void zzjh() {
            synchronized (this) {
                this.mListener = null;
            }
        }
    }

    public final class zze implements ServiceConnection {
        final /* synthetic */ zzk zzPT;

        public zze(zzk zzk) {
            this.zzPT = zzk;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            zzx.zzb((Object) binder, (Object) "Expecting a valid IBinder");
            this.zzPT.zzPI = com.google.android.gms.common.internal.zzs.zza.zzU(binder);
            this.zzPT.mHandler.sendMessage(this.zzPT.mHandler.obtainMessage(6, new zzg(this.zzPT)));
        }

        public void onServiceDisconnected(ComponentName component) {
            this.zzPT.mHandler.sendMessage(this.zzPT.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    private abstract class zza extends zzc<Boolean> {
        public final int statusCode;
        public final Bundle zzPS;
        final /* synthetic */ zzk zzPT;

        protected zza(zzk zzk, int i, Bundle bundle) {
            this.zzPT = zzk;
            super(zzk, Boolean.valueOf(true));
            this.statusCode = i;
            this.zzPS = bundle;
        }

        protected void zzc(Boolean bool) {
            if (bool == null) {
                this.zzPT.zza(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzje()) {
                        if (this.zzPT.zzPN != null) {
                            this.zzPT.zzPH.zzb(this.zzPT.zzcF(), this.zzPT.zzPN, this.zzPT.zziZ());
                            this.zzPT.zzPN = null;
                        }
                        this.zzPT.zza(1, null);
                        zzf(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.zzPT.zza(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.zzPS != null ? (PendingIntent) this.zzPS.getParcelable("pendingIntent") : null;
                    if (this.zzPT.zzPN != null) {
                        this.zzPT.zzPH.zzb(this.zzPT.zzcF(), this.zzPT.zzPN, this.zzPT.zziZ());
                        this.zzPT.zzPN = null;
                    }
                    this.zzPT.zza(1, null);
                    zzf(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        protected void zzf(ConnectionResult connectionResult) {
            this.zzPT.zzMu.zzg(connectionResult);
        }

        protected /* synthetic */ void zzi(Object obj) {
            zzc((Boolean) obj);
        }

        protected abstract boolean zzje();

        protected void zzjf() {
        }
    }

    public static final class zzd extends com.google.android.gms.common.internal.zzr.zza {
        private zzk zzPV;

        public zzd(zzk zzk) {
            this.zzPV = zzk;
        }

        private void zzji() {
            this.zzPV = null;
        }

        public void zzb(int i, IBinder iBinder, Bundle bundle) {
            zzx.zzb(this.zzPV, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzPV.zza(i, iBinder, bundle);
            zzji();
        }

        public void zzc(int i, Bundle bundle) {
            zzx.zzb(this.zzPV, (Object) "onAccountValidationComplete can be called only once per call to validateAccount");
            this.zzPV.zzb(i, bundle);
            zzji();
        }
    }

    protected final class zzf extends zza {
        final /* synthetic */ zzk zzPT;
        public final IBinder zzPW;

        public zzf(zzk zzk, int i, IBinder iBinder, Bundle bundle) {
            this.zzPT = zzk;
            super(zzk, i, bundle);
            this.zzPW = iBinder;
        }

        protected boolean zzje() {
            try {
                if (!this.zzPT.zzcG().equals(this.zzPW.getInterfaceDescriptor())) {
                    return false;
                }
                IInterface zzp = this.zzPT.zzp(this.zzPW);
                if (zzp == null || !this.zzPT.zza(2, 3, zzp)) {
                    return false;
                }
                this.zzPT.zzMu.zzfe();
                GooglePlayServicesUtil.zzL(this.zzPT.mContext);
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzg extends zza {
        final /* synthetic */ zzk zzPT;

        public zzg(zzk zzk) {
            this.zzPT = zzk;
            super(zzk, 0, null);
        }

        protected boolean zzje() {
            if (this.zzPT.zzPJ) {
                zzx.zza(this.zzPT.zzPK != null, (Object) "mConnectionProgressReportCallbacks should not be null if mReportProgress");
                this.zzPT.zzPK.zzia();
            } else {
                this.zzPT.zzb(null);
            }
            return true;
        }
    }

    protected final class zzh extends zza {
        final /* synthetic */ zzk zzPT;

        public zzh(zzk zzk, int i, Bundle bundle) {
            this.zzPT = zzk;
            super(zzk, i, bundle);
        }

        protected boolean zzje() {
            boolean z = this.zzPT.zzPJ && this.zzPT.zzPK != null;
            zzx.zza(z, (Object) "PostValidationCallback should not happen when mReportProgress is false ormConnectionProgressReportCallbacks is null");
            this.zzPT.zzPK.zzib();
            return true;
        }
    }

    @Deprecated
    protected zzk(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this.zznh = new Object();
        this.zzPJ = false;
        this.zzPM = new ArrayList();
        this.zzPO = 1;
        this.zzPP = false;
        this.mContext = (Context) zzx.zzl(context);
        this.zzMc = (Looper) zzx.zzb((Object) looper, (Object) "Looper must not be null");
        this.zzPH = zzm.zzP(context);
        this.zzMu = new zzl(looper, this);
        this.mHandler = new zzb(this, looper);
        this.zzPQ = i;
        this.zzFN = null;
        this.zzMM = null;
        this.zzPG = new Builder(context).zzhY();
        registerConnectionCallbacks((ConnectionCallbacks) zzx.zzl(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) zzx.zzl(onConnectionFailedListener));
    }

    protected zzk(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf zzf) {
        this(context, looper, zzm.zzP(context), i, zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected zzk(Context context, Looper looper, zzm zzm, int i, zzf zzf) {
        this.zznh = new Object();
        this.zzPJ = false;
        this.zzPM = new ArrayList();
        this.zzPO = 1;
        this.zzPP = false;
        this.mContext = (Context) zzx.zzb((Object) context, (Object) "Context must not be null");
        this.zzMc = (Looper) zzx.zzb((Object) looper, (Object) "Looper must not be null");
        this.zzPH = (zzm) zzx.zzb((Object) zzm, (Object) "Supervisor must not be null");
        this.zzMu = new zzl(looper, this);
        this.mHandler = new zzb(this, looper);
        this.zzPQ = i;
        this.zzPG = (zzf) zzx.zzl(zzf);
        this.zzFN = zzf.getAccount();
        this.zzMM = zzh(zzf.zziP());
    }

    protected zzk(Context context, Looper looper, zzm zzm, int i, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzm, i, zzf);
        registerConnectionCallbacks((ConnectionCallbacks) zzx.zzl(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) zzx.zzl(onConnectionFailedListener));
    }

    private void zza(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzx.zzO(z);
        synchronized (this.zznh) {
            this.zzPO = i;
            this.zzPL = t;
        }
    }

    private boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zznh) {
            if (this.zzPO != i) {
                z = false;
            } else {
                zza(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    private List<String> zzh(List<String> list) {
        List<String> zzf = zzf((List) list);
        if (zzf == null || zzf == list) {
            return zzf;
        }
        for (String contains : zzf) {
            if (!list.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzf;
    }

    public void connect() {
        this.zzPP = true;
        zza(2, null);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, null);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.zzPN != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzcF());
            this.zzPH.zzb(zzcF(), this.zzPN, zziZ());
        }
        this.zzPN = new zze(this);
        if (!this.zzPH.zza(zzcF(), this.zzPN, zziZ())) {
            Log.e("GmsClient", "unable to connect to service: " + zzcF());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    public void disconnect() {
        this.zzPP = false;
        synchronized (this.zzPM) {
            int size = this.zzPM.size();
            for (int i = 0; i < size; i++) {
                ((zzc) this.zzPM.get(i)).zzjh();
            }
            this.zzPM.clear();
        }
        zza(1, null);
        if (this.zzPN != null) {
            this.zzPH.zzb(zzcF(), this.zzPN, zziZ());
            this.zzPN = null;
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).println("GmsClient:");
        CharSequence charSequence = prefix + "  ";
        writer.append(charSequence).append("mStartServiceAction=").println(zzcF());
        synchronized (this.zznh) {
            int i = this.zzPO;
            IInterface iInterface = this.zzPL;
        }
        writer.append(charSequence).append("mConnectState=");
        switch (i) {
            case 1:
                writer.print("DISCONNECTED");
                break;
            case 2:
                writer.print("CONNECTING");
                break;
            case 3:
                writer.print("CONNECTED");
                break;
            case 4:
                writer.print("DISCONNECTING");
                break;
            default:
                writer.print("UNKNOWN");
                break;
        }
        writer.append(" mService=");
        if (iInterface == null) {
            writer.println("null");
        } else {
            writer.append(zzcG()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzMc;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzPO == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzPO == 2;
        }
        return z;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzMu.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzMu.registerConnectionFailedListener(listener);
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new zzf(this, i, iBinder, bundle)));
    }

    public void zza(com.google.android.gms.common.api.GoogleApiClient.zza zza) {
        this.zzPK = (com.google.android.gms.common.api.GoogleApiClient.zza) zzx.zzb((Object) zza, (Object) "Must provide a non-null ConnectionStatusReportCallbacks");
        this.zzPJ = true;
    }

    @Deprecated
    public final void zza(zzc<?> zzc) {
        synchronized (this.zzPM) {
            this.zzPM.add(zzc);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, zzc));
    }

    public void zza(zzq zzq) {
        try {
            this.zzPI.zza(new zzd(this), new zzae(zzq, this.zzMM == null ? null : zzmh.zzi(this.zzMM), this.mContext.getPackageName(), zzjc()));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzaI(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void zzaI(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    protected void zzb(int i, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, new zzh(this, i, bundle)));
    }

    public void zzb(zzq zzq) {
        try {
            zzi zzi = new zzi(this.zzPQ).zzbg(this.mContext.getPackageName()).zzi(zzhq());
            if (this.zzMM != null) {
                zzi.zza(zzmh.zzi(this.zzMM));
            }
            if (zzhc()) {
                zzi.zzb(zziN()).zzd(zzq);
            } else if (zzjd()) {
                zzi.zzb(this.zzFN);
            }
            this.zzPI.zza(new zzd(this), zzi);
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzaI(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    protected abstract String zzcF();

    protected abstract String zzcG();

    protected List<String> zzf(List<String> list) {
        return list;
    }

    protected final void zzfc() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public boolean zzhc() {
        return false;
    }

    public Bundle zzhp() {
        return null;
    }

    protected Bundle zzhq() {
        return new Bundle();
    }

    public final Account zziN() {
        return this.zzFN != null ? this.zzFN : new Account("<<default account>>", GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    public final List<String> zziP() {
        return this.zzMM;
    }

    protected String zziZ() {
        return this.zzPG.zziS();
    }

    public boolean zzin() {
        return this.zzPP;
    }

    protected final zzf zzja() {
        return this.zzPG;
    }

    public final T zzjb() throws DeadObjectException {
        T t;
        synchronized (this.zznh) {
            if (this.zzPO == 4) {
                throw new DeadObjectException();
            }
            zzfc();
            zzx.zza(this.zzPL != null, (Object) "Client is connected but service is null");
            t = this.zzPL;
        }
        return t;
    }

    protected Bundle zzjc() {
        return null;
    }

    public boolean zzjd() {
        return false;
    }

    protected abstract T zzp(IBinder iBinder);
}
