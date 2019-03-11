package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface zzpv extends IInterface {

    public static abstract class zza extends Binder implements zzpv {

        private static class zza implements zzpv {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zzX(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzY(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzZ(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzaa(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzay(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
        }

        public static zzpv zzbp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpv)) ? new zza(iBinder) : (zzpv) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DataHolder dataHolder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.zzA(data);
                    }
                    zzX(dataHolder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.zzA(data);
                    }
                    zzY(dataHolder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.zzA(data);
                    }
                    zzZ(dataHolder);
                    return true;
                case 4:
                    Status createFromParcel;
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = Status.CREATOR.createFromParcel(data);
                    }
                    zzay(createFromParcel);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.zzA(data);
                    }
                    zzaa(dataHolder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzX(DataHolder dataHolder) throws RemoteException;

    void zzY(DataHolder dataHolder) throws RemoteException;

    void zzZ(DataHolder dataHolder) throws RemoteException;

    void zzaa(DataHolder dataHolder) throws RemoteException;

    void zzay(Status status) throws RemoteException;
}
