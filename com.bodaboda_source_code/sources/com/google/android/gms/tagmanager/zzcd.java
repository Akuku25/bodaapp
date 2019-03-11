package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcd extends zzaj {
    private static final String ID = zza.REGEX_GROUP.toString();
    private static final String zzazH = zzb.ARG0.toString();
    private static final String zzazI = zzb.ARG1.toString();
    private static final String zzazJ = zzb.IGNORE_CASE.toString();
    private static final String zzazK = zzb.GROUP.toString();

    public zzcd() {
        super(ID, zzazH, zzazI);
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        zzd.zza zza = (zzd.zza) map.get(zzazH);
        zzd.zza zza2 = (zzd.zza) map.get(zzazI);
        if (zza == null || zza == zzde.zzuf() || zza2 == null || zza2 == zzde.zzuf()) {
            return zzde.zzuf();
        }
        int i = 64;
        if (zzde.zzk((zzd.zza) map.get(zzazJ)).booleanValue()) {
            i = 66;
        }
        zzd.zza zza3 = (zzd.zza) map.get(zzazK);
        int intValue;
        if (zza3 != null) {
            Long zzi = zzde.zzi(zza3);
            if (zzi == zzde.zzua()) {
                return zzde.zzuf();
            }
            intValue = zzi.intValue();
            if (intValue < 0) {
                return zzde.zzuf();
            }
        }
        intValue = 1;
        try {
            CharSequence zzg = zzde.zzg(zza);
            Object obj = null;
            Matcher matcher = Pattern.compile(zzde.zzg(zza2), i).matcher(zzg);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? zzde.zzuf() : zzde.zzx(obj);
        } catch (PatternSyntaxException e) {
            return zzde.zzuf();
        }
    }

    public boolean zzsD() {
        return true;
    }
}
