package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzma;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String zzIQ;
    private int zzIR;
    private String zzIS;
    private MediaMetadata zzIT;
    private long zzIU;
    private List<MediaTrack> zzIV;
    private TextTrackStyle zzIW;
    private JSONObject zzIX;

    public static class Builder {
        private final MediaInfo zzIY;

        public Builder(String contentId) throws IllegalArgumentException {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzIY = new MediaInfo(contentId);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.zzIY.zzhi();
            return this.zzIY;
        }

        public Builder setContentType(String contentType) throws IllegalArgumentException {
            this.zzIY.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzIY.setCustomData(customData);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> mediaTracks) {
            this.zzIY.zzg(mediaTracks);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.zzIY.zza(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) throws IllegalArgumentException {
            this.zzIY.zzm(duration);
            return this;
        }

        public Builder setStreamType(int streamType) throws IllegalArgumentException {
            this.zzIY.setStreamType(streamType);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzIY.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String contentId) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.zzIQ = contentId;
        this.zzIR = -1;
        this.zzIU = -1;
    }

    MediaInfo(JSONObject json) throws JSONException {
        int i = 0;
        this.zzIQ = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzIR = 0;
        } else if ("BUFFERED".equals(string)) {
            this.zzIR = 1;
        } else if ("LIVE".equals(string)) {
            this.zzIR = 2;
        } else {
            this.zzIR = -1;
        }
        this.zzIS = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.zzIT = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.zzIT.zzd(jSONObject);
        }
        this.zzIU = -1;
        if (json.has("duration") && !json.isNull("duration")) {
            double optDouble = json.optDouble("duration", 0.0d);
            if (!(Double.isNaN(optDouble) || Double.isInfinite(optDouble))) {
                this.zzIU = zzjv.zzb(optDouble);
            }
        }
        if (json.has("tracks")) {
            this.zzIV = new ArrayList();
            JSONArray jSONArray = json.getJSONArray("tracks");
            while (i < jSONArray.length()) {
                this.zzIV.add(new MediaTrack(jSONArray.getJSONObject(i)));
                i++;
            }
        } else {
            this.zzIV = null;
        }
        if (json.has("textTrackStyle")) {
            JSONObject jSONObject2 = json.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzd(jSONObject2);
            this.zzIW = textTrackStyle;
        } else {
            this.zzIW = null;
        }
        this.zzIX = json.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.zzIX == null) != (mediaInfo.zzIX == null)) {
            return false;
        }
        if (this.zzIX != null && mediaInfo.zzIX != null && !zzma.zzd(this.zzIX, mediaInfo.zzIX)) {
            return false;
        }
        if (!(zzjv.zza(this.zzIQ, mediaInfo.zzIQ) && this.zzIR == mediaInfo.zzIR && zzjv.zza(this.zzIS, mediaInfo.zzIS) && zzjv.zza(this.zzIT, mediaInfo.zzIT) && this.zzIU == mediaInfo.zzIU)) {
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

    public List<MediaTrack> getMediaTracks() {
        return this.zzIV;
    }

    public MediaMetadata getMetadata() {
        return this.zzIT;
    }

    public long getStreamDuration() {
        return this.zzIU;
    }

    public int getStreamType() {
        return this.zzIR;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzIW;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzIQ, Integer.valueOf(this.zzIR), this.zzIS, this.zzIT, Long.valueOf(this.zzIU), String.valueOf(this.zzIX));
    }

    void setContentType(String contentType) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzIS = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.zzIX = customData;
    }

    void setStreamType(int streamType) throws IllegalArgumentException {
        if (streamType < -1 || streamType > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzIR = streamType;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzIW = textTrackStyle;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.zzIQ);
            switch (this.zzIR) {
                case 1:
                    obj = "BUFFERED";
                    break;
                case 2:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.zzIS != null) {
                jSONObject.put("contentType", this.zzIS);
            }
            if (this.zzIT != null) {
                jSONObject.put("metadata", this.zzIT.toJson());
            }
            if (this.zzIU <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzjv.zzp(this.zzIU));
            }
            if (this.zzIV != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack toJson : this.zzIV) {
                    jSONArray.put(toJson.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzIW != null) {
                jSONObject.put("textTrackStyle", this.zzIW.toJson());
            }
            if (this.zzIX != null) {
                jSONObject.put("customData", this.zzIX);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zza(MediaMetadata mediaMetadata) {
        this.zzIT = mediaMetadata;
    }

    void zzg(List<MediaTrack> list) {
        this.zzIV = list;
    }

    void zzhi() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.zzIQ)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.zzIS)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.zzIR == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    void zzm(long j) throws IllegalArgumentException {
        if (j >= 0 || j == -1) {
            this.zzIU = j;
            return;
        }
        throw new IllegalArgumentException("Invalid stream duration");
    }
}
