package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.zza.zza;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class zzbd extends zzk<zzai> {
    private final zzaj<zza> zzaGG = new zzb();
    private final zzaj<DataListener> zzaGH = new zzc();
    private final zzaj<MessageListener> zzaGI = new zzd();
    private final zzaj<NodeListener> zzaGJ = new zze();
    private final ExecutorService zzazT = Executors.newCachedThreadPool();

    public zzbd(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf zzf) {
        super(context, looper, 14, connectionCallbacks, onConnectionFailedListener, zzf);
    }

    private FutureTask<Boolean> zza(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask(new Callable<Boolean>(this) {
            final /* synthetic */ zzbd zzaGL;

            public /* synthetic */ Object call() throws Exception {
                return zzvl();
            }

            public Boolean zzvl() {
                if (Log.isLoggable("WearableClient", 3)) {
                    Log.d("WearableClient", "processAssets: writing data to FD : " + parcelFileDescriptor);
                }
                AutoCloseOutputStream autoCloseOutputStream = new AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    autoCloseOutputStream.write(bArr);
                    autoCloseOutputStream.flush();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: wrote data: " + parcelFileDescriptor);
                    }
                    Boolean valueOf = Boolean.valueOf(true);
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                        return valueOf;
                    } catch (IOException e) {
                        return valueOf;
                    }
                } catch (IOException e2) {
                    Log.w("WearableClient", "processAssets: writing data failed: " + parcelFileDescriptor);
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e3) {
                    }
                    return Boolean.valueOf(false);
                } catch (Throwable th) {
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e4) {
                    }
                    throw th;
                }
            }
        });
    }

    public void disconnect() {
        this.zzaGG.zzb(this);
        this.zzaGH.zzb(this);
        this.zzaGI.zzb(this);
        this.zzaGJ.zzb(this);
        super.disconnect();
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.zzaGG.zzcS(iBinder);
            this.zzaGH.zzcS(iBinder);
            this.zzaGI.zzcS(iBinder);
            this.zzaGJ.zzcS(iBinder);
        }
        super.zza(i, iBinder, bundle);
    }

    public void zza(zzb<DataItemResult> zzb, Uri uri) throws RemoteException {
        ((zzai) zzjb()).zza(new zzd(zzb), uri);
    }

    public void zza(zzb<GetFdForAssetResult> zzb, Asset asset) throws RemoteException {
        ((zzai) zzjb()).zza(new zzf(zzb), asset);
    }

    public void zza(zzb<Status> zzb, DataListener dataListener) throws RemoteException {
        this.zzaGH.zza(this, zzb, dataListener);
    }

    public void zza(zzb<Status> zzb, DataListener dataListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzaGH.zza(this, zzb, dataListener, intentFilterArr);
    }

    public void zza(zzb<GetFdForAssetResult> zzb, DataItemAsset dataItemAsset) throws RemoteException {
        zza((zzb) zzb, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void zza(zzb<Status> zzb, MessageListener messageListener) throws RemoteException {
        this.zzaGI.zza(this, zzb, messageListener);
    }

    public void zza(zzb<Status> zzb, MessageListener messageListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzaGI.zza(this, zzb, messageListener, intentFilterArr);
    }

    public void zza(zzb<Status> zzb, NodeListener nodeListener) throws RemoteException, RemoteException {
        this.zzaGJ.zza(this, zzb, nodeListener, null);
    }

    public void zza(zzb<DataItemResult> zzb, PutDataRequest putDataRequest) throws RemoteException {
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest zzn = PutDataRequest.zzn(putDataRequest.getUri());
        zzn.setData(putDataRequest.getData());
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.getData() == null) {
                zzn.putAsset((String) value2.getKey(), (Asset) value2.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    zzn.putAsset((String) value2.getKey(), Asset.createFromFd(createPipe[0]));
                    Runnable zza = zza(createPipe[1], asset2.getData());
                    arrayList.add(zza);
                    this.zzazT.submit(zza);
                } catch (Throwable e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        try {
            ((zzai) zzjb()).zza(new zzi(zzb, arrayList), zzn);
        } catch (Throwable e2) {
            throw new IllegalStateException("Unable to putDataItem: " + putDataRequest, e2);
        }
    }

    public void zza(zzb<SendMessageResult> zzb, String str, String str2, byte[] bArr) throws RemoteException {
        ((zzai) zzjb()).zza(new zzj(zzb), str, str2, bArr);
    }

    public void zzb(zzb<DataItemBuffer> zzb, Uri uri) throws RemoteException {
        ((zzai) zzjb()).zzb(new zze(zzb), uri);
    }

    public void zzb(zzb<Status> zzb, NodeListener nodeListener) throws RemoteException {
        this.zzaGJ.zza(this, zzb, nodeListener);
    }

    public void zzc(zzb<DeleteDataItemsResult> zzb, Uri uri) throws RemoteException {
        ((zzai) zzjb()).zzc(new zzb(zzb), uri);
    }

    protected String zzcF() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String zzcG() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    protected zzai zzcT(IBinder iBinder) {
        return zzai.zza.zzcR(iBinder);
    }

    public void zzm(zzb<DataItemBuffer> zzb) throws RemoteException {
        ((zzai) zzjb()).zzb(new zze(zzb));
    }

    public void zzn(zzb<GetLocalNodeResult> zzb) throws RemoteException {
        ((zzai) zzjb()).zzc(new zzg(zzb));
    }

    public void zzo(zzb<GetConnectedNodesResult> zzb) throws RemoteException {
        ((zzai) zzjb()).zzd(new zzc(zzb));
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzcT(iBinder);
    }
}
