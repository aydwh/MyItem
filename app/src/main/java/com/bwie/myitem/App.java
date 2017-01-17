package com.bwie.myitem;

import android.support.v7.app.AppCompatDelegate;

import com.bwie.library.utils.AppApplication;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/10.
 */

public class App extends AppApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
