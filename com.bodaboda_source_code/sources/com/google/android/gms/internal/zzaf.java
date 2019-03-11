package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.internal.zzia.zza;
import com.google.android.gms.internal.zzia.zzd;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzaf implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean zzmJ = false;
    private boolean zznA;
    private boolean zznB;
    private BroadcastReceiver zznC;
    private final HashSet<zzac> zznD = new HashSet();
    private final zzcv zznE = new C03307(this);
    private final zzcv zznF = new C03318(this);
    private final zzcv zznG = new C03329(this);
    private final Object zznh = new Object();
    private final Context zznk;
    private final WeakReference<zzhe> zznn;
    private WeakReference<ViewTreeObserver> zzno;
    private final WeakReference<View> zznp;
    private final zzad zznq;
    private final zzdf zznr;
    private final zzia<zzah> zzns;
    private boolean zznt;
    private final WindowManager zznu;
    private final PowerManager zznv;
    private final KeyguardManager zznw;
    private zzag zznx;
    private boolean zzny = false;
    private long zznz = Long.MIN_VALUE;

    /* renamed from: com.google.android.gms.internal.zzaf$6 */
    class C01476 extends BroadcastReceiver {
        final /* synthetic */ zzaf zznI;

        C01476(zzaf zzaf) {
            this.zznI = zzaf;
        }

        public void onReceive(Context context, Intent intent) {
            this.zznI.zzh(false);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaf$2 */
    class C03262 implements zza {
        final /* synthetic */ zzaf zznI;

        C03262(zzaf zzaf) {
            this.zznI = zzaf;
        }

        public void run() {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaf$3 */
    class C03273 implements zza {
        final /* synthetic */ zzaf zznI;

        C03273(zzaf zzaf) {
            this.zznI = zzaf;
        }

        public void run() {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaf$4 */
    class C03284 implements zzd<zzah> {
        final /* synthetic */ zzaf zznI;

        C03284(zzaf zzaf) {
            this.zznI = zzaf;
        }

        public /* synthetic */ void zza(Object obj) {
            zzb((zzah) obj);
        }

        public void zzb(zzah zzah) {
            this.zznI.zznt = true;
            this.zznI.zza(zzah);
            this.zznI.zzbb();
            this.zznI.zzh(false);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaf$5 */
    class C03295 implements zza {
        final /* synthetic */ zzaf zznI;

        C03295(zzaf zzaf) {
            this.zznI = zzaf;
        }

        public void run() {
            this.zznI.destroy();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaf$7 */
    class C03307 implements zzcv {
        final /* synthetic */ zzaf zznI;

        C03307(zzaf zzaf) {
            this.zznI = zzaf;
        }

        public void zza(zzic zzic, Map<String, String> map) {
            if (this.zznI.zza((Map) map)) {
                this.zznI.zza(zzic.getWebView(), (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaf$8 */
    class C03318 implements zzcv {
        final /* synthetic */ zzaf zznI;

        C03318(zzaf zzaf) {
            this.zznI = zzaf;
        }

        public void zza(zzic zzic, Map<String, String> map) {
            if (this.zznI.zza((Map) map)) {
                zzhx.zzY("Received request to untrack: " + this.zznI.zznq.zzaZ());
                this.zznI.destroy();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaf$9 */
    class C03329 implements zzcv {
        final /* synthetic */ zzaf zznI;

        C03329(zzaf zzaf) {
            this.zznI = zzaf;
        }

        public void zza(zzic zzic, Map<String, String> map) {
            if (this.zznI.zza((Map) map) && map.containsKey("isVisible")) {
                boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                this.zznI.zzg(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    public zzaf(zzba zzba, zzhe zzhe, zzhy zzhy, View view, zzdf zzdf) {
        this.zznr = zzdf;
        this.zznn = new WeakReference(zzhe);
        this.zznp = new WeakReference(view);
        this.zzno = new WeakReference(null);
        this.zznA = true;
        this.zznq = new zzad(UUID.randomUUID().toString(), zzhy, zzba.zzpa, zzhe.zzys, zzhe.zzba());
        this.zzns = this.zznr.zzcJ();
        this.zznu = (WindowManager) view.getContext().getSystemService("window");
        this.zznv = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.zznw = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.zznk = view.getContext().getApplicationContext();
        try {
            final JSONObject zzd = zzd(view);
            this.zzns.zza(new zzd<zzah>(this) {
                final /* synthetic */ zzaf zznI;

                public /* synthetic */ void zza(Object obj) {
                    zzb((zzah) obj);
                }

                public void zzb(zzah zzah) {
                    this.zznI.zza(zzd);
                }
            }, new C03273(this));
        } catch (JSONException e) {
        } catch (Throwable e2) {
            zzhx.zzb("Failure while processing active view data.", e2);
        }
        this.zzns.zza(new C03284(this), new C03295(this));
        zzhx.zzY("Tracking ad unit: " + this.zznq.zzaZ());
    }

    protected void destroy() {
        synchronized (this.zznh) {
            zzbh();
            zzbc();
            this.zznA = false;
            zzbe();
            this.zznr.zzb(this.zzns);
        }
    }

    public void onGlobalLayout() {
        zzh(false);
    }

    public void onScrollChanged() {
        zzh(true);
    }

    public void pause() {
        synchronized (this.zznh) {
            this.zzmJ = true;
            zzh(false);
        }
    }

    public void resume() {
        synchronized (this.zznh) {
            this.zzmJ = false;
            zzh(false);
        }
    }

    public void stop() {
        synchronized (this.zznh) {
            this.zzny = true;
            zzh(false);
        }
    }

    protected int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    protected void zza(View view, Map<String, String> map) {
        zzh(false);
    }

    public void zza(zzac zzac) {
        this.zznD.add(zzac);
    }

    public void zza(zzag zzag) {
        synchronized (this.zznh) {
            this.zznx = zzag;
        }
    }

    protected void zza(zzah zzah) {
        zzah.zza("/updateActiveView", this.zznE);
        zzah.zza("/untrackActiveViewUnit", this.zznF);
        zzah.zza("/visibilityChanged", this.zznG);
    }

    protected void zza(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            final JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            this.zzns.zza(new zzd<zzah>(this) {
                final /* synthetic */ zzaf zznI;

                public /* synthetic */ void zza(Object obj) {
                    zzb((zzah) obj);
                }

                public void zzb(zzah zzah) {
                    zzah.zza("AFMA_updateActiveView", jSONObject2);
                }
            }, new C03262(this));
        } catch (Throwable th) {
            zzhx.zzb("Skipping active view message.", th);
        }
    }

    protected boolean zza(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        boolean z = !TextUtils.isEmpty(str) && str.equals(this.zznq.zzaZ());
        return z;
    }

    protected void zzbb() {
        synchronized (this.zznh) {
            if (this.zznC != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.zznC = new C01476(this);
            this.zznk.registerReceiver(this.zznC, intentFilter);
        }
    }

    protected void zzbc() {
        synchronized (this.zznh) {
            if (this.zznC != null) {
                this.zznk.unregisterReceiver(this.zznC);
                this.zznC = null;
            }
        }
    }

    public void zzbd() {
        synchronized (this.zznh) {
            if (this.zznA) {
                this.zznB = true;
                try {
                    zza(zzbj());
                } catch (Throwable e) {
                    zzhx.zzb("JSON failure while processing active view data.", e);
                } catch (Throwable e2) {
                    zzhx.zzb("Failure while processing active view data.", e2);
                }
                zzhx.zzY("Untracking ad unit: " + this.zznq.zzaZ());
            }
        }
    }

    protected void zzbe() {
        if (this.zznx != null) {
            this.zznx.zza(this);
        }
    }

    public boolean zzbf() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zznA;
        }
        return z;
    }

    protected void zzbg() {
        View view = (View) this.zznp.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzno.get();
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.zzno = new WeakReference(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
        }
    }

    protected void zzbh() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzno.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject zzbi() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.zznq.zzaX()).put("activeViewJSON", this.zznq.zzaY()).put("timestamp", zzab.zzaQ().elapsedRealtime()).put("adFormat", this.zznq.zzaW()).put("hashCode", this.zznq.zzaZ()).put("isMraid", this.zznq.zzba());
        return jSONObject;
    }

    protected JSONObject zzbj() throws JSONException {
        JSONObject zzbi = zzbi();
        zzbi.put("doneReasonCode", "u");
        return zzbi;
    }

    protected JSONObject zzd(View view) throws JSONException {
        boolean zzi = zzab.zzaO().zzi(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            zzhx.zzb("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.zznu.getDefaultDisplay().getWidth();
        rect2.bottom = this.zznu.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject zzbi = zzbi();
        zzbi.put("windowVisibility", view.getWindowVisibility()).put("isStopped", this.zzny).put("isPaused", this.zzmJ).put("isAttachedToWindow", zzi).put("viewBox", new JSONObject().put("top", zza(rect2.top, displayMetrics)).put("bottom", zza(rect2.bottom, displayMetrics)).put("left", zza(rect2.left, displayMetrics)).put("right", zza(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", zza(rect.top, displayMetrics)).put("bottom", zza(rect.bottom, displayMetrics)).put("left", zza(rect.left, displayMetrics)).put("right", zza(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", zza(rect3.top, displayMetrics)).put("bottom", zza(rect3.bottom, displayMetrics)).put("left", zza(rect3.left, displayMetrics)).put("right", zza(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect4.top, displayMetrics)).put("bottom", zza(rect4.bottom, displayMetrics)).put("left", zza(rect4.left, displayMetrics)).put("right", zza(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect5.top, displayMetrics)).put("bottom", zza(rect5.bottom, displayMetrics)).put("left", zza(rect5.left, displayMetrics)).put("right", zza(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", zze(view));
        return zzbi;
    }

    protected boolean zze(View view) {
        return view.getVisibility() == 0 && view.isShown() && this.zznv.isScreenOn() && (!this.zznw.inKeyguardRestrictedInputMode() || zzab.zzaM().zzes());
    }

    protected void zzg(boolean z) {
        Iterator it = this.zznD.iterator();
        while (it.hasNext()) {
            ((zzac) it.next()).zza(this, z);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void zzh(boolean r9) {
        /*
        r8 = this;
        r2 = r8.zznh;
        monitor-enter(r2);
        r0 = r8.zznt;	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r8.zznA;	 Catch:{ all -> 0x0022 }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = com.google.android.gms.internal.zzab.zzaQ();	 Catch:{ all -> 0x0022 }
        r0 = r0.elapsedRealtime();	 Catch:{ all -> 0x0022 }
        if (r9 == 0) goto L_0x0025;
    L_0x0017:
        r4 = r8.zznz;	 Catch:{ all -> 0x0022 }
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r4 = r4 + r6;
        r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r3 <= 0) goto L_0x0025;
    L_0x0020:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        goto L_0x000c;
    L_0x0022:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        throw r0;
    L_0x0025:
        r8.zznz = r0;	 Catch:{ all -> 0x0022 }
        r0 = r8.zznn;	 Catch:{ all -> 0x0022 }
        r0 = r0.get();	 Catch:{ all -> 0x0022 }
        r0 = (com.google.android.gms.internal.zzhe) r0;	 Catch:{ all -> 0x0022 }
        r1 = r8.zznp;	 Catch:{ all -> 0x0022 }
        r1 = r1.get();	 Catch:{ all -> 0x0022 }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x003b;
    L_0x0039:
        if (r0 != 0) goto L_0x0043;
    L_0x003b:
        r0 = 1;
    L_0x003c:
        if (r0 == 0) goto L_0x0045;
    L_0x003e:
        r8.zzbd();	 Catch:{ all -> 0x0022 }
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        goto L_0x000c;
    L_0x0043:
        r0 = 0;
        goto L_0x003c;
    L_0x0045:
        r0 = r8.zzd(r1);	 Catch:{ JSONException -> 0x0054, RuntimeException -> 0x005b }
        r8.zza(r0);	 Catch:{ JSONException -> 0x0054, RuntimeException -> 0x005b }
    L_0x004c:
        r8.zzbg();	 Catch:{ all -> 0x0022 }
        r8.zzbe();	 Catch:{ all -> 0x0022 }
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        goto L_0x000c;
    L_0x0054:
        r0 = move-exception;
        r1 = "Active view update failed.";
        com.google.android.gms.internal.zzhx.zza(r1, r0);	 Catch:{ all -> 0x0022 }
        goto L_0x004c;
    L_0x005b:
        r0 = move-exception;
        r1 = "Active view update failed.";
        com.google.android.gms.internal.zzhx.zza(r1, r0);	 Catch:{ all -> 0x0022 }
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaf.zzh(boolean):void");
    }
}
