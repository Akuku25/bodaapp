package com.google.android.gms.fitness.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;

public interface zzt extends IInterface {

    public static abstract class zza extends Binder implements zzt {

        private static class zza implements zzt {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void onDeviceFound(BleDevice device) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onScanStopped() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.request.IBleScanCallback");
        }

        public static zzt zzaV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzt)) ? new zza(iBinder) : (zzt) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    onDeviceFound(data.readInt() != 0 ? (BleDevice) BleDevice.CREATOR.createFromParcel(data) : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    onScanStopped();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.request.IBleScanCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onDeviceFound(BleDevice bleDevice) throws RemoteException;

    void onScanStopped() throws RemoteException;
}
