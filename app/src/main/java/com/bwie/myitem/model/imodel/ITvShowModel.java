package com.bwie.myitem.model.imodel;

import com.bwie.library.mvp.ibase.IBaseModel;
import com.bwie.myitem.model.listener.OnGetDataShow;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/12.
 */

public interface ITvShowModel extends IBaseModel{
    void getDataShow(OnGetDataShow dataShow,String uid);
}
