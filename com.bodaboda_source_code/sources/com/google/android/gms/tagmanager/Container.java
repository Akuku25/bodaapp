package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzc.zzf;
import com.google.android.gms.internal.zzc.zzi;
import com.google.android.gms.internal.zzc.zzj;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzvl.zzc;
import com.google.android.gms.internal.zzvl.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final Context mContext;
    private Map<String, FunctionCallTagCallback> zzaxA = new HashMap();
    private volatile long zzaxB;
    private volatile String zzaxC = "";
    private final String zzaxw;
    private final DataLayer zzaxx;
    private zzco zzaxy;
    private Map<String, FunctionCallMacroCallback> zzaxz = new HashMap();

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class zza implements com.google.android.gms.tagmanager.zzs.zza {
        final /* synthetic */ Container zzaxD;

        private zza(Container container) {
            this.zzaxD = container;
        }

        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzcM = this.zzaxD.zzcM(str);
            return zzcM == null ? null : zzcM.getValue(str, map);
        }
    }

    private class zzb implements com.google.android.gms.tagmanager.zzs.zza {
        final /* synthetic */ Container zzaxD;

        private zzb(Container container) {
            this.zzaxD = container;
        }

        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzcN = this.zzaxD.zzcN(str);
            if (zzcN != null) {
                zzcN.execute(str, map);
            }
            return zzde.zzue();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, zzj resource) {
        this.mContext = context;
        this.zzaxx = dataLayer;
        this.zzaxw = containerId;
        this.zzaxB = lastRefreshTime;
        zza(resource.zzgs);
        if (resource.zzgr != null) {
            zza(resource.zzgr);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, zzc resource) {
        this.mContext = context;
        this.zzaxx = dataLayer;
        this.zzaxw = containerId;
        this.zzaxB = lastRefreshTime;
        zza(resource);
    }

    private void zza(zzf zzf) {
        if (zzf == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzvl.zzb(zzf));
        } catch (zzg e) {
            zzbf.zzZ("Not loading resource: " + zzf + " because it is invalid: " + e.toString());
        }
    }

    private void zza(zzc zzc) {
        this.zzaxC = zzc.getVersion();
        zzc zzc2 = zzc;
        zza(new zzco(this.mContext, zzc2, this.zzaxx, new zza(), new zzb(), zzcP(this.zzaxC)));
    }

    private synchronized void zza(zzco zzco) {
        this.zzaxy = zzco;
    }

    private void zza(zzi[] zziArr) {
        List arrayList = new ArrayList();
        for (Object add : zziArr) {
            arrayList.add(add);
        }
        zzsJ().zzu(arrayList);
    }

    private synchronized zzco zzsJ() {
        return this.zzaxy;
    }

    public boolean getBoolean(String key) {
        zzco zzsJ = zzsJ();
        if (zzsJ == null) {
            zzbf.zzZ("getBoolean called for closed container.");
            return zzde.zzuc().booleanValue();
        }
        try {
            return zzde.zzk((com.google.android.gms.internal.zzd.zza) zzsJ.zzdi(key).getObject()).booleanValue();
        } catch (Exception e) {
            zzbf.zzZ("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzde.zzuc().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzaxw;
    }

    public double getDouble(String key) {
        zzco zzsJ = zzsJ();
        if (zzsJ == null) {
            zzbf.zzZ("getDouble called for closed container.");
            return zzde.zzub().doubleValue();
        }
        try {
            return zzde.zzj((com.google.android.gms.internal.zzd.zza) zzsJ.zzdi(key).getObject()).doubleValue();
        } catch (Exception e) {
            zzbf.zzZ("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzde.zzub().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzaxB;
    }

    public long getLong(String key) {
        zzco zzsJ = zzsJ();
        if (zzsJ == null) {
            zzbf.zzZ("getLong called for closed container.");
            return zzde.zzua().longValue();
        }
        try {
            return zzde.zzi((com.google.android.gms.internal.zzd.zza) zzsJ.zzdi(key).getObject()).longValue();
        } catch (Exception e) {
            zzbf.zzZ("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzde.zzua().longValue();
        }
    }

    public String getString(String key) {
        zzco zzsJ = zzsJ();
        if (zzsJ == null) {
            zzbf.zzZ("getString called for closed container.");
            return zzde.zzue();
        }
        try {
            return zzde.zzg((com.google.android.gms.internal.zzd.zza) zzsJ.zzdi(key).getObject());
        } catch (Exception e) {
            zzbf.zzZ("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzde.zzue();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzaxz) {
            this.zzaxz.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzaxA) {
            this.zzaxA.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.zzaxy = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.zzaxz) {
            this.zzaxz.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.zzaxA) {
            this.zzaxA.remove(customTagName);
        }
    }

    FunctionCallMacroCallback zzcM(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzaxz) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zzaxz.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback zzcN(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzaxA) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzaxA.get(str);
        }
        return functionCallTagCallback;
    }

    void zzcO(String str) {
        zzsJ().zzcO(str);
    }

    zzag zzcP(String str) {
        if (zzca.zztx().zzty().equals(zza.CONTAINER_DEBUG)) {
        }
        return new zzbn();
    }

    String zzsI() {
        return this.zzaxC;
    }
}
