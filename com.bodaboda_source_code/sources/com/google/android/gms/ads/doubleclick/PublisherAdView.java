package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.zzbp;

public final class PublisherAdView extends ViewGroup {
    private final zzbp zzll;

    public PublisherAdView(Context context) {
        super(context);
        this.zzll = new zzbp(this);
    }

    public PublisherAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzll = new zzbp(this, attrs, true);
    }

    public PublisherAdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzll = new zzbp(this, attrs, true);
    }

    public void destroy() {
        this.zzll.destroy();
    }

    public AdListener getAdListener() {
        return this.zzll.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzll.getAdSize();
    }

    public AdSize[] getAdSizes() {
        return this.zzll.getAdSizes();
    }

    public String getAdUnitId() {
        return this.zzll.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzll.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzll.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzll.getOnCustomRenderedAdLoadedListener();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzll.zza(publisherAdRequest.zzY());
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = ((right - left) - measuredWidth) / 2;
            int i2 = ((bottom - top) - measuredHeight) / 2;
            childAt.layout(i, i2, measuredWidth + i, measuredHeight + i2);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        int i = 0;
        View childAt = getChildAt(0);
        AdSize adSize = getAdSize();
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            measuredWidth = childAt.getMeasuredWidth();
            i = childAt.getMeasuredHeight();
        } else if (adSize != null) {
            Context context = getContext();
            measuredWidth = adSize.getWidthInPixels(context);
            i = adSize.getHeightInPixels(context);
        } else {
            measuredWidth = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), widthMeasureSpec), View.resolveSize(Math.max(i, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void pause() {
        this.zzll.pause();
    }

    public void recordManualImpression() {
        this.zzll.recordManualImpression();
    }

    public void resume() {
        this.zzll.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzll.setAdListener(adListener);
    }

    public void setAdSizes(AdSize... adSizes) {
        if (adSizes == null || adSizes.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzll.zza(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        this.zzll.setAdUnitId(adUnitId);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zzll.setAppEventListener(appEventListener);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzll.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }
}
