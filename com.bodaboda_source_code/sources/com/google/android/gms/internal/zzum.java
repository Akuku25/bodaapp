package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;

public class zzum implements SafetyNetApi {

    static class zza implements AttestationResult {
        private final Status zzHb;
        private final com.google.android.gms.safetynet.zza zzawJ;

        public zza(Status status, com.google.android.gms.safetynet.zza zza) {
            this.zzHb = status;
            this.zzawJ = zza;
        }

        public String getJwsResult() {
            return this.zzawJ == null ? null : this.zzawJ.getJwsResult();
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    static abstract class zzb extends zzuj<AttestationResult> {
        protected zzuk zzawK = new C05961(this);

        /* renamed from: com.google.android.gms.internal.zzum$zzb$1 */
        class C05961 extends zzui {
            final /* synthetic */ zzb zzawL;

            C05961(zzb zzb) {
                this.zzawL = zzb;
            }

            public void zza(Status status, com.google.android.gms.safetynet.zza zza) {
                this.zzawL.setResult(new zza(status, zza));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaL(x0);
        }

        protected AttestationResult zzaL(Status status) {
            return new zza(status, null);
        }
    }

    public PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, final byte[] nonce) {
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzum zzawI;

            protected void zza(zzun zzun) throws RemoteException {
                zzun.zza(this.zzawK, nonce);
            }
        });
    }
}
