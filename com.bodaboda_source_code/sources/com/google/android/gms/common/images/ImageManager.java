package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzme;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zzOl = new Object();
    private static HashSet<Uri> zzOm = new HashSet();
    private static ImageManager zzOn;
    private static ImageManager zzOo;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzOp = Executors.newFixedThreadPool(4);
    private final zzb zzOq;
    private final zzkm zzOr;
    private final Map<zza, ImageReceiver> zzOs;
    private final Map<Uri, ImageReceiver> zzOt;
    private final Map<Uri, Long> zzOu;

    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> zzOv = new ArrayList();
        final /* synthetic */ ImageManager zzOw;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zzOw = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.zzOw.zzOp.execute(new zzc(this.zzOw, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(zza zza) {
            com.google.android.gms.common.internal.zzb.zzbd("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzOv.add(zza);
        }

        public void zzc(zza zza) {
            com.google.android.gms.common.internal.zzb.zzbd("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzOv.remove(zza);
        }

        public void zziH() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.zzOw.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        final /* synthetic */ ImageManager zzOw;
        private final ParcelFileDescriptor zzOx;

        public zzc(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzOw = imageManager;
            this.mUri = uri;
            this.zzOx = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzbe("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzOx != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzOx.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.zzOx.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzOw.mHandler.post(new zzf(this.zzOw, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class zzd implements Runnable {
        final /* synthetic */ ImageManager zzOw;
        private final zza zzOy;

        public zzd(ImageManager imageManager, zza zza) {
            this.zzOw = imageManager;
            this.zzOy = zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzbd("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.zzOw.zzOs.get(this.zzOy);
            if (imageReceiver != null) {
                this.zzOw.zzOs.remove(this.zzOy);
                imageReceiver.zzc(this.zzOy);
            }
            zza zza = this.zzOy.zzOA;
            if (zza.uri == null) {
                this.zzOy.zza(this.zzOw.mContext, this.zzOw.zzOr, true);
                return;
            }
            Bitmap zza2 = this.zzOw.zza(zza);
            if (zza2 != null) {
                this.zzOy.zza(this.zzOw.mContext, zza2, true);
                return;
            }
            Long l = (Long) this.zzOw.zzOu.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzOy.zza(this.zzOw.mContext, this.zzOw.zzOr, true);
                    return;
                }
                this.zzOw.zzOu.remove(zza.uri);
            }
            this.zzOy.zza(this.zzOw.mContext, this.zzOw.zzOr);
            imageReceiver = (ImageReceiver) this.zzOw.zzOt.get(zza.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.zzOw, zza.uri);
                this.zzOw.zzOt.put(zza.uri, imageReceiver);
            }
            imageReceiver.zzb(this.zzOy);
            if (!(this.zzOy instanceof com.google.android.gms.common.images.zza.zzc)) {
                this.zzOw.zzOs.put(this.zzOy, imageReceiver);
            }
            synchronized (ImageManager.zzOl) {
                if (!ImageManager.zzOm.contains(zza.uri)) {
                    ImageManager.zzOm.add(zza.uri);
                    imageReceiver.zziH();
                }
            }
        }
    }

    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzOq;

        public zze(zzb zzb) {
            this.zzOq = zzb;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.zzOq.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.zzOq.evictAll();
            } else if (level >= 20) {
                this.zzOq.trimToSize(this.zzOq.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        final /* synthetic */ ImageManager zzOw;
        private boolean zzOz;
        private final CountDownLatch zzmx;

        public zzf(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zzOw = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzOz = z;
            this.zzmx = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.zzOv;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza zza2 = (zza) zza.get(i);
                if (z) {
                    zza2.zza(this.zzOw.mContext, this.mBitmap, false);
                } else {
                    this.zzOw.zzOu.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza2.zza(this.zzOw.mContext, this.zzOw.zzOr, false);
                }
                if (!(zza2 instanceof com.google.android.gms.common.images.zza.zzc)) {
                    this.zzOw.zzOs.remove(zza2);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzbd("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.zzOw.zzOq != null) {
                if (this.zzOz) {
                    this.zzOw.zzOq.evictAll();
                    System.gc();
                    this.zzOz = false;
                    this.zzOw.mHandler.post(this);
                    return;
                } else if (z) {
                    this.zzOw.zzOq.put(new zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.zzOw.zzOt.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzmx.countDown();
            synchronized (ImageManager.zzOl) {
                ImageManager.zzOm.remove(this.mUri);
            }
        }
    }

    private static final class zzb extends zzkv<zza, Bitmap> {
        public zzb(Context context) {
            super(zzO(context));
        }

        private static int zzO(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !zzme.zzkd()) ? activityManager.getMemoryClass() : zza.zza(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            zza(x0, (zza) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return zza((zza) x0, (Bitmap) x1);
        }

        protected int zza(zza zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void zza(boolean z, zza zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, zza, bitmap, bitmap2);
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.zzOq = new zzb(this.mContext);
            if (zzme.zzkg()) {
                zziE();
            }
        } else {
            this.zzOq = null;
        }
        this.zzOr = new zzkm();
        this.zzOs = new HashMap();
        this.zzOt = new HashMap();
        this.zzOu = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzb(context, false);
    }

    private Bitmap zza(zza zza) {
        return this.zzOq == null ? null : (Bitmap) this.zzOq.get(zza);
    }

    public static ImageManager zzb(Context context, boolean z) {
        if (z) {
            if (zzOo == null) {
                zzOo = new ImageManager(context, true);
            }
            return zzOo;
        }
        if (zzOn == null) {
            zzOn = new ImageManager(context, false);
        }
        return zzOn;
    }

    private void zziE() {
        this.mContext.registerComponentCallbacks(new zze(this.zzOq));
    }

    public void loadImage(ImageView imageView, int resId) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        zza zzb = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        zzb.zzaC(defaultResId);
        zza(zzb);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzc(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        zza zzc = new com.google.android.gms.common.images.zza.zzc(listener, uri);
        zzc.zzaC(defaultResId);
        zza(zzc);
    }

    public void zza(zza zza) {
        com.google.android.gms.common.internal.zzb.zzbd("ImageManager.loadImage() must be called in the main thread");
        new zzd(this, zza).run();
    }
}
