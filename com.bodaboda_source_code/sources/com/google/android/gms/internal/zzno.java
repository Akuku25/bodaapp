package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.zzac;
import com.google.android.gms.fitness.request.zzae;

public interface zzno extends IInterface {

    public static abstract class zza extends Binder implements zzno {

        private static class zza implements zzno {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzac zzac) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (zzac != null) {
                        obtain.writeInt(1);
                        zzac.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzae zzae) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (zzae != null) {
                        obtain.writeInt(1);
                        zzae.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzno zzaL(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzno)) ? new zza(iBinder) : (zzno) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zzae zzae = null;
            switch (code) {
                case 1:
                    DataSourcesRequest dataSourcesRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (data.readInt() != 0) {
                        dataSourcesRequest = (DataSourcesRequest) DataSourcesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataSourcesRequest);
                    return true;
                case 2:
                    zzac zzac;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (data.readInt() != 0) {
                        zzac = (zzac) zzac.CREATOR.createFromParcel(data);
                    }
                    zza(zzac);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (data.readInt() != 0) {
                        zzae = (zzae) zzae.CREATOR.createFromParcel(data);
                    }
                    zza(zzae);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException;

    void zza(zzac zzac) throws RemoteException;

    void zza(zzae zzae) throws RemoteException;
}
