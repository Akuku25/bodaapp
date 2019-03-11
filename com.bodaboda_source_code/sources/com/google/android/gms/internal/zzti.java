package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zztd.zza;

public class zzti implements ConnectionCallbacks, OnConnectionFailedListener {
    private zztl zzatK = null;
    private final zza zzatU;
    private boolean zzatV = true;

    public zzti(zza zza) {
        this.zzatU = zza;
    }

    public void onConnected(Bundle connectionHint) {
        this.zzatK.zzae(false);
        if (this.zzatV && this.zzatU != null) {
            this.zzatU.zzrE();
        }
        this.zzatV = false;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.zzatK.zzae(true);
        if (this.zzatV && this.zzatU != null) {
            if (result.hasResolution()) {
                this.zzatU.zzf(result.getResolution());
            } else {
                this.zzatU.zzrF();
            }
        }
        this.zzatV = false;
    }

    public void onConnectionSuspended(int cause) {
        this.zzatK.zzae(true);
    }

    public void zza(zztl zztl) {
        this.zzatK = zztl;
    }

    public void zzad(boolean z) {
        this.zzatV = z;
    }
}
