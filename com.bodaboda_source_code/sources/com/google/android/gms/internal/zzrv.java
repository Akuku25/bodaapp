package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzrv extends IInterface {

    public static abstract class zza extends Binder implements zzrv {

        private static class zza implements zzrv {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzsa zzsa) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (zzsa != null) {
                        obtain.writeInt(1);
                        zzsa.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzsc zzsc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (zzsc != null) {
                        obtain.writeInt(1);
                        zzsc.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzse zzse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (zzse != null) {
                        obtain.writeInt(1);
                        zzse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzsg zzsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (zzsg != null) {
                        obtain.writeInt(1);
                        zzsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzrv zzcl(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrv)) ? new zza(iBinder) : (zzrv) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zzsg zzsg = null;
            switch (code) {
                case 1:
                    zzsa zzsa;
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        zzsa = (zzsa) zzsa.CREATOR.createFromParcel(data);
                    }
                    zza(zzsa);
                    return true;
                case 2:
                    zzse zzse;
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        zzse = (zzse) zzse.CREATOR.createFromParcel(data);
                    }
                    zza(zzse);
                    return true;
                case 3:
                    zzsc zzsc;
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        zzsc = (zzsc) zzsc.CREATOR.createFromParcel(data);
                    }
                    zza(zzsc);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        zzsg = (zzsg) zzsg.CREATOR.createFromParcel(data);
                    }
                    zza(zzsg);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzsa zzsa) throws RemoteException;

    void zza(zzsc zzsc) throws RemoteException;

    void zza(zzse zzse) throws RemoteException;

    void zza(zzsg zzsg) throws RemoteException;
}
