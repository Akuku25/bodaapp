package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;

public interface IRoomService extends IInterface {

    public static abstract class Stub extends Binder implements IRoomService {

        private static class Proxy implements IRoomService {
            private IBinder zzle;

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zzV(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_INTERSECTION, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException {
                IBinder iBinder2 = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeStrongBinder(iBinder);
                    if (iRoomServiceCallbacks != null) {
                        iBinder2 = iRoomServiceCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    this.zzle.transact(1001, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_FLOOR, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(byte[] bArr, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_LOCALITY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(byte[] bArr, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_NATURAL_FEATURE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcb(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_POINT_OF_INTEREST, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcc(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_POST_BOX, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zze(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzle.transact(Place.TYPE_COLLOQUIAL_AREA, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznV() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.zzle.transact(1002, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.zzle.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.zzle.transact(Place.TYPE_COUNTRY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.zzle.transact(Place.TYPE_GEOCODE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzw(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_NEIGHBORHOOD, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzx(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_POLITICAL, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zza(data.readStrongBinder(), com.google.android.gms.games.internal.IRoomServiceCallbacks.Stub.zzbc(data.readStrongBinder()));
                    return true;
                case 1002:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zznV();
                    return true;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /*1003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zznW();
                    return true;
                case Place.TYPE_COLLOQUIAL_AREA /*1004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zze(data.readString(), data.readString(), data.readString());
                    return true;
                case Place.TYPE_COUNTRY /*1005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zznX();
                    return true;
                case Place.TYPE_FLOOR /*1006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    DataHolder zzA = data.readInt() != 0 ? DataHolder.CREATOR.zzA(data) : null;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzA, z);
                    return true;
                case Place.TYPE_GEOCODE /*1007*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zznY();
                    return true;
                case Place.TYPE_INTERSECTION /*1008*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzV(z);
                    return true;
                case Place.TYPE_LOCALITY /*1009*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zza(data.createByteArray(), data.readString(), data.readInt());
                    return true;
                case Place.TYPE_NATURAL_FEATURE /*1010*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zza(data.createByteArray(), data.createStringArray());
                    return true;
                case Place.TYPE_NEIGHBORHOOD /*1011*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zzw(data.readString(), data.readInt());
                    return true;
                case Place.TYPE_POLITICAL /*1012*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zzx(data.readString(), data.readInt());
                    return true;
                case Place.TYPE_POINT_OF_INTEREST /*1013*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zzcb(data.readString());
                    return true;
                case Place.TYPE_POST_BOX /*1014*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zzcc(data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IRoomService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzV(boolean z) throws RemoteException;

    void zza(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException;

    void zza(DataHolder dataHolder, boolean z) throws RemoteException;

    void zza(byte[] bArr, String str, int i) throws RemoteException;

    void zza(byte[] bArr, String[] strArr) throws RemoteException;

    void zzcb(String str) throws RemoteException;

    void zzcc(String str) throws RemoteException;

    void zze(String str, String str2, String str3) throws RemoteException;

    void zznV() throws RemoteException;

    void zznW() throws RemoteException;

    void zznX() throws RemoteException;

    void zznY() throws RemoteException;

    void zzw(String str, int i) throws RemoteException;

    void zzx(String str, int i) throws RemoteException;
}
