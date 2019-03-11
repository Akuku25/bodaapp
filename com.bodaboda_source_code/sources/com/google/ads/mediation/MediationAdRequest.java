package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zzd;
    private final Gender zze;
    private final Set<String> zzf;
    private final boolean zzg;
    private final Location zzh;

    public MediationAdRequest(Date birthday, Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.zzd = birthday;
        this.zze = gender;
        this.zzf = keywords;
        this.zzg = isTesting;
        this.zzh = location;
    }

    public Integer getAgeInYears() {
        if (this.zzd == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zzd);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzd;
    }

    public Gender getGender() {
        return this.zze;
    }

    public Set<String> getKeywords() {
        return this.zzf;
    }

    public Location getLocation() {
        return this.zzh;
    }

    public boolean isTesting() {
        return this.zzg;
    }
}
