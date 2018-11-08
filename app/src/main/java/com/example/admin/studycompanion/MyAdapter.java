package com.example.admin.studycompanion;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return new BroadcastFragment();
            case 1:
                return new DiscussionFragment();
            case 2:
                return new MatesFragment();
            default:
                return new BroadcastFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //TODO
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
