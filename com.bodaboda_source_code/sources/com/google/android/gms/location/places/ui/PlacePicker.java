package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLngBounds;

public class PlacePicker {
    public static final int RESULT_ERROR = 2;

    public static class IntentBuilder {
        private final Intent mIntent = new Intent("com.google.android.gms.location.places.ui.PICK_PLACE");

        public IntentBuilder() {
            this.mIntent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        }

        public Intent build(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            GooglePlayServicesUtil.zzI(context);
            return this.mIntent;
        }

        public IntentBuilder setLatLngBounds(LatLngBounds latLngBounds) {
            zzx.zzl(latLngBounds);
            zzc.zza((SafeParcelable) latLngBounds, this.mIntent, "latlng_bounds");
            return this;
        }
    }

    public static String getAttributions(Intent intent) {
        return intent.getStringExtra("third_party_attributions");
    }

    public static LatLngBounds getLatLngBounds(Intent intent) {
        return (LatLngBounds) zzc.zza(intent, "final_latlng_bounds", LatLngBounds.CREATOR);
    }

    public static Place getPlace(Intent intent, Context context) {
        zzx.zzb((Object) context, (Object) "context must not be null");
        zzpy zzpy = (zzpy) zzc.zza(intent, "selected_place", zzpy.CREATOR);
        zzpy.zza(zzqf.zzab(context));
        return zzpy;
    }
}
