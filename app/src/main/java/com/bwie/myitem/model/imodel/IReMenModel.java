package com.bwie.myitem.model.imodel;

import com.bwie.library.mvp.ibase.IBaseModel;
import com.bwie.myitem.model.listener.OnGetHotListener;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public interface IReMenModel extends IBaseModel {

    void getData(OnGetHotListener listener);
}
