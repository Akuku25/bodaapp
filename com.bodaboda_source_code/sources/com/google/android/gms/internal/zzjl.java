package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public final class zzjl extends zzk<zzjn> {

    private static final class zzb implements StateDeletedResult {
        private final Status zzHb;
        private final int zzHc;

        public zzb(Status status, int i) {
            this.zzHb = status;
            this.zzHc = i;
        }

        public int getStateKey() {
            return this.zzHc;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static final class zzd extends com.google.android.gms.common.api.zzc implements StateListResult {
        private final AppStateBuffer zzHd;

        public zzd(DataHolder dataHolder) {
            super(dataHolder);
            this.zzHd = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.zzHd;
        }
    }

    private static final class zzf extends com.google.android.gms.common.api.zzc implements StateConflictResult, StateLoadedResult, StateResult {
        private final int zzHc;
        private final AppStateBuffer zzHd;

        public zzf(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.zzHc = i;
            this.zzHd = new AppStateBuffer(dataHolder);
        }

        private boolean zzhf() {
            return this.zzHb.getStatusCode() == 2000;
        }

        public StateConflictResult getConflictResult() {
            return zzhf() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return zzhf() ? null : this;
        }

        public byte[] getLocalData() {
            return this.zzHd.getCount() == 0 ? null : this.zzHd.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.zzHd.getCount() == 0 ? null : this.zzHd.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.zzHd.getCount() == 0 ? null : this.zzHd.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.zzHc;
        }

        public void release() {
            this.zzHd.release();
        }
    }

    private static final class zza extends zzjk {
        private final com.google.android.gms.common.api.zza.zzb<StateDeletedResult> zzHa;

        public zza(com.google.android.gms.common.api.zza.zzb<StateDeletedResult> zzb) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzb((Object) zzb, (Object) "Result holder must not be null");
        }

        public void zzi(int i, int i2) {
            this.zzHa.zzd(new zzb(new Status(i), i2));
        }
    }

    private static final class zzc extends zzjk {
        private final com.google.android.gms.common.api.zza.zzb<StateListResult> zzHa;

        public zzc(com.google.android.gms.common.api.zza.zzb<StateListResult> zzb) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzb((Object) zzb, (Object) "Result holder must not be null");
        }

        public void zza(DataHolder dataHolder) {
            this.zzHa.zzd(new zzd(dataHolder));
        }
    }

    private static final class zze extends zzjk {
        private final com.google.android.gms.common.api.zza.zzb<StateResult> zzHa;

        public zze(com.google.android.gms.common.api.zza.zzb<StateResult> zzb) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzb((Object) zzb, (Object) "Result holder must not be null");
        }

        public void zza(int i, DataHolder dataHolder) {
            this.zzHa.zzd(new zzf(i, dataHolder));
        }
    }

    private static final class zzg extends zzjk {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;

        public zzg(com.google.android.gms.common.api.zza.zzb<Status> zzb) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzb((Object) zzb, (Object) "Holder must not be null");
        }

        public void zzhb() {
            this.zzHa.zzd(new Status(0));
        }
    }

    public zzjl(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 7, connectionCallbacks, onConnectionFailedListener, zzf);
    }

    protected zzjn zzL(IBinder iBinder) {
        return com.google.android.gms.internal.zzjn.zza.zzN(iBinder);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateListResult> zzb) throws RemoteException {
        ((zzjn) zzjb()).zza(new zzc(zzb));
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateDeletedResult> zzb, int i) throws RemoteException {
        ((zzjn) zzjb()).zzb(new zza(zzb), i);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateResult> zzb, int i, String str, byte[] bArr) throws RemoteException {
        ((zzjn) zzjb()).zza(new zze(zzb), i, str, bArr);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateResult> zzb, int i, byte[] bArr) throws RemoteException {
        zzjm zzjm;
        if (zzb == null) {
            zzjm = null;
        } else {
            Object zze = new zze(zzb);
        }
        ((zzjn) zzjb()).zza(zzjm, i, bArr);
    }

    public void zzb(com.google.android.gms.common.api.zza.zzb<Status> zzb) throws RemoteException {
        ((zzjn) zzjb()).zzb(new zzg(zzb));
    }

    public void zzb(com.google.android.gms.common.api.zza.zzb<StateResult> zzb, int i) throws RemoteException {
        ((zzjn) zzjb()).zza(new zze(zzb), i);
    }

    protected String zzcF() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    protected List<String> zzf(List<String> list) {
        zzx.zza(list.contains(Scopes.APP_STATE), String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
        return list;
    }

    public boolean zzhc() {
        return true;
    }

    public int zzhd() {
        try {
            return ((zzjn) zzjb()).zzhd();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int zzhe() {
        try {
            return ((zzjn) zzjb()).zzhe();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzL(iBinder);
    }
}
