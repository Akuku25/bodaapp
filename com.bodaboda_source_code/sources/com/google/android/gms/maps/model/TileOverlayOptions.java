package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.model.internal.zzo;
import com.google.android.gms.maps.model.internal.zzo.zza;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzw CREATOR = new zzw();
    private final int zzFG;
    private zzo zzarH;
    private TileProvider zzarI;
    private boolean zzarJ;
    private float zzarb;
    private boolean zzarc;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions$1 */
    class C03871 implements TileProvider {
        private final zzo zzarK = this.zzarL.zzarH;
        final /* synthetic */ TileOverlayOptions zzarL;

        C03871(TileOverlayOptions tileOverlayOptions) {
            this.zzarL = tileOverlayOptions;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.zzarK.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    public TileOverlayOptions() {
        this.zzarc = true;
        this.zzarJ = true;
        this.zzFG = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.zzarc = true;
        this.zzarJ = true;
        this.zzFG = versionCode;
        this.zzarH = zza.zzcf(delegate);
        this.zzarI = this.zzarH == null ? null : new C03871(this);
        this.zzarc = visible;
        this.zzarb = zIndex;
        this.zzarJ = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.zzarJ = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzarJ;
    }

    public TileProvider getTileProvider() {
        return this.zzarI;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public float getZIndex() {
        return this.zzarb;
    }

    public boolean isVisible() {
        return this.zzarc;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.zzarI = tileProvider;
        this.zzarH = this.zzarI == null ? null : new zza(this) {
            final /* synthetic */ TileOverlayOptions zzarL;

            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.zzarc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (zzaa.zzqF()) {
            zzx.zza(this, out, flags);
        } else {
            zzw.zza(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.zzarb = zIndex;
        return this;
    }

    IBinder zzqK() {
        return this.zzarH.asBinder();
    }
}
