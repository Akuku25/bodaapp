package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

public final class zzr extends zzd implements DataItem {
    private final int zzadF;

    public zzr(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzadF = i2;
    }

    public /* synthetic */ Object freeze() {
        return zzvj();
    }

    public Map<String, DataItemAsset> getAssets() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.zzadF);
        for (int i = 0; i < this.zzadF; i++) {
            zzn zzn = new zzn(this.zzMd, this.zzNQ + i);
            if (zzn.getDataItemKey() != null) {
                hashMap.put(zzn.getDataItemKey(), zzn);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public DataItem zzvj() {
        return new zzo(this);
    }
}
