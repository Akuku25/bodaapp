package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final zzi CREATOR = new zzi();
    final int zzFG;
    private final zzb<T> zzWJ;
    final MetadataBundle zzWx;

    InFilter(int versionCode, MetadataBundle value) {
        this.zzFG = versionCode;
        this.zzWx = value;
        this.zzWJ = (zzb) zze.zzb(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.zza(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection) this.zzWx.zza(this.zzWJ)).iterator().next();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zzb(this.zzWJ, getValue());
    }
}
