package com.google.android.gms.games.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.fitness.FitnessStatusCodes;

public interface IGamesSignInCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IGamesSignInCallbacks {

        private static class Proxy implements IGamesSignInCallbacks {
            private IBinder zzle;

            Proxy(IBinder remote) {
                this.zzle = remote;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zzU(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzV(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(15501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzeD(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzeE(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzeF(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(14001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInCallbacks");
        }

        public static IGamesSignInCallbacks zzba(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesSignInCallbacks)) ? new Proxy(iBinder) : (IGamesSignInCallbacks) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            PendingIntent pendingIntent = null;
            DataHolder zzA;
            switch (code) {
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /*5002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (data.readInt() != 0) {
                        zzA = DataHolder.CREATOR.zzA(data);
                    }
                    zzU(zzA);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /*5003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (data.readInt() != 0) {
                        zzA = DataHolder.CREATOR.zzA(data);
                    }
                    zzV(zzA);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /*5004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    zzeD(data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /*5005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (data.readInt() != 0) {
                        zzA = DataHolder.CREATOR.zzA(data);
                    }
                    zzg(zzA);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /*5006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    zzeE(data.readInt());
                    reply.writeNoException();
                    return true;
                case 14001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    zzeF(data.readInt());
                    reply.writeNoException();
                    return true;
                case 15501:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    int readInt = data.readInt();
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    zza(readInt, pendingIntent);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzU(DataHolder dataHolder) throws RemoteException;

    void zzV(DataHolder dataHolder) throws RemoteException;

    void zza(int i, PendingIntent pendingIntent) throws RemoteException;

    void zzeD(int i) throws RemoteException;

    void zzeE(int i) throws RemoteException;

    void zzeF(int i) throws RemoteException;

    void zzg(DataHolder dataHolder) throws RemoteException;
}
