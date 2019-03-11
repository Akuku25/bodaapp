package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private T zzXN;
    private Bundle zzXO;
    private LinkedList<zza> zzXP;
    private final zzf<T> zzXQ = new C03111(this);

    private interface zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    /* renamed from: com.google.android.gms.dynamic.zza$1 */
    class C03111 implements zzf<T> {
        final /* synthetic */ zza zzXR;

        C03111(zza zza) {
            this.zzXR = zza;
        }

        public void zza(T t) {
            this.zzXR.zzXN = t;
            Iterator it = this.zzXR.zzXP.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzb(this.zzXR.zzXN);
            }
            this.zzXR.zzXP.clear();
            this.zzXR.zzXO = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza$6 */
    class C03156 implements zza {
        final /* synthetic */ zza zzXR;

        C03156(zza zza) {
            this.zzXR = zza;
        }

        public int getState() {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzXR.zzXN.onStart();
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza$7 */
    class C03167 implements zza {
        final /* synthetic */ zza zzXR;

        C03167(zza zza) {
            this.zzXR = zza;
        }

        public int getState() {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzXR.zzXN.onResume();
        }
    }

    private void zza(Bundle bundle, zza zza) {
        if (this.zzXN != null) {
            zza.zzb(this.zzXN);
            return;
        }
        if (this.zzXP == null) {
            this.zzXP = new LinkedList();
        }
        this.zzXP.add(zza);
        if (bundle != null) {
            if (this.zzXO == null) {
                this.zzXO = (Bundle) bundle.clone();
            } else {
                this.zzXO.putAll(bundle);
            }
        }
        zza(this.zzXQ);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence zze = GooglePlayServicesUtil.zze(context, isGooglePlayServicesAvailable);
        CharSequence zzf = GooglePlayServicesUtil.zzf(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zze);
        linearLayout.addView(textView);
        if (zzf != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzf);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.zzan(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzdd(int i) {
        while (!this.zzXP.isEmpty() && ((zza) this.zzXP.getLast()).getState() >= i) {
            this.zzXP.removeLast();
        }
    }

    public void onCreate(final Bundle savedInstanceState) {
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzXR;

            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzXR.zzXN.onCreate(savedInstanceState);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzXR;

            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.zzXR.zzXN.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.zzXN == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzXN != null) {
            this.zzXN.onDestroy();
        } else {
            zzdd(1);
        }
    }

    public void onDestroyView() {
        if (this.zzXN != null) {
            this.zzXN.onDestroyView();
        } else {
            zzdd(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzXR;

            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzXR.zzXN.onInflate(activity, attrs, savedInstanceState);
            }
        });
    }

    public void onLowMemory() {
        if (this.zzXN != null) {
            this.zzXN.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzXN != null) {
            this.zzXN.onPause();
        } else {
            zzdd(5);
        }
    }

    public void onResume() {
        zza(null, new C03167(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.zzXN != null) {
            this.zzXN.onSaveInstanceState(outState);
        } else if (this.zzXO != null) {
            outState.putAll(this.zzXO);
        }
    }

    public void onStart() {
        zza(null, new C03156(this));
    }

    public void onStop() {
        if (this.zzXN != null) {
            this.zzXN.onStop();
        } else {
            zzdd(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> zzf);

    public T zzlg() {
        return this.zzXN;
    }
}
