package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzy.zza;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> zzED = new HashMap();
        ProductAction zzEE;
        Map<String, List<Product>> zzEF = new HashMap();
        List<Promotion> zzEG = new ArrayList();
        List<Product> zzEH = new ArrayList();

        protected HitBuilder() {
        }

        public T addImpression(Product product, String impressionList) {
            if (product == null) {
                zzae.zzac("product should be non-null");
            } else {
                if (impressionList == null) {
                    impressionList = "";
                }
                if (!this.zzEF.containsKey(impressionList)) {
                    this.zzEF.put(impressionList, new ArrayList());
                }
                ((List) this.zzEF.get(impressionList)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzae.zzac("product should be non-null");
            } else {
                this.zzEH.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzae.zzac("promotion should be non-null");
            } else {
                this.zzEG.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.zzED);
            if (this.zzEE != null) {
                hashMap.putAll(this.zzEE.build());
            }
            int i = 1;
            for (Promotion zzaw : this.zzEG) {
                hashMap.putAll(zzaw.zzaw(zzs.zzH(i)));
                i++;
            }
            i = 1;
            for (Product zzaw2 : this.zzEH) {
                hashMap.putAll(zzaw2.zzaw(zzs.zzG(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.zzEF.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String zzJ = zzs.zzJ(i2);
                int i3 = 1;
                for (Product zzaw3 : list) {
                    hashMap.putAll(zzaw3.zzaw(zzJ + zzs.zzI(i3)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    hashMap.put(zzJ + "nm", entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        protected String get(String paramName) {
            return (String) this.zzED.get(paramName);
        }

        public final T set(String paramName, String paramValue) {
            zzy.zzfV().zza(zza.MAP_BUILDER_SET);
            if (paramName != null) {
                this.zzED.put(paramName, paramValue);
            } else {
                zzae.zzac(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> params) {
            zzy.zzfV().zza(zza.MAP_BUILDER_SET_ALL);
            if (params != null) {
                this.zzED.putAll(new HashMap(params));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String utmParams) {
            zzy.zzfV().zza(zza.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
            Object zzau = zzan.zzau(utmParams);
            if (!TextUtils.isEmpty(zzau)) {
                Map zzat = zzan.zzat(zzau);
                set("&cc", (String) zzat.get("utm_content"));
                set("&cm", (String) zzat.get("utm_medium"));
                set("&cn", (String) zzat.get("utm_campaign"));
                set("&cs", (String) zzat.get("utm_source"));
                set("&ck", (String) zzat.get("utm_term"));
                set("&ci", (String) zzat.get("utm_id"));
                set("&gclid", (String) zzat.get("gclid"));
                set("&dclid", (String) zzat.get("dclid"));
                set("&gmob_t", (String) zzat.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int index, String dimension) {
            set(zzs.zzE(index), dimension);
            return this;
        }

        public T setCustomMetric(int index, float metric) {
            set(zzs.zzF(index), Float.toString(metric));
            return this;
        }

        protected T setHitType(String hitType) {
            set("&t", hitType);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean nonInteraction) {
            set("&ni", zzan.zzG(nonInteraction));
            return this;
        }

        public T setProductAction(ProductAction action) {
            this.zzEE = action;
            return this;
        }

        public T setPromotionAction(String action) {
            this.zzED.put("&promoa", action);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_EVENT);
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String category, String action) {
            this();
            setCategory(category);
            setAction(action);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String action) {
            set("&ea", action);
            return this;
        }

        public EventBuilder setCategory(String category) {
            set("&ec", category);
            return this;
        }

        public EventBuilder setLabel(String label) {
            set("&el", label);
            return this;
        }

        public EventBuilder setValue(long value) {
            set("&ev", Long.toString(value));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_EXCEPTION);
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String description) {
            set("&exd", description);
            return this;
        }

        public ExceptionBuilder setFatal(boolean fatal) {
            set("&exf", zzan.zzG(fatal));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_ITEM);
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String category) {
            set("&iv", category);
            return this;
        }

        public ItemBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public ItemBuilder setName(String name) {
            set("&in", name);
            return this;
        }

        public ItemBuilder setPrice(double price) {
            set("&ip", Double.toString(price));
            return this;
        }

        public ItemBuilder setQuantity(long quantity) {
            set("&iq", Long.toString(quantity));
            return this;
        }

        public ItemBuilder setSku(String sku) {
            set("&ic", sku);
            return this;
        }

        public ItemBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_SOCIAL);
            set("&t", "social");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String action) {
            set("&sa", action);
            return this;
        }

        public SocialBuilder setNetwork(String network) {
            set("&sn", network);
            return this;
        }

        public SocialBuilder setTarget(String target) {
            set("&st", target);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_TIMING);
            set("&t", "timing");
        }

        public TimingBuilder(String category, String variable, long value) {
            this();
            setVariable(variable);
            setValue(value);
            setCategory(category);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String category) {
            set("&utc", category);
            return this;
        }

        public TimingBuilder setLabel(String label) {
            set("&utl", label);
            return this;
        }

        public TimingBuilder setValue(long value) {
            set("&utt", Long.toString(value));
            return this;
        }

        public TimingBuilder setVariable(String variable) {
            set("&utv", variable);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_TRANSACTION);
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String affiliation) {
            set("&ta", affiliation);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public TransactionBuilder setRevenue(double revenue) {
            set("&tr", Double.toString(revenue));
            return this;
        }

        public TransactionBuilder setShipping(double shipping) {
            set("&ts", Double.toString(shipping));
            return this;
        }

        public TransactionBuilder setTax(double tax) {
            set("&tt", Double.toString(tax));
            return this;
        }

        public TransactionBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }
}
