package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.zza;

public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    public static final class Builder {
        private String zzZO;
        private Long zzakE;
        private Long zzakF;
        private zza zzakG;
        private Uri zzakH;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zzZO, this.zzakE, this.zzakG, this.zzakH, this.zzakF);
        }

        public Builder fromMetadata(SnapshotMetadata metadata) {
            this.zzZO = metadata.getDescription();
            this.zzakE = Long.valueOf(metadata.getPlayedTime());
            this.zzakF = Long.valueOf(metadata.getProgressValue());
            if (this.zzakE.longValue() == -1) {
                this.zzakE = null;
            }
            this.zzakH = metadata.getCoverImageUri();
            if (this.zzakH != null) {
                this.zzakG = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap coverImage) {
            this.zzakG = new zza(coverImage);
            this.zzakH = null;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzZO = description;
            return this;
        }

        public Builder setPlayedTimeMillis(long playedTimeMillis) {
            this.zzakE = Long.valueOf(playedTimeMillis);
            return this;
        }

        public Builder setProgressValue(long progressValue) {
            this.zzakF = Long.valueOf(progressValue);
            return this;
        }
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract Long getProgressValue();

    public abstract zza zzpc();
}
