package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.AppMetadata;

public interface zzrm extends IInterface {

    public static abstract class zza extends Binder implements zzrm {

        private static class zza implements zzrm {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(remoteEndpointId);
                    obtain.writeString(remoteDeviceId);
                    obtain.writeString(remoteEndpointName);
                    obtain.writeByteArray(payload);
                    this.zzle.transact(1001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDisconnected(String remoteEndpointId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(remoteEndpointId);
                    this.zzle.transact(Place.TYPE_INTERSECTION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onEndpointFound(String endpointId, String deviceId, String serviceId, String name) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(endpointId);
                    obtain.writeString(deviceId);
                    obtain.writeString(serviceId);
                    obtain.writeString(name);
                    this.zzle.transact(1002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onEndpointLost(String endpointId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(endpointId);
                    this.zzle.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onMessageReceived(String remoteEndpointId, byte[] payload, boolean isReliable) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(remoteEndpointId);
                    obtain.writeByteArray(payload);
                    if (isReliable) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_GEOCODE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(Place.TYPE_FLOOR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(Place.TYPE_COLLOQUIAL_AREA, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzcw(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_COUNTRY, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgs(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_NATURAL_FEATURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgt(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_NEIGHBORHOOD, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgu(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_POLITICAL, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgv(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_POINT_OF_INTEREST, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgw(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_POST_BOX, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_LOCALITY, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        }

        public static zzrm zzch(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrm)) ? new zza(iBinder) : (zzrm) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onConnectionRequest(data.readString(), data.readString(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 1002:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onEndpointFound(data.readString(), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /*1003*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onEndpointLost(data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COLLOQUIAL_AREA /*1004*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zza(data.readString(), data.readString(), data.readString(), data.readString(), data.readInt() != 0 ? AppMetadata.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COUNTRY /*1005*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzcw(data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FLOOR /*1006*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zza(data.readString(), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GEOCODE /*1007*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onMessageReceived(data.readString(), data.createByteArray(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_INTERSECTION /*1008*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onDisconnected(data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_LOCALITY /*1009*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzi(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_NATURAL_FEATURE /*1010*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzgs(data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_NEIGHBORHOOD /*1011*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzgt(data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POLITICAL /*1012*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzgu(data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POINT_OF_INTEREST /*1013*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzgv(data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POST_BOX /*1014*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzgw(data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void onDisconnected(String str) throws RemoteException;

    void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException;

    void onEndpointLost(String str) throws RemoteException;

    void onMessageReceived(String str, byte[] bArr, boolean z) throws RemoteException;

    void zza(String str, int i, byte[] bArr) throws RemoteException;

    void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException;

    void zzcw(String str) throws RemoteException;

    void zzgs(int i) throws RemoteException;

    void zzgt(int i) throws RemoteException;

    void zzgu(int i) throws RemoteException;

    void zzgv(int i) throws RemoteException;

    void zzgw(int i) throws RemoteException;

    void zzi(int i, String str) throws RemoteException;
}
