package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzb;
import com.google.android.gms.plus.PlusShare;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class zzax extends zzaj {
    private static final String ID = com.google.android.gms.internal.zza.JOINER.toString();
    private static final String zzayC = zzb.ARG0.toString();
    private static final String zzayU = zzb.ITEM_SEPARATOR.toString();
    private static final String zzayV = zzb.KEY_VALUE_SEPARATOR.toString();
    private static final String zzayW = zzb.ESCAPE.toString();

    private enum zza {
        NONE,
        URL,
        BACKSLASH
    }

    public zzax() {
        super(ID, zzayC);
    }

    private String zza(String str, zza zza, Set<Character> set) {
        switch (zza) {
            case URL:
                try {
                    return zzdi.zzdv(str);
                } catch (Throwable e) {
                    zzbf.zzb("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void zza(StringBuilder stringBuilder, String str, zza zza, Set<Character> set) {
        stringBuilder.append(zza(str, zza, set));
    }

    private void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public com.google.android.gms.internal.zzd.zza zzH(Map<String, com.google.android.gms.internal.zzd.zza> map) {
        com.google.android.gms.internal.zzd.zza zza = (com.google.android.gms.internal.zzd.zza) map.get(zzayC);
        if (zza == null) {
            return zzde.zzuf();
        }
        zza zza2;
        Set set;
        com.google.android.gms.internal.zzd.zza zza3 = (com.google.android.gms.internal.zzd.zza) map.get(zzayU);
        String zzg = zza3 != null ? zzde.zzg(zza3) : "";
        zza3 = (com.google.android.gms.internal.zzd.zza) map.get(zzayV);
        String zzg2 = zza3 != null ? zzde.zzg(zza3) : "=";
        zza zza4 = zza.NONE;
        zza3 = (com.google.android.gms.internal.zzd.zza) map.get(zzayW);
        if (zza3 != null) {
            String zzg3 = zzde.zzg(zza3);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(zzg3)) {
                zza2 = zza.URL;
                set = null;
            } else if ("backslash".equals(zzg3)) {
                zza2 = zza.BACKSLASH;
                set = new HashSet();
                zza(set, zzg);
                zza(set, zzg2);
                set.remove(Character.valueOf('\\'));
            } else {
                zzbf.zzZ("Joiner: unsupported escape type: " + zzg3);
                return zzde.zzuf();
            }
        }
        set = null;
        zza2 = zza4;
        StringBuilder stringBuilder = new StringBuilder();
        switch (zza.type) {
            case 2:
                Object obj = 1;
                com.google.android.gms.internal.zzd.zza[] zzaArr = zza.zzgw;
                int length = zzaArr.length;
                int i = 0;
                while (i < length) {
                    com.google.android.gms.internal.zzd.zza zza5 = zzaArr[i];
                    if (obj == null) {
                        stringBuilder.append(zzg);
                    }
                    zza(stringBuilder, zzde.zzg(zza5), zza2, set);
                    i++;
                    obj = null;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < zza.zzgx.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(zzg);
                    }
                    String zzg4 = zzde.zzg(zza.zzgx[i2]);
                    String zzg5 = zzde.zzg(zza.zzgy[i2]);
                    zza(stringBuilder, zzg4, zza2, set);
                    stringBuilder.append(zzg2);
                    zza(stringBuilder, zzg5, zza2, set);
                }
                break;
            default:
                zza(stringBuilder, zzde.zzg(zza), zza2, set);
                break;
        }
        return zzde.zzx(stringBuilder.toString());
    }

    public boolean zzsD() {
        return true;
    }
}
