package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;
import com.google.android.gms.location.zze;

public class zzpi implements SafeParcelable {
    public static final zzpj CREATOR = new zzpj();
    PendingIntent mPendingIntent;
    private final int zzFG;
    int zzanl;
    zzpg zzanm;
    zzd zzann;
    zze zzano;

    zzpi(int i, int i2, zzpg zzpg, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        zze zze = null;
        this.zzFG = i;
        this.zzanl = i2;
        this.zzanm = zzpg;
        this.zzann = iBinder == null ? null : zza.zzbg(iBinder);
        this.mPendingIntent = pendingIntent;
        if (iBinder2 != null) {
            zze = zze.zza.zzbh(iBinder2);
        }
        this.zzano = zze;
    }

    public static zzpi zza(zze zze) {
        return new zzpi(1, 2, null, null, null, zze.asBinder());
    }

    public static zzpi zzb(zzpg zzpg, PendingIntent pendingIntent) {
        return new zzpi(1, 1, zzpg, null, pendingIntent, null);
    }

    public static zzpi zzb(zzpg zzpg, zzd zzd) {
        return new zzpi(1, 1, zzpg, zzd.asBinder(), null, null);
    }

    public static zzpi zzb(zzd zzd) {
        return new zzpi(1, 2, null, zzd.asBinder(), null, null);
    }

    public static zzpi zze(PendingIntent pendingIntent) {
        return new zzpi(1, 2, null, null, pendingIntent, null);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzpj.zza(this, parcel, flags);
    }

    IBinder zzpA() {
        return this.zzano == null ? null : this.zzano.asBinder();
    }

    IBinder zzpz() {
        return this.zzann == null ? null : this.zzann.asBinder();
    }
}
