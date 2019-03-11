package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    /* renamed from: com.google.android.gms.tagmanager.PreviewActivity$1 */
    class C02461 implements OnClickListener {
        final /* synthetic */ PreviewActivity zzazw;

        C02461(PreviewActivity previewActivity) {
            this.zzazw = previewActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    private void zzg(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C02461(this));
        create.show();
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            zzbf.zzaa("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).zzl(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                zzbf.zzac(str);
                zzg("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                zzbf.zzaa("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            zzbf.zzaa("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            zzbf.zzZ("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
