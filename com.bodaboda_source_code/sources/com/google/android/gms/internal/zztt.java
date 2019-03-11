package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.zzld.zza;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zztt extends zzle implements Moment {
    public static final zztu CREATOR = new zztu();
    private static final HashMap<String, zza<?, ?>> zzauW = new HashMap();
    String zzFA;
    final int zzFG;
    final Set<Integer> zzauX;
    String zzavK;
    zztr zzavS;
    zztr zzavT;
    String zzxV;

    static {
        zzauW.put("id", zza.zzl("id", 2));
        zzauW.put("result", zza.zza("result", 4, zztr.class));
        zzauW.put("startDate", zza.zzl("startDate", 5));
        zzauW.put("target", zza.zza("target", 6, zztr.class));
        zzauW.put("type", zza.zzl("type", 7));
    }

    public zztt() {
        this.zzFG = 1;
        this.zzauX = new HashSet();
    }

    zztt(Set<Integer> set, int i, String str, zztr zztr, String str2, zztr zztr2, String str3) {
        this.zzauX = set;
        this.zzFG = i;
        this.zzFA = str;
        this.zzavS = zztr;
        this.zzavK = str2;
        this.zzavT = zztr2;
        this.zzxV = str3;
    }

    public zztt(Set<Integer> set, String str, zztr zztr, String str2, zztr zztr2, String str3) {
        this.zzauX = set;
        this.zzFG = 1;
        this.zzFA = str;
        this.zzavS = zztr;
        this.zzavK = str2;
        this.zzavT = zztr2;
        this.zzxV = str3;
    }

    public int describeContents() {
        zztu zztu = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zztt)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zztt zztt = (zztt) obj;
        for (zza zza : zzauW.values()) {
            if (zza(zza)) {
                if (!zztt.zza(zza)) {
                    return false;
                }
                if (!zzb(zza).equals(zztt.zzb(zza))) {
                    return false;
                }
            } else if (zztt.zza(zza)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzsd();
    }

    public String getId() {
        return this.zzFA;
    }

    public ItemScope getResult() {
        return this.zzavS;
    }

    public String getStartDate() {
        return this.zzavK;
    }

    public ItemScope getTarget() {
        return this.zzavT;
    }

    public String getType() {
        return this.zzxV;
    }

    public boolean hasId() {
        return this.zzauX.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.zzauX.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.zzauX.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.zzauX.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.zzauX.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (zza zza : zzauW.values()) {
            int hashCode;
            if (zza(zza)) {
                hashCode = zzb(zza).hashCode() + (i + zza.zzjG());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        zztu zztu = CREATOR;
        zztu.zza(this, out, flags);
    }

    protected boolean zza(zza zza) {
        return this.zzauX.contains(Integer.valueOf(zza.zzjG()));
    }

    protected Object zzb(zza zza) {
        switch (zza.zzjG()) {
            case 2:
                return this.zzFA;
            case 4:
                return this.zzavS;
            case 5:
                return this.zzavK;
            case 6:
                return this.zzavT;
            case 7:
                return this.zzxV;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + zza.zzjG());
        }
    }

    public /* synthetic */ Map zzjz() {
        return zzsb();
    }

    public HashMap<String, zza<?, ?>> zzsb() {
        return zzauW;
    }

    public zztt zzsd() {
        return this;
    }
}
