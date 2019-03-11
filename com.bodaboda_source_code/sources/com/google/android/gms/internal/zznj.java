package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzar;
import com.google.android.gms.fitness.request.zzav;
import com.google.android.gms.fitness.request.zzb;
import com.google.android.gms.fitness.request.zzu;

public interface zznj extends IInterface {

    public static abstract class zza extends Binder implements zznj {

        private static class zza implements zznj {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(StartBleScanRequest startBleScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzar zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (zzar != null) {
                        obtain.writeInt(1);
                        zzar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (zzav != null) {
                        obtain.writeInt(1);
                        zzav.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzb zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (zzb != null) {
                        obtain.writeInt(1);
                        zzb.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzu zzu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (zzu != null) {
                        obtain.writeInt(1);
                        zzu.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznj zzaG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznj)) ? new zza(iBinder) : (zznj) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zzu zzu = null;
            switch (code) {
                case 1:
                    StartBleScanRequest startBleScanRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        startBleScanRequest = (StartBleScanRequest) StartBleScanRequest.CREATOR.createFromParcel(data);
                    }
                    zza(startBleScanRequest);
                    return true;
                case 2:
                    zzar zzar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        zzar = (zzar) zzar.CREATOR.createFromParcel(data);
                    }
                    zza(zzar);
                    return true;
                case 3:
                    zzb zzb;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        zzb = (zzb) zzb.CREATOR.createFromParcel(data);
                    }
                    zza(zzb);
                    return true;
                case 4:
                    zzav zzav;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        zzav = (zzav) zzav.CREATOR.createFromParcel(data);
                    }
                    zza(zzav);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        zzu = (zzu) zzu.CREATOR.createFromParcel(data);
                    }
                    zza(zzu);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(StartBleScanRequest startBleScanRequest) throws RemoteException;

    void zza(zzar zzar) throws RemoteException;

    void zza(zzav zzav) throws RemoteException;

    void zza(zzb zzb) throws RemoteException;

    void zza(zzu zzu) throws RemoteException;
}
