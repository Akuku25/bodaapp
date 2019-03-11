package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzkd zzJs = new zzkd(this, null) {
        final /* synthetic */ RemoteMediaPlayer zzJw;

        protected void onMetadataUpdated() {
            this.zzJw.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.zzJw.onStatusUpdated();
        }
    };
    private final zza zzJt = new zza(this);
    private OnMetadataUpdatedListener zzJu;
    private OnStatusUpdatedListener zzJv;
    private final Object zznh = new Object();

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    private class zza implements zzke {
        private GoogleApiClient zzJJ;
        private long zzJK = 0;
        final /* synthetic */ RemoteMediaPlayer zzJw;

        private final class zza implements ResultCallback<Status> {
            private final long zzJL;
            final /* synthetic */ zza zzJM;

            zza(zza zza, long j) {
                this.zzJM = zza;
                this.zzJL = j;
            }

            public /* synthetic */ void onResult(Result x0) {
                zzi((Status) x0);
            }

            public void zzi(Status status) {
                if (!status.isSuccess()) {
                    this.zzJM.zzJw.zzJs.zzb(this.zzJL, status.getStatusCode());
                }
            }
        }

        public zza(RemoteMediaPlayer remoteMediaPlayer) {
            this.zzJw = remoteMediaPlayer;
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzJJ == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzJJ, str, str2).setResultCallback(new zza(this, j));
        }

        public void zzb(GoogleApiClient googleApiClient) {
            this.zzJJ = googleApiClient;
        }

        public long zzhk() {
            long j = this.zzJK + 1;
            this.zzJK = j;
            return j;
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzHb;
        private final JSONObject zzIX;

        zzc(Status status, JSONObject jSONObject) {
            this.zzHb = status;
            this.zzIX = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzIX;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private static abstract class zzb extends zzjr<MediaChannelResult> {
        zzkf zzJN = new C02991(this);

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$zzb$1 */
        class C02991 implements zzkf {
            final /* synthetic */ zzb zzJO;

            C02991(zzb zzb) {
                this.zzJO = zzb;
            }

            public void zza(long j, int i, Object obj) {
                this.zzJO.setResult(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            public void zzn(long j) {
                this.zzJO.setResult(this.zzJO.zzj(new Status(2103)));
            }
        }

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzj(x0);
        }

        public MediaChannelResult zzj(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ zzb zzJO;

                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public RemoteMediaPlayer() {
        this.zzJs.zza(this.zzJt);
    }

    private void onMetadataUpdated() {
        if (this.zzJu != null) {
            this.zzJu.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.zzJv != null) {
            this.zzJv.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zznh) {
            approximateStreamPosition = this.zzJs.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zznh) {
            mediaInfo = this.zzJs.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zznh) {
            mediaStatus = this.zzJs.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzJs.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zznh) {
            streamDuration = this.zzJs.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final long[] jArr = activeTrackIds;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, mediaInfo2, z, j, jArr, jSONObject);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.zzJs.zzaI(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(apiClient);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, customData);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(apiClient);
                    try {
                        this.zzJw.zzJs.zzc(this.zzJN, customData);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(apiClient);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, j, i, jSONObject);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if (trackIds != null) {
            return apiClient.zzb(new zzb(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer zzJw;

                protected void zza(zzju zzju) {
                    synchronized (this.zzJw.zznh) {
                        this.zzJw.zzJt.zzb(apiClient);
                        try {
                            this.zzJw.zzJs.zza(this.zzJN, trackIds);
                            this.zzJw.zzJt.zzb(null);
                        } catch (IOException e) {
                            setResult(zzj(new Status(2100)));
                            this.zzJw.zzJt.zzb(null);
                        } catch (Throwable th) {
                            this.zzJw.zzJt.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.zzJu = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.zzJv = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final boolean z = muteState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, z, jSONObject);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IllegalStateException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e2) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, d, jSONObject);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IllegalStateException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (IllegalArgumentException e2) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e3) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.zzb(new zzb(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer zzJw;

                protected void zza(zzju zzju) {
                    synchronized (this.zzJw.zznh) {
                        this.zzJw.zzJt.zzb(apiClient);
                        try {
                            this.zzJw.zzJs.zza(this.zzJN, trackStyle);
                            this.zzJw.zzJt.zzb(null);
                        } catch (IOException e) {
                            setResult(zzj(new Status(2100)));
                            this.zzJw.zzJt.zzb(null);
                        } catch (Throwable th) {
                            this.zzJw.zzJt.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(apiClient);
                    try {
                        this.zzJw.zzJs.zzb(this.zzJN, customData);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }
}
