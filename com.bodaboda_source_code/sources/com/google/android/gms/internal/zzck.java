package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzcj.zza;

@zzgi
public final class zzck extends zza {
    private final OnCustomRenderedAdLoadedListener zzpL;

    public zzck(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzpL = onCustomRenderedAdLoadedListener;
    }

    public void zza(zzci zzci) {
        this.zzpL.onCustomRenderedAdLoaded(new zzch(zzci));
    }
}
