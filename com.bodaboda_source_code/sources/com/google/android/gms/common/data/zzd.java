package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzd {
    protected final DataHolder zzMd;
    protected int zzNQ;
    private int zzNR;

    public zzd(DataHolder dataHolder, int i) {
        this.zzMd = (DataHolder) zzx.zzl(dataHolder);
        zzav(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzd)) {
            return false;
        }
        zzd zzd = (zzd) obj;
        return zzw.equal(Integer.valueOf(zzd.zzNQ), Integer.valueOf(this.zzNQ)) && zzw.equal(Integer.valueOf(zzd.zzNR), Integer.valueOf(this.zzNR)) && zzd.zzMd == this.zzMd;
    }

    protected boolean getBoolean(String column) {
        return this.zzMd.zzd(column, this.zzNQ, this.zzNR);
    }

    protected byte[] getByteArray(String column) {
        return this.zzMd.zzf(column, this.zzNQ, this.zzNR);
    }

    protected float getFloat(String column) {
        return this.zzMd.zze(column, this.zzNQ, this.zzNR);
    }

    protected int getInteger(String column) {
        return this.zzMd.zzb(column, this.zzNQ, this.zzNR);
    }

    protected long getLong(String column) {
        return this.zzMd.zza(column, this.zzNQ, this.zzNR);
    }

    protected String getString(String column) {
        return this.zzMd.zzc(column, this.zzNQ, this.zzNR);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzNQ), Integer.valueOf(this.zzNR), this.zzMd);
    }

    public boolean isDataValid() {
        return !this.zzMd.isClosed();
    }

    protected void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.zzMd.zza(str, this.zzNQ, this.zzNR, charArrayBuffer);
    }

    protected void zzav(int i) {
        boolean z = i >= 0 && i < this.zzMd.getCount();
        zzx.zzN(z);
        this.zzNQ = i;
        this.zzNR = this.zzMd.zzax(this.zzNQ);
    }

    public boolean zzba(String str) {
        return this.zzMd.zzba(str);
    }

    protected Uri zzbb(String str) {
        return this.zzMd.zzg(str, this.zzNQ, this.zzNR);
    }

    protected boolean zzbc(String str) {
        return this.zzMd.zzh(str, this.zzNQ, this.zzNR);
    }

    protected int zzix() {
        return this.zzNQ;
    }
}
