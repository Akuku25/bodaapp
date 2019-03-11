package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR = new zzc();
    public Uri uri;
    final int zzFG;
    private String zzaFr;
    public ParcelFileDescriptor zzaFs;
    private byte[] zzakd;

    Asset(int versionCode, byte[] data, String digest, ParcelFileDescriptor fd, Uri uri) {
        this.zzFG = versionCode;
        this.zzakd = data;
        this.zzaFr = digest;
        this.zzaFs = fd;
        this.uri = uri;
    }

    public static Asset createFromBytes(byte[] assetData) {
        if (assetData != null) {
            return new Asset(1, assetData, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor fd) {
        if (fd != null) {
            return new Asset(1, null, null, fd, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String digest) {
        if (digest != null) {
            return new Asset(1, null, digest, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri) {
        if (uri != null) {
            return new Asset(1, null, null, null, uri);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) o;
        return zzw.equal(this.zzakd, asset.zzakd) && zzw.equal(this.zzaFr, asset.zzaFr) && zzw.equal(this.zzaFs, asset.zzaFs) && zzw.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.zzakd;
    }

    public String getDigest() {
        return this.zzaFr;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzaFs;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzakd, this.zzaFr, this.zzaFs, this.uri);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzaFr == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.zzaFr);
        }
        if (this.zzakd != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.zzakd.length);
        }
        if (this.zzaFs != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.zzaFs);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags | 1);
    }
}
