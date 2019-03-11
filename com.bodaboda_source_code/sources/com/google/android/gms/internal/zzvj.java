package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;

public class zzvj {
    private final List<zzve> zzaBY = new ArrayList();

    public String getId() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (zzve zzve : this.zzaBY) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("#");
            }
            stringBuilder.append(zzve.getContainerId());
        }
        return stringBuilder.toString();
    }

    public zzvj zzb(zzve zzve) throws IllegalArgumentException {
        zzx.zzl(zzve);
        for (zzve containerId : this.zzaBY) {
            if (containerId.getContainerId().equals(zzve.getContainerId())) {
                throw new IllegalArgumentException("The container is already being requested. " + zzve.getContainerId());
            }
        }
        this.zzaBY.add(zzve);
        return this;
    }

    public List<zzve> zzun() {
        return this.zzaBY;
    }
}
