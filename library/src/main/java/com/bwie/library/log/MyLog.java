package com.bwie.library.log;

import com.socks.library.KLog;

/**
 * 1.日志控制管理
 * 2.@author:weihuanhuan
 * 3.@ 2016/12/28.
 */

public class MyLog implements IMyLog{

    @Override
    public void v(Object object) {
        KLog.v(object);
    }

    @Override
    public void d(Object object) {
        KLog.d(object);
    }

    @Override
    public void i(Object object) {
        KLog.i(object);
    }

    @Override
    public void w(Object object) {
        KLog.w(object);
    }

    @Override
    public void e(Object object) {
        KLog.e(object);
    }

    @Override
    public void json(String object) {
        KLog.json(object);
    }


}
