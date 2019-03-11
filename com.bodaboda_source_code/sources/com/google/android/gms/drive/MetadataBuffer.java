package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzm;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zzmi;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzSt;

    private static class zza extends Metadata {
        private final DataHolder zzMd;
        private final int zzNR;
        private final int zzSu;

        public zza(DataHolder dataHolder, int i) {
            this.zzMd = dataHolder;
            this.zzSu = i;
            this.zzNR = dataHolder.zzax(i);
        }

        public /* synthetic */ Object freeze() {
            return zzkw();
        }

        public boolean isDataValid() {
            return !this.zzMd.isClosed();
        }

        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzMd, this.zzSu, this.zzNR);
        }

        public Metadata zzkw() {
            MetadataBundle zzkZ = MetadataBundle.zzkZ();
            for (MetadataField metadataField : zze.zzkY()) {
                if (metadataField != zzmi.zzVU) {
                    metadataField.zza(this.zzMd, zzkZ, this.zzSu, this.zzNR);
                }
            }
            return new zzm(zzkZ);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zziu().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        zza zza = this.zzSt;
        if (zza != null && zza.zzSu == row) {
            return zza;
        }
        Metadata zza2 = new zza(this.zzMd, row);
        this.zzSt = zza2;
        return zza2;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }
}
