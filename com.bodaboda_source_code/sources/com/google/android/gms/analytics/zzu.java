package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class zzu extends BroadcastReceiver {
    static final String zzBO = zzu.class.getName();
    private final zzaj zzBP;

    zzu(zzaj zzaj) {
        this.zzBP = zzaj;
    }

    public void onReceive(Context ctx, Intent intent) {
        boolean z = false;
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            zzaj zzaj = this.zzBP;
            if (!booleanExtra) {
                z = true;
            }
            zzaj.zzE(z);
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(zzBO)) {
            this.zzBP.zzfJ();
        }
    }

    public void zzD(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter);
    }
}
