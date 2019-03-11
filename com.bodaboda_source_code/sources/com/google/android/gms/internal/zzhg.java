package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@zzgi
public class zzhg {
    private Context mContext;
    private zzae zzlG;
    private boolean zzmE = false;
    private final Object zznh = new Object();
    private zzhy zznl;
    private zzam zzol = null;
    private zzal zzom = null;
    private final zzgh zzon = null;
    private boolean zzxO = true;
    private boolean zzxP = true;
    private final String zzyL;
    private final zzhh zzyM;
    private BigInteger zzyN = BigInteger.ONE;
    private final HashSet<zzhf> zzyO = new HashSet();
    private final HashMap<String, zzhj> zzyP = new HashMap();
    private boolean zzyQ = false;
    private int zzyR = 0;
    private zzcc zzyS = null;
    private zzan zzyT = null;
    private final LinkedList<Thread> zzyU = new LinkedList();
    private Boolean zzyV = null;
    private String zzyW;

    /* renamed from: com.google.android.gms.internal.zzhg$2 */
    class C01962 implements Runnable {
        final /* synthetic */ zzhg zzyY;

        C01962(zzhg zzhg) {
            this.zzyY = zzhg;
        }

        public void run() {
            zzcb zzcb = new zzcb();
            zzcb.zzb(this.zzyY.mContext, this.zzyY.zznl.zzzH);
            try {
                this.zzyY.zzyS = zzab.zzaR().zza(zzcb);
            } catch (IllegalArgumentException e) {
                zzhx.zzac("Cannot initialize CSI reporter." + e.getMessage());
            }
        }
    }

    public zzhg(zzho zzho) {
        this.zzyL = zzho.zzeu();
        this.zzyM = new zzhh(this.zzyL);
    }

    public String getSessionId() {
        return this.zzyL;
    }

    public Bundle zza(Context context, zzhi zzhi, String str) {
        Bundle bundle;
        synchronized (this.zznh) {
            bundle = new Bundle();
            bundle.putBundle("app", this.zzyM.zzc(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.zzyP.keySet()) {
                bundle2.putBundle(str2, ((zzhj) this.zzyP.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzyO.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzhf) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzhi.zza(this.zzyO);
            this.zzyO.clear();
        }
        return bundle;
    }

    public void zza(Context context, boolean z) {
        synchronized (this.zznh) {
            if (z != this.zzxO) {
                this.zzxO = z;
                zzhm.zza(context, z);
            }
        }
    }

    public void zza(zzhf zzhf) {
        synchronized (this.zznh) {
            this.zzyO.add(zzhf);
        }
    }

    public void zza(String str, zzhj zzhj) {
        synchronized (this.zznh) {
            this.zzyP.put(str, zzhj);
        }
    }

    public void zza(final Thread thread) {
        zzca.zza(new Runnable(this) {
            final /* synthetic */ zzhg zzyY;

            public void run() {
                zzgh.zza(this.zzyY.mContext, thread, this.zzyY.zznl);
            }
        });
    }

    public void zzb(Context context, zzhy zzhy) {
        synchronized (this.zznh) {
            if (!this.zzmE) {
                this.mContext = context.getApplicationContext();
                this.zznl = zzhy;
                this.zzxO = zzhm.zzr(context);
                this.zzyR = zzhm.zzs(context);
                zza(Thread.currentThread());
                this.zzyW = zzab.zzaM().zze(context, zzhy.zzzH);
                this.zzlG = new zzae(context.getApplicationContext(), this.zznl, new zzdf(context.getApplicationContext(), this.zznl, (String) zzca.zzql.get()));
                zzen();
                this.zzmE = true;
            }
        }
    }

    public void zzb(Boolean bool) {
        synchronized (this.zznh) {
            this.zzyV = bool;
        }
    }

    public void zzb(HashSet<zzhf> hashSet) {
        synchronized (this.zznh) {
            this.zzyO.addAll(hashSet);
        }
    }

    public String zzc(int i, String str) {
        Resources resources = this.zznl.zzzK ? this.mContext.getResources() : GooglePlayServicesUtil.getRemoteResource(this.mContext);
        return resources == null ? str : resources.getString(i);
    }

    public void zze(Throwable th) {
        new zzgh(this.mContext, this.zznl, null, null).zzb(th);
    }

    public boolean zzed() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzxP;
        }
        return z;
    }

    public String zzee() {
        String bigInteger;
        synchronized (this.zznh) {
            bigInteger = this.zzyN.toString();
            this.zzyN = this.zzyN.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public zzhh zzef() {
        zzhh zzhh;
        synchronized (this.zznh) {
            zzhh = this.zzyM;
        }
        return zzhh;
    }

    public zzcc zzeg() {
        zzcc zzcc;
        synchronized (this.zznh) {
            zzcc = this.zzyS;
        }
        return zzcc;
    }

    public boolean zzeh() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzyQ;
            this.zzyQ = true;
        }
        return z;
    }

    public boolean zzei() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzxO;
        }
        return z;
    }

    public String zzej() {
        String str;
        synchronized (this.zznh) {
            str = this.zzyW;
        }
        return str;
    }

    public Boolean zzek() {
        Boolean bool;
        synchronized (this.zznh) {
            bool = this.zzyV;
        }
        return bool;
    }

    public zzae zzel() {
        return this.zzlG;
    }

    public boolean zzem() {
        boolean z;
        synchronized (this.zznh) {
            if (this.zzyR < ((Integer) zzca.zzqN.get()).intValue()) {
                this.zzyR = ((Integer) zzca.zzqN.get()).intValue();
                zzhm.zza(this.mContext, this.zzyR);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    void zzen() {
        zzca.zza(new C01962(this));
    }

    public zzan zzo(Context context) {
        if (!((Boolean) zzca.zzqB.get()).booleanValue() || !zzme.zzkg() || zzed()) {
            return null;
        }
        synchronized (this.zznh) {
            if (this.zzol == null) {
                if (context instanceof Activity) {
                    this.zzol = new zzam((Application) context.getApplicationContext(), (Activity) context);
                } else {
                    return null;
                }
            }
            if (this.zzom == null) {
                this.zzom = new zzal();
            }
            if (this.zzyT == null) {
                this.zzyT = new zzan(this.zzol, this.zzom, new zzgh(this.mContext, this.zznl, null, null));
            }
            this.zzyT.zzbt();
            zzan zzan = this.zzyT;
            return zzan;
        }
    }

    public void zzz(boolean z) {
        synchronized (this.zznh) {
            this.zzxP = z;
        }
    }
}
