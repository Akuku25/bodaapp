package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

@zzgi
public class zzei {
    public boolean zza(Context context, zzek zzek, zzes zzes) {
        if (zzek == null) {
            zzhx.zzac("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzek.zztR)) {
            zzhx.zzac("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(zzek.mimeType)) {
            intent.setData(Uri.parse(zzek.zztR));
        } else {
            intent.setDataAndType(Uri.parse(zzek.zztR), zzek.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzek.packageName)) {
            intent.setPackage(zzek.packageName);
        }
        if (!TextUtils.isEmpty(zzek.zztS)) {
            String[] split = zzek.zztS.split("/", 2);
            if (split.length < 2) {
                zzhx.zzac("Could not parse component name from open GMSG: " + zzek.zztS);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        Object obj = zzek.zztT;
        if (!TextUtils.isEmpty(obj)) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(obj);
            } catch (NumberFormatException e) {
                zzhx.zzac("Could not parse intent flags.");
                parseInt = 0;
            }
            intent.addFlags(parseInt);
        }
        try {
            zzhx.zzab("Launching an intent: " + intent.toURI());
            context.startActivity(intent);
            if (zzes != null) {
                zzes.zzae();
            }
            return true;
        } catch (ActivityNotFoundException e2) {
            zzhx.zzac(e2.getMessage());
            return false;
        }
    }
}
