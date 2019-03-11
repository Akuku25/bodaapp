package com.google.android.gms.internal;

import android.support.v4.widget.ExploreByTouchHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgi
public class zzal {
    private final Object zznh = new Object();
    private int zzog;
    private List<zzak> zzoh = new LinkedList();

    public boolean zza(zzak zzak) {
        boolean z;
        synchronized (this.zznh) {
            if (this.zzoh.contains(zzak)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean zzb(zzak zzak) {
        boolean z;
        synchronized (this.zznh) {
            Iterator it = this.zzoh.iterator();
            while (it.hasNext()) {
                zzak zzak2 = (zzak) it.next();
                if (zzak != zzak2 && zzak2.zzbm().equals(zzak.zzbm())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public zzak zzbs() {
        zzak zzak = null;
        synchronized (this.zznh) {
            if (this.zzoh.size() == 0) {
                zzhx.zzY("Queue empty");
                return null;
            } else if (this.zzoh.size() >= 2) {
                int i = ExploreByTouchHelper.INVALID_ID;
                for (zzak zzak2 : this.zzoh) {
                    zzak zzak3;
                    int i2;
                    int score = zzak2.getScore();
                    if (score > i) {
                        int i3 = score;
                        zzak3 = zzak2;
                        i2 = i3;
                    } else {
                        i2 = i;
                        zzak3 = zzak;
                    }
                    i = i2;
                    zzak = zzak3;
                }
                this.zzoh.remove(zzak);
                return zzak;
            } else {
                zzak2 = (zzak) this.zzoh.get(0);
                zzak2.zzbn();
                return zzak2;
            }
        }
    }

    public void zzc(zzak zzak) {
        synchronized (this.zznh) {
            if (this.zzoh.size() >= 10) {
                zzhx.zzY("Queue is full, current size = " + this.zzoh.size());
                this.zzoh.remove(0);
            }
            int i = this.zzog;
            this.zzog = i + 1;
            zzak.zzc(i);
            this.zzoh.add(zzak);
        }
    }
}
