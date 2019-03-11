package com.bodaboda.custom_adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.actionbarsherlock.app.SherlockFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    public SherlockFragment fragment;
    public SherlockFragment fragment1;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public SherlockFragment getItem(int position) {
        switch (position) {
            case 0:
                return this.fragment1;
            case 1:
                return this.fragment;
            default:
                return null;
        }
    }

    public int getCount() {
        return 2;
    }
}
