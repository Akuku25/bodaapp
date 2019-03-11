package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkb;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API = new Api(zzGS, zzkb.zzGR, new Scope[0]);
    public static final CastApi CastApi = new zza();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    private static final zzb<zzju, CastOptions> zzGS = new C02981();

    public interface CastApi {

        public static final class zza implements CastApi {
            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((zzju) client.zza(zzkb.zzGR)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((zzju) client.zza(zzkb.zzGR)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((zzju) client.zza(zzkb.zzGR)).zzhs();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((zzju) client.zza(zzkb.zzGR)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju zzju) throws RemoteException {
                        try {
                            zzju.zzb(null, null, this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju zzju) throws RemoteException {
                        try {
                            zzju.zzb(applicationId, null, this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju zzju) throws RemoteException {
                        try {
                            zzju.zzb(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju zzju) throws RemoteException {
                        try {
                            zzju.zza(applicationId, false, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju zzju) throws RemoteException {
                        try {
                            zzju.zza(applicationId, options, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.zzb(new zzjy(this, client) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju zzju) throws RemoteException {
                        try {
                            zzju.zzd((com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((zzju) client.zza(zzkb.zzGR)).zzaJ(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((zzju) client.zza(zzkb.zzGR)).zzhr();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.zzb(new zzjy(this, client) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju zzju) throws RemoteException {
                        try {
                            zzju.zza(namespace, message, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalArgumentException e) {
                            zzah(2001);
                        } catch (IllegalStateException e2) {
                            zzah(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((zzju) client.zza(zzkb.zzGR)).zza(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((zzju) client.zza(zzkb.zzGR)).zzL(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((zzju) client.zza(zzkb.zzGR)).zza(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.zzb(new zzjy(this, client) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju zzju) throws RemoteException {
                        try {
                            zzju.zza("", (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.zzb(new zzjy(this, client) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju zzju) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            zzd(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            zzju.zza(sessionId, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static class Listener {
        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }

        public void zzab(int i) {
        }

        public void zzac(int i) {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* renamed from: com.google.android.gms.cast.Cast$1 */
    static class C02981 implements zzb<zzju, CastOptions> {
        C02981() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzju zza(Context context, Looper looper, zzf zzf, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb((Object) castOptions, (Object) "Setting the API options is required.");
            return new zzju(context, looper, castOptions.zzIx, (long) castOptions.zzIz, castOptions.zzIy, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice zzIx;
        final Listener zzIy;
        private final int zzIz;

        public static final class Builder {
            CastDevice zzIA;
            Listener zzIB;
            private int zzIC;

            private Builder(CastDevice castDevice, Listener castListener) {
                zzx.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                zzx.zzb((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.zzIA = castDevice;
                this.zzIB = castListener;
                this.zzIC = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.zzIC |= 1;
                } else {
                    this.zzIC &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzIx = builder.zzIA;
            this.zzIy = builder.zzIB;
            this.zzIz = builder.zzIC;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    private static abstract class zza extends zzjr<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzh(x0);
        }

        public ApplicationConnectionResult zzh(final Status status) {
            return new ApplicationConnectionResult(this) {
                final /* synthetic */ zza zzID;

                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
