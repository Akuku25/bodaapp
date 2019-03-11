package com.google.android.gms.internal;

import org.json.JSONObject;

@zzgi
public class zzee {
    private final boolean zztA;
    private final boolean zztB;
    private final boolean zztC;
    private final boolean zztD;
    private final boolean zztE;

    public static final class zza {
        private boolean zztA;
        private boolean zztB;
        private boolean zztC;
        private boolean zztD;
        private boolean zztE;

        public zzee zzcR() {
            return new zzee();
        }

        public zza zzn(boolean z) {
            this.zztA = z;
            return this;
        }

        public zza zzo(boolean z) {
            this.zztB = z;
            return this;
        }

        public zza zzp(boolean z) {
            this.zztC = z;
            return this;
        }

        public zza zzq(boolean z) {
            this.zztD = z;
            return this;
        }

        public zza zzr(boolean z) {
            this.zztE = z;
            return this;
        }
    }

    private zzee(zza zza) {
        this.zztA = zza.zztA;
        this.zztB = zza.zztB;
        this.zztC = zza.zztC;
        this.zztD = zza.zztD;
        this.zztE = zza.zztE;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zztA).put("tel", this.zztB).put("calendar", this.zztC).put("storePicture", this.zztD).put("inlineVideo", this.zztE);
        } catch (Throwable e) {
            zzhx.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
