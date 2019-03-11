package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzfs.zza;

@zzgi
public final class zzfx extends zza {
    private final PlayStorePurchaseListener zzpK;

    public zzfx(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzpK = playStorePurchaseListener;
    }

    public boolean isValidPurchase(String productId) {
        return this.zzpK.isValidPurchase(productId);
    }

    public void zza(zzfr zzfr) {
        this.zzpK.onInAppPurchaseFinished(new zzfv(zzfr));
    }
}
