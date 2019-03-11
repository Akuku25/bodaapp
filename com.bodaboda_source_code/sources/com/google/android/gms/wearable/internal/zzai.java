package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.zze;

public interface zzai extends IInterface {

    public static abstract class zza extends Binder implements zzai {

        private static class zza implements zzai {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzle.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (zzau != null) {
                        obtain.writeInt(1);
                        zzau.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, zzb zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (zzb != null) {
                        obtain.writeInt(1);
                        zzb.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (zze != null) {
                        obtain.writeInt(1);
                        zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (zze != null) {
                        obtain.writeInt(1);
                        zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag zzag, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzag zzag, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzle.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzag zzag, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzag zzag, zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (zze != null) {
                        obtain.writeInt(1);
                        zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzag zzag, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzag zzag, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzag zzag, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzag zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzag != null ? zzag.asBinder() : null);
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzai zzcR(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzai)) ? new zza(iBinder) : (zzai) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zze zze = null;
            zzag zzcP;
            Uri uri;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        zze = (zze) zze.CREATOR.createFromParcel(data);
                    }
                    zzb(zzcP, zze);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzj(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzk(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzl(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    PutDataRequest putDataRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzcP, putDataRequest);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zza(zzcP, uri);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzb(zzcP, uri);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzc(zzcP, uri);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()), data.readString(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 13:
                    Asset asset;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        asset = (Asset) Asset.CREATOR.createFromParcel(data);
                    }
                    zza(zzcP, asset);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    zzb zzb;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        zzb = (zzb) zzb.CREATOR.createFromParcel(data);
                    }
                    zza(zzcP, zzb);
                    reply.writeNoException();
                    return true;
                case 17:
                    zzau zzau;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        zzau = (zzau) zzau.CREATOR.createFromParcel(data);
                    }
                    zza(zzcP, zzau);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        zze = (zze) zze.CREATOR.createFromParcel(data);
                    }
                    zza(zzcP, zze);
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzg(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzh(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 27:
                    zze zze2;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        zze2 = (zze) zze.CREATOR.createFromParcel(data);
                    }
                    zza(zzcP, zze2);
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzi(com.google.android.gms.wearable.internal.zzag.zza.zzcP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzag zzag) throws RemoteException;

    void zza(zzag zzag, int i) throws RemoteException;

    void zza(zzag zzag, Uri uri) throws RemoteException;

    void zza(zzag zzag, Asset asset) throws RemoteException;

    void zza(zzag zzag, PutDataRequest putDataRequest) throws RemoteException;

    void zza(zzag zzag, zzau zzau) throws RemoteException;

    void zza(zzag zzag, zzb zzb) throws RemoteException;

    void zza(zzag zzag, zze zze) throws RemoteException;

    void zza(zzag zzag, zze zze) throws RemoteException;

    void zza(zzag zzag, String str) throws RemoteException;

    void zza(zzag zzag, String str, String str2, byte[] bArr) throws RemoteException;

    void zzb(zzag zzag) throws RemoteException;

    void zzb(zzag zzag, int i) throws RemoteException;

    void zzb(zzag zzag, Uri uri) throws RemoteException;

    void zzb(zzag zzag, zze zze) throws RemoteException;

    void zzb(zzag zzag, String str) throws RemoteException;

    void zzc(zzag zzag) throws RemoteException;

    void zzc(zzag zzag, Uri uri) throws RemoteException;

    void zzc(zzag zzag, String str) throws RemoteException;

    void zzd(zzag zzag) throws RemoteException;

    void zze(zzag zzag) throws RemoteException;

    void zzf(zzag zzag) throws RemoteException;

    void zzg(zzag zzag) throws RemoteException;

    void zzh(zzag zzag) throws RemoteException;

    void zzi(zzag zzag) throws RemoteException;

    void zzj(zzag zzag) throws RemoteException;

    void zzk(zzag zzag) throws RemoteException;

    void zzl(zzag zzag) throws RemoteException;
}
