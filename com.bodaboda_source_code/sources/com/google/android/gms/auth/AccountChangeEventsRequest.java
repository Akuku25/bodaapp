package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final AccountChangeEventsRequestCreator CREATOR = new AccountChangeEventsRequestCreator();
    Account zzFN;
    final int zzHe;
    @Deprecated
    String zzHg;
    int zzHi;

    public AccountChangeEventsRequest() {
        this.zzHe = 1;
    }

    AccountChangeEventsRequest(int version, int eventIndex, String accountName, Account account) {
        this.zzHe = version;
        this.zzHi = eventIndex;
        this.zzHg = accountName;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.zzFN = account;
        } else {
            this.zzFN = new Account(accountName, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzFN;
    }

    public String getAccountName() {
        return this.zzHg;
    }

    public int getEventIndex() {
        return this.zzHi;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzFN = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String accountName) {
        this.zzHg = accountName;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int eventIndex) {
        this.zzHi = eventIndex;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountChangeEventsRequestCreator.zza(this, dest, flags);
    }
}
