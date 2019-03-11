package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new zzb();
    private final int zzFG;
    private final Uri zzOL;
    private final int zzli;
    private final int zzlj;

    WebImage(int versionCode, Uri url, int width, int height) {
        this.zzFG = versionCode;
        this.zzOL = url;
        this.zzli = width;
        this.zzlj = height;
    }

    public WebImage(Uri url) throws IllegalArgumentException {
        this(url, 0, 0);
    }

    public WebImage(Uri url, int width, int height) throws IllegalArgumentException {
        this(1, url, width, height);
        if (url == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject json) throws IllegalArgumentException {
        this(zze(json), json.optInt("width", 0), json.optInt("height", 0));
    }

    private static Uri zze(JSONObject jSONObject) {
        Uri uri = null;
        if (jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            try {
                uri = Uri.parse(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
            } catch (JSONException e) {
            }
        }
        return uri;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) other;
        return zzw.equal(this.zzOL, webImage.zzOL) && this.zzli == webImage.zzli && this.zzlj == webImage.zzlj;
    }

    public int getHeight() {
        return this.zzlj;
    }

    public Uri getUrl() {
        return this.zzOL;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int getWidth() {
        return this.zzli;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzOL, Integer.valueOf(this.zzli), Integer.valueOf(this.zzlj));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, this.zzOL.toString());
            jSONObject.put("width", this.zzli);
            jSONObject.put("height", this.zzlj);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.zzli), Integer.valueOf(this.zzlj), this.zzOL.toString()});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
