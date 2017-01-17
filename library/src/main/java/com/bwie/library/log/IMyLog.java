package com.bwie.library.log;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2016/12/28.
 */

public interface IMyLog {
    void v(Object object);

    void d(Object object);

    void i(Object object);

    void w(Object object);

    void e(Object object);

    void json(String object);
}
