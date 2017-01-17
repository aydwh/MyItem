package com.bwie.myitem.model.imodel;

import com.bwie.library.mvp.ibase.IBaseModel;
import com.bwie.myitem.model.listener.OnGetDataOther;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public interface IOtherModel extends IBaseModel {
    void getDate1(OnGetDataOther dataOther,String name);
}
