package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class zzlh implements SafeParcelable {
    public static final zzli CREATOR = new zzli();
    private final int zzFG;
    private final HashMap<String, Map<String, com.google.android.gms.internal.zzld.zza<?, ?>>> zzQZ;
    private final ArrayList<zza> zzRa;
    private final String zzRb;

    public static class zza implements SafeParcelable {
        public static final zzlj CREATOR = new zzlj();
        final String className;
        final int versionCode;
        final ArrayList<zzb> zzRc;

        zza(int i, String str, ArrayList<zzb> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.zzRc = arrayList;
        }

        zza(String str, Map<String, com.google.android.gms.internal.zzld.zza<?, ?>> map) {
            this.versionCode = 1;
            this.className = str;
            this.zzRc = zzE(map);
        }

        private static ArrayList<zzb> zzE(Map<String, com.google.android.gms.internal.zzld.zza<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<zzb> arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new zzb(str, (com.google.android.gms.internal.zzld.zza) map.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            zzlj zzlj = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzlj zzlj = CREATOR;
            zzlj.zza(this, out, flags);
        }

        HashMap<String, com.google.android.gms.internal.zzld.zza<?, ?>> zzjQ() {
            HashMap<String, com.google.android.gms.internal.zzld.zza<?, ?>> hashMap = new HashMap();
            int size = this.zzRc.size();
            for (int i = 0; i < size; i++) {
                zzb zzb = (zzb) this.zzRc.get(i);
                hashMap.put(zzb.zzfv, zzb.zzRd);
            }
            return hashMap;
        }
    }

    public static class zzb implements SafeParcelable {
        public static final zzlg CREATOR = new zzlg();
        final int versionCode;
        final com.google.android.gms.internal.zzld.zza<?, ?> zzRd;
        final String zzfv;

        zzb(int i, String str, com.google.android.gms.internal.zzld.zza<?, ?> zza) {
            this.versionCode = i;
            this.zzfv = str;
            this.zzRd = zza;
        }

        zzb(String str, com.google.android.gms.internal.zzld.zza<?, ?> zza) {
            this.versionCode = 1;
            this.zzfv = str;
            this.zzRd = zza;
        }

        public int describeContents() {
            zzlg zzlg = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzlg zzlg = CREATOR;
            zzlg.zza(this, out, flags);
        }
    }

    zzlh(int i, ArrayList<zza> arrayList, String str) {
        this.zzFG = i;
        this.zzRa = null;
        this.zzQZ = zzc(arrayList);
        this.zzRb = (String) zzx.zzl(str);
        zzjM();
    }

    public zzlh(Class<? extends zzld> cls) {
        this.zzFG = 1;
        this.zzRa = null;
        this.zzQZ = new HashMap();
        this.zzRb = cls.getCanonicalName();
    }

    private static HashMap<String, Map<String, com.google.android.gms.internal.zzld.zza<?, ?>>> zzc(ArrayList<zza> arrayList) {
        HashMap<String, Map<String, com.google.android.gms.internal.zzld.zza<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zza zza = (zza) arrayList.get(i);
            hashMap.put(zza.className, zza.zzjQ());
        }
        return hashMap;
    }

    public int describeContents() {
        zzli zzli = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.zzQZ.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.zzQZ.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzli zzli = CREATOR;
        zzli.zza(this, out, flags);
    }

    public void zza(Class<? extends zzld> cls, Map<String, com.google.android.gms.internal.zzld.zza<?, ?>> map) {
        this.zzQZ.put(cls.getCanonicalName(), map);
    }

    public boolean zzb(Class<? extends zzld> cls) {
        return this.zzQZ.containsKey(cls.getCanonicalName());
    }

    public Map<String, com.google.android.gms.internal.zzld.zza<?, ?>> zzbs(String str) {
        return (Map) this.zzQZ.get(str);
    }

    public void zzjM() {
        for (String str : this.zzQZ.keySet()) {
            Map map = (Map) this.zzQZ.get(str);
            for (String str2 : map.keySet()) {
                ((com.google.android.gms.internal.zzld.zza) map.get(str2)).zza(this);
            }
        }
    }

    public void zzjN() {
        for (String str : this.zzQZ.keySet()) {
            Map map = (Map) this.zzQZ.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, ((com.google.android.gms.internal.zzld.zza) map.get(str2)).zzjC());
            }
            this.zzQZ.put(str, hashMap);
        }
    }

    ArrayList<zza> zzjO() {
        ArrayList<zza> arrayList = new ArrayList();
        for (String str : this.zzQZ.keySet()) {
            arrayList.add(new zza(str, (Map) this.zzQZ.get(str)));
        }
        return arrayList;
    }

    public String zzjP() {
        return this.zzRb;
    }
}
