package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzbm extends IInterface {

    public static abstract class zza extends Binder implements zzbm {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                    zza(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(String str, String str2) throws RemoteException;
}
