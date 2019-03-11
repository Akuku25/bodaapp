package com.google.android.gms.internal;

public abstract class zzki<T> {
    private static zza zzNG = null;
    private static int zzNH = 0;
    private static final Object zzmz = new Object();
    private T zzNI = null;
    protected final String zzqd;
    protected final T zzqe;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zzb(String str, Boolean bool);

        Integer zzb(String str, Integer num);
    }

    protected zzki(String str, T t) {
        this.zzqd = str;
        this.zzqe = t;
    }

    public static boolean isInitialized() {
        return zzNG != null;
    }

    public static zzki<Integer> zza(String str, Integer num) {
        return new zzki<Integer>(str, num) {
            protected /* synthetic */ Object zzaV(String str) {
                return zzaY(str);
            }

            protected Integer zzaY(String str) {
                return zzki.zzNG.zzb(this.zzqd, (Integer) this.zzqe);
            }
        };
    }

    public static zzki<Long> zza(String str, Long l) {
        return new zzki<Long>(str, l) {
            protected /* synthetic */ Object zzaV(String str) {
                return zzaX(str);
            }

            protected Long zzaX(String str) {
                return zzki.zzNG.getLong(this.zzqd, (Long) this.zzqe);
            }
        };
    }

    public static zzki<Boolean> zzg(String str, boolean z) {
        return new zzki<Boolean>(str, Boolean.valueOf(z)) {
            protected /* synthetic */ Object zzaV(String str) {
                return zzaW(str);
            }

            protected Boolean zzaW(String str) {
                return zzki.zzNG.zzb(this.zzqd, (Boolean) this.zzqe);
            }
        };
    }

    public static int zzis() {
        return zzNH;
    }

    public static zzki<String> zzp(String str, String str2) {
        return new zzki<String>(str, str2) {
            protected /* synthetic */ Object zzaV(String str) {
                return zzaZ(str);
            }

            protected String zzaZ(String str) {
                return zzki.zzNG.getString(this.zzqd, (String) this.zzqe);
            }
        };
    }

    public final T get() {
        return this.zzNI != null ? this.zzNI : zzaV(this.zzqd);
    }

    protected abstract T zzaV(String str);
}
