package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class zzwm {

    public static class zza {
        public final zzwn zzaGQ;
        public final List<Asset> zzaGR;

        public zza(zzwn zzwn, List<Asset> list) {
            this.zzaGQ = zzwn;
            this.zzaGR = list;
        }
    }

    private static int zza(String str, com.google.android.gms.internal.zzwn.zza.zza[] zzaArr) {
        int i = 14;
        for (com.google.android.gms.internal.zzwn.zza.zza zza : zzaArr) {
            if (i == 14) {
                if (zza.type == 9 || zza.type == 2 || zza.type == 6) {
                    i = zza.type;
                } else if (zza.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + zza.type + " for key " + str);
                }
            } else if (zza.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + zza.type);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzwn zzwn = new zzwn();
        List arrayList = new ArrayList();
        zzwn.zzaGS = zza(dataMap, arrayList);
        return new zza(zzwn, arrayList);
    }

    private static com.google.android.gms.internal.zzwn.zza.zza zza(List<Asset> list, Object obj) {
        com.google.android.gms.internal.zzwn.zza.zza zza = new com.google.android.gms.internal.zzwn.zza.zza();
        if (obj == null) {
            zza.type = 14;
            return zza;
        }
        zza.zzaGW = new com.google.android.gms.internal.zzwn.zza.zza.zza();
        if (obj instanceof String) {
            zza.type = 2;
            zza.zzaGW.zzaGY = (String) obj;
        } else if (obj instanceof Integer) {
            zza.type = 6;
            zza.zzaGW.zzaHc = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            zza.type = 5;
            zza.zzaGW.zzaHb = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            zza.type = 3;
            zza.zzaGW.zzaGZ = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            zza.type = 4;
            zza.zzaGW.zzaHa = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            zza.type = 8;
            zza.zzaGW.zzaHe = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            zza.type = 7;
            zza.zzaGW.zzaHd = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            zza.type = 1;
            zza.zzaGW.zzaGX = (byte[]) obj;
        } else if (obj instanceof String[]) {
            zza.type = 11;
            zza.zzaGW.zzaHh = (String[]) obj;
        } else if (obj instanceof long[]) {
            zza.type = 12;
            zza.zzaGW.zzaHi = (long[]) obj;
        } else if (obj instanceof float[]) {
            zza.type = 15;
            zza.zzaGW.zzaHj = (float[]) obj;
        } else if (obj instanceof Asset) {
            zza.type = 13;
            zza.zzaGW.zzaHk = (long) zza((List) list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            zza.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> keySet = dataMap.keySet();
            com.google.android.gms.internal.zzwn.zza[] zzaArr = new com.google.android.gms.internal.zzwn.zza[keySet.size()];
            r1 = 0;
            for (String str : keySet) {
                zzaArr[r1] = new com.google.android.gms.internal.zzwn.zza();
                zzaArr[r1].name = str;
                zzaArr[r1].zzaGU = zza((List) list, dataMap.get(str));
                r1++;
            }
            zza.zzaGW.zzaHf = zzaArr;
        } else if (obj instanceof ArrayList) {
            zza.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            com.google.android.gms.internal.zzwn.zza.zza[] zzaArr2 = new com.google.android.gms.internal.zzwn.zza.zza[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                com.google.android.gms.internal.zzwn.zza.zza zza2 = zza((List) list, obj3);
                if (zza2.type == 14 || zza2.type == 2 || zza2.type == 6 || zza2.type == 9) {
                    if (i2 == 14 && zza2.type != 14) {
                        r1 = zza2.type;
                    } else if (zza2.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    zzaArr2[i] = zza2;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            zza.zzaGW.zzaHg = zzaArr2;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return zza;
    }

    public static DataMap zza(zza zza) {
        DataMap dataMap = new DataMap();
        for (com.google.android.gms.internal.zzwn.zza zza2 : zza.zzaGQ.zzaGS) {
            zza(zza.zzaGR, dataMap, zza2.name, zza2.zzaGU);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, com.google.android.gms.internal.zzwn.zza.zza.zza zza, int i) {
        ArrayList arrayList = new ArrayList(zza.zzaHg.length);
        for (com.google.android.gms.internal.zzwn.zza.zza zza2 : zza.zzaHg) {
            if (zza2.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (com.google.android.gms.internal.zzwn.zza zza3 : zza2.zzaGW.zzaHf) {
                    zza(list, dataMap, zza3.name, zza3.zzaGU);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(zza2.zzaGW.zzaGY);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(zza2.zzaGW.zzaHc));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, com.google.android.gms.internal.zzwn.zza.zza zza) {
        int i = zza.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        com.google.android.gms.internal.zzwn.zza.zza.zza zza2 = zza.zzaGW;
        if (i == 1) {
            dataMap.putByteArray(str, zza2.zzaGX);
        } else if (i == 11) {
            dataMap.putStringArray(str, zza2.zzaHh);
        } else if (i == 12) {
            dataMap.putLongArray(str, zza2.zzaHi);
        } else if (i == 15) {
            dataMap.putFloatArray(str, zza2.zzaHj);
        } else if (i == 2) {
            dataMap.putString(str, zza2.zzaGY);
        } else if (i == 3) {
            dataMap.putDouble(str, zza2.zzaGZ);
        } else if (i == 4) {
            dataMap.putFloat(str, zza2.zzaHa);
        } else if (i == 5) {
            dataMap.putLong(str, zza2.zzaHb);
        } else if (i == 6) {
            dataMap.putInt(str, zza2.zzaHc);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) zza2.zzaHd);
        } else if (i == 8) {
            dataMap.putBoolean(str, zza2.zzaHe);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) zza2.zzaHk));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (com.google.android.gms.internal.zzwn.zza zza3 : zza2.zzaHf) {
                zza(list, dataMap2, zza3.name, zza3.zzaGU);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            i = zza(str, zza2.zzaHg);
            ArrayList zza4 = zza(list, zza2, i);
            if (i == 14) {
                dataMap.putStringArrayList(str, zza4);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, zza4);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, zza4);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, zza4);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static com.google.android.gms.internal.zzwn.zza[] zza(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        com.google.android.gms.internal.zzwn.zza[] zzaArr = new com.google.android.gms.internal.zzwn.zza[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            Object obj = dataMap.get(str);
            zzaArr[i] = new com.google.android.gms.internal.zzwn.zza();
            zzaArr[i].name = str;
            zzaArr[i].zzaGU = zza((List) list, obj);
            i++;
        }
        return zzaArr;
    }
}
