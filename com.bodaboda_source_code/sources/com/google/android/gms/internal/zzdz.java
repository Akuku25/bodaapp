package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@zzgi
public final class zzdz {

    /* renamed from: com.google.android.gms.internal.zzdz$1 */
    static /* synthetic */ class C01731 {
        static final /* synthetic */ int[] zzsX = new int[Gender.values().length];

        static {
            zzsY = new int[ErrorCode.values().length];
            try {
                zzsY[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzsY[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzsY[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzsY[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zzsX[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                zzsX[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                zzsX[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int zza(ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize zzb(zzba zzba) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < adSizeArr.length) {
            if (adSizeArr[i].getWidth() == zzba.width && adSizeArr[i].getHeight() == zzba.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(zza.zza(zzba.width, zzba.height, zzba.zzpa));
    }

    public static MediationAdRequest zzd(zzax zzax) {
        return new MediationAdRequest(new Date(zzax.zzoL), zzn(zzax.zzoM), zzax.zzoN != null ? new HashSet(zzax.zzoN) : null, zzax.zzoO, zzax.zzoT);
    }

    public static Gender zzn(int i) {
        switch (i) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
