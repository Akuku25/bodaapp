package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

public class zzi {
    private DriveId zzSA;
    private String zzSy;
    protected MetadataChangeSet zzTm;
    private Integer zzTn;
    private final int zzTo;

    public zzi(int i) {
        this.zzTo = i;
    }

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zzb(this.zzTm, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        zzr zzr = (zzr) apiClient.zza(Drive.zzGR);
        this.zzTm.zzkx().setContext(zzr.getContext());
        try {
            return zzr.zzkF().zza(new CreateFileIntentSenderRequest(this.zzTm.zzkx(), this.zzTn == null ? -1 : this.zzTn.intValue(), this.zzSy, this.zzSA, this.zzTo));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public void zza(DriveId driveId) {
        this.zzSA = (DriveId) zzx.zzl(driveId);
    }

    public void zza(MetadataChangeSet metadataChangeSet) {
        this.zzTm = (MetadataChangeSet) zzx.zzl(metadataChangeSet);
    }

    public void zzbD(int i) {
        this.zzTn = Integer.valueOf(i);
    }

    public void zzbx(String str) {
        this.zzSy = (String) zzx.zzl(str);
    }
}
