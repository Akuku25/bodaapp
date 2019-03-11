package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@zzgi
public class zzaz {
    public static final zzaz zzoZ = new zzaz();

    protected zzaz() {
    }

    public static zzaz zzbA() {
        return zzoZ;
    }

    public zzax zza(Context context, zzbo zzbo) {
        Date birthday = zzbo.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzbo.getContentUrl();
        int gender = zzbo.getGender();
        Collection keywords = zzbo.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = zzbo.isTestDevice(context);
        int zzbL = zzbo.zzbL();
        Location location = zzbo.getLocation();
        Bundle networkExtrasBundle = zzbo.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzbo.getManualImpressionsEnabled();
        String publisherProvidedId = zzbo.getPublisherProvidedId();
        SearchAdRequest zzbI = zzbo.zzbI();
        return new zzax(5, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzbL, manualImpressionsEnabled, publisherProvidedId, zzbI != null ? new zzbs(zzbI) : null, location, contentUrl, zzbo.zzbK(), zzbo.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzbo.zzbM())), zzbo.zzbH());
    }
}
