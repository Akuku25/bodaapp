package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zza extends com.google.android.gms.common.internal.zzq.zza {
    private Context mContext;
    private Account zzFN;
    int zzPm;

    public static Account zzc(zzq zzq) {
        Account account = null;
        if (zzq != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = zzq.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return !(o instanceof zza) ? false : this.zzFN.equals(((zza) o).zzFN);
    }

    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzPm) {
            return this.zzFN;
        }
        if (GooglePlayServicesUtil.zzd(this.mContext, callingUid)) {
            this.zzPm = callingUid;
            return this.zzFN;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
