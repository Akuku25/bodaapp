package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR = new zzd();
    final int zzFG;
    final DataHolder zzXv;
    final boolean zzXw;
    final List<String> zzXx;
    final List<ParcelableEvent> zzmv;

    ParcelableEventList(int versionCode, List<ParcelableEvent> events, DataHolder eventData, boolean undoRedoStateChanged, List<String> affectedObjectIds) {
        this.zzFG = versionCode;
        this.zzmv = events;
        this.zzXv = eventData;
        this.zzXw = undoRedoStateChanged;
        this.zzXx = affectedObjectIds;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
