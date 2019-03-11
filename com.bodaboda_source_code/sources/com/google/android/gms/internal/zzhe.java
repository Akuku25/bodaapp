package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzgi
public class zzhe {
    public final int errorCode;
    public final int orientation;
    public final zzdj zzsL;
    public final zzds zzsM;
    public final String zzsN;
    public final zzdm zzsO;
    public final List<String> zzst;
    public final List<String> zzsu;
    public final long zzsx;
    public final zzic zzuq;
    public final String zzwD;
    public final long zzwH;
    public final boolean zzwI;
    public final long zzwJ;
    public final List<String> zzwK;
    public final String zzwN;
    public final zzax zzwn;
    public final String zzwq;
    public final JSONObject zzys;
    public final zzdk zzyt;
    public final zzba zzyu;
    public final long zzyv;
    public final long zzyw;
    public final com.google.android.gms.internal.zzcn.zza zzyx;

    @zzgi
    public static final class zza {
        public final int errorCode;
        public final zzba zzlV;
        public final JSONObject zzys;
        public final zzdk zzyt;
        public final long zzyv;
        public final long zzyw;
        public final zzgo zzyy;
        public final zzgq zzyz;

        public zza(zzgo zzgo, zzgq zzgq, zzdk zzdk, zzba zzba, int i, long j, long j2, JSONObject jSONObject) {
            this.zzyy = zzgo;
            this.zzyz = zzgq;
            this.zzyt = zzdk;
            this.zzlV = zzba;
            this.errorCode = i;
            this.zzyv = j;
            this.zzyw = j2;
            this.zzys = jSONObject;
        }
    }

    public zzhe(zzax zzax, zzic zzic, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzdj zzdj, zzds zzds, String str2, zzdk zzdk, zzdm zzdm, long j2, zzba zzba, long j3, long j4, long j5, String str3, JSONObject jSONObject, com.google.android.gms.internal.zzcn.zza zza, String str4) {
        this.zzwn = zzax;
        this.zzuq = zzic;
        this.zzst = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.zzsu = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzwK = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.zzsx = j;
        this.zzwq = str;
        this.zzwI = z;
        this.zzsL = zzdj;
        this.zzsM = zzds;
        this.zzsN = str2;
        this.zzyt = zzdk;
        this.zzsO = zzdm;
        this.zzwJ = j2;
        this.zzyu = zzba;
        this.zzwH = j3;
        this.zzyv = j4;
        this.zzyw = j5;
        this.zzwN = str3;
        this.zzys = jSONObject;
        this.zzyx = zza;
        this.zzwD = str4;
    }

    public zzhe(zza zza, zzic zzic, zzdj zzdj, zzds zzds, String str, zzdm zzdm, com.google.android.gms.internal.zzcn.zza zza2) {
        this(zza.zzyy.zzwn, zzic, zza.zzyz.zzst, zza.errorCode, zza.zzyz.zzsu, zza.zzyz.zzwK, zza.zzyz.orientation, zza.zzyz.zzsx, zza.zzyy.zzwq, zza.zzyz.zzwI, zzdj, zzds, str, zza.zzyt, zzdm, zza.zzyz.zzwJ, zza.zzlV, zza.zzyz.zzwH, zza.zzyv, zza.zzyw, zza.zzyz.zzwN, zza.zzys, zza2, zza.zzyy.zzwD);
    }

    public boolean zzba() {
        return (this.zzuq == null || this.zzuq.zzeG() == null) ? false : this.zzuq.zzeG().zzba();
    }
}
