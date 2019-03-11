package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.Session.Builder;
import com.google.android.gms.internal.zzxe.zza;
import java.util.concurrent.TimeUnit;

public class zzmw {
    public static final zzmw zzZW = new zzmw();

    public Session zza(zza zza) {
        String str = zza.zzaIe == null ? "unknown" : zza.zzaIe.packageName;
        Builder builder = new Builder();
        if (zza.zzfl != null) {
            builder.setIdentifier(zza.zzfl);
        }
        if (zza.name != null) {
            builder.setName(zza.name);
        }
        if (zza.description != null) {
            builder.setDescription(zza.description);
        }
        if (zza.zzaIL != null) {
            builder.setStartTime(zza.zzaIL.longValue(), TimeUnit.MILLISECONDS);
        }
        if (zza.zzaIM != null) {
            builder.setEndTime(zza.zzaIM.longValue(), TimeUnit.MILLISECONDS);
        }
        if (zza.zzaIO != null) {
            builder.zzds(zza.zzaIO.intValue());
        }
        builder.zzbL(str);
        return builder.build();
    }

    public zza zzb(Session session) {
        zza zza = new zza();
        zzx.zzb(session.getIdentifier(), "session require identifier: " + session);
        zza.zzfl = session.getIdentifier();
        if (session.getName() != null) {
            zza.name = session.getName();
        }
        if (session.getDescription() != null) {
            zza.description = session.getDescription();
        }
        zza.zzaIL = Long.valueOf(session.getStartTime(TimeUnit.MILLISECONDS));
        zza.zzaIM = Long.valueOf(session.getEndTime(TimeUnit.MILLISECONDS));
        zza.zzaIO = Integer.valueOf(session.zzln());
        if (session.getAppPackageName() != null) {
            zza.zzaIe = new zzxc.zza();
            zza.zzaIe.packageName = session.getAppPackageName();
        }
        return zza;
    }
}
