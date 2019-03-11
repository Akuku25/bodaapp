package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter extends AbstractFilter {
    public static final Creator<FieldOnlyFilter> CREATOR = new zzb();
    final int zzFG;
    final MetadataBundle zzWx;
    private final MetadataField<?> zzWy;

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.zzFG = versionCode;
        this.zzWx = value;
        this.zzWy = zze.zzb(value);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> field) {
        this(1, MetadataBundle.zza(field, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public <T> T zza(zzf<T> zzf) {
        return zzf.zze(this.zzWy);
    }
}
