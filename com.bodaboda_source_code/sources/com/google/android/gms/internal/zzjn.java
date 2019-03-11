package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.FitnessStatusCodes;

public interface zzjn extends IInterface {

    public static abstract class zza extends Binder implements zzjn {

        private static class zza implements zzjn {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzjm zzjm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjm != null ? zzjm.asBinder() : null);
                    this.zzle.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjm zzjm, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjm != null ? zzjm.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzle.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjm zzjm, int i, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjm != null ? zzjm.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjm zzjm, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjm != null ? zzjm.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzjm zzjm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjm != null ? zzjm.asBinder() : null);
                    this.zzle.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzjm zzjm, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjm != null ? zzjm.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzle.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzjm zzjm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjm != null ? zzjm.asBinder() : null);
                    this.zzle.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzhd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zzle.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzhe() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zzle.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzjn zzN(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjn)) ? new zza(iBinder) : (zzjn) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int zzhd;
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /*5001*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzhd = zzhd();
                    reply.writeNoException();
                    reply.writeInt(zzhd);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /*5002*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzhd = zzhe();
                    reply.writeNoException();
                    reply.writeInt(zzhd);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /*5003*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjm.zza.zzM(data.readStrongBinder()), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /*5004*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjm.zza.zzM(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /*5005*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjm.zza.zzM(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /*5006*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjm.zza.zzM(data.readStrongBinder()), data.readInt(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /*5007*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(com.google.android.gms.internal.zzjm.zza.zzM(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR /*5008*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(com.google.android.gms.internal.zzjm.zza.zzM(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED /*5009*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzc(com.google.android.gms.internal.zzjm.zza.zzM(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzjm zzjm) throws RemoteException;

    void zza(zzjm zzjm, int i) throws RemoteException;

    void zza(zzjm zzjm, int i, String str, byte[] bArr) throws RemoteException;

    void zza(zzjm zzjm, int i, byte[] bArr) throws RemoteException;

    void zzb(zzjm zzjm) throws RemoteException;

    void zzb(zzjm zzjm, int i) throws RemoteException;

    void zzc(zzjm zzjm) throws RemoteException;

    int zzhd() throws RemoteException;

    int zzhe() throws RemoteException;
}
