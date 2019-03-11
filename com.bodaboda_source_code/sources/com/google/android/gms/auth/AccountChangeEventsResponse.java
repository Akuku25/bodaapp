package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final AccountChangeEventsResponseCreator CREATOR = new AccountChangeEventsResponseCreator();
    final int zzHe;
    final List<AccountChangeEvent> zzmv;

    AccountChangeEventsResponse(int version, List<AccountChangeEvent> events) {
        this.zzHe = version;
        this.zzmv = (List) zzx.zzl(events);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> events) {
        this.zzHe = 1;
        this.zzmv = (List) zzx.zzl(events);
    }

    public int describeContents() {
        return 0;
    }

    public List<AccountChangeEvent> getEvents() {
        return this.zzmv;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountChangeEventsResponseCreator.zza(this, dest, flags);
    }
}
