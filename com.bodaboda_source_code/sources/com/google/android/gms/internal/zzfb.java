package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;

@zzgi
public final class zzfb implements SafeParcelable {
    public static final zzfa CREATOR = new zzfa();
    public final int versionCode;
    public final zzfl zzmg;
    public final zzfn zzuS;
    public final Context zzuT;
    public final zzfk zzuU;

    zzfb(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.zzmg = (zzfl) zze.zzf(zza.zzau(iBinder));
        this.zzuS = (zzfn) zze.zzf(zza.zzau(iBinder2));
        this.zzuT = (Context) zze.zzf(zza.zzau(iBinder3));
        this.zzuU = (zzfk) zze.zzf(zza.zzau(iBinder4));
    }

    public zzfb(Context context, zzfl zzfl, zzfn zzfn, zzfk zzfk) {
        this.versionCode = 2;
        this.zzuT = context;
        this.zzmg = zzfl;
        this.zzuS = zzfn;
        this.zzuU = zzfk;
    }

    public static void zza(Intent intent, zzfb zzfb) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", zzfb);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static zzfb zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(zzfb.class.getClassLoader());
            return (zzfb) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzfa.zza(this, out, flags);
    }

    IBinder zzds() {
        return zze.zzn(this.zzuU).asBinder();
    }

    IBinder zzdt() {
        return zze.zzn(this.zzmg).asBinder();
    }

    IBinder zzdu() {
        return zze.zzn(this.zzuS).asBinder();
    }

    IBinder zzdv() {
        return zze.zzn(this.zzuT).asBinder();
    }
}
