package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.zzat;
import com.google.android.gms.fitness.request.zzax;
import com.google.android.gms.fitness.request.zzw;

public interface zznn extends IInterface {

    public static abstract class zza extends Binder implements zznn {

        private static class zza implements zznn {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzat zzat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (zzat != null) {
                        obtain.writeInt(1);
                        zzat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzax zzax) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (zzax != null) {
                        obtain.writeInt(1);
                        zzax.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzw zzw) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (zzw != null) {
                        obtain.writeInt(1);
                        zzw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznn zzaK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznn)) ? new zza(iBinder) : (zznn) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zzw zzw = null;
            switch (code) {
                case 1:
                    zzat zzat;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (data.readInt() != 0) {
                        zzat = (zzat) zzat.CREATOR.createFromParcel(data);
                    }
                    zza(zzat);
                    return true;
                case 2:
                    zzax zzax;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (data.readInt() != 0) {
                        zzax = (zzax) zzax.CREATOR.createFromParcel(data);
                    }
                    zza(zzax);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (data.readInt() != 0) {
                        zzw = (zzw) zzw.CREATOR.createFromParcel(data);
                    }
                    zza(zzw);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzat zzat) throws RemoteException;

    void zza(zzax zzax) throws RemoteException;

    void zza(zzw zzw) throws RemoteException;
}
