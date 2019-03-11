package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public interface zzoo extends IInterface {

    public static abstract class zza extends Binder implements zzoo {
        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zzom zzom = null;
            switch (code) {
                case 1:
                    zzok zzok;
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        zzok = (zzok) zzok.CREATOR.createFromParcel(data);
                    }
                    zza(zzok, com.google.android.gms.internal.zznh.zza.zzaE(data.readStrongBinder()));
                    return true;
                case 2:
                    FitnessSensorServiceRequest fitnessSensorServiceRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        fitnessSensorServiceRequest = (FitnessSensorServiceRequest) FitnessSensorServiceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(fitnessSensorServiceRequest, com.google.android.gms.internal.zznv.zza.zzaS(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        zzom = (zzom) zzom.CREATOR.createFromParcel(data);
                    }
                    zza(zzom, com.google.android.gms.internal.zznv.zza.zzaS(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zznv zznv) throws RemoteException;

    void zza(zzok zzok, zznh zznh) throws RemoteException;

    void zza(zzom zzom, zznv zznv) throws RemoteException;
}
