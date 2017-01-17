package com.bwie.myitem.model.imodel;

import com.bwie.library.mvp.ibase.IBaseModel;
import com.bwie.myitem.model.listener.OnGettvMainListener;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/8.
 */

public interface ITvMainModel extends IBaseModel {
    void getDate(OnGettvMainListener listener);
}
