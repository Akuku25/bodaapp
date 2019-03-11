package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class zzqw implements zzrc {
    private static final Uri zzarS;
    private final LogPrinter zzarT = new LogPrinter(4, "GA/LogCatTransport");

    /* renamed from: com.google.android.gms.internal.zzqw$1 */
    class C02241 implements Comparator<zzqy> {
        final /* synthetic */ zzqw zzarU;

        C02241(zzqw zzqw) {
            this.zzarU = zzqw;
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return zza((zzqy) x0, (zzqy) x1);
        }

        public int zza(zzqy zzqy, zzqy zzqy2) {
            return zzqy.getClass().getCanonicalName().compareTo(zzqy2.getClass().getCanonicalName());
        }
    }

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        zzarS = builder.build();
    }

    public void zza(zzqx zzqx) {
        List<zzqy> arrayList = new ArrayList(zzqx.zzqQ());
        Collections.sort(arrayList, new C02241(this));
        StringBuilder stringBuilder = new StringBuilder();
        for (zzqy obj : arrayList) {
            Object obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj2);
            }
        }
        this.zzarT.println(stringBuilder.toString());
    }

    public Uri zzqP() {
        return zzarS;
    }
}
