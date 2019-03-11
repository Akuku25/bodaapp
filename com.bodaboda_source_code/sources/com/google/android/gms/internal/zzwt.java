package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzwt<M extends zzws<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzaHC;
    protected final boolean zzaHD;

    private zzwt(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzaHC = cls;
        this.tag = i2;
        this.zzaHD = z;
    }

    @Deprecated
    public static <M extends zzws<M>, T extends zzwy> zzwt<M, T> zza(int i, Class<T> cls, int i2) {
        return new zzwt(i, cls, i2, false);
    }

    private T zzy(List<zzxa> list) {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            zzxa zzxa = (zzxa) list.get(i);
            if (zzxa.zzaHN.length != 0) {
                zza(zzxa, arrayList);
            }
        }
        i = arrayList.size();
        if (i == 0) {
            return null;
        }
        T cast = this.zzaHC.cast(Array.newInstance(this.zzaHC.getComponentType(), i));
        while (i2 < i) {
            Array.set(cast, i2, arrayList.get(i2));
            i2++;
        }
        return cast;
    }

    private T zzz(List<zzxa> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzaHC.cast(zzz(zzwq.zzt(((zzxa) list.get(list.size() - 1)).zzaHN)));
    }

    int zzF(Object obj) {
        return this.zzaHD ? zzG(obj) : zzH(obj);
    }

    protected int zzG(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzH(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected int zzH(Object obj) {
        int zziI = zzxb.zziI(this.tag);
        switch (this.type) {
            case 10:
                return zzwr.zzb(zziI, (zzwy) obj);
            case 11:
                return zzwr.zzc(zziI, (zzwy) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    protected void zza(zzxa zzxa, List<Object> list) {
        list.add(zzz(zzwq.zzt(zzxa.zzaHN)));
    }

    void zza(Object obj, zzwr zzwr) throws IOException {
        if (this.zzaHD) {
            zzc(obj, zzwr);
        } else {
            zzb(obj, zzwr);
        }
    }

    protected void zzb(Object obj, zzwr zzwr) {
        try {
            zzwr.zziA(this.tag);
            switch (this.type) {
                case 10:
                    zzwy zzwy = (zzwy) obj;
                    int zziI = zzxb.zziI(this.tag);
                    zzwr.zzb(zzwy);
                    zzwr.zzC(zziI, 4);
                    return;
                case 11:
                    zzwr.zzc((zzwy) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected void zzc(Object obj, zzwr zzwr) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzwr);
            }
        }
    }

    final T zzx(List<zzxa> list) {
        return list == null ? null : this.zzaHD ? zzy(list) : zzz((List) list);
    }

    protected Object zzz(zzwq zzwq) {
        Class componentType = this.zzaHD ? this.zzaHC.getComponentType() : this.zzaHC;
        try {
            zzwy zzwy;
            switch (this.type) {
                case 10:
                    zzwy = (zzwy) componentType.newInstance();
                    zzwq.zza(zzwy, zzxb.zziI(this.tag));
                    return zzwy;
                case 11:
                    zzwy = (zzwy) componentType.newInstance();
                    zzwq.zza(zzwy);
                    return zzwy;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }
}
