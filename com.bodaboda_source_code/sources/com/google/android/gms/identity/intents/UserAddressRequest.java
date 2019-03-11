package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR = new zza();
    private final int zzFG;
    List<CountrySpecification> zzalr;

    public final class Builder {
        final /* synthetic */ UserAddressRequest zzals;

        private Builder(UserAddressRequest userAddressRequest) {
            this.zzals = userAddressRequest;
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (this.zzals.zzalr == null) {
                this.zzals.zzalr = new ArrayList();
            }
            this.zzals.zzalr.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> countrySpecifications) {
            if (this.zzals.zzalr == null) {
                this.zzals.zzalr = new ArrayList();
            }
            this.zzals.zzalr.addAll(countrySpecifications);
            return this;
        }

        public UserAddressRequest build() {
            if (this.zzals.zzalr != null) {
                this.zzals.zzalr = Collections.unmodifiableList(this.zzals.zzalr);
            }
            return this.zzals;
        }
    }

    UserAddressRequest() {
        this.zzFG = 1;
    }

    UserAddressRequest(int versionCode, List<CountrySpecification> allowedCountrySpecifications) {
        this.zzFG = versionCode;
        this.zzalr = allowedCountrySpecifications;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
