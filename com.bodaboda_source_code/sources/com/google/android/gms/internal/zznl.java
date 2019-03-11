package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.zzaa;
import com.google.android.gms.fitness.request.zze;
import com.google.android.gms.fitness.request.zzr;
import com.google.android.gms.fitness.request.zzy;

public interface zznl extends IInterface {

    public static abstract class zza extends Binder implements zznl {

        private static class zza implements zznl {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(DataReadRequest dataReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzaa zzaa) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (zzaa != null) {
                        obtain.writeInt(1);
                        zzaa.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (zze != null) {
                        obtain.writeInt(1);
                        zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzr zzr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (zzr != null) {
                        obtain.writeInt(1);
                        zzr.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzy zzy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (zzy != null) {
                        obtain.writeInt(1);
                        zzy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznl zzaI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznl)) ? new zza(iBinder) : (zznl) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zzy zzy = null;
            switch (code) {
                case 1:
                    DataReadRequest dataReadRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dataReadRequest = (DataReadRequest) DataReadRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataReadRequest);
                    return true;
                case 2:
                    zze zze;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        zze = (zze) zze.CREATOR.createFromParcel(data);
                    }
                    zza(zze);
                    return true;
                case 3:
                    DataDeleteRequest dataDeleteRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        dataDeleteRequest = (DataDeleteRequest) DataDeleteRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataDeleteRequest);
                    return true;
                case 4:
                    zzr zzr;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        zzr = (zzr) zzr.CREATOR.createFromParcel(data);
                    }
                    zza(zzr);
                    return true;
                case 5:
                    zzaa zzaa;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        zzaa = (zzaa) zzaa.CREATOR.createFromParcel(data);
                    }
                    zza(zzaa);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (data.readInt() != 0) {
                        zzy = (zzy) zzy.CREATOR.createFromParcel(data);
                    }
                    zza(zzy);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException;

    void zza(DataReadRequest dataReadRequest) throws RemoteException;

    void zza(zzaa zzaa) throws RemoteException;

    void zza(zze zze) throws RemoteException;

    void zza(zzr zzr) throws RemoteException;

    void zza(zzy zzy) throws RemoteException;
}
