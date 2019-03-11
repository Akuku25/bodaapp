package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zza.zza;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zznv;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR = new zzaq();
    private final int zzFG;
    private final String zzFO;
    private final List<DataType> zzYA;
    private final zznv zzaaN;
    private final zzt zzabH;
    private final int zzabI;

    public static class Builder {
        private zzt zzabH;
        private int zzabI = 10;
        private DataType[] zzabg = new DataType[0];

        public StartBleScanRequest build() {
            zzx.zza(this.zzabH != null, (Object) "Must set BleScanCallback");
            return new StartBleScanRequest();
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza(zza.zzlO().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzabg = dataTypes;
            return this;
        }

        public Builder setTimeoutSecs(int stopTimeSecs) {
            boolean z = true;
            zzx.zzb(stopTimeSecs > 0, (Object) "Stop time must be greater than zero");
            if (stopTimeSecs > 60) {
                z = false;
            }
            zzx.zzb(z, (Object) "Stop time must be less than 1 minute");
            this.zzabI = stopTimeSecs;
            return this;
        }

        public Builder zza(zzt zzt) {
            this.zzabH = zzt;
            return this;
        }
    }

    StartBleScanRequest(int versionCode, List<DataType> dataTypes, IBinder bleScanCallback, int timeoutSecs, IBinder callback, String packageName) {
        this.zzFG = versionCode;
        this.zzYA = dataTypes;
        this.zzabH = zzt.zza.zzaV(bleScanCallback);
        this.zzabI = timeoutSecs;
        this.zzaaN = callback == null ? null : zznv.zza.zzaS(callback);
        this.zzFO = packageName;
    }

    private StartBleScanRequest(Builder builder) {
        this(zzls.zzb(builder.zzabg), builder.zzabH, builder.zzabI, null, null);
    }

    public StartBleScanRequest(StartBleScanRequest request, zznv callback, String packageName) {
        this(request.zzYA, request.zzabH, request.zzabI, callback, packageName);
    }

    public StartBleScanRequest(List<DataType> dataTypes, zzt bleScanCallback, int timeoutSecs, zznv callback, String packageName) {
        this.zzFG = 3;
        this.zzYA = dataTypes;
        this.zzabH = bleScanCallback;
        this.zzabI = timeoutSecs;
        this.zzaaN = callback;
        this.zzFO = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzYA);
    }

    public String getPackageName() {
        return this.zzFO;
    }

    public int getTimeoutSecs() {
        return this.zzabI;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        return zzw.zzk(this).zza("dataTypes", this.zzYA).zza("timeoutSecs", Integer.valueOf(this.zzabI)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzaq.zza(this, parcel, flags);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public IBinder zzmk() {
        return this.zzabH.asBinder();
    }
}
