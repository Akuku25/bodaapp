package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

class zzy implements zzaq {
    private static final Object zzaxj = new Object();
    private static zzy zzayy;
    private zzcc zzaxM;
    private String zzayA;
    private zzar zzayB;
    private String zzayz;

    private zzy(Context context) {
        this(zzas.zzam(context), new zzcr());
    }

    zzy(zzar zzar, zzcc zzcc) {
        this.zzayB = zzar;
        this.zzaxM = zzcc;
    }

    public static zzaq zzak(Context context) {
        zzaq zzaq;
        synchronized (zzaxj) {
            if (zzayy == null) {
                zzayy = new zzy(context);
            }
            zzaq = zzayy;
        }
        return zzaq;
    }

    public boolean zzcY(String str) {
        if (this.zzaxM.zzgv()) {
            if (!(this.zzayz == null || this.zzayA == null)) {
                try {
                    str = this.zzayz + "?" + this.zzayA + "=" + URLEncoder.encode(str, "UTF-8");
                    zzbf.zzab("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    zzbf.zzd("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.zzayB.zzdb(str);
            return true;
        }
        zzbf.zzac("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
