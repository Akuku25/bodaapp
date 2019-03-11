package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface zzwe extends IInterface {

    public static abstract class zza extends Binder implements zzwe {

        private static class zza implements zzwe {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public zzwb zza(zzd zzd, zzc zzc, WalletFragmentOptions walletFragmentOptions, zzwc zzwc) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzwc != null) {
                        iBinder = zzwc.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzwb zzcH = com.google.android.gms.internal.zzwb.zza.zzcH(obtain2.readStrongBinder());
                    return zzcH;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzwe zzcK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzwe)) ? new zza(iBinder) : (zzwe) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    zzwb zza = zza(com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()), com.google.android.gms.dynamic.zzc.zza.zzat(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzwc.zza.zzcI(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzwb zza(zzd zzd, zzc zzc, WalletFragmentOptions walletFragmentOptions, zzwc zzwc) throws RemoteException;
}
