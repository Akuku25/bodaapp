package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.zzc.zzi;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzvl.zze;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzco {
    private static final zzbv<com.google.android.gms.internal.zzd.zza> zzazW = new zzbv(zzde.zzuf(), true);
    private final Map<String, zzaj> zzaAa;
    private final Map<String, zzaj> zzaAb;
    private final zzk<com.google.android.gms.internal.zzvl.zza, zzbv<com.google.android.gms.internal.zzd.zza>> zzaAc;
    private final zzk<String, zzb> zzaAd;
    private final Set<zze> zzaAe;
    private final Map<String, zzc> zzaAf;
    private volatile String zzaAg;
    private int zzaAh;
    private final DataLayer zzaxx;
    private final com.google.android.gms.internal.zzvl.zzc zzazX;
    private final zzag zzazY;
    private final Map<String, zzaj> zzazZ;

    interface zza {
        void zza(zze zze, Set<com.google.android.gms.internal.zzvl.zza> set, Set<com.google.android.gms.internal.zzvl.zza> set2, zzcj zzcj);
    }

    private static class zzb {
        private zzbv<com.google.android.gms.internal.zzd.zza> zzaAn;
        private com.google.android.gms.internal.zzd.zza zzaAo;

        public zzb(zzbv<com.google.android.gms.internal.zzd.zza> zzbv, com.google.android.gms.internal.zzd.zza zza) {
            this.zzaAn = zzbv;
            this.zzaAo = zza;
        }

        public int getSize() {
            return (this.zzaAo == null ? 0 : this.zzaAo.zzvX()) + ((com.google.android.gms.internal.zzd.zza) this.zzaAn.getObject()).zzvX();
        }

        public zzbv<com.google.android.gms.internal.zzd.zza> zztJ() {
            return this.zzaAn;
        }

        public com.google.android.gms.internal.zzd.zza zztK() {
            return this.zzaAo;
        }
    }

    private static class zzc {
        private final Set<zze> zzaAe = new HashSet();
        private final Map<zze, List<com.google.android.gms.internal.zzvl.zza>> zzaAp = new HashMap();
        private final Map<zze, List<com.google.android.gms.internal.zzvl.zza>> zzaAq = new HashMap();
        private final Map<zze, List<String>> zzaAr = new HashMap();
        private final Map<zze, List<String>> zzaAs = new HashMap();
        private com.google.android.gms.internal.zzvl.zza zzaAt;

        public void zza(zze zze) {
            this.zzaAe.add(zze);
        }

        public void zza(zze zze, com.google.android.gms.internal.zzvl.zza zza) {
            List list = (List) this.zzaAp.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaAp.put(zze, list);
            }
            list.add(zza);
        }

        public void zza(zze zze, String str) {
            List list = (List) this.zzaAr.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaAr.put(zze, list);
            }
            list.add(str);
        }

        public void zzb(com.google.android.gms.internal.zzvl.zza zza) {
            this.zzaAt = zza;
        }

        public void zzb(zze zze, com.google.android.gms.internal.zzvl.zza zza) {
            List list = (List) this.zzaAq.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaAq.put(zze, list);
            }
            list.add(zza);
        }

        public void zzb(zze zze, String str) {
            List list = (List) this.zzaAs.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaAs.put(zze, list);
            }
            list.add(str);
        }

        public Set<zze> zztL() {
            return this.zzaAe;
        }

        public Map<zze, List<com.google.android.gms.internal.zzvl.zza>> zztM() {
            return this.zzaAp;
        }

        public Map<zze, List<String>> zztN() {
            return this.zzaAr;
        }

        public Map<zze, List<String>> zztO() {
            return this.zzaAs;
        }

        public Map<zze, List<com.google.android.gms.internal.zzvl.zza>> zztP() {
            return this.zzaAq;
        }

        public com.google.android.gms.internal.zzvl.zza zztQ() {
            return this.zzaAt;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzco$1 */
    class C03981 implements com.google.android.gms.tagmanager.zzl.zza<com.google.android.gms.internal.zzvl.zza, zzbv<com.google.android.gms.internal.zzd.zza>> {
        final /* synthetic */ zzco zzaAi;

        C03981(zzco zzco) {
            this.zzaAi = zzco;
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return zza((com.google.android.gms.internal.zzvl.zza) x0, (zzbv) x1);
        }

        public int zza(com.google.android.gms.internal.zzvl.zza zza, zzbv<com.google.android.gms.internal.zzd.zza> zzbv) {
            return ((com.google.android.gms.internal.zzd.zza) zzbv.getObject()).zzvX();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzco$2 */
    class C03992 implements com.google.android.gms.tagmanager.zzl.zza<String, zzb> {
        final /* synthetic */ zzco zzaAi;

        C03992(zzco zzco) {
            this.zzaAi = zzco;
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return zza((String) x0, (zzb) x1);
        }

        public int zza(String str, zzb zzb) {
            return str.length() + zzb.getSize();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzco$4 */
    class C04014 implements zza {
        final /* synthetic */ zzco zzaAi;

        C04014(zzco zzco) {
            this.zzaAi = zzco;
        }

        public void zza(zze zze, Set<com.google.android.gms.internal.zzvl.zza> set, Set<com.google.android.gms.internal.zzvl.zza> set2, zzcj zzcj) {
            set.addAll(zze.zzuE());
            set2.addAll(zze.zzuF());
            zzcj.zztq().zzc(zze.zzuE(), zze.zzuJ());
            zzcj.zztr().zzc(zze.zzuF(), zze.zzuK());
        }
    }

    public zzco(Context context, com.google.android.gms.internal.zzvl.zzc zzc, DataLayer dataLayer, com.google.android.gms.tagmanager.zzs.zza zza, com.google.android.gms.tagmanager.zzs.zza zza2, zzag zzag) {
        if (zzc == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.zzazX = zzc;
        this.zzaAe = new HashSet(zzc.zzuy());
        this.zzaxx = dataLayer;
        this.zzazY = zzag;
        this.zzaAc = new zzl().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C03981(this));
        this.zzaAd = new zzl().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C03992(this));
        this.zzazZ = new HashMap();
        zzb(new zzi(context));
        zzb(new zzs(zza2));
        zzb(new zzw(dataLayer));
        zzb(new zzdf(context, dataLayer));
        zzb(new zzda(context, dataLayer));
        this.zzaAa = new HashMap();
        zzc(new zzq());
        zzc(new zzad());
        zzc(new zzae());
        zzc(new zzal());
        zzc(new zzam());
        zzc(new zzbb());
        zzc(new zzbc());
        zzc(new zzce());
        zzc(new zzcx());
        this.zzaAb = new HashMap();
        zza(new zzb(context));
        zza(new zzc(context));
        zza(new zze(context));
        zza(new zzf(context));
        zza(new zzg(context));
        zza(new zzh(context));
        zza(new zzm());
        zza(new zzp(this.zzazX.getVersion()));
        zza(new zzs(zza));
        zza(new zzu(dataLayer));
        zza(new zzz(context));
        zza(new zzaa());
        zza(new zzac());
        zza(new zzah(this));
        zza(new zzan());
        zza(new zzao());
        zza(new zzav(context));
        zza(new zzax());
        zza(new zzba());
        zza(new zzbh());
        zza(new zzbj(context));
        zza(new zzbw());
        zza(new zzby());
        zza(new zzcb());
        zza(new zzcd());
        zza(new zzcf(context));
        zza(new zzcp());
        zza(new zzcq());
        zza(new zzcz());
        zza(new zzdg());
        this.zzaAf = new HashMap();
        for (zze zze : this.zzaAe) {
            if (zzag.zztg()) {
                zza(zze.zzuG(), zze.zzuH(), "add macro");
                zza(zze.zzuL(), zze.zzuI(), "remove macro");
                zza(zze.zzuE(), zze.zzuJ(), "add tag");
                zza(zze.zzuF(), zze.zzuK(), "remove tag");
            }
            int i = 0;
            while (i < zze.zzuG().size()) {
                com.google.android.gms.internal.zzvl.zza zza3 = (com.google.android.gms.internal.zzvl.zza) zze.zzuG().get(i);
                String str = "Unknown";
                if (zzag.zztg() && i < zze.zzuH().size()) {
                    str = (String) zze.zzuH().get(i);
                }
                zzc zze2 = zze(this.zzaAf, zza(zza3));
                zze2.zza(zze);
                zze2.zza(zze, zza3);
                zze2.zza(zze, str);
                i++;
            }
            i = 0;
            while (i < zze.zzuL().size()) {
                zza3 = (com.google.android.gms.internal.zzvl.zza) zze.zzuL().get(i);
                str = "Unknown";
                if (zzag.zztg() && i < zze.zzuI().size()) {
                    str = (String) zze.zzuI().get(i);
                }
                zze2 = zze(this.zzaAf, zza(zza3));
                zze2.zza(zze);
                zze2.zzb(zze, zza3);
                zze2.zzb(zze, str);
                i++;
            }
        }
        for (Entry entry : this.zzazX.zzuz().entrySet()) {
            for (com.google.android.gms.internal.zzvl.zza zza32 : (List) entry.getValue()) {
                if (!zzde.zzk((com.google.android.gms.internal.zzd.zza) zza32.zzuv().get(com.google.android.gms.internal.zzb.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    zze(this.zzaAf, (String) entry.getKey()).zzb(zza32);
                }
            }
        }
    }

    private zzbv<com.google.android.gms.internal.zzd.zza> zza(com.google.android.gms.internal.zzd.zza zza, Set<String> set, zzdh zzdh) {
        if (!zza.zzgF) {
            return new zzbv(zza, true);
        }
        com.google.android.gms.internal.zzd.zza zzo;
        int i;
        zzbv zza2;
        switch (zza.type) {
            case 2:
                zzo = zzvl.zzo(zza);
                zzo.zzgw = new com.google.android.gms.internal.zzd.zza[zza.zzgw.length];
                for (i = 0; i < zza.zzgw.length; i++) {
                    zza2 = zza(zza.zzgw[i], (Set) set, zzdh.zzhf(i));
                    if (zza2 == zzazW) {
                        return zzazW;
                    }
                    zzo.zzgw[i] = (com.google.android.gms.internal.zzd.zza) zza2.getObject();
                }
                return new zzbv(zzo, false);
            case 3:
                zzo = zzvl.zzo(zza);
                if (zza.zzgx.length != zza.zzgy.length) {
                    zzbf.zzZ("Invalid serving value: " + zza.toString());
                    return zzazW;
                }
                zzo.zzgx = new com.google.android.gms.internal.zzd.zza[zza.zzgx.length];
                zzo.zzgy = new com.google.android.gms.internal.zzd.zza[zza.zzgx.length];
                for (i = 0; i < zza.zzgx.length; i++) {
                    zza2 = zza(zza.zzgx[i], (Set) set, zzdh.zzhg(i));
                    zzbv zza3 = zza(zza.zzgy[i], (Set) set, zzdh.zzhh(i));
                    if (zza2 == zzazW || zza3 == zzazW) {
                        return zzazW;
                    }
                    zzo.zzgx[i] = (com.google.android.gms.internal.zzd.zza) zza2.getObject();
                    zzo.zzgy[i] = (com.google.android.gms.internal.zzd.zza) zza3.getObject();
                }
                return new zzbv(zzo, false);
            case 4:
                if (set.contains(zza.zzgz)) {
                    zzbf.zzZ("Macro cycle detected.  Current macro reference: " + zza.zzgz + "." + "  Previous macro references: " + set.toString() + ".");
                    return zzazW;
                }
                set.add(zza.zzgz);
                zzbv<com.google.android.gms.internal.zzd.zza> zza4 = zzdi.zza(zza(zza.zzgz, (Set) set, zzdh.zztt()), zza.zzgE);
                set.remove(zza.zzgz);
                return zza4;
            case 7:
                zzo = zzvl.zzo(zza);
                zzo.zzgD = new com.google.android.gms.internal.zzd.zza[zza.zzgD.length];
                for (i = 0; i < zza.zzgD.length; i++) {
                    zza2 = zza(zza.zzgD[i], (Set) set, zzdh.zzhi(i));
                    if (zza2 == zzazW) {
                        return zzazW;
                    }
                    zzo.zzgD[i] = (com.google.android.gms.internal.zzd.zza) zza2.getObject();
                }
                return new zzbv(zzo, false);
            default:
                zzbf.zzZ("Unknown type: " + zza.type);
                return zzazW;
        }
    }

    private zzbv<com.google.android.gms.internal.zzd.zza> zza(String str, Set<String> set, zzbi zzbi) {
        this.zzaAh++;
        zzb zzb = (zzb) this.zzaAd.get(str);
        if (zzb == null || this.zzazY.zztg()) {
            zzc zzc = (zzc) this.zzaAf.get(str);
            if (zzc == null) {
                zzbf.zzZ(zztI() + "Invalid macro: " + str);
                this.zzaAh--;
                return zzazW;
            }
            com.google.android.gms.internal.zzvl.zza zztQ;
            zzbv zza = zza(str, zzc.zztL(), zzc.zztM(), zzc.zztN(), zzc.zztP(), zzc.zztO(), set, zzbi.zzsX());
            if (((Set) zza.getObject()).isEmpty()) {
                zztQ = zzc.zztQ();
            } else {
                if (((Set) zza.getObject()).size() > 1) {
                    zzbf.zzac(zztI() + "Multiple macros active for macroName " + str);
                }
                zztQ = (com.google.android.gms.internal.zzvl.zza) ((Set) zza.getObject()).iterator().next();
            }
            if (zztQ == null) {
                this.zzaAh--;
                return zzazW;
            }
            zzbv zza2 = zza(this.zzaAb, zztQ, (Set) set, zzbi.zztl());
            boolean z = zza.zztu() && zza2.zztu();
            zzbv<com.google.android.gms.internal.zzd.zza> zzbv = zza2 == zzazW ? zzazW : new zzbv(zza2.getObject(), z);
            com.google.android.gms.internal.zzd.zza zztK = zztQ.zztK();
            if (zzbv.zztu()) {
                this.zzaAd.zze(str, new zzb(zzbv, zztK));
            }
            zza(zztK, (Set) set);
            this.zzaAh--;
            return zzbv;
        }
        zza(zzb.zztK(), (Set) set);
        this.zzaAh--;
        return zzb.zztJ();
    }

    private zzbv<com.google.android.gms.internal.zzd.zza> zza(Map<String, zzaj> map, com.google.android.gms.internal.zzvl.zza zza, Set<String> set, zzcg zzcg) {
        boolean z = true;
        com.google.android.gms.internal.zzd.zza zza2 = (com.google.android.gms.internal.zzd.zza) zza.zzuv().get(com.google.android.gms.internal.zzb.FUNCTION.toString());
        if (zza2 == null) {
            zzbf.zzZ("No function id in properties");
            return zzazW;
        }
        String str = zza2.zzgA;
        zzaj zzaj = (zzaj) map.get(str);
        if (zzaj == null) {
            zzbf.zzZ(str + " has no backing implementation.");
            return zzazW;
        }
        zzbv<com.google.android.gms.internal.zzd.zza> zzbv = (zzbv) this.zzaAc.get(zza);
        if (zzbv != null && !this.zzazY.zztg()) {
            return zzbv;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : zza.zzuv().entrySet()) {
            zzbv zza3 = zza((com.google.android.gms.internal.zzd.zza) entry.getValue(), (Set) set, zzcg.zzde((String) entry.getKey()).zze((com.google.android.gms.internal.zzd.zza) entry.getValue()));
            if (zza3 == zzazW) {
                return zzazW;
            }
            boolean z3;
            if (zza3.zztu()) {
                zza.zza((String) entry.getKey(), (com.google.android.gms.internal.zzd.zza) zza3.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), zza3.getObject());
            z2 = z3;
        }
        if (zzaj.zzb(hashMap.keySet())) {
            if (!(z2 && zzaj.zzsD())) {
                z = false;
            }
            zzbv = new zzbv(zzaj.zzH(hashMap), z);
            if (z) {
                this.zzaAc.zze(zza, zzbv);
            }
            zzcg.zzd((com.google.android.gms.internal.zzd.zza) zzbv.getObject());
            return zzbv;
        }
        zzbf.zzZ("Incorrect keys for function " + str + " required " + zzaj.zzti() + " had " + hashMap.keySet());
        return zzazW;
    }

    private zzbv<Set<com.google.android.gms.internal.zzvl.zza>> zza(Set<zze> set, Set<String> set2, zza zza, zzcn zzcn) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (zze zze : set) {
            zzcj zzts = zzcn.zzts();
            zzbv zza2 = zza(zze, (Set) set2, zzts);
            if (((Boolean) zza2.getObject()).booleanValue()) {
                zza.zza(zze, hashSet, hashSet2, zzts);
            }
            boolean z2 = z && zza2.zztu();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        zzcn.zzc(hashSet);
        return new zzbv(hashSet, z);
    }

    private static String zza(com.google.android.gms.internal.zzvl.zza zza) {
        return zzde.zzg((com.google.android.gms.internal.zzd.zza) zza.zzuv().get(com.google.android.gms.internal.zzb.INSTANCE_NAME.toString()));
    }

    private void zza(com.google.android.gms.internal.zzd.zza zza, Set<String> set) {
        if (zza != null) {
            zzbv zza2 = zza(zza, (Set) set, new zzbt());
            if (zza2 != zzazW) {
                Object zzl = zzde.zzl((com.google.android.gms.internal.zzd.zza) zza2.getObject());
                if (zzl instanceof Map) {
                    this.zzaxx.push((Map) zzl);
                } else if (zzl instanceof List) {
                    for (Object zzl2 : (List) zzl2) {
                        if (zzl2 instanceof Map) {
                            this.zzaxx.push((Map) zzl2);
                        } else {
                            zzbf.zzac("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    zzbf.zzac("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void zza(List<com.google.android.gms.internal.zzvl.zza> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            zzbf.zzaa("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void zza(Map<String, zzaj> map, zzaj zzaj) {
        if (map.containsKey(zzaj.zzth())) {
            throw new IllegalArgumentException("Duplicate function type name: " + zzaj.zzth());
        }
        map.put(zzaj.zzth(), zzaj);
    }

    private static zzc zze(Map<String, zzc> map, String str) {
        zzc zzc = (zzc) map.get(str);
        if (zzc != null) {
            return zzc;
        }
        zzc = new zzc();
        map.put(str, zzc);
        return zzc;
    }

    private String zztI() {
        if (this.zzaAh <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.zzaAh));
        for (int i = 2; i < this.zzaAh; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    zzbv<Boolean> zza(com.google.android.gms.internal.zzvl.zza zza, Set<String> set, zzcg zzcg) {
        zzbv zza2 = zza(this.zzaAa, zza, (Set) set, zzcg);
        Boolean zzk = zzde.zzk((com.google.android.gms.internal.zzd.zza) zza2.getObject());
        zzcg.zzd(zzde.zzx(zzk));
        return new zzbv(zzk, zza2.zztu());
    }

    zzbv<Boolean> zza(zze zze, Set<String> set, zzcj zzcj) {
        boolean z = true;
        for (com.google.android.gms.internal.zzvl.zza zza : zze.zzuD()) {
            zzbv zza2 = zza(zza, (Set) set, zzcj.zztm());
            if (((Boolean) zza2.getObject()).booleanValue()) {
                zzcj.zzf(zzde.zzx(Boolean.valueOf(false)));
                return new zzbv(Boolean.valueOf(false), zza2.zztu());
            }
            boolean z2 = z && zza2.zztu();
            z = z2;
        }
        for (com.google.android.gms.internal.zzvl.zza zza3 : zze.zzuC()) {
            zza2 = zza(zza3, (Set) set, zzcj.zztn());
            if (((Boolean) zza2.getObject()).booleanValue()) {
                z = z && zza2.zztu();
            } else {
                zzcj.zzf(zzde.zzx(Boolean.valueOf(false)));
                return new zzbv(Boolean.valueOf(false), zza2.zztu());
            }
        }
        zzcj.zzf(zzde.zzx(Boolean.valueOf(true)));
        return new zzbv(Boolean.valueOf(true), z);
    }

    zzbv<Set<com.google.android.gms.internal.zzvl.zza>> zza(String str, Set<zze> set, Map<zze, List<com.google.android.gms.internal.zzvl.zza>> map, Map<zze, List<String>> map2, Map<zze, List<com.google.android.gms.internal.zzvl.zza>> map3, Map<zze, List<String>> map4, Set<String> set2, zzcn zzcn) {
        final Map<zze, List<com.google.android.gms.internal.zzvl.zza>> map5 = map;
        final Map<zze, List<String>> map6 = map2;
        final Map<zze, List<com.google.android.gms.internal.zzvl.zza>> map7 = map3;
        final Map<zze, List<String>> map8 = map4;
        return zza((Set) set, (Set) set2, new zza(this) {
            final /* synthetic */ zzco zzaAi;

            public void zza(zze zze, Set<com.google.android.gms.internal.zzvl.zza> set, Set<com.google.android.gms.internal.zzvl.zza> set2, zzcj zzcj) {
                List list = (List) map5.get(zze);
                List list2 = (List) map6.get(zze);
                if (list != null) {
                    set.addAll(list);
                    zzcj.zzto().zzc(list, list2);
                }
                list = (List) map7.get(zze);
                list2 = (List) map8.get(zze);
                if (list != null) {
                    set2.addAll(list);
                    zzcj.zztp().zzc(list, list2);
                }
            }
        }, zzcn);
    }

    zzbv<Set<com.google.android.gms.internal.zzvl.zza>> zza(Set<zze> set, zzcn zzcn) {
        return zza((Set) set, new HashSet(), new C04014(this), zzcn);
    }

    void zza(zzaj zzaj) {
        zza(this.zzaAb, zzaj);
    }

    void zzb(zzaj zzaj) {
        zza(this.zzazZ, zzaj);
    }

    void zzc(zzaj zzaj) {
        zza(this.zzaAa, zzaj);
    }

    public synchronized void zzcO(String str) {
        zzdj(str);
        zzaf zzda = this.zzazY.zzda(str);
        zzt zzte = zzda.zzte();
        for (com.google.android.gms.internal.zzvl.zza zza : (Set) zza(this.zzaAe, zzte.zzsX()).getObject()) {
            zza(this.zzazZ, zza, new HashSet(), zzte.zzsW());
        }
        zzda.zztf();
        zzdj(null);
    }

    public zzbv<com.google.android.gms.internal.zzd.zza> zzdi(String str) {
        this.zzaAh = 0;
        zzaf zzcZ = this.zzazY.zzcZ(str);
        zzbv<com.google.android.gms.internal.zzd.zza> zza = zza(str, new HashSet(), zzcZ.zztd());
        zzcZ.zztf();
        return zza;
    }

    synchronized void zzdj(String str) {
        this.zzaAg = str;
    }

    synchronized String zztH() {
        return this.zzaAg;
    }

    public synchronized void zzu(List<zzi> list) {
        for (zzi zzi : list) {
            if (zzi.name == null || !zzi.name.startsWith("gaExperiment:")) {
                zzbf.zzab("Ignored supplemental: " + zzi);
            } else {
                zzai.zza(this.zzaxx, zzi);
            }
        }
    }
}
