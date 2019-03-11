package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzmh;
import com.google.android.gms.internal.zzur;
import com.google.android.gms.internal.zzus;
import com.google.android.gms.internal.zzut;
import com.google.android.gms.internal.zzuv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class zzd implements GoogleApiClient {
    private final Context mContext;
    private final Lock zzCN = new ReentrantLock();
    private volatile boolean zzMA;
    private int zzMB = 0;
    private boolean zzMC = false;
    private int zzMD;
    private long zzME = 120000;
    private long zzMF = 5000;
    private final zzc zzMG;
    BroadcastReceiver zzMH;
    private final Bundle zzMI = new Bundle();
    private final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zza> zzMJ = new HashMap();
    private final Set<com.google.android.gms.common.api.Api.zzc<?>> zzMK = new HashSet();
    private final Map<com.google.android.gms.common.api.Api.zzc<?>, ConnectionResult> zzML = new HashMap();
    private final List<String> zzMM;
    private boolean zzMN;
    private zzur zzMO;
    private int zzMP;
    private boolean zzMQ;
    private boolean zzMR;
    private zzq zzMS;
    private boolean zzMT;
    private boolean zzMU;
    private final Set<zze<?>> zzMV = Collections.newSetFromMap(new WeakHashMap());
    final Set<zzg<?>> zzMW = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final zze zzMX = new C03011(this);
    private final ConnectionCallbacks zzMY = new C04216(this);
    private final com.google.android.gms.common.api.GoogleApiClient.zza zzMZ = new C03057(this);
    private final Looper zzMc;
    private final Condition zzMt = this.zzCN.newCondition();
    private final zzl zzMu;
    private final int zzMv;
    final Queue<zzg<?>> zzMw = new LinkedList();
    private ConnectionResult zzMx;
    private int zzMy;
    private volatile int zzMz = 4;
    private final com.google.android.gms.common.internal.zzl.zza zzNa = new C03068(this);

    /* renamed from: com.google.android.gms.common.api.zzd$2 */
    class C01112 implements Runnable {
        final /* synthetic */ zzd zzNb;

        C01112(zzd zzd) {
            this.zzNb = zzd;
        }

        public void run() {
            this.zzNb.zzCN.lock();
            try {
                this.zzNb.zzij();
            } finally {
                this.zzNb.zzCN.unlock();
            }
        }
    }

    private final class zzc extends Handler {
        final /* synthetic */ zzd zzNb;

        zzc(zzd zzd, Looper looper) {
            this.zzNb = zzd;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.zzNb.zzim();
                    return;
                case 2:
                    this.zzNb.resume();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    private static class zzd extends BroadcastReceiver {
        private WeakReference<zzd> zzNj;

        zzd(zzd zzd) {
            this.zzNj = new WeakReference(zzd);
        }

        public void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                zzd zzd = (zzd) this.zzNj.get();
                if (zzd != null) {
                    zzd.resume();
                }
            }
        }
    }

    interface zze {
        void zzb(zzg<?> zzg);
    }

    interface zzg<A extends com.google.android.gms.common.api.Api.zza> {
        void cancel();

        void zza(zze zze);

        void zzb(A a) throws DeadObjectException;

        com.google.android.gms.common.api.Api.zzc<A> zzhV();

        int zzhW();

        void zzk(Status status);
    }

    /* renamed from: com.google.android.gms.common.api.zzd$1 */
    class C03011 implements zze {
        final /* synthetic */ zzd zzNb;

        C03011(zzd zzd) {
            this.zzNb = zzd;
        }

        public void zzb(zzg<?> zzg) {
            this.zzNb.zzMW.remove(zzg);
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzd$7 */
    class C03057 implements com.google.android.gms.common.api.GoogleApiClient.zza {
        final /* synthetic */ zzd zzNb;

        C03057(zzd zzd) {
            this.zzNb = zzd;
        }

        private void zzap(int i) {
            this.zzNb.zzCN.lock();
            try {
                if (this.zzNb.zzMB != i) {
                    Log.wtf("GoogleApiClientImpl", String.format("Internal error: step mismatch. Expected: %d, Actual: %d", new Object[]{Integer.valueOf(this.zzNb.zzMB), Integer.valueOf(i)}));
                    this.zzNb.zzao(4);
                    return;
                }
                if (this.zzNb.zzMz == 1) {
                    this.zzNb.zzie();
                }
                this.zzNb.zzCN.unlock();
            } finally {
                this.zzNb.zzCN.unlock();
            }
        }

        public void zzia() {
            zzap(0);
        }

        public void zzib() {
            zzap(1);
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzd$8 */
    class C03068 implements com.google.android.gms.common.internal.zzl.zza {
        final /* synthetic */ zzd zzNb;

        C03068(zzd zzd) {
            this.zzNb = zzd;
        }

        public boolean isConnected() {
            return this.zzNb.isConnected();
        }

        public Bundle zzhp() {
            return null;
        }

        public boolean zzin() {
            return this.zzNb.zzMN;
        }
    }

    private abstract class zzf implements ConnectionCallbacks {
        final /* synthetic */ zzd zzNb;

        private zzf(zzd zzd) {
            this.zzNb = zzd;
        }

        public void onConnectionSuspended(int cause) {
            this.zzNb.zzCN.lock();
            switch (cause) {
                case 1:
                    if (!this.zzNb.zzil()) {
                        this.zzNb.zzMA = true;
                        if (this.zzNb.zzMH == null) {
                            this.zzNb.zzMH = new zzd(this.zzNb);
                            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                            intentFilter.addDataScheme("package");
                            this.zzNb.mContext.getApplicationContext().registerReceiver(this.zzNb.zzMH, intentFilter);
                        }
                        this.zzNb.zzMG.sendMessageDelayed(this.zzNb.zzMG.obtainMessage(1), this.zzNb.zzME);
                        this.zzNb.zzMG.sendMessageDelayed(this.zzNb.zzMG.obtainMessage(2), this.zzNb.zzMF);
                        this.zzNb.zzao(cause);
                        break;
                    }
                    this.zzNb.zzCN.unlock();
                    return;
                case 2:
                    try {
                        this.zzNb.zzao(cause);
                        this.zzNb.connect();
                        break;
                    } catch (Throwable th) {
                        this.zzNb.zzCN.unlock();
                    }
            }
            this.zzNb.zzCN.unlock();
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzd$6 */
    class C04216 extends zzf {
        final /* synthetic */ zzd zzNb;

        C04216(zzd zzd) {
            this.zzNb = zzd;
            super();
        }

        public void onConnected(Bundle connectionHint) {
            this.zzNb.zzCN.lock();
            try {
                if (this.zzNb.isConnecting()) {
                    if (connectionHint != null) {
                        this.zzNb.zzMI.putAll(connectionHint);
                    }
                    this.zzNb.zzie();
                    this.zzNb.zzCN.unlock();
                }
            } finally {
                this.zzNb.zzCN.unlock();
            }
        }
    }

    private static class zzb extends com.google.android.gms.common.internal.zzt.zza {
        private WeakReference<zzd> zzNj;

        zzb(zzd zzd) {
            this.zzNj = new WeakReference(zzd);
        }

        public void zzb(zzaa zzaa) {
            zzd zzd = (zzd) this.zzNj.get();
            if (zzd != null) {
                zzd.zza(zzaa);
            }
        }
    }

    private static class zza extends zzuv {
        private WeakReference<zzd> zzNj;

        zza(zzd zzd) {
            this.zzNj = new WeakReference(zzd);
        }

        public void zza(ConnectionResult connectionResult, zzut zzut) {
            zzd zzd = (zzd) this.zzNj.get();
            if (zzd != null) {
                zzd.zzd(connectionResult);
            }
        }
    }

    public zzd(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf, com.google.android.gms.common.api.Api.zzb<? extends zzur, zzus> zzb, Map<Api<?>, ApiOptions> map, Map<Api<?>, Boolean> map2, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2, int i) {
        this.mContext = context;
        this.zzMu = new zzl(looper, this.zzNa);
        this.zzMc = looper;
        this.zzMG = new zzc(this, looper);
        this.zzMv = i;
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.zzMu.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.zzMu.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zzMM = Collections.unmodifiableList(zzf.zziP());
        this.zzMQ = false;
        this.zzMP = 2;
        int i2 = 0;
        for (Api api : map.keySet()) {
            int i3;
            Object obj = map.get(api);
            if (map2.get(api) != null) {
                i3 = ((Boolean) map2.get(api)).booleanValue() ? 2 : 1;
            } else {
                i3 = 0;
            }
            com.google.android.gms.common.api.Api.zza zza = zza(api.zzhT(), obj, context, looper, zzf, this.zzMY, zza(api, i3));
            zza.zza(this.zzMZ);
            this.zzMJ.put(api.zzhV(), zza);
            int i4 = (api.zzhT().getPriority() == 1 ? 1 : 0) | i2;
            if (zza.zzhc()) {
                this.zzMQ = true;
                if (i3 < this.zzMP) {
                    this.zzMP = i3;
                }
                if (i3 != 0) {
                    this.zzMK.add(api.zzhV());
                }
            }
            i2 = i4;
        }
        if (i2 != 0) {
            this.zzMQ = false;
        }
        if (this.zzMQ) {
            zzf.zza(Integer.valueOf(getSessionId()));
            zza(context, looper, zzf, (com.google.android.gms.common.api.Api.zzb) zzb);
        }
    }

    private void resume() {
        this.zzCN.lock();
        try {
            if (zzil()) {
                connect();
            }
            this.zzCN.unlock();
        } catch (Throwable th) {
            this.zzCN.unlock();
        }
    }

    private void zzM(boolean z) {
        if (this.zzMO != null) {
            if (this.zzMO.isConnected()) {
                if (z) {
                    this.zzMO.zzsu();
                }
                this.zzMO.disconnect();
            }
            this.zzMS = null;
        }
    }

    private static <C extends com.google.android.gms.common.api.Api.zza, O> C zza(com.google.android.gms.common.api.Api.zzb<C, O> zzb, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return zzb.zza(context, looper, zzf, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private final OnConnectionFailedListener zza(final Api<?> api, final int i) {
        return new OnConnectionFailedListener(this) {
            final /* synthetic */ zzd zzNb;

            public void onConnectionFailed(ConnectionResult result) {
                this.zzNb.zzCN.lock();
                try {
                    if (this.zzNb.isConnecting()) {
                        if (i != 2) {
                            int priority = api.zzhT().getPriority();
                            if (this.zzNb.zza(priority, i, result)) {
                                this.zzNb.zzMx = result;
                                this.zzNb.zzMy = priority;
                            }
                        }
                        this.zzNb.zzML.put(api.zzhV(), result);
                        this.zzNb.zzie();
                        this.zzNb.zzCN.unlock();
                    }
                } finally {
                    this.zzNb.zzCN.unlock();
                }
            }
        };
    }

    private void zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf, com.google.android.gms.common.api.Api.zzb<? extends zzur, zzus> zzb) {
        this.zzMO = (zzur) zza(zzb, zzf.zziU(), context, looper, zzf, new zzf(this) {
            final /* synthetic */ zzd zzNb;

            {
                this.zzNb = r2;
            }

            public void onConnected(Bundle connectionHint) {
                this.zzNb.zzif();
            }
        }, new OnConnectionFailedListener(this) {
            final /* synthetic */ zzd zzNb;

            {
                this.zzNb = r1;
            }

            public void onConnectionFailed(ConnectionResult result) {
                this.zzNb.zzCN.lock();
                try {
                    this.zzNb.zzb(new ConnectionResult(8, null));
                } finally {
                    this.zzNb.zzCN.unlock();
                }
            }
        });
    }

    private void zza(ConnectionResult connectionResult) {
        this.zzMC = false;
        zzM(!connectionResult.hasResolution());
        zzao(3);
        if (!(zzil() && GooglePlayServicesUtil.zzh(this.mContext, connectionResult.getErrorCode()))) {
            zzim();
            this.zzMu.zzg(connectionResult);
        }
        this.zzMN = false;
    }

    private void zza(final GoogleApiClient googleApiClient, final zzg zzg, final boolean z) {
        zzko.zzQy.zzc(googleApiClient).setResultCallback(new ResultCallback<Status>(this) {
            final /* synthetic */ zzd zzNb;

            public /* synthetic */ void onResult(Result x0) {
                zzi((Status) x0);
            }

            public void zzi(Status status) {
                if (status.isSuccess() && this.zzNb.isConnected()) {
                    this.zzNb.reconnect();
                }
                zzg.setResult(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private <A extends com.google.android.gms.common.api.Api.zza> void zza(zzg<A> zzg) throws DeadObjectException {
        this.zzCN.lock();
        try {
            zzx.zzb(zzg.zzhV() != null, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.zzMW.add(zzg);
            zzg.zza(this.zzMX);
            if (zzil()) {
                zzg.zzk(new Status(8));
                return;
            }
            com.google.android.gms.common.api.Api.zza zza = zza(zzg.zzhV());
            if (zza.isConnected() || !this.zzML.containsKey(zzg.zzhV())) {
                zzg.zzb(zza);
                this.zzCN.unlock();
                return;
            }
            zzg.zzk(new Status(17));
            this.zzCN.unlock();
        } finally {
            this.zzCN.unlock();
        }
    }

    private void zza(final zzaa zzaa) {
        ConnectionResult zzjo = zzaa.zzjo();
        if (zzjo.isSuccess()) {
            this.zzMG.post(new Runnable(this) {
                final /* synthetic */ zzd zzNb;

                public void run() {
                    this.zzNb.zzMS = zzaa.zzjn();
                    this.zzNb.zzMR = true;
                    this.zzNb.zzMT = zzaa.zzjp();
                    this.zzNb.zzMU = zzaa.zzjq();
                    this.zzNb.zzii();
                }
            });
        } else {
            zzb(zzjo);
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || connectionResult.hasResolution()) ? this.zzMx == null || i < this.zzMy : false;
    }

    private void zzao(int i) {
        this.zzCN.lock();
        try {
            if (this.zzMz != 3) {
                if (i == -1) {
                    Iterator it;
                    zzg zzg;
                    if (isConnecting()) {
                        it = this.zzMw.iterator();
                        while (it.hasNext()) {
                            zzg = (zzg) it.next();
                            if (zzg.zzhW() != 1) {
                                zzg.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        for (zzg zzg2 : this.zzMw) {
                            zzg2.cancel();
                        }
                        this.zzMw.clear();
                    }
                    for (zzg zzg22 : this.zzMW) {
                        zzg22.zza(null);
                        zzg22.cancel();
                    }
                    this.zzMW.clear();
                    for (zze clear : this.zzMV) {
                        clear.clear();
                    }
                    this.zzMV.clear();
                    if (this.zzMx != null || this.zzMw.isEmpty()) {
                        this.zzML.clear();
                    } else {
                        this.zzMC = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.zzMz = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.zzMx = null;
                    }
                    this.zzMt.signalAll();
                }
                this.zzMN = false;
                for (com.google.android.gms.common.api.Api.zza disconnect : this.zzMJ.values()) {
                    disconnect.disconnect();
                }
                zzM(i == -1);
                this.zzMN = true;
                this.zzMz = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.zzMu.zzaJ(i);
                    }
                    this.zzMN = false;
                }
            }
            this.zzCN.unlock();
        } finally {
            this.zzCN.unlock();
        }
    }

    private void zzb(final ConnectionResult connectionResult) {
        this.zzMG.post(new Runnable(this) {
            final /* synthetic */ zzd zzNb;

            public void run() {
                this.zzNb.zzCN.lock();
                try {
                    if (this.zzNb.zzc(connectionResult)) {
                        this.zzNb.zzMN = false;
                        for (com.google.android.gms.common.api.Api.zzc zzc : this.zzNb.zzMK) {
                            com.google.android.gms.common.api.Api.zza zza = (com.google.android.gms.common.api.Api.zza) this.zzNb.zzMJ.get(zzc);
                            if (zza.isConnected()) {
                                zza.disconnect();
                            }
                            if (!this.zzNb.zzML.containsKey(zzc)) {
                                this.zzNb.zzML.put(zzc, new ConnectionResult(17, null));
                            }
                        }
                        this.zzNb.zzMN = true;
                        this.zzNb.zzij();
                    } else {
                        this.zzNb.zza(connectionResult);
                    }
                    this.zzNb.zzCN.unlock();
                } catch (Throwable th) {
                    this.zzNb.zzCN.unlock();
                }
            }
        });
    }

    private boolean zzc(ConnectionResult connectionResult) {
        return this.zzMP != 2 ? this.zzMP == 1 && !connectionResult.hasResolution() : true;
    }

    private void zzd(ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            this.zzMG.post(new C01112(this));
        } else {
            zzb(connectionResult);
        }
    }

    private void zzie() {
        this.zzMD--;
        if (this.zzMD != 0) {
            return;
        }
        if (this.zzMx != null) {
            zza(this.zzMx);
            return;
        }
        switch (this.zzMB) {
            case 0:
                if (this.zzMQ) {
                    this.zzMB = 1;
                    zzii();
                    return;
                }
                zzij();
                return;
            case 1:
                zzih();
                return;
            case 2:
                this.zzMz = 2;
                zzim();
                if (this.zzMO != null) {
                    if (this.zzMT) {
                        this.zzMO.zza(this.zzMS, this.zzMU);
                    }
                    zzM(false);
                }
                this.zzMt.signalAll();
                zzik();
                if (this.zzMC) {
                    this.zzMC = false;
                    zzao(-1);
                    return;
                }
                this.zzMu.zzj(this.zzMI.isEmpty() ? null : this.zzMI);
                return;
            default:
                return;
        }
    }

    private void zzif() {
        this.zzMO.zza(new zzb(this));
    }

    private Set<Scope> zzig() {
        return new HashSet(Arrays.asList(zzmh.zzi(this.zzMM)));
    }

    private void zzih() {
        this.zzMO.zza(this.zzMS, zzig(), new zza(this));
    }

    private void zzii() {
        zzx.zza(getLooper() == this.zzMG.getLooper(), (Object) "This method must be run on the mHandlerForCallbacks thread");
        if (this.zzMB == 1 && this.zzMR) {
            this.zzMD = this.zzMJ.size();
            Iterator it = this.zzMJ.keySet().iterator();
            while (it.hasNext()) {
                com.google.android.gms.common.api.Api.zzc zzc = (com.google.android.gms.common.api.Api.zzc) it.next();
                if (this.zzML.containsKey(zzc)) {
                    this.zzCN.lock();
                    try {
                        zzie();
                    } finally {
                        it = this.zzCN;
                        it.unlock();
                    }
                } else {
                    ((com.google.android.gms.common.api.Api.zza) this.zzMJ.get(zzc)).zza(this.zzMS);
                }
            }
        }
    }

    private void zzij() {
        this.zzMB = 2;
        this.zzMD = this.zzMJ.size();
        for (com.google.android.gms.common.api.Api.zzc zzc : this.zzMJ.keySet()) {
            if (this.zzML.containsKey(zzc)) {
                zzie();
            } else {
                ((com.google.android.gms.common.api.Api.zza) this.zzMJ.get(zzc)).zzb(this.zzMS);
            }
        }
    }

    private void zzik() {
        this.zzCN.lock();
        try {
            boolean z = isConnected() || zzil();
            zzx.zza(z, (Object) "GoogleApiClient is not connected yet.");
            while (!this.zzMw.isEmpty()) {
                zza((zzg) this.zzMw.remove());
            }
            this.zzCN.unlock();
        } catch (Throwable e) {
            Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
        } catch (Throwable th) {
            this.zzCN.unlock();
        }
    }

    private void zzim() {
        this.zzCN.lock();
        try {
            if (this.zzMA) {
                this.zzMA = false;
                this.zzMG.removeMessages(2);
                this.zzMG.removeMessages(1);
                if (this.zzMH != null) {
                    this.mContext.getApplicationContext().unregisterReceiver(this.zzMH);
                    this.zzMH = null;
                }
                this.zzCN.unlock();
            }
        } finally {
            this.zzCN.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzCN.lock();
        try {
            connect();
            while (isConnecting()) {
                this.zzMt.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.zzLr;
            } else if (this.zzMx != null) {
                connectionResult = this.zzMx;
                this.zzCN.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zzCN.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zzCN.unlock();
        }
        return connectionResult;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzCN.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.zzMt.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.zzLr;
                this.zzCN.unlock();
            } else if (this.zzMx != null) {
                connectionResult = this.zzMx;
                this.zzCN.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zzCN.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zzCN.unlock();
        }
        return connectionResult;
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzx.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        final zzg zzg = new zzg(this.zzMc);
        if (this.zzMJ.containsKey(zzko.zzGR)) {
            zza((GoogleApiClient) this, zzg, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            ConnectionCallbacks c03023 = new ConnectionCallbacks(this) {
                final /* synthetic */ zzd zzNb;

                public void onConnected(Bundle connectionHint) {
                    this.zzNb.zza((GoogleApiClient) atomicReference.get(), zzg, true);
                }

                public void onConnectionSuspended(int cause) {
                }
            };
            GoogleApiClient build = new Builder(this.mContext).addApi(zzko.API).addConnectionCallbacks(c03023).addOnConnectionFailedListener(new OnConnectionFailedListener(this) {
                final /* synthetic */ zzd zzNb;

                public void onConnectionFailed(ConnectionResult result) {
                    zzg.setResult(new Status(8));
                }
            }).setHandler(this.zzMG).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzg;
    }

    public void connect() {
        this.zzCN.lock();
        try {
            this.zzMC = false;
            if (isConnected() || isConnecting()) {
                this.zzCN.unlock();
                return;
            }
            this.zzMN = true;
            this.zzMx = null;
            this.zzMz = 1;
            this.zzMB = 0;
            this.zzMI.clear();
            this.zzMD = this.zzMJ.size();
            this.zzML.clear();
            this.zzMR = false;
            this.zzMT = false;
            this.zzMU = false;
            if (this.zzMQ) {
                this.zzMO.connect();
            }
            for (com.google.android.gms.common.api.Api.zza connect : this.zzMJ.values()) {
                connect.connect();
            }
            this.zzCN.unlock();
        } catch (Throwable th) {
            this.zzCN.unlock();
        }
    }

    public void disconnect() {
        zzim();
        zzao(-1);
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).println("GoogleApiClient:");
        Object obj = prefix + "  ";
        writer.append(obj).append("mConnectionState=");
        switch (this.zzMz) {
            case 1:
                writer.print("CONNECTING");
                break;
            case 2:
                writer.print("CONNECTED");
                break;
            case 3:
                writer.print("DISCONNECTING");
                break;
            case 4:
                writer.print("DISCONNECTED");
                break;
            default:
                writer.print("UNKNOWN");
                break;
        }
        writer.append(" mResuming=").print(this.zzMA);
        writer.append(" mWaitingToDisconnect=").println(this.zzMC);
        writer.append(obj).append("mWorkQueue.size()=").print(this.zzMw.size());
        writer.append(" mUnconsumedRunners.size()=").println(this.zzMW.size());
        for (com.google.android.gms.common.api.Api.zza dump : this.zzMJ.values()) {
            dump.dump(obj, fd, writer, args);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzMc;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean isConnected() {
        return this.zzMz == 2;
    }

    public boolean isConnecting() {
        return this.zzMz == 1;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.zzMu.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.zzMu.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzMu.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzMu.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(FragmentActivity lifecycleActivity) {
        zzx.zza(this.zzMv >= 0, (Object) "Called stopAutoManage but automatic lifecycle management is not enabled.");
        zzh.zza(lifecycleActivity).zzas(this.zzMv);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzMu.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzMu.unregisterConnectionFailedListener(listener);
    }

    public <C extends com.google.android.gms.common.api.Api.zza> C zza(com.google.android.gms.common.api.Api.zzc<C> zzc) {
        Object obj = (com.google.android.gms.common.api.Api.zza) this.zzMJ.get(zzc);
        zzx.zzb(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends com.google.android.gms.common.api.Api.zza, R extends Result, T extends com.google.android.gms.common.api.zza.zza<R, A>> T zza(T t) {
        zzx.zzb(this.zzMJ.containsKey(t.zzhV()), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        this.zzCN.lock();
        try {
            if (isConnected()) {
                zzb((com.google.android.gms.common.api.zza.zza) t);
            } else {
                this.zzMw.add(t);
            }
            this.zzCN.unlock();
            return t;
        } catch (Throwable th) {
            this.zzCN.unlock();
        }
    }

    public boolean zza(Api<?> api) {
        return this.zzMJ.containsKey(api.zzhV());
    }

    public boolean zza(Scope scope) {
        return this.zzMM.contains(scope.zzio());
    }

    public <A extends com.google.android.gms.common.api.Api.zza, T extends com.google.android.gms.common.api.zza.zza<? extends Result, A>> T zzb(T t) {
        boolean z = isConnected() || zzil();
        zzx.zza(z, (Object) "GoogleApiClient is not connected yet.");
        zzik();
        try {
            zza((zzg) t);
        } catch (DeadObjectException e) {
            zzao(1);
        }
        return t;
    }

    public boolean zzb(Api<?> api) {
        com.google.android.gms.common.api.Api.zza zza = (com.google.android.gms.common.api.Api.zza) this.zzMJ.get(api.zzhV());
        return zza == null ? false : zza.isConnected();
    }

    public <L> zze<L> zzf(L l) {
        zzx.zzb((Object) l, (Object) "Listener must not be null");
        this.zzCN.lock();
        try {
            zze<L> zze = new zze(this.zzMc, l);
            this.zzMV.add(zze);
            return zze;
        } finally {
            this.zzCN.unlock();
        }
    }

    boolean zzil() {
        return this.zzMA;
    }
}
