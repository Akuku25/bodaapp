package com.actionbarsherlock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import com.actionbarsherlock.C0055R;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MenuInflater {
    private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class};
    private static final String LOG_TAG = "MenuInflater";
    private static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    private final Object[] mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    private final Object[] mActionViewConstructorArguments;
    private Context mContext;
    private Object mRealOwner;

    private class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        private ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private boolean itemEnabled;
        private int itemIconResId;
        private int itemId;
        private String itemListenerMethodName;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private boolean itemVisible;
        private Menu menu;

        public MenuState(Menu menu) {
            this.menu = menu;
            resetGroup();
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }

        public void readGroup(AttributeSet attrs) {
            TypedArray a = MenuInflater.this.mContext.obtainStyledAttributes(attrs, C0055R.styleable.SherlockMenuGroup);
            this.groupId = a.getResourceId(C0055R.styleable.SherlockMenuGroup_android_id, 0);
            this.groupCategory = a.getInt(C0055R.styleable.SherlockMenuGroup_android_menuCategory, 0);
            this.groupOrder = a.getInt(C0055R.styleable.SherlockMenuGroup_android_orderInCategory, 0);
            this.groupCheckable = a.getInt(C0055R.styleable.SherlockMenuGroup_android_checkableBehavior, 0);
            this.groupVisible = a.getBoolean(C0055R.styleable.SherlockMenuGroup_android_visible, true);
            this.groupEnabled = a.getBoolean(C0055R.styleable.SherlockMenuGroup_android_enabled, true);
            a.recycle();
        }

        public void readItem(AttributeSet attrs) {
            String charSequence;
            boolean hasActionProvider;
            TypedArray a = MenuInflater.this.mContext.obtainStyledAttributes(attrs, C0055R.styleable.SherlockMenuItem);
            this.itemId = a.getResourceId(C0055R.styleable.SherlockMenuItem_android_id, 0);
            this.itemCategoryOrder = (-65536 & a.getInt(C0055R.styleable.SherlockMenuItem_android_menuCategory, this.groupCategory)) | (65535 & a.getInt(C0055R.styleable.SherlockMenuItem_android_orderInCategory, this.groupOrder));
            this.itemTitle = a.getText(C0055R.styleable.SherlockMenuItem_android_title);
            this.itemTitleCondensed = a.getText(C0055R.styleable.SherlockMenuItem_android_titleCondensed);
            this.itemIconResId = a.getResourceId(C0055R.styleable.SherlockMenuItem_android_icon, 0);
            this.itemAlphabeticShortcut = getShortcut(a.getString(C0055R.styleable.SherlockMenuItem_android_alphabeticShortcut));
            this.itemNumericShortcut = getShortcut(a.getString(C0055R.styleable.SherlockMenuItem_android_numericShortcut));
            if (a.hasValue(C0055R.styleable.SherlockMenuItem_android_checkable)) {
                int i;
                if (a.getBoolean(C0055R.styleable.SherlockMenuItem_android_checkable, false)) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.itemCheckable = i;
            } else {
                this.itemCheckable = this.groupCheckable;
            }
            this.itemChecked = a.getBoolean(C0055R.styleable.SherlockMenuItem_android_checked, false);
            this.itemVisible = a.getBoolean(C0055R.styleable.SherlockMenuItem_android_visible, this.groupVisible);
            this.itemEnabled = a.getBoolean(C0055R.styleable.SherlockMenuItem_android_enabled, this.groupEnabled);
            TypedValue value = new TypedValue();
            a.getValue(C0055R.styleable.SherlockMenuItem_android_showAsAction, value);
            this.itemShowAsAction = value.type == 17 ? value.data : -1;
            this.itemListenerMethodName = a.getString(C0055R.styleable.SherlockMenuItem_android_onClick);
            this.itemActionViewLayout = a.getResourceId(C0055R.styleable.SherlockMenuItem_android_actionLayout, 0);
            value = new TypedValue();
            a.getValue(C0055R.styleable.SherlockMenuItem_android_actionViewClass, value);
            if (value.type == 3) {
                charSequence = value.string.toString();
            } else {
                charSequence = null;
            }
            this.itemActionViewClassName = charSequence;
            value = new TypedValue();
            a.getValue(C0055R.styleable.SherlockMenuItem_android_actionProviderClass, value);
            if (value.type == 3) {
                charSequence = value.string.toString();
            } else {
                charSequence = null;
            }
            this.itemActionProviderClassName = charSequence;
            if (this.itemActionProviderClassName != null) {
                hasActionProvider = true;
            } else {
                hasActionProvider = false;
            }
            if (hasActionProvider && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
                this.itemActionProvider = (ActionProvider) newInstance(this.itemActionProviderClassName, MenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionProviderConstructorArguments);
            } else {
                if (hasActionProvider) {
                    Log.w(MenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.itemActionProvider = null;
            }
            a.recycle();
            this.itemAdded = false;
        }

        private char getShortcut(String shortcutString) {
            if (shortcutString == null) {
                return '\u0000';
            }
            return shortcutString.charAt(0);
        }

        private void setItem(MenuItem item) {
            item.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
            if (this.itemShowAsAction >= 0) {
                item.setShowAsAction(this.itemShowAsAction);
            }
            if (this.itemListenerMethodName != null) {
                if (MenuInflater.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                item.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(MenuInflater.this.mRealOwner, this.itemListenerMethodName));
            }
            if (this.itemCheckable >= 2) {
                if (item instanceof MenuItemImpl) {
                    ((MenuItemImpl) item).setExclusiveCheckable(true);
                } else {
                    this.menu.setGroupCheckable(this.groupId, true, true);
                }
            }
            boolean actionViewSpecified = false;
            if (this.itemActionViewClassName != null) {
                item.setActionView((View) newInstance(this.itemActionViewClassName, MenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionViewConstructorArguments));
                actionViewSpecified = true;
            }
            if (this.itemActionViewLayout > 0) {
                if (actionViewSpecified) {
                    Log.w(MenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    item.setActionView(this.itemActionViewLayout);
                }
            }
            if (this.itemActionProvider != null) {
                item.setActionProvider(this.itemActionProvider);
            }
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu subMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(subMenu.getItem());
            return subMenu;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        private <T> T newInstance(String className, Class<?>[] constructorSignature, Object[] arguments) {
            try {
                return MenuInflater.this.mContext.getClassLoader().loadClass(className).getConstructor(constructorSignature).newInstance(arguments);
            } catch (Exception e) {
                Log.w(MenuInflater.LOG_TAG, "Cannot instantiate class: " + className, e);
                return null;
            }
        }
    }

    private static class InflatedOnMenuItemClickListener implements OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = new Class[]{MenuItem.class};
        private Method mMethod;
        private Object mRealOwner;

        public InflatedOnMenuItemClickListener(Object realOwner, String methodName) {
            this.mRealOwner = realOwner;
            Class<?> c = realOwner.getClass();
            try {
                this.mMethod = c.getMethod(methodName, PARAM_TYPES);
            } catch (Exception e) {
                InflateException ex = new InflateException("Couldn't resolve menu item onClick handler " + methodName + " in class " + c.getName());
                ex.initCause(e);
                throw ex;
            }
        }

        public boolean onMenuItemClick(MenuItem item) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.mRealOwner, new Object[]{item})).booleanValue();
                }
                this.mMethod.invoke(this.mRealOwner, new Object[]{item});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public MenuInflater(Context context) {
        this.mContext = context;
        this.mRealOwner = context;
        this.mActionViewConstructorArguments = new Object[]{context};
    }

    public MenuInflater(Context context, Object realOwner) {
        this.mContext = context;
        this.mRealOwner = realOwner;
        this.mActionViewConstructorArguments = new Object[]{context};
    }

    public void inflate(int menuRes, Menu menu) {
        XmlResourceParser parser = null;
        try {
            parser = this.mContext.getResources().getLayout(menuRes);
            parseMenu(parser, Xml.asAttributeSet(parser), menu);
            if (parser != null) {
                parser.close();
            }
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
        }
    }

    private void parseMenu(XmlPullParser parser, AttributeSet attrs, Menu menu) throws XmlPullParserException, IOException {
        MenuState menuState = new MenuState(menu);
        int eventType = parser.getEventType();
        boolean lookingForEndOfUnknownTag = false;
        String unknownTagName = null;
        while (eventType != 2) {
            eventType = parser.next();
            if (eventType == 1) {
                break;
            }
        }
        String tagName = parser.getName();
        if (tagName.equals(XML_MENU)) {
            eventType = parser.next();
            boolean z = false;
            while (!z) {
                switch (eventType) {
                    case 1:
                        throw new RuntimeException("Unexpected end of document");
                    case 2:
                        if (!lookingForEndOfUnknownTag) {
                            tagName = parser.getName();
                            if (!tagName.equals(XML_GROUP)) {
                                if (!tagName.equals(XML_ITEM)) {
                                    if (!tagName.equals(XML_MENU)) {
                                        lookingForEndOfUnknownTag = true;
                                        unknownTagName = tagName;
                                        break;
                                    }
                                    parseMenu(parser, attrs, menuState.addSubMenuItem());
                                    break;
                                }
                                menuState.readItem(attrs);
                                break;
                            }
                            menuState.readGroup(attrs);
                            break;
                        }
                        break;
                    case 3:
                        tagName = parser.getName();
                        if (!lookingForEndOfUnknownTag || !tagName.equals(unknownTagName)) {
                            if (!tagName.equals(XML_GROUP)) {
                                if (!tagName.equals(XML_ITEM)) {
                                    if (!tagName.equals(XML_MENU)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                                } else if (!menuState.hasAddedItem()) {
                                    if (menuState.itemActionProvider != null && menuState.itemActionProvider.hasSubMenu()) {
                                        menuState.addSubMenuItem();
                                        break;
                                    } else {
                                        menuState.addItem();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            menuState.resetGroup();
                            break;
                        }
                        lookingForEndOfUnknownTag = false;
                        unknownTagName = null;
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
            return;
        }
        throw new RuntimeException("Expecting menu, got " + tagName);
    }
}
