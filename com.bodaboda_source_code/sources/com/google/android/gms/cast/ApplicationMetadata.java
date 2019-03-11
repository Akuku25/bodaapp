package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR = new zza();
    String mName;
    private final int zzFG;
    String zzIm;
    List<WebImage> zzIn;
    List<String> zzIo;
    String zzIp;
    Uri zzIq;

    private ApplicationMetadata() {
        this.zzFG = 1;
        this.zzIn = new ArrayList();
        this.zzIo = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.zzFG = versionCode;
        this.zzIm = applicationId;
        this.mName = name;
        this.zzIn = images;
        this.zzIo = namespaces;
        this.zzIp = senderAppIdentifier;
        this.zzIq = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.zzIo != null && this.zzIo.containsAll(namespaces);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzjv.zza(this.zzIm, applicationMetadata.zzIm) && zzjv.zza(this.zzIn, applicationMetadata.zzIn) && zzjv.zza(this.mName, applicationMetadata.mName) && zzjv.zza(this.zzIo, applicationMetadata.zzIo) && zzjv.zza(this.zzIp, applicationMetadata.zzIp) && zzjv.zza(this.zzIq, applicationMetadata.zzIq);
    }

    public String getApplicationId() {
        return this.zzIm;
    }

    public List<WebImage> getImages() {
        return this.zzIn;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.zzIp;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzFG), this.zzIm, this.mName, this.zzIn, this.zzIo, this.zzIp, this.zzIq);
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.zzIo != null && this.zzIo.contains(namespace);
    }

    public String toString() {
        int i = 0;
        StringBuilder append = new StringBuilder().append("applicationId: ").append(this.zzIm).append(", name: ").append(this.mName).append(", images.count: ").append(this.zzIn == null ? 0 : this.zzIn.size()).append(", namespaces.count: ");
        if (this.zzIo != null) {
            i = this.zzIo.size();
        }
        return append.append(i).append(", senderAppIdentifier: ").append(this.zzIp).append(", senderAppLaunchUrl: ").append(this.zzIq).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public Uri zzhh() {
        return this.zzIq;
    }
}
