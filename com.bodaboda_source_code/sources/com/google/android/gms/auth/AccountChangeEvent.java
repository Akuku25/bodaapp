package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent implements SafeParcelable {
    public static final AccountChangeEventCreator CREATOR = new AccountChangeEventCreator();
    final int zzHe;
    final long zzHf;
    final String zzHg;
    final int zzHh;
    final int zzHi;
    final String zzHj;

    AccountChangeEvent(int version, long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.zzHe = version;
        this.zzHf = id;
        this.zzHg = (String) zzx.zzl(accountName);
        this.zzHh = changeType;
        this.zzHi = eventIndex;
        this.zzHj = changeData;
    }

    public AccountChangeEvent(long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.zzHe = 1;
        this.zzHf = id;
        this.zzHg = (String) zzx.zzl(accountName);
        this.zzHh = changeType;
        this.zzHi = eventIndex;
        this.zzHj = changeData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (that == this) {
            return true;
        }
        if (!(that instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) that;
        return this.zzHe == accountChangeEvent.zzHe && this.zzHf == accountChangeEvent.zzHf && zzw.equal(this.zzHg, accountChangeEvent.zzHg) && this.zzHh == accountChangeEvent.zzHh && this.zzHi == accountChangeEvent.zzHi && zzw.equal(this.zzHj, accountChangeEvent.zzHj);
    }

    public String getAccountName() {
        return this.zzHg;
    }

    public String getChangeData() {
        return this.zzHj;
    }

    public int getChangeType() {
        return this.zzHh;
    }

    public int getEventIndex() {
        return this.zzHi;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzHe), Long.valueOf(this.zzHf), this.zzHg, Integer.valueOf(this.zzHh), Integer.valueOf(this.zzHi), this.zzHj);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.zzHh) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.zzHg + ", changeType = " + str + ", changeData = " + this.zzHj + ", eventIndex = " + this.zzHi + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountChangeEventCreator.zza(this, dest, flags);
    }
}
