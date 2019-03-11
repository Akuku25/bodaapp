package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zzb;

public class zzwh implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        final String str = googleTransactionId;
        final String str2 = merchantTransactionId;
        final int i = requestCode;
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi zzwi) {
                zzwi.zze(str, str2, i);
                setResult(Status.zzNo);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi zzwi) {
                zzwi.zzhG(requestCode);
                setResult(Status.zzNo);
            }
        });
    }

    public void isNewUser(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi zzwi) {
                zzwi.zzhH(requestCode);
                setResult(Status.zzNo);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi zzwi) {
                zzwi.zza(request, requestCode);
                setResult(Status.zzNo);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi zzwi) {
                zzwi.zza(request, requestCode);
                setResult(Status.zzNo);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi zzwi) {
                zzwi.zza(request);
                setResult(Status.zzNo);
            }
        });
    }
}
