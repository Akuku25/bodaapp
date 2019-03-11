package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method zzawM = null;
    private static final Object zzmz = new Object();

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzx.zzb((Object) context, (Object) "Context must not be null");
        GooglePlayServicesUtil.zzI(context);
        Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (zzmz) {
            try {
                if (zzawM == null) {
                    zzai(remoteContext);
                }
                zzawM.invoke(null, new Object[]{remoteContext});
            } catch (Exception e) {
                Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener listener) {
        zzx.zzb((Object) context, (Object) "Context must not be null");
        zzx.zzb((Object) listener, (Object) "Listener must not be null");
        zzx.zzbd("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() {
            protected /* synthetic */ Object doInBackground(Object[] x0) {
                return zzb((Void[]) x0);
            }

            protected /* synthetic */ void onPostExecute(Object x0) {
                zze((Integer) x0);
            }

            protected Integer zzb(Void... voidArr) {
                try {
                    ProviderInstaller.installIfNeeded(context);
                    return Integer.valueOf(0);
                } catch (GooglePlayServicesRepairableException e) {
                    return Integer.valueOf(e.getConnectionStatusCode());
                } catch (GooglePlayServicesNotAvailableException e2) {
                    return Integer.valueOf(e2.errorCode);
                }
            }

            protected void zze(Integer num) {
                if (num.intValue() == 0) {
                    listener.onProviderInstalled();
                    return;
                }
                listener.onProviderInstallFailed(num.intValue(), GooglePlayServicesUtil.zzan(num.intValue()));
            }
        }.execute(new Void[0]);
    }

    private static void zzai(Context context) throws ClassNotFoundException, NoSuchMethodException {
        zzawM = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }
}
