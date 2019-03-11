package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

public interface zzka extends IInterface {

    public static abstract class zza extends Binder implements zzka {
        public zza() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            zzjw zzjw = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzai(data.readInt());
                    return true;
                case 2:
                    ApplicationMetadata applicationMetadata;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        applicationMetadata = (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(data);
                    }
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(applicationMetadata, readString, readString2, z);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzaj(data.readInt());
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = data.readString();
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(readString3, readDouble, z);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzn(data.readString(), data.readString());
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzb(data.readString(), data.createByteArray());
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzal(data.readInt());
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzak(data.readInt());
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(data.readInt());
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zza(data.readString(), data.readLong(), data.readInt());
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zza(data.readString(), data.readLong());
                    return true;
                case 12:
                    zzjp zzjp;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        zzjp = (zzjp) zzjp.CREATOR.createFromParcel(data);
                    }
                    zzb(zzjp);
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        zzjw = (zzjw) zzjw.CREATOR.createFromParcel(data);
                    }
                    zzb(zzjw);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onApplicationDisconnected(int i) throws RemoteException;

    void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void zza(String str, double d, boolean z) throws RemoteException;

    void zza(String str, long j) throws RemoteException;

    void zza(String str, long j, int i) throws RemoteException;

    void zzai(int i) throws RemoteException;

    void zzaj(int i) throws RemoteException;

    void zzak(int i) throws RemoteException;

    void zzal(int i) throws RemoteException;

    void zzb(zzjp zzjp) throws RemoteException;

    void zzb(zzjw zzjw) throws RemoteException;

    void zzb(String str, byte[] bArr) throws RemoteException;

    void zzn(String str, String str2) throws RemoteException;
}
