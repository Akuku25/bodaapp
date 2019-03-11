package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.internal.zzmk;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzSv = new MetadataChangeSet(MetadataBundle.zzkZ());
    private final MetadataBundle zzSw;

    public static class Builder {
        private final MetadataBundle zzSw = MetadataBundle.zzkZ();
        private zza zzSx;

        private int zzbw(String str) {
            return str == null ? 0 : str.getBytes().length;
        }

        private String zzi(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        private void zzj(String str, int i, int i2) {
            zzx.zzb(i2 <= i, zzi(str, i, i2));
        }

        private zza zzky() {
            if (this.zzSx == null) {
                this.zzSx = new zza();
            }
            return this.zzSx;
        }

        public MetadataChangeSet build() {
            if (this.zzSx != null) {
                this.zzSw.zzb(zzmi.zzVu, this.zzSx.zzkW());
            }
            return new MetadataChangeSet(this.zzSw);
        }

        public Builder deleteCustomProperty(CustomPropertyKey key) {
            zzx.zzb((Object) key, (Object) "key");
            zzky().zza(key, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey key, String value) {
            zzx.zzb((Object) key, (Object) "key");
            zzx.zzb((Object) value, (Object) "value");
            zzj("The total size of key string and value string of a custom property", MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, zzbw(key.getKey()) + zzbw(value));
            zzky().zza(key, value);
            return this;
        }

        public Builder setDescription(String description) {
            this.zzSw.zzb(zzmi.zzVv, description);
            return this;
        }

        public Builder setIndexableText(String text) {
            zzj("Indexable text size", 131072, zzbw(text));
            this.zzSw.zzb(zzmi.zzVA, text);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.zzSw.zzb(zzmk.zzWf, date);
            return this;
        }

        public Builder setMimeType(String mimeType) {
            this.zzSw.zzb(zzmi.zzVM, mimeType);
            return this;
        }

        public Builder setPinned(boolean pinned) {
            this.zzSw.zzb(zzmi.zzVF, Boolean.valueOf(pinned));
            return this;
        }

        public Builder setStarred(boolean starred) {
            this.zzSw.zzb(zzmi.zzVT, Boolean.valueOf(starred));
            return this;
        }

        public Builder setTitle(String title) {
            this.zzSw.zzb(zzmi.zzVV, title);
            return this;
        }

        public Builder setViewed(boolean viewed) {
            this.zzSw.zzb(zzmi.zzVL, Boolean.valueOf(viewed));
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle bag) {
        this.zzSw = MetadataBundle.zza(bag);
    }

    public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzSw.zza(zzmi.zzVu);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzkV();
    }

    public String getDescription() {
        return (String) this.zzSw.zza(zzmi.zzVv);
    }

    public String getIndexableText() {
        return (String) this.zzSw.zza(zzmi.zzVA);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.zzSw.zza(zzmk.zzWf);
    }

    public String getMimeType() {
        return (String) this.zzSw.zza(zzmi.zzVM);
    }

    public String getTitle() {
        return (String) this.zzSw.zza(zzmi.zzVV);
    }

    public Boolean isPinned() {
        return (Boolean) this.zzSw.zza(zzmi.zzVF);
    }

    public Boolean isStarred() {
        return (Boolean) this.zzSw.zza(zzmi.zzVT);
    }

    public Boolean isViewed() {
        return (Boolean) this.zzSw.zza(zzmi.zzVL);
    }

    public MetadataBundle zzkx() {
        return this.zzSw;
    }
}
