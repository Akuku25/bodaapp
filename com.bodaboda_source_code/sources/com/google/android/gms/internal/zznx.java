package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.BatchCallback;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class zznx<T extends Result> implements PendingResult<T> {
    private final T zzZX;

    zznx(T t) {
        this.zzZX = t;
    }

    public void addBatchCallback(BatchCallback callback) {
        callback.zzl(this.zzZX.getStatus());
    }

    public T await() {
        return this.zzZX;
    }

    public T await(long time, TimeUnit units) {
        return this.zzZX;
    }

    public void cancel() {
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResultCallback(ResultCallback<T> callback) {
        callback.onResult(this.zzZX);
    }

    public void setResultCallback(ResultCallback<T> callback, long time, TimeUnit units) {
        callback.onResult(this.zzZX);
    }
}
