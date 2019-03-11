package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchase;

@zzgi
public class zzfw implements InAppPurchase {
    private final zzfn zzvi;

    public zzfw(zzfn zzfn) {
        this.zzvi = zzfn;
    }

    public String getProductId() {
        try {
            return this.zzvi.getProductId();
        } catch (Throwable e) {
            zzhx.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        try {
            this.zzvi.recordPlayBillingResolution(billingResponseCode);
        } catch (Throwable e) {
            zzhx.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int resolution) {
        try {
            this.zzvi.recordResolution(resolution);
        } catch (Throwable e) {
            zzhx.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
