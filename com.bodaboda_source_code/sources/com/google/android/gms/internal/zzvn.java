package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzvl.zzg;
import com.google.android.gms.tagmanager.zzbf;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzvn {
    public static final Integer zzaCx = Integer.valueOf(0);
    public static final Integer zzaCy = Integer.valueOf(1);
    private final Context mContext;
    private final ExecutorService zzazT;

    public zzvn(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzvn(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzazT = executorService;
    }

    private String zzdF(String str) {
        return "resource_" + str;
    }

    private byte[] zzf(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzlz.zza(inputStream, byteArrayOutputStream);
        } catch (IOException e) {
            zzbf.zzac("Failed to read the resource from disk");
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                zzbf.zzac("Error closing stream for reading resource from disk");
                return null;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void zza(String str, Integer num, zzvh zzvh, zzvm zzvm) {
        final String str2 = str;
        final Integer num2 = num;
        final zzvh zzvh2 = zzvh;
        final zzvm zzvm2 = zzvm;
        this.zzazT.execute(new Runnable(this) {
            final /* synthetic */ zzvn zzaCD;

            public void run() {
                this.zzaCD.zzb(str2, num2, zzvh2, zzvm2);
            }
        });
    }

    void zzb(String str, Integer num, zzvh zzvh, zzvm zzvm) {
        Object zzn;
        zzbf.zzab("DiskLoader: Starting to load resource from Disk.");
        try {
            zzn = zzvh.zzn(zzf(new FileInputStream(zzdE(str))));
            if (zzn != null) {
                zzbf.zzab("Saved resource loaded: " + zzdF(str));
                zzvm.zza(Status.zzNo, zzn, zzaCy, zzdD(str));
                return;
            }
        } catch (FileNotFoundException e) {
            zzbf.zzZ("Saved resource not found: " + zzdF(str));
        } catch (zzg e2) {
            zzbf.zzZ("Saved resource is corrupted: " + zzdF(str));
        }
        if (num == null) {
            zzvm.zza(Status.zzNq, null, null, 0);
            return;
        }
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(num.intValue());
            if (openRawResource != null) {
                zzn = zzvh.zzn(zzf(openRawResource));
                if (zzn != null) {
                    zzbf.zzab("Default resource loaded: " + this.mContext.getResources().getResourceEntryName(num.intValue()));
                    zzvm.zza(Status.zzNo, zzn, zzaCx, 0);
                    return;
                }
            }
        } catch (NotFoundException e3) {
            zzbf.zzZ("Default resource not found. ID: " + num);
        } catch (zzg e4) {
            zzbf.zzZ("Default resource resource is corrupted: " + num);
        }
        zzvm.zza(Status.zzNq, null, null, 0);
    }

    public long zzdD(String str) {
        File zzdE = zzdE(str);
        return zzdE.exists() ? zzdE.lastModified() : 0;
    }

    File zzdE(String str) {
        return new File(this.mContext.getDir("google_tagmanager", 0), zzdF(str));
    }

    public void zzf(final String str, final byte[] bArr) {
        this.zzazT.execute(new Runnable(this) {
            final /* synthetic */ zzvn zzaCD;

            public void run() {
                this.zzaCD.zzg(str, bArr);
            }
        });
    }

    void zzg(String str, byte[] bArr) {
        File zzdE = zzdE(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzdE);
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                    zzbf.zzab("Resource " + str + " saved on Disk.");
                } catch (IOException e) {
                    zzbf.zzZ("Error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                zzbf.zzZ("Error writing resource to disk. Removing resource from disk");
                zzdE.delete();
                try {
                    fileOutputStream.close();
                    zzbf.zzab("Resource " + str + " saved on Disk.");
                } catch (IOException e3) {
                    zzbf.zzZ("Error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                    zzbf.zzab("Resource " + str + " saved on Disk.");
                } catch (IOException e4) {
                    zzbf.zzZ("Error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            zzbf.zzZ("Error opening resource file for writing");
        }
    }
}
