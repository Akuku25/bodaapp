package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;

public final class PendingResults {

    private static final class zza<R extends Result> extends AbstractPendingResult<R> {
        private final R zzNm;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzNm = r;
        }

        protected R createFailedResult(Status status) {
            if (status.getStatusCode() == this.zzNm.getStatus().getStatusCode()) {
                return this.zzNm;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends AbstractPendingResult<R> {
        public zzb() {
            super(Looper.getMainLooper());
        }

        protected R createFailedResult(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        PendingResult zzg = new zzg(Looper.getMainLooper());
        zzg.cancel();
        return zzg;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        zzx.zzb(result.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        PendingResult zza = new zza(result);
        zza.cancel();
        return zza;
    }

    public static <R extends Result> PendingResult<R> immediatePendingResult(R result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        PendingResult zzb = new zzb();
        zzb.setResult(result);
        return zzb;
    }

    public static PendingResult<Status> immediatePendingResult(Status result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        PendingResult zzg = new zzg(Looper.getMainLooper());
        zzg.setResult(result);
        return zzg;
    }
}
