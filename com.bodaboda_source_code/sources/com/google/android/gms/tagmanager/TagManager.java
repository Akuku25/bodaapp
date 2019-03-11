package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zzaAS;
    private final Context mContext;
    private final zza zzaAP;
    private final zzcs zzaAQ;
    private final ConcurrentMap<zzn, Boolean> zzaAR;
    private final DataLayer zzaxx;
    private final zzr zzazO;

    /* renamed from: com.google.android.gms.tagmanager.TagManager$3 */
    class C02473 implements ComponentCallbacks2 {
        final /* synthetic */ TagManager zzaAT;

        C02473(TagManager tagManager) {
            this.zzaAT = tagManager;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.zzaAT.dispatch();
            }
        }
    }

    public interface zza {
        zzo zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzr zzr);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager$1 */
    class C03931 implements zzb {
        final /* synthetic */ TagManager zzaAT;

        C03931(TagManager tagManager) {
            this.zzaAT = tagManager;
        }

        public void zzI(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.zzaAT.zzdk(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager$2 */
    static class C03942 implements zza {
        C03942() {
        }

        public zzo zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzr zzr) {
            return new zzo(context, tagManager, looper, str, i, zzr);
        }
    }

    TagManager(Context context, zza containerHolderLoaderProvider, DataLayer dataLayer, zzcs serviceManager) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzaAQ = serviceManager;
        this.zzaAP = containerHolderLoaderProvider;
        this.zzaAR = new ConcurrentHashMap();
        this.zzaxx = dataLayer;
        this.zzaxx.zza(new C03931(this));
        this.zzaxx.zza(new zzd(this.mContext));
        this.zzazO = new zzr();
        zztT();
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzaAS == null) {
                if (context == null) {
                    zzbf.zzZ("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzaAS = new TagManager(context, new C03942(), new DataLayer(new zzv(context)), zzct.zztR());
            }
            tagManager = zzaAS;
        }
        return tagManager;
    }

    private void zzdk(String str) {
        for (zzn zzcO : this.zzaAR.keySet()) {
            zzcO.zzcO(str);
        }
    }

    private void zztT() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new C02473(this));
        }
    }

    public void dispatch() {
        this.zzaAQ.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzaxx;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzazO);
        zza.zzsN();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzazO);
        zza.zzsN();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzazO);
        zza.zzsP();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzazO);
        zza.zzsP();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzazO);
        zza.zzsO();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzazO);
        zza.zzsO();
        return zza;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        zzbf.setLogLevel(enableVerboseLogging ? 2 : 5);
    }

    void zza(zzn zzn) {
        this.zzaAR.put(zzn, Boolean.valueOf(true));
    }

    boolean zzb(zzn zzn) {
        return this.zzaAR.remove(zzn) != null;
    }

    public PendingResult<ContainerHolder> zzc(String str, int i, String str2) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, null, str, i, this.zzazO);
        zza.load(str2);
        return zza;
    }

    synchronized boolean zzl(Uri uri) {
        boolean z;
        zzca zztx = zzca.zztx();
        if (zztx.zzl(uri)) {
            String containerId = zztx.getContainerId();
            switch (zztx.zzty()) {
                case NONE:
                    for (zzn zzn : this.zzaAR.keySet()) {
                        if (zzn.getContainerId().equals(containerId)) {
                            zzn.zzcQ(null);
                            zzn.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (zzn zzn2 : this.zzaAR.keySet()) {
                        if (zzn2.getContainerId().equals(containerId)) {
                            zzn2.zzcQ(zztx.zztz());
                            zzn2.refresh();
                        } else if (zzn2.zzsK() != null) {
                            zzn2.zzcQ(null);
                            zzn2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
