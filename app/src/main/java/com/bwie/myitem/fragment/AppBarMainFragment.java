package com.bwie.myitem.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.library.mvp.BaseFragment;
import com.bwie.myitem.R;
import com.bwie.myitem.fragment.child.ReMenFragment;
import com.bwie.myitem.fragment.child.RiBaoFragment;
import com.bwie.myitem.fragment.child.WeChatFragment;
import com.bwie.myitem.fragment.child.ZhuanLanFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/2.
 */

public class AppBarMainFragment extends BaseFragment {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    List<Fragment> fragments = new ArrayList<>();
    String[] mTabs = {"日报", "专栏", "微信", "热门"};

    @Override
    public int bindLayout() {
        return R.layout.app_bar_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        toolbar.setTitle("首页");
//        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.inflateMenu(R.menu.fragment_main_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.day:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        getActivity().recreate();
                        break;
                    case R.id.night:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        getActivity().recreate();
                        break;
                }
                return true;
            }
        });
        showTab(mTabs);
    }




    public void showTab(String [] mTabs) {
        for (int i=0;i<mTabs.length;i++){
            tabs.addTab(tabs.newTab().setText(mTabs[i]));
                switch (i){
                case 0:
                    fragments.add(new RiBaoFragment());
                     break;
                case 1:
                    fragments.add(new ZhuanLanFragment());
                    break;
                case 2:
                    fragments.add(new WeChatFragment());
                    break;
                case 3:
                    fragments.add(new ReMenFragment());
                    break;
            }
        }
        viewpager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments));
        tabs.setupWithViewPager(viewpager);
        for (int i = 0; i < mTabs.length; i++) {
            tabs.getTabAt(i).setText(mTabs[i]);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
