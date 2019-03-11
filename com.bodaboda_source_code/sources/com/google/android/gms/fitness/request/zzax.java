package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzax implements SafeParcelable {
    public static final Creator<zzax> CREATOR = new zzay();
    private final int zzFG;
    private final String zzFO;
    private final DataType zzYo;
    private final DataSource zzYp;
    private final zznv zzaaN;

    zzax(int i, DataType dataType, DataSource dataSource, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzYo = dataType;
        this.zzYp = dataSource;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str;
    }

    public zzax(DataType dataType, DataSource dataSource, zznv zznv, String str) {
        this.zzFG = 2;
        this.zzYo = dataType;
        this.zzYp = dataSource;
        this.zzaaN = zznv;
        this.zzFO = str;
    }

    private boolean zzb(zzax zzax) {
        return zzw.equal(this.zzYp, zzax.zzYp) && zzw.equal(this.zzYo, zzax.zzYo);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof zzax) && zzb((zzax) o));
    }

    public DataSource getDataSource() {
        return this.zzYp;
    }

    public DataType getDataType() {
        return this.zzYo;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYp, this.zzYo);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzay.zza(this, parcel, flags);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }
}
