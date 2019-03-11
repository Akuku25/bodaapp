package com.actionbarsherlock.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.Handler;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class ActivityChooserModel extends DataSetObservable {
    private static final String ATTRIBUTE_ACTIVITY = "activity";
    private static final String ATTRIBUTE_TIME = "time";
    private static final String ATTRIBUTE_WEIGHT = "weight";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    private static final Executor SERIAL_EXECUTOR = Executors.newSingleThreadExecutor();
    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
    private static final Object sRegistryLock = new Object();
    private final List<ActivityResolveInfo> mActivites = new ArrayList();
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter = new DefaultSorter();
    private boolean mCanReadHistoricalData = true;
    private final Context mContext;
    private final Handler mHandler = new Handler();
    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
    private boolean mHistoricalRecordsChanged = true;
    private final String mHistoryFileName;
    private int mHistoryMaxSize = 50;
    private final Object mInstanceLock = new Object();
    private Intent mIntent;
    private boolean mReadShareHistoryCalled = false;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((ActivityResolveInfo) obj).weight)) {
                return false;
            }
            return true;
        }

        public int compareTo(ActivityResolveInfo another) {
            return Float.floatToIntBits(another.weight) - Float.floatToIntBits(this.weight);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(this.resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal((double) this.weight));
            builder.append("]");
            return builder.toString();
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
        }

        public HistoricalRecord(ComponentName activityName, long time, float weight) {
            this.activity = activityName;
            this.time = time;
            this.weight = weight;
        }

        public int hashCode() {
            return (((((this.activity == null ? 0 : this.activity.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            HistoricalRecord other = (HistoricalRecord) obj;
            if (this.activity == null) {
                if (other.activity != null) {
                    return false;
                }
            } else if (!this.activity.equals(other.activity)) {
                return false;
            }
            if (this.time != other.time) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(other.weight)) {
                return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(this.activity);
            builder.append("; time:").append(this.time);
            builder.append("; weight:").append(new BigDecimal((double) this.weight));
            builder.append("]");
            return builder.toString();
        }
    }

    private final class HistoryLoader implements Runnable {

        /* renamed from: com.actionbarsherlock.widget.ActivityChooserModel$HistoryLoader$1 */
        class C00751 implements Runnable {
            C00751() {
            }

            public void run() {
                ActivityChooserModel.this.pruneExcessiveHistoricalRecordsLocked();
                ActivityChooserModel.this.sortActivities();
            }
        }

        private HistoryLoader() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r25 = this;
            r5 = 0;
            r0 = r25;
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ FileNotFoundException -> 0x0077 }
            r22 = r0;
            r22 = r22.mContext;	 Catch:{ FileNotFoundException -> 0x0077 }
            r0 = r25;
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ FileNotFoundException -> 0x0077 }
            r23 = r0;
            r23 = r23.mHistoryFileName;	 Catch:{ FileNotFoundException -> 0x0077 }
            r5 = r22.openFileInput(r23);	 Catch:{ FileNotFoundException -> 0x0077 }
            r13 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r22 = 0;
            r0 = r22;
            r13.setInput(r5, r0);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r18 = 0;
        L_0x0026:
            r22 = 1;
            r0 = r18;
            r1 = r22;
            if (r0 == r1) goto L_0x0036;
        L_0x002e:
            r22 = 2;
            r0 = r18;
            r1 = r22;
            if (r0 != r1) goto L_0x0079;
        L_0x0036:
            r22 = "historical-records";
            r23 = r13.getName();	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r22 = r22.equals(r23);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            if (r22 != 0) goto L_0x007e;
        L_0x0042:
            r22 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r23 = "Share records file does not start with historical-records tag.";
            r22.<init>(r23);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            throw r22;	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
        L_0x004a:
            r21 = move-exception;
            r22 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x0159 }
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0159 }
            r24 = "Error reading historical recrod file: ";
            r23.<init>(r24);	 Catch:{ all -> 0x0159 }
            r0 = r25;
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x0159 }
            r24 = r0;
            r24 = r24.mHistoryFileName;	 Catch:{ all -> 0x0159 }
            r23 = r23.append(r24);	 Catch:{ all -> 0x0159 }
            r23 = r23.toString();	 Catch:{ all -> 0x0159 }
            r0 = r22;
            r1 = r23;
            r2 = r21;
            android.util.Log.e(r0, r1, r2);	 Catch:{ all -> 0x0159 }
            if (r5 == 0) goto L_0x0076;
        L_0x0073:
            r5.close();	 Catch:{ IOException -> 0x01aa }
        L_0x0076:
            return;
        L_0x0077:
            r6 = move-exception;
            goto L_0x0076;
        L_0x0079:
            r18 = r13.next();	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            goto L_0x0026;
        L_0x007e:
            r15 = new java.util.ArrayList;	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r15.<init>();	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
        L_0x0083:
            r18 = r13.next();	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r22 = 1;
            r0 = r18;
            r1 = r22;
            if (r0 != r1) goto L_0x00ca;
        L_0x008f:
            r0 = r25;
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r22 = r0;
            r23 = r22.mInstanceLock;	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            monitor-enter(r23);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r19 = new java.util.LinkedHashSet;	 Catch:{ all -> 0x01a7 }
            r0 = r19;
            r0.<init>(r15);	 Catch:{ all -> 0x01a7 }
            r0 = r25;
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x01a7 }
            r22 = r0;
            r8 = r22.mHistoricalRecords;	 Catch:{ all -> 0x01a7 }
            r9 = r8.size();	 Catch:{ all -> 0x01a7 }
            r10 = r9 + -1;
        L_0x00b1:
            if (r10 >= 0) goto L_0x0160;
        L_0x00b3:
            r22 = r8.size();	 Catch:{ all -> 0x01a7 }
            r24 = r19.size();	 Catch:{ all -> 0x01a7 }
            r0 = r22;
            r1 = r24;
            if (r0 != r1) goto L_0x016f;
        L_0x00c1:
            monitor-exit(r23);	 Catch:{ all -> 0x01a7 }
            if (r5 == 0) goto L_0x0076;
        L_0x00c4:
            r5.close();	 Catch:{ IOException -> 0x00c8 }
            goto L_0x0076;
        L_0x00c8:
            r22 = move-exception;
            goto L_0x0076;
        L_0x00ca:
            r22 = 3;
            r0 = r18;
            r1 = r22;
            if (r0 == r1) goto L_0x0083;
        L_0x00d2:
            r22 = 4;
            r0 = r18;
            r1 = r22;
            if (r0 == r1) goto L_0x0083;
        L_0x00da:
            r12 = r13.getName();	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r22 = "historical-record";
            r0 = r22;
            r22 = r0.equals(r12);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            if (r22 != 0) goto L_0x011f;
        L_0x00e8:
            r22 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r23 = "Share records file not well-formed.";
            r22.<init>(r23);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            throw r22;	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
        L_0x00f0:
            r11 = move-exception;
            r22 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x0159 }
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0159 }
            r24 = "Error reading historical recrod file: ";
            r23.<init>(r24);	 Catch:{ all -> 0x0159 }
            r0 = r25;
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x0159 }
            r24 = r0;
            r24 = r24.mHistoryFileName;	 Catch:{ all -> 0x0159 }
            r23 = r23.append(r24);	 Catch:{ all -> 0x0159 }
            r23 = r23.toString();	 Catch:{ all -> 0x0159 }
            r0 = r22;
            r1 = r23;
            android.util.Log.e(r0, r1, r11);	 Catch:{ all -> 0x0159 }
            if (r5 == 0) goto L_0x0076;
        L_0x0117:
            r5.close();	 Catch:{ IOException -> 0x011c }
            goto L_0x0076;
        L_0x011c:
            r22 = move-exception;
            goto L_0x0076;
        L_0x011f:
            r22 = 0;
            r23 = "activity";
            r0 = r22;
            r1 = r23;
            r4 = r13.getAttributeValue(r0, r1);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r22 = 0;
            r23 = "time";
            r0 = r22;
            r1 = r23;
            r22 = r13.getAttributeValue(r0, r1);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r16 = java.lang.Long.parseLong(r22);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r22 = 0;
            r23 = "weight";
            r0 = r22;
            r1 = r23;
            r22 = r13.getAttributeValue(r0, r1);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r20 = java.lang.Float.parseFloat(r22);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r14 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoricalRecord;	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r0 = r16;
            r2 = r20;
            r14.<init>(r4, r0, r2);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            r15.add(r14);	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            goto L_0x0083;
        L_0x0159:
            r22 = move-exception;
            if (r5 == 0) goto L_0x015f;
        L_0x015c:
            r5.close();	 Catch:{ IOException -> 0x01ad }
        L_0x015f:
            throw r22;
        L_0x0160:
            r7 = r8.get(r10);	 Catch:{ all -> 0x01a7 }
            r7 = (com.actionbarsherlock.widget.ActivityChooserModel.HistoricalRecord) r7;	 Catch:{ all -> 0x01a7 }
            r0 = r19;
            r0.add(r7);	 Catch:{ all -> 0x01a7 }
            r10 = r10 + -1;
            goto L_0x00b1;
        L_0x016f:
            r8.clear();	 Catch:{ all -> 0x01a7 }
            r0 = r19;
            r8.addAll(r0);	 Catch:{ all -> 0x01a7 }
            r0 = r25;
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x01a7 }
            r22 = r0;
            r24 = 1;
            r0 = r22;
            r1 = r24;
            r0.mHistoricalRecordsChanged = r1;	 Catch:{ all -> 0x01a7 }
            r0 = r25;
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x01a7 }
            r22 = r0;
            r22 = r22.mHandler;	 Catch:{ all -> 0x01a7 }
            r24 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoryLoader$1;	 Catch:{ all -> 0x01a7 }
            r24.<init>();	 Catch:{ all -> 0x01a7 }
            r0 = r22;
            r1 = r24;
            r0.post(r1);	 Catch:{ all -> 0x01a7 }
            monitor-exit(r23);	 Catch:{ all -> 0x01a7 }
            if (r5 == 0) goto L_0x0076;
        L_0x019f:
            r5.close();	 Catch:{ IOException -> 0x01a4 }
            goto L_0x0076;
        L_0x01a4:
            r22 = move-exception;
            goto L_0x0076;
        L_0x01a7:
            r22 = move-exception;
            monitor-exit(r23);	 Catch:{ all -> 0x01a7 }
            throw r22;	 Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
        L_0x01aa:
            r22 = move-exception;
            goto L_0x0076;
        L_0x01ad:
            r23 = move-exception;
            goto L_0x015f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.widget.ActivityChooserModel.HistoryLoader.run():void");
        }
    }

    private final class HistoryPersister implements Runnable {
        private HistoryPersister() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r18 = this;
            r3 = 0;
            r10 = 0;
            r0 = r18;
            r13 = com.actionbarsherlock.widget.ActivityChooserModel.this;
            r14 = r13.mInstanceLock;
            monitor-enter(r14);
            r11 = new java.util.ArrayList;	 Catch:{ all -> 0x005c }
            r0 = r18;
            r13 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x005c }
            r13 = r13.mHistoricalRecords;	 Catch:{ all -> 0x005c }
            r11.<init>(r13);	 Catch:{ all -> 0x005c }
            monitor-exit(r14);	 Catch:{ all -> 0x0142 }
            r0 = r18;
            r13 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ FileNotFoundException -> 0x005f }
            r13 = r13.mContext;	 Catch:{ FileNotFoundException -> 0x005f }
            r0 = r18;
            r14 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ FileNotFoundException -> 0x005f }
            r14 = r14.mHistoryFileName;	 Catch:{ FileNotFoundException -> 0x005f }
            r15 = 0;
            r3 = r13.openFileOutput(r14, r15);	 Catch:{ FileNotFoundException -> 0x005f }
            r12 = android.util.Xml.newSerializer();
            r13 = 0;
            r12.setOutput(r3, r13);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r13 = "UTF-8";
            r14 = 1;
            r14 = java.lang.Boolean.valueOf(r14);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r12.startDocument(r13, r14);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r13 = 0;
            r14 = "historical-records";
            r12.startTag(r13, r14);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r9 = r11.size();	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r4 = 0;
        L_0x004b:
            if (r4 < r9) goto L_0x007f;
        L_0x004d:
            r13 = 0;
            r14 = "historical-records";
            r12.endTag(r13, r14);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r12.endDocument();	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            if (r3 == 0) goto L_0x005b;
        L_0x0058:
            r3.close();	 Catch:{ IOException -> 0x013f }
        L_0x005b:
            return;
        L_0x005c:
            r13 = move-exception;
        L_0x005d:
            monitor-exit(r14);	 Catch:{ all -> 0x005c }
            throw r13;
        L_0x005f:
            r2 = move-exception;
            r13 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG;
            r14 = new java.lang.StringBuilder;
            r15 = "Error writing historical recrod file: ";
            r14.<init>(r15);
            r0 = r18;
            r15 = com.actionbarsherlock.widget.ActivityChooserModel.this;
            r15 = r15.mHistoryFileName;
            r14 = r14.append(r15);
            r14 = r14.toString();
            android.util.Log.e(r13, r14, r2);
            goto L_0x005b;
        L_0x007f:
            r13 = 0;
            r8 = r11.remove(r13);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r8 = (com.actionbarsherlock.widget.ActivityChooserModel.HistoricalRecord) r8;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r13 = 0;
            r14 = "historical-record";
            r12.startTag(r13, r14);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r13 = 0;
            r14 = "activity";
            r15 = r8.activity;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r15 = r15.flattenToString();	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r12.attribute(r13, r14, r15);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r13 = 0;
            r14 = "time";
            r0 = r8.time;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r16 = r0;
            r15 = java.lang.String.valueOf(r16);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r12.attribute(r13, r14, r15);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r13 = 0;
            r14 = "weight";
            r15 = r8.weight;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r15 = java.lang.String.valueOf(r15);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r12.attribute(r13, r14, r15);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r13 = 0;
            r14 = "historical-record";
            r12.endTag(r13, r14);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x00e4, IOException -> 0x010d }
            r4 = r4 + 1;
            goto L_0x004b;
        L_0x00bb:
            r5 = move-exception;
            r13 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x0136 }
            r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0136 }
            r15 = "Error writing historical recrod file: ";
            r14.<init>(r15);	 Catch:{ all -> 0x0136 }
            r0 = r18;
            r15 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x0136 }
            r15 = r15.mHistoryFileName;	 Catch:{ all -> 0x0136 }
            r14 = r14.append(r15);	 Catch:{ all -> 0x0136 }
            r14 = r14.toString();	 Catch:{ all -> 0x0136 }
            android.util.Log.e(r13, r14, r5);	 Catch:{ all -> 0x0136 }
            if (r3 == 0) goto L_0x005b;
        L_0x00dc:
            r3.close();	 Catch:{ IOException -> 0x00e1 }
            goto L_0x005b;
        L_0x00e1:
            r13 = move-exception;
            goto L_0x005b;
        L_0x00e4:
            r7 = move-exception;
            r13 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x0136 }
            r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0136 }
            r15 = "Error writing historical recrod file: ";
            r14.<init>(r15);	 Catch:{ all -> 0x0136 }
            r0 = r18;
            r15 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x0136 }
            r15 = r15.mHistoryFileName;	 Catch:{ all -> 0x0136 }
            r14 = r14.append(r15);	 Catch:{ all -> 0x0136 }
            r14 = r14.toString();	 Catch:{ all -> 0x0136 }
            android.util.Log.e(r13, r14, r7);	 Catch:{ all -> 0x0136 }
            if (r3 == 0) goto L_0x005b;
        L_0x0105:
            r3.close();	 Catch:{ IOException -> 0x010a }
            goto L_0x005b;
        L_0x010a:
            r13 = move-exception;
            goto L_0x005b;
        L_0x010d:
            r6 = move-exception;
            r13 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x0136 }
            r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0136 }
            r15 = "Error writing historical recrod file: ";
            r14.<init>(r15);	 Catch:{ all -> 0x0136 }
            r0 = r18;
            r15 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x0136 }
            r15 = r15.mHistoryFileName;	 Catch:{ all -> 0x0136 }
            r14 = r14.append(r15);	 Catch:{ all -> 0x0136 }
            r14 = r14.toString();	 Catch:{ all -> 0x0136 }
            android.util.Log.e(r13, r14, r6);	 Catch:{ all -> 0x0136 }
            if (r3 == 0) goto L_0x005b;
        L_0x012e:
            r3.close();	 Catch:{ IOException -> 0x0133 }
            goto L_0x005b;
        L_0x0133:
            r13 = move-exception;
            goto L_0x005b;
        L_0x0136:
            r13 = move-exception;
            if (r3 == 0) goto L_0x013c;
        L_0x0139:
            r3.close();	 Catch:{ IOException -> 0x013d }
        L_0x013c:
            throw r13;
        L_0x013d:
            r14 = move-exception;
            goto L_0x013c;
        L_0x013f:
            r13 = move-exception;
            goto L_0x005b;
        L_0x0142:
            r13 = move-exception;
            r10 = r11;
            goto L_0x005d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.widget.ActivityChooserModel.HistoryPersister.run():void");
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    private final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<String, ActivityResolveInfo> mPackageNameToActivityMap;

        private DefaultSorter() {
            this.mPackageNameToActivityMap = new HashMap();
        }

        public void sort(Intent intent, List<ActivityResolveInfo> activities, List<HistoricalRecord> historicalRecords) {
            int i;
            Map<String, ActivityResolveInfo> packageNameToActivityMap = this.mPackageNameToActivityMap;
            packageNameToActivityMap.clear();
            int activityCount = activities.size();
            for (i = 0; i < activityCount; i++) {
                ActivityResolveInfo activity = (ActivityResolveInfo) activities.get(i);
                activity.weight = 0.0f;
                packageNameToActivityMap.put(activity.resolveInfo.activityInfo.packageName, activity);
            }
            float nextRecordWeight = 1.0f;
            for (i = historicalRecords.size() - 1; i >= 0; i--) {
                HistoricalRecord historicalRecord = (HistoricalRecord) historicalRecords.get(i);
                activity = (ActivityResolveInfo) packageNameToActivityMap.get(historicalRecord.activity.getPackageName());
                if (activity != null) {
                    activity.weight += historicalRecord.weight * nextRecordWeight;
                    nextRecordWeight *= WEIGHT_DECAY_COEFFICIENT;
                }
            }
            Collections.sort(activities);
        }
    }

    public static ActivityChooserModel get(Context context, String historyFileName) {
        ActivityChooserModel dataModel;
        synchronized (sRegistryLock) {
            dataModel = (ActivityChooserModel) sDataModelRegistry.get(historyFileName);
            if (dataModel == null) {
                dataModel = new ActivityChooserModel(context, historyFileName);
                sDataModelRegistry.put(historyFileName, dataModel);
            }
            dataModel.readHistoricalData();
        }
        return dataModel;
    }

    private ActivityChooserModel(Context context, String historyFileName) {
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(historyFileName) || historyFileName.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = historyFileName;
        } else {
            this.mHistoryFileName = new StringBuilder(String.valueOf(historyFileName)).append(HISTORY_FILE_EXTENSION).toString();
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            loadActivitiesLocked();
        }
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            size = this.mActivites.size();
        }
        return size;
    }

    public ResolveInfo getActivity(int index) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            resolveInfo = ((ActivityResolveInfo) this.mActivites.get(index)).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityIndex(ResolveInfo activity) {
        List<ActivityResolveInfo> activities = this.mActivites;
        int activityCount = activities.size();
        for (int i = 0; i < activityCount; i++) {
            if (((ActivityResolveInfo) activities.get(i)).resolveInfo == activity) {
                return i;
            }
        }
        return -1;
    }

    public Intent chooseActivity(int index) {
        ActivityResolveInfo chosenActivity = (ActivityResolveInfo) this.mActivites.get(index);
        ComponentName chosenName = new ComponentName(chosenActivity.resolveInfo.activityInfo.packageName, chosenActivity.resolveInfo.activityInfo.name);
        Intent choiceIntent = new Intent(this.mIntent);
        choiceIntent.setComponent(chosenName);
        if (this.mActivityChoserModelPolicy != null) {
            if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(choiceIntent))) {
                return null;
            }
        }
        addHisoricalRecord(new HistoricalRecord(chosenName, System.currentTimeMillis(), 1.0f));
        return choiceIntent;
    }

    public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        this.mActivityChoserModelPolicy = listener;
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            if (this.mActivites.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((ActivityResolveInfo) this.mActivites.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public void setDefaultActivity(int index) {
        float weight;
        ActivityResolveInfo newDefaultActivity = (ActivityResolveInfo) this.mActivites.get(index);
        ActivityResolveInfo oldDefaultActivity = (ActivityResolveInfo) this.mActivites.get(0);
        if (oldDefaultActivity != null) {
            weight = (oldDefaultActivity.weight - newDefaultActivity.weight) + 5.0f;
        } else {
            weight = 1.0f;
        }
        addHisoricalRecord(new HistoricalRecord(new ComponentName(newDefaultActivity.resolveInfo.activityInfo.packageName, newDefaultActivity.resolveInfo.activityInfo.name), System.currentTimeMillis(), weight));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readHistoricalData() {
        /*
        r4 = this;
        r1 = r4.mInstanceLock;
        monitor-enter(r1);
        r0 = r4.mCanReadHistoricalData;	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r4.mHistoricalRecordsChanged;	 Catch:{ all -> 0x0028 }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 0;
        r4.mCanReadHistoricalData = r0;	 Catch:{ all -> 0x0028 }
        r0 = 1;
        r4.mReadShareHistoryCalled = r0;	 Catch:{ all -> 0x0028 }
        r0 = r4.mHistoryFileName;	 Catch:{ all -> 0x0028 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0028 }
        if (r0 != 0) goto L_0x0026;
    L_0x001b:
        r0 = SERIAL_EXECUTOR;	 Catch:{ all -> 0x0028 }
        r2 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoryLoader;	 Catch:{ all -> 0x0028 }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x0028 }
        r0.execute(r2);	 Catch:{ all -> 0x0028 }
    L_0x0026:
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        goto L_0x000c;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.widget.ActivityChooserModel.readHistoricalData():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void persistHistoricalData() {
        /*
        r4 = this;
        r1 = r4.mInstanceLock;
        monitor-enter(r1);
        r0 = r4.mReadShareHistoryCalled;	 Catch:{ all -> 0x000f }
        if (r0 != 0) goto L_0x0012;
    L_0x0007:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x000f }
        r2 = "No preceding call to #readHistoricalData";
        r0.<init>(r2);	 Catch:{ all -> 0x000f }
        throw r0;	 Catch:{ all -> 0x000f }
    L_0x000f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000f }
        throw r0;
    L_0x0012:
        r0 = r4.mHistoricalRecordsChanged;	 Catch:{ all -> 0x000f }
        if (r0 != 0) goto L_0x0018;
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x000f }
    L_0x0017:
        return;
    L_0x0018:
        r0 = 0;
        r4.mHistoricalRecordsChanged = r0;	 Catch:{ all -> 0x000f }
        r0 = 1;
        r4.mCanReadHistoricalData = r0;	 Catch:{ all -> 0x000f }
        r0 = r4.mHistoryFileName;	 Catch:{ all -> 0x000f }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x000f }
        if (r0 != 0) goto L_0x0031;
    L_0x0026:
        r0 = SERIAL_EXECUTOR;	 Catch:{ all -> 0x000f }
        r2 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoryPersister;	 Catch:{ all -> 0x000f }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x000f }
        r0.execute(r2);	 Catch:{ all -> 0x000f }
    L_0x0031:
        monitor-exit(r1);	 Catch:{ all -> 0x000f }
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.widget.ActivityChooserModel.persistHistoricalData():void");
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == activitySorter) {
                return;
            }
            this.mActivitySorter = activitySorter;
            sortActivities();
        }
    }

    private void sortActivities() {
        synchronized (this.mInstanceLock) {
            if (!(this.mActivitySorter == null || this.mActivites.isEmpty())) {
                this.mActivitySorter.sort(this.mIntent, this.mActivites, Collections.unmodifiableList(this.mHistoricalRecords));
                notifyChanged();
            }
        }
    }

    public void setHistoryMaxSize(int historyMaxSize) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == historyMaxSize) {
                return;
            }
            this.mHistoryMaxSize = historyMaxSize;
            pruneExcessiveHistoricalRecordsLocked();
            sortActivities();
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.mInstanceLock) {
            i = this.mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        boolean added;
        synchronized (this.mInstanceLock) {
            added = this.mHistoricalRecords.add(historicalRecord);
            if (added) {
                this.mHistoricalRecordsChanged = true;
                pruneExcessiveHistoricalRecordsLocked();
                persistHistoricalData();
                sortActivities();
            }
        }
        return added;
    }

    private void pruneExcessiveHistoricalRecordsLocked() {
        List<HistoricalRecord> choiceRecords = this.mHistoricalRecords;
        int pruneCount = choiceRecords.size() - this.mHistoryMaxSize;
        if (pruneCount > 0) {
            this.mHistoricalRecordsChanged = true;
            for (int i = 0; i < pruneCount; i++) {
                HistoricalRecord historicalRecord = (HistoricalRecord) choiceRecords.remove(0);
            }
        }
    }

    private void loadActivitiesLocked() {
        this.mActivites.clear();
        if (this.mIntent != null) {
            List<ResolveInfo> resolveInfos = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
            int resolveInfoCount = resolveInfos.size();
            for (int i = 0; i < resolveInfoCount; i++) {
                this.mActivites.add(new ActivityResolveInfo((ResolveInfo) resolveInfos.get(i)));
            }
            sortActivities();
            return;
        }
        notifyChanged();
    }
}
