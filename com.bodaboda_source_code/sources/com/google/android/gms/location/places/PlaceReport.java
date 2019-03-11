package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;

public class PlaceReport implements SafeParcelable {
    public static final PlaceReportCreator CREATOR = new PlaceReportCreator();
    private final String mTag;
    final int zzFG;
    private final String zzanM;
    private final String zzanN;

    PlaceReport(int versionCode, String placeId, String tag, String source) {
        this.zzFG = versionCode;
        this.zzanM = placeId;
        this.mTag = tag;
        this.zzanN = source;
    }

    public static PlaceReport create(String placeId, String tag) {
        return zzf(placeId, tag, "unknown");
    }

    private static boolean zzcm(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    z = true;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    z = true;
                    break;
                }
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    z = false;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    z = true;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzf(String str, String str2, String str3) {
        zzx.zzbn(str);
        zzx.zzbn(str2);
        zzx.zzbn(str3);
        zzx.zzb(zzcm(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public int describeContents() {
        PlaceReportCreator placeReportCreator = CREATOR;
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) that;
        return zzw.equal(this.zzanM, placeReport.zzanM) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzanN, placeReport.zzanN);
    }

    public String getPlaceId() {
        return this.zzanM;
    }

    public String getSource() {
        return this.zzanN;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanM, this.mTag, this.zzanN);
    }

    public String toString() {
        zza zzk = zzw.zzk(this);
        zzk.zza("placeId", this.zzanM);
        zzk.zza("tag", this.mTag);
        if (!"unknown".equals(this.zzanN)) {
            zzk.zza("source", this.zzanN);
        }
        return zzk.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        PlaceReportCreator placeReportCreator = CREATOR;
        PlaceReportCreator.zza(this, out, flags);
    }
}
