package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzl;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        private static class zza implements zzd {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public com.google.android.gms.dynamic.zzd zzf(zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    com.google.android.gms.dynamic.zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public com.google.android.gms.dynamic.zzd zzg(zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    com.google.android.gms.dynamic.zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        public static zzd zzbv(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new zza(iBinder) : (zzd) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            com.google.android.gms.dynamic.zzd zzf;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    zzf = zzf(com.google.android.gms.maps.model.internal.zzl.zza.zzcb(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zzf != null) {
                        iBinder = zzf.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    zzf = zzg(com.google.android.gms.maps.model.internal.zzl.zza.zzcb(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zzf != null) {
                        iBinder = zzf.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    com.google.android.gms.dynamic.zzd zzf(zzl zzl) throws RemoteException;

    com.google.android.gms.dynamic.zzd zzg(zzl zzl) throws RemoteException;
}
