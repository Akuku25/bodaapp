package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.internal.zzg;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        private static class zza implements zzc {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public IMapViewDelegate zza(zzd zzd, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate zzbz = com.google.android.gms.maps.internal.IMapViewDelegate.zza.zzbz(obtain2.readStrongBinder());
                    return zzbz;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaViewDelegate zza(zzd zzd, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaViewDelegate zzbU = com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.zza.zzbU(obtain2.readStrongBinder());
                    return zzbU;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzd zzd, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate zzj(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate zzby = com.google.android.gms.maps.internal.IMapFragmentDelegate.zza.zzby(obtain2.readStrongBinder());
                    return zzby;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaFragmentDelegate zzk(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaFragmentDelegate zzbT = com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate.zza.zzbT(obtain2.readStrongBinder());
                    return zzbT;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate zzqA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate zzbr = com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.zza.zzbr(obtain2.readStrongBinder());
                    return zzbr;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzg zzqB() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    zzg zzbW = com.google.android.gms.maps.model.internal.zzg.zza.zzbW(obtain2.readStrongBinder());
                    return zzbW;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzc zzbt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new zza(iBinder) : (zzc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    zzi(com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate zzj = zzj(com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zzj != null) {
                        iBinder = zzj.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate zza = zza(com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.zzdP(data) : null);
                    reply.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate zzqA = zzqA();
                    reply.writeNoException();
                    if (zzqA != null) {
                        iBinder = zzqA.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    zzg zzqB = zzqB();
                    reply.writeNoException();
                    if (zzqB != null) {
                        iBinder = zzqB.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    zzb(com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate zza2 = zza(com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.zzdQ(data) : null);
                    reply.writeNoException();
                    if (zza2 != null) {
                        iBinder = zza2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate zzk = zzk(com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zzk != null) {
                        iBinder = zzk.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IMapViewDelegate zza(zzd zzd, GoogleMapOptions googleMapOptions) throws RemoteException;

    IStreetViewPanoramaViewDelegate zza(zzd zzd, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void zzb(zzd zzd, int i) throws RemoteException;

    void zzi(zzd zzd) throws RemoteException;

    IMapFragmentDelegate zzj(zzd zzd) throws RemoteException;

    IStreetViewPanoramaFragmentDelegate zzk(zzd zzd) throws RemoteException;

    ICameraUpdateFactoryDelegate zzqA() throws RemoteException;

    zzg zzqB() throws RemoteException;
}
