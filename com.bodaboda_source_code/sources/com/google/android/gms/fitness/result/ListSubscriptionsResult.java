package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
    public static final Creator<ListSubscriptionsResult> CREATOR = new zzi();
    private final int zzFG;
    private final Status zzHb;
    private final List<Subscription> zzabT;

    ListSubscriptionsResult(int versionCode, List<Subscription> subscriptions, Status status) {
        this.zzFG = versionCode;
        this.zzabT = subscriptions;
        this.zzHb = status;
    }

    public ListSubscriptionsResult(List<Subscription> subscriptions, Status status) {
        this.zzFG = 3;
        this.zzabT = Collections.unmodifiableList(subscriptions);
        this.zzHb = (Status) zzx.zzb((Object) status, Games.EXTRA_STATUS);
    }

    public static ListSubscriptionsResult zzE(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean zzb(ListSubscriptionsResult listSubscriptionsResult) {
        return this.zzHb.equals(listSubscriptionsResult.zzHb) && zzw.equal(this.zzabT, listSubscriptionsResult.zzabT);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof ListSubscriptionsResult) && zzb((ListSubscriptionsResult) that));
    }

    public Status getStatus() {
        return this.zzHb;
    }

    public List<Subscription> getSubscriptions() {
        return this.zzabT;
    }

    public List<Subscription> getSubscriptions(DataType dataType) {
        List arrayList = new ArrayList();
        for (Subscription subscription : this.zzabT) {
            if (dataType.equals(subscription.zzlJ())) {
                arrayList.add(subscription);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, this.zzabT);
    }

    public String toString() {
        return zzw.zzk(this).zza(Games.EXTRA_STATUS, this.zzHb).zza("subscriptions", this.zzabT).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
