package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class zzin implements SafeParcelable {
    public static final zzio CREATOR = new zzio();
    public final Account account;
    final int zzFG;
    final zzir[] zzFH;
    public final String zzFI;
    public final boolean zzFJ;

    public static class zza {
        private List<zzir> zzFK;
        private String zzFL;
        private boolean zzFM;
        private Account zzFN;

        public zza zzH(boolean z) {
            this.zzFM = z;
            return this;
        }

        public zza zza(Account account) {
            this.zzFN = account;
            return this;
        }

        public zza zza(zzir zzir) {
            if (this.zzFK == null) {
                this.zzFK = new ArrayList();
            }
            this.zzFK.add(zzir);
            return this;
        }

        public zza zzax(String str) {
            this.zzFL = str;
            return this;
        }

        public zzin zzgU() {
            return new zzin(this.zzFL, this.zzFM, this.zzFN, this.zzFK != null ? (zzir[]) this.zzFK.toArray(new zzir[this.zzFK.size()]) : null);
        }
    }

    zzin(int i, zzir[] zzirArr, String str, boolean z, Account account) {
        this.zzFG = i;
        this.zzFH = zzirArr;
        this.zzFI = str;
        this.zzFJ = z;
        this.account = account;
    }

    zzin(String str, boolean z, Account account, zzir... zzirArr) {
        this(1, zzirArr, str, z, account);
        BitSet bitSet = new BitSet(zziy.zzgW());
        for (zzir zzir : zzirArr) {
            int i = zzir.zzFV;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + zziy.zzV(i));
                }
                bitSet.set(i);
            }
        }
    }

    public int describeContents() {
        zzio zzio = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzio zzio = CREATOR;
        zzio.zza(this, dest, flags);
    }
}
