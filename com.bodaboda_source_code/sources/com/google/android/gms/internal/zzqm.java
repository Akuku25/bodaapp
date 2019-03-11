package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import java.util.List;

public class zzqm implements SafeParcelable {
    public static final zzqn CREATOR = new zzqn();
    final int zzFG;
    private final String zzapf;
    private final List<zza> zzapg;

    public static final class zza implements SafeParcelable {
        public static final zzql CREATOR = new zzql();
        final int zzFG;
        private final String zzFQ;
        private final String zzSy;

        zza(int i, String str, String str2) {
            this.zzFG = i;
            this.zzSy = str;
            this.zzFQ = str2;
        }

        public int describeContents() {
            zzql zzql = CREATOR;
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof zza)) {
                return false;
            }
            zza zza = (zza) object;
            return zzw.equal(this.zzSy, zza.zzSy) && zzw.equal(this.zzFQ, zza.zzFQ);
        }

        public String getTitle() {
            return this.zzSy;
        }

        public String getUri() {
            return this.zzFQ;
        }

        public int hashCode() {
            return zzw.hashCode(this.zzSy, this.zzFQ);
        }

        public String toString() {
            return zzw.zzk(this).zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.zzSy).zza("uri", this.zzFQ).toString();
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzql zzql = CREATOR;
            zzql.zza(this, parcel, flags);
        }
    }

    zzqm(int i, String str, List<zza> list) {
        this.zzFG = i;
        this.zzapf = str;
        this.zzapg = list;
    }

    public int describeContents() {
        zzqn zzqn = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzqm)) {
            return false;
        }
        zzqm zzqm = (zzqm) object;
        return zzw.equal(this.zzapf, zzqm.zzapf) && zzw.equal(this.zzapg, zzqm.zzapg);
    }

    public List<zza> getActions() {
        return this.zzapg;
    }

    public String getData() {
        return this.zzapf;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapf, this.zzapg);
    }

    public String toString() {
        return zzw.zzk(this).zza("data", this.zzapf).zza("actions", this.zzapg).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzqn zzqn = CREATOR;
        zzqn.zza(this, parcel, flags);
    }
}
