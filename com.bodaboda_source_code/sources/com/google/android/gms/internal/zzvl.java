package com.google.android.gms.internal;

import com.google.android.gms.internal.zzc.zzh;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzde;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzvl {

    public static class zza {
        private final com.google.android.gms.internal.zzd.zza zzaAo;
        private final Map<String, com.google.android.gms.internal.zzd.zza> zzaCj;

        private zza(Map<String, com.google.android.gms.internal.zzd.zza> map, com.google.android.gms.internal.zzd.zza zza) {
            this.zzaCj = map;
            this.zzaAo = zza;
        }

        public static zzb zzuu() {
            return new zzb();
        }

        public String toString() {
            return "Properties: " + zzuv() + " pushAfterEvaluate: " + this.zzaAo;
        }

        public void zza(String str, com.google.android.gms.internal.zzd.zza zza) {
            this.zzaCj.put(str, zza);
        }

        public com.google.android.gms.internal.zzd.zza zztK() {
            return this.zzaAo;
        }

        public Map<String, com.google.android.gms.internal.zzd.zza> zzuv() {
            return Collections.unmodifiableMap(this.zzaCj);
        }
    }

    public static class zzb {
        private com.google.android.gms.internal.zzd.zza zzaAo;
        private final Map<String, com.google.android.gms.internal.zzd.zza> zzaCj;

        private zzb() {
            this.zzaCj = new HashMap();
        }

        public zzb zzb(String str, com.google.android.gms.internal.zzd.zza zza) {
            this.zzaCj.put(str, zza);
            return this;
        }

        public zzb zzq(com.google.android.gms.internal.zzd.zza zza) {
            this.zzaAo = zza;
            return this;
        }

        public zza zzuw() {
            return new zza(this.zzaCj, this.zzaAo);
        }
    }

    public static class zzc {
        private final String zzYw;
        private final List<zze> zzaCk;
        private final Map<String, List<zza>> zzaCl;
        private final int zzaCm;

        private zzc(List<zze> list, Map<String, List<zza>> map, String str, int i) {
            this.zzaCk = Collections.unmodifiableList(list);
            this.zzaCl = Collections.unmodifiableMap(map);
            this.zzYw = str;
            this.zzaCm = i;
        }

        public static zzd zzux() {
            return new zzd();
        }

        public String getVersion() {
            return this.zzYw;
        }

        public String toString() {
            return "Rules: " + zzuy() + "  Macros: " + this.zzaCl;
        }

        public List<zze> zzuy() {
            return this.zzaCk;
        }

        public Map<String, List<zza>> zzuz() {
            return this.zzaCl;
        }
    }

    public static class zzd {
        private String zzYw;
        private final List<zze> zzaCk;
        private final Map<String, List<zza>> zzaCl;
        private int zzaCm;

        private zzd() {
            this.zzaCk = new ArrayList();
            this.zzaCl = new HashMap();
            this.zzYw = "";
            this.zzaCm = 0;
        }

        public zzd zzb(zze zze) {
            this.zzaCk.add(zze);
            return this;
        }

        public zzd zzc(zza zza) {
            String zzg = zzde.zzg((com.google.android.gms.internal.zzd.zza) zza.zzuv().get(zzb.INSTANCE_NAME.toString()));
            List list = (List) this.zzaCl.get(zzg);
            if (list == null) {
                list = new ArrayList();
                this.zzaCl.put(zzg, list);
            }
            list.add(zza);
            return this;
        }

        public zzd zzdy(String str) {
            this.zzYw = str;
            return this;
        }

        public zzd zzhk(int i) {
            this.zzaCm = i;
            return this;
        }

        public zzc zzuA() {
            return new zzc(this.zzaCk, this.zzaCl, this.zzYw, this.zzaCm);
        }
    }

    public static class zze {
        private final List<zza> zzaCn;
        private final List<zza> zzaCo;
        private final List<zza> zzaCp;
        private final List<zza> zzaCq;
        private final List<zza> zzaCr;
        private final List<zza> zzaCs;
        private final List<String> zzaCt;
        private final List<String> zzaCu;
        private final List<String> zzaCv;
        private final List<String> zzaCw;

        private zze(List<zza> list, List<zza> list2, List<zza> list3, List<zza> list4, List<zza> list5, List<zza> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.zzaCn = Collections.unmodifiableList(list);
            this.zzaCo = Collections.unmodifiableList(list2);
            this.zzaCp = Collections.unmodifiableList(list3);
            this.zzaCq = Collections.unmodifiableList(list4);
            this.zzaCr = Collections.unmodifiableList(list5);
            this.zzaCs = Collections.unmodifiableList(list6);
            this.zzaCt = Collections.unmodifiableList(list7);
            this.zzaCu = Collections.unmodifiableList(list8);
            this.zzaCv = Collections.unmodifiableList(list9);
            this.zzaCw = Collections.unmodifiableList(list10);
        }

        public static zzf zzuB() {
            return new zzf();
        }

        public String toString() {
            return "Positive predicates: " + zzuC() + "  Negative predicates: " + zzuD() + "  Add tags: " + zzuE() + "  Remove tags: " + zzuF() + "  Add macros: " + zzuG() + "  Remove macros: " + zzuL();
        }

        public List<zza> zzuC() {
            return this.zzaCn;
        }

        public List<zza> zzuD() {
            return this.zzaCo;
        }

        public List<zza> zzuE() {
            return this.zzaCp;
        }

        public List<zza> zzuF() {
            return this.zzaCq;
        }

        public List<zza> zzuG() {
            return this.zzaCr;
        }

        public List<String> zzuH() {
            return this.zzaCt;
        }

        public List<String> zzuI() {
            return this.zzaCu;
        }

        public List<String> zzuJ() {
            return this.zzaCv;
        }

        public List<String> zzuK() {
            return this.zzaCw;
        }

        public List<zza> zzuL() {
            return this.zzaCs;
        }
    }

    public static class zzf {
        private final List<zza> zzaCn;
        private final List<zza> zzaCo;
        private final List<zza> zzaCp;
        private final List<zza> zzaCq;
        private final List<zza> zzaCr;
        private final List<zza> zzaCs;
        private final List<String> zzaCt;
        private final List<String> zzaCu;
        private final List<String> zzaCv;
        private final List<String> zzaCw;

        private zzf() {
            this.zzaCn = new ArrayList();
            this.zzaCo = new ArrayList();
            this.zzaCp = new ArrayList();
            this.zzaCq = new ArrayList();
            this.zzaCr = new ArrayList();
            this.zzaCs = new ArrayList();
            this.zzaCt = new ArrayList();
            this.zzaCu = new ArrayList();
            this.zzaCv = new ArrayList();
            this.zzaCw = new ArrayList();
        }

        public zzf zzd(zza zza) {
            this.zzaCn.add(zza);
            return this;
        }

        public zzf zzdA(String str) {
            this.zzaCw.add(str);
            return this;
        }

        public zzf zzdB(String str) {
            this.zzaCt.add(str);
            return this;
        }

        public zzf zzdC(String str) {
            this.zzaCu.add(str);
            return this;
        }

        public zzf zzdz(String str) {
            this.zzaCv.add(str);
            return this;
        }

        public zzf zze(zza zza) {
            this.zzaCo.add(zza);
            return this;
        }

        public zzf zzf(zza zza) {
            this.zzaCp.add(zza);
            return this;
        }

        public zzf zzg(zza zza) {
            this.zzaCq.add(zza);
            return this;
        }

        public zzf zzh(zza zza) {
            this.zzaCr.add(zza);
            return this;
        }

        public zzf zzi(zza zza) {
            this.zzaCs.add(zza);
            return this;
        }

        public zze zzuM() {
            return new zze(this.zzaCn, this.zzaCo, this.zzaCp, this.zzaCq, this.zzaCr, this.zzaCs, this.zzaCt, this.zzaCu, this.zzaCv, this.zzaCw);
        }
    }

    public static class zzg extends Exception {
        public zzg(String str) {
            super(str);
        }
    }

    private static com.google.android.gms.internal.zzd.zza zza(int i, com.google.android.gms.internal.zzc.zzf zzf, com.google.android.gms.internal.zzd.zza[] zzaArr, Set<Integer> set) throws zzg {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            zzdw("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        com.google.android.gms.internal.zzd.zza zza = (com.google.android.gms.internal.zzd.zza) zza(zzf.zzfG, i, "values");
        if (zzaArr[i] != null) {
            return zzaArr[i];
        }
        com.google.android.gms.internal.zzd.zza zza2 = null;
        set.add(Integer.valueOf(i));
        zzh zzp;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (zza.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                zza2 = zza;
                break;
            case 2:
                zzp = zzp(zza);
                zza2 = zzo(zza);
                zza2.zzgw = new com.google.android.gms.internal.zzd.zza[zzp.zzgh.length];
                iArr = zzp.zzgh;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    zza2.zzgw[i3] = zza(iArr[i2], zzf, zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                zza2 = zzo(zza);
                zzh zzp2 = zzp(zza);
                if (zzp2.zzgi.length != zzp2.zzgj.length) {
                    zzdw("Uneven map keys (" + zzp2.zzgi.length + ") and map values (" + zzp2.zzgj.length + ")");
                }
                zza2.zzgx = new com.google.android.gms.internal.zzd.zza[zzp2.zzgi.length];
                zza2.zzgy = new com.google.android.gms.internal.zzd.zza[zzp2.zzgi.length];
                int[] iArr2 = zzp2.zzgi;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    zza2.zzgx[i4] = zza(iArr2[i3], zzf, zzaArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = zzp2.zzgj;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    zza2.zzgy[i3] = zza(iArr[i2], zzf, zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                zza2 = zzo(zza);
                zza2.zzgz = zzde.zzg(zza(zzp(zza).zzgm, zzf, zzaArr, (Set) set));
                break;
            case 7:
                zza2 = zzo(zza);
                zzp = zzp(zza);
                zza2.zzgD = new com.google.android.gms.internal.zzd.zza[zzp.zzgl.length];
                iArr = zzp.zzgl;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    zza2.zzgD[i3] = zza(iArr[i2], zzf, zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (zza2 == null) {
            zzdw("Invalid value: " + zza);
        }
        zzaArr[i] = zza2;
        set.remove(Integer.valueOf(i));
        return zza2;
    }

    private static zza zza(com.google.android.gms.internal.zzc.zzb zzb, com.google.android.gms.internal.zzc.zzf zzf, com.google.android.gms.internal.zzd.zza[] zzaArr, int i) throws zzg {
        zzb zzuu = zza.zzuu();
        for (int valueOf : zzb.zzfq) {
            com.google.android.gms.internal.zzc.zze zze = (com.google.android.gms.internal.zzc.zze) zza(zzf.zzfH, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) zza(zzf.zzfF, zze.key, "keys");
            com.google.android.gms.internal.zzd.zza zza = (com.google.android.gms.internal.zzd.zza) zza(zzaArr, zze.value, "values");
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzuu.zzq(zza);
            } else {
                zzuu.zzb(str, zza);
            }
        }
        return zzuu.zzuw();
    }

    private static zze zza(com.google.android.gms.internal.zzc.zzg zzg, List<zza> list, List<zza> list2, List<zza> list3, com.google.android.gms.internal.zzc.zzf zzf) {
        zzf zzuB = zze.zzuB();
        for (int valueOf : zzg.zzfV) {
            zzuB.zzd((zza) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : zzg.zzfW) {
            zzuB.zze((zza) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : zzg.zzfX) {
            zzuB.zzf((zza) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : zzg.zzfZ) {
            zzuB.zzdz(zzf.zzfG[Integer.valueOf(valueOf3).intValue()].zzgv);
        }
        for (int valueOf222 : zzg.zzfY) {
            zzuB.zzg((zza) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : zzg.zzga) {
            zzuB.zzdA(zzf.zzfG[Integer.valueOf(valueOf32).intValue()].zzgv);
        }
        for (int valueOf2222 : zzg.zzgb) {
            zzuB.zzh((zza) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : zzg.zzgd) {
            zzuB.zzdB(zzf.zzfG[Integer.valueOf(valueOf322).intValue()].zzgv);
        }
        for (int valueOf22222 : zzg.zzgc) {
            zzuB.zzi((zza) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : zzg.zzge) {
            zzuB.zzdC(zzf.zzfG[Integer.valueOf(valueOf4).intValue()].zzgv);
        }
        return zzuB.zzuM();
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzg {
        if (i < 0 || i >= tArr.length) {
            zzdw("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static zzc zzb(com.google.android.gms.internal.zzc.zzf zzf) throws zzg {
        int i;
        int i2 = 0;
        com.google.android.gms.internal.zzd.zza[] zzaArr = new com.google.android.gms.internal.zzd.zza[zzf.zzfG.length];
        for (i = 0; i < zzf.zzfG.length; i++) {
            zza(i, zzf, zzaArr, new HashSet(0));
        }
        zzd zzux = zzc.zzux();
        List arrayList = new ArrayList();
        for (i = 0; i < zzf.zzfJ.length; i++) {
            arrayList.add(zza(zzf.zzfJ[i], zzf, zzaArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < zzf.zzfK.length; i++) {
            arrayList2.add(zza(zzf.zzfK[i], zzf, zzaArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < zzf.zzfI.length; i++) {
            zza zza = zza(zzf.zzfI[i], zzf, zzaArr, i);
            zzux.zzc(zza);
            arrayList3.add(zza);
        }
        com.google.android.gms.internal.zzc.zzg[] zzgArr = zzf.zzfL;
        int length = zzgArr.length;
        while (i2 < length) {
            zzux.zzb(zza(zzgArr[i2], arrayList, arrayList3, arrayList2, zzf));
            i2++;
        }
        zzux.zzdy(zzf.version);
        zzux.zzhk(zzf.zzfT);
        return zzux.zzuA();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void zzdw(String str) throws zzg {
        zzbf.zzZ(str);
        throw new zzg(str);
    }

    public static com.google.android.gms.internal.zzd.zza zzo(com.google.android.gms.internal.zzd.zza zza) {
        com.google.android.gms.internal.zzd.zza zza2 = new com.google.android.gms.internal.zzd.zza();
        zza2.type = zza.type;
        zza2.zzgE = (int[]) zza.zzgE.clone();
        if (zza.zzgF) {
            zza2.zzgF = zza.zzgF;
        }
        return zza2;
    }

    private static zzh zzp(com.google.android.gms.internal.zzd.zza zza) throws zzg {
        if (((zzh) zza.zza(zzh.zzgf)) == null) {
            zzdw("Expected a ServingValue and didn't get one. Value is: " + zza);
        }
        return (zzh) zza.zza(zzh.zzgf);
    }
}
