package com.bodaboda;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.bodaboda.custom_adapters.ViewPagerAdapter;

public class Passager_Login_SignUp extends SherlockFragmentActivity {
    ActionBar mActionBar;
    ViewPager mPager;
    Tab tab;

    /* renamed from: com.bodaboda.Passager_Login_SignUp$2 */
    class C02952 implements TabListener {
        C02952() {
        }

        public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        }

        public void onTabSelected(Tab tab, FragmentTransaction ft) {
            Passager_Login_SignUp.this.mPager.setCurrentItem(tab.getPosition());
        }

        public void onTabReselected(Tab tab, FragmentTransaction ft) {
        }
    }

    /* renamed from: com.bodaboda.Passager_Login_SignUp$1 */
    class C04151 extends SimpleOnPageChangeListener {
        C04151() {
        }

        public void onPageSelected(int position) {
            super.onPageSelected(position);
            Passager_Login_SignUp.this.mActionBar.setSelectedNavigationItem(position);
        }
    }

    protected void onCreate(Bundle savedIntance) {
        super.onCreate(savedIntance);
        setContentView((int) C0096R.layout.pager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.mActionBar = getSupportActionBar();
        this.mActionBar.setNavigationMode(2);
        this.mPager = (ViewPager) findViewById(C0096R.id.pager);
        FragmentManager fm = getSupportFragmentManager();
        this.mPager.setOnPageChangeListener(new C04151());
        ViewPagerAdapter viewPageAdapter = new ViewPagerAdapter(fm);
        viewPageAdapter.fragment1 = new Passager_Login_Fragment();
        viewPageAdapter.fragment = new Passager_Signup_Fragment();
        this.mPager.setAdapter(viewPageAdapter);
        this.mPager.setAdapter(viewPageAdapter);
        TabListener tabListener = new C02952();
        for (CharSequence tabTitle : new String[]{"Sign In", "Sign Up"}) {
            this.mActionBar.addTab(this.mActionBar.newTab().setText(tabTitle).setTabListener(tabListener));
        }
    }
}
