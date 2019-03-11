package com.google.android.gms.internal;

import android.os.Binder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@zzgi
public class zzby {
    Collection<zzbw> zzqf = new ArrayList();
    Collection<zzbx<String>> zzqg = new ArrayList();

    public void zza(zzbw zzbw) {
        this.zzqf.add(zzbw);
    }

    public void zza(zzbx<String> zzbx) {
        this.zzqg.add(zzbx);
    }

    public List<String> zzca() {
        List<String> arrayList = new ArrayList();
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            for (zzbx zzbZ : this.zzqg) {
                String str = (String) zzbZ.zzbZ().get();
                if (str != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public List<String> zzcb() {
        List<String> arrayList = new ArrayList();
        for (zzbx zzbx : this.zzqg) {
            String str = (String) zzbx.get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
