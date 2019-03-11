package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Games;
import com.google.android.gms.internal.zzpq;

public class AutocompletePredictionBuffer extends AbstractDataBuffer<AutocompletePrediction> implements Result {
    public AutocompletePredictionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public AutocompletePrediction get(int position) {
        return new zzpq(this.zzMd, position);
    }

    public Status getStatus() {
        return new Status(this.zzMd.getStatusCode());
    }

    public String toString() {
        return zzw.zzk(this).zza(Games.EXTRA_STATUS, getStatus()).toString();
    }
}
