package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.location.places.Place;

public interface IRoomServiceCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IRoomServiceCallbacks {

        private static class Proxy implements IRoomServiceCallbacks {
            private IBinder zzle;

            Proxy(IBinder remote) {
                this.zzle = remote;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void onP2PConnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(participantId);
                    this.zzle.transact(Place.TYPE_POST_BOX, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(participantId);
                    this.zzle.transact(Place.TYPE_POSTAL_CODE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ParcelFileDescriptor parcelFileDescriptor, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(1024, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ConnectionInfo connectionInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (connectionInfo != null) {
                        obtain.writeInt(1);
                        connectionInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(Place.TYPE_SUBLOCALITY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, byte[] bArr, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    this.zzle.transact(1002, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_INTERSECTION, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_LOCALITY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzbb(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(Place.TYPE_STREET_ADDRESS, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.zzle.transact(1001, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(Place.TYPE_PREMISE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_NATURAL_FEATURE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcd(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzce(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_COLLOQUIAL_AREA, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcf(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_COUNTRY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcg(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_FLOOR, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzch(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_GEOCODE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzci(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_ROOM, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzd(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_NEIGHBORHOOD, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zze(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_POLITICAL, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzeG(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_ROUTE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzf(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_POINT_OF_INTEREST, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzg(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_POSTAL_TOWN, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzi(String str, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_SUBLOCALITY_LEVEL_4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznZ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.zzle.transact(Place.TYPE_POSTAL_CODE_PREFIX, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzoa() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.zzle.transact(Place.TYPE_SUBLOCALITY_LEVEL_1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzy(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_SUBLOCALITY_LEVEL_3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
        }

        public static IRoomServiceCallbacks zzbc(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRoomServiceCallbacks)) ? new Proxy(iBinder) : (IRoomServiceCallbacks) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ParcelFileDescriptor parcelFileDescriptor = null;
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzc(data.readInt(), data.readInt(), data.readString());
                    return true;
                case 1002:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zza(data.readString(), data.createByteArray(), data.readInt());
                    return true;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /*1003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzcd(data.readString());
                    return true;
                case Place.TYPE_COLLOQUIAL_AREA /*1004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzce(data.readString());
                    return true;
                case Place.TYPE_COUNTRY /*1005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzcf(data.readString());
                    return true;
                case Place.TYPE_FLOOR /*1006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzcg(data.readString());
                    return true;
                case Place.TYPE_GEOCODE /*1007*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzch(data.readString());
                    return true;
                case Place.TYPE_INTERSECTION /*1008*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zza(data.readString(), data.createStringArray());
                    return true;
                case Place.TYPE_LOCALITY /*1009*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzb(data.readString(), data.createStringArray());
                    return true;
                case Place.TYPE_NATURAL_FEATURE /*1010*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzc(data.readString(), data.createStringArray());
                    return true;
                case Place.TYPE_NEIGHBORHOOD /*1011*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzd(data.readString(), data.createStringArray());
                    return true;
                case Place.TYPE_POLITICAL /*1012*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zze(data.readString(), data.createStringArray());
                    return true;
                case Place.TYPE_POINT_OF_INTEREST /*1013*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzf(data.readString(), data.createStringArray());
                    return true;
                case Place.TYPE_POST_BOX /*1014*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PConnected(data.readString());
                    return true;
                case Place.TYPE_POSTAL_CODE /*1015*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PDisconnected(data.readString());
                    return true;
                case Place.TYPE_POSTAL_CODE_PREFIX /*1016*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zznZ();
                    return true;
                case Place.TYPE_POSTAL_TOWN /*1017*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzg(data.readString(), data.createStringArray());
                    return true;
                case Place.TYPE_PREMISE /*1018*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzc(data.readString(), data.createByteArray());
                    return true;
                case Place.TYPE_ROOM /*1019*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzci(data.readString());
                    return true;
                case Place.TYPE_ROUTE /*1020*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzeG(data.readInt());
                    return true;
                case Place.TYPE_STREET_ADDRESS /*1021*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzbb(data.readStrongBinder());
                    return true;
                case Place.TYPE_SUBLOCALITY /*1022*/:
                    ConnectionInfo zzcX;
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (data.readInt() != 0) {
                        zzcX = ConnectionInfo.CREATOR.zzcX(data);
                    }
                    zza(zzcX);
                    return true;
                case Place.TYPE_SUBLOCALITY_LEVEL_1 /*1023*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzoa();
                    return true;
                case 1024:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (data.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    }
                    zza(parcelFileDescriptor, data.readInt());
                    return true;
                case Place.TYPE_SUBLOCALITY_LEVEL_3 /*1025*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzy(data.readString(), data.readInt());
                    return true;
                case Place.TYPE_SUBLOCALITY_LEVEL_4 /*1026*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzi(data.readString(), data.readInt() != 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    void zza(ParcelFileDescriptor parcelFileDescriptor, int i) throws RemoteException;

    void zza(ConnectionInfo connectionInfo) throws RemoteException;

    void zza(String str, byte[] bArr, int i) throws RemoteException;

    void zza(String str, String[] strArr) throws RemoteException;

    void zzb(String str, String[] strArr) throws RemoteException;

    void zzbb(IBinder iBinder) throws RemoteException;

    void zzc(int i, int i2, String str) throws RemoteException;

    void zzc(String str, byte[] bArr) throws RemoteException;

    void zzc(String str, String[] strArr) throws RemoteException;

    void zzcd(String str) throws RemoteException;

    void zzce(String str) throws RemoteException;

    void zzcf(String str) throws RemoteException;

    void zzcg(String str) throws RemoteException;

    void zzch(String str) throws RemoteException;

    void zzci(String str) throws RemoteException;

    void zzd(String str, String[] strArr) throws RemoteException;

    void zze(String str, String[] strArr) throws RemoteException;

    void zzeG(int i) throws RemoteException;

    void zzf(String str, String[] strArr) throws RemoteException;

    void zzg(String str, String[] strArr) throws RemoteException;

    void zzi(String str, boolean z) throws RemoteException;

    void zznZ() throws RemoteException;

    void zzoa() throws RemoteException;

    void zzy(String str, int i) throws RemoteException;
}
