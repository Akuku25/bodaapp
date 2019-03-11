package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;

public class zzre {
    private static final zza[] zzash = new zza[0];
    private static zzre zzasi;
    private final Application zzasj;
    private zzrh zzask;
    private final List<zza> zzasl = new ArrayList();
    private zzri zzasm;

    public interface zza {
        void zza(zzrh zzrh);

        void zza(zzrh zzrh, Activity activity);
    }

    private zzre(Application application) {
        zzx.zzl(application);
        this.zzasj = application;
    }

    public static zzre zzag(Context context) {
        zzre zzre;
        zzx.zzl(context);
        Application application = (Application) context.getApplicationContext();
        zzx.zzl(application);
        synchronized (zzre.class) {
            if (zzasi == null) {
                zzasi = new zzre(application);
            }
            zzre = zzasi;
        }
        return zzre;
    }

    private zza[] zzqZ() {
        zza[] zzaArr;
        synchronized (this.zzasl) {
            if (this.zzasl.isEmpty()) {
                zzaArr = zzash;
            } else {
                zzaArr = (zza[]) this.zzasl.toArray(new zza[this.zzasl.size()]);
            }
        }
        return zzaArr;
    }

    public void zzZ(boolean z) {
        if (VERSION.SDK_INT < 14) {
            Log.i("com.google.android.gms.measurement.ScreenViewService", "AutoScreeViewTracking is not supported on API 14 or earlier devices");
        } else if (zzqY() == z) {
        } else {
            if (z) {
                this.zzasm = new zzri(this);
                this.zzasj.registerActivityLifecycleCallbacks(this.zzasm);
                return;
            }
            this.zzasj.unregisterActivityLifecycleCallbacks(this.zzasm);
            this.zzasm = null;
        }
    }

    public void zza(zza zza) {
        zzx.zzl(zza);
        synchronized (this.zzasl) {
            this.zzasl.remove(zza);
            this.zzasl.add(zza);
        }
    }

    public void zzb(zzrh zzrh, Activity activity) {
        int i = 0;
        zzx.zzl(zzrh);
        zza[] zzaArr = null;
        if (zzrh.isMutable()) {
            if (activity instanceof zzrd) {
                ((zzrd) activity).zzb(zzrh);
            }
            if (this.zzask != null) {
                zzrh.zzgr(this.zzask.zzaF());
                zzrh.zzcv(this.zzask.zzre());
            }
            zza[] zzqZ = zzqZ();
            for (zza zza : zzqZ) {
                zza.zza(zzrh, activity);
            }
            zzrh.zzrh();
            if (!TextUtils.isEmpty(zzrh.zzre())) {
                zzaArr = zzqZ;
            } else {
                return;
            }
        }
        if (this.zzask == null || this.zzask.zzaF() != zzrh.zzaF()) {
            zzqX();
            this.zzask = zzrh;
            if (zzaArr == null) {
                zzaArr = zzqZ();
            }
            while (i < zzaArr.length) {
                zzaArr[i].zza(zzrh);
                i++;
            }
            return;
        }
        this.zzask = zzrh;
    }

    public zzrh zzqW() {
        return this.zzask;
    }

    public void zzqX() {
        this.zzask = null;
    }

    public boolean zzqY() {
        return this.zzasm != null;
    }
}
