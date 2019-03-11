package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzr;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private DriveId zzSA;
    private String zzSy;
    private String[] zzSz;

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzSz == null) {
            this.zzSz = new String[0];
        }
        try {
            return ((zzr) apiClient.zza(Drive.zzGR)).zzkF().zza(new OpenFileIntentSenderRequest(this.zzSy, this.zzSz, this.zzSA));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzSA = (DriveId) zzx.zzl(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.zzSy = (String) zzx.zzl(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        zzx.zzb(mimeTypes != null, (Object) "mimeTypes may not be null");
        this.zzSz = mimeTypes;
        return this;
    }
}
