package com.google.android.gms.internal;

import android.content.Context;

public class zzot {
    private final Context mContext;
    private final String zzHg;
    private final String zzMh;
    private zzou zzamA = null;
    private final zzpm<zzpc> zzamz;

    private zzot(Context context, String str, String str2, zzpm<zzpc> zzpm) {
        this.mContext = context;
        this.zzHg = str;
        this.zzamz = zzpm;
        this.zzMh = str2;
    }

    public static zzot zza(Context context, String str, String str2, zzpm<zzpc> zzpm) {
        return new zzot(context, str, str2, zzpm);
    }
}
