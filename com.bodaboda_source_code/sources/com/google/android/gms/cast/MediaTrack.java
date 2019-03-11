package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzma;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzHf;
    private String zzIO;
    private String zzIQ;
    private String zzIS;
    private JSONObject zzIX;
    private int zzJp;
    private int zzJq;

    public static class Builder {
        private final MediaTrack zzJr;

        public Builder(long trackId, int trackType) throws IllegalArgumentException {
            this.zzJr = new MediaTrack(trackId, trackType);
        }

        public MediaTrack build() {
            return this.zzJr;
        }

        public Builder setContentId(String contentId) {
            this.zzJr.setContentId(contentId);
            return this;
        }

        public Builder setContentType(String contentType) {
            this.zzJr.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzJr.setCustomData(customData);
            return this;
        }

        public Builder setLanguage(String language) {
            this.zzJr.setLanguage(language);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzJr.setLanguage(zzjv.zzb(locale));
            return this;
        }

        public Builder setName(String trackName) {
            this.zzJr.setName(trackName);
            return this;
        }

        public Builder setSubtype(int subtype) throws IllegalArgumentException {
            this.zzJr.zzaf(subtype);
            return this;
        }
    }

    MediaTrack(long id, int type) throws IllegalArgumentException {
        clear();
        this.zzHf = id;
        if (type <= 0 || type > 3) {
            throw new IllegalArgumentException("invalid type " + type);
        }
        this.zzJp = type;
    }

    MediaTrack(JSONObject json) throws JSONException {
        zzd(json);
    }

    private void clear() {
        this.zzHf = 0;
        this.zzJp = 0;
        this.zzIQ = null;
        this.mName = null;
        this.zzIO = null;
        this.zzJq = -1;
        this.zzIX = null;
    }

    private void zzd(JSONObject jSONObject) throws JSONException {
        clear();
        this.zzHf = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzJp = 1;
        } else if ("AUDIO".equals(string)) {
            this.zzJp = 2;
        } else if ("VIDEO".equals(string)) {
            this.zzJp = 3;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.zzIQ = jSONObject.optString("trackContentId", null);
        this.zzIS = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.zzIO = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            string = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string)) {
                this.zzJq = 1;
            } else if ("CAPTIONS".equals(string)) {
                this.zzJq = 2;
            } else if ("DESCRIPTIONS".equals(string)) {
                this.zzJq = 3;
            } else if ("CHAPTERS".equals(string)) {
                this.zzJq = 4;
            } else if ("METADATA".equals(string)) {
                this.zzJq = 5;
            } else {
                throw new JSONException("invalid subtype: " + string);
            }
        }
        this.zzJq = 0;
        this.zzIX = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) other;
        if ((this.zzIX == null) != (mediaTrack.zzIX == null)) {
            return false;
        }
        if (this.zzIX != null && mediaTrack.zzIX != null && !zzma.zzd(this.zzIX, mediaTrack.zzIX)) {
            return false;
        }
        if (!(this.zzHf == mediaTrack.zzHf && this.zzJp == mediaTrack.zzJp && zzjv.zza(this.zzIQ, mediaTrack.zzIQ) && zzjv.zza(this.zzIS, mediaTrack.zzIS) && zzjv.zza(this.mName, mediaTrack.mName) && zzjv.zza(this.zzIO, mediaTrack.zzIO) && this.zzJq == mediaTrack.zzJq)) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.zzIQ;
    }

    public String getContentType() {
        return this.zzIS;
    }

    public JSONObject getCustomData() {
        return this.zzIX;
    }

    public long getId() {
        return this.zzHf;
    }

    public String getLanguage() {
        return this.zzIO;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.zzJq;
    }

    public int getType() {
        return this.zzJp;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzHf), Integer.valueOf(this.zzJp), this.zzIQ, this.zzIS, this.mName, this.zzIO, Integer.valueOf(this.zzJq), this.zzIX);
    }

    public void setContentId(String contentId) {
        this.zzIQ = contentId;
    }

    public void setContentType(String contentType) {
        this.zzIS = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.zzIX = customData;
    }

    void setLanguage(String language) {
        this.zzIO = language;
    }

    void setName(String name) {
        this.mName = name;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzHf);
            switch (this.zzJp) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.zzIQ != null) {
                jSONObject.put("trackContentId", this.zzIQ);
            }
            if (this.zzIS != null) {
                jSONObject.put("trackContentType", this.zzIS);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.zzIO)) {
                jSONObject.put("language", this.zzIO);
            }
            switch (this.zzJq) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.zzIX != null) {
                jSONObject.put("customData", this.zzIX);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzaf(int i) throws IllegalArgumentException {
        if (i <= -1 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.zzJp == 1) {
            this.zzJq = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }
}
