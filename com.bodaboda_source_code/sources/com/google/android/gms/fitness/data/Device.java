package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznz;

public final class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR = new zzi();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int zzFG;
    private final int zzJp;
    private final String zzYw;
    private final String zzZe;
    private final String zzZf;
    private final String zzZg;
    private final int zzZh;

    Device(int versionCode, String manufacturer, String model, String version, String uid, int type, int platformType) {
        this.zzFG = versionCode;
        this.zzZe = (String) zzx.zzl(manufacturer);
        this.zzZf = (String) zzx.zzl(model);
        this.zzYw = "";
        this.zzZg = (String) zzx.zzl(uid);
        this.zzJp = type;
        this.zzZh = platformType;
    }

    public Device(String manufacturer, String model, String uid, int type) {
        this(manufacturer, model, "", uid, type, 0);
    }

    public Device(String manufacturer, String model, String version, String uid, int type) {
        this(manufacturer, model, uid, type);
    }

    public Device(String manufacturer, String model, String version, String uid, int type, int platformType) {
        this(1, manufacturer, model, "", uid, type, platformType);
    }

    public static Device getLocalDevice(Context context) {
        int zzU = zzU(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, zzT(context), zzU, 2);
    }

    private static String zzT(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    private static int zzU(Context context) {
        switch (zzW(context)) {
            case 8:
            case 9:
                return 0;
            case 10:
                return zzV(context) ? 3 : 0;
            default:
                return zzY(context) ? 1 : 2;
        }
    }

    public static boolean zzV(Context context) {
        return (context.getResources().getConfiguration().uiMode & 15) == 6;
    }

    private static int zzW(Context context) {
        return ((zzX(context) % 1000) / 100) + 5;
    }

    private static int zzX(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    private static boolean zzY(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
    }

    private boolean zza(Device device) {
        return zzw.equal(this.zzZe, device.zzZe) && zzw.equal(this.zzZf, device.zzZf) && zzw.equal(this.zzYw, device.zzYw) && zzw.equal(this.zzZg, device.zzZg) && this.zzJp == device.zzJp && this.zzZh == device.zzZh;
    }

    private boolean zzlE() {
        return zzlD() == 1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Device) && zza((Device) that));
    }

    public String getManufacturer() {
        return this.zzZe;
    }

    public String getModel() {
        return this.zzZf;
    }

    String getStreamIdentifier() {
        return String.format("%s:%s:%s", new Object[]{this.zzZe, this.zzZf, this.zzZg});
    }

    public int getType() {
        return this.zzJp;
    }

    public String getUid() {
        return this.zzZg;
    }

    public String getVersion() {
        return this.zzYw;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzZe, this.zzZf, this.zzYw, this.zzZg, Integer.valueOf(this.zzJp));
    }

    public String toString() {
        return String.format("Device{%s:%s:%s:%s}", new Object[]{getStreamIdentifier(), this.zzYw, Integer.valueOf(this.zzJp), Integer.valueOf(this.zzZh)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzi.zza(this, parcel, flags);
    }

    public int zzlD() {
        return this.zzZh;
    }

    public String zzlF() {
        return (zznz.zzlM() || zzlE()) ? this.zzZg : zznz.zzbM(this.zzZg);
    }
}
