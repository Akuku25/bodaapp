package com.google.android.gms.internal;

import android.text.TextUtils;

public class zzcd {
    private boolean zzqO = false;

    private zzcc zzb(zzcb zzcb, int i) {
        zzcc zzcc = new zzcc(zzcb.getContext(), zzcb.zzaX(), zzcb.zzce(), zzcb.zzcf(), zzcb.zzcg(), zzcb.zzch(), zzcb.zzci(), zzcb.zzcj(), i);
        this.zzqO = true;
        return zzcc;
    }

    public zzcc zza(zzcb zzcb) {
        return zza(zzcb, 1);
    }

    public zzcc zza(zzcb zzcb, int i) {
        if (zzcb == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!zzcb.zzcd()) {
            zzhx.zzaa("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (zzcb.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzcb.zzaX())) {
            return zzb(zzcb, i);
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }

    public zzcc zzb(zzcb zzcb) {
        return zza(zzcb, 2);
    }

    public boolean zzcd() {
        return this.zzqO;
    }
}
