package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzik implements Parcelable {
    @Deprecated
    public static final Creator<zzik> CREATOR = new C02151();
    private String mValue;
    private String zzFA;
    private String zzFB;

    /* renamed from: com.google.android.gms.internal.zzik$1 */
    static class C02151 implements Creator<zzik> {
        C02151() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzk(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzO(x0);
        }

        @Deprecated
        public zzik[] zzO(int i) {
            return new zzik[i];
        }

        @Deprecated
        public zzik zzk(Parcel parcel) {
            return new zzik(parcel);
        }
    }

    @Deprecated
    zzik(Parcel parcel) {
        readFromParcel(parcel);
    }

    public zzik(String str, String str2, String str3) {
        this.zzFA = str;
        this.zzFB = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.zzFA = in.readString();
        this.zzFB = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzFA;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.zzFA);
        out.writeString(this.zzFB);
        out.writeString(this.mValue);
    }
}
