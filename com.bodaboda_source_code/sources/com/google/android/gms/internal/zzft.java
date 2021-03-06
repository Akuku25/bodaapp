package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzfo.zza;

@zzgi
public final class zzft extends zza {
    private final InAppPurchaseListener zzpJ;

    public zzft(InAppPurchaseListener inAppPurchaseListener) {
        this.zzpJ = inAppPurchaseListener;
    }

    public void zza(zzfn zzfn) {
        this.zzpJ.onInAppPurchaseRequested(new zzfw(zzfn));
    }
}
