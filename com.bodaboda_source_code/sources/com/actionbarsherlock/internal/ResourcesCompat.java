package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.actionbarsherlock.C0055R;

public final class ResourcesCompat {
    private static final String TAG = "ResourcesCompat";

    private ResourcesCompat() {
    }

    public static boolean getResources_getBoolean(Context context, int id) {
        if (VERSION.SDK_INT >= 14) {
            return context.getResources().getBoolean(id);
        }
        float smallestWidthDp;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float widthDp = ((float) metrics.widthPixels) / metrics.density;
        float heightDp = ((float) metrics.heightPixels) / metrics.density;
        if (widthDp < heightDp) {
            smallestWidthDp = widthDp;
        } else {
            smallestWidthDp = heightDp;
        }
        if (id == C0055R.bool.abs__action_bar_embed_tabs) {
            if (widthDp < 480.0f) {
                return false;
            }
            return true;
        } else if (id == C0055R.bool.abs__split_action_bar_is_narrow) {
            if (widthDp >= 480.0f) {
                return false;
            }
            return true;
        } else if (id == C0055R.bool.abs__action_bar_expanded_action_views_exclusive) {
            if (smallestWidthDp >= 600.0f) {
                return false;
            }
            return true;
        } else if (id != C0055R.bool.abs__config_allowActionMenuItemTextWithIcon) {
            throw new IllegalArgumentException("Unknown boolean resource ID " + id);
        } else if (widthDp < 480.0f) {
            return false;
        } else {
            return true;
        }
    }

    public static int getResources_getInteger(Context context, int id) {
        if (VERSION.SDK_INT >= 13) {
            return context.getResources().getInteger(id);
        }
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float widthDp = ((float) metrics.widthPixels) / metrics.density;
        if (id != C0055R.integer.abs__max_action_buttons) {
            throw new IllegalArgumentException("Unknown integer resource ID " + id);
        } else if (widthDp >= 600.0f) {
            return 5;
        } else {
            if (widthDp >= 500.0f) {
                return 4;
            }
            if (widthDp >= 360.0f) {
                return 3;
            }
            return 2;
        }
    }

    public static int loadLogoFromManifest(Activity activity) {
        int logo = 0;
        try {
            String thisPackage = activity.getClass().getName();
            String packageName = activity.getApplicationInfo().packageName;
            XmlResourceParser xml = activity.createPackageContext(packageName, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.nextToken()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    int i;
                    if ("application".equals(name)) {
                        for (i = xml.getAttributeCount() - 1; i >= 0; i--) {
                            if ("logo".equals(xml.getAttributeName(i))) {
                                logo = xml.getAttributeResourceValue(i, 0);
                                break;
                            }
                        }
                    } else if ("activity".equals(name)) {
                        Integer activityLogo = null;
                        String activityPackage = null;
                        boolean isOurActivity = false;
                        for (i = xml.getAttributeCount() - 1; i >= 0; i--) {
                            String attrName = xml.getAttributeName(i);
                            if (!"logo".equals(attrName)) {
                                if ("name".equals(attrName)) {
                                    activityPackage = ActionBarSherlockCompat.cleanActivityName(packageName, xml.getAttributeValue(i));
                                    if (!thisPackage.equals(activityPackage)) {
                                        break;
                                    }
                                    isOurActivity = true;
                                }
                            } else {
                                activityLogo = Integer.valueOf(xml.getAttributeResourceValue(i, 0));
                            }
                            if (!(activityLogo == null || activityPackage == null)) {
                                logo = activityLogo.intValue();
                            }
                        }
                        if (isOurActivity) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logo;
    }
}
