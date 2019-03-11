package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;

@zzgi
public final class zzeo implements SafeParcelable {
    public static final zzen CREATOR = new zzen();
    public final int orientation;
    public final int versionCode;
    public final zzhy zzlP;
    public final String zztR;
    public final zzek zzun;
    public final zzat zzuo;
    public final zzep zzup;
    public final zzic zzuq;
    public final zzct zzur;
    public final String zzus;
    public final boolean zzut;
    public final String zzuu;
    public final zzes zzuv;
    public final int zzuw;
    public final zzcw zzux;
    public final String zzuy;
    public final zzx zzuz;

    zzeo(int i, zzek zzek, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, zzhy zzhy, IBinder iBinder6, String str4, zzx zzx) {
        this.versionCode = i;
        this.zzun = zzek;
        this.zzuo = (zzat) zze.zzf(zza.zzau(iBinder));
        this.zzup = (zzep) zze.zzf(zza.zzau(iBinder2));
        this.zzuq = (zzic) zze.zzf(zza.zzau(iBinder3));
        this.zzur = (zzct) zze.zzf(zza.zzau(iBinder4));
        this.zzus = str;
        this.zzut = z;
        this.zzuu = str2;
        this.zzuv = (zzes) zze.zzf(zza.zzau(iBinder5));
        this.orientation = i2;
        this.zzuw = i3;
        this.zztR = str3;
        this.zzlP = zzhy;
        this.zzux = (zzcw) zze.zzf(zza.zzau(iBinder6));
        this.zzuy = str4;
        this.zzuz = zzx;
    }

    public zzeo(zzat zzat, zzep zzep, zzct zzct, zzes zzes, zzic zzic, boolean z, int i, String str, zzhy zzhy, zzcw zzcw) {
        this.versionCode = 4;
        this.zzun = null;
        this.zzuo = zzat;
        this.zzup = zzep;
        this.zzuq = zzic;
        this.zzur = zzct;
        this.zzus = null;
        this.zzut = z;
        this.zzuu = null;
        this.zzuv = zzes;
        this.orientation = i;
        this.zzuw = 3;
        this.zztR = str;
        this.zzlP = zzhy;
        this.zzux = zzcw;
        this.zzuy = null;
        this.zzuz = null;
    }

    public zzeo(zzat zzat, zzep zzep, zzct zzct, zzes zzes, zzic zzic, boolean z, int i, String str, String str2, zzhy zzhy, zzcw zzcw) {
        this.versionCode = 4;
        this.zzun = null;
        this.zzuo = zzat;
        this.zzup = zzep;
        this.zzuq = zzic;
        this.zzur = zzct;
        this.zzus = str2;
        this.zzut = z;
        this.zzuu = str;
        this.zzuv = zzes;
        this.orientation = i;
        this.zzuw = 3;
        this.zztR = null;
        this.zzlP = zzhy;
        this.zzux = zzcw;
        this.zzuy = null;
        this.zzuz = null;
    }

    public zzeo(zzat zzat, zzep zzep, zzes zzes, zzic zzic, int i, zzhy zzhy, String str, zzx zzx) {
        this.versionCode = 4;
        this.zzun = null;
        this.zzuo = zzat;
        this.zzup = zzep;
        this.zzuq = zzic;
        this.zzur = null;
        this.zzus = null;
        this.zzut = false;
        this.zzuu = null;
        this.zzuv = zzes;
        this.orientation = i;
        this.zzuw = 1;
        this.zztR = null;
        this.zzlP = zzhy;
        this.zzux = null;
        this.zzuy = str;
        this.zzuz = zzx;
    }

    public zzeo(zzat zzat, zzep zzep, zzes zzes, zzic zzic, boolean z, int i, zzhy zzhy) {
        this.versionCode = 4;
        this.zzun = null;
        this.zzuo = zzat;
        this.zzup = zzep;
        this.zzuq = zzic;
        this.zzur = null;
        this.zzus = null;
        this.zzut = z;
        this.zzuu = null;
        this.zzuv = zzes;
        this.orientation = i;
        this.zzuw = 2;
        this.zztR = null;
        this.zzlP = zzhy;
        this.zzux = null;
        this.zzuy = null;
        this.zzuz = null;
    }

    public zzeo(zzek zzek, zzat zzat, zzep zzep, zzes zzes, zzhy zzhy) {
        this.versionCode = 4;
        this.zzun = zzek;
        this.zzuo = zzat;
        this.zzup = zzep;
        this.zzuq = null;
        this.zzur = null;
        this.zzus = null;
        this.zzut = false;
        this.zzuu = null;
        this.zzuv = zzes;
        this.orientation = -1;
        this.zzuw = 4;
        this.zztR = null;
        this.zzlP = zzhy;
        this.zzux = null;
        this.zzuy = null;
        this.zzuz = null;
    }

    public static void zza(Intent intent, zzeo zzeo) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", zzeo);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static zzeo zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(zzeo.class.getClassLoader());
            return (zzeo) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzen.zza(this, out, flags);
    }

    IBinder zzdi() {
        return zze.zzn(this.zzuo).asBinder();
    }

    IBinder zzdj() {
        return zze.zzn(this.zzup).asBinder();
    }

    IBinder zzdk() {
        return zze.zzn(this.zzuq).asBinder();
    }

    IBinder zzdl() {
        return zze.zzn(this.zzur).asBinder();
    }

    IBinder zzdm() {
        return zze.zzn(this.zzux).asBinder();
    }

    IBinder zzdn() {
        return zze.zzn(this.zzuv).asBinder();
    }
}
