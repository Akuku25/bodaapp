package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzgi
public final class zzhn {
    private static final ThreadFactory zzzk = new C02014();
    private static final ExecutorService zzzl = Executors.newFixedThreadPool(10, zzzk);
    private static final ExecutorService zzzm = Executors.newFixedThreadPool(5, zzzk);

    /* renamed from: com.google.android.gms.internal.zzhn$4 */
    static class C02014 implements ThreadFactory {
        private final AtomicInteger zzzp = new AtomicInteger(1);

        C02014() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.zzzp.getAndIncrement());
        }
    }

    public static <T> Future<T> submit(Callable<T> callable) {
        return zza(zzzl, (Callable) callable);
    }

    public static Future<Void> zza(int i, final Runnable runnable) {
        return i == 1 ? zza(zzzm, new Callable<Void>() {
            public /* synthetic */ Object call() throws Exception {
                return zzer();
            }

            public Void zzer() {
                runnable.run();
                return null;
            }
        }) : zza(zzzl, new Callable<Void>() {
            public /* synthetic */ Object call() throws Exception {
                return zzer();
            }

            public Void zzer() {
                runnable.run();
                return null;
            }
        });
    }

    public static <T> Future<T> zza(ExecutorService executorService, final Callable<T> callable) {
        try {
            return executorService.submit(new Callable<T>() {
                public T call() throws Exception {
                    try {
                        Process.setThreadPriority(10);
                        return callable.call();
                    } catch (Throwable e) {
                        zzab.zzaP().zze(e);
                        throw e;
                    }
                }
            });
        } catch (Throwable e) {
            zzhx.zzd("Thread execution is rejected.", e);
            return new zzhr(null);
        }
    }

    public static Future<Void> zzb(Runnable runnable) {
        return zza(0, runnable);
    }
}
