package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzhx;

public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzev zzlf;

    private void zzX() {
        if (this.zzlf != null) {
            try {
                this.zzlf.zzX();
            } catch (Throwable e) {
                zzhx.zzd("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzlf = zzeu.zzb(this);
        if (this.zzlf == null) {
            zzhx.zzac("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.zzlf.onCreate(savedInstanceState);
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.zzlf != null) {
                this.zzlf.onDestroy();
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.zzlf != null) {
                this.zzlf.onPause();
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.zzlf != null) {
                this.zzlf.onRestart();
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.zzlf != null) {
                this.zzlf.onResume();
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        try {
            if (this.zzlf != null) {
                this.zzlf.onSaveInstanceState(outState);
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(outState);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.zzlf != null) {
                this.zzlf.onStart();
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.zzlf != null) {
                this.zzlf.onStop();
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        zzX();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        zzX();
    }

    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        zzX();
    }
}
