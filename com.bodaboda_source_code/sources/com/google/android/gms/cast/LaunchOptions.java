package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Creator<LaunchOptions> CREATOR = new zzc();
    private final int zzFG;
    private boolean zzIN;
    private String zzIO;

    public static final class Builder {
        private LaunchOptions zzIP = new LaunchOptions();

        public LaunchOptions build() {
            return this.zzIP;
        }

        public Builder setLocale(Locale locale) {
            this.zzIP.setLanguage(zzjv.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean relaunchIfRunning) {
            this.zzIP.setRelaunchIfRunning(relaunchIfRunning);
            return this;
        }
    }

    public LaunchOptions() {
        this(1, false, zzjv.zzb(Locale.getDefault()));
    }

    LaunchOptions(int versionCode, boolean relaunchIfRunning, String language) {
        this.zzFG = versionCode;
        this.zzIN = relaunchIfRunning;
        this.zzIO = language;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.zzIN == launchOptions.zzIN && zzjv.zza(this.zzIO, launchOptions.zzIO);
    }

    public String getLanguage() {
        return this.zzIO;
    }

    public boolean getRelaunchIfRunning() {
        return this.zzIN;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzIN), this.zzIO);
    }

    public void setLanguage(String language) {
        this.zzIO = language;
    }

    public void setRelaunchIfRunning(boolean relaunchIfRunning) {
        this.zzIN = relaunchIfRunning;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.zzIN), this.zzIO});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
