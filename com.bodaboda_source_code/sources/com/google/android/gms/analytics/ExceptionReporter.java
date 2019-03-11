package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final Context mContext;
    private final UncaughtExceptionHandler zzBK;
    private final Tracker zzBL;
    private ExceptionParser zzBM;
    private GoogleAnalytics zzBN;

    public ExceptionReporter(Tracker tracker, UncaughtExceptionHandler originalHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.zzBK = originalHandler;
            this.zzBL = tracker;
            this.zzBM = new StandardExceptionParser(context, new ArrayList());
            this.mContext = context.getApplicationContext();
            zzae.zzab("ExceptionReporter created, original handler is " + (originalHandler == null ? "null" : originalHandler.getClass().getName()));
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.zzBM;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzBM = exceptionParser;
    }

    public void uncaughtException(Thread t, Throwable e) {
        String str = "UncaughtException";
        if (this.zzBM != null) {
            str = this.zzBM.getDescription(t != null ? t.getName() : null, e);
        }
        zzae.zzab("Tracking Exception: " + str);
        this.zzBL.send(new ExceptionBuilder().setDescription(str).setFatal(true).build());
        GoogleAnalytics zzfC = zzfC();
        zzfC.dispatchLocalHits();
        zzfC.zzfj();
        if (this.zzBK != null) {
            zzae.zzab("Passing exception to original handler.");
            this.zzBK.uncaughtException(t, e);
        }
    }

    GoogleAnalytics zzfC() {
        if (this.zzBN == null) {
            this.zzBN = GoogleAnalytics.getInstance(this.mContext);
        }
        return this.zzBN;
    }

    UncaughtExceptionHandler zzfD() {
        return this.zzBK;
    }
}
