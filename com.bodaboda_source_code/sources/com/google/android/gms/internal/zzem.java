package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.drive.DriveFile;

public class zzem {
    public void zza(Context context, zzeo zzeo) {
        zza(context, zzeo, true);
    }

    public void zza(Context context, zzeo zzeo, boolean z) {
        if (zzeo.zzuw == 4 && zzeo.zzup == null) {
            if (zzeo.zzuo != null) {
                zzeo.zzuo.onAdClicked();
            }
            zzab.zzaJ().zza(context, zzeo.zzun, zzeo.zzuv);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", zzeo.zzlP.zzzK);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        zzeo.zza(intent, zzeo);
        if (!zzme.zzkk()) {
            intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }
}
