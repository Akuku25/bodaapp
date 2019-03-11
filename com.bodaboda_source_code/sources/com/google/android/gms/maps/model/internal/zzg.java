package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzg extends IInterface {

    public static abstract class zza extends Binder implements zzg {

        private static class zza implements zzg {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public zzd zzb(Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzcs(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzct(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzcu(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zze(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeFloat(f);
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzgn(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeInt(i);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzqN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzg zzbW(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzg)) ? new zza(iBinder) : (zzg) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            zzd zzgn;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzgn = zzgn(data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(zzgn != null ? zzgn.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzgn = zzcs(data.readString());
                    reply.writeNoException();
                    if (zzgn != null) {
                        iBinder = zzgn.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzgn = zzct(data.readString());
                    reply.writeNoException();
                    if (zzgn != null) {
                        iBinder = zzgn.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzgn = zzqN();
                    reply.writeNoException();
                    if (zzgn != null) {
                        iBinder = zzgn.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzgn = zze(data.readFloat());
                    reply.writeNoException();
                    if (zzgn != null) {
                        iBinder = zzgn.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzgn = zzb(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzgn != null) {
                        iBinder = zzgn.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzgn = zzcu(data.readString());
                    reply.writeNoException();
                    if (zzgn != null) {
                        iBinder = zzgn.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzd zzb(Bitmap bitmap) throws RemoteException;

    zzd zzcs(String str) throws RemoteException;

    zzd zzct(String str) throws RemoteException;

    zzd zzcu(String str) throws RemoteException;

    zzd zze(float f) throws RemoteException;

    zzd zzgn(int i) throws RemoteException;

    zzd zzqN() throws RemoteException;
}
