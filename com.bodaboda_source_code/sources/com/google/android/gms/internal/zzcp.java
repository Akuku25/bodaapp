package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzcp extends IInterface {

    public static abstract class zza extends Binder implements zzcp {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            String zzcw;
            zzd zzcx;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzl(data.readInt());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    recordImpression();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzcw = zzcw();
                    reply.writeNoException();
                    reply.writeString(zzcw);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzcx = zzcx();
                    reply.writeNoException();
                    if (zzcx != null) {
                        iBinder = zzcx.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzcw = getBody();
                    reply.writeNoException();
                    reply.writeString(zzcw);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzcx = zzcD();
                    reply.writeNoException();
                    if (zzcx != null) {
                        iBinder = zzcx.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzcw = zzcz();
                    reply.writeNoException();
                    reply.writeString(zzcw);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzcw = zzcE();
                    reply.writeNoException();
                    reply.writeString(zzcw);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String getBody() throws RemoteException;

    void recordImpression() throws RemoteException;

    zzd zzcD() throws RemoteException;

    String zzcE() throws RemoteException;

    String zzcw() throws RemoteException;

    zzd zzcx() throws RemoteException;

    String zzcz() throws RemoteException;

    void zzl(int i) throws RemoteException;
}
