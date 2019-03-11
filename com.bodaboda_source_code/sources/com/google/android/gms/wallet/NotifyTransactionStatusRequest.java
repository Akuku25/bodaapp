package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Creator<NotifyTransactionStatusRequest> CREATOR = new zzn();
    int status;
    final int zzFG;
    String zzaCY;
    String zzaEf;

    public final class Builder {
        final /* synthetic */ NotifyTransactionStatusRequest zzaEg;

        private Builder(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.zzaEg = notifyTransactionStatusRequest;
        }

        public NotifyTransactionStatusRequest build() {
            boolean z = true;
            zzx.zzb(!TextUtils.isEmpty(this.zzaEg.zzaCY), (Object) "googleTransactionId is required");
            if (this.zzaEg.status < 1 || this.zzaEg.status > 8) {
                z = false;
            }
            zzx.zzb(z, (Object) "status is an unrecognized value");
            return this.zzaEg;
        }

        public Builder setDetailedReason(String detailedReason) {
            this.zzaEg.zzaEf = detailedReason;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzaEg.zzaCY = googleTransactionId;
            return this;
        }

        public Builder setStatus(int status) {
            this.zzaEg.status = status;
            return this;
        }
    }

    public interface Status {
        public static final int SUCCESS = 1;

        public interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }

    NotifyTransactionStatusRequest() {
        this.zzFG = 1;
    }

    NotifyTransactionStatusRequest(int versionCode, String googleTransactionId, int status, String detailedReason) {
        this.zzFG = versionCode;
        this.zzaCY = googleTransactionId;
        this.status = status;
        this.zzaEf = detailedReason;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getDetailedReason() {
        return this.zzaEf;
    }

    public String getGoogleTransactionId() {
        return this.zzaCY;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzn.zza(this, out, flags);
    }
}
