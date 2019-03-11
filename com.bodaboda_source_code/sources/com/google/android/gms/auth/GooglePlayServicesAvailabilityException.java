package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zzHm;

    GooglePlayServicesAvailabilityException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.zzHm = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.zzHm;
    }
}
