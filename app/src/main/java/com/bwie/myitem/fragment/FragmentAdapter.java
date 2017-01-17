package com.bwie.myitem.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    public FragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;

    }

    @Override
    public void destroyItem(View container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
