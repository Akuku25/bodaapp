package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.List;

public class zzc implements zzf<String> {
    public <T> String zza(zzb<T> zzb, T t) {
        return String.format("contains(%s,%s)", new Object[]{zzb.getName(), t});
    }

    public <T> String zza(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", new Object[]{operator.getTag(), metadataField.getName(), t});
    }

    public String zza(Operator operator, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder(operator.getTag() + "(");
        String str = "";
        for (String str2 : list) {
            stringBuilder.append(str);
            stringBuilder.append(str2);
            str = ",";
        }
        return stringBuilder.append(")").toString();
    }

    public /* synthetic */ Object zzb(zzb zzb, Object obj) {
        return zza(zzb, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, MetadataField metadataField, Object obj) {
        return zza(operator, metadataField, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, List list) {
        return zza(operator, list);
    }

    public String zzbC(String str) {
        return String.format("not(%s)", new Object[]{str});
    }

    public String zzbD(String str) {
        return String.format("fullTextSearch(%s)", new Object[]{str});
    }

    public /* synthetic */ Object zzbE(String str) {
        return zzbD(str);
    }

    public <T> String zzc(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", new Object[]{metadataField.getName(), t});
    }

    public /* synthetic */ Object zzd(MetadataField metadataField, Object obj) {
        return zzc(metadataField, obj);
    }

    public String zzd(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", new Object[]{metadataField.getName()});
    }

    public /* synthetic */ Object zze(MetadataField metadataField) {
        return zzd(metadataField);
    }

    public String zzle() {
        return "all()";
    }

    public /* synthetic */ Object zzlf() {
        return zzle();
    }

    public /* synthetic */ Object zzm(Object obj) {
        return zzbC((String) obj);
    }
}
