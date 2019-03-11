package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.internal.zzxc;

public class DataSource implements SafeParcelable {
    public static final Creator<DataSource> CREATOR = new zzg();
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final String mName;
    private final int zzFG;
    private final int zzJp;
    private final Device zzYO;
    private final zza zzYP;
    private final String zzYQ;
    private final String zzYR;
    private final DataType zzYo;

    public static final class Builder {
        private String mName;
        private int zzJp = -1;
        private Device zzYO;
        private zza zzYP;
        private String zzYQ = "";
        private DataType zzYo;

        public DataSource build() {
            boolean z = true;
            zzx.zza(this.zzYo != null, (Object) "Must set data type");
            if (this.zzJp < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must set data source type");
            return new DataSource();
        }

        public Builder setAppPackageName(Context appContext) {
            return setAppPackageName(appContext.getPackageName());
        }

        public Builder setAppPackageName(String packageName) {
            this.zzYP = zza.zzbI(packageName);
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzYo = dataType;
            return this;
        }

        public Builder setDevice(Device device) {
            this.zzYO = device;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        @Deprecated
        public Builder setObfuscated(boolean isObfuscated) {
            return this;
        }

        public Builder setStreamName(String streamName) {
            zzx.zzb(streamName != null, (Object) "Must specify a valid stream name");
            this.zzYQ = streamName;
            return this;
        }

        public Builder setType(int type) {
            this.zzJp = type;
            return this;
        }

        public Builder zzb(zza zza) {
            this.zzYP = zza;
            return this;
        }
    }

    DataSource(int versionCode, DataType dataType, String name, int type, Device device, zza application, String streamName) {
        this.zzFG = versionCode;
        this.zzYo = dataType;
        this.zzJp = type;
        this.mName = name;
        this.zzYO = device;
        this.zzYP = application;
        this.zzYQ = streamName;
        this.zzYR = zzlA();
    }

    private DataSource(Builder builder) {
        this.zzFG = 3;
        this.zzYo = builder.zzYo;
        this.zzJp = builder.zzJp;
        this.mName = builder.mName;
        this.zzYO = builder.zzYO;
        this.zzYP = builder.zzYP;
        this.zzYQ = builder.zzYQ;
        this.zzYR = zzlA();
    }

    public static DataSource extract(Intent intent) {
        return intent == null ? null : (DataSource) zzc.zza(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private String getTypeString() {
        switch (this.zzJp) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    private boolean zza(DataSource dataSource) {
        return this.zzYR.equals(dataSource.zzYR);
    }

    private String zzlA() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTypeString());
        stringBuilder.append(":").append(this.zzYo.getName());
        if (this.zzYP != null) {
            stringBuilder.append(":").append(this.zzYP.getPackageName());
        }
        if (this.zzYO != null) {
            stringBuilder.append(":").append(this.zzYO.getStreamIdentifier());
        }
        if (this.zzYQ != null) {
            stringBuilder.append(":").append(this.zzYQ);
        }
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSource) && zza((DataSource) that));
    }

    public String getAppPackageName() {
        return this.zzYP == null ? null : this.zzYP.getPackageName();
    }

    public DataType getDataType() {
        return this.zzYo;
    }

    public Device getDevice() {
        return this.zzYO;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.zzYR;
    }

    public String getStreamName() {
        return this.zzYQ;
    }

    public int getType() {
        return this.zzJp;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return this.zzYR.hashCode();
    }

    public String toDebugString() {
        StringBuilder append = new StringBuilder().append(this.zzJp == 0 ? "r" : "d").append(":").append(this.zzYo.zzlB());
        String str = this.zzYP == null ? "" : this.zzYP.equals(zza.zzYv) ? ":gms" : ":" + this.zzYP.getPackageName();
        return append.append(str).append(this.zzYO != null ? ":" + this.zzYO.getModel() + ":" + this.zzYO.getUid() : "").append(this.zzYQ != null ? ":" + this.zzYQ : "").toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSource{");
        stringBuilder.append(getTypeString());
        if (this.mName != null) {
            stringBuilder.append(":").append(this.mName);
        }
        if (this.zzYP != null) {
            stringBuilder.append(":").append(this.zzYP);
        }
        if (this.zzYO != null) {
            stringBuilder.append(":").append(this.zzYO);
        }
        if (this.zzYQ != null) {
            stringBuilder.append(":").append(this.zzYQ);
        }
        stringBuilder.append(":").append(this.zzYo);
        return stringBuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzg.zza(zznz.zzc(this), parcel, flags);
    }

    public zzxc.zzc zzly() {
        return getDataType() == null ? null : getDataType().zzlC();
    }

    public zza zzlz() {
        return this.zzYP;
    }
}
