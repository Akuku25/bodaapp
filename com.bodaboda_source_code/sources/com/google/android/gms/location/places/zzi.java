package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzqr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzi extends com.google.android.gms.internal.zzpv.zza {
    private static final String TAG = zzi.class.getSimpleName();
    private final Context mContext;
    private final zzd zzanV;
    private final zza zzanW;
    private final zze zzanX;
    private final zzf zzanY;
    private final zzg zzanZ;
    private final zzc zzaoa;

    public static abstract class zzb<R extends Result, A extends com.google.android.gms.common.api.Api.zza> extends com.google.android.gms.common.api.zza.zza<R, A> {
        public zzb(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }
    }

    public static abstract class zza<A extends com.google.android.gms.common.api.Api.zza> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaz(x0);
        }

        protected AutocompletePredictionBuffer zzaz(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.zzay(status.getStatusCode()));
        }
    }

    public static abstract class zzc<A extends com.google.android.gms.common.api.Api.zza> extends zzb<PlaceBuffer, A> {
        public zzc(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaA(x0);
        }

        protected PlaceBuffer zzaA(Status status) {
            return new PlaceBuffer(DataHolder.zzay(status.getStatusCode()), null);
        }
    }

    public static abstract class zzd<A extends com.google.android.gms.common.api.Api.zza> extends zzb<PlaceLikelihoodBuffer, A> {
        public zzd(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaB(x0);
        }

        protected PlaceLikelihoodBuffer zzaB(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.zzay(status.getStatusCode()), 100, null);
        }
    }

    public static abstract class zze<A extends com.google.android.gms.common.api.Api.zza> extends zzb<zzh, A> {
        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaC(x0);
        }

        protected zzh zzaC(Status status) {
            return new zzh(status, Collections.emptyList());
        }
    }

    public static abstract class zzf<A extends com.google.android.gms.common.api.Api.zza> extends zzb<zzqr, A> {
        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaD(x0);
        }

        protected zzqr zzaD(Status status) {
            return zzqr.zzaE(status);
        }
    }

    public static abstract class zzg<A extends com.google.android.gms.common.api.Api.zza> extends zzb<Status, A> {
        public zzg(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    public zzi(zza zza) {
        this.zzanV = null;
        this.zzanX = null;
        this.zzanW = zza;
        this.zzanY = null;
        this.zzanZ = null;
        this.zzaoa = null;
        this.mContext = null;
    }

    public zzi(zzc zzc, Context context) {
        this.zzanV = null;
        this.zzanX = null;
        this.zzanW = null;
        this.zzanY = null;
        this.zzanZ = null;
        this.zzaoa = zzc;
        this.mContext = context;
    }

    public zzi(zzd zzd, Context context) {
        this.zzanV = zzd;
        this.zzanX = null;
        this.zzanW = null;
        this.zzanY = null;
        this.zzanZ = null;
        this.zzaoa = null;
        this.mContext = context;
    }

    public zzi(zzg zzg) {
        this.zzanV = null;
        this.zzanX = null;
        this.zzanW = null;
        this.zzanY = null;
        this.zzanZ = zzg;
        this.zzaoa = null;
        this.mContext = null;
    }

    public void zzX(DataHolder dataHolder) throws RemoteException {
        Object obj = 1;
        zzx.zza((this.zzanV != null ? 1 : null) != (this.zzanX != null ? 1 : null), (Object) "Only one of placeEstimator or placeReturner can be null");
        if (this.zzanV == null) {
            obj = null;
        }
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zzmg.zzkm());
            }
            if (obj != null) {
                this.zzanV.zzk(Status.zzNq);
                return;
            } else {
                this.zzanX.zzk(Status.zzNq);
                return;
            }
        }
        PlaceLikelihoodBuffer placeLikelihoodBuffer = new PlaceLikelihoodBuffer(dataHolder, 100, this.mContext);
        if (obj != null) {
            this.zzanV.setResult(placeLikelihoodBuffer);
            return;
        }
        Status status = placeLikelihoodBuffer.getStatus();
        List arrayList = new ArrayList(placeLikelihoodBuffer.getCount());
        Iterator it = placeLikelihoodBuffer.iterator();
        while (it.hasNext()) {
            arrayList.add(((PlaceLikelihood) it.next()).getPlace().freeze());
        }
        placeLikelihoodBuffer.release();
        this.zzanX.setResult(new zzh(status, arrayList));
    }

    public void zzY(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zzmg.zzkm());
            }
            this.zzanW.zzk(Status.zzNq);
            return;
        }
        this.zzanW.setResult(new AutocompletePredictionBuffer(dataHolder));
    }

    public void zzZ(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zzmg.zzkm());
            }
            this.zzanY.zzk(Status.zzNq);
            return;
        }
        this.zzanY.setResult(new zzqr(dataHolder));
    }

    public void zzaa(DataHolder dataHolder) throws RemoteException {
        this.zzaoa.setResult(new PlaceBuffer(dataHolder, this.mContext));
    }

    public void zzay(Status status) throws RemoteException {
        this.zzanZ.setResult(status);
    }
}
