package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface zzsl extends IInterface {

    public static abstract class zza extends Binder implements zzsl {

        private static class zza implements zzsl {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public boolean zzrs() throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<zzsi> zzrt() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    List<zzsi> createTypedArrayList = obtain2.createTypedArrayList(zzsi.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzsl zzcn(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzsl)) ? new zza(iBinder) : (zzsl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    boolean zzrs = zzrs();
                    reply.writeNoException();
                    reply.writeInt(zzrs ? 1 : 0);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    List zzrt = zzrt();
                    reply.writeNoException();
                    reply.writeTypedList(zzrt);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean zzrs() throws RemoteException;

    List<zzsi> zzrt() throws RemoteException;
}
