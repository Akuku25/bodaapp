package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new C01131();
    private IBinder zzPp;

    /* renamed from: com.google.android.gms.common.internal.BinderWrapper$1 */
    static class C01131 implements Creator<BinderWrapper> {
        C01131() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzD(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzaG(x0);
        }

        public BinderWrapper zzD(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        public BinderWrapper[] zzaG(int i) {
            return new BinderWrapper[i];
        }
    }

    public BinderWrapper() {
        this.zzPp = null;
    }

    public BinderWrapper(IBinder binder) {
        this.zzPp = null;
        this.zzPp = binder;
    }

    private BinderWrapper(Parcel in) {
        this.zzPp = null;
        this.zzPp = in.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.zzPp);
    }
}
