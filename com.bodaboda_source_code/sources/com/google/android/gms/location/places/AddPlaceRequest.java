package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class AddPlaceRequest implements SafeParcelable {
    public static final Creator<AddPlaceRequest> CREATOR = new zza();
    private final String mName;
    final int zzFG;
    private final String zzYy;
    private final LatLng zzant;
    private final List<Integer> zzanu;
    private final String zzanv;
    private final Uri zzanw;

    AddPlaceRequest(int versionCode, String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber, Uri websiteUri) {
        this.zzFG = versionCode;
        this.mName = zzx.zzbn(name);
        this.zzant = (LatLng) zzx.zzl(latLng);
        this.zzYy = address;
        this.zzanu = new ArrayList(placeTypes);
        boolean z = (TextUtils.isEmpty(phoneNumber) && websiteUri == null) ? false : true;
        zzx.zzb(z, (Object) "One of phone number or URI should be provided.");
        this.zzanv = phoneNumber;
        this.zzanw = websiteUri;
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, Uri uri) {
        this(name, latLng, address, placeTypes, null, (Uri) zzx.zzl(uri));
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber) {
        this(name, latLng, address, placeTypes, zzx.zzbn(phoneNumber), null);
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber, Uri uri) {
        this(0, name, latLng, address, placeTypes, phoneNumber, uri);
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.zzYy;
    }

    public LatLng getLatLng() {
        return this.zzant;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.zzanv;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzanu;
    }

    public Uri getWebsiteUri() {
        return this.zzanw;
    }

    public String toString() {
        return zzw.zzk(this).zza("name", this.mName).zza("latLng", this.zzant).zza("address", this.zzYy).zza("placeTypes", this.zzanu).zza("phoneNumer", this.zzanv).zza("websiteUri", this.zzanw).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
