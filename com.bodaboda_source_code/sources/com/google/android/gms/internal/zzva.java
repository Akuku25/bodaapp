package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzy;

public interface zzva extends IInterface {

    public static abstract class zza extends Binder implements zzva {

        private static class zza implements zzva {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(int i, Account account, zzuz zzuz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzuz != null ? zzuz.asBinder() : null);
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzc zzc, zzuz zzuz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (zzc != null) {
                        obtain.writeInt(1);
                        zzc.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzuz != null ? zzuz.asBinder() : null);
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzq zzq, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzq != null ? zzq.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzle.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzy zzy, zzt zzt) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (zzy != null) {
                        obtain.writeInt(1);
                        zzy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzuw zzuw) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (zzuw != null) {
                        obtain.writeInt(1);
                        zzuw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaf(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzhb(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzva zzcF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzva)) ? new zza(iBinder) : (zzva) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            Account account = null;
            switch (code) {
                case 2:
                    zzc zzc;
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (data.readInt() != 0) {
                        zzc = (zzc) zzc.CREATOR.createFromParcel(data);
                    }
                    zza(zzc, com.google.android.gms.internal.zzuz.zza.zzcE(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    zzuw zzuw;
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (data.readInt() != 0) {
                        zzuw = (zzuw) zzuw.CREATOR.createFromParcel(data);
                    }
                    zza(zzuw);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzaf(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5:
                    zzy zzy;
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (data.readInt() != 0) {
                        zzy = (zzy) zzy.CREATOR.createFromParcel(data);
                    }
                    zza(zzy, com.google.android.gms.common.internal.zzt.zza.zzV(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzhb(data.readInt());
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int readInt = data.readInt();
                    if (data.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(data);
                    }
                    zza(readInt, account, com.google.android.gms.internal.zzuz.zza.zzcE(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzq zzR = com.google.android.gms.common.internal.zzq.zza.zzR(data.readStrongBinder());
                    int readInt2 = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzR, readInt2, z);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(int i, Account account, zzuz zzuz) throws RemoteException;

    void zza(zzc zzc, zzuz zzuz) throws RemoteException;

    void zza(zzq zzq, int i, boolean z) throws RemoteException;

    void zza(zzy zzy, zzt zzt) throws RemoteException;

    void zza(zzuw zzuw) throws RemoteException;

    void zzaf(boolean z) throws RemoteException;

    void zzhb(int i) throws RemoteException;
}
