package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.internal.zziz.zza;
import com.google.android.gms.internal.zzop.zzb;
import com.google.android.gms.internal.zzop.zzc;
import com.google.android.gms.internal.zzop.zzd;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;

public class zzji {
    private static zzir zza(String str, zzc zzc) {
        return new zzir(zzwy.zzf(zzc), new zza(str).zzI(true).zzaA(str).zzaz("blob").zzgX());
    }

    public static zzjb zza(Action action, long j, String str, int i) {
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzgZ());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent zza = zzjj.zza(str, Uri.parse(bundle2.getString(PlusShare.KEY_CALL_TO_ACTION_URL)));
        zzin.zza zza2 = zzjb.zza(zza, string, parse, string2, null);
        if (bundle.containsKey(".private:ssbContext")) {
            zza2.zza(zzir.zzd(bundle.getByteArray(".private:ssbContext")));
            action.zzgZ().remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            zza2.zza(new Account(bundle.getString(".private:accountName"), GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            action.zzgZ().remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly")) {
            i = 4;
            action.zzgZ().remove(".private:isContextOnly");
        }
        int i2 = i;
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            action.zzgZ().remove(".private:isDeviceOnly");
        }
        zza2.zza(zza(".private:action", zzh(action.zzgZ())));
        return new zzjb(zzjb.zza(str, zza), j, i2, null, zza2.zzgU(), z, -1);
    }

    static zzc zzh(Bundle bundle) {
        zzc zzc = new zzc();
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            zzb zzb = new zzb();
            zzb.name = str;
            zzb.zzalj = new zzd();
            if (obj instanceof String) {
                zzb.zzalj.zzQN = (String) obj;
            } else if (obj instanceof Bundle) {
                zzb.zzalj.zzalo = zzh((Bundle) obj);
            } else {
                Log.e("AppDataSearchClient", "Unsupported value: " + obj);
            }
            arrayList.add(zzb);
        }
        if (bundle.containsKey("type")) {
            zzc.type = bundle.getString("type");
        }
        zzc.zzalk = (zzb[]) arrayList.toArray(new zzb[arrayList.size()]);
        return zzc;
    }
}
