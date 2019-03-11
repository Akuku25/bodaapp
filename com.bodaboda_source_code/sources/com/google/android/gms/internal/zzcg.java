package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzci.zza;

@zzgi
public final class zzcg extends zza {
    private final zzv zzrg;
    private final String zzrh;
    private final String zzri;

    public zzcg(zzv zzv, String str, String str2) {
        this.zzrg = zzv;
        this.zzrh = str;
        this.zzri = str2;
    }

    public String getContent() {
        return this.zzri;
    }

    public void recordClick() {
        this.zzrg.recordClick();
    }

    public void recordImpression() {
        this.zzrg.recordImpression();
    }

    public void zza(zzd zzd) {
        if (zzd != null) {
            this.zzrg.zzb((View) zze.zzf(zzd));
        }
    }

    public String zzcv() {
        return this.zzrh;
    }
}
