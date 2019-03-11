package com.google.android.gms.analytics;

import android.util.Log;

class zzp implements Logger {
    private int zzBJ = 2;

    zzp() {
    }

    private String zzal(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public void error(Exception exception) {
        if (this.zzBJ <= 3) {
            Log.e("GAV4", null, exception);
        }
    }

    public void error(String msg) {
        if (this.zzBJ <= 3) {
            Log.e("GAV4", zzal(msg));
        }
    }

    public int getLogLevel() {
        return this.zzBJ;
    }

    public void info(String msg) {
        if (this.zzBJ <= 1) {
            Log.i("GAV4", zzal(msg));
        }
    }

    public void setLogLevel(int level) {
        this.zzBJ = level;
    }

    public void verbose(String msg) {
        if (this.zzBJ <= 0) {
            Log.v("GAV4", zzal(msg));
        }
    }

    public void warn(String msg) {
        if (this.zzBJ <= 2) {
            Log.w("GAV4", zzal(msg));
        }
    }
}
