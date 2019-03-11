package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzd;
import com.google.android.gms.drive.internal.zzq.zza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzr extends zzk<zzag> {
    private final String zzMh;
    private final Bundle zzTC;
    private final boolean zzTD;
    private DriveId zzTE;
    private DriveId zzTF;
    final ConnectionCallbacks zzTG;
    final Map<DriveId, Map<zzc, zzaa>> zzTH = new HashMap();

    public zzr(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, connectionCallbacks, onConnectionFailedListener, zzf);
        this.zzMh = zzf.zziR();
        this.zzTG = connectionCallbacks;
        this.zzTC = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.zzTD = false;
                return;
            case 1:
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                if (serviceInfo.exported) {
                    this.zzTD = true;
                    return;
                }
                throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, final List<String> pendingTags) {
        boolean z = true;
        zzx.zzO(pendingTags != null);
        if (pendingTags.isEmpty()) {
            z = false;
        }
        zzx.zzO(z);
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return apiClient.zzb(new zza(this, apiClient) {
            final /* synthetic */ zzr zzTL;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zza(new CancelPendingActionsRequest(pendingTags), new zzbl(this));
            }
        });
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzag) zzjb()).zza(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.zzTH.clear();
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, final DriveId driveId, final int i) {
        zzx.zzb(zzd.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        if (this.zzTD) {
            return googleApiClient.zzb(new zza(this, googleApiClient) {
                final /* synthetic */ zzr zzTL;

                protected void zza(zzr zzr) throws RemoteException {
                    zzr.zzkF().zza(new AddEventListenerRequest(driveId, i), null, null, new zzbl(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, int i, zzc zzc) {
        PendingResult<Status> zzj;
        zzx.zzb(zzd.zza(i, driveId), (Object) "id");
        zzx.zzb((Object) zzc, (Object) "listener");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        synchronized (this.zzTH) {
            Map map;
            zzaa zzaa;
            Map map2 = (Map) this.zzTH.get(driveId);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.zzTH.put(driveId, hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            zzaa zzaa2 = (zzaa) map.get(zzc);
            if (zzaa2 == null) {
                zzaa = new zzaa(getLooper(), getContext(), i, zzc);
                map.put(zzc, zzaa);
            } else if (zzaa2.zzbK(i)) {
                zzj = new zzj(googleApiClient, Status.zzNo);
            } else {
                zzaa = zzaa2;
            }
            zzaa.zzbJ(i);
            final DriveId driveId2 = driveId;
            final int i2 = i;
            zzj = googleApiClient.zzb(new zza(this, googleApiClient) {
                final /* synthetic */ zzr zzTL;

                protected void zza(zzr zzr) throws RemoteException {
                    zzr.zzkF().zza(new AddEventListenerRequest(driveId2, i2), zzaa, null, new zzbl(this));
                }
            });
        }
        return zzj;
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzTE = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzTF = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.zza(i, iBinder, bundle);
    }

    protected zzag zzab(IBinder iBinder) {
        return zzag.zza.zzac(iBinder);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, final DriveId driveId, final int i) {
        zzx.zzb(zzd.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzr zzTL;

            protected void zza(zzr zzr) throws RemoteException {
                zzr.zzkF().zza(new RemoveEventListenerRequest(driveId, i), null, null, new zzbl(this));
            }
        });
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, int i, zzc zzc) {
        PendingResult<Status> zzj;
        zzx.zzb(zzd.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        zzx.zzb((Object) zzc, (Object) "listener");
        synchronized (this.zzTH) {
            Map map = (Map) this.zzTH.get(driveId);
            if (map == null) {
                zzj = new zzj(googleApiClient, Status.zzNo);
            } else {
                final zzaa zzaa = (zzaa) map.remove(zzc);
                if (zzaa == null) {
                    zzj = new zzj(googleApiClient, Status.zzNo);
                } else {
                    if (map.isEmpty()) {
                        this.zzTH.remove(driveId);
                    }
                    final DriveId driveId2 = driveId;
                    final int i2 = i;
                    zzj = googleApiClient.zzb(new zza(this, googleApiClient) {
                        final /* synthetic */ zzr zzTL;

                        protected void zza(zzr zzr) throws RemoteException {
                            zzr.zzkF().zza(new RemoveEventListenerRequest(driveId2, i2), zzaa, null, new zzbl(this));
                        }
                    });
                }
            }
        }
        return zzj;
    }

    protected String zzcF() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public boolean zzhc() {
        return true;
    }

    protected Bundle zzhq() {
        String packageName = getContext().getPackageName();
        zzx.zzl(packageName);
        zzx.zzl(zziP());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzMh)) {
            bundle.putString("proxy_package_name", this.zzMh);
        }
        bundle.putAll(this.zzTC);
        return bundle;
    }

    public zzag zzkF() throws DeadObjectException {
        return (zzag) zzjb();
    }

    public DriveId zzkG() {
        return this.zzTE;
    }

    public DriveId zzkH() {
        return this.zzTF;
    }

    public boolean zzkI() {
        return this.zzTD;
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzab(iBinder);
    }
}
