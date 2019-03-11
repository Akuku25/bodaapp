package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.zzc.zzf;
import com.google.android.gms.internal.zzvd.zza;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzvl.zzc;
import com.google.android.gms.internal.zzvl.zzg;
import com.google.android.gms.internal.zzwx;
import com.google.android.gms.internal.zzwy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class zzcm implements zzf {
    private final Context mContext;
    private final String zzaxw;
    private zzbe<zza> zzazN;
    private final ExecutorService zzazT = Executors.newSingleThreadExecutor();

    /* renamed from: com.google.android.gms.tagmanager.zzcm$1 */
    class C02531 implements Runnable {
        final /* synthetic */ zzcm zzazU;

        C02531(zzcm zzcm) {
            this.zzazU = zzcm;
        }

        public void run() {
            this.zzazU.zztF();
        }
    }

    zzcm(Context context, String str) {
        this.mContext = context;
        this.zzaxw = str;
    }

    private zzc zza(ByteArrayOutputStream byteArrayOutputStream) {
        zzc zzc = null;
        try {
            zzc = zzay.zzdd(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbf.zzY("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
        } catch (JSONException e2) {
            zzbf.zzac("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return zzc;
    }

    private void zzd(zza zza) throws IllegalArgumentException {
        if (zza.zzgs == null && zza.zzaBL == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    private zzc zzl(byte[] bArr) {
        try {
            zzc zzb = zzvl.zzb(zzf.zza(bArr));
            if (zzb == null) {
                return zzb;
            }
            zzbf.zzab("The container was successfully loaded from the resource (using binary file)");
            return zzb;
        } catch (zzwx e) {
            zzbf.zzZ("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (zzg e2) {
            zzbf.zzac("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    public synchronized void release() {
        this.zzazT.shutdown();
    }

    public void zza(zzbe<zza> zzbe) {
        this.zzazN = zzbe;
    }

    public void zzb(final zza zza) {
        this.zzazT.execute(new Runnable(this) {
            final /* synthetic */ zzcm zzazU;

            public void run() {
                this.zzazU.zzc(zza);
            }
        });
    }

    boolean zzc(zza zza) {
        boolean z = false;
        File zztG = zztG();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zztG);
            try {
                fileOutputStream.write(zzwy.zzf(zza));
                z = true;
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    zzbf.zzac("error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                zzbf.zzac("Error writing resource to disk. Removing resource from disk.");
                zztG.delete();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zzbf.zzac("error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    zzbf.zzac("error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            zzbf.zzZ("Error opening resource file for writing");
        }
        return z;
    }

    public zzc zzhc(int i) {
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            zzbf.zzab("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzvl.zzc(openRawResource, byteArrayOutputStream);
                zzc zza = zza(byteArrayOutputStream);
                if (zza == null) {
                    return zzl(byteArrayOutputStream.toByteArray());
                }
                zzbf.zzab("The container was successfully loaded from the resource (using JSON file format)");
                return zza;
            } catch (IOException e) {
                zzbf.zzac("Error reading the default container with resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (NotFoundException e2) {
            zzbf.zzac("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }

    public void zzsS() {
        this.zzazT.execute(new C02531(this));
    }

    void zztF() {
        if (this.zzazN == null) {
            throw new IllegalStateException("Callback must be set before execute");
        }
        this.zzazN.zzsR();
        zzbf.zzab("Attempting to load resource from disk");
        if ((zzca.zztx().zzty() == zza.CONTAINER || zzca.zztx().zzty() == zza.CONTAINER_DEBUG) && this.zzaxw.equals(zzca.zztx().getContainerId())) {
            this.zzazN.zza(zzbe.zza.NOT_AVAILABLE);
            return;
        }
        try {
            InputStream fileInputStream = new FileInputStream(zztG());
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzvl.zzc(fileInputStream, byteArrayOutputStream);
                zza zzm = zza.zzm(byteArrayOutputStream.toByteArray());
                zzd(zzm);
                this.zzazN.zzo(zzm);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    zzbf.zzac("Error closing stream for reading resource from disk");
                }
            } catch (IOException e2) {
                this.zzazN.zza(zzbe.zza.IO_ERROR);
                zzbf.zzac("Failed to read the resource from disk");
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    zzbf.zzac("Error closing stream for reading resource from disk");
                }
            } catch (IllegalArgumentException e4) {
                this.zzazN.zza(zzbe.zza.IO_ERROR);
                zzbf.zzac("Failed to read the resource from disk. The resource is inconsistent");
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    zzbf.zzac("Error closing stream for reading resource from disk");
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    zzbf.zzac("Error closing stream for reading resource from disk");
                }
                throw th;
            }
            zzbf.zzab("The Disk resource was successfully read.");
        } catch (FileNotFoundException e7) {
            zzbf.zzY("Failed to find the resource in the disk");
            this.zzazN.zza(zzbe.zza.NOT_AVAILABLE);
        }
    }

    File zztG() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.zzaxw);
    }
}
